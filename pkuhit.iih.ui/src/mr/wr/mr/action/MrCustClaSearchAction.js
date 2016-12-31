Ext.define('iih.mr.wr.mr.action.MrCustClaSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
	    this.prepareOperations(context.operations);
    },
    prepareOperations: function(operations) {
        var url = this.url+'?enTypeCd=ENM01.04&encounterPk='+IMER_GLOBAL.encounterSn;
        var operation = {
                url: url,
                method: 'get',
                scope: this,
                success: this.onSuccess
            };
        operations.push(operation);
    },
    onSuccess: function(operation) {
    	console.info(this.url+'?enTypeCd=ENM01.04&encounterPk='+IMER_GLOBAL.encounterSn);
    	var owner=this.getOwner();
    	var block= owner.getBlock("condition");
        var xapcheckboxgroup=block.down('xapcheckboxgroup[name=all]');
        var checked=xapcheckboxgroup.items.items;
        //console.info(deselectedEnabled);
        var mrCustClaCd=block.down('[name=mrCategoryCode]');
        var mrTypeCd=block.down('[name=typeCode]');
        //为辅助录入赋值 
        var mrDeptCode=block.down('[name=deptCode]');
        var departCode = IMER_GLOBAL.department.code;//登陆科室编码
        mrDeptCode.select(departCode);
        var properties = owner.ownerCt.getLayer(Xap.ej.block.Layer.PROPERTIES);
		//树节点选择病历分类编号
		var ccatCode = properties.data.ccatCode;
        if(operation.result.data){
        	if(operation.result.data.mrTypeCustomCategorys&&operation.result.data.mrTypeCustomCategorys.length>0){
        		mrCustClaCd.setData(operation.result.data.mrTypeCustomCategorys);
        		  if(ccatCode==''){
                  	mrCustClaCd.select('MRM14.02');
                  }else{
                  	mrCustClaCd.select(ccatCode);
                  }
        	}
            if(operation.result.data.mrTypes){
            	mrTypeCd.setData(operation.result.data.mrTypes);
            }
            var deselectedEnabled= operation.result.data.deselectedEnabled;
            checked[0].setValue(deselectedEnabled);
            //给病历类型分类赋值
//            if(ccatCode==''){
//            	mrCustClaCd.select('MRM14.02');
//            }else{
//            	mrCustClaCd.select(ccatCode);
//            }
            //var result = this.getOwner();
            //var initChain = result.getActionChain('init');
            //initChain.execute();
        }

    }
});
