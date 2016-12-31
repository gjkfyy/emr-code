/**
 * @author wujunhui<wu.junhui@founder.com>
 * @docauthor wujunhui<wu.junhui@founder.com>
 * 该模板是上下布局的容器模板。定义该模板主要是为了将来对上下布局的画面进行统一修改。
 */
Ext.define('Xap.ej.stl.view.TopBottomContainerTemplate', {
	extend : 'Xap.ej.template.BaseTemplate',

	requires : [
		'Xap.ej.stl.view.PlaceHolderBlock'
	],

	alias : 'widget.xaptopbottomcontainertemplate',

	border : 0,

	layout : {
		type: 'vbox',
		align : 'stretch'
	},
	
	defaultXapConfig: {
		blocks: {
			'top': {
				xclass: 'Xap.ej.stl.view.PlaceHolderBlock',
				height:100
			},
			'bottom': {
				xclass: 'Xap.ej.stl.view.PlaceHolderBlock',
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

	getTopBlock : function() {
		return this.getBlock('top');
	},
	
	getBottomBlock : function() {
		return this.getBlock('bottom');
	}
});
