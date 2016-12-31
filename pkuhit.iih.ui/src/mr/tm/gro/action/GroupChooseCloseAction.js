Ext.define('iih.mr.tm.gro.action.GroupChooseCloseAction', {
	extend: 'Xap.ej.action.Action',
	
	execute: function(context) {
		//点击grid上选中的行，对操作权限进行修改
		console.log('--------------------------- GroupChooseCloseAction ---------------------------------------');
		var owner = this.getOwner().ownerCt;  
	    owner.close();
    }
});
