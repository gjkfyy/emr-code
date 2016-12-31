/**
 * main 
 */
var fs          = require('fs'),
    FileManager = require('./scripts/FileManager.js');

//Add error event listener
process.on('uncaughtException', function (err) {
    //var message = '---unexpected Exception---\n' + err.stack + '\n\n';
    // fs.appendFile(FileManager.logFile, message);
    //console.log(message);
});

window.addEventListener('error', function (err) {
    var message = '---error---\n' + err.filename + ':' + err.lineno + '\n' + err.message + '\n\n';
    // fs.appendFile(FileManager.logFile, message);
    console.log(message);
}, false);

// var gui = require('nw.gui');
// global.gui = gui;
// global.mainWindow = gui.Window.get();

// global.getFileManager = function () {
//     return FileManager;
// };

global.Ext = Ext;

global.Xap = Xap;

global.iih = iih;

global.IMER_GLOBAL = IMER_GLOBAL;

global.getFileManager = function () {
    return FileManager;
};

var launcher = require('./scripts/launcher.js');
launcher.startUp();