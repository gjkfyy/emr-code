Ext.define('iih.mr.wr.nmr.action.NmrShowCreateAction', {
	extend: 'Xap.ej.action.PopAction',

	requires: ['iih.mr.wr.nmr.view.CreateDocView'],
	

	execute: function(context) {
	        var config = {
                modal: true,           
                width: 850,
                height:500,
                title :'新建护理记录',
                contentConfig: {
                    xtype: 'createdocview',
                    initChain: {
                       // name: 'search'
                    }
                }
            };
	    
    	
    	this.callParent([config]);
    }
});
