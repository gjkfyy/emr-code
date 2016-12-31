Ext.define('iih.mr.wr.nmr.action.BatchPrintAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    /*
     * @Override
     */
    execute: function(context) {
        var operations = context.operations;
        if(!operations) {
            return;
        }
        
        var plugin = document.getElementById('iemrOpenEditor');
        var arrayObj = new Array(0);
    	var emptyParagNames = new Array(0);      	    	
    	plugin.PrintEx(emptyParagNames,arrayObj,false);
    }
});
