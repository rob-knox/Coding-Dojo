var express = require('express');
var app = express();
var bodyParser = require('body-parser');
var mongoose = require('mongoose');
var path = require('path');
var Schema = mongoose.Schema;

app.use(bodyParser.urlencoded({extended: true}));
app.use(express.static(path.join(__dirname, './static')));

app.set('views', path.join(__dirname, './views'));
app.set('view engine', 'ejs');

mongoose.connect('mongodb://localhost/messageBoard');
var MessageSchema = new mongoose.Schema({
    name: {type: String, required: true, minLength: 3},
    message: {type: String, required: true, minLength: 10},
    _comments: [{type: Schema.Types.ObjectId, ref: 'Comment'}]
}, {timestamps: true});

var CommentSchema = new mongoose.Schema({
    name: {type: String, required: true, minLength: 3},
    comment: {type: String, required: true, minLength: 10},
    _message: [{type: Schema.Types.ObjectId, ref: 'Message'}]
}, {timestamps: true});

var Message = mongoose.model('Message', MessageSchema);
var Comment = mongoose.model('Comment', CommentSchema);
mongoose.Promise = global.Promise;

app.get('/', function(req, res) {
    Message.find({}).populate("_comments").exec(function(err, data) {
        if (err) {console.log(err);}
        // var context = {
        //     message: message,
        //     comment: comment
        // }
        res.render('index', {message:data});
    });
});
app.post('/newMessage', function(req, res) {
    var message = new Message({name: req.body.name, message: req.body.message});
    message.save(function(err) {
        if (err) {
            console.log(err);
            console.log("Something went terribly wrong.");
        } else {
            console.log("You added a message!");
        }
    });
    res.redirect('/')
});
app.post('/newComment/:id', function(req, res) {
    Message.findOne({_id: req.params.id}, function(err, message) {
        var comment = new Comment({
            name: req.body.name,
            comment: req.body.comment,
            _message: message._id
        });
        
        comment.save(function(err) {
            message._comments.push(comment);
            message.save(function(err) {
                if (err) {
                    console.log(err);
                    console.log("Something went terribly wrong.");
                    res.redirect('/');
                } else {
                    console.log("You added a message!");
                    res.redirect('/');
                }
            });
        });
    });
});

app.listen(8000, function() {
    console.log("Listening on port 8000");
});