Ext.define('iih.mr.action.editor.EmrCmdDispatchAction', {
	extend: 'Xap.ej.action.Action',
	
	/*
	* @Override
	*/
	execute: function(context) {
	    Ext.useShims=true;
	    this.callParent();    
        var event = context.event;
        var method = event.arguments[0];
        var owner = this.getOwner();
        var chain = owner.getActionChain(method);
        if(!chain) {
            chain = owner.getActionChain('task');
        }
        if(chain) {
            chain.execute(context);
        }
    }
});
