Ext.define('iih.mr.tm.gro.block.GroupElementSearchTreeBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [
	           'Xap.ej.element.tree.Tree',
               'Xap.ej.element.field.CustomTrigger',
	           'Xap.ej.element.field.ComboBox',
	],
	alias:'widget.groupelementsearchtreeblock',
	
	items: [{
		xtype:'xapformblock',
		layout: {
		    type: 'vbox',
		    align: 'left'
		},
		items:[{          
                	xtype: "xaptrigger",
                	name: 'groupElementTrigger',
                	triggerBaseCls :'x-text-trigger', 
                	emptyText: "按组合元素名称检索"//,医疗记录类型                        
				},{
					xtype:'xaptree',
					name:'groupElement',
					ifSelect:true,
					rootVisible: false
				}
		]
	}],

	setData: function(data) {
	    var tree = this.down('xaptree');
	    var myobj=eval(data);  
	    tree.setData(myobj);
	},
    getData: function() {
        return null;
    }    
})