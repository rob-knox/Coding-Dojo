var express = require('express');
var app = express();

app.use(express.static(__dirname + '/static'));
app.set('views', __dirname + '/views');
app.set('view engine', 'ejs');

app.get('/', function(req, res) {
    res.render('index.html');
});
app.get('/cars', function(req, res) {
    res.render('cars.ejs');
});
app.get('/dogs', function(req, res) {
    res.render('dogs.ejs');
});
app.get('/cars/new', function(req, res) {
    res.render('new.ejs');
});
app.listen(8000, function() {
    console.log("Listening on port 8000");
});