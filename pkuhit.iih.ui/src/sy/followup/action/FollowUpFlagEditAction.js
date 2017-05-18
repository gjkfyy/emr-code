Ext.define('iih.sy.followup.action.FollowUpFlagEditAction', {
	extend: 'Xap.ej.action.PopAction',

	requires: ['iih.sy.followup.view.FollowUpFlagEditView'],
	defaultConfig: {
	    width: 500,
	    height: 270,
	    layout : 'fit',
	    modal: true
	},	
	/*
	* @Override
	*/
	execute: function(context) {
		var owner = this.getOwner();
		var block = owner.getBlock('right')
        var grid = block.down('xapgrid');
		var select = grid.getSelectionModel().getSelection();
		var patientId = select[0].data.patientId;
		
	    var config = {
    	    modal: true,           
    		width: 500,
    		height:270,
    		title :'更改随访状态',
    		contentConfig: {
    			xtype: 'followupflageditview',
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
	    IMER_GLOBAL.portal.code = IMER_CONSTANT.PORTAL_CD_1003;
	    this.callParent([config]);
    }
});
