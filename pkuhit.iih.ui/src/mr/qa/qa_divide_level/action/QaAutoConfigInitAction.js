Ext.define('iih.mr.qa.qa_divide_level.action.QaAutoConfigInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	isMrConfig:'',
	execute: function(context) {
		var owner = this.getOwner();
		var block = this.getBlock('content');
		var data = context.qaItmData;
		block.data = data;
		var qaItmCd = context.qaItmCd;
		isMrConfig = context.isMrConfig; 
		var operations = context.operations;
    	if(!operations) {
    		return;
    	}
		this.prepareOperations(operations,qaItmCd);
	},
    
    prepareOperations: function(operations,qaItmCd) {
		var url = this.url + '?qaItmCd=' + qaItmCd;
    	var operation = {
            url: url ,
    		mclass: null,
    		method: 'get',
    		condition: null,
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.length = 0;
    	operations.push(operation);
    },

    onSuccess: function(operation) {
    	var owner = this.getOwner();
        var block = this.getBlock('content');
        var qaItmTpCd = block.down('xapcombobox[name=qaItmTpCd]').value;
        var timeAuto = block.down('xapform[name=timeAuto]');
        var frequencyAuto = block.down('xapform[name=frequencyAuto]');
        var integrityAuto = block.down('xapform[name=integrityAuto]');
        var dependentAuto = block.down('xapform[name=dependentAuto]');
        var itmData = block.data;
        var m = operation.result;
        var mrTypes = m.mrTypes;
        var jobTitleCd = m.jobTitleCd;
        var eventTypeCode = m.eventTypeCode; //事件类型
        if(m.qaItmConfigCd == null){
        	if(isMrConfig){
            	m.req = itmData.name;
            	m.qaItmCd = itmData.code;
        	}else{
            	m.req = itmData.req;
            	m.qaItmCd = itmData.qaItmCd;
        	}

        }
        var deadHours = m.deadHours;
        if(deadHours > 24){
        	deadHours = deadHours/24;
        	m.deadHours = deadHours;
        	m.unit ='day';
        }else{
        	m.unit ='time';
        }
        if(mrTypes != null){
        	var comValue = m.mrTypes.split(',')
        }
        if(jobTitleCd != null){
        	var jobTlCdComValue = m.jobTitleCd.split(',')
        }
        // TODO 数据格式就这样了？
        if(m instanceof Ext.data.Model) {
            block.setData({
                mclass: operation.mclass,
                data: m.getData(true)
            });
        }
        else {
        	if(qaItmTpCd == 'QAM06.02'){
        		timeAuto.setData(m);
        		var mrTypes = timeAuto.down('xapcombobox[name=mrTypes]');
        		mrTypes.setValue(comValue);
        	}else if(qaItmTpCd == 'QAM06.05'){
        		if(m.qaRlTpCd == '01'){
        			m.repNum = m.qaRlCd;
        		}else{
        			m.conNum = m.qaRlCd;
        		}
        		frequencyAuto.setData(m);
        		var mrTypes = frequencyAuto.down('xapcombobox[name=mrTypes]');
        		mrTypes.setValue(comValue);
        	}else if(qaItmTpCd == 'QAM06.04'){
        		integrityAuto.setData(m);
        		var mrTypes = integrityAuto.down('xapcombobox[name=mrTypes]');
        		mrTypes.setValue(comValue);
        		var jobTitleCd = integrityAuto.down('xapcombobox[name=jobTitleCd]');
        		if(jobTlCdComValue == undefined){
        			jobTitleCd.selectAt(0);
        		}else{
        			jobTitleCd.setValue(jobTlCdComValue);
        		}
        		var eventTypeCode = integrityAuto.down('xapcombobox[name=eventTypeCode]');
        		if(isMrConfig){
        			eventTypeCode.setDisabled(true);
        		}else{
        			eventTypeCode.setDisabled(false);
        		}
        	}else if(qaItmTpCd == 'QAM06.03'){
        		dependentAuto.setData(m);
        		var mrTypes = dependentAuto.down('xapcombobox[name=mrTypes]');
        		mrTypes.setValue(comValue);
        		var mrOpType = dependentAuto.down('xapcombobox[name=mrOpType]');
        		if(isMrConfig){
        			mrOpType.setDisabled(false);
        		}else{
        			mrOpType.setDisabled(true);
        		}
        	}
        	console.log(m);
        }
    }
});
