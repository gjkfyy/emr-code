Ext.define('iih.mr.wr.nmr.action.SearchNmrTypeAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    /*
    * @Override
    */
    execute: function(context) {
        this.prepareOperations(context.operations);
    },
    prepareOperations: function(operations) {
        var block = this.getOwner().getBlock('condition');
        var mrCustClaCd=block.down('[name=mrCategoryCode]').getValue();
        var condition={"mrTypeCustomCategoryCd":mrCustClaCd,"enTypeCd":'ENM01.04'};
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