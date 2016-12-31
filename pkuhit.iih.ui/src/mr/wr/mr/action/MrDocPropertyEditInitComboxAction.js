Ext.define('iih.mr.wr.mr.action.MrDocPropertyEditInitComboxAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
        this.init(context.operations);
    },
    init: function(operations) {
        var url = this.url+'?deptCd='+IMER_GLOBAL.department.code;
        var operation = {
            url: url,
            method: 'get',
            scope: this,
            success: this.onSuccess
        };
        operations.push(operation);
    },
    onSuccess: function(operation) {
//    	console.log('aaaaaaaa');
//    	console.log(operation.result.data.supDoctors);
    	var mr=this.getOwner().mr;
//    	console.log(mr);
        var block = this.getOwner().getBlock('content');
        var typeCode = mr.typeCode;
        if("MRM16.19"==typeCode||"MRM16.20"==typeCode){
        	var higherLvlEmpId=block.down('[name=higherLvlEmpId]');
            higherLvlEmpId.setReadOnly(false);
            if(operation.result.data.supDoctors){
            	this.getOwner().init=1;
                higherLvlEmpId.setData(operation.result.data.supDoctors);
                higherLvlEmpId.setValue(mr.superiorDoctorId);
            }
        }
        var masterDoctorName=block.down('[name=masterDoctorName]');
        masterDoctorName.setReadOnly(false);
        if(operation.result.data.twoSignLevelDoctors){
        	masterDoctorName.setData(operation.result.data.twoSignLevelDoctors);
        	masterDoctorName.setValue(mr.mastDoctorCd);
        }
        var dirDoctorName=block.down('[name=dirDoctorName]');
        dirDoctorName.setReadOnly(false);
        if(operation.result.data.threeSignLevelDoctors){
        	dirDoctorName.setData(operation.result.data.threeSignLevelDoctors);
        	dirDoctorName.setValue(mr.dirDoctorCd);
        }
    }
});
