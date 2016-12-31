Ext.define('iih.mr.wr.mr.action.MrShareElementEditAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
	    if(context.element){
	        console.log(context.element);
	        var block = this.getBlock('content');
	        block.setData(context.element);
	    }
    }
});
