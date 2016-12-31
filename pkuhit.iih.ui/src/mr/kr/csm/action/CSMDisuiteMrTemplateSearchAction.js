Ext.define('iih.mr.kr.csm.action.CSMDisuiteMrTemplateSearchAction',{
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
        	
        	var condition = owner.viewConfig;
        	
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
	    	var mrGrid = me.getBlock('topblock').down('xapgrid[action=mrgrid]');
	    	var res = operation.result.dataList;
	    	
	        if(res==null){
	        	XapMessageBox.info('该科室无模板数据!');
	        }else{
	        	mrGrid.setData(res);
	        	
	        }
	    	
	    },
	 onFailure: function(operation) {
	    	XapMessageBox.info('查询失败!');
	    },  
});
