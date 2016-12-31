Ext.define('iih.masterdata.dataelement.dimensionvalue.action.WakeDictDataButtonAction', {
extend: 'Xap.ej.action.ServiceInvocation',

	requires: [],
	
	execute: function(context) {

		var owner = this.getOwner();
		
		var contentBlock = owner.getBlock('bottom').getBlock('result');
		if(contentBlock == undefined){
			contentBlock = owner.ownerCt.getBlock('bottom').getBlock('result');
	    }
	    
		var block = owner.getBlock('top');
	    if(block == undefined){
	    	block = owner.ownerCt.getBlock('top');
	    }
		var grid = block.down('xapgrid');
        var record = grid.getSelectionModel().getSelection();
	    
	    //获取储存于画面间的参数
	    var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
		
		var noticeStatus = properties.data.revisionStatus;
		
	    if(record !=undefined && !Ext.isEmpty(record, false)){
/*	    	 // 启用 复选框
	         var isActivated = contentBlock.down('xapgrid xapcheckbox[action=isActivated]');*/
	         // 新建按钮
	         var create = contentBlock.down('xapgrid xapbutton[action=create]');
	         // 编辑按钮
	         var edit = contentBlock.down('xapgrid xapbutton[action=edit]');
	         //删除按钮
	         var deleteb = contentBlock.down('xapgrid xapbutton[action=deleted]');
	         /*         // 上移按钮
	         var changeUp = contentBlock.down('xapgrid xapbutton[action=changeUp]');
	         // 下移按钮
	         var changeDown = contentBlock.down('xapgrid xapbutton[action=changeDown]');
	         // 停用按钮
	         var stopped = contentBlock.down('xapgrid xapbutton[action=stopped]');
	         // 启用按钮
	         var activated = contentBlock.down('xapgrid xapbutton[action=activated]');*/
	        

	 	         // 设置按钮可用
	        //	 isActivated.setDisabled(false);
	        	 create.setDisabled(false);
	        	 edit.setDisabled(false);
	        	 deleteb.setDisabled(false);
	        	 /*	 	        	 changeUp.setDisabled(false);
	        	 changeDown.setDisabled(false);
       	 stopped.setDisabled(false);
	        	 activated.setDisabled(false);*/

	    }
	    
        contentBlock.down('xapgrid').refresh();
        
    }
});