const mongoose = require('mongoose'),
    Comment = mongoose.model('Comment'),
    Cake = mongoose.model('Cake');

module.exports = {

    index: function(req, res) {
        Cake.find({}, function(err, cakes) {
            // breadcrumbs
            if (err) {
                console.log('Returned an error.');
                res.json(err);
            } else {
                console.log('Showing all cakes');
                res.json(cakes);
            }
        })
    },
    create: function(req, res) {
        Cake.create(req.body, function(err, cake) {
            if (err) {
                console.log('Returned an error.');
                res.json(err);
            } else {
                console.log('Added a cake.');
                res.json(cake);
            }
        })
    },
    createComment: function(req, res) {
       Cake.findOne({_id: req.params.id}, function(err, cake) {
            if (err) {
                console.log('Returned an error.');
                res.json(err);
            } else {
                console.log("Added a comment.");
                Comment.create(req.body, function(err, comment) {
                    if (err) {
                        console.log('Error saving comment');
                        res.json(err);
                    } else {
                        console.log('Created a comment');
                        cake.comments.push(comment);
                        cake.save(function(err) {
                            if (err) {
                                console.log("Didn't push the comments");
                                res.json(err);
                            } else {
                                console.log('We did it fam');
                                res.json(comment);
                            }
                        })
                    }
                });
            }
       });
    }
}