const mongoose = require('mongoose');

// Make sure you change this everytime you start a project
var ReviewsSchema = new mongoose.Schema({
    name: {type: String},
    stars: {type: Number},
    review: {type: String}
});
var RestaurantSchema = new mongoose.Schema({
    name: {type: String},
    cuisine: {type: String},
    reviews: [ReviewsSchema]
});
    
mongoose.model('Restaurant', RestaurantSchema);
mongoose.model('Reviews', ReviewsSchema);