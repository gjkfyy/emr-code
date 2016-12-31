/** 
 * 查询：环节质控---缺陷一览列表
 * @author ：yao_lijie
 */
Ext.define('iih.mr.qa.process_qa_patient.action.QaDefectListAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	doExecute: function(context) {
			this. showLoading();
	        this.prepareOperations(context);
	 },
	 prepareOperations: function(context) {
		 var me = this;
		
	    var owner = this.getOwner();   
	    
	    var record = owner.revisionRecord;
	    
	    var pk = record.data.pk;
	    
		var operations = context.operations;
		
        var bottomBlock = this.getBlock('result');  
        
       var event = context.event;
        
        var url = this.url;
        var qs = 'pk=' + pk;
    	var operation = {
            url: url + '?' +qs,
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
        var data = m.data.qaFaultList.dataList;
        block.setData(data);
    }
});
