const mongoose = require('mongoose');

var CommentSchema = new mongoose.Schema({
    rating: {type: Number},
    comment: {type: String}
    })

var CakeSchema = mongoose.Schema({
    name: {type: String},
    url: {type: String},
    comments: [CommentSchema]
})

mongoose.model('Comment', CommentSchema);
mongoose.model('Cake', CakeSchema);