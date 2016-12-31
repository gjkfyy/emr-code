Ext.define('iih.sy.userinfo.action.ReportListInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	execute: function(context) {
         var operations = context.operations;
    	 if(!operations) {
    		 return;
    	 }
    	 var url = this.url;
    	var operation = {
            url: url,
    		method: 'get',
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.push(operation);
    },
    onSuccess: function(operation) {
        var block = this.getOwner().getBlock('right');
        var m = operation.result;
        if(m instanceof Ext.data.Model) {
            block.setData({
                mclass: operation.mclass,
                data: m.getData(true)
            });
        }else {
            block.setData(m);
        }
    }
});
