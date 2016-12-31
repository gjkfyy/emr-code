Ext.define('iih.po.com.action.LoginKeyAction', {
	extend: 'Xap.ej.action.Action',
	
	/*
	* @Override
	*/
	execute: function(context) {
    	this.callParent();
    	var event = context.event;
    	var args = event.arguments;
        var e = args[1];
        var sp = this.getOwner();
        var chain = sp.getActionChain(args[0]);
        if(e.keyCode==Ext.EventObject.ENTER){
        	if(!chain) {
                chain = sp.getActionChain('login');
            }
            if(chain) {
                chain.execute(context);
            }
        }
    }
});
