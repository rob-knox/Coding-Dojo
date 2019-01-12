var express = require('express');
var app = express();

app.use(express.static(__dirname + "/static"));
app.set('views', __dirname + '/views');
app.set('view engine', 'ejs');

app.get('/users', function(req, res) {
    var users_array = [
        {name: "Rob", email: "rob@gmail.com"},
        {name: "Erika", email: "erika@gmail.com"},
        {name: "Abraham", email: "abraham@gmail.com"},
        {name: "Nattaly", email: "nattaly@gmail.com"},
        {name: "Jacob", email: "jacob@gmail.com"}
    ];
    res.render('users', {users: users_array});
});

app.get('/', function(req, res) {
    res.send('Hello Express');
});

app.listen(8000, function() {
    console.log("Listening on port 8000");
});