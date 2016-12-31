Ext.define('iih.mr.dr.condition_set.action.CancelAction', {
	extend: 'Xap.ej.action.Action',
	
	requires: ['Xap.ej.block.Layer'],
	
	execute: function(context) {
    	var owner = this.getOwner();
        var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        var data = properties.getData();
    	owner.ownerCt.close();
    }
});