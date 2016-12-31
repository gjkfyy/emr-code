/** 
 * 点击记录，判断按钮状态
 * @author ：yao_lijie
 */
Ext.define('iih.mr.qa.order_qa_patient.action.JudgeBtnAction', {
	extend: 'Xap.ej.action.Action',
	
	execute: function(context) {
		var block = this.getBlock('result');
		var grid = block.down('xapgrid');
		//环节质控进入环节质控按钮
		var inOrder = grid.down('button[method=inOrder]');
		inOrder.setDisabled(false);
	}
});
