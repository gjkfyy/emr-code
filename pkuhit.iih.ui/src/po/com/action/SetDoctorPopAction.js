Ext.define('iih.po.com.action.SetDoctorPopAction', {
	extend: 'Xap.ej.action.PopAction',

	requires: ['iih.po.com.view.SetDoctorPopView'],
	
	/*
	* @Override
	*/
	execute: function(context) {
	    var parent = context.parent;
	    var patient = context.patient;
    	var config = {
    	    modal: true,           
    		width: 650,
    		height:150,
    		title :'三级医师设置',
    		contentConfig: {
    			xtype: 'setdoctorpopview',
    			initChain: {
                    name: 'init',
                    context: {
                        patient: patient
                    }
                }
    		}
    	};
    	this.callParent([config]);
    }
});
