Ext.define('iih.mr.tm.xml.action.FormXmlCreateAction', {
	extend: 'Xap.ej.action.PopAction',
	

	requires: ['iih.mr.tm.xml.view.FormXmlView'],
	/*
	* @Override
	*/
	execute: function(context) {
	    var view = this.getOwner();
	    var plugin = document.getElementById('iemrEditor');
	    var xmlFile = plugin.ExportEleTableHead(),msg;
	    if(!Ext.isEmpty(xmlFile,false)){
	    	plugin.EnableOCX(false);//设置编辑器不可用
	    	view.xmlFile = xmlFile;
	    	var config = {
	                modal: true,            
	                height: 370,
	                width:  580,
	                title :'表格设置',
	                contentConfig: {
	                    xtype: 'formxmlview',  
	                    initChain: {
	                        name: 'init',
	                        context: {
	                            sourceView: view
	                        }
	                    }
	                }
	        };
		    this.callParent([config]);   
        }else{
        	msg = "请选中表格!";
        	XapMessageBox.info(msg);
        }
    }
});
