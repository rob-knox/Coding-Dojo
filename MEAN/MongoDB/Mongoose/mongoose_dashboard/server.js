var express = require('express');
var app = express();
var bodyParser = require('body-parser');
var mongoose = require('mongoose');
var path = require('path');

app.use(bodyParser.urlencoded({extended:true}));
app.use(express.static(path.join(__dirname, './static')));

app.set('views', path.join(__dirname, './views'));
app.set('view engine', 'ejs');

mongoose.connect('mongodb://localhost/mongooseDashboard');
var AnimalSchema = new mongoose.Schema({
    name: {type: String, required: true, minLength: 3},
    color: {type: String, required: true, minLength: 3},
    favorite_snack: {type: String, required: true, minLength: 3},
    age: {type: Number, required: true}
}, {timestamps: true});
var Animal = mongoose.model('Animal', AnimalSchema);
mongoose.Promise = global.Promise;

app.get('/', function(req, res) {
    Animal.find({}, function(err, animal) {
        if (err) { console.log(err); }
        res.render('index', {animal: animal});
    });
});
app.get('/new', function(req, res) {
    res.render('new');
});
app.post('/addnew', function(req, res) {
    var animal = new Animal({name: req.body.name, color: req.body.color, favorite_snack: req.body.favorite_snack, age: req.body.age});
    animal.save(function(err) {
        if (err) {
            console.log(err);
            console.log('Something went wrong.');
        } else {
            console.log('Successfully added an animal!');
            console.log(req.body);
        }
    });
    res.redirect('/');
});
app.get('/animal/:id', function(req, res) {
    Animal.findOne({_id: req.params.id}, function(err, animal) {
        if (err) {console.log(err);}
        res.render('animal', {animal: animal})
    })
});
app.get('/delete/:id', function(req, res) {
    Animal.remove({_id: req.params.id}, function(err, animal) {
        if (err) {console.log(err);}
        res.redirect('/');
    });
})
app.get('/edit/:id', function(req, res) {
    Animal.findOne({_id: req.params.id}, function(err, animal) {
        if (err) {console.log(err);}
        res.render('edit', {animal:animal});
    });
    
});
app.post('/edit/:id', function(req, res) {
    Animal.update({_id: req.params.id}, req.body, function(err, animal) {
        if (err) {console.log(err);}
        res.redirect('/');
    });
});

app.listen(8000, function() {
    console.log('Listening on port 8000');
});