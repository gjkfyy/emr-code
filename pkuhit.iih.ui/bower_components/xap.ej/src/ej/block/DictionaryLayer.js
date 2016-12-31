Ext.define('Xap.ej.block.DictionaryLayer', {
	extend : 'Xap.ej.block.Layer',

	requires: [
		'Xap.ej.action.Chain',
		'Xap.ej.action.DictionaryAction',
		'Xap.ej.element.field.ComboBox'
	],

	getData: function() {
		if(!this.data) {
			this.data = {};
		}
		var canvas = Xap.getCanvas();
		var canvasLayer = canvas.getLayer(Xap.ej.block.Layer.DEFAULT);
		var global = canvasLayer.getData();
		for(var name in this.data) {
			var d = this.data[name];
			if(d && !d.data) {
				var gd = global[name];
				if(gd && gd.data) {
					d.data = gd.data;
				}
			}
		}
		return this.data;
	},

	setData: function(data, callback) {
		// TODO call parent
		if(!this.data) {
			this.data = {};
		}
		
		if(data) {
			this.data = Ext.apply(this.data, data);
		}

		var to = {};
		for(var name in this.data) {
			var d = this.data[name];
			to[name] = d;
			// 如果没有数据，需要从全局Canvas取得
			/*
			if(d && (!d.data || d.data.length <= 0)) {
				to[name] = d;
			}*/
		}
		var canvas = Xap.getCanvas();
		var canvasLayer = canvas.getLayer(Xap.ej.block.Layer.DEFAULT);
		canvasLayer.setData(to);
		canvas.refresh(callback);
	},

	render: function() {
		// TODO 这里假设Owner是Form，需要修改支持更多组件
		var owner = this.getOwner();
		// TODO 监听comboxready事件，然后初始化所有下拉列表
		// TODO仅针对grid和form监听
		owner.on('combochange', this.onInputChanged, this);
		owner.on('comboxready', function(combos){
			// 收集数据
			var data = {};
			for(var n in combos) {
				var combo = combos[n];
				if(combo.dictionary && combo instanceof Xap.ej.element.field.ComboBox) {
					data[combo.dictionary] = {
						data: combo.getData()
					};
				}
			}
			// 初始化Layer，成功后填充字典相关组件
			this.setData(data, function(canvasLayer) {
				var d = canvasLayer.getData();
				for(var n in combos) {
					var combo = combos[n];
					var obj = d[combo.dictionary];
					if(obj) {
						combo.setData(obj.data);
					}
				}
				if(owner instanceof Xap.ej.element.grid.Grid) {
					var comboxs = owner.query("xapcombobox");
					Ext.Array.forEach(comboxs,function(combox,index,array){
						combox.setData(combos[combox.dictionary].getData());
					});
				}
			});
		}, this);
		// 字典相关
		// var components = Ext.ComponentQuery.query("xapcombobox", owner);
	},

	// @Override
	/*
	setOwner: function(owner) {
		this.callParent([owner]);
		// 找到所有Comboxgrid，监听inputchange事件
		var combogrids = Ext.ComponentQuery.query("comboxgrid", owner);
		Ext.Array.forEach(combogrids, function(cg, index, array) {
			if(cg.dictionary) {
				// scope设置为组件对象
				cg.on('combochange', this.onInputChanged, this);
			}
		}, this);

		var grids = Ext.ComponentQuery.query("xapgrid", owner);
		Ext.Array.forEach(grids, function(grid, index, array) {
			grid.on('combochange', this.onInputChanged, this);
		}, this);
	},*/

	onInputChanged: function(obj, combo) {
		var component = combo;
		var chain = this.getChain();
		// TODO 支持多参数
		var param = {
			id: obj.dictionary
		};
		param[obj.searchParam[0]] = obj.searchValue;
		chain.execute({
			operations: [],
			params: [param],
			callback: function(data) {
				for(var n in data) {
					var d = data[n];
					if(d) {
						component.setData(d.data);
						break;
					}
				}
			}
		});
	},

	getChain: function() {
		if(!this.chain) {
			// TODO 构造函数创建
			this.chain = Xap.create({
				xclass: 'Xap.ej.action.Chain'
			});
			var action = Xap.create({
				xclass: 'Xap.ej.action.DictionaryAction'
			});
			this.chain.addAction(action);
		}
		return this.chain;
	}
});