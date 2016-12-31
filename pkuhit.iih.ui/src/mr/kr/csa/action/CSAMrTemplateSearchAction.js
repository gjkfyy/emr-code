Ext.define('iih.mr.kr.csa.action.CSAMrTemplateSearchAction',{
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
        	
        	//var dept = me.getBlock('leftblock').down('xapcombobox[action=dept]');
        	//var val = dept.value;
        	var radios = me.getBlock('leftblock').query('xapradio');
        	var ownerTypeVal ;
        	for(var i=0;i<radios.length;i++){
        		
        		 if(radios[i].value){
        			 ownerTypeVal= radios[i].inputValue;
        		 }
        	}
        	
        	if(ownerTypeVal=='MDM08.02'){
        		
        		
        	  val = IMER_GLOBAL.department.code;
      
        	}else{
        		val = IMER_GLOBAL.user.code;
        	}
        	
        	var condition;
        	var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        	var diSuiteCode = properties.data.diSuiteCode;
        	var diCode = properties.data.diCode;
        	if(diCode=='*'){
        		
        		 condition = {
             			diSuiteCode: diSuiteCode,
             			diCode:diCode,
             			ownerType:ownerTypeVal,
             			ownerCode:val,
             			enTypeCode: 'ENM01.01'
             			
                	 };
        		
        	}else{
        		
        	   condition = {
            			diSuiteCode: diSuiteCode,
            			ownerType:ownerTypeVal
               	 };
               	
        	}
        	
           	var qs = Ext.Object.toQueryString(condition);
           	url += '?' + qs;
            var METHODS = this.getInvocationMethods();
	    	var operation = {
	            url: url,
	    		mclass: null,
	    		method: METHODS.METHOD_GET,
	    		condition: null,
	    		scope: this,
	    		success: this.onSuccess,
	    	    fail: this.onFailure
	    	};
	    	operations.push(operation);
	    },
	
	onSuccess : function(operation) {
	    	var me = this;
	    	var owner = me.getOwner();
	    	var mrGrid = me.getBlock('rightblock').down('xapgrid[action=mrgrid]');
	    	var res = operation.result.dataList;
	    	mrGrid.setData(res);
	    	if(res && res.length>0){
	    		var store = mrGrid.getStore();
	    		mrGrid.getSelectionModel().select(0);
	    		
	    		var mrProperty = owner.getActionChain('initMrProperty');
	    		mrProperty.execute();
	    	}
	    	
	    },
	 onFailure: function(operation) {
	    	XapMessageBox.info('查询失败!');
	    },  
});
