/** 
 * 点击记录，判断按钮状态
 * @author ：yao_lijie
 */
Ext.define('iih.mr.qa.process_qa_search.action.JudgeBtnAction', {
	extend: 'Xap.ej.action.Action',
	
	execute: function(context) {
		var block = this.getBlock('result');
		var grid = block.down('xapgrid');
		//查看按钮
		var look = grid.down('button[method=look]');
		look.setDisabled(false);
	}
});
