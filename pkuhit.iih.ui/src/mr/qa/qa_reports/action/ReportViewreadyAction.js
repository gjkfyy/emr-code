/** 
 * 列表加载完成后查找到tools上的相关按钮进行事件的监听
 * @author ：cheng_feng
 */

Ext.define('iih.mr.qa.qa_reports.action.ReportViewreadyAction', {
	extend: 'Xap.ej.action.Action',
	
	execute: function(context){
		var me = this;
		
	    var owner = this.getOwner();
	    
		var resultBlock = this.getBlock('result');	
		var inProcessGrid = resultBlock.down('xapgrid');
		
		//查看按钮
		var inProcess = inProcessGrid.down('xapbutton[action=checkOut]');
		inProcess.on('click',function(btn){
			context.event.name='click';
			var inProcessChain = me.getOwner().getActionChain("toReport");
			inProcessChain.execute(context);
		});
	}
	
})