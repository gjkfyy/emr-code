Ext.define('iih.mr.tm.mr.action.MrCcatCodeChangeAction', {
	extend: 'Xap.ej.action.Action',
	
	/*
	* @Override
	*/
	execute: function(context) {
		var left = this.getBlock('result');
		var view = left.ownerCt;
		//刷新树
		var chainMrTypeCodeInit = view.getActionChain('mrTypeCodeInit');
		chainMrTypeCodeInit.execute();
		
		var chainSearch = view.getActionChain('init');
		chainSearch.execute();
		
	}
});
