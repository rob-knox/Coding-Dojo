const mongoose = require('mongoose');

// Make sure you change this everytime you start a project
var ProductSchema = new mongoose.Schema({
    name: {type: String, required: true, minlength: 3},
    quantity: {type: Number, required: true},
    price: {type: Number, required: true}
    }, {timestamps: true})
mongoose.model('Product', ProductSchema);