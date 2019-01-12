var express = require('express');
var app = express();

app.use(express.static(__dirname + '/static'));

app.get('/', function(req, res) {
    res.render('index.html');
});
app.get('/dogs.html', function(req, res) {
    res.render('dogs.html');
});
app.get('/form.html', function(req, res) {
    res.render('form.html');
});

app.listen(8000, function() {
    console.log("Listening on port 8000");
});