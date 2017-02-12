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
        var m = operation.result;
        // TODO 数据格式就这样了？
        if(m instanceof Ext.data.Model) {
            block.setData({
                mclass: operation.mclass,
                data: m.getData(true)
            });
        } else {
            block.setData(m.data);
        }
    }
});
