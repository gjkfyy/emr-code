Ext.define('Xap.ej.block.ToolbarBlock', {
	extend: 'Ext.toolbar.Toolbar',
	
	requires: [],

	mixins: ['Xap.ej.block.Block'],

	alias: 'widget.xaptoolbarblock',
	
	height: 30,
	
	layout: {
		type: 'hbox',
		pack: 'end'
	}
});