/**
 * @author dan_zhang
 * @docauthor dan_zhang
 * 该模板是可以手动改变大小的模板。
 */
Ext.define('Xap.ej.stl.view.LeftRightSplitTemplate', {
	extend : 'Xap.ej.template.BaseTemplate',

	requires : [
		'Xap.ej.stl.view.PlaceHolderBlock'
	],

	alias : 'widget.xapleftrightsplittemplate',

	border : 0,

	layout: 'border', 
	
	defaultXapConfig: {
		blocks: {	
			//west布局，默认宽度为100可自行修改
			'left': {
				xclass: 'Xap.ej.element.panel.Panel',
				header:false,
				region:'west',
				split: true,
				collapsible: true
			},
			//center布局，必须存在,否则extjs4后会报错
			'right': {
				xclass: 'Xap.ej.element.panel.Panel',				
				region: 'center'
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
