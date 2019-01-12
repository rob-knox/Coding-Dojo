const express = require('express'),
    app = express(),
    mongoose = require('mongoose'),
    bodyParser = require('body-parser');

app.use(bodyParser.json());
app.use(express.static(__dirname + '/public/dist/public'));

mongoose.connect('mongodb://localhost/product_manager');

require('./server/config/mongoose.js');
require('./server/models/product.js');
require('./server/config/routes.js')(app);


app.listen(8000, function() {
    console.log('Listening on port 8000.');
});