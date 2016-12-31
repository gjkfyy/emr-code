Ext.define('iih.mr.wr.mr.view.MrTypeCcatView', {
	extend: 'Xap.ej.template.BaseTemplate',

	requires: ['Xap.ej.element.grid.Grid'],
    
	alias:'widget.mrtypeccatview',
	
	id: 'mrtypeccatviewid',

	border: 0,
    
    layout: 'fit',
    
	xapConfig: {
		
		blocks: {
			'content': {
		        xclass: 'iih.mr.wr.mr.block.MrTypeCcatBlock'
            }
		},
        actions: {
            'search': {
                xclass: 'iih.mr.wr.mr.action.MrTypeCcatSearchAction',
                url:'mr/md/mrccat',
                blocks: {
                   content: 'content'
                }
            },
        	'open': {
				xclass: 'iih.mr.wr.mr.action.MrTypeCcatPopAction',
				blocks: {
				   content: 'content'
				}
            },
            'delete': {
                xclass: 'iih.mr.wr.mr.action.MrTypeCcatDelAction',
                url:'mrtypecustomcategory',
                blocks: {
                   content: 'content'
                }
            }
        },  
        chains: {
            'search': ['search'],
        	'open': ['open'],
        	'delete': ['delete']
        },
        connections: {
        	'content': [{
                event: 'afterrender',
                chain: 'search'
            }]
        }
	},
	initComponent : function() {
		this.callParent();
	}
});