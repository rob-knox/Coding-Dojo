const express = require('express'),
    app = express(),
    mongoose = require('mongoose'),
    bodyParser = require('body-parser');

app.use(bodyParser.json());
app.use(express.static(__dirname + '/public/dist/public'));

// change this to your new database name
mongoose.connect('mongodb://localhost/commerce');

require('./server/config/mongoose.js');
require('./server/models/product.js');
require('./server/config/routes.js')(app);

app.listen(8000, function() {
    console.log('Listening on port 8000.');
});