Ext.define('iih.mr.dr.condition_set.action.ConditionSettingInferLeftInitTreeAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

	doExecute: function(context) {
		this.showLoading();
        var operations = context.operations;
        var view = this.getBlock('result').ownerCt;
        var data = {};
        var xmlFilePk = view.ownerCt.down('[name=mrDocType]').value;
        condition = {xmlFilePk:xmlFilePk};
        data.condition = condition;
        this.prepareOperations(operations,data);    
    }, 
    prepareOperations: function(operations,data) {
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
        var noTree = block.down('xaptree');
        var m = operation; 
        if(m instanceof Ext.data.Model) {
        	gridBlock.setData({
                mclass: operation.mclass,
                data: m.getData(true)
            });
        }else {
        	console.log(operation.result);
        	if(operation.result.root.children){
//        		var store = noTree.getStore();
        		block.setData(operation.result.root.children);
        	}else{
        		block.setData(null);
        	}
        }
        noTree.collapseAll();
        /*var ownerCode;
        if(operation.result.data.children && operation.result.data.children.length>0){
        	ownerCode = operation.result.data.children[0].data.ownerCode;
        }*/
//        var view = this.getBlock('result').ownerCt;
//        var properties = view.getLayer(Xap.ej.block.Layer.PROPERTIES);
    }
});
