Ext.define('iih.sy.userinfo.action.TerminalResetAction', {
	extend: 'Xap.ej.action.Action',
	
	/*
	* @Override
	*/
	execute: function(context) {
    	this.callParent();
    	var param = this.getBlock('condition');
    	var form = param.down('xapform');
    	var deptCd = form.down('comboxgrid[name=deptCd]');
    	deptCd.reset();
    	param.getForm().reset();
    }
});
