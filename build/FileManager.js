'use strict';

var fs   = require('fs'),
    path = require('path');

exports.rootDir = process.cwd();
    // exports.buildDir = path.join(exports.rootDir, 'build');
	exports.buildDir = exports.rootDir;
    exports.manifestFile = path.join(exports.buildDir, 'manifest.json');

// exports.userDataDir = path.join(process.env[(process.platform === 'win32') ? 'USERPROFILE' : 'HOME'], '.iemr');
    //exports.storageDir = path.join(exports.userDataDir, 'storage');

// Create it if the directory is not exists
// if (!fs.existsSync(exports.userDataDir)) {
//    fs.mkdirSync(exports.userDataDir);
//}