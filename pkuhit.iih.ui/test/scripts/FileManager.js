/*
* File Manager Module
*/
'use strict';

var fs   = require('fs'),
    path = require('path'),
    util = require('./util');

exports.rootDir = process.cwd();
    exports.appScriptsDir = path.join(exports.rootDir, 'scripts');
    exports.packageJsonFile = path.join(exports.rootDir, 'package.json');

//exports.userDataDir = path.join(process.env[(process.platform === 'win32') ? 'USERPROFILE' : 'HOME'], '.iemr');
exports.userDataDir = path.join(exports.rootDir, 'userconfig');
    exports.storageDir = path.join(exports.userDataDir, 'storage');
    exports.tmpDir = path.join(exports.userDataDir, 'tmp');
    exports.tmpFile = path.join(exports.tmpDir, 'tmp.json');
    exports.logFile = path.join(exports.userDataDir, 'iemr.log');
    exports.globalSettingsFile = path.join(exports.userDataDir, 'settings.json');
    // 默认两种设置来自相同的文件settings.json
    exports.settingsFile = path.join(exports.rootDir, 'settings.json');
    // 默认App数据目录跟用户数据目录相同
    exports.appDataDir = exports.userDataDir;

// Create it if the directory is not exists
if (!fs.existsSync(exports.userDataDir)) {
	//console.log(exports.userDataDir);
    //fs.mkdirSync(exports.userDataDir);
}

if (!fs.existsSync(exports.storageDir)) {
   // fs.mkdirSync(exports.storageDir);
}
