Ext.define('iih.mrb.action.MrTypeSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
	    this.prepareOperations(context.operations);
    },
    prepareOperations: function(operations) {
        var mrCustClaCd = '';
        var condition={"mrTypeCustomCategoryCd":mrCustClaCd,"enTypeCd":'ENM01.04'};
        var url = this.url;
        var operation = {
                url: url,
                method: 'get',
                params: condition,
                scope: this,
                success: this.onSuccess
            };
        operations.push(operation);
    },
    onSuccess: function(operation) {
    	var owner = this.getOwner();
        var block = owner.getBlock('condition');
        var mrTypeCd = block.down('xapcombobox[name=mrTypes]');
        mrTypeCd.setData(operation.result.dataList);
    }
});
