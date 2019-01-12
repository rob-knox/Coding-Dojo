const express = require('express'),
    app = express(),
    bodyParser = require('body-parser'),
    mongoose = require('mongoose');

app.use(bodyParser.json());

mongoose.connect('mongodb://localhost/mongooseDashboard');

require('./server/config/mongoose.js');
require('./server/models/models.js');
require('./server/config/routes.js')(app);

app.listen(8000, function() {
    console.log("Listening on port 8000.");
});