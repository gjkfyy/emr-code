Ext.define('Xap.ej.stl.action.PopUpCloseAction', {
	extend: 'Xap.ej.action.Action',
	
	/*
	* @Override
	*/
	execute: function(context) {
    	this.callParent();
        this.beforeClosing();
        if(this.target && Ext.isFunction(this.target.close)) {
            this.target.close();
        }
    },

    setTarget: function(target) {
        this.target = target;
    },

    beforeClosing: Ext.emptyFn
});
