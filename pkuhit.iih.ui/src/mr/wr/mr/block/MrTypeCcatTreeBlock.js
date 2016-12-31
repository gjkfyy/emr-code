Ext.define('iih.mr.wr.mr.block.MrTypeCcatTreeBlock',{
	extend : 'Xap.ej.block.Block',

	requires: ['Xap.ej.element.tree.Tree'],
	
	alias:'widget.mrtypeccatTreeBlock',
	
	layout: 'fit',
	
	border: 0,
	
	items:[{
        xtype:'xaptree',
        border: 0,
        flex: 1,
        ifSelect:true,
        rootVisible: false
    }],

	setData: function(data) {
	},
    getData: function() {
    }	
    
})