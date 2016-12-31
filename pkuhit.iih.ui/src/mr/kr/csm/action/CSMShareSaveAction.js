Ext.define('iih.mr.kr.csm.action.CSMShareSaveAction',{
	extend : 'Xap.ej.action.ServiceInvocation',
	requires:[],
	
	doExecute: function(context) {
		   //this. showLoading();
           this.prepareOperations(context.operations,context);
        },
	 prepareOperations: function(operations,context) {
        	
        	var me = this;
        	var owner = me.getOwner();
        	var dept = me.getBlock('topblock').down('xapcombobox[action=dept]');
        	var deptCodeSrc = dept.value;
        	var deptNameSrc = dept.rawValue;
           
            
        	 var url = this.url;
        	
        	 var deptGrid = me.getBlock('topblock').down('xapgrid[action=deptgrid]');
             var selModel=deptGrid.getSelectionModel();
             var selection = selModel.getSelection();
        	
             var deptDstArr = [];
             for(var i=0;i<selection.length;i++){
            	 deptDstArr.push(selection[i].data);
             }
             
        	var data = {deptCodeSrc:deptCodeSrc,deptNameSrc:deptNameSrc,deptDstArr:deptDstArr};
        	
	        var METHODS = this.getInvocationMethods();
	    	var operation = {
	            url: url,
	    		mclass: null,
	    		method: METHODS.METHOD_CREATE,
	    		condition: null,
	    		scope: this,
	    		data:data,
	    		success: this.onSuccess,
	    	    fail: this.onFailure
	    	};
	    	operations.push(operation);
	    },
	
	onSuccess : function(operation) {
	    	var me = this;
	    	
	    	if(operation.result.data){
	    		
	    		 var shareDeptAction = me.getOwner().getActionChain("shareDeptAction");
	        	 shareDeptAction.execute();
	    		
	    	}else{
	    		XapMessageBox.info('共享失败!');
	    	}
           
	    },
	 onFailure: function(operation) {
	    	XapMessageBox.info('查询失败!');
	    },  
});
