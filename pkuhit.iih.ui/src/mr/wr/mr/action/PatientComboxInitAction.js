Ext.define('iih.mr.wr.mr.action.PatientComboxInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
    /*
	    * @Override
	    */
	    execute: function(context) {
//	        this.callParent();
//	        var operations = context.operations;
//	        if(!operations) {
//	            return;
//	        };
	        
//	        console.log("this is mrdoclistinitaction 11111111111111111111111"); 
	        this.prepareOperations(context.operations);
	    },
	    /*
	     * @return {mclass: '', condition: {}}
	     */
	    prepareOperations: function(operations) {
	         
	         var url = this.url;
	         var operation = {
	             url: url,
	             method: 'get',
	             scope: this,
	             success: this.onSuccess
	         };
	         operations.push(operation);
	     },
	     onSuccess: function(operation) {
	         var block = this.getBlock('condition');
	         var combox = block.down('[name=patient]');
	         var m = operation.result;
	         var data;
	         if(!Ext.isEmpty(m, false)){
	             data = m.data;
	             if(data) {
	                 combox.setData(eval(data));
	             }
	         }

	     }
    
	    
});
