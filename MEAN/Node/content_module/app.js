const http = require('http');
const static_contents = require('./static.js')();

const server = http.createServer(function(request, response) {
    //console.log(request.url);
    static_contents.file(request);
    
});
server.listen(8000);
console.log('Running in localhost at port 8000.')