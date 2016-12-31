Ext.define('iih.mr.wr.mr.action.CompleteMrAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    /*
        * @Override
        */
        execute: function(context) {
        this.showSubmitProgressBar();
          this.prepareOperations(context.operations);
         
        },

        /*
         * @return {mclass: '', condition: {}}
         */
        
        prepareOperations: function(operations) {
            var METHODS = this.getInvocationMethods();
            var url=this.url;
            var operation = {
                url: url,
                method: METHODS.METHOD_UPDATE,
                scope: this,
                success: this.onSuccess,
                fail: this.onFail
            };
            operations.push(operation);
//            var url = this.url;    
//            var METHODS = this.getInvocationMethods();
//            var operation = {
//                url: url,
//                method: METHODS.METHOD_DELETE,
//                scope: this,
//                success: this.onSuccess
//            };
//            operations.push(operation);
        },
        
        onSuccess: function(operation) {
//            Ext.Msg.alert("提示",'成功!');
        },
        onFail: function(operation) {
            Ext.Msg.alert("提示",'失败!');
        }
        
});
