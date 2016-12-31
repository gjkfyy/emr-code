Ext.define('iih.masterdata.dataelement.dimensionvalue.action.DictDataViewreadyAction', {
	extend: 'Xap.ej.action.Action',
	
	execute: function(context){
		var me = this;
	    var owner = this.getOwner();
		var resultBlock = this.getBlock('result');	
		
/*		//启用 checkbox   
		var isActivated = resultBlock.down('xapcheckbox[action=isActivated]');
		isActivated.on('change',function(btn){
			context.event.name='change';
			var dictInitChain = me.getOwner().getActionChain("init");
			dictInitChain.execute(context);
		});
		*/
		//新建按钮   
		var create = resultBlock.down('xapbutton[action=create]');
		create.on('click',function(btn){
			context.event.name='click';
			var createChain = me.getOwner().getActionChain("create");
			createChain.execute(context);
		});
		
        // 编辑按钮
		var edit = resultBlock.down('xapbutton[action=edit]');
		edit.on('click',function(btn){
			context.event.name='click';
			var editChain = me.getOwner().getActionChain("edit");
			editChain.execute(context);
		});
		
        // 删除按钮
        var deleted = resultBlock.down('xapbutton[action=deleted]');
        deleted.on('click',function(btn){
			context.event.name='click';
			var activatedChain = me.getOwner().getActionChain("deleted");
			activatedChain.execute(context);
		});
		/*
        // 上移按钮
		var changeUp = resultBlock.down('xapbutton[action=changeUp]');
		changeUp.on('click',function(btn){
			context.event.name='click';
			var changeUpChain = me.getOwner().getActionChain("changeUp");
			changeUpChain.execute(context);
		});
		
        // 下移按钮
		var changeDown = resultBlock.down('xapbutton[action=changeDown]');
		changeDown.on('click',function(btn){
			context.event.name='click';
			var changeDownChain = me.getOwner().getActionChain("changeDown");
			changeDownChain.execute(context);
		});
		
        // 停用按钮
        var stopped = resultBlock.down('xapbutton[action=stopped]');
        stopped.on('click',function(btn){
			context.event.name='click';
			var stoppedChain = me.getOwner().getActionChain("stopped");
			stoppedChain.execute(context);
		});
		
*/
        
	}
})