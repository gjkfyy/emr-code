Ext.define('Xap.ej.block.LayerFactory', {
	requires : [
		'Xap.ej.platform.Plugin'
	],

	singleton: true,

	createLayer: function(name, owner) {
		if(!name) 
			return;
		if(!this.creators) {
			this.creators = {};
		}
		var creator = this.creators[name];
		if(!creator) {
			creator = this.findCreator(name);
		}
		if(!creator) {
			creator = this.findCreator('default');
		}
		var layer = creator.create();
		layer.setOwner(owner);
		return layer;
	},

	findCreator: function(name) {
		var plugin = Xap.ej.platform.Plugin;
		var ep = plugin.getExtensionPoint('xap.core.block.layer.creators');
		var result = null;
		if(ep) {
			var exts = ep.getExtensions();
			for(var i = 0; i < exts.length; i++) {
				var config = exts[i];
				if(config.xclass && config.name && config.name == name) {
					var creator = Xap.create(config);
					this.creators[creator.name] = creator;
					result = creator;
					break;
				}
			}
		}
		else {
			if(!this.defaultCreator) {
				this.defaultCreator = Xap.create({
					xclass: 'Xap.ej.block.DefaultLayerCreator'
				});
			}
			result = this.defaultCreator;
		}
		return result;
	}
});