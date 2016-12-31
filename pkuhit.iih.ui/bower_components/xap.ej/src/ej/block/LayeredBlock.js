Ext.define('Xap.ej.block.LayeredBlock', {
	extend: 'Xap.ej.block.Block',

	requires : [
		'Xap.ej.block.Layer'
	],

	initBlock: function() {
		this.callParent();
		this.refreshLayers();
	},

	refreshLayers: function() {
		var dict = this.getLayer(Xap.ej.block.Layer.DICTIONARY);
		dict.render();
	}
});