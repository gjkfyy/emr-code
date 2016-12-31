Ext.define('iih.mr.tm.gro.block.GroupChooseTreeBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [
	           'Xap.ej.element.tree.Tree',
               'Xap.ej.element.field.CustomTrigger',
	           'Xap.ej.element.field.Checkbox',
	           'Xap.ej.element.field.ComboBox',
               'Xap.ej.element.field.ComboBox'
	],
	alias:'widget.groupchoosetreeblock',
	

	//layout: 'fit',
	items:[ { 
	            xtype:'xapformblock',
	            width:200,
		        layout: 'fit',
	            items:[{           
                    xtype: "xaptrigger",
                    name: 'basTemplateTrigger',
                    triggerBaseCls :'x-text-trigger', 
                    emptyText: "按模板名称检索"//,医疗记录类型                        
                }]
	    
	        },
	       {
		        xtype:'panel',
		        layout: 'fit',
		        items:[{
			        	xtype:'xaptree',
			        	name:'basTemplate',
			        	ifSelect:true,
			        	rootVisible: false
			    }]
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