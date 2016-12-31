Ext.define('iih.mr.tm.fr.action.FrTplCreateAction', {
	extend: 'Xap.ej.action.PopAction',
	
	requires: ['iih.mr.tm.fr.view.FrTplProEditView'],
	/*
	* @Override
	*/
	execute: function(context) {
	   //新建模板
		console.log('---------------- FrTplCreateAction --------------------');
	    var view =this.getOwner();	
	    var block = this.getBlock('result');
        var config = {         
            modal: true,            
            height: 220,
            width: 300,
            title :'新建基础模板',
            contentConfig: {
            	//新建模板页面
                xtype: 'frtplproeditview', 
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
