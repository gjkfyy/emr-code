var fs          = require('fs'),
	path        = require('path'),
	util        = require('./util'),
	configManager = require('./ConfigManager');

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

function compileComponents() {
	var manifest = configManager.getManifest();	
	var components = manifest.components;
	for(var name in components) {
		var component = getComponent(name);
		compileComponent(component);
	}
}

function compileComponent(component) {
	if(component && component.dir) {
		var dst = path.join(component.dir, 'test/classes');
		if(!fs.existsSync(dst)) {
			fs.mkdirSync(dst);
		}
		compileComponentToDir(component, dst);
	}
}

function compileComponentToDir(component, dst) {
	if(!component || !component.dir)
		return;
	var src = path.join(component.dir, 'src');
	util.copy(src, dst);

	var dependencies = component.dependencies;
	if(dependencies && dependencies.length > 0) {
		for(var i = 0; i < dependencies.length; i++) {
			var dep = dependencies[i];
			dep = getComponent(dep);
			compileComponentToDir(dep, dst);
		}
	}
}

function getComponent(name) {
	var manifest = configManager.getManifest();
	var components = manifest.components;
	return components[name];
}

parseConfig();
compileComponents();