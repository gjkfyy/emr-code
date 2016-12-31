Ext.define('Xap.ej.block.PropertyBlock', {
	extend : 'Xap.ej.block.Block',

	alias : 'widget.xappropertyblock',

	getData : function() {
		return this.properties;
	},

	setData : function(data) {
		if(data) {
			if(!this.properties) {
				this.properties = {};
			}
			this.properties = Ext.apply(this.properties, data);
		}
	}
});