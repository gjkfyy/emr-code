Ext.define('iih.mr.wr.mr.action.ShowSyqyCompAction', {
	extend: 'Xap.ej.action.PopAction',

	requires: ['iih.mr.wr.mr.view.SyqyFingerPrintView'],
	/*
	* @Override
	*/
	execute: function(context) {
    	var config = {
    	    modal: true, 
    		width: 0,
    		height:0,
    		title :'指纹录入插件',
    		closable: false,
    		contentConfig: {
    			xtype: 'syqyfingerprintview',
    			initChain: {
    				name: 'init',
    				context:context
    			}
    		}
    	};
    	this.callParent([config]);
    }
});
