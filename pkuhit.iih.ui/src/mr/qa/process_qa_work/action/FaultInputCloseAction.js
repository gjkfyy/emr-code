/** 
 * 提缺陷画面关闭Action
 * @extends Xap.ej.action.Action
 * @author ：wu_guocheng
 */
Ext.define('iih.mr.qa.process_qa_work.action.FaultInputCloseAction', {
	extend: 'Xap.ej.action.Action',
	requires:[],
    
	execute: function(context){
		
	    var me = this;
		
	    var owner = this.getOwner();
	    
	    var parentOwner = owner.ownerCt;
	    
	    parentOwner.close();
	}
	
})