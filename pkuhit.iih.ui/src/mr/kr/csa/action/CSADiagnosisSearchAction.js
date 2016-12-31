Ext.define('iih.mr.kr.csa.action.CSADiagnosisSearchAction',{
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
	    	var diGrid = me.getBlock('rightblock').down('xapgrid[action=digrid]');
	    	var res = operation.result.dataList;
	    	diGrid.setData(res);
	    	if(res && res.length>0){
	    		diGrid.getSelectionModel().selectAll();
	    	}
	    	
	    	
	    },
	 onFailure: function(operation) {
	    	XapMessageBox.info('查询失败!');
	    },  
});
