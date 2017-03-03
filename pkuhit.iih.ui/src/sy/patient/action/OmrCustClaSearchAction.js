Ext.define('iih.sy.patient.action.OmrCustClaSearchAction', {
	extend:  Xap.ej.action.ServiceInvocation ,
	
	/*
	* @Override
	*/
	execute: function(context) {
	    this.prepareOperations(context.operations);
    },
    prepareOperations: function(operations) {
        var url = this.url+'?enTypeCd=ENM01.01';
        var operation = {
                url: url,
                method: 'get',
                scope: this,
                success: this.onSuccess
            };
        operations.push(operation);
    },
    onSuccess: function(operation) {
        var block = this.getOwner().getBlock('condition');
     /*   var mrCustClaCd=block.down('[name=mrCategoryCode]');
        var mrTypeCd=block.down('[name=typeCode]');*/
        //为辅助录入赋值 
      /*  var mrDeptCode=block.down('[name=deptCode]');
        var departCode = IMER_GLOBAL.department.code;//登陆科室编码
        mrDeptCode.select(departCode);
        */
        var owner=this.getOwner();	
        var properties = owner.ownerCt.ownerCt.ownerCt.ownerCt.getLayer(Xap.ej.block.Layer.PROPERTIES);
       // mrCustClaCd.setData(operation.result.data.mrTypeCustomCategorys);
  //      mrTypeCd.setData(operation.result.data.mrTypes);
		//树节点选择病历分类编号
        if(properties.data){
        	var ccatCode = properties.data.ccatCode;
        	if(operation.result.data){
                //给病历类型分类赋值
                	var searchTemplateConfig=operation.result.data.searchTemplateConfig;
                	if('1'==searchTemplateConfig){
						//mrCustClaCd.select('MRM14.03');
                		//owner.mrTypeCd='MRM16.18';
                	}else{
						if(ccatCode&&ccatCode!='merge'){
                			//mrCustClaCd.select(ccatCode);
						}else{
							//mrCustClaCd.select('MRM14.09');
						}
                	}
                var result = this.getOwner();
    /*            var initChain = result.getActionChain('init');
                initChain.execute();*/
            }else{
				if(ccatCode&&ccatCode!='merge'){
                	//mrCustClaCd.select(ccatCode);
				}else{
					//mrCustClaCd.select('MRM14.09');
				}
			}
        }else{
        	var searchTemplateConfig=operation.result.data.searchTemplateConfig;
        	if('1'==searchTemplateConfig){
        		//mrCustClaCd.select('MRM14.03');
        		//owner.mrTypeCd='MRM16.18';
        		console.log(createmrblock);
        	}else{
        		//mrCustClaCd.select('MRM14.09');
        	}
        }
    }
});