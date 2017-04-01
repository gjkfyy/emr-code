Ext.define('iih.sy.patient.action.PatientRightListAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	doExecute: function(context) {
        var block = this.getBlock('condition');// 当前页面patientLeftListView
        var operations = context.operations;
        var block2 = this.getBlock('result');// 当前页面patientLeftListView
        var grid2=block2.down('xapgrid');
        // 当前页面patientLeftListView
        var grid=block.down('xapgrid');
		var select = grid.getSelectionModel().getSelection();
		var id = select[0].data.patientId;
		 
		var data = {'pk':id}
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
	    
	    //刷新右侧已写的病历
	    
    }
});
