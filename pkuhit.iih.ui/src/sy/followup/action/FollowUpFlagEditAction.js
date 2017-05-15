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
	    var config = {
    	    modal: true,           
    		width: 500,
    		height:270,
    		title :'更改随访状态',
    		contentConfig: {
    			xtype: 'followupflageditview'
    		}
    	};
	    IMER_GLOBAL.portal.code = IMER_CONSTANT.PORTAL_CD_1003;
	    this.callParent([config]);
    }
});
