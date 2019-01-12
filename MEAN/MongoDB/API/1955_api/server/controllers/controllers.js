const mongoose = require('mongoose'),
    Person = mongoose.model('Person');

module.exports = {
    index: function(req, res) {
        Person.find({}, function(err, people) {
            if (err) {
                console.log("Returned an error", err);
                res.json({message: "Error", err});
            } else {
                console.log("Showing all people.");
                res.json(people);
            }
        })
    },
    new: function(req, res) {
        Person.create({name: req.params.name}, function(err) {
            if (err) {
                console.log("Returned an error", err);
                res.json({message: "Error", err});
            } else {
                console.log("Added a person!");
                res.redirect('/');
            }
        });
    },
    remove: function(req, res) {
        Person.remove({name: req.params.name}, function(err) {
            if (err) {
                console.log("Returned an error", err);
                res.json({message: "Error", err});
            } else {
                console.log("Person was removed");
                res.redirect('/');
            }
        })
    },
    read: function(req, res) {
        Person.findOne({name: req.params.name}, function(err, people) {
            if (err) {
                console.log("Returned an error", err);
                res.json({message: "Error", err});
            } else {
                console.log("Showing one person.");
                res.json(people);
            }
        });
    }
    
    
}