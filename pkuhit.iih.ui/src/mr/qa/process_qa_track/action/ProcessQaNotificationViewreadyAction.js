/** 
 * 环节质控追踪页面，整改通知列表加载完成后查找到tools上的相关按钮进行事件的监听
 * @author ：cheng_feng
 */

Ext.define('iih.mr.qa.process_qa_track.action.ProcessQaNotificationViewreadyAction', {
	extend: 'Xap.ej.action.Action',
	
	execute: function(context){
		var me = this;
		
	    var owner = this.getOwner();
	    
	    //获取整改通知的 block
		var resultBlock = this.getBlock('result');	
		var inProcessGrid = resultBlock.down('xapgrid');
		
		//已审核（7天内） checkbox   
		var isVerified = resultBlock.down('xapcheckbox[action=isVerified]');
		isVerified.on('change',function(btn){
			context.event.name='change';
			var defectListInitChain = me.getOwner().getActionChain("init");
			defectListInitChain.execute(context);
		});
		
		//开始审核按钮
		var inProcess = inProcessGrid.down('xapbutton[action=inQaWork]');
		inProcess.on('click',function(btn){
			context.event.name='click';
			var inProcessChain = me.getOwner().getActionChain("toProcessQaDefect");
			inProcessChain.execute(context);
		});
	}
	
})