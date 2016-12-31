Ext.define('iih.po.com.block.KnowledgeSearchBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: ['Xap.ej.element.field.Checkbox',
	           'Xap.ej.element.field.CustomTrigger',
	           'iih.po.com.view.KnowledgeView'],
	           
	alias:'widget.knowledgesearchblock',
	
	header:false,
	
	border:0,
	    
	items:[{		 
    	xtype:'panel',
    	name:'searchblock',
    	tbar:[/*{
		        xtype: 'xapcheckbox',
		        padding:'0 0 0 5',
		        name:'ownerPersonal',
		        vertical: true,
		        boxLabel: '个人', 
		        inputValue: 'MDM12.03',
		        checked:true
		    },{
		        xtype: 'xapcheckbox',
		        padding:'0 0 0 5',
		        name:'ownerDept',
		        vertical: true,
		        boxLabel: '科室',
		        inputValue: 'MDM12.02'
		    },*/{           
	            xtype: "textfield",
	            name: 'keyword',
	            width:220,
	            margin: '0 2 0 2',
	            emptyText: "输入关键字按回车检索",
	            listeners:{
	                specialkey : function(field, e) {  
	                    if (e.getKey() == Ext.EventObject.ENTER) {  
	                        var view = this.up('knowledgeview');
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