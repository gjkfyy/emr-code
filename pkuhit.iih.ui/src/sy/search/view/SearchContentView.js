Ext.define('iih.sy.search.view.SearchContentView', {
			extend : 'Xap.ej.stl.view.LeftRightContainerTemplate',
			alias : 'widget.searchcontentview',
			requires : ['iih.sy.search.view.SearchLeftView'],

			xapConfig : {
				blocks : {
					'left' : {
						xclass : 'iih.sy.search.view.SearchLeftView',
						width : 350,
						region:'west',
						split: true,
		                collapsible: true,
		                header:false
					},
					'right' : {
						xclass : 'iih.sy.search.block.AdvancedSearchBlock',
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