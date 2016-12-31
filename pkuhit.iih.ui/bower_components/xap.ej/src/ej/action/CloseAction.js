Ext.define('Xap.ej.action.CloseAction', {
	extend: 'Xap.ej.action.Action',
	
	requires: [
        'Xap.ej.action.Action'
    ],
	 
    execute: function(context) {
        this.callParent();
        if(this.targetBlock) {
            this.targetBlock.close();
        }
    }
});
