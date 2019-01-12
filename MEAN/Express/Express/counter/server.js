var express = require('express');
var path = require('path');
var bodyParser = require('body-parser');
var session = require('express-session');
var app = express();

app.use(session({
    secret: 'keyboardkitteh',
    resave: false,
    saveUninitialized: true,
    cookie: {maxAge: 60000}
}));
app.use(bodyParser.urlencoded({extended: true}));
app.use(express.static(path.join(__dirname, './static')));
app.set('views', path.join(__dirname, './views'));
app.set('view engine', 'ejs');

app.get('/', function(req, res) {
    if (req.session.counter == undefined) {
        req.session.counter = 0;
    } else {
        req.session.counter += 1;
    }
    res.render('index', {counter:req.session.counter});
});
app.get('/plusTwo', function(req, res) {
    req.session.counter += 1;
    res.redirect('/');
});
app.get('/reset', function(req, res) {
    req.session.destroy();
    res.redirect('/');
});
app.listen(8000, function() {
    console.log('Listening on port 8000');
});