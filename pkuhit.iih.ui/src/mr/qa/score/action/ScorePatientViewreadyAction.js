/** 
 * 质控评分页面加载完成后查找到tools上的相关按钮进行事件的监听
 * @extends Xap.ej.action.Action
 * @author ：yao_lijie
 */

Ext.define('iih.mr.qa.score.action.ScorePatientViewreadyAction', {
	extend: 'Xap.ej.action.Action',
	
	requires:[],
	      
	execute: function(context){
		var me = this;
		
	    //获取就诊一览的 block
		var resultBlock = this.getBlock('result');	
		var scoreGrid = resultBlock.down('xapgrid');
		
		//评分按钮
		var score = scoreGrid.down('button[method=score]');
		score.on('click',function(btn){
			context.event.name='click';
			var scoreChain = me.getOwner().getActionChain("score");
			scoreChain.execute(context);
		});
	}
})