// 全局唯一的画布
Ext.define('Xap.ej.block.Canvas', {
	extend : 'Xap.ej.block.Block',

	// requires: ['Xap.ej.action.DictionaryAction'],

	singleton: true,

	initBlock : function() {
		/*
		var action = Xap.create({
			xclass: 'Xap.ej.action.DictionaryAction'
		});
		action.addBlock('target', this);
		*/

		this.chain = Xap.create({
			xclass: 'Xap.ej.action.Chain'
		});
		/*
		this.chain.addAction(action);
		*/
	},

	refresh: function(callback) {
		this.chain.execute({
			operations: [],
			callback: callback
		});
	},

	addAction: function(action) {
		if(action) {
			this.chain.addAction(action);
		}
	}
});