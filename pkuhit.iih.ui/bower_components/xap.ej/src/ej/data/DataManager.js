Ext.define('Xap.ej.data.DataManager', {

	extend: 'Ext.util.MixedCollection',

	requires: [
		'Xap.ej.data.DataModel',
		'Xap.ej.data.Bucket'
	],

	singleton: true,

	dms: {},

	createDataModel: function(context) {
		var key = context.key;
		var dm = this.getDataModel(key);
		// 已经创建过，直接返回
		if(dm)
			return dm;

		var m = this.findModel(context);
		// 没有数据模型的定义，返回空
		if(!m)
			// TODO log
			return null;

		var sm = Ext.data.StoreManager.lookup(key);
		if(!sm) {
			sm = Xap.create({
				xclass: 'Ext.data.Store',
				model: context.mclass,
				// TODO class as id?
				storeId: key
			});
		}
		dm = Xap.create({
			xclass: 'Xap.ej.data.DataModel',
			model: m,
			store: sm
		});
		// 保存数据模型对象
		this.dms[key] = dm;
		return dm;
	},

	findModel: function(context) {
		var mc = context.mclass;
		var obj = Ext.ModelManager.getModel(mc);
		if(!obj)
			return null;

		// TODO 没有Proxy才设置Proxy
		obj.setProxy({
			type: 'localstorage',
			id  : mc
		});
		return obj;
	},

	getDataModel: function(key) {
		return this.dms[key];
	},

	/*
	* @param config.model
	* @param config.data
	*/
	loadData: function(config) {
		if(!config.model)
			return;
		var key = config.url;
		if(!key) {
			key = config.model;
		}
		var dm = this.createDataModel({
			key: key,
			mclass: config.model
		});
		dm.loadData(config.data);
	},

	getBucket: function(name) {
		if(!this.nativeBinarySupport()) {
			Xap.debug('native binary is not supported in this browser!');
			// TODO return dummyLocalBucket
			return null;
		}
		if(name) {
			var bucket = Xap.create({
				xclass: 'Xap.ej.data.Bucket'
			});
			bucket.name = name;
			return bucket;
		}
	},

    nativeBinarySupport: function() {
        return Ext.isChrome ||
            (Ext.isSafari && Ext.isDefined(window.Uint8Array)) ||
            (Ext.isGecko && Ext.isDefined(window.Uint8Array));
    }
});