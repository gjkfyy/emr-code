Ext.define('iih.mr.wr.mr.action.MrTemplateSelectAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
		var bottom = this.getOwner().ownerCt.getBlock('bottom');
		var confim=bottom.down('button[name=confim]');
		confim.setDisabled(false);
	    var rb = this.getBlock('result');
        var grid = rb.down('xapgrid'); 
        var selected=grid.getSelectionModel().getSelection();
        var mrDocNm=selected[0].data.name;
        var mrDocNmText=bottom.down('[name=mrNm]');
        mrDocNmText.setValue(mrDocNm);
        var mrTypeCode=selected[0].data.mrTypeCode;
        this.initOrcaleGetDate(context.operations);
        var higherLvlEmpId=bottom.down('[name=higherLvlEmpId]');
        
        if(mrTypeCode=='MRM16.19'||mrTypeCode=='MRM16.20'){//上级医师查房记录
        	var higherLvlEmpNm = higherLvlEmpId.getRawValue();
        	mrDocNmText.setRawValue(higherLvlEmpNm+" "+mrDocNm);
            //设置只读
            higherLvlEmpId.setDisabled(false);
        }else if(mrTypeCode=='MRM16.33'||mrTypeCode=='MRM16.30'){
        	//清空上级医师和职称
            higherLvlEmpId.select('');
            //设置只读
        	higherLvlEmpId.setDisabled(true);
        }else{
        	higherLvlEmpId.select('');
            //设置只读
            higherLvlEmpId.setDisabled(true);
        }
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
    	if(operation.result.data.dataBaseTime&&this.getOwner().ownerCt){
    		var bottom = this.getOwner().ownerCt.getBlock('bottom');
            var logicSmtTimeDateFiled=bottom.down('[name=logicSmtDate]');
            logicSmtTimeDateFiled.setValue(operation.result.data.dataBaseTime);
    	}else{
    		console.log("获取数据库时间出错！");
    	}
        
    }
});
