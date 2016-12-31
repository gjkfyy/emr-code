Ext.define('iih.po.assistant.action.PersonKnowledgePrapareDataAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	execute: function(context) {
		var owner=this.getOwner();
        var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
		var parentView = properties.data.parentView;
		
		var rb = parentView.getBlock('west');
		var grid = rb.down('xapgrid'); 
		//得到当前选中行
		var selected=grid.getSelectionModel().getSelection();
		var fragmentTplCd = selected[0].data.fragmentTplCd;
		//查询选中知识库详细信息
	    this.prepareOperations(context.operations,fragmentTplCd);
    },
    prepareOperations: function(operations,fragmentTplCd) {
        var url = 'knowledge';
        url += '/' + fragmentTplCd;       
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            method: METHODS.METHOD_GET,
            condition: null,
            scope: this,
            success: this.onSuccess
        };
        operations.push(operation);
    },
    onSuccess: function(operation) {
    	//得到返回结果，赋值
    	var data = operation.result.data;
    	var owner =this.getOwner();
		var form = owner.down('xapform'); 
		form.getForm().setValues(data);
    } 
});