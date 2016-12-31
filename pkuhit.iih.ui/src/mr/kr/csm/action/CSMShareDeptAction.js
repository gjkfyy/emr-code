Ext.define('iih.mr.kr.csm.action.CSMShareDeptAction',{
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
        	var ownerCode = dept.value;
        	var condition = {
        			enTypeCode:'ENM01.01',
        			ownerType:'MDM08.02',
        			ownerCode:ownerCode
        	};
        	var url = this.url;
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
	    	var block = me.getBlock('topblock');
	    	var res = operation.result.dataList;
	    	var records = new Array();
	    	
            var deptgrid = block.down('xapgrid[action=deptgrid]');
            deptgrid.setData(res);
            var store = deptgrid.getStore();
            var datas = store.getData();
            deptgrid.getSelectionModel().selectAll();
          
            for(var i=0;i<datas.length;i++){
	    		
	    		if(!datas[i].checked){
	    			deptgrid.getSelectionModel().deselect(i);
	    		}
	    	}
           
	    },
	 onFailure: function(operation) {
	    	XapMessageBox.info('查询失败!');
	    }

});
