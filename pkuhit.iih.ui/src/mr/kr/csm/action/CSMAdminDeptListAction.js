Ext.define('iih.mr.kr.csm.action.CSMAdminDeptListAction',{
	extend : 'Xap.ej.action.ServiceInvocation',
	requires:['iih.mr.kr.csm.action.Util'],
	
	//组套树查询
	doExecute: function(context) {
		   //this. showLoading();
           this.prepareOperations(context.operations,context);
        },
	 prepareOperations: function(operations,context) {
        	
        	var me = this;
        	var url = this.url;
        	var condition = {
        		 enTypeCode: 'ENM01.01'
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
	    	var combox = me.getBlock('leftblock').down('xapcombobox[action=dept]');
	    	var res = operation.result.dataList;
	    	var comdata = [];
	    	for(var i=0;i<res.length;i++){
	 	        	
	 	       var model = {
	                 'text':res[i].deptName,
	                 'value':res[i].deptCode,
	               };
	 	        comdata.push(model);
	 	      }
	    	iih.mr.kr.csm.action.Util.deptArr = comdata;
	    	combox.setData(comdata);
	    	combox.setRawValue(IMER_GLOBAL.department.name);
	    
	    },
	 onFailure: function(operation) {
	    	XapMessageBox.info('查询失败!');
	    },  
});
