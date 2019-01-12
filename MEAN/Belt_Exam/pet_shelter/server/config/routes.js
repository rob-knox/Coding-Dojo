const pets = require('../controllers/pets.js'),
    path = require('path');

module.exports = function(app) {
    app.get('/api/pets', pets.index);
    app.post('/api/pets', pets.create);
    app.get('/api/pets/:id/edit', pets.show);
    app.post('/api/pets/:id/edit', pets.update);
    app.delete('/api/pets/:id', pets.delete);
    app.get('/api/pets/:id', pets.show);

    // this is the catch all function, which redirects to the root page
    app.all("*", (req,res,next) => {
        res.sendFile(path.resolve("./public/dist/public/index.html"))
    });
}