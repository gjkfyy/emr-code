Ext.define('Xap.ej.data.Bucket', {
	getName: function() {
		return this.name;
	},

	put: function(obj) {
		var action = Xap.create({
			xclass: 'Xap.ej.action.StorageServiceInvocation',
			url: 'xapss/' + this.name
		});
		Xap.runAction(action, {
			options: {
				method: 'POST',
				success: this.onSuccess,
				scope: this,
				data: obj.data
				// binaryData: obj.data // 字节数组
			}
		});
	},

	onSuccess: function(o) {
        console.log(o);
    },
});