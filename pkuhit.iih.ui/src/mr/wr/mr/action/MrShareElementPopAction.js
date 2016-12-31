Ext.define('iih.mr.wr.mr.action.MrShareElementPopAction', {
	extend: 'Xap.ej.action.PopAction',

	requires: ['iih.mr.wr.mr.view.MrShareElementEditView'],
	
	execute: function(context) {
	    var data = context.data;
    	var config = {
    	    modal: true,           
    		width: 350,
    		height:200,
    		title : data?'共享元素编辑':'共享元素新增',
    		contentConfig: {
    			xtype: 'mrshareelementeditview',
    			initChain: {
                    name: 'init',
                    context: {
                        'element': data
                    }
                }
    		}
    	};
    	this.callParent([config]);
    }
});
