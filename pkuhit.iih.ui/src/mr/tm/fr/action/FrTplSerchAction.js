Ext.define('iih.mr.tm.fr.action.FrTplSerchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

	doExecute: function(context) {  
        var operations = context.operations;
        var keyword =context.event.arguments[1];
        this.prepareOperations(operations,keyword);  
    }, 
    prepareOperations: function(operations,keyword) {
        var url = this.url+'?keyWord='+keyword;//+'?keyword='+'test'
        var mclass = null;        
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: mclass,
            method: METHODS.METHOD_GET,
            condition: null,
            scope: this,
            success: this.onSuccess,
        };
        operations.push(operation);
    },
    onSuccess: function(operation) {
        var block = this.getBlock('result');
        var m = operation; 
        //console.log(operation.result.root);
        // TODO 数据格式就这样了？
        if(m instanceof Ext.data.Model) {
        	block.setData({
				mclass: operation.mclass,
				data: m.getData(true)
			});
        }
        else {
        	block.setData(m.result.data);
        }
    }    

});
