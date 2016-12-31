Ext.define('iih.mr.kr.csa.action.CSASearchAction',{
	extend : 'Xap.ej.action.ServiceInvocation',
	requires:[],
	
	//组套树查询
	doExecute: function(context) {
		   //this. showLoading();
           this.prepareOperations(context.operations,context);
        },
	 prepareOperations: function(operations,context) {
        	
        	var me = this;
        	
        	var radios = me.getBlock('leftblock').query('xapradio');
        	var ownerTypeVal ;
        	var ownerCode;
        	for(var i=0;i<radios.length;i++){
        		
        		 if(radios[i].checked){
        			 ownerTypeVal= radios[i].inputValue;
        			 radios[i].checked = false;
        		 }else{
        			 radios[i].setValue(false);
        			 radios[i].checked = false;
        		 }
        	}
        	
        	if(ownerTypeVal=='MDM08.02'){
        		ownerCode = IMER_GLOBAL.department.code;
        	}else{
        		ownerCode = IMER_GLOBAL.user.code;
        	}
        	
        	var url = this.url;
        	var condition = {
        		 enTypeCode: 'ENM01.01',
        		 ownerType:ownerTypeVal,
        		 ownerCode:ownerCode
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
	    	//var tree = me.getBlock('leftblock').down('xaptree[action=csatree]');
	    	var block = me.getBlock('leftblock');
    		var result = [];
	 		 var model = {
	                 		'text':'通用',
	                 		'expand':true,
	                 		'leaf':true,
	                        'diSuiteCode':null,
	                        'diCode':'*'
	                 	};
	 					
	 	    result.push(model);
	    	var res = operation.result.dataList;
	    	if(res!=null){
		 	    for(var i=0;i< res.length; i++){
		 	    	 result.push(res[i]);
		 	    }
	    	}else{
	    		/*block.removeData();
	    		var diGrid = me.getBlock('rightblock').down('xapgrid[action=digrid]');
	 	    	var distore = diGrid.getStore();
	 	    	distore.removeAll();
	 	    	
		 	   	var mrGrid = me.getBlock('rightblock').down('xapgrid[action=mrgrid]');
	 	    	var mrstore = mrGrid.getStore();
	 	    	mrstore.removeAll();*/
	    	}
	    	var obj = new Object();
        	var test = Ext.Object.merge(obj, result);
        	block.setData(test);
	    	
	    },
	 onFailure: function(operation) {
	    	XapMessageBox.info('查询失败!');
	    },  
});
