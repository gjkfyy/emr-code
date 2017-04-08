Ext.define('iih.sy.patient.action.PatientCreateWinAction', {
	extend: 'Xap.ej.action.PopAction',

	requires: ['iih.sy.patient.view.PatientCreateView'],
	defaultConfig: {
	    width: 1050,
	    height: 480,
	    layout : 'fit',
	    modal: true
	},	
	/*
	* @Override
	*/
	execute: function(context) {
	    var config = {
    	    modal: true,           
    		width: 1050,
    		height:480,
    		title :'新建患者',
    		contentConfig: {
    			xtype: 'patientcreateview'
    		}
    	};
	    
	    this.callParent([config]);
    }
});
