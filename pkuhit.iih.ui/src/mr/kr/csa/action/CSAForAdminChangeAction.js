 Ext.define('iih.mr.kr.csa.action.CSAForAdminChangeAction', {
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
	   
	   var csaForAdminSearchchain = me.getOwner().getActionChain("csaForAdminsearchAction");
	   csaForAdminSearchchain.execute();
	   
	 
    }
  
});