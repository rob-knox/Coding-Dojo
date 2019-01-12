const mongoose = require('mongoose');

// redefine models per project
var ProductSchema = new mongoose.Schema({
    imageUrl: {type: String, required: true, minLength: 4},
    title: {type: String, required: true},
    price: {type: Number}
    }, {timestamps: true})
mongoose.model('Product', ProductSchema);