Ext.define('iih.mr.kr.csm.action.CSMSearchAction',{
	extend : 'Xap.ej.action.ServiceInvocation',
	requires:[],
	
	//组套树查询
	doExecute: function(context) {
		   //this. showLoading();
           this.prepareOperations(context.operations,context);
        },
	 prepareOperations: function(operations,context) {
        	
        	var me = this;
        	var owner = me.getOwner();
        	var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        
        	var url = this.url;
        	
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
	    	//var tree = me.getBlock('leftblock').down('xaptree[action=csmtree]');
	    	var block = me.getBlock('leftblock');
	    	var res = operation.result.dataList;
	    	if(res!=null){
	    		var result = [];
		 	    for(var i=0;i< res.length; i++){
		 	    	 result.push(res[i]);
		 	    }
		    	var obj = new Object();
	        	var test = Ext.Object.merge(obj, result);
	        	block.setData(test);
	    	}else{
	    		block.removeData();
	    		var diGrid = me.getBlock('rightblock').down('xapgrid[action=digrid]');
	 	    	var distore = diGrid.getStore();
	 	    	distore.removeAll();
	 	    	
		 	   	var mrGrid = me.getBlock('rightblock').down('xapgrid[action=mrgrid]');
	 	    	var mrstore = mrGrid.getStore();
	 	    	mrstore.removeAll();
	 	    	
	    	}
	    	
	    	
	    },
	 onFailure: function(operation) {
	    	XapMessageBox.info('查询失败!');
	    },  
});
