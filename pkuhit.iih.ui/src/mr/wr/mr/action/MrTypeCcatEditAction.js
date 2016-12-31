Ext.define('iih.mr.wr.mr.action.MrTypeCcatEditAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
	    if(context.mrtpccat){
	        console.log(context.mrtpccat);
	        var block = this.getBlock('content');
	        block.setData(context.mrtpccat);
	    }
    }
});
