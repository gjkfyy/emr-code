Ext.define('iih.mr.wr.mr.action.MrShowLoginWinAction', {
	extend: 'Xap.ej.action.PopAction',

	requires: ['iih.mr.wr.mr.view.MrLoginWinView'],
	/*
	* @Override
	*/
	execute: function(context) {
		var plugin = document.getElementById('iemrEditor');
        plugin.EnableOCX(false);
		var mrdoceditView = this.getOwner();
    	var config = {
    	    modal: true, 
    		width: 280,
    		height:180,
    		title :'上级医师登录',
    		closable:false,
    		contentConfig: {
    			xtype: 'mrloginwinview',
    			mrdoceditView:mrdoceditView,
    			mastDoctorCd:context.mastDoctorCd,
				code:context.code,
				deptCd:context.deptCd,
    			initChain: {
    				name: 'init',
    				context:context
    			}
    		}
    	};
    	this.callParent([config]);
    }
});
