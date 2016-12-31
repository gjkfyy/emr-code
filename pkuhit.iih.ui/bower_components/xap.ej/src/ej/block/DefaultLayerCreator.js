Ext.define('Xap.ej.block.DefaultLayerCreator', {
	requires : ['Xap.ej.block.Layer'],

	create: function(config) {
		return Xap.create({
			xclass: 'Xap.ej.block.Layer'
		});
	}
});