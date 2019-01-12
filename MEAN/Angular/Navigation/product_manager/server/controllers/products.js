const mongoose = require('mongoose'),
    Product = mongoose.model('Product');

module.exports = {

    index: function(req, res) {
        console.log("hit index");
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
                    console.log(err);
                    res.json(err);
                } else {
                    console.log('success!');
                    res.json(newProduct);
                }
                
            }); 
    },
    update: function(req, res) {
        console.log('hit update');
        // 3. The server updates the product in the db using the id of the object and req.body
        Product.findOne({_id: req.params.id}, function(err, product) {
            product.title = req.body.title,
            product.price = req.body.price,
            product.imageUrl = req.body.imageUrl,
            product.save(function(err) {
                if (err) {
                    console.log(err);
                    res.json(err);
                } else {
                    console.log('success!');
                    res.json(product);
                }
            });
        });
    },
    show: function(req, res) {
        console.log('hit show');
        Product.findOne({_id: req.params.id}, function(err, product) {
            if (err) {
                console.log(err);
                res.json(err);
            } else {
                console.log('success!');
                res.json(product);
            }
        });
    }
}