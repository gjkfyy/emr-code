Ext.define('iih.mr.kr.csm.action.CSMDisuiteMrSearchAction',{
	extend : 'Xap.ej.action.ServiceInvocation',
	requires:[],
	
	doExecute: function(context) {
		   //this. showLoading();
           this.prepareOperations(context.operations,context);
        },
	 prepareOperations: function(operations,context) {
        	
        	var me = this;
        	var owner=me.getOwner();
        	var url = me.url;
        	var diSuiteCode = owner.viewConfig.data.diSuiteCode;
        	var ownerType = owner.viewConfig.data.ownerType;
        	
        	   condition = {
            			diSuiteCode: diSuiteCode,
            			ownerType:ownerType
               	 };
               	
        	
        	
           	var qs = Ext.Object.toQueryString(condition);
           	url += '?' + qs;
            var METHODS = this.getInvocationMethods();
	    	var operation = {
	            url: url,
	    		mclass: null,
	    		method: METHODS.METHOD_GET,
	    		condition: null,
	    		scope: this,
	    		success: this.onSuccess,
	    	    fail: this.onFailure
	    	};
	    	operations.push(operation);
	    },
	
	onSuccess : function(operation) {
	    	var me = this;
	    	var block = me.getBlock('topblock');
	    	var mrGrid = block.down('xapgrid[action=mrgrid]');
	    	var res = operation.result.dataList;
	    	mrGrid.setData(res);
	    	mrGrid.getSelectionModel().selectAll();
	    	
	    },
	 onFailure: function(operation) {
	    	XapMessageBox.info('查询失败!');
	    },  
});
