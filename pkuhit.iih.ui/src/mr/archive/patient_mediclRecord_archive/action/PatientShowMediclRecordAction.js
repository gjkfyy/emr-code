Ext.define('iih.mr.archive.patient_mediclRecord_archive.action.PatientShowMediclRecordAction', {
	extend: 'Xap.ej.action.PopAction',

	requires: ['iih.mr.archive.patient_mediclRecord_archive.view.MediclRecordView'],
	

	execute: function(context) {
		this.getOwner().pk=context.event.arguments[1].data.pk;
	        var config = {
                modal: true,           
                width: 980,
                height:640,
                title :'病历列表',
                contentConfig: {
                    xtype: 'mediclrecordview',
                    initChain: {
                        name: 'search'
                    }
                }
            };
	    
    	
    	this.callParent([config]);
    }
});
