
Ext.define('iih.mr.dr.plan.action.ProcessPlanViewreadyAction', {
	extend: 'Xap.ej.action.Action',
	
	requires:[],
	      
	execute: function(context){
		
		var me = this;
		
	    var owner = this.getOwner();
	    
		//获取缺陷一览的 block
		var resultBlock = this.getBlock('result');		
		var conditionGrid = resultBlock.down('xapgrid');
		
		//编辑按钮
		var editRetrieval = resultBlock.down('xapgrid xapbutton[action=editRetrieval]');
		editRetrieval.on('click',function(btn){
			context.event.name='click';
			var editChain = me.getOwner().getActionChain("edit");
			editChain.execute(context);
		});
		
		//删除按钮
		var deleteRetrieval = resultBlock.down('xapgrid xapbutton[action=deleteRetrieval]');
		deleteRetrieval.on('click',function(btn){
    		context.event.name='click';
			var deleteChain = me.getOwner().getActionChain("delete");
			deleteChain.execute(context);
		});
		
	}
	
})