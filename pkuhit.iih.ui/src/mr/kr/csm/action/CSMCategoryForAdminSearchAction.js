Ext.define('iih.mr.kr.csm.action.CSMCategoryForAdminSearchAction',{
	extend : 'Xap.ej.action.ServiceInvocation',
	requires:[],
	
	
	doExecute: function(context) {
		   //this. showLoading();
           this.prepareOperations(context.operations,context);
        },
	 prepareOperations: function(operations,context) {
        	
        
        	var me = this;
        	var owner = me.getOwner();
        	var url = me.url;
        	var dept = me.getBlock('content').down('xapcombobox[action=dept]');
        	var radios = me.getBlock('content').query('xapradio');
        
        	var ownerCode = dept.value;
        	var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        	properties.data.ownerCode = ownerCode;
        
        	var qs = Ext.Object.toQueryString(properties.data);
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
	    	var grid = me.getBlock('content').down('xapgrid[action=categorygrid]');
	    	var res = operation.result.dataList;
	    	if(res!=null){
	    		grid.setData(res);
	    	}else{
	    		grid.getStore().removeAll();
	    	}
	    	
	    },
	 onFailure: function(operation) {
	    	XapMessageBox.info('查询失败!');
	    },  
});
