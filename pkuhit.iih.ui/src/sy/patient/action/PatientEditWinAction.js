Ext.define('iih.sy.patient.action.PatientEditWinAction', {
	extend: 'Xap.ej.action.PopAction',

	requires: ['iih.sy.patient.view.PatientCreateView'],
	defaultConfig: {
	    width: 1050,
	    height: 500,
	    layout : 'fit',
	    modal: true
	},	
	/*
	* @Override
	*/
	execute: function(context) {
		var owner = this.getOwner();
	    var block = owner.getBlock('right');
	    var patientId = block.down('xaptextfield[name=patientId]').getValue();
	    var config = {
    	    modal: true,           
    		width: 1050,
    		height:500,
    		title :'编辑患者',
    		contentConfig: {
    			xtype: 'patientcreateview',
    			initChain: {
                     name: 'init',
                     context: {
                         customerData: 'edit',
                         patientId :patientId,
                         sourceView: block
                     }
                 }
    		}
    	};
	    
	    this.callParent([config]);
    }
});
