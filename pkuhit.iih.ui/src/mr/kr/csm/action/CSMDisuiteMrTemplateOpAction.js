Ext.define('iih.mr.kr.csm.action.CSMDisuiteMrTemplateOpAction', {
	extend: 'Xap.ej.action.Action',
	requires:[],
	
	execute: function(context) {
	 
	    var me = this;
	    var owner = me.getOwner();
	    var block = me.getBlock('topblock');
	    var mrgrid = block.down('xapgrid[action=mrgrid]');
	    var selModel=mrgrid.getSelectionModel();
        var selection = selModel.getSelection();
	    
        if(selection.length==0){
        	  XapMessageBox.info('请选择病例模板!');
        	return;
        }
	    
	     if(context.event.arguments[0].action='confirm'){
	    	 
	    	 var view = Ext.getCmp('csmdisuiteview');
	    	 var parentMrGrid = view.down('xapgrid[action=mrgrid]');
	    	 var mrStore = parentMrGrid.getStore();
	    	 if(mrStore.getData().length>0){
	    		 //过滤重复数据
	    		 for(var i=0;i<selection.length;i++){
	    			 
	    			 for(var j=0;j<mrStore.getData().length;j++){
	    				 
	    				 if(selection[i].data.mrTemplateCode == mrStore.getData()[j].mrTemplateCode){
	    					 Ext.Array.remove(selection,selection[i])
	    				 }
	    			 }
	    		 }
	    		 
	    		 var index = mrStore.getData().length;
	    		 mrStore.insert(index,selection);
	    		 
	    		 parentMrGrid.getSelectionModel().selectAll();
	    		 
	    	 }else{
	    		 parentMrGrid.setData(selection);
	    	 }
	    	 parentMrGrid.getSelectionModel().selectAll();
	    	 me.owner.ownerCt.close();
	     }else{
	    	 me.owner.ownerCt.close();
	     }
	    
    }
});
