/**
 * @author wujunhui<wu.junhui@founder.com>
 * @docauthor wujunhui<wu.junhui@founder.com>
 * 该模板是左右布局的容器模板。定义该模板主要是为了将来对左右布局的画面进行统一修改。
 */
Ext.define('Xap.ej.stl.view.LeftRightContainerTemplate', {
	extend : 'Xap.ej.template.BaseTemplate',

	requires : [
		'Xap.ej.stl.view.PlaceHolderBlock'
	],

	alias : 'widget.xapleftrightcontainertemplate',

	border : 0,

	layout : {
		type: 'hbox',
		align : 'stretch'
	},
	
	defaultXapConfig: {
		blocks: {
			'left': {
				xclass: 'Xap.ej.stl.view.PlaceHolderBlock',
				width:100
			},
			'right': {
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

	getLeftBlock : function() {
		return this.getBlock('left');
	},
	
	getRightBlock : function() {
		return this.getBlock('right');
	}
});
