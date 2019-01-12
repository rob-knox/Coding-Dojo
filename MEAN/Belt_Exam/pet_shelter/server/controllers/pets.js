const mongoose = require('mongoose'),
    Pet = mongoose.model('Pet');

module.exports = {

    index: function(req, res) {
        console.log('hit index');
        Pet.find({}, function(err, pets) {
            if (err) {
                console.log('Returned an error.');
                res.json({message: 'Error'}, err);
            } else {
                console.log('Success');
                res.json(pets);
            }
        })
    },
    create: function(req, res) {
        console.log('hit create');
        var newPet = new Pet(req.body);
        newPet.save(function(err) {
            if (err) {
                console.log('returned an error');
                res.json(err);
            } else {
                console.log('created a pet');
                res.json(newPet);
            }
        })
    },
    show: function(req, res) {
        console.log('Hit show');
        Pet.findOne({_id: req.params.id}, function(err, pet) {
            res.json(pet);
        });
    },
    update: function(req, res) {
        console.log('hit update');
        Pet.findOne({_id: req.params.id}, function(err, pet) {
            pet.name = req.body.name,
            pet.type = req.body.type,
            pet.description = req.body.description,
            pet.skill1 = req.body.skill1,
            pet.skill2 = req.body.skill2,
            pet.skill3 = req.body.skill3,
            pet.likes = req.body.likes,
            pet.save(function(err) {
                if (err) {
                    console.log(err);
                    res.json(err);
                } else {
                    console.log('saved a pet');
                    res.json(pet);
                }
            });
        });
    },
    delete: function(req, res) {
        console.log('hit delete');
        Pet.remove({_id: req.params.id}, function(err, pet) {
            res.json(pet)
        });
    }
    
}