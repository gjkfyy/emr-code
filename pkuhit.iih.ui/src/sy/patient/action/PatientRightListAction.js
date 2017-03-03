Ext.define('iih.sy.patient.action.PatientRightListAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	doExecute: function(context) {
		this.showLoading();
    	this.callParent();
    	var id;
    	var rowindex;
        var block = this.getBlock('result');// 当前页面patientLeftListView
    	if(context.event!=undefined){
    		 id = context.event.arguments[1].data.patientId;		//患者ID
    	}else{
    		 id = context.patientId;
    		 block.rowindex = context.rowindex;
    	}
        var operations = context.operations;
    	if(!operations) {
    		 return;
    	}
    	var url = this.url;
    	url += '/'+id +'/no';
    	var operation = {
            url: url,
    		method: 'get',
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.push(operation);
    },
    onSuccess: function(operation) {
        var block = this.getBlock('result');// 当前页面是UserInfoLeftListView
        block = block.getBlock('content'); 
        var m = operation.result;
        // TODO 数据格式就这样了？
        if(m instanceof Ext.data.Model) {
            block.setData({
                mclass: operation.mclass,
                data: m.getData(true)
            });
        } else {
        	var data = {'patientId':'123',
        			'pk':'854883',
        				'amrNo':'12',
        				'patientName':'3',
        				'sexName':'3',
        				'age':'3',
        				'receiveTime':'3',
        				'encounterCount':'3',
        				'paInsurNm':'3',
        				'currentMainDiagnosisName':'3'
        				}
        	var rec = data;
			var workArea = Ext.getCmp('workareapageview');
            var callBack = function(patient){
                var canvas = Xap.getCanvas();
                canvas.fireEvent("updatePatient",{patient:patient});
            };
            workArea.callBack = {
                method: callBack,
                params: [rec]
            };
            var canvas = Xap.getCanvas();
            canvas.fireEvent("portalRender2");
            
            block.setData(m.data);
        }
    }
});
