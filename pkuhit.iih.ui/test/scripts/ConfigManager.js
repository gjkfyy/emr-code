/**
 * config module
 */

'use strict';

var fs          = require('fs'),
    util        = require('./util'),
    path = require('path'),
    FileManager = require('./FileManager');

// get config from package.json
var packageConfig = util.readJsonSync(FileManager.packageJsonFile) || {};
var settingsConfig = util.readJsonSync(FileManager.settingsFile) || {};
//FileManager.appDataDir = path.join(FileManager.userDataDir, packageConfig.maintenance.appId);
FileManager.appDataDir = path.join(FileManager.userDataDir);
FileManager.settingsFile = path.join(FileManager.appDataDir, 'settings.json');

// default config of application
var appConfig = {};

// default config of user
var defaultUserConfig = {
    version: packageConfig.maintenance.version,
    autoUpdate: true,
    baseServerUrl: settingsConfig.baseServerUrl,
    updateUrl: packageConfig.maintenance.baseServerUrl
};

/**
 * load user config
 */
function initUserConfig() {
    //var config = getUserConfig(),toSync;
	var config = defaultUserConfig;
    // sync app config
    //toSync = util.syncObject(config, defaultUserConfig) || toSync;

    // replace the specified settings
    //if (config.appVersion !== packageConfig.version) {
        // TODO 更多字段
      //  config['appVersion'] = defaultUserConfig['appVersion'];
      //  toSync = true;
    //}

    //if (toSync) {
	 //fs.writeFileSync(FileManager.settingsFile, JSON.stringify(config, null, '\t'));
       
    //}

    //merge user config to global config
    for (var j in config) {
        appConfig[j] = config[j];
    }
}

/**
 * load user config
 * @return {Object} user config
 */
function getUserConfig() {
    if (!fs.existsSync(FileManager.globalSettingsFile)) {
        fs.appendFileSync(FileManager.globalSettingsFile, JSON.stringify(defaultUserConfig, null, '\t'));
    }
    var globalUserConfig = util.readJsonSync(FileManager.globalSettingsFile);
    if(FileManager.globalSettingsFile == FileManager.settingsFile) {
        return globalUserConfig;
    }
    if (!fs.existsSync(FileManager.settingsFile)) {
        if(!fs.existsSync(FileManager.appDataDir)) {
            // 创建目录
            fs.mkdirSync(FileManager.appDataDir);
        }
        fs.appendFileSync(FileManager.settingsFile, JSON.stringify(globalUserConfig, null, '\t'));
    }
    var localUserConfig = util.readJsonSync(FileManager.settingsFile);
    var toSync = false;
    // TODO 从globalUserConfig合并localUserConfig中没有的配置
    for(var name in globalUserConfig) {
        // TODO 在值是布尔类型时，不知道有没有问题
        var global = globalUserConfig[name];
        if (typeof(global) == "undefined" || global == null) {
            continue;
        }

        var local = localUserConfig[name];
        if (typeof(local) == "undefined" || local == null) {
            localUserConfig[name] = global;
            if(!toSync) {
                toSync = true;
            }
        }
    }

    if (toSync) {
        fs.writeFileSync(FileManager.settingsFile, JSON.stringify(localUserConfig, null, '\t'));
    }

    return util.readJsonSync(FileManager.settingsFile) || defaultUserConfig;
}

/**
 * get app config
 * @return {Object} app config
 */
exports.getAppConfig = function () {
    return appConfig;
};

/**
 * get app package info
 * @return {Object} package object
 */
exports.getPackageConfig = function () {
    return packageConfig;
}

exports.saveConfig = function() {
    for (var j in config) {
        config[j] = appConfig[j];
    }
    fs.writeFileSync(FileManager.settingsFile, JSON.stringify(config, null, '\t'));
}

//module initialization
initUserConfig();