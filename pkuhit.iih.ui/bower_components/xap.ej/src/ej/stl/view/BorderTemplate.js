/**
 * @author tian_yuyan<tian_yuyan@founder.com>
 * @docauthor tian_yuyan<tian_yuyan@founder.com>
 * 该模板是border布局的容器模板。
 */
Ext.define('Xap.ej.stl.view.BorderTemplate', {
	extend : 'Xap.ej.template.BaseTemplate',

	requires : [
		'Xap.ej.stl.view.PlaceHolderBlock'
	],

	alias : 'widget.xapbordertemplate',

	border : 0,

	layout: 'border', 
	
	defaultXapConfig: {
		blocks: {	
			/*
			 * south,east,north,南,东,北三种布局默认不加到模板中，
			 * 如果有需要，需要在实现中自己实现
			/*'south': {				
				region:'south', 
				height:0
			},*/
			//west布局，默认宽度为250可自行修改
			'west': {
				xclass: 'Xap.ej.element.panel.Panel',
				header:false,
				region:'west',
				split: true,
				collapsible: true, 
				width:250
			},
			//center布局，必须存在,否则extjs4后会报错
			'center': {
				xclass: 'Xap.ej.element.panel.Panel',				
				region: 'center', 
				margins: '0 5 0 0', 
				flex:1
			}
		}
	},

	initBlock : function() {
		this.callParent();
	},

	doCheckXapConfig: function() {
		// TODO 必须包括的Action等等...
	},
	
	//getWestBlock,getCenterBlock,默认提供拿到'west'和'center'的block方法
	getWestBlock : function() {
		return this.getBlock('west');
	},
	
	getCenterBlock : function() {
		return this.getBlock('center');
	}
});
