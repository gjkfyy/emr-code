/** 
 * 点击记录，判断按钮状态
 * @author ：yao_lijie
 */
Ext.define('iih.mr.qa.qa_divide_level.action.JudgeBtnAction', {
	extend: 'Xap.ej.action.Action',
	
	execute: function(context) {
		
		var owner = this.getOwner();
		var block = this.getBlock('content');
		var grid = block.down('xapgrid');
    	var workBlock = owner.up();
    	var groupType = workBlock.groupType;
		//编辑按钮
		var editLevel = grid.down('button[method=editLevel]');
		editLevel.setDisabled(false);
		//删除按钮
		var delLevel = grid.down('button[method=delLevel]');
    	delLevel.setDisabled(false);
	}
});
