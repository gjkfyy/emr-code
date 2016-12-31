Ext.define('iih.mr.wr.mr.action.CreateMrDocAction', {
	extend: 'Xap.ej.action.PopAction',

	requires: ['iih.mr.wr.mr.view.CreateMrDocView'],
	
	/*
	* @Override
	*/
	execute: function(context) {
		var block = this.getBlock('result');
		var tree=block.down('xaptree');
		var select = tree.getSelectionModel().getSelection();
		var workpageview = this.getOwner().ownerCt.items.items[1];
		var ccatCode = '';
		var mrTpCd = '';
		if(select.length>0){
			ccatCode = select[0].raw.id;
		};
		if(context.mrTpCcatCd)ccatCode=context.mrTpCcatCd;
		if(context.mrTpCd)mrTpCd=context.mrTpCd;
    	var config = {
    	    modal: true,           
    		width: 820,
    		height:478,
    		title :'病历新建',
    		contentConfig: {
    			xtype: 'createmrdocview',
    			initChain: {
    				name: 'init',
    				context: {
    					id:ccatCode,
    					mrTpCd:mrTpCd,
    					workpageview:workpageview
    				}
    			}
    		}
    	};
    	this.callParent([config]);
    }
});
