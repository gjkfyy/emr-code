Ext.define('iih.mr.wr.mr.action.EnterPressAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
		var arguments = context.event.arguments[1];
		if (arguments.keyCode == 13){
			var result = this.getOwner();
	        var initChain = result.getActionChain('init');
	        initChain.execute();
        }
    }
});
