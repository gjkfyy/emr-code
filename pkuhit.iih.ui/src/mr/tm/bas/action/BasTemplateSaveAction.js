Ext.define('iih.mr.tm.bas.action.BasTemplateSaveAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	requires: ['iih.po.com.view.ResourceNavigationView'],
	/*
	 * @Override
	 */
	execute: function(context) {
	    var operations = context.operations;
        if(!operations) {
            return;
        }
	    var plugin = document.getElementById('iemrEditor');
	    plugin.tagName = 'ext';
	    var owner = this.getOwner();
	    var opType = owner.opType;
	    var data = {'odtFile':plugin.SaveToString()};
	    console.log(data);
	    if(opType!=undefined){
	    	this.showSubmitProgressBar();
            if(opType=='new' || opType=='upgrade'){
            	data.name = owner.title;
            	data.description = owner.description;
            	data.paperTypeCode = owner.paperTypeCode;
                this.addPrepareOperations(operations,data);
            }else if(opType=='open'){
            	data.code = this.getOwner().code;
            	data.filePk = this.getOwner().filePk;
                this.openPrepareOperations(operations, data);
            }
        }
    },
    
    addPrepareOperations: function(operations,data) {    
        var METHODS = this.getInvocationMethods();       
        var url = this.url;
        console.log(url);
        var operation = {
            url: url,
            method: METHODS.METHOD_CREATE,
            data:data,
            scope: this,
            success: this.onAddSuccess,
            fail: this.onFail
        };
        operations.push(operation);
    },
    
    openPrepareOperations: function(operations,data) {
    	var code = data.code;
    	console.log(data);
        var METHODS = this.getInvocationMethods();
        var url = this.url+"/"+code;
        var operation = {
            url: url,
            method: METHODS.METHOD_UPDATE,
            data:data,
            scope: this,
            success: this.onOpenSuccess,
            fail: this.onFail
        };
        operations.push(operation);
    },
    onOpenSuccess: function(operation) {
        //Ext.Msg.alert('提示','保存成功!');
    },
    onAddSuccess: function(returnData) {
    	var mrTemplateEditPage = this.getOwner();
    	mrTemplateEditPage.opType = 'open';
    	mrTemplateEditPage.filePk = returnData.result.data.filePk;
    	mrTemplateEditPage.code = returnData.result.data.code;
//    	var properties = this.getOwner().getLayer(Xap.ej.block.Layer.PROPERTIES);
//    	properties.owner.opType = 'open';
//    	properties.owner.filePk = returnData
        //Ext.Msg.alert('提示','保存成功!');
    },
    onFail: function(operation) {
        Ext.Msg.alert('提示','保存失败!');
    }
        
});
