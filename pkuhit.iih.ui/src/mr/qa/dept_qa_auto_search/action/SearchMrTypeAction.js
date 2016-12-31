Ext.define('iih.mr.qa.dept_qa_auto_search.action.SearchMrTypeAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    /*
    * @Override
    */
    execute: function(context) {
        this.prepareOperations(context.operations);
    },
    prepareOperations: function(operations) {
        var block = this.getOwner().getBlock('condition');
        var condition={"enTypeCd":'ENM01.04'};
        var url = this.url;
        /*if(condition) {
            var qs = Ext.Object.toQueryString(condition);
            if(qs) {
                url += '?'+qs;
            }
        }*/
        var operation = {
                url: url,
                method: 'get',
                params: condition,
                scope: this,
                success: this.onSuccess
                // fail: this.onFail
            };
        operations.push(operation);
    },
    onSuccess: function(operation) {
    	var view = this.getOwner();
        var block = this.getBlock('condition');
        var mrTypeCd=block.down('[name=mrTypes]');
        mrTypeCd.select(null);
        if(operation.result){
            mrTypeCd.setData(operation.result.dataList);
            var initChain = view.getActionChain('init');
    		initChain.execute({});
        }
    }
});