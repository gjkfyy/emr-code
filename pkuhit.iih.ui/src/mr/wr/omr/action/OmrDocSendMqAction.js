Ext.define('iih.mr.wr.omr.action.OmrDocSendMqAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    /*
     * @Override
     */
    execute: function(context) {
        var operations = context.operations;
        if(!operations) {
            return;
        }
        var medicalRecord=this.getOwner().medicalRecord;
        var opt = context.opt;
        	
        this.prepareOperations(operations, medicalRecord, opt);
    },
    
    prepareOperations: function(operations,medicalRecord,opt) {
        var METHODS = this.getInvocationMethods();
        var condition = {
            versionNumber: opt,
            serviceId: CONFIG_PARAM.OMR_SENDMQ_SERVICE_ID,
            domainId: CONFIG_PARAM.OMR_SENDMQ_DOMAIN_ID
        };
        var qs = Ext.Object.toQueryString(condition);
        var url=this.url+'?'+qs;
        var operation = {
            url: url,
            method: METHODS.METHOD_CREATE,
            data:medicalRecord,
            scope: this,
            success: this.onSuccess,
            fail: this.onFail
        };
        operations.push(operation);
    },
    onSuccess: function(returnData) {
        
    },
    onFail: function(operation) {
        Ext.Msg.alert('提示','发送MQ失败!');
    }
});
