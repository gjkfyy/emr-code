Ext.define('iih.mr.wr.mr.action.MrTypeEditAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
	    var view = this.getOwner();
	    var block = this.getBlock('content');
        if(context.mrtp){
            block.setData(context.mrtp);
        };
	    var chain = view.getActionChain('mrTpCcatSearch');
	    chain.execute();
    }
});
