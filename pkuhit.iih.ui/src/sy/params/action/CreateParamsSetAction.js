Ext.define('iih.sy.params.action.CreateParamsSetAction', {
	extend: 'Xap.ej.action.PopAction',
	
	requires: ['iih.sy.params.view.ParamsSetEditView'],
	/*
	* @Override
	*/
	execute: function(context) {
	   //新建模板
		console.log('---------------- CreateParamsSetAction --------------------');
	    var view = this.getOwner();	
	    var block = this.getBlock('result');
        var config = {         
            modal: true,            
            height: 290,
            width: 300,
            title :'新建参数',
            contentConfig: {
            	//新建模板页面
                xtype: 'paramsseteditview', 
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
