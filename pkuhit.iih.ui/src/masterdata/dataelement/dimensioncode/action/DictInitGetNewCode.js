Ext.define('iih.masterdata.dataelement.dimensioncode.action.DictInitGetNewCode', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	execute: function(context) {
		var data = {
			tableName : 'MD_META_ELEMENT'
		}
	  	var operations = context.operations;
    	this.prepareOperations(operations, data);

	 },
	 prepareOperations: function(operations, data) {
		 var url = this.url;
    	var operation = {
            url: url ,
    		mclass: null,
    		method: 'get',
    		condition: null,
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.length = 0;
    	operations.push(operation);
    },

    onSuccess: function(operation) {
        var block = this.getBlock('top');
        var m = operation.result; 
    	var block = this.getBlock('result');
    	var form = block.getForm('xapform');
    	var data = {
    			dataElementCd:m
    			,dataElementNm:''
    	}/*dataElementCd: "376", dataElementNm: "饮酒史组合"*/
    	var dataElementCdTxtBox = form.getFields('dataElementCd') ;
    	form.setValues(data);  
    }
});
