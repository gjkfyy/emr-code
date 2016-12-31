Ext.define('iih.mr.wr.mr.action.EmrEmrExportXMLAction', {
	extend: 'Xap.ej.action.PopAction',
	requires: ['iih.mr.wr.mr.view.MrXmlView','iih.mr.wr.mr.view.MrDocEditView'],
	/*
	 * @Override
	 */
	execute: function(context) {
	    var plugin = document.getElementById('iemrEditor');
	    var xml=plugin.ExportXML();
//	    console.log(xml);
	    var view = this.getOwner();
	    var config = {         
                modal: true,            
                height: 580,
                width:  730,
                title :'浏览XML',
                contentConfig: {
                    xtype: 'mrxmlview',  
                    initChain: {
                        name: 'init',
                        context: {
                        	xml:xml,
                            sourceView: view
                        }
                    }
                }
    		};
    	this.callParent([config]); 
	    /*var opType=this.getOwner().opType;
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
	    }*/
    }
});
