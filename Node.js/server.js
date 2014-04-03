var http = require('http');

http.createServer(function (req, res) {
	// console.log(req);
	res.writeHead(200, {'Content-Type': 'text/html'});
	res.end('<h1>Totes legit Node.JS server!</h1>');
}).listen(1337, '127.0.0.1');

console.log("Totes legit Node.JS server running on 127.0.0.1:1337!");