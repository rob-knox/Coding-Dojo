var express = require('express');
var app = express();

app.use(express.static(__dirname + '/static'));
app.set('views', __dirname + '/views');
app.set('view engine', 'ejs');

app.get('/', function(req, res) {
    res.render('index.html');
});

var dogs_array = [
    {name: "Barley", favoriteFood: "People Food", age: 5, sleepingSpots: "Couch, Bed", picture: "images/australian_shepherd.jpg"},
    {name: "Fluffy", favoriteFood: "Meatballs", age: 3, sleepingSpots: "Floor, Couch", picture: "images/chow_chow.jpeg"},
    {name: "Puppy", favoriteFood: "Anything", age: 1, sleepingSpots: "Floor, Couch", picture: "images/corgi.jpg"},
    {name: "Yeller", favoriteFood: "Steak", age: 12, sleepingSpots: "Floor, Couch", picture: "images/golden_retriever.jpeg"},
    {name: "George", favoriteFood: "Lots of stuff", age: 1, sleepingSpots: "Couch", picture: "images/labrador.jpeg"},
    {name: "Gorgeous", favoriteFood: "Slippers", age: 1, sleepingSpots: "Floor, Couch", picture: "images/siberian_husky.jpg"}
]

app.get('/dogs', function(req, res) {
    res.render('dogs.ejs', {dog: dogs_array});
});
app.get('/:name', function(req, res) {
    if (req.params.name == 'Barley') {
        res.render('details.ejs', {dog: dogs_array[0]});
    } else if (req.params.name == 'Fluffy') {
        res.render('details.ejs', {dog: dogs_array[1]});
    } else if (req.params.name == 'Puppy') {
        res.render('details.ejs', {dog: dogs_array[2]});
    } else if (req.params.name == 'Yeller') {
        res.render('details.ejs', {dog: dogs_array[3]});
    } else if (req.params.name == 'George') {
        res.render('details.ejs', {dog: dogs_array[4]});
    } else if (req.params.name == 'Gorgeous') {
        res.render('details.ejs', {dog: dogs_array[5]});
    }
});
app.listen(8000, function() {
    console.log('Listening on port 8000');
});