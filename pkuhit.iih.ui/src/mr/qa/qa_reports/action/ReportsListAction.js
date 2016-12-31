/** 
 * 质控报表列表
 * @author ：cheng_feng
 */
Ext.define('iih.mr.qa.qa_reports.action.ReportsListAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
//	extend: 'Xap.ej.action.Action',
	
	doExecute: function(context) {
			this. showLoading();
	        this.prepareOperations(context);
	 },
	 prepareOperations: function(context) {
		 var me = this;
		
	    var owner = this.getOwner();   
	    
	    //wang_yanli add 
	    
	    var workScreen = iih.mr.qa.QaStatusGlobal.workScreenQaReport;//15
	    
	    var typeFlag = owner.typeFlag;
	    
	    if(typeFlag == '1'){
	    	workScreen = iih.mr.qa.QaStatusGlobal.workScreenNSReport;//16  护理报表
	    }
	    
		var operations = context.operations;
		
        var resultBlock = this.getBlock('result');  
        
       var event = context.event;
        
     //   var url = this.url;
        var url = this.url+"?workScreen="+workScreen; //wangyanli add workScreen
    	var operation = {
            url: url,
    		mclass: null,
    		method: 'get',
    		condition: null,
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.length = 0;
    	operations.push(operation);
    },

    onSuccess: function(operation) {
        var block = this.getBlock('result');
        var m = operation.result;
        block.setData(m.dataList);
    }
});
