Ext.define('iih.mr.qa.process_qa_work.action.QaItmFstSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
		//获取质控项目block
		var block = this.getBlock('content');
		
		var data = {
        	encounterPk:context.encounterPk,
        	mrTypeCode:context.mrTypeCode,
        	mrTypeName:context.mrTypeName,
			mrCreateUserCode:context.mrCreateUserCode,
			mrCreateDeptCode:context.mrCreateDeptCode,
        	mrSegmemtTypeCode:context.mrSegmemtTypeCode,
        	firstCode:context.firstCode,
        	qaTypeCode:context.qaTypeCode//医嘱质控用
        };
        block.data = data;
	    this.prepareOperations(context.operations);
    },
    prepareOperations: function(operations) {
        var url = this.url;
        var operation = {
                url: url,
                method: 'get',
                scope: this,
                success: this.onSuccess
            };
        operations.length = 0;
        operations.push(operation);
    },
    onSuccess: function(operation) {
        var block = this.getBlock('content');
        var mrTypeNameStatus = block.down('[name=mrTypeName]');
        var associateMrCheckBox = block.down('[name=associateMr]');//关联文书checkbox
        var data = block.data;
        var qaItmFst=block.down('[name=qaItmFst]');
        var qaItmSnd=block.down('[name=qaItmSnd]');
        var mrTypeName = data.mrTypeName;
        var mrCreateUserCode = data.mrCreateUserCode;
        var mrCreateDeptCode = data.mrCreateDeptCode;
        var qaTypeCode = data.qaTypeCode;
        var associateMr = true;
        if((mrTypeName == undefined || mrTypeName == '') && (mrTypeNameStatus != null)){
        	associateMr = false;
        	mrTypeNameStatus.setDisabled('true');
        	//如果为医嘱质控，则将checkbox置为不可用
        	if(qaTypeCode == iih.mr.qa.QaStatusGlobal.qaTypeCodeOrder){
        		associateMrCheckBox.setDisabled('true');
        	}
        }
        var setData = {'associateMr':associateMr,'mrTypeName':mrTypeName,'mrCreateUserCode':mrCreateUserCode,'mrCreateDeptCode':mrCreateDeptCode};
        
        if(block){
        	block.setData(setData);
        }else{
        	return;
        }
        
        if(operation.result.data){
            qaItmFst.setData(operation.result.data.qaItmFstCategory);
            qaItmSnd.setData(operation.result.data.qaItmSndCategory);
            if(data.firstCode == '' || data.firstCode == undefined){
            	qaItmFst.selectAt(0);
            }else{
            	qaItmFst.select(data.firstCode);
            }
        }
    }
});
