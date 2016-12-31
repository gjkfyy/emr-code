Ext.define('iih.mr.wr.mr.action.MrDocSaveAsTemplateAction', {
	extend: 'Xap.ej.action.PopAction',
	requires: ['iih.mr.tm.mr.view.MrTemplatePropertyEditView'],
	/*
	 * @Override
	 */
	execute: function(context) {
	    var plugin = document.getElementById('iemrEditor');
	    var opType=this.getOwner().opType;
	    if(plugin.IsModified()||'new'==opType){
	    	Ext.Msg.alert('提示','请先保存后在进行此操作!');
	    }else{
	    	var view = this.getOwner();
		    view.enTypeCode = 'ENM01.04';
		    var config = {         
	                modal: true,            
	                height: 280,
	                width:  530,
	                title :'另存为模板',
	                contentConfig: {
	                    xtype: 'mrTemplatePropertyEditView',  
	                    initChain: {
	                        name: 'init',
	                        context: {
	                        	plugin:plugin,
	                            customerData: 'mrSaveAs',
	                            verMrTplKc: view.medicalRecord.templeCode,
	                            sourceView: view
	                        }
	                    }
	                }
	    		};
	    	this.callParent([config]); 
	    }
    }
});
