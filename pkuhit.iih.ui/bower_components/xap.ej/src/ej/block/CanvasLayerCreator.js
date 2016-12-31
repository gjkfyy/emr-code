Ext.define('Xap.ej.block.CanvasLayerCreator', {
	requires : ['Xap.ej.block.Layer'],

	create: function(config) {
		var canvas = Xap.getCanvas();
		return canvas.getLayer('default');
	}
});