var fs          = require('fs'),
	path        = require('path'),
	util        = require('./util'),
	fileManager = require('./FileManager'),
	configManager = require('./ConfigManager');

function start() {
	var argv = process.argv;
	var args = parseArguments(argv);
	var command = args.command;
	if(!command) {
		console.log('missing command, end process!');
		return;
	}
	var targetName = args.target;
	this.options = args.options;

	var components = [];
	if(targetName) {
		var manifest = configManager.getManifest();
		var component = manifest.components[targetName];
		if(component && typeof(component)=='string') {
			component = getComponent(targetName);
		}
		if(component) {
			components = [component];
		}
	}
	else {
		components = getComponents();
	}
	if(command == 'compile') {
		compileComponents(components);
	}
	else if(command == 'clean') {
		cleanComponents(components);
	}
	else if(command == 'package') {
		cleanComponents(components);
		compileComponents(components);
		packageComponents(components);
	}
	else {
		console.log('no command found or unclear command');
	}
}

function parseArguments(argv) {
	argv = argv.slice(2);
	var args = {};
	args.options = {};
	for(var i = 0; i < argv.length; i++) {
		var arg = argv[i];
		if(i == 0) {
			args.command = arg;
		}
		else if (i == 1) {
			v = parseOption(arg);
			if(v) {
				args.options[v] = v;
			}
			else {
				args.target = arg;
			}
		}
		else {
			v = parseOption(arg);
			if(v) {
				args.options[v] = v;
			}
		}
	}
	return args;
}

function parseOption(arg) {
	var idx = arg.indexOf('--');
	if(idx == 0) {
		return arg.slice(2);
	}
}

// 打包JS代码
function packageComponents(components) {
	for(var i = 0; i < components.length; i++) {
		var component = components[i];
		if(!component || typeof(component) == 'string')
			continue;
		/*
		sencha -s "E:\develop-tools\sdk\ext-4.2.1.883" compile -cl iih.all/test/classes,bower_components/xap.ej/src concatenate target/iih.all.js
		*/
		var target = component.target;
		if(!target) {
			target = component.name;
		}
		if(target) {
			// TODO 制作一个ExtJs SDK模块放到bower私有库管理
			var cmd = 'sencha compile -cl ';
			var cpaths = getClassPaths(component);
			cmd += cpaths.toString();
			cmd += ' exclude -namespace Ext and concatenate ';
			var dst = path.join(component.dir, 'test', target + '.js');
			cmd += dst;
			console.log(cmd);
			var exec = require('child_process').exec;
			exec(cmd, function (error, stdout, stderr) {
				console.log('stdout: ' + stdout);
				// console.log('stderr: ' + stderr);
				if (error || stderr) {
					console.log('exec error: ' + error);
					console.log(stderr);
				}
				else {
					packageSkin(component);
					console.log('success');
				}
			});
		}
		else {
			console.log('package failed, need target!');
		}
	}
}

function getClassPaths(component) {
	var paths = [];
	paths.push(path.join(component.dir, 'test', 'classes'));
	paths.push(path.join(fileManager.buildDir, 'bower_components', 'xap.ej', 'src'));
	paths.push(path.join(fileManager.buildDir, 'bower_components', 'lib.extjs', 'src'));
	return paths;
}

function cleanComponents(components) {
	for(var i = 0; i < components.length; i++) {
		var component = components[i];
		if(!component || typeof(component) == 'string')
			continue;
		var dst = path.join(component.dir, 'test/classes');
		if(fs.existsSync(dst)) {
			util.removeDir(dst);
		}
		if(this.options.css) {
			dst = path.join(component.dir, 'test/css');
			if(fs.existsSync(dst)) {
				util.removeDir(dst);
			}
		}
	}
}

function compileComponents(components) {
	for(var i = 0; i < components.length; i++) {
		var component = components[i];
		compileComponent(component);
		compileSkin(component);
	}
}

