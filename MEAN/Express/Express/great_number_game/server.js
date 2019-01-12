var express = require('express');
var app = express();
var bodyParser = require('body-parser');
var path = require('path');
var session = require('express-session');

app.use(session ({
    secret: 'keyboardkitteh',
    resave: false,
    saveUninitialized: true,
    cookie: { maxAge: 60000 }
}))
app.use(bodyParser.urlencoded({extended: true}));
app.use(express.static(path.join(__dirname, './static')));
app.set('views', path.join(__dirname, './views'));
app.set('view engine', 'ejs');

app.get('/', function(req, res) {
    var randomNum = parseInt(Math.random(1) * 100);
    if (req.session.randomNum == undefined) {
        req.session.randomNum = Math.floor(Math.random() * 100);
    }
    context = {
        answer : req.session.randomNum,
        guess : req.session.guess
    }
    console.log(req.session.randomNum);
    res.render('index', context);
});
app.post('/process', function(req, res) {
    req.session.guess = req.body.guess;
    console.log(req.body);
    res.redirect('/');
});
app.get('/reset', function(req, res) {
    req.session.destroy();
    res.redirect('/');
});
app.listen(8000, function() {
    console.log('Listening on port 8000.');
});