/**
 * @author tian_yuyan<tian_yuyan@founder.com>
 * @docauthor tian_yuyan<tian_yuyan@founder.com>
 * 该模板是border布局的容器模板。
 */
Ext.define('Xap.ej.stl.view.TopBottomSplitTemplate', {
	extend : 'Xap.ej.template.BaseTemplate',

	requires : [
		'Xap.ej.stl.view.PlaceHolderBlock'
	],

	alias : 'widget.xaptopbottomsplittemplate',

	border : 0,

	layout: 'border', 
	
	defaultXapConfig: {
		blocks: {	
			/*
			 * south,east,north,南,东,北三种布局默认不加到模板中，
			 * 如果有需要，需要在实现中自己实现
			 */
			'top': {
				xclass: 'Xap.ej.element.panel.Panel',				
				region: 'center'
			},
			'bottom': {	
				xclass: 'Xap.ej.element.panel.Panel',	
				region:'south',
				split: true
			},
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
