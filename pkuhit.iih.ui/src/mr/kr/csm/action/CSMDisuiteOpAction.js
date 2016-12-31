Ext.define('iih.mr.kr.csm.action.CSMDisuiteOpAction', {
	extend: 'Xap.ej.action.Action',
	requires:['iih.mr.kr.csm.view.CSMDisuiteMrTemplateView'],
	
	execute: function(context) {
    
	
	   var me = this;
	   var owner = me.getOwner();
	   var block = me.getBlock('topblock');
	
	   var diGrid = block.down('xapgrid[action=digrid]');
       var diStore = diGrid.getStore();
	   
       var mrGrid = block.down('xapgrid[action=mrgrid]');
       var mrStore = mrGrid.getStore();
       
       //type 1 诊断新增,2诊断删除,3模板新增,4模板删除 5确认 ,6取消
       
	   if(context.type=='1'){
		   var insertModel = Ext.create('iih.mr.kr.csm.model.DIModel',{
			   icdCode:'',
			   diName:'',
			   diCode:''
		   });
		   var index = diStore.data.length;
		   diStore.insert(index,[insertModel]);
		   
	   }else if(context.type=='2'){
           var selModel=diGrid.getSelectionModel();
           var selection = selModel.getSelection();
           if(selection.length>0){
        	   XapMessageBox.confirm2(
    					'确认删除该记录？',
    					function(btn){
    						if(btn == 'yes'){
    							
    						    for(var i=0;i<selection.length;i++){
    						    	var record = selection[i];
    						    	diStore.remove(record);
    						    }
    						}
    				});
           }else{
        	   XapMessageBox.info('请选择要删除的诊断!');
           }
		   
	   }else if(context.type=='3'){
		   
		   var ownerTypeCombox = block.down('xapcombobox[action=ownerType]');
	       var ownerCombox = block.down('xapcombobox[action=owner]');
	       var ownerdisute = block.down('xapcombobox[action=disute]');
		   var diSuiteCode = '';
		   if(owner.viewConfig.typeFlag==2){
			   diSuiteCode = owner.viewConfig.data.diSuiteCode;
		   }
		   var action = Xap.create({
   			  xclass: 'Xap.ej.action.PopAction'
   		   });
       	   var config = {
       			width: 760,
	    		height:400,
	    		title:'选择组套病历模板',
           		contentConfig: {
           			xtype: 'csmdisuitemrtemplateview',
           		    viewConfig:{
       		           ownerType: ownerTypeCombox.value,
       		           ownerCode:ownerCombox.value,
       		           enTypeCode:'ENM01.01',
       		           diSuiteCode:diSuiteCode
                    }
           		}
           	};
   		action.execute(config);
		   
	   }else if(context.type=='4'){
		   

           var selModel=mrGrid.getSelectionModel();
           var selection = selModel.getSelection();
           if(selection.length>0){
        	   XapMessageBox.confirm2(
    					'确认删除该记录？',
    					function(btn){
    						if(btn == 'yes'){
    							
    						    for(var i=0;i<selection.length;i++){
    						    	var record = selection[i];
    						    	mrStore.remove(record);
    						    }
    						}
    				});
           }else{
        	   XapMessageBox.info('请选择要删除的病历模板!');
           }
	   }else if(context.type=='5'){
		     
		    //保存组套
		     var disuiteOpAction = me.getOwner().getActionChain("disuiteSaveAction");
    	     disuiteOpAction.execute();
		   
	   }else if(context.type=='6'){
		   
		   owner.ownerCt.close();
	   }
    }
});
