Ext.define('iih.mr.dr.condition_set.action.ConditionSettingInferLeftInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

	doExecute: function(context) {
		this.showLoading();
        var operations = context.operations;
        var view = this.getBlock('result').ownerCt;
        var data = {};
//        var xmlFilePk = view.ownerCt.down('[name=mrDocType]').value;
//        condition = {xmlFilePk:xmlFilePk};
//        data.condition = condition;
        this.prepareOperations(operations, data);    
    }, 
    prepareOperations: function(operations, data) {
    	var condition = data.condition;
        var url = this.url;
        if(Ext.Object.getSize(condition) > 0 ){
	        var queryString = Ext.Object.toQueryString(condition);
	        url = url + '?'+queryString;
        }

        var mclass = null;        
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: mclass,
            method:METHODS.METHOD_GET,
            condition: null,
            scope: this,
            success: this.onSuccessTree
        };
        operations.push(operation);
    },
       
    onSuccessTree: function(operation) {
        var block = this.getBlock('result');
        
        var xmlFilePk=block.down('[name=mrDocType]');
    	if(operation.result.dataList){
    		xmlFilePk.setData(operation.result.dataList);
        }
    	
    }
});
