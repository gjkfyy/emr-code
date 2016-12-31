Ext.define('iih.mr.kr.csm.action.CSMCloseAction', {
	extend: 'Xap.ej.action.Action',
	
	execute: function(context) {
    	this.callParent();
       // var block = this.getBlock('result');
        var win = Ext.getCmp('csakrview').ownerCt;
        win.close();
    }
});
