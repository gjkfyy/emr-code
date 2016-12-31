Ext.define('iih.mr.tm.mr.action.MrTemplateNmSerchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
    doExecute: function(context) {
        //console.log(context.event.arguments[1]);
        var mrTplNm =context.event.arguments[1];
        var operations = context.operations;    
        this.prepareOperations(operations,mrTplNm);
    }, 
    prepareOperations: function(operations,data) {
        var url = this.url;
        url += '/' + data;       
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_GET,
            condition: null,
            data:null,
            scope: this,
            success: this.onSuccess,
            //fail: this.onFail
        };
        operations.push(operation);     
     },        
    onSuccess: function(operation) {
        var block = this.getBlock('result');
        var m = operation;
		if(m)
			block.setData(m.result.data);
    }    
    
});
