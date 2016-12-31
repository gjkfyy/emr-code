Ext.define('iih.mr.wr.mr.action.MrDocTreeSelectAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
    /*
	    * @Override
	    */
    execute: function(context) {
    	if(context.event){
    		var ccatCode = context.event.arguments[1].raw.id;
    	};
        var encounterSn = IMER_GLOBAL.encounterSn;
        this.prepareOperations(context.operations,encounterSn,ccatCode);
    },
    prepareOperations: function(operations,encounterSn,ccatCode) {
         
         var url = this.url+'?encounterPk='+encounterSn+'&mrTypeCustomCode='+ccatCode;
         var operation = {
             url: url,
             method: 'get',
             scope: this,
             success: this.onSuccess
         };
         operations.push(operation);
     },
     onSuccess: function(operation) {
         var block = this.getBlock('result');
         // TODO 数据格式就这样了？
         if(operation.result.dataList){
     	 	 block.setData(operation.result.dataList);
         }else{
        	 block.setData(null);
         }
     }
});
