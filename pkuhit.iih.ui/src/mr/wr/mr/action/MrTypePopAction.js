Ext.define('iih.mr.wr.mr.action.MrTypePopAction', {
	extend: 'Xap.ej.action.PopAction',

	requires: ['iih.mr.wr.mr.view.MrTypeEditView'],
	
	execute: function(context) {
	    var mrtp = context.mrtp;
    	var config = {
    	    modal: true,           
    		width: 400,
    		height:422,
    		title : mrtp?'病历文书类型编辑':'病历文书类型新增',
    		contentConfig: {
    			xtype: 'mrtypeeditview',
    			initChain: {
                    name: 'init',
                    context: {
                        'mrtp': mrtp
                    }
                }
    		}
    	};
    	this.callParent([config]);
    }
});
