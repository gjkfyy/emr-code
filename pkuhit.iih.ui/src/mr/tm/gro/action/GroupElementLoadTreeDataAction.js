Ext.define('iih.mr.tm.gro.action.GroupElementLoadTreeDataAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

	doExecute: function(context) {  
        var operations = context.operations;        
        this.prepareOperations(operations);    
    }, 
    prepareOperations: function(operations) {
    	var encounterCode = IMER_GLOBAL.encounterSn;
        var url = this.url+'?typeCode='+'MRM11.01';//+'?keyword='+'test'+'&'
        console.log(url);
        var mclass = null;        
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: mclass,
            method: METHODS.METHOD_GET,
            condition: null,
            scope: this,
            success: this.onSuccess
        };
        operations.push(operation);
    },
        
    onSuccess: function(operation) {
        var block = this.getBlock('result');
        var m = operation; 
        // TODO 数据格式就这样了？
        if(m instanceof Ext.data.Model) {
        	block.setData({
				mclass: operation.mclass,
				data: m.getData(true)
			});
        }
        else {
        	block.setData(m.result.root);
        }
    }    

});
