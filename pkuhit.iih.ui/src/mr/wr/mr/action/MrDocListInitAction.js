Ext.define('iih.mr.wr.mr.action.MrDocListInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
    /*
	    * @Override
	    */
	    execute: function(context) {
	    	/*var owner = this.getOwner();
	        var chain = owner.getActionChain('btnUsable');
	        if(chain) {
	            chain.execute();
	        }*/
	        var encounterSn = IMER_GLOBAL.encounterSn;
	        var me=this;
	        this.prepareOperations(context.operations,encounterSn);
	    },
	    /*
	     * @return {mclass: '', condition: {}}
	     */
	    prepareOperations: function(operations,encounterSn) {
	         
	         var url = this.url+'?encounterPk='+encounterSn;
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
	         block.setData(operation.result.dataList);
	     }
});
