Ext.define('iih.mr.wr.mr.action.MrDocTempSortTreeInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	    execute: function(context) {
	    	//var enTypeCode = IMER_GLOBAL.department.code;
	    	//console.info(IMER_GLOBAL);
	    	//var data={"enTypeCode":enTypeCode,"dctNsF":1,"onlyThisDept":1};
	        this.prepareOperations(context.operations);
	    },
	    prepareOperations: function(operations,data) {
	         var url = this.url+"?enTypeCode=ENM01.04&dctNsF=1&onlyThisDept=1";
	         var operation = {
	             url: url,
	             method: 'get',
	             scope: this,
	            // param:data,
	             success: this.onSuccess
	         };
	         operations.push(operation);
	     },
	     onSuccess: function(operation) {
	    	// console.info(operation.result.root.children);
	         var mrTempSortTree=Ext.getCmp('mrTempSortTree');
	         // TODO 数据格式就这样了？
	         if(mrTempSortTree){
	        	 var deptCode="_"+IMER_GLOBAL.department.code;
	        	 var bool=true;
	        	 mrTempSortTree.setData(operation.result.root.children);
	        	 var arr=mrTempSortTree.getRootNode().childNodes;
	        	 if(arr.length>0){
	        		 for (var i = 0; i < arr.length; i++) {
	        			 if(arr[i].internalId==deptCode){
	        				 arr[i].expand();
	        				 bool=false;
	        			 }
					}
	        		if(bool){arr[0].expand();}
	        	 }
	         }
	     }
});
