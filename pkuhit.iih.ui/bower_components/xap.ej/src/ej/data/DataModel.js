Ext.define('Xap.ej.data.DataModel', {
	/*
	mixins: {
        observable: 'Ext.util.Observable'
    },
    */
    constructor: function() {
        this.callParent(arguments);
        // this.mixins.observable.constructor.call(this, config);
        // this.addEvents('datachanged');

		// this.model = null;
		// this.store = null;
        var arg = arguments[0];
        if(arg) {
        	Ext.apply(this, arg);
        }
        /*
        this.store.on(
        	'datachanged', 
        	this.onStoreDatachanged, 
        	this
        );
        */
    },

	/*
	* 查询数据
	*/
	get: function(context) {
		var condition = context.condition;
		var data = null;
		if(condition) {
			data = condition.data;
		}

		if(!data) {
			data = condition;
		}
		
		if(!data) {
			return this.store.getRange();
		}
		var m = this.model.create(data);
		var id = m.getId();
		if(id) {
			return this.store.getById(id);
		}
		else {
			var r = this.store.queryBy(function(record, id) {
				var b = false;
				for(n in data) {
					var v = data[n];
					if(!v) {
						continue;
					}
					if(v == record.get(n)) {
						b = true;
					} 
					else {
						b = false;
						break;
					}
				}
				return b;
			});
			return r.getRange();
		}
	},

	/*
	* 修改数据
	*/
	save: function(context) {
		var data = context.data;
		if(!data)
			return;
		var newObj = this.model.create(data);
		var oldObj = null;
		var id = newObj.getId();
		if(id) {
			oldObj = this.store.getById(id);
		}
		if(oldObj) {
			// TODO 更新
			this.store.loadRawData(data, true);
		}
		else {
			// 可能ID被自动生成
			this.store.loadRawData(data, true);
		}
		// 保存到Proxy指向的位置
		this.store.sync();
	},

	remove: function(context) {
		// TODO 实现删除
		console.log(context);
	},

	loadData: function(data) {
		this.store.loadRawData(data);
		this.store.sync();
	}
});