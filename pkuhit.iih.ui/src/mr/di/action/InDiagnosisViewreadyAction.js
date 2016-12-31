Ext.define('iih.mr.di.action.InDiagnosisViewreadyAction',{
	extend: 'Xap.ej.action.Action',
	
	requires:[],
	      
	execute: function(context){
		var me = this;
		
	    var owner = this.getOwner();

	    //获取诊断一览的 block
		var contentBlock = this.getBlock('content');	
		var grid = contentBlock.down('xapgrid');
		
		//子诊断按钮
		var sonDi = grid.down('button[method=sonDi]');
		sonDi.on('click',function(btn){
			context.event.name='click';
			var sonDiChain = me.getOwner().getActionChain("sonDi");
			sonDiChain.execute(context);
		});
		
		//编辑按钮
		var editDi = grid.down('button[method=editDi]');
		editDi.on('click',function(btn){
			context.event.name='click';
			var editDiChain = me.getOwner().getActionChain("editDi");
			editDiChain.execute(context);
		});
		
		//删除按钮
		var delDi = grid.down('button[method=delDi]');
		delDi.on('click',function(btn){
			context.event.name='click';
			var delDiChain = me.getOwner().getActionChain("delDi");
			delDiChain.execute(context);
		});
		
	}
	
})