Ext.define('iih.mr.kr.csm.action.CSMDisuiteSaveAction',{
	extend : 'Xap.ej.action.ServiceInvocation',
	requires:[],
	
	doExecute: function(context) {
		   //this. showLoading();
           this.prepareOperations(context.operations,context);
        },
	 prepareOperations: function(operations,context) {
        	
        	var me = this;
        	var owner=me.getOwner();
        	var url = me.url;
        	
        	var block = me.getBlock('topblock');
            var ownerTypeCombox = block.down('xapcombobox[action=ownerType]');
            var ownerCombox = block.down('xapcombobox[action=owner]');
            var categoryCombox = block.down('xapcombobox[action=category]');
            var diCodeCombox = block.down('comboxgrid[action=disute]');
            
            var diGrid = block.down('xapgrid[action=digrid]');
            var mrGrid = block.down('xapgrid[action=mrgrid]');
            
            var selModeldi=diGrid.getSelectionModel();
            var selectiondi = selModeldi.getSelection();
            
            var selModelmr=mrGrid.getSelectionModel();
            var selectionmr = selModelmr.getSelection();
            
            var ownerType = ownerTypeCombox.value;
            var ownerCode = ownerCombox.value;
            var diSuiteTypeCode = categoryCombox.value;
            var diCode = diCodeCombox.getValue();
            
            if(owner.viewConfig.typeFlag==2){
            	
            	 if(diCode==null){
            		 diCode = owner.viewConfig.data.diCode;
            	 }
            }
            
            var relDiList=[];
            var relMrList=[];
            
            if(diCode==null){
            	XapMessageBox.info('请录入组套名称!');
            	return;
            }
            
            if(selectiondi.length==0){
            	
            	XapMessageBox.info('请选择诊断!');
            	return;
            }else{
            	
            	for(var i=0;i<selectiondi.length;i++){
			    	var record = selectiondi[i];
			    	var disuitediCode = record.get('diCode');
			    	if(disuitediCode!=null && disuitediCode!=''){
			    		relDiList.push(disuitediCode);
			    	}
			    	
			    }
            }
            
           if(selectionmr.length==0){
            	
            	XapMessageBox.info('请选择病历模板!');
            	return;
            }else{
            	
            	for(var i=0;i<selectionmr.length;i++){
			    	var record = selectionmr[i];
			    	var mrTemplateCode = record.get('mrTemplateCode');
			    	if(mrTemplateCode!=null && mrTemplateCode!=''){
			    		relMrList.push(mrTemplateCode);
			    	}
			    	
			    }
            }
           
           if(owner.viewConfig.typeFlag==2){
        	   var data={enTypeCode:'ENM01.01',ownerType:ownerType,ownerCode:ownerCode,diSuiteTypeCode:diSuiteTypeCode,diCode:diCode,relDiList:relDiList,relMrList:relMrList,diSuiteCode:owner.viewConfig.data.diSuiteCode};
           }else{
        	   var data={enTypeCode:'ENM01.01',ownerType:ownerType,ownerCode:ownerCode,diSuiteTypeCode:diSuiteTypeCode,diCode:diCode,relDiList:relDiList,relMrList:relMrList};
           }
           
            
            var METHODS = this.getInvocationMethods();
	    	var operation = {
	            url: url,
	    		mclass: null,
	    		method: METHODS.METHOD_CREATE,
	    		data:data,
	    		condition: null,
	    		scope: this,
	    		success: this.onSuccess,
	    	    fail: this.onFailure
	    	};
	    	operations.push(operation);
	    },
	
	onSuccess : function(operation) {
	    	var me = this;
	    	var view = Ext.getCmp('csmkrcontentview');
	    	if(operation.result.data){
	    		//自动关闭
	    		var owner=me.getOwner();
	    		owner.ownerCt.close();
	    		var csmForAdminSearch = view.getActionChain('csmForAdminsearchAction');
	    		csmForAdminSearch.execute();
	    		
	    		var diGrid = view.getBlock('right').down('xapgrid[action=digrid]');
	    		var diStore = diGrid.getStore();
	    		
	    		var mrGrid = view.getBlock('right').down('xapgrid[action=mrgrid]');
	    		var mrStore = mrGrid.getStore();
		
	    		diStore.removeAll();
	    		mrStore.removeAll();
	    	 
	    		
	    	}else{
	    		XapMessageBox.info('保存失败!');
	    	}
	    	
	    },
	 onFailure: function(operation) {
	    	XapMessageBox.info('查询失败!');
	    },  
});
