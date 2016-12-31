/** 
 * 重发整改通知
 * @author ：cheng_feng
 */
Ext.define('iih.mr.qa.process_qa_track.action.DefectSendNotificationAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	doExecute: function(context) {
	        this.prepareOperations(context);
	 },
	 prepareOperations: function(context) {
		
	    var owner = this.getOwner();
	    
    	var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
    	
        var revisionCd = properties.data.revisionCd;
	    
		var operations = context.operations;
		
        var url = this.url;
        url+= '/' + revisionCd;
        console.log(url);
    	var operation = {
            url: url,
    		mclass: null,
    		method: 'put',
    		condition: null,
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.length = 0;
    	operations.push(operation);
    },

    onSuccess: function(operation) {
        var block = this.getBlock('result');
        var defectBlock = block.ownerCt.getBlock('bottom');
        var defectGrid = defectBlock.down('xapgrid');
        var m = operation.result;
        defectBlock.setData(m.data.qaFaultList.dataList);
    }
});
