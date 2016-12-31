Ext.define('iih.sy.config.action.CancelAction', {
	extend: 'Xap.ej.action.Action',
	
	requires: [],
	
	execute: function(context) {
		var owner = this.getOwner();
		var block = this.getBlock('context');
	    var win = block.up('window');
	    win.close();
    }
});