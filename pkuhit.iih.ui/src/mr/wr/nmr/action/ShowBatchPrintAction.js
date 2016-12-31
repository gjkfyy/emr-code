Ext.define('iih.mr.wr.nmr.action.ShowBatchPrintAction', {
	extend: 'Xap.ej.action.PopAction',

	requires: ['iih.mr.wr.nmr.view.BatchPrintView'],
	

	execute: function(context) {
	        var config = {
	        	modal: true,           
                width: 850,
                height:575,
                title :'批量打印',
                contentConfig: {
                    xtype: 'batchprintview',
                    initChain: {
                        //name: 'createImage'
                    }
                }
            };
	    
    	
    	this.callParent([config]);
    }
});
