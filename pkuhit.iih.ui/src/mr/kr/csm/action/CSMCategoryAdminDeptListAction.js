Ext.define('iih.mr.kr.csm.action.CSMCategoryAdminDeptListAction',{
	extend : 'iih.mr.kr.csm.action.CSMAdminDeptListAction',
	requires:[],
	onSuccess : function(operation) {
	    	var me = this;
	    	var combox = me.getBlock('content').down('xapcombobox[action=dept]');
	    	var res = operation.result.dataList;
	    	var comdata = [];
	    	for(var i=0;i<res.length;i++){
	 	        	
	 	       var model = {
	                 'text':res[i].deptName,
	                 'value':res[i].deptCode,
	               };
	 	        comdata.push(model);
	 	      }
	    	
	    	combox.setData(comdata);
	    	combox.setRawValue(IMER_GLOBAL.department.name);
	    
	    }
 
});
