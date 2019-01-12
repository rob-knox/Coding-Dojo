const mongoose = require('mongoose'),
    people = require('./../controllers/controllers.js');

module.exports = function(app) {

    app.get('/', function(req, res) {
        people.index(req, res);
    });
    app.get('/new/:name', function(req, res) {
        people.new(req, res);
    });
    app.get('/remove/:name', function(req, res) {
        people.remove(req, res);
    });
    app.get('/:name', function(req, res) {
        people.read(req, res);
    });

}