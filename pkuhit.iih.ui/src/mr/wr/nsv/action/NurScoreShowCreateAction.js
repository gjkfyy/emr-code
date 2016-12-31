Ext.define('iih.mr.wr.nsv.action.NurScoreShowCreateAction', {
	extend: 'Xap.ej.action.PopAction',

	requires: ['iih.mr.wr.nsv.view.CreateNurScoreDocView'],
	

	execute: function(context) {
	        var config = {
                modal: true,           
                width: 850,
                height:500,
                title :'新建护理评分',
                contentConfig: {
                    xtype: 'createnurscoredocview',
                    initChain: {
                       // name: 'search'
                    }
                }
            };
	    
    	
    	this.callParent([config]);
    }
});
