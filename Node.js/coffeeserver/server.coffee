http = require('http')

server = http.createServer (req, res) ->
    console.log req.method, req.url
    data = 'Hi\n You requested ' + req.url
    res.writeHead(200,
        'Content-Type':     'text/plain'
        'Content-Length':   data.length)
    res.end(data)

server.listen(1337)

console.log("Totes legit Node.CoffeeScript server running on 127.0.0.1:1337!")
