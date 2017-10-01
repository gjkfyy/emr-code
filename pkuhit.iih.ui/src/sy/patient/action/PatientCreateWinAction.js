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
    		height:580,
    		title :'新建患者',
    		contentConfig: {
    			xtype: 'patientcreateview'
    		}
    	};
	    IMER_GLOBAL.portal.code = IMER_CONSTANT.PORTAL_CD_1001;
	    this.callParent([config]);
    }
});
