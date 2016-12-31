Ext.define('iih.po.com.action.MessageDetailSearchAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	doExecute: function(context) {
	    this.callParent();
    	var operations = context.operations;
    	var mesId = context.msg.mesId;
    	this.status = context.msg.status;
    	this.revisionCd = context.msg.revisionCd;
    	var url = this.url + '/' + mesId;
    	var mclass = null;
    	var METHODS = this.getInvocationMethods();
    	var operation = {
    	    url: url,
    	    method: METHODS.METHOD_GET,
            scope: this,
            success: this.onSuccess
    	};
    	operations.push(operation);
    },
    
    onSuccess: function(operation) {
        var block = this.getBlock('content');
        var m = operation.result;
        if(m && m.data && block){
            var data = m.data;
            var v = data.sendDate;
            var time = Ext.Date.parse(v, 'time');
            var sendDate = Ext.Date.format(time, 'Y-m-d H:i');
            data.sendDate = sendDate;
            block.setData(m.data);
            var txt = block.down('xaptextfield[name=revisionCd]');
            txt.setValue(this.revisionCd);
            if(this.status){
                var btn = block.down('button[name=confim]');
                btn.show();
            }
        }
    }
});