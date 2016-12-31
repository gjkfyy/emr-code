/** 
 * ：
 * @author ：wang_yanli
 */
Ext.define('iih.mr.qa.process_qa_work.action.CheckAssociateMrAction', {
extend: 'Xap.ej.action.Action',
	
	
	/*
	* @Override
	*/
	execute: function(context) {
		
		 var me = this;
		 var block = this.getBlock('content');
         var associateMr = block.down('[name=associateMr]');
         var mrTypeNameStatus = block.down('[name=mrTypeName]');
         if(associateMr.checked){
         
         	mrTypeNameStatus.setDisabled(false);
         }else{
        	 mrTypeNameStatus.setDisabled(true);
         }
    }
});