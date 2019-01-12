const cakes = require('../controllers/cakes.js');

module.exports = function(app) {
    app.post('/cakes', cakes.create);
    app.get('/cakes', cakes.index);
    app.post('/cakes/:id', cakes.createComment);
}