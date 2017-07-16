Ext.define('iih.sy.search.action.SaveSearchHistoryDataAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	requires: ['Xap.ej.block.Layer',
	           'iih.sy.search.block.EMRSearchConditionBlock'],
	
	doExecute: function(context) {
		 
		this.showLoading();
	    this.callParent();
	    var owner = this.getOwner();
	    
		var contentBlock = owner.getBlock('content');
		//var conditionBlock = owner.getBlock('condition');
		var conditionBlock=Ext.getCmp('emrsearchconditionblock');
		
		var userId = IMER_GLOBAL.user.code;

	    //console.log(context);
	    
	    var content = contentBlock.getItemData(contentBlock);
	    var condition = conditionBlock.getItemData(conditionBlock);
	    
		var itemValues = "";
	    for(var key in condition){
	    	if(key.indexOf('xapdisplayfield')==0){
	    		delete condition[key];
	    	}
	    	
	    	if(key.indexOf('mr_element')==0){
	    		if(condition[key] != null && condition[key] != undefined){
	    			var itemKey = 'examItem'+key.substring('mr_element'.length);
	    			var itemValue = condition[itemKey];
	    			var temp = condition[key]+"|"+itemValue;
	    			itemValues += "||" + temp;
	    			delete condition[key];
	    			delete condition[itemKey];
	    		}
	    	}
	    	
	    	if(condition[key] instanceof Date){
	    		var date = condition[key];
	    		condition[key] = Ext.Date.format(date,'Y-m-d');
	    		//data.key = date.format("Y-m-d H:i:s");
	    	}
	    }
	    if(itemValues != ""){
	    	condition.itemValues = itemValues.substring(2);
	    }
	    
	    var data = {};
	    data.conditionName = content.conditionData;
	    data.userId = userId;
	    data.condition = Ext.JSON.encode(condition);
		
        var operations = context.operations;      
        this.prepareOperations(operations,data);  
	},  
	 prepareOperations: function(operations,data) { 
        var url = this.url;   
        var METHODS = this.getInvocationMethods();
        
        var operation = {
            url: url,
            mclass: null,
            method: 'post',
            condition: null,
            data:data,
            scope: this,
            success: this.onSuccess,
            fail: this.onFail
        };
        operations.push(operation);	    
	 },
	 
	 onFail: function(operation) { 
		 XapMessageBox.info('保存失败!');
	 },  
     onSuccess: function(operation) {
    	var view = this.getOwner();
    	var chain = view.getActionChain('cancel');
    	chain.execute({
    		flag:'1'
    	});
    	XapMessageBox.info('保存成功!');
		
		var block=Ext.getCmp('searchleftview');
		var initChain = block.getActionChain('init');
		initChain.execute({});
		//block.getForm().reset(); //清空form
     }    
});