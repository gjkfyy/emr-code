/** 
 * 环节质控工作查询页面加载完成后查找到tools上的相关按钮进行事件的监听
 * @extends Xap.ej.action.Action
 * @author ：yao_lijie
 */

Ext.define('iih.mr.qa.process_qa_search.action.InProcessWorkViewreadyAction', {
	extend: 'Xap.ej.action.Action',
	
	requires:[],
	      
	execute: function(context){
		var me = this;
		
	    var owner = this.getOwner();
	    
	    //获取工作查询的 block
		var resultBlock = this.getBlock('result');	
		var searchGrid = resultBlock.down('xapgrid');

		//查看按钮
		var look = searchGrid.down('button[method=look]');
		look.on('click',function(btn){
			context.event.name='click';
			var lookChain = me.getOwner().getActionChain("look");
			lookChain.execute(context);
		});
	}
	
})