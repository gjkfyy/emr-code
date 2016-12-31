'use strict';

var fs          = require('fs'),
    util        = require('./util'),
    fileManager = require('./FileManager'),
    path = require('path');

var manifest = util.readJsonSync(fileManager.manifestFile) || {};

exports.getManifest = function () {
    return manifest;
};

exports.repoPath = path.join(fileManager.buildDir, manifest.repo);