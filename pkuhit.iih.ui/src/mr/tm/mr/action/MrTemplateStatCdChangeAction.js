Ext.define('iih.mr.tm.mr.action.MrTemplateStatCdChangeAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	requires: ['Xap.ej.block.Layer'],

	doExecute: function(context) {
	    this.callParent();
	    //console.log('状态下拉框选择，应该触发查询事件');
	  //获取模板列表的 block
		var block = this.getBlock('result');
		//获取模板列表组件	
		var grid = block.down('mrtemplatelistblock');
		var rs = grid.fireEvent('turnpage',1,25);
		console.log(rs);

	}   
});
