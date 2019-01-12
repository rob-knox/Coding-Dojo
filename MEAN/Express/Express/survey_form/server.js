var express  = require("express");
var app = express();

app.use(express.static(__dirname + "/static"));

app.set('views', __dirname + "/views");
app.set('view engine', 'ejs');

var bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({extended: true}));

app.get('/', function(req, res) {
    res.render('index');
});
app.post('/process', function(req, res) {
    console.log(req.body);
    data = req.body;
    res.render('result', {data:data});
});

app.listen(8000, function() {
    console.log("Listining on port 8000");
});