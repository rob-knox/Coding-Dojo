const mongoose = require('mongoose');

// Make sure you change this everytime you start a project
var PetSchema = new mongoose.Schema({
    name: {type: String, required: true},
    type: {type: String, required: true},
    description: {type: String, required: true},
    skill1: {type: String},
    skill2: {type: String},
    skill3: {type: String},
    likes: {type: Number}
    }, {timestamps: true})
mongoose.model('Pet', PetSchema);