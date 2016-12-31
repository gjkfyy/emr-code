Ext.define('iih.mr.kr.csm.action.CSMForAdminSearchAction',{
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
        	var dept = me.getBlock('leftblock').down('xapcombobox[action=dept]');
        	var ownerCode = dept.value;
        	var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        	if(ownerCode!=null){
        		properties.data.ownerCode = ownerCode;
        	}
        	
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
	    	//var tree = me.getBlock('leftblock').down('xaptree[action=csatree]');
	    	var block = me.getBlock('leftblock');
	    	var res = operation.result.dataList;
	    	if(res!=null){
	    		var obj = new Object();
	        	var test = Ext.Object.merge(obj, res);
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
