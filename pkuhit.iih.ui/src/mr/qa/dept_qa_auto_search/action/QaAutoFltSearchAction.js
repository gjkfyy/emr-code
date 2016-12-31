Ext.define('iih.mr.qa.dept_qa_auto_search.action.QaAutoFltSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
		var owner = this.getOwner();
	    var patientRecord = owner.patientRecord;
	    var enStaCd = owner.enStaCd;
	    patientRecord.enStaCd = enStaCd;
	    var block = this.getBlock('result');
	    var grid = block.down('xapgridblock');
	    grid.setTitle('['+patientRecord.nm+'] 自动质控缺陷项');
	    var pageNum,pageSize;
		if(context.event == undefined){
			pageNum = context.pageNum; 
			pageSize = context.pageSize; 
		}else{
			pageNum = context.event.arguments[0]; 
			pageSize = context.event.arguments[1]; 
		}
		block.pageSize = pageSize;
		patientRecord.pageNum = pageNum;
		patientRecord.pageSize = pageSize;
    	var operations = context.operations;
    	if(!operations) {
    		return;
    	}
    	this.prepareOperations(operations,patientRecord);
    },
    
    prepareOperations: function(operations,patientRecord) {
        var block = this.getBlock('result');
        var conditionBlock = this.getBlock('condition');
    	var condition = conditionBlock.getData();
        var url = this.url;
        if(condition) {
            var qs = Ext.Object.toQueryString(condition);
            if(patientRecord.pageSize == undefined || typeof(patientRecord.pageSize)=='object'){
        		if(qs) {
        			url += '?' + qs + '&currentManageDoctorId='+patientRecord.currentManageDoctorId +'&deptCd='+ patientRecord.deptCd + '&enStaCd='+ patientRecord.enStaCd ;
        		}else{
        			url += '?' + 'currentManageDoctorId='+patientRecord.currentManageDoctorId +'&deptCd='+ patientRecord.deptCd+ '&enStaCd=' +patientRecord.enStaCd;
        		}
        	}else{
        		if(qs) {
            		url += '?' + qs + '&currentManageDoctorId='+patientRecord.currentManageDoctorId +'&deptCd='+ patientRecord.deptCd + '&enStaCd='+ patientRecord.enStaCd +"&pageNum="+ patientRecord.pageNum +"&pageSize="+ patientRecord.pageSize;
        		}else{
        			url +='?' + 'currentManageDoctorId='+patientRecord.currentManageDoctorId +'&deptCd='+ patientRecord.deptCd + '&enStaCd=' +patientRecord.enStaCd + "&pageNum="+ patientRecord.pageNum +"&pageSize="+ patientRecord.pageSize;
        		}
        	}
//            url += '?' + qs + '&currentManageDoctorId='+patientRecord.currentManageDoctorId +'&deptCd='+ patientRecord.deptCd;
        }
            	
        var mclass = null;
        if(block.getModelClass) {
            mclass = block.getModelClass();
        }
    	var operation = {
            url: url,
    		mclass: mclass,
    		method: 'get',
    		condition: condition,
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.length = 0;
    	operations.push(operation);
    },

    onSuccess: function(operation) {
        var block = this.getBlock('result');
        if(block){
	        var pageSize = block.pageSize;
	        var m = operation.result;
	        m.pageSize = pageSize;
	        // TODO 数据格式就这样了？
	        if(m instanceof Ext.data.Model) {
	            block.setData({
	                mclass: operation.mclass,
	                data: m.getData(true)
	            });
	        }
	        else {
	        	block.setData(m);
	        	console.log(m);
	        }
        }
    }
});
