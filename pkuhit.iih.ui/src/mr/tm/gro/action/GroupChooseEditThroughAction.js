Ext.define('iih.mr.tm.gro.action.GroupChooseEditThroughAction', {
	extend: 'Xap.ej.action.Action',
	
	execute: function(context) {
		//点击grid上选中的行，对操作权限进行修改
		console.log('--------------------------- GroupChooseEditThroughAction ---------------------------------------');
		var operations = context.operations;
		var owner = this.getOwner().ownerCt.ownerCt.ownerCt;
		var mrDocOdtFile = owner.odtFile;
        var plugin = document.getElementById('iemrEditor');
		plugin.InsertFromString(mrDocOdtFile,0);
		owner.close();
    }
});
