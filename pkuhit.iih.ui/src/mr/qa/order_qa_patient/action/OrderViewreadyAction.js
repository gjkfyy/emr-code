/** 
 * 环节质控页面加载完成后查找到tools上的相关按钮进行事件的监听
 * @extends Xap.ej.action.Action
 * @author ：yao_lijie
 */

Ext.define('iih.mr.qa.order_qa_patient.action.OrderViewreadyAction', {
	extend: 'Xap.ej.action.Action',
	
	requires:[],
	      
	execute: function(context){
		var me = this;
		
	    var owner = this.getOwner();
	    
	    //获取就诊一览的 block
		var resultBlock = this.getBlock('result');	
		var inOrderGrid = resultBlock.down('xapgrid');

		//进入环节质控按钮
		var inOrder = inOrderGrid.down('button[method=inOrder]');
		inOrder.on('click',function(btn){
			context.event.name='itemdblclick';
			var inOrderChain = me.getOwner().getActionChain("confirmOpen");
			inOrderChain.execute(context);
		});
	}
	
})