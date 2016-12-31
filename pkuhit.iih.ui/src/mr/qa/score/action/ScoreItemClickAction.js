
/** 
 * 缺陷一览页面删除按钮
 * @extends Xap.ej.action.Action
 * @author ：wang_yanli
 */
Ext.define('iih.mr.qa.score.action.ScoreItemClickAction', {
	extend: 'Xap.ej.action.Action',
	
	requires:['iih.mr.qa.QaStatusGlobal'],
    
	execute: function(context){  
		
		var defectsInBlock = this.getBlock('bottomcontent');
		
		//获取缺陷一览的GRID
		var ScoreItemGrid = defectsInBlock.down('xapgrid');
		
		var ownerProperty = this.getOwner().ownerProperty;
		
		//设置删除按钮不可编辑
		if(!ownerProperty.completed){
			//ScoreItemGrid.down('xapbutton[action=qaScoreItemDelete]').setDisabled(false);return;
		}
			
	}
	
})