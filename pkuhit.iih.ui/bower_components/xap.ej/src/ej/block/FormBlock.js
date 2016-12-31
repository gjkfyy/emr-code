Ext.define('Xap.ej.block.FormBlock', {
	// extend : 'Ext.form.Panel',
	extend: 'Xap.ej.element.form.Form',

	requires : [
		'Xap.ej.block.Block',
		'Xap.ej.block.Layer'
	],

	alias : 'widget.xapformblock',

	mixins : ['Xap.ej.block.Block'],
	
	constructor: function(config) {
		//为了提供table布局的灵活性，对ext的table布局增强了列均等的特性。
		//在使用table布局时，通过设置layout.xapExt值为true打开这一特性。
		//当打开列均等特性后，会自动生成一行高度为2像素的伪列并设置列的
		//CSS属性width为[100/totalCols+'%']，让浏览器渲染时能够保证列的
		//的宽度均等。
		//Added by wujunhui<wu.junhui@founder.com> 2014/8/11
		var layout = config.layout || this.layout || {};
		var items = config.items || this.items;
		if (layout && layout.type == 'table' && layout.columns > 0 && layout.xapExt) {
		  var dummyCells = [], totalCols = layout.columns;
		  for (var i=0; i<totalCols; i++) {
		    Ext.Array.push(dummyCells, {
		        xtype: 'tbspacer',
		        colspan:1});
		  }
		  Ext.Array.insert(items, 0, dummyCells);
		      
		  layout.tdAttrs = layout.tdAttrs || {};
		  Ext.merge(layout.tdAttrs, {style:{width:100/totalCols+'%'}});
		}
		//End

		this.callParent([config]);
	},

	initComponent: function() {
		Xap.debug('begin...');
		this.callParent();
		this.initBlock();
		this.refreshLayers();
		
		Xap.debug('end...');
	},

	refreshLayers: function() {
		// TODO 插件，插入各种层 xap.core.block.form
		// 取得字典数据层
		var dict = this.getLayer(Xap.ej.block.Layer.DICTIONARY);
		dict.render();
	},
	
	getModelClass : function() {
		return this.mclass;
	},

	getItemData : function(item) {
		var data = {};

		if (item instanceof Xap.ej.block.Block) {
			data = Ext.apply(data, item.getData());
		} else {
			if (Ext.isFunction(item.getValue)) {
				data[item.name || item.xtype + Ext.id()] = item
						.getValue();
			} else if (item instanceof Ext.container.Container) {
				var items = item.items;
				for (var i = 0; i < items.length; i++) {
					data = Ext.apply(data, this
									.getItemData(items.items[i]));
				}
			}
		}
		return data;
	},

  /**
   * 从FormBlock块获取页面数据(FormBlock里面不允许再嵌套FormBlock)。
   * 返回的数据结构约定如下：
   *  {
   *      name1:value1,
   *      name2:value2,
   *      //xapgrid元素时，key名称应该与元素的xapId属性保持一致。数据结构与元素的setData方法保持一致，
   *      //详细数据结构请参考Xap.ej.element.grid.Grid类的getData方法。
   *      xapId1:{       
   *        total:99,
   *        results:[]
   *      },           
   *      //xaptree元素时，key名称应该与元素的xapId属性保持一致。数据结构与元素的setData方法保持一致，
   *      //详细数据结构请参考Xap.ej.element.tree.Tree类的getData方法。
   *      xapId2:[{}]   //xaptree元素的xapId
   *      }
   *  }
   * 
   * @return {} Block块页面数据
   */
  getData : function() {
    Xap.debug('begin...');
    var me = this;
    var formData = me.getValues();
    var gridtreeComponents = me.query('xapgrid, xaptree');
    Ext.Array.each(gridtreeComponents, function(item) {
        formData[item.xapId] = item.getData();
    });
    
    Xap.debug('end...');
    return formData;
  },

  /**
   * 设置数据到FormBlock块(FormBlock里面不允许再嵌套FormBlock)。
   * @param {Object} formData 设定到块的数据.
   *  {
   *      name1:value1,
   *      name2:value2,
   *      //xapgrid元素时，key名称应该与元素的xapId属性保持一致。数据结构与元素的setData方法保持一致，
   *      //详细数据结构请参考Xap.ej.element.grid.Grid类的setData方法。
   *      xapId1:{       
   *        total:99,
   *        results:[]
   *      },           
   *      //xaptree元素时，key名称应该与元素的xapId属性保持一致。数据结构与元素的setData方法保持一致，
   *      //详细数据结构请参考Xap.ej.element.tree.Tree类的setData方法。
   *      xapId2:[{}]   //xaptree元素的xapId
   *  }
   */
  setData : function(formData) {
    Xap.debug('begin...');
    var me = this;
    if (Ext.isObject(formData)) {
      me.getForm().setValues(formData);
      Ext.Object.each(formData, function(key, item) {
          var selector = 'xapgrid[xapId=' + key + '], xaptree[xapId=' + key + ']';
          var itemComponent = me.query(selector)[0];
          if (itemComponent && itemComponent.setData) {
            itemComponent.setData(item);
          }
      });
    } else {
      Xap.debug('The format of formData is not correct.');
    }
    Xap.debug('end...');
  }
});