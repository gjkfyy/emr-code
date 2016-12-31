Ext.define('iih.mr.wr.omr.action.OmrPrintOpLogAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    /*
     * @Override
     */
    execute: function(context) {   
    	var owner = this.getOwner();
		var block = this.getBlock('content');
		var enPk=IMER_GLOBAL.encounterSn;
		var patientId = IMER_GLOBAL.patientId;
		var encounterCount = IMER_GLOBAL.encounterCount;
		var printDoctorCd = IMER_GLOBAL.user.code;
		var mrPk = owner.mrSn;
        var operations = context.operations;
        if(!operations) {
     		return;
	    }
        var data = {};
        data.enPk =enPk;
        data.paId =patientId;
        data.enCnt =encounterCount;
        data.printDoctorCd =printDoctorCd;
        data.mrPk=mrPk;
        this.prepareOperations(operations,data);
    },
    prepareOperations: function(operations,data) {
        var url = this.url;
        var mclass = null;
        var METHODS = this.getInvocationMethods();
    	var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_CREATE,
            condition: null,	
            data:data,
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.length = 0;
    	operations.push(operation);
    },
    onSuccess: function(operation) {
    	console.log('门诊打印日志插入成功');
    }
});
