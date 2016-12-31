Ext.define('iih.mr.kr.csa.action.CSACloseAction', {
	extend: 'Xap.ej.action.Action',
	
	execute: function(context) {
    	this.callParent();
       // var block = this.getBlock('result');
        var win = Ext.getCmp('csakrview').ownerCt;
        win.close();
    }
});
