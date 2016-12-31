Ext.define('iih.mr.tm.fr.block.FrTplSearchBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: ['Xap.ej.element.field.Checkbox',
	           'Xap.ej.element.field.CustomTrigger',
	           'iih.mr.tm.fr.view.FrTplView'],
	           
	alias:'widget.frtplsearchblock',
	
	header:false,
	
	border:0,
	    
	items:[{		 
    	xtype:'panel',
    	name:'searchblock',
    	tbar:[{           
	            xtype: "textfield",
	            name: 'keyword',
	            width:220,
	            margin: '0 2 0 2',
	            emptyText: "输入关键字按回车检索",
	            listeners:{
	                specialkey : function(field, e) {  
	                    if (e.getKey() == Ext.EventObject.ENTER) {  
	                        var view = this.up('frtplview');
	                        var chain = view.getActionChain('search');
	                        chain.execute({}); 
	                    }  
	                }
	            }
		    },{
	            itemId: 'refresh',
	            xtype: 'tool',
	            type: 'refresh'
		    }
    	]
	}]  
});