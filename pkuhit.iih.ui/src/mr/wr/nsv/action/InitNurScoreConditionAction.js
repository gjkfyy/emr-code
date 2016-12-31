Ext.define('iih.mr.wr.nsv.action.InitNurScoreConditionAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
	    this.prepareOperations(context.operations);
    },
    prepareOperations: function(operations) {
        var url = this.url+'?doctorNuserFlag=2';
        var operation = {
                url: url,
                method: 'get',
                scope: this,
                success: this.onSuccess
            };
        operations.push(operation);
    },
    onSuccess: function(operation) {
    	console.info(this.url+'?doctorNuserFlag=2');
    	var owner=this.getOwner();
    	var block= owner.getBlock("condition");
        var xapcheckboxgroup=block.down('xapcheckboxgroup[name=all]');
        var checked=xapcheckboxgroup.items.items;
        var mrCustClaCd=block.down('[name=mrCategoryCode]');
        var mrTypeCd=block.down('[name=typeCode]');
        //为辅助录入赋值 
        var mrDeptCode=block.down('[name=deptCode]');
        var departCode = IMER_GLOBAL.department.code;//登陆科室编码
        mrDeptCode.select(departCode);
        if(operation.result.data){
        	if(operation.result.data.mrTypeCustomCategorys&&operation.result.data.mrTypeCustomCategorys.length>0){
        		mrCustClaCd.setData(operation.result.data.mrTypeCustomCategorys);
                  	mrCustClaCd.select('MRM14.22');
                  }
        	}
//        var deselectedEnabled= operation.result.data.deselectedEnabled;
//        checked[0].setValue(deselectedEnabled);
    }
});
