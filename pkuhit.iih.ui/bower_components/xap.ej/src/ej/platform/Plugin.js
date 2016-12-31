Ext.define('Xap.ej.platform.Plugin', {
	requires: ['Xap.ej.platform.ExtensionPoint'],

	statics: {
		points: {},

		getExtensionPoint: function(name) {
			return this.points[name];
		},

		addExtensionPoint: function(ep) {
			if(ep instanceof Xap.ej.platform.ExtensionPoint) {
				this.points[ep.getName()] = ep;
			}
		},

		load: function(plugins) {
			if(Ext.isArray(plugins)) {
				for(var i = 0; i < plugins.length; i++) {
					var pluginName = plugins[i];
					if(pluginName) {
						var p = Xap.create(pluginName);
						p.init();
					}
				}
			}
		}
    },

	constructor: function() {
		// 配置Plugin的时候，应该已经把依赖的类Require了
		var extensions = this.pluginConfig.extensions;
		for(var name in extensions) {
			this.createExtensionPoint(name, extensions[name]);
		}
    },

    createExtensionPoint: function(name, extPointConfig) {
    	var plugin = Xap.ej.platform.Plugin;
    	var ep = plugin.getExtensionPoint(name);
    	if(name && !ep) {
    		// TODO 用new关键字？
    		ep = new Xap.ej.platform.ExtensionPoint();
    		ep.setName(name);
    		plugin.addExtensionPoint(ep);
    	}
    	ep.addExtension(extPointConfig);
    },

	getExtensions: function(extPointName) {
		var plugin = Xap.ej.platform.Plugin;
		var extPoint = plugin.getExtensionPoint(extPointName);
		if(extPoint) {
			return extPoint.getExtensions();
		}
	},

	init: Ext.emptyFn
})