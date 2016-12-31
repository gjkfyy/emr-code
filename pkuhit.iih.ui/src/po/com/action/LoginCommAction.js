Ext.define('iih.po.com.action.LoginCommAction', {
    extend: 'Xap.ej.action.Action',
	/*
	* @Override
	*/
    execute: function(context) {
    	this.callParent();
    	var view = this.getOwner();
    	var block = this.getBlock('lvblock');
    	var data = block.getForm().getValues();
    	if(data.caLogin){
    	    var chain = view.getActionChain('caLogin');
            chain.execute();
    	}else{
        	var chain = view.getActionChain('login');
        	chain.execute();
    	}
    }
});
