Ext.define('iih.mr.wr.mr.action.AddPrintCountAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
//    userName:'',
    /*
    * @Override
    */
    execute: function(context) {
    	var medicalRecord= this.getOwner().medicalRecord;
	    this.AddPrintCount(context.operations, medicalRecord.mrPk);
    },AddPrintCount: function(operations,mrPk) {
    	
        var METHODS = this.getInvocationMethods();
        var url=this.url+"/"+mrPk;
        var operation = {
            url: url,
            method: METHODS.METHOD_CREATE,
            scope: this,
            success: this.onSuccess,
            fail: this.onFail
        };
        operations.push(operation);
    }, onSuccess: function(returnData) {
    	console.log('打印成功');
    }
});
