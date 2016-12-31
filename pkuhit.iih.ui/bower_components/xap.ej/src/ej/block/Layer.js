/*
* 块（Block）由多个层次（Layer）组成，目前一般只有一个层次
*/
Ext.define('Xap.ej.block.Layer', {
	requires : [],

	statics: {
		PROPERTIES: 'properties',

		CANVAS: 'canvas',

		DICTIONARY: 'dictionary',

		DEFAULT: 'default'
	},

	// 取得所有者，其实就是块（Block）
	getOwner: function() {
		return this.owner;
	},

	// 设置所有者
	setOwner: function(owner) {
		this.owner = owner;
	},

	// 取得数据
	getData: function() {
		return this.data;
	},

	// 设置数据
	setData: function(data) {
		if(!this.data) {
			this.data = {};
		}
		
		if(data) {
			this.data = Ext.apply(this.data, data);
		}
	},

	// 绘制，通常是根据数据（Data）向所在（Owner）绘图
	render: Ext.emptyFn
});