Ext.define('iih.sy.search.view.AdvancedSearchView', {
	extend : 'Xap.ej.stl.view.LeftRightContainerTemplate',
	alias : 'widget.advancedsearchview',
	requires : [ 'iih.sy.search.view.SearchLeftView',
			'iih.sy.search.view.SearchContentView' ],

	xapConfig : {
		blocks : {
			'left' : {
				xclass : 'iih.sy.search.view.SearchLeftView',
				width : 350,
				region : 'west',
				split : false,
				collapsible : true,
				header : false
			},
			'right' : {
				xclass : 'iih.sy.search.view.SearchContentView',
				flex : 1
			}
		},

		actions : {

		},
		chains : {

		},

		connections : {

		}
	}
});