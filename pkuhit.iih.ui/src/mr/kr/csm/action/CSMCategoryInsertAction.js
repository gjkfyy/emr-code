Ext.define('iih.mr.kr.csm.action.CSMCategoryInsertAction',{
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
        	var owner = me.getOwner();
        
        	var diSuiteTypeName = me.getBlock('content').down('xaptextfield[action=categoryNm]').getValue();

        	var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        	var condition = {
           		 enTypeCode: properties.data.enTypeCode,
           		 ownerType: properties.data.ownerType,
           		 ownerCode: properties.data.ownerCode,
           		 diSuiteTypeName:diSuiteTypeName
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
	    	XapMessageBox.info('查询失败!');
	    },  
});
