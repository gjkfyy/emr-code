Ext.define('iih.mr.wr.mr.action.MrTypeCcatPopAction', {
	extend: 'Xap.ej.action.PopAction',

	requires: ['iih.mr.wr.mr.view.MrTypeCcatEditView'],
	
	execute: function(context) {
	    var mrtpccat = context.mrtpccat;
    	var config = {
    	    modal: true,           
    		width: 350,
    		height:280,
    		title : mrtpccat?'病历文书类型组编辑':'病历文书类型组新增',
    		contentConfig: {
    			xtype: 'mrtypeccateditview',
    			initChain: {
                    name: 'init',
                    context: {
                        'mrtpccat': mrtpccat
                    }
                }
    		}
    	};
    	this.callParent([config]);
    }
});
