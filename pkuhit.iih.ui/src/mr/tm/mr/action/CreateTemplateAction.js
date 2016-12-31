Ext.define('iih.mr.tm.mr.action.CreateTemplateAction', {
	extend: 'Xap.ej.action.PopAction',
	
	requires: ['iih.mr.tm.mr.view.MrTemplatePropertyEditView'],
	/*
	* @Override
	*/
	execute: function(context) {
	   //新建模板
	    var view = this.getOwner();
	    console.log('-------------------- CreateTemplateAction ---------------------------');
	    console.log(view);
	    var xaptreemrTemplate = view.down('xaptree[name=mrTemplate]');
	    console.log(xaptreemrTemplate)
	    var nodeId = xaptreemrTemplate.nodeId;
	    var ownerCode,mrCategoryCode,typeCode;
	    if(typeof(nodeId)!=undefined && nodeId!=null && nodeId!=''){//如果非空
        	temp = nodeId.split('_');
        	if(temp.length==2){
        		ownerCode = temp[temp.length-1];
        	}else if(temp.length==3){
        		ownerCode = temp[temp.length-2];
        		mrCategoryCode = temp[temp.length-1];
        	}else if(temp.length==4){
        		ownerCode = temp[temp.length-3];
        		mrCategoryCode = temp[temp.length-2];
        		typeCode = temp[temp.length-1];
        	}
        }
	    view.ownerCode = ownerCode;
	    view.mrCategoryCode = mrCategoryCode;
	    view.typeCode = typeCode;
	    view.nodeId = nodeId;
	    var block = this.getBlock('result');	
        var config = {         
            modal: true,
            height: 280,
            width:  530,
            title :'新建模板',
            contentConfig: {
                xtype: 'mrTemplatePropertyEditView',
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
