/** 
 *  唤醒按钮
 * @author ：cheng_feng
 */
Ext.define('iih.mr.qa.qa_reports.action.WakeReportButtonAction', {
extend: 'Xap.ej.action.ServiceInvocation',

	requires: [],
	
	execute: function(context) {

		 var me = this;
		 var contentBlock = this.getBlock('result');
	        
	     var enGrid = contentBlock.down('xapgrid');
	     
	     // 查看按钮
         var checkOut = contentBlock.down('xapgrid xapbutton[action=checkOut]');
        
        // 设置按钮可用
         checkOut.setDisabled(false);
        
        contentBlock.down('xapgrid').refresh();
    }
});