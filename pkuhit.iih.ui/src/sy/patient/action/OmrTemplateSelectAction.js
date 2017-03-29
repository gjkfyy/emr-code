Ext.define('iih.sy.patient.action.OmrTemplateSelectAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
		var owner=this.getOwner();
		var content = owner.ownerCt.ownerCt.ownerCt;
		var confim=content.down('button[name=confim]');
		confim.setDisabled(false);
	    var rb = this.getBlock('result');
        var grid = rb.down('xapgrid'); 
        var selected=grid.getSelectionModel().getSelection();
        var mrDocNm=selected[0].data.name;
        var mrDocNmText=content.down('[name=mrNm]');
        mrDocNmText.setValue(mrDocNm);
        var mrTypeCode=selected[0].data.mrTypeCode;
        
        var higherLvlEmpId=content.down('[name=higherLvlEmpId]');
        
        if(mrTypeCode=='MRM16.19'||mrTypeCode=='MRM16.20'){//上级医师查房记录
        	var higherLvlEmpNm = higherLvlEmpId.getRawValue();
        	mrDocNmText.setRawValue(higherLvlEmpNm+" "+mrDocNm);
            //设置只读
            //higherLvlEmpId.setDisabled(false);
        }else{
        	//higherLvlEmpId.select('');
            //设置只读
            //higherLvlEmpId.setDisabled(true);
        }
        this.initOrcaleGetDate(context.operations);
    },initOrcaleGetDate: function(operations) {
        var url = 'mr/dataBaseTime';
        var operation = {
            url: url,
            method: 'get',
            scope: this,
            success: this.onSuccess
        };
        operations.push(operation);
    },
    onSuccess: function(operation) {
    	if(operation.result.data.dataBaseTime){/*
    		var owner=this.getOwner();
    		var content = owner.ownerCt.ownerCt.ownerCt;
    		var logicSmtTimeDateFiled=content.down('[name=logicSmtDate]');
            if(logicSmtTimeDateFiled){
            	logicSmtTimeDateFiled.setValue(operation.result.data.dataBaseTime);
            }
    	*/}else{
    		console.log("获取数据库时间出错！");
    	}
        
    }
});
