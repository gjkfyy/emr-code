Ext.define('iih.mr.tm.mr.action.PropertyTemplateSaveAsAction', {
	extend: 'Xap.ej.action.PopAction',
	

	requires: ['iih.mr.tm.mr.view.MrTemplatePropertyEditView'],
	/*
	* @Override
	*/
	execute: function(context) {
		console.log('---------------------- PropertyTemplateSaveAsAction --------------------------------');
	    var gridPage = this.getOwner().ownerCt;
	    var code = gridPage.code;
	    if(code!=undefined && !Ext.isEmpty(code,false)){
	    	var filePk = gridPage.filePk;
	    	var config = {         
	                modal: true,            
	                height: 280,
	                width:  530,
	                title :'模板另存为',
	                contentConfig: {
	                    xtype: 'mrTemplatePropertyEditView',  
	                    initChain: {
	                        name: 'init',
	                        context: {
	                            customerData: 'saveAs',
	                            verMrTplKc :code,
	                            filePk:filePk,
	                            sourceView: gridPage,
	                            enTypeCode:gridPage.enTypeCode
	                        }
	                    }
	                }
	    		};
	    	this.callParent([config]); 
	    }else{
	    	var message = '请选先保存模板。再另存模板';
	        XapMessageBox.info(message);
	    }
    }
});
