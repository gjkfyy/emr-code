Ext.define('iih.mr.wr.mr.block.MrDocSortTreeBlock', {
	extend : 'Xap.ej.block.FormBlock',

	requires : [ 'Xap.ej.element.tree.Tree' ],
	alias : 'widget.mrdocsorttreeblock',

	title : '病历文书分类',

	autoScroll: true,
	items : [ {
		xtype : 'xaptree',
		//layout : 'fit',
		name : 'MrDocSortTree',
		selectBy : 'id',
		rootVisible : false,
		border : 0
	}, {
		xtype : 'xaptree',
		title:'病历文书模板',
		layout : 'fit',
		name : 'mrTempSortTree',
		id:'mrTempSortTree',
		selectBy : 'id',
		rootVisible : false,
		border : 0
	} ],

	setData : function(data) {
		var tree = this.down('xaptree[name=MrDocSortTree]');
		if (tree) {
			var myobj = eval(data);
			tree.setData(myobj);
		}

	},
	getData : function() {
		return null;
	}
})