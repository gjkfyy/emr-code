Ext.define('iih.po.com.action.GetCertInfoAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
	
    requires:[],
    
    doExecute: function(context) {
    	this.callParent();
    	var strCert = context.strCert;
    	var strOid = context.strOid;
        var url = this.url;
        var condition = {
            'strCert': strCert,
            'strOid': strOid
        };
        var qs = Ext.Object.toQueryString(condition);
        url += '?' + qs;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            method: METHODS.METHOD_GET,
            condition: condition,
            scope: this,
            success: this.onSuccess,
            fail: this.onFail
        };
        var operations = context.operations;
        operations.push(operation);
    },
    
    onSuccess : function(operation) {
        var data = operation.result;
        var uniqueId = data.certInfo;
        var chain = this.getOwner().getActionChain("getCertUser");
        chain.execute({
            'caSubject':1,
            'uniqueId':uniqueId
        });
    },
    
    onFail: function(operation) {
        var view = this.getOwner();
        var block = this.getBlock('lvblock');
        var showInfo = block.down('xapdisplayfield');
        showInfo.setValue('<font color=red>获取证书信息失败!</font>');
    }
});
