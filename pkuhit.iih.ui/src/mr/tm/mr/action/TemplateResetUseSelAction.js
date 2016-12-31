Ext.define('iih.mr.tm.mr.action.TemplateResetUseSelAction', {
	extend: 'Xap.ej.action.PopAction',
	

	requires: ['iih.mr.tm.mr.view.BasTemplateResetListView'],
	/*
	* @Override
	*/
	execute: function(context) {
		console.log('---------------------- TemplateResetUseSelAction --------------------------------');
	    var gridPage = this.getOwner();
    	var code = gridPage.code;
    	var filePk = gridPage.filePk;
    	var config = {         
                modal: true,            
                height: 340,
                width:  550,
                title :'重新应用基础模板',
                contentConfig: {
                    xtype: 'basictemplateresetlistview',  
                    initChain: {
                        name: 'init',
                        context: {
                            sourceView: gridPage
                        }
                    }
                }
    		};
    	this.callParent([config]); 
    }
});
