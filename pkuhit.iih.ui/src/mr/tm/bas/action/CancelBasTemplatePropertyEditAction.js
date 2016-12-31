Ext.define('iih.mr.tm.bas.action.CancelBasTemplatePropertyEditAction', {
	extend: 'Xap.ej.action.Action',
	
	/*
	* @Override
	*/
	execute: function(context) {
       //关闭窗口
       var owner = this.getOwner().ownerCt;  
       owner.close();
    }
});
