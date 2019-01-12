var express = require('express'); 
var app = express();
var bodyParser = require('body-parser');
var mongoose= require('mongoose');

app.use(bodyParser.json());
app.use(express.static(__dirname + '/public/dist/public'));
app.set('views',__dirname+'/views');
app.set('view engine', 'ejs');

mongoose.connect('mongodb://localhost/restfulAPI');

//reference to mongoose.js
require('./server/config/mongoose.js');

//reference to routes.js
var routes=require('./server/config/routes.js');
routes(app);

app.listen(8000, function() {
    console.log("listening on port 8000");
})