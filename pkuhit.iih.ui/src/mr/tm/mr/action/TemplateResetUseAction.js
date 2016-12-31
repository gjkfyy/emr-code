Ext.define('iih.mr.tm.mr.action.TemplateResetUseAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

	/*
	* @Override
	*/
	doExecute: function(context) {
		console.log('---------------------- TemplateResetUseAction --------------------------------');
	    var view = this.getOwner().ownerCt;
	    var code = view.code;
	    var operations = context.operations;
	    //通过code获取到基础模板的文件id
	    this.prepareOperations(operations,code);
    },
    
    prepareOperations: function(operations,data) {  
    	var url = 'mr/tpl/smbtfp?code='+data;
    	var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: METHODS.GET,
            data: data,
            scope: this,
            success: this.onSuccess,
            fail: this.onFail
        };
        operations.push(operation);
    },
    
    onSuccess: function(operation) {
    	var result = operation.result;
    	var file = result.data.odtFile;
    	var plugin = document.getElementById('iemrEditor');
	    plugin.tagName='ext';
	    var temp = plugin.SaveToString();
	   // plugin.CloseDocument();
	    plugin.OpenFromString(file,2);
	    plugin.InsertFromString(temp,0);
	    //控制按钮
	    var me = this;
        var emrStartApprove ='com.founder.iemr.editor.toolbar:emrStartApprove';//开始审签
        setTimeout(function() {
        	plugin.SetCommandVisible(emrStartApprove,false);
        	plugin.UpdateToolbar();
        },350);
    	return;
    },
    
    onFail: function(operation) {
    	return;
    }
});
