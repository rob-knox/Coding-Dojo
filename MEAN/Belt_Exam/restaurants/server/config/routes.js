const restaurants = require('../controllers/restaurants.js');

module.exports = function(app) {

    app.get('/api/restaurants', restaurants.index);
    app.post('/api/restaurants', restaurants.create); // definitely need slash
    app.delete('/api/restaurants/:id', restaurants.delete);
    app.post('/api/restaurants/:id/review', restaurants.createReview);
    app.get('/api/restaurants/:id/edit', restaurants.show);
    app.post('/api/restaurants/:id/edit', restaurants.update);
    app.get('/api/restaurants/:id/review', restaurants.review);
}