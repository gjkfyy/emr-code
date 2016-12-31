Ext.define('iih.mr.kr.csm.action.CSMDisuiteDelAction',{
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
        	var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        	var diSuiteCode = properties.data.diSuiteCode;
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
	    	var owner = me.getOwner();
	    	var csmSearch = owner.getActionChain("csmsearchAction");
	 	    csmSearch.execute();
	 	    
	 	    var diGrid = owner.down('xapgrid[action=digrid]');
	 	    var distore = diGrid.getStore();
	    	distore.removeAll();
	    	
	    	
	    	var mrGrid = owner.down('xapgrid[action=mrgrid]');
		 	var mrstore = mrGrid.getStore();
		    mrstore.removeAll();
	    	
	    },
	 onFailure: function(operation) {
	    	XapMessageBox.info('查询失败!');
	    },  
});
