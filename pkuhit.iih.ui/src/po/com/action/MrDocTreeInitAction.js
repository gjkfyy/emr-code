Ext.define('iih.po.com.action.MrDocTreeInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

	doExecute: function(context) {  
        var operations = context.operations;    
        var encounterSn = context.encounterSn;
        this.prepareOperations(operations,encounterSn);    
    }, 
    prepareOperations: function(operations,encounterSn) {
    	//就診序號變量
    	var encounterCode = IMER_GLOBAL.encounterSn;
        console.log(encounterCode);
        var url = this.url+'?encounterPk='+encounterSn;//+'?keyword='+'test'+'&'
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
        //console.log(operation.result);
        // TODO 数据格式就这样了？
        if(m instanceof Ext.data.Model) {
        	block.setData({
				mclass: operation.mclass,
				data: m.getData(true)
			});
        }
        else {
        	//block.setData(m.result.root.children);
        	block.setData(m.result.data.children);
        }
    }    

});
