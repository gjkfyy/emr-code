// TODO 修改类名
Ext.define('Xap.ej.stl.action.ProcessDispatchAction', {
	extend: 'Xap.ej.action.Action',
	
	/*
	* @Override
	*/
	execute: function(context) {
    	this.callParent();
    	// tasksubmit
    	var event = context.event;
    	// TODO 从event中取得
    	var method = event.arguments[0];
    	var owner = this.getOwner();
    	var chain = owner.getActionChain(method);
        if(!chain) {
            chain = owner.getActionChain('task');
        }
    	if(chain) {
            // TODO Context
            chain.execute(context);
    	}
    }
});
