/**
 * @author wujunhui<wu.junhui@founder.com>
 * @docauthor wujunhui<wu.junhui@founder.com>
 * 模板中的预留块,请使用实际业务中需要的块替换它。
 */
Ext.define('Xap.ej.stl.view.PlaceHolderBlock', {
	extend : 'Xap.ej.block.FormBlock',

	requires : [
		'Xap.ej.block.FormBlock'
	],

	alias : 'widget.xapplaceholderblock',

	border : 1,
	
	height : 50,
	
	items : [
	{html:'替换此区域为业务BLOCK'}
	]
});
