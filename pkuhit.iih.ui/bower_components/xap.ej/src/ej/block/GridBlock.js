Ext.define('Xap.ej.block.GridBlock', {
	extend: 'Xap.ej.element.grid.Grid',

	requires : [
		'Xap.ej.block.LayeredBlock'
	],

	alias : 'widget.xapgridblock',

	mixins : ['Xap.ej.block.LayeredBlock'],

	initComponent: function() {
		this.callParent();
		this.initBlock();
	}
});