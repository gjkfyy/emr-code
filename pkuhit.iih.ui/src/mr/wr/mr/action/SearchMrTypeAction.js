Ext.define('iih.mr.wr.mr.action.SearchMrTypeAction', {
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
        var block = this.getOwner().getBlock('condition');
        var mrTypeCd=block.down('[name=typeCode]');
        mrTypeCd.select(null);
        if(operation.result){
            mrTypeCd.setData(operation.result.dataList);
            var properties = this.getOwner().ownerCt.getLayer(Xap.ej.block.Layer.PROPERTIES);
            var mrTpCd = properties.data.mrTpCd;
            if(mrTpCd){
                mrTypeCd.select(mrTpCd);
                properties.data.mrTpCd = null;
            }else{
                mrTypeCd.select('ALL');
            };
            //var result = this.getOwner();
            //var initChain = result.getActionChain('init');
            //initChain.execute();
            //if(mrCustClaCd!='ALL')mrTypeCd.expand();
        }
    }
});