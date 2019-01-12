const products = require('../controllers/products.js'),
    path = require('path');

module.exports = function(app) {
    app.get('/api/products', products.index);
    app.post('/api/products', products.create);
    app.get('/api/products/:id/edit', products.show_one);
    app.delete('/api/products/:id', products.delete);
    app.post('/api/products/:id/edit', products.update);

    // this is the catch all function, which redirects to the root page
    app.all("*", (req,res,next) => {
        res.sendFile(path.resolve("./public/dist/public/index.html"))
    });
}