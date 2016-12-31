Ext.define('iih.mr.kr.csm.action.CSMCategoryDelAction',{
	extend : 'Xap.ej.action.ServiceInvocation',
	requires:[],
	
	//组套树查询
	doExecute: function(context) {
		   //this. showLoading();
           this.prepareOperations(context.operations,context);
        },
	 prepareOperations: function(operations,context) {
        	
        	var me = this;
        	var url = me.url;
        	
        	var grid = me.getBlock('content').down('xapgrid[action=categorygrid]');
        	var selModel=grid.getSelectionModel();
        	var sel = selModel.getSelection();
        	var diSuiteTpCds = [];
        	for(var i=0;i<sel.length;i++){
        		diSuiteTpCds.push(sel[i].data.diSuiteTpCd);
        	}
            var  diSuiteTpCdVals= diSuiteTpCds.join(",");
            var condition = {
            		diSuiteTypeCode: diSuiteTpCds
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
	       var category = me.getOwner().getActionChain("categorySearchAction");
	       category.execute();
	    },
	 onFailure: function(operation) {
	    	XapMessageBox.info('删除失败!');
	    },  
});
