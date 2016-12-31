/** 
 * 缺陷列表，选择一条缺陷记录后，根据整改通知单的状态唤醒按钮
 * @author ：cheng_feng
 */
Ext.define('iih.mr.qa.process_qa_track.action.WakeDefectButtonAction', {
extend: 'Xap.ej.action.ServiceInvocation',

	requires: [],
	
	execute: function(context) {

		var contentBlock = this.getBlock('result');
		
		var owner = this.getOwner();
	        
	    //获取储存于画面间的参数
	    var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
		
		var noticeStatus = properties.data.revisionStatus;
		
	    if(iih.mr.qa.QaStatusGlobal.revisionNoticeReformed == noticeStatus){
	    	 // 审核通过按钮
//	         var checkPass = contentBlock.down('xapgrid xapbutton[action=checkPass]');
	         // 扣分按钮
//	         var deduction = contentBlock.down('xapgrid xapbutton[action=deduction]');
	         // 再整改按钮
//	         var rectification = contentBlock.down('xapgrid xapbutton[action=rectification]');
	         // 完成本次审核按钮
	         var finishCheck = contentBlock.down('xapgrid xapbutton[action=finishCheck]');
	        
	         if(iih.mr.qa.QaStatusGlobal.revisionNoticeReformed == noticeStatus){
	 	        // 设置按钮可用
//	 	        checkPass.setDisabled(false);
//	 	        deduction.setDisabled(false);
//	 	        rectification.setDisabled(false);
	 	        finishCheck.setDisabled(false);
	         }
	    }
	    
        contentBlock.down('xapgrid').refresh();
        
    }
});