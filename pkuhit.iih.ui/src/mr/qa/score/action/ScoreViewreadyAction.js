/** 
 * 评分工作页面加载完成后查找到tools上的相关按钮进行事件的监听
 * @extends Xap.ej.action.Action
 * @author ：wang_yanli
 */

Ext.define('iih.mr.qa.score.action.ScoreViewreadyAction', {

	extend: 'Xap.ej.action.Action',
	
	requires:[],
	      
	execute: function(context){
		var me = this;
		
		var owner = this.getOwner();
		var ownerProperty = this.getOwner().ownerProperty;
		ownerProperty.completed = false;
		//扣分项目 block
		var bottomBlock = this.getBlock('bottom');		
		var dropItemGrid = bottomBlock.down('xapgrid');	
		
		
		//扣分项目-增加-按钮
		var qaScoreItemAdd = bottomBlock.down('button[action=qaScoreItemAdd]');
		qaScoreItemAdd.on('click',function(btn){
			var qaScoreItemAddChain = me.getOwner().getActionChain("qaScoreItemAdd");
			qaScoreItemAddChain.execute(context);
		});
		
		/*//扣分项目-删除-按钮
		var qaScoreItemDelete = bottomBlock.down('xapactioncolumn[name=qaScoreItemDelete]');
		qaScoreItemDelete.on('clickEvent',function(btn){
			XapMessageBox.confirm2(
					'确认删除？',
	   				function(btn){
						if(btn=="yes"){
							var qaScoreItemDeleteChain = me.getOwner().getActionChain("qaScoreItemDelete");
							qaScoreItemDeleteChain.execute(context);
						}
				});
			
		});*/
		
		//扣分项目-完成质控评分-按钮
		var qaScoreComplete = bottomBlock.down('button[action=qaScoreComplete]');
		qaScoreComplete.on('click',function(btn){
			var qaScoreCompleteChain = me.getOwner().getActionChain("qaScoreComplete");
			qaScoreCompleteChain.execute(context);
	    });
	}
})