Ext.define('iih.mr.kr.csm.action.CSMShareViewreadyAction', {
	extend: 'Xap.ej.action.Action',
	requires:[],
	
	execute: function(context) {
	
           var me = this;
           var owner = me.getOwner();
           var block = me.getBlock('topblock');
           var deptcombox = block.down('xapcombobox[action=dept]');
           deptcombox.setData(iih.mr.kr.csm.action.Util.deptArr);
           deptcombox.selectAt(0);
           
           me.searchSharDept(me);
           
           deptcombox.on('select',function(com){
        	   me.searchSharDept(me);
           });
           
           var bottomBlock = me.getBlock('bottomblock');
           var confirmBtn = bottomBlock.down('xapbutton[action=confirm]');
           var closeBtn = bottomBlock.down('xapbutton[action=close]');
           
           confirmBtn.on('click',function(btn){
        	   
        	   var deptGrid = me.getBlock('topblock').down('xapgrid[action=deptgrid]');
               var selModel=deptGrid.getSelectionModel();
               var selection = selModel.getSelection();
           	
               if(selection.length>0){
            	   var shareSaveAction = me.getOwner().getActionChain("shareSaveAction");
            	   shareSaveAction.execute();
               }else{
            	   XapMessageBox.info('请选择共享的科室!');
               }
        	  
           });
           
           closeBtn.on('click',function(btn){
        	   owner.ownerCt.close();
           });
           
    },
    
    searchSharDept:function(me){
    	
    	 var shareDeptAction = me.getOwner().getActionChain("shareDeptAction");
    	 shareDeptAction.execute();
    },
});
