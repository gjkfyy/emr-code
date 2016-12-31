Ext.define('iih.po.assistant.block.MrDocHelperTreeBlock',{
	extend : 'Xap.ej.block.PanelBlock',
	
	requires: [
	           'Xap.ej.element.tree.Tree',
	           'Xap.ej.element.field.Checkbox'
	],
	alias:'widget.mrdochelpertreeblock',

	layout: 'fit',
    
	items: [{
		xtype:'xaptree',
		border:false,
		autoScroll:true,
		height:245,
		rootVisible: false
	}],
	tbar:[/*{
	        xtype: 'label',
	        flex:1
	        //width: 25
	    },*/
	    {	xtype:'button',
	    	iconCls: 'icon-Open',
	    	text:'门诊病历打印',
	    	method: 'print',
	    	hidden:false
	    }
    ],
    setData: function(data) {
	    var tree = this.down('xaptree');
	    var myobj=eval(data);  
	    tree.setData(myobj);
	},
    getData: function() {
        return null;
    }
    
})