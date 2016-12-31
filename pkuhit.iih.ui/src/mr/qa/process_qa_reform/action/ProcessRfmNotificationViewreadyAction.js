/** 
 * 环节整改通知页面（住院医生站），整改通知列表加载完成后查找到tools上的相关按钮进行事件的监听
 * @author ：yao_lijie
 */

Ext.define('iih.mr.qa.process_qa_reform.action.ProcessRfmNotificationViewreadyAction', {
	extend: 'Xap.ej.action.Action',
	
	requires:[],
	      
	execute: function(context){
		var me = this;
		
	    var owner = this.getOwner();
	    
	    //获取整改通知的 block
		var resultBlock = this.getBlock('content');	
		var inProcessGrid = resultBlock.down('xapgrid');

		//开始整改按钮
		var stertRfm = inProcessGrid.down('xapbutton[action=stertRfm]');
		stertRfm.on('click',function(btn){
			context.event.name='click';
			var inProcessChain = me.getOwner().getActionChain("stertRfm");
			inProcessChain.execute(context);
		});
	}
	
})