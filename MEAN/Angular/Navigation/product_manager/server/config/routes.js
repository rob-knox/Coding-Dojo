const products = require('../controllers/products.js'),
    path = require('path');

module.exports = function(app) {
    //app.get('/', products.index);
    app.post('/api/products', products.create);
    app.get('/api/products', products.index);
    app.get('/api/products/:id', products.show);
    app.post('/api/products/:id/update', products.update);
    app.all("*", (req,res,next) => {
        res.sendFile(path.resolve("./public/dist/public/index.html"));
    });
}