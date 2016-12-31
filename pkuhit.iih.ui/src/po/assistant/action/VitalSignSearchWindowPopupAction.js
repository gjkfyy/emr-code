
Ext.define('iih.po.assistant.action.VitalSignSearchWindowPopupAction', {
	extend: 'Xap.ej.action.PopAction',
	
	requires: ['iih.po.assistant.view.VitalSignHelperSearchView'],
	/*
	* @Override
	*/
	execute: function(context) {
	   //新建模板
        var config = {         
            modal: true,            
            height: 180,
            width: 420,
            title :'生命体征查询',
            contentConfig: {
            	//新建模板页面
                xtype: 'VitalSignHelperSearchView',
                initChain: {
                    name: 'init',
                    context: {
                        customerData: 'new',
                        sourceView: this.getOwner()
                    }
                }
            }
        };
        this.callParent([config]);    
    }
})

