Ext.define('iih.po.com.action.SelectPatientAction', {
	extend: 'Xap.ej.action.Action',
	
	requires: [],
	
	/*
	* @Override
	*/
	execute: function(context) {
	    //切换患者
        var event = context.event;
        var patient;
        if(event) {
            var args = event.arguments;
            var node = args[1];
            patient = node.raw;
            var canvas = Xap.getCanvas();
            canvas.fireEvent("updatePatient",{patient:patient});
            this.getOwner().ownerCt.close();
        }else{
            patient = context.patient;
            var canvas = Xap.getCanvas();
            canvas.fireEvent("updatePatient",{patient:patient});
        };
    }
});