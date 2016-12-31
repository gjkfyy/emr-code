Ext.define('iih.mr.tm.fr.action.FrTplProEditCancelAction', {
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
