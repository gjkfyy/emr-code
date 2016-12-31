Ext.define('iih.mr.wr.omr.action.OmrTypeSearchAction', {
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
        var condition={"mrTypeCustomCategoryCd":mrCustClaCd,"enTypeCd":'ENM01.01'};
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
    	var owner=this.getOwner()
        var block = this.getOwner().getBlock('condition');
        var mrTypeCd=block.down('[name=typeCode]');
    	if(operation.result.dataList){
    		var mrTypeCd2=owner.mrTypeCd;
            mrTypeCd.setData(operation.result.dataList);
            if('MRM16.18'==mrTypeCd2){
            	owner.mrTypeCd=undefined;
            	mrTypeCd.select('MRM16.18');
            }else{
            	mrTypeCd.select('ALL');
            }
            //if(mrCustClaCd!='ALL')mrTypeCd.expand();
        }else{
            mrTypeCd.setData([]);
        }
    	var result = this.getOwner();
        var initChain = result.getActionChain('init');
        initChain.execute();
    }
});
