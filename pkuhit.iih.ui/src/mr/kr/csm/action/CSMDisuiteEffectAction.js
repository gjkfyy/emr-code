Ext.define('iih.mr.kr.csm.action.CSMDisuiteEffectAction',{
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
	    	 var bottomblock = me.getBlock('bottomblock');
	    	 var confirmBtn = bottomblock.down('xapbutton[action=confirm]');
	    	 var closeBtn = bottomblock.down('xapbutton[action=close]');
	    	 var res = operation.result.data;
	    	 if(res){
	    		 confirmBtn.setDisabled(false);
	    	 }else{
	    		 confirmBtn.setDisabled(true);
	    		 XapMessageBox.info('该分类下,组套名称不可用!')
	    	 }
	    },
	 onFailure: function(operation) {
	    	XapMessageBox.info('查询失败!');
	    },  
});
