var mongoose = require('mongoose');

var PersonSchema = new mongoose.Schema({
    name: {type: String, required: true, minLength: 2}
}, {timestamps: true});
mongoose.model('Person', PersonSchema);