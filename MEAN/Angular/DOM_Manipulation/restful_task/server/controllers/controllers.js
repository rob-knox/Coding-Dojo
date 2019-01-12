var mongoose = require('mongoose');
var Task = mongoose.model('Task');

module.exports = {
	index:function (req, res) {
        Task.find({}, function (err, tasks){
        if (err) {
            console.log("Returned an error.", err);
            res.json({message: "Error", err})
        } else {
            console.log("Success");
            res.json(tasks);
        }
    })
  },
  create:function(req, res) {
      Task.create({title: req.body.title, description: req.body.description, completed: req.body.completed},function(err) {
        if(err) {
            console.log('something went wrong', err);
            res.json(err);
        } else {
            console.log('Task added!');
            res.redirect('/tasks');
        }
      })
  },
  destroy:function(req, res) {
    Task.remove({_id: req.params.id}, function(err, task) {
        if(err) {
            console.log('Returned error', err);
        } else {
            console.log('Task removed!');
            res.json(task)
        }
    });
  },
  show:function(req, res) {
    Task.findOne({_id: req.params.id}, function(err, task) {
        if(err) {
            console.log('Returned error', err);
        } else {
            console.log('Found!');
            res.json(task);
        }
    });
  },
  update:function(req, res) {
    Task.findOne({_id: req.params.id}, function(err, task) {
        task.title = req.body.title,
        task.description = req.body.description,
        task.save(function(err) {
            if(err) {
                console.log('Returned error', err);
            } else {
                console.log('Updated!');
                res.redirect('/tasks');
            }
        })
    });
  }
}