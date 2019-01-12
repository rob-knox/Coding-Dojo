const mongoose = require('mongoose'),
    Restaurant = mongoose.model('Restaurant'),
    Reviews = mongoose.model('Reviews');

module.exports = {

    index: function(req, res) {
        console.log('Hit index');
        Restaurant.find({}, function(err, restaurants) {
            if (err) {
                console.log('Returned an error.');
                res.json({message: 'Error'}, err);
            } else {
                console.log('Success');
                res.json(restaurants);
            }
        })
    },
    create: function(req, res) {
        console.log('Hit create');
        var newRestaurant = new Restaurant(req.body);
        newRestaurant.save(function(err) {
            if (err) {
                console.log(err);
                res.json(err);
            } else {
                console.log('Created a new restaurant');
                res.json(newRestaurant);
            }
        })
    },
    show: function(req, res) {
        console.log('Hit show');
        Restaurant.findOne({_id: req.params.id}, function(err, restaurant) {
            if (err) {
                console.log(err);
                res.json(err);
            } else {
                console.log('Found a new restaurant');
                res.json(restaurant);
            }
        });
        console.log('show completed');
    },
    delete: function(req, res) {
        console.log('Hit delete');
        Restaurant.remove({_id: req.params.id}, function(err, restaurant) {
            if (err) {
                console.log(err);
                res.json(err);
            } else {
                console.log('Created a new restaurant');
                res.json(restaurant);
            }
        })
    },
    createReview: function(req, res) {
        console.log('hit createReview');
        Restaurant.findOne({_id: req.params.id}, function(err, restaurant) {
            if(err) {
                console.log('Returned an error');
                res.json(err);
            } else {
                console.log('added a review');
                Reviews.create(req.body, function(err, review) {
                    if (err) {
                        console.log('Error saving review');
                        res.json(err);
                    } else {
                        console.log(restaurant.reviews);
                        restaurant.reviews.push(review);
                        restaurant.save(function(err) {
                            if (err) {
                                console.log("didnt push to reviews");
                                res.json(err);
                            } else {
                                console.log("Succesfully pushed reviews");
                                res.json(review);
                            }
                        })
                    }
                })
            }
        });
    },
    update: function(req, res) {
        console.log('hit update');
        // 3. The server updates the product in the db using the id of the object and req.body
        Restaurant.findOne({_id: req.params.id}, function(err, restaurant) {
            restaurant.name = req.body.name,
            restaurant.cuisine = req.body.cuisine,
            restaurant.save(function(err) {
                if (err) {
                    console.log(err);
                    res.json(err);
                } else {
                    console.log('success!');
                    res.json(restaurant);
                }
            });
        });
    },
    review: function(req, res) {
        console.log('hit review');
    }
    
}