/** 
 * 病案等级设置页面加载完成后查找到tools上的相关按钮进行事件的监听
 * @extends Xap.ej.action.Action
 * @author ：yao_lijie
 */

Ext.define('iih.mr.qa.qa_divide_level.action.QaDivideLevelViewreadyAction', {
	extend: 'Xap.ej.action.Action',
	
	requires:[],
	      
	execute: function(context){
		var me = this;
	    
	    //获取病案等级一览的 block
		var contentBlock = this.getBlock('content');	
		var grid = contentBlock.down('xapgrid');

		//新增按钮
		var addLevel = grid.down('button[method=addLevel]');
		addLevel.on('click',function(btn){
			context.event.name='addClick';
			var addLevelChain = me.getOwner().getActionChain("addLevel");
			addLevelChain.execute(context);
		});
		
		/*//编辑按钮
		var editLevel = grid.down('button[method=editLevel]');
		editLevel.on('click',function(btn){
			context.event.name='editClick';
			var editLevelChain = me.getOwner().getActionChain("editLevel");
			editLevelChain.execute(context);
		});*/
		
		/*//删除按钮
		var delLevel = grid.down('button[method=delLevel]');
		delLevel.on('click',function(btn){
			XapMessageBox.confirm2 (
			'确认删除？',
			function(btn){
				if(btn == 'yes'){
					context.event.name='click';
					var delLevelChain = me.getOwner().getActionChain("delLevel");
					delLevelChain.execute(context);
				}
			});
			
		});*/
	}
	
})