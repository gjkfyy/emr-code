Ext.define('iih.masterdata.dataelement.dimensioncode.action.DictViewreadyAction', {
	extend: 'Xap.ej.action.Action',
	
	execute: function(context){
		var me = this;
	    var owner = this.getOwner();
		var resultBlock = this.getBlock('result');	
		var inProcessGrid = resultBlock.down('xapgrid');
		/*
		//启用 checkbox   
		var isActivated = resultBlock.down('xapcheckbox[action=isActivated]');
		isActivated.on('change',function(btn){
			context.event.name='change';
			var dictInitChain = me.getOwner().getActionChain("init");
			dictInitChain.execute(context);
		});
		*/
		//查询按钮
		var search = inProcessGrid.down('xapbutton[action=search]');
		search.on('click',function(btn){
			context.event.name='click';
			var searchChain = me.getOwner().getActionChain("init");
			searchChain.execute(context);
		});
		
		//新建按钮
		var create = inProcessGrid.down('xapbutton[action=create]');
		create.on('click',function(btn){
			context.event.name='click';
			var createChain = me.getOwner().getActionChain("create");
			createChain.execute(context);
		});
		
		//编辑按钮
		var edit = inProcessGrid.down('xapbutton[action=edit]');
		edit.on('click',function(btn){
			context.event.name='click';
			var editChain = me.getOwner().getActionChain("edit");
			editChain.execute(context);
		});
		
        // 删除按钮
        var deleted = inProcessGrid.down('xapbutton[action=deleted]');
        deleted.on('click',function(btn){
			context.event.name='click';
			var activatedChain = me.getOwner().getActionChain("deleted");
			activatedChain.execute(context);
		});
		/*
		//停用按钮
		var stopped = inProcessGrid.down('xapbutton[action=stopped]');
		stopped.on('click',function(btn){
			context.event.name='click';
			var stoppedChain = me.getOwner().getActionChain("stopped");
			stoppedChain.execute(context);
		});
		
		//启用按钮
		var activated = inProcessGrid.down('xapbutton[action=activated]');
		activated.on('click',function(btn){
			context.event.name='click';
			var activatedChain = me.getOwner().getActionChain("activated");
			activatedChain.execute(context);
		});
		*/
	}
})