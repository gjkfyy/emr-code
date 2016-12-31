Ext.define('iih.mr.kr.csm.action.CSMDisuiteDiSearchAction',{
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
        	var condition = {
        			diSuiteCode: diSuiteCode
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
	    	var diGrid = block.down('xapgrid[action=digrid]');
	    	var res = operation.result.dataList;
	    	diGrid.setData(res);
	    	diGrid.getSelectionModel().selectAll();
	    	
	    	 var disuiteOpAction = me.getOwner().getActionChain("disuiteOpAction");
	    	 disuiteOpAction.execute({type:'1'});
	    	
	    },
	 onFailure: function(operation) {
	    	XapMessageBox.info('查询失败!');
	    },  
});
