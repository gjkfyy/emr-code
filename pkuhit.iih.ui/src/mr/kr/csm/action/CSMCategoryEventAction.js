Ext.define('iih.mr.kr.csm.action.CSMCategoryEventAction', {
	extend: 'Xap.ej.action.Action',
	execute: function(context){
	    var me = this;
	    var owner=me.getOwner();	
	   
	    var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
	    var ownerCode;
	    var ownerType;
	    var ownerTypeDeptVal = 'MDM08.02';
	    var ownerTypePerVal = 'MDM08.03';
	    var enTypeCode = 'ENM01.01';
	    var dept = me.getBlock('content').down('xapcombobox[action=dept]');
	    
	    if(context.event.name="change" && context.event.from.xtype!='xapgrid'){
	    	//ownerType = context.event.arguments[0].inputValue;
	    	if(context.event.arguments[1]){
	    		ownerType = ownerTypeDeptVal;
	    		dept.setDisabled(false);
		    	if(dept.value==null){
		    		ownerCode = IMER_GLOBAL.department.code;
		    	}else{
		    		ownerCode = dept.value;
		    	}
	    	}else{
	    		ownerType = ownerTypePerVal;
	    		ownerCode = IMER_GLOBAL.user.code;
	    		dept.setDisabled(true);
	    	}
	    	
	    }else{
	    	ownerType= ownerTypeDeptVal;
	    	ownerCode = IMER_GLOBAL.department.code;
	    }
	    
	    properties.setData({
	    	ownerCode:ownerCode,
	    	ownerType:ownerType,
	    	enTypeCode:enTypeCode
 	     });
	    
	    var categorySearch = owner.getActionChain("categorySearchAction");
	    categorySearch.execute(context);
	   
	    
   }
	
});
