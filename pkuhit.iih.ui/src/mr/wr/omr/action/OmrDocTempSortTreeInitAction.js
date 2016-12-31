Ext.define('iih.mr.wr.omr.action.OmrDocTempSortTreeInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	    execute: function(context) {
	        this.prepareOperations(context.operations);
	    },
	    prepareOperations: function(operations,data) {
	         var url = this.url+"?enTypeCode=ENM01.01&dctNsF=1&onlyThisDept=1";
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
	    	 //console.info(operation.result.root.children);
	         var omrTempSortTree=Ext.getCmp('omrTempSortTree');
	         var deptCode="_"+IMER_GLOBAL.department.code;
        	 var bool=true;
	         // TODO 数据格式就这样了？
	         if(omrTempSortTree){
	        	 omrTempSortTree.setData(operation.result.root.children);
	        	 var arr=omrTempSortTree.getRootNode().childNodes;
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
