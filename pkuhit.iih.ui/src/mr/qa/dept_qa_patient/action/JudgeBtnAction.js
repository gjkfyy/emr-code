/** 
 * 点击记录，判断按钮状态
 * @author ：yao_lijie
 */
Ext.define('iih.mr.qa.dept_qa_patient.action.JudgeBtnAction', {
	extend: 'Xap.ej.action.Action',
	
	execute: function(context) {
		var block = this.getBlock('result');
		var grid = block.down('xapgrid');
		//科室质控进入科室质控按钮
		var inDept = grid.down('button[method=inDept]');
		inDept.setDisabled(false);
		var back = grid.down('button[name=back]');
		back.setDisabled(false);
	}
});
