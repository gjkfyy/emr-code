Ext.define('iih.mr.wr.nmr.action.SearchBatchTypeAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    /*
    * @Override
    */
    execute: function(context) {
        this.prepareOperations(context.operations);
    },
    prepareOperations: function(operations) {
        var block = this.getOwner().getBlock('condition');
        var batchCategoryCode=block.down('[name=batchCategoryCode]').getValue();
        var condition={"mrTypeCustomCategoryCd":batchCategoryCode,"enTypeCd":'ENM01.04'};
        var url = this.url;
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
        var block = this.getOwner().getBlock('condition');
        var mrTypeCd=block.down('[name=typeCode]');
        mrTypeCd.select(null);
        if(operation.result){
            mrTypeCd.setData(operation.result.dataList);
             mrTypeCd.select('ALL');
        }
    }
});