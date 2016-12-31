Ext.define('iih.po.assistant.action.FragmentTplTypeComboxAction', {
	extend: 'Xap.ej.action.ServiceInvocation',	
	
	doExecute: function(context) {
	    this.callParent();
        var operations = context.operations;      
        this.prepareOperations(operations);        
	},  
	 prepareOperations: function(operations) {
        var condition = '?empCd='+'1001'+'&deptCd='+'100023';       
        var url = this.url + condition;    
        console.log(url);
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_GET,
            condition: null,
            data:condition,
            scope: this,
            success: this.onSuccess,
            //fail: this.onFail
        };
        operations.push(operation);	    
	 },
	    
    onSuccess: function(operation) {
        //alert("FragmentTplTypeSearchAction");
        var block = this.getBlock('result').down('[name=fragmentTplTypeCd]');      
        var m = operation.result;
		if(m){
			// TODO 数据格式就这样了？
			if(m instanceof Ext.data.Model) {
				block.setData({
					mclass: operation.mclass,
					data: m.getData(true)
				});
			}
			else {
				block.setData(m);
			}
		}
    }    
});
