 Ext.define('iih.mr.kr.csa.action.CSAViewreadyAction', {
	extend: 'Xap.ej.action.Action',
	requires:[
	          'Xap.ej.element.field.Checkbox',
	          'Xap.ej.action.PopAction',
	          ],
	/*
	* @Override
	*/
	execute: function(context) {
	   
	   var me = this;
	   var owner=me.getOwner();	
	   var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
	   
	  /* var deptListchain = me.getOwner().getActionChain("csaAdminDeptListAction");
	   deptListchain.execute();*/
	   
	   var csaSearchchain = me.getOwner().getActionChain("csasearchAction");
	   csaSearchchain.execute();
	   
	   //var csaSysdatechain = me.getOwner().getActionChain("csaSysdateAction");
	   //csaSysdatechain.execute();
	   
	  
    }
  
});