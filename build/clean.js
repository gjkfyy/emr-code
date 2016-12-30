var fs          = require('fs'),
	path        = require('path'),
	util        = require('./util'),
	configManager = require('./ConfigManager');

// TODO 共通化
function parseConfig() {
	var manifest = configManager.getManifest();

	var components = manifest.components;
	for(var name in components) {
		var cp = components[name];
		cp = path.join(configManager.repoPath, cp);
		var ccp = path.join(cp, 'build.json');
		if(fs.existsSync(ccp)) {
			cc = util.readJsonSync(ccp) || {};
			cc.dir = cp;
			components[name] = cc;
		}
	}
}

function cleanComponents() {
	var manifest = configManager.getManifest();
	
	var components = manifest.components;

	for(var name in components) {
		cleanComponent(name);
	}
}

function cleanComponent(name) {
	var manifest = configManager.getManifest();
	var components = manifest.components;
	var component = components[name];
	if(component && component.dir) {
		var dst = path.join(component.dir, 'test/classes');
		if(fs.existsSync(dst)) {
			util.removeDir(dst);
		}
	}
}

parseConfig();
cleanComponents();