Ext.define('Xap.ej.stl.STLPlugin', {
	extend: 'Xap.ej.platform.Plugin',

	requires: [
		'Xap.ej.stl.action.DictionaryAction'
	],

	constructor: function() {
		this.callParent();
		var canvas = Xap.getCanvas();
		var action = Xap.create({
			xclass: 'Xap.ej.stl.action.DictionaryAction'
		});
		action.addBlock('target', canvas);
		canvas.addAction(action);
	},

	pluginConfig: {
		extensions: {
		}
	}
})