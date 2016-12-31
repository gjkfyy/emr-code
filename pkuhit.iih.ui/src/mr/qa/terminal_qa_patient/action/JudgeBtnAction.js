/** 
 * 点击记录，判断按钮状态
 * @author ：yao_lijie
 */
Ext.define('iih.mr.qa.terminal_qa_patient.action.JudgeBtnAction', {
	extend: 'Xap.ej.action.Action',
	
	execute: function(context) {
		var block = this.getBlock('result');
		var grid = block.down('xapgrid[name=waitSignGrid]');
		//终末审签按钮
		var sign = grid.down('button[method=sign]');
		sign.setDisabled(false);
	}
});
