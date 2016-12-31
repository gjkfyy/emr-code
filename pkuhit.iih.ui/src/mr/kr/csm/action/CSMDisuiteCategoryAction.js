Ext.define('iih.mr.kr.csm.action.CSMDisuiteCategoryAction', {
	extend: 'iih.mr.kr.csm.action.CSMCategorySearchAction',
	requires:[],
	
	 onSuccess : function(operation) {
		var me = this;
		var owner = me.getOwner();
		var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
		var diSuiteTypeCode = properties.data.diSuiteTypeCode;
		var block = me.getBlock('topblock');
		var categoryCombox = block.down('xapcombobox[action=category]');
		var res = operation.result.dataList;
	    var comdata = [];
	    var index = 0;
	    if(res!=null){
	    	
	    	for(var i=0;i<res.length;i++){
	    		
	    	    var model = {
		                 'text':res[i].diSuiteTpNm,
		                 'value':res[i].diSuiteTpCd,
		               };
		 	     comdata.push(model);
		 	     
		 	     if(diSuiteTypeCode!=''){
		 	    	 
		 	    	 if(diSuiteTypeCode == res[i].diSuiteTpCd){
		 	    		 index = i;
		 	    	 }
		 	     }
		    }
	    	
	    	categoryCombox.setData(comdata);
	    	categoryCombox.selectAt(index);
	    	
	    }else{
	    	var categoryStore = categoryCombox.getStore();
	    	categoryStore.removeAll();
	    	categoryCombox.setRawValue('');
	    	XapMessageBox.info('无组套分类,请先维护组套分类!');
	    }
	    
	    
    }
    
   
});
