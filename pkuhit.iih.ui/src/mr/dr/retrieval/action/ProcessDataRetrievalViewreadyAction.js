Ext.define('iih.mr.dr.retrieval.action.ProcessDataRetrievalViewreadyAction', {
	extend: 'Xap.ej.action.Action',
	
	requires:[],
	      
	execute: function(context){
		
		var me = this;
		
	    var owner = this.getOwner();
	    
		//获取缺陷一览的 block
		var bottomBlock = this.getBlock('result');		
		var drGrid = bottomBlock.down('xapgrid');
		
		//审核通过按钮
		/*var checkPass = bottomBlock.down('xapgrid xapbutton[action=checkPass]');
		checkPass.on('click',function(btn){
			context.event.name='click';
			var checkPassChain = me.getOwner().getActionChain("checkPass");
			checkPassChain.execute(context);
		});*/
	}
})