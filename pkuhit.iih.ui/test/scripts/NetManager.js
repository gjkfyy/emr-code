/*
* Net Manager Module
*/
var net = require('net');
var events = require("events");

exports.open = function(config) {
    var self = this;
    if(!config.port) {
        config.port = 8888
    }

    var server = net.createServer();

    server.on('connection', function(origin) {
        var id = buildSocketId(origin.remoteAddress, origin.remotePort);
        if(hasSocket()) {
            throw 'socket should not exist';
        }
        var socket = createSocket(id, origin);
        // server emit
        getEmitter().emit('connection', socket);
    });

    server.on('error', function (e) {
        if (e.code == 'EADDRINUSE') {
            console.log('address in use, failed to start server...netManager');
        }
        else {
            console.log('unexpected error [' + e.code + ']');
        }
    });

    server.listen(config.port, function() {
        console.log('waiting on port: [' + config.port + ']...NETMANAGER');
    });
}

exports.on = function() {
    var len = arguments.length;
    var id, event, listener;
    if(len == 3) {
        id = arguments[0];
        event = arguments[1];
        listener = arguments[2];
    }
    else if(len == 2) {
        event = arguments[0];
        listener = arguments[1];
    }
    if(id) {
        var socket = getSocket(id);
        socket.emitter.on(event, listener);
    }
    else {
        getEmitter().on(event, listener);
    }
}

exports.connect = function(config) {
    if(!config.ip) {
        throw 'must set config.ip';
    }
    if(!config.port) {
        throw 'must set config.port';
    }
    var id = buildSocketId(config.ip, config.port);
    if(hasSocket()) 
        return;
    var origin = net.connect(config.port, config.ip, function() {
        console.log('connected [' + id + ']');
        var socket = getSocket(id);
        socket.emitter.emit('connection', socket);
    });
    return createSocket(id, origin);
}

exports.buildSocketId = buildSocketId;

function getEmitter() {
    if(!this.emitter) {
        this.emitter = new events.EventEmitter();
    }
    return this.emitter;
}

function buildSocketId(ip, port) {
    return ip + '_' + port;
}

function createSocket(id, origin) {
    var socket = new Socket(origin);
    addSocket(id, socket);
    socket.origin.on('end', function() {
        removeSocket(id);
        console.log('socket named [' + id + '] end!');
    });
    socket.origin.on('error', function(e) {
        removeSocket(id);
        console.log('socket named [' + id + '] error [' + e.code + ']');
    });
    socket.origin.on('data', function(data) {
        emitDataEvent(id, data);
    });
    return socket;
}

function emitDataEvent(id, data) {
    var data = data.toString();
    // xml
    if(data.indexOf('<') < 0) {
        data = JSON.parse(data);
    }
    var socket = getSocket(id);
    socket.emitter.emit('data', {
        id: id,
        data:  data  
    });
}

function getSocket(id) {
    var sockets = exports.getSockets();
    var socket = sockets[id];
    if(!socket) {
        throw 'can not find socket with id [' + id + ']';
    }
    return socket;
}

function addSocket(id, socket) {
    var sockets = exports.getSockets();
    if(sockets[id]) {
        throw 'socket named [' + name + '] exists!';
    }
    sockets[id] = socket;
}

function removeSocket(id) {
    var sockets = exports.getSockets();
    this.sockets = {};
    for(var k in sockets) {
        if(!k)
            continue;
        if(k == id) {
            continue;
        }
        this.sockets[k] = sockets[k];
    }
}

function getSockets() {
    if(!this.sockets) {
        this.sockets = {};
    }
    return this.sockets;
}
exports.getSockets = getSockets;

function hasSocket(id) {
    var sockets = exports.getSockets();
    if(sockets[id]) 
        return true;
    return false;
}

function Socket(origin) {
    this.emitter = new events.EventEmitter();
    this.origin = origin;
}

Socket.prototype.on = function(event, listener) {
    this.emitter.on(event, listener);
}

Socket.prototype.send = function(data) {
    var data = JSON.stringify(data);
    this.origin.write(data);
    console.log('his refaresh console log');
}