var express = require('express');
var app = express();
var bodyParser = require('body-parser');
var path = require('path');
var mongoose = require('mongoose');

app.use(bodyParser.urlencoded({extended: true}));
app.use(express.static(path.join(__dirname, './static')));

app.set('views', path.join(__dirname, './views'));
app.set('view engine', 'ejs');

mongoose.connect('mongodb://localhost/quotingDojo');
var QuoteSchema = new mongoose.Schema({
    name: {type: String, required: true, minlength: 6},
    quote: {type: String, required: true, minlength: 10}
}, {timestamps: true});
var Quote = mongoose.model('Quote', QuoteSchema);

mongoose.Promise = global.Promise;

app.get('/', function(req, res) {
    res.render('index');
}); 
app.post('/quotes', function(req, res) {
    var quote = new Quote({name: req.body.name, quote: req.body.quote});
    quote.save(function(err) {
        if (err) {
            console.log(err);
            console.log('Something went wrong.');
        } else {
            console.log('Successfully added a quote!');
        }
    })
    res.redirect('/');
});
app.get('/quotes', function(req, res) {
    Quote.find({}, function(err, quotes) {
        if (err) {console.log(err);}
        res.render('quotes', {quotes: quotes});
    });
});

app.listen(8000, function() {
    console.log("Listening on port 8000");
});