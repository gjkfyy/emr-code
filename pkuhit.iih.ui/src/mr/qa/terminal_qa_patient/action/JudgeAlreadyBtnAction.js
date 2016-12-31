/** 
 * 点击记录，判断按钮状态
 * @author ：yao_lijie
 */
Ext.define('iih.mr.qa.terminal_qa_patient.action.JudgeAlreadyBtnAction', {
	extend: 'Xap.ej.action.Action',
	
	execute: function(context) {
		var block = this.getBlock('result');
		var grid = block.down('xapgrid[name=alreadySignGrid]');
		//终末质控进入终末质控按钮
		var inTerminal = grid.down('button[method=inTerminal]');
		inTerminal.setDisabled(false);
		var back = grid.down('button[name=back]');
		back.setDisabled(false);
	}
});
