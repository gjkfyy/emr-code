Ext.define('iih.mr.tm.gro.action.CreateGroupElementAction', {
	extend: 'Xap.ej.action.PopAction',
	
	requires: ['iih.mr.tm.gro.view.GroupElementAttributeView'],
	/*
	* @Override
	*/
	execute: function(context) {
	   //新建模板
	    var view =this.getOwner();	
	    var block = this.getBlock('result');
        var config = {         
            modal: true,            
            height: 210,
            width: 550,
            title :'新建组合元素',
            contentConfig: {
            	//新建模板页面
                xtype: 'groupelementattributeview', 
                initChain: {
                    name: 'init',
                    context: {
                        customerData: 'new',
                        sourceView: view,
                        block:block
                    }
                }
            }
        };
        this.callParent([config]);    
    }
});