function compileComponent(component) {
	if(!component || !component.dir)
		return;
	var dst = path.join(component.dir, 'test/classes');
	copyDirToDst(component, 'src', dst);
}

// 编译皮肤
function compileSkin(component) {
	if(!this.options.css)
		return;
	var dst = path.join(component.dir, 'test/css');
	copyDirToDst(component, 'css', dst);
}

// 打包皮肤
function packageSkin(component) {
	if(!this.options.css)
		return;
	// TODO 从参数取得
	var theme = 'classic';
	var src = findCssFiles(component, theme);
	if(src && src.length > 0) {
		// TODO 在util里实现多层目录创建
		// if(!fs.existsSync(dst)) {
		// 	fs.mkdirSync(dst);
		// }
		// TODO 考虑theme
		// dst = path.join(dst, theme);
		// if(!fs.existsSync(dst)) {
		// 	fs.mkdirSync(dst);
		// }
		var dst = path.join(component.dir, 'test/css', 'skin-min.css');
		console.log('Try to minify all skin css to [' + dst + ']');
		minifyCss(src, dst);
	}
}

function findCssFiles(component, theme) {
	var ret = [];
	var cssdir = path.join(component.dir, 'test/css');
	// var skinCss = path.join(component.dir, 'css/' + theme + '/skin.css');
	// if(fs.existsSync(skinCss)) {
	// 	ret.push(skinCss);
	// }
	if(fs.existsSync(cssdir)) {
		var files = fs.readdirSync(cssdir);
		files.forEach(function (file) {
			var path = cssdir + '/' + file;
			var stats = fs.lstatSync(path);
			if (!stats.isDirectory()) {
				ret.push(path);
			}
		});
	}
	// var dependencies = component.dependencies;
	// if(dependencies && dependencies.length > 0) {
	// 	for(var i = 0; i < dependencies.length; i++) {
	// 		var dep = dependencies[i];
	// 		dep = getComponent(dep);
	// 		var files = findCssFiles(dep, theme);
	// 		if(files && files.length > 0) {
	// 			ret = ret.concat(files);
	// 		}
	// 	}
	// }
	return ret;
}

function copyDirToDst(component, dir, dst) {
	var src = path.join(component.dir, dir);
	if(!fs.existsSync(dst)) {
		fs.mkdirSync(dst);
	}
	// 原文件存在，则拷贝；否则跳过
	if(fs.existsSync(src)) {
		util.copy(src, dst);
	}
	var dependencies = component.dependencies;
	if(dependencies && dependencies.length > 0) {
		for(var i = 0; i < dependencies.length; i++) {
			var dep = dependencies[i];
			dep = getComponent(dep);
			copyDirToDst(dep, dir, dst);
		}
	}
}

// 压缩合并CSS
function minifyCss(fileIn, fileOut) {
	var CleanCSS = require('clean-css');
	var fileIn=Array.isArray(fileIn)? fileIn : [fileIn];
	var origCode = '';
	var finalCode='';
	for(var i=0; i<fileIn.length; i++) {
		origCode = fs.readFileSync(fileIn[i], 'utf8');
		finalCode += new CleanCSS().minify(origCode);
	}
    fs.writeFileSync(fileOut, finalCode, 'utf8');
}

function getComponent(name) {
	var manifest = configManager.getManifest();
	var components = manifest.components;
	var cp = components[name];
	if(cp && typeof(cp)=='string') {
		cp = path.join(configManager.repoPath, cp);
		var ccp = path.join(cp, 'build.json');
		if(fs.existsSync(ccp)) {
			cc = util.readJsonSync(ccp) || {};
			cc.dir = cp;
			cc.name = name;
			components[name] = cc;
		}
	}
	return components[name];
}

function getComponents() {
	var manifest = configManager.getManifest();
	var components = manifest.components;
	var ret = [];
	for(var name in components) {
		var component = components[name];
		if(component && typeof(component)=='string') {
			component = getComponent(name);
		}
		if(component) {
			ret.push(component);
		}
	}
	return ret;
}

start();