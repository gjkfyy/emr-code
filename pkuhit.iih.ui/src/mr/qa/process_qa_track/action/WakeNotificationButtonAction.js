/** 
 *  整改通知列表，选择一条整改通知记录后，根据整改通知记录的状态唤醒按钮
 * @author ：cheng_feng
 */
Ext.define('iih.mr.qa.process_qa_track.action.WakeNotificationButtonAction', {
extend: 'Xap.ej.action.ServiceInvocation',

	requires: [],
	
	execute: function(context) {

		 var me = this;
		 var contentBlock = this.getBlock('result');
	        
	     var enGrid = contentBlock.down('xapgrid');
	     
	     var selModel = enGrid.getSelectionModel();
	        
	     var record = selModel.getSelection()[0];
	     
	     var noticeStatus = record.data.status;
	     // 开始审核按钮
         var inQaWork = contentBlock.down('xapgrid xapbutton[action=inQaWork]');
        
        // 设置按钮可用
        inQaWork.setDisabled(false);
        
        contentBlock.down('xapgrid').refresh();
    }
});