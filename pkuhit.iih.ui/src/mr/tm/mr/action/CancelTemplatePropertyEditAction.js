Ext.define('iih.mr.tm.mr.action.CancelTemplatePropertyEditAction', {
	extend: 'Xap.ej.action.Action',
	
	/*
	* @Override
	*/
	execute: function(context) {
	   /*先找到block，然后找到他的父层节点 关闭窗口
       var rs = this.getBlock('result').ownerCt.ownerCt; 
       //点击取消关闭窗口
       rs.close();
       */
       //关闭窗口
       var owner = this.getOwner().ownerCt;  
       owner.close();
    }
});
