Ext.define('iih.mr.tm.mr.action.GroupElementLibAction', {
	extend: 'Xap.ej.action.PopAction',
	
	requires: ['iih.mr.tm.gro.view.GroupElementChooseView'],
	/*
	* @Override
	*/
	execute: function(context) {
	   //新建模板
	    var view =this.getOwner();
	    var block = this.getBlock('result');	        
        var config = {         
            modal: true,            
            height: 350,
            width:  600,
            title :'组合元素一览',
            contentConfig: {
                xtype: 'groupelementchooseview'
                /*initChain: {
                    name: 'init',
                    context: {
                        customerData: 'new',                        
                        sourceView: view,
                        block:block
                    }
                }*/
            }
        };
        this.callParent([config]);    
    }
});
