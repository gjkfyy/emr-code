Ext.define('iih.mr.wr.nmr.action.ShowEmrImageAction', {
	extend: 'Xap.ej.action.PopAction',

	requires: ['iih.mr.wr.nmr.view.CreateImageElementView'],
	

	execute: function(context) {
	        var config = {
	        	modal: true,           
                width: 595,
                height:475,
                title :'添加图片',
                contentConfig: {
                    xtype: 'createimageelementview',
                    initChain: {
                        name: 'createImage'
                    }
                }
            };
	    
    	
    	this.callParent([config]);
    }
});
