Ext.define('iih.sy.patient.action.PatientEditWinAction', {
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
		var owner = this.getOwner();
	    var block = owner.ownerCt.getBlock('left');
	    var grid = block.down('xapgrid');
		var rb = grid.getSelectionModel().getSelection();
		var patientId = "";
		if(rb.length == 0){
			XapMessageBox.info('请先选择一个患者！');
            return
        }else{
        	patientId = rb[0].data.patientId;
        }	
	    
	    var config = {
    	    modal: true,           
    		width: 1050,
    		height:480,
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
	    IMER_GLOBAL.portal.code = IMER_CONSTANT.PORTAL_CD_1001;
	    this.callParent([config]);
    }
});
