Ext.define('iih.mrb.action.UseRateInitAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
    doExecute: function(context) {
    	console.log('UseRateInitAction............. ');
    		var block = this.getOwner().getBlock('condition');
//        var form = block.down('xapform');
//        form.getForm().reset();
		var block = this.getBlock('content');
		var crtTimeStart = block.down('xapdatefield[name=crtTimeStart]');
	    var crtTimeEnd = block.down('xapdatefield[name=crtTimeEnd]');
	    
	    var curDate = new Date();
		var curDateTime = curDate.getTime();
		var preDateTime = curDateTime - 24*60*60*1000*7;  
		crtTimeStart.setValue(preDateTime);
		crtTimeEnd.setValue(curDateTime);
		var diEmpId = IMER_GLOBAL.user.code;
		var data = {'userId': diEmpId,
				   roleId:'XAPM14.17'} ;
		this.prepareOperations(context.operations, data);
    },
    
    prepareOperations: function(operations,data) {
        var url = this.url ;
        var mclass = null;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: 'get',
            scope: this,
            params:data,
            success: this.onSuccess,
            fail: this.onFail
        };
        console.log('operation');
        console.log(operation);
        operations.length = 0;
        operations.push(operation);
    },
    
    onSuccess: function(operation){
        console.log('operation');
        console.log(operation);
        if(!operation.result.dataList){
            console.log('!operation.result.dataList');
            console.log(operation);
    		var block = this.getOwner().getBlock('condition');
	  		var useRateTypeCodeXapcombobox = block.down('xapcombobox[name=useRateTypeCode]');
	  		useRateTypeCodeXapcombobox.store.removeAt(2);
        }else{
            console.log('operation.result.dataList');
            console.log(operation);
        }
    },
    
    onFail: function(operation){
       // this.hideLoading();
    }
});