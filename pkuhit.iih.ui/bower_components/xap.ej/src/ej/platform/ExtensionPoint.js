Ext.define('Xap.ej.platform.ExtensionPoint', {
	extensions: [],

	name: null,

	getName: function() {
		return this.name;
	},

	setName: function(name) {
		this.name = name;
	},

	addExtension: function(ext) {
		if(Ext.isArray(ext)) {
			this.extensions = this.extensions.concat(ext);
		}
		else {
			this.extensions.push(ext);
		}
	},

	getExtensions: function() {
		return this.extensions;
	}
})