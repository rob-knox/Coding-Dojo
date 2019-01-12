const mongoose = require('mongoose'),
    Product = mongoose.model('Product');

module.exports = {

    index: function(req, res) {
        Product.find({}, function(err, products) {
            // breadcrumbs
            if (err) {
                console.log('Returned an error.');
                res.json({message: 'Error'}, err);
            } else {
                console.log('Success');
                res.json(products);
            }
        })
    },
    create: function(req, res) {
        console.log('hit create');
        var newProduct = new Product(req.body);
        newProduct.save(function(err) {
            if (err) {
                console.log('returned an error');
                res.json(err);
            } else {
                console.log(newProduct);
                res.json(newProduct);
            }
        })
    },
    show_one: function(req, res) {
        console.log('Hit show');
        Product.findOne({_id: req.params.id}, function(err, product) {
            res.json(product);
        });
    },
    update: function(req, res) {
        Product.findOne({_id: req.params.id}, function(err, product) {
            product.name = req.body.name,
            product.quantity = req.body.quantity,
            product.price = req.body.price,
            product.save(function(err) {
                if (err) {
                    console.log(err);
                    res.json(err);
                } else {
                    console.log('saved a product');
                    res.json(product);
                }
            });
        });
    },
    delete: function(req, res) {
        console.log('hit delete');
        Product.remove({_id: req.params.id}, function(err, product) {
            res.json(product)
        });
    }
}