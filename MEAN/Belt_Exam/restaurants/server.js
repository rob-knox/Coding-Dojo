const express = require('express'),
    app = express(),
    mongoose = require('mongoose'),
    bodyParser = require('body-parser'),
    path = require('path');

app.use(bodyParser.json());
app.use(express.static(__dirname + '/public/dist/public'));

// change this to your new database name
mongoose.connect('mongodb://localhost/restaurants');

require('./server/config/mongoose.js');
require('./server/models/restaurant.js');
require('./server/config/routes.js')(app);

// this is the catch all function, which redirects to the root page
app.all("*", (req,res,next) => {
    res.sendFile(path.resolve("./public/dist/public/index.html"));
});

app.listen(8000, function() {
    console.log('Listening on port 8000.');
});