Ext.define('Xap.ej.CorePlugin', {
	extend: 'Xap.ej.platform.Plugin',

	requires: [
		'Xap.ej.block.DefaultLayerCreator',
		'Xap.ej.block.CanvasLayerCreator',
		'Xap.ej.block.DictionaryLayerCreator'
	],

	pluginConfig: {
		extensions: {
			'xap.core.block.layer.creators': [{
				name: 'default',
				xclass: 'Xap.ej.block.DefaultLayerCreator'
			}, {
				name: 'canvas',
				xclass: 'Xap.ej.block.CanvasLayerCreator'
			}, {
				name: 'dictionary',
				xclass: 'Xap.ej.block.DictionaryLayerCreator'
			}]
		}
	}
})