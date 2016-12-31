Ext.define('iih.mr.tm.mr.action.PropertyTemplateDocAction', {
	extend: 'Xap.ej.action.PopAction',
	

	requires: ['iih.mr.tm.mr.view.MrTemplatePropertyEditView'],
	/*
	* @Override
	*/
	execute: function(context) {
	    var doc = this.getOwner();
	    console.log('------------------------------- PropertyTemplateDocAction ------------------------------------------');
	    console.log(doc);
	    var code = doc.ownerCt.code;
	    if(!Ext.isEmpty(code,false)){
	    	var config = {         
                    modal: true,            
                    height: 280,
                    width:  530,
                    title :'模板属性',
                    contentConfig: {
                        xtype: 'mrTemplatePropertyEditView',  
                        initChain: {
                            name: 'init',
                            context: {
                                customerData: 'edit',
                                verMrTplKc :code,
                                sourceView: doc
                            }
                        }
                    }
            };
          this.callParent([config]); 
	    }
    }
});
