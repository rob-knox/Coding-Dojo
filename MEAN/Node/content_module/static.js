const fs = require('fs');

module.exports = function() {
    return {
        file: function(request, response) {
            var request = request.url;
            var images = '/images/';
            var css = '/stylesheets/';

            console.log(request);

            if (request == '/') {
                console.log('root');
                fs.readFile('index.html', 'utf-8', function(errors, contents) {
                    response.writeHead(200, {'Content-Type': 'text/html'});
                    response.write(contents);
                    response.end();
                });
            } else if (request.includes(images)) {
                console.log('images');
            } else if (request.includes(css)) {
                console.log('css');
            } else {
                console.log('no request');
            }
        }
    }
}