Ext.define('iih.mr.tm.gro.action.GroupChooseEditCancelBtnAction', {
	extend: 'Xap.ej.action.Action',
	
	execute: function(context) {
		//点击grid上选中的行，对操作权限进行修改
		console.log('--------------------------- GroupChooseEditCancelBtnAction ---------------------------------------');
		var owner = this.getOwner().ownerCt;
		var layout = owner.getLayout();
	    layout.setActiveItem(0);
    }
});
