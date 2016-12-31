Ext.define('iih.mr.wr.mr.view.MrShareElementView', {
	extend: 'Xap.ej.template.BaseTemplate',

	requires: ['Xap.ej.element.grid.Grid'],
    
	alias:'widget.mrshareelementview',
	
	id: 'mrshareelementid',

	border: 0,
    
    layout: 'fit',
    
	xapConfig: {
		
		blocks: {
			'content': {
		        xclass: 'iih.mr.wr.mr.block.MrShareElementBlock'
            }
		},
        actions: {
            'search': {
                xclass: 'iih.mr.wr.mr.action.MrShareElementSearchAction',
                url:'mr/md/shareElement',
                blocks: {
                   content: 'content'
                }
            },
        	'open': {
				xclass: 'iih.mr.wr.mr.action.MrShareElementPopAction',
				blocks: {
				   content: 'content'
				}
            },
            'delete': {
                xclass: 'iih.mr.wr.mr.action.MrShareElementDelAction',
                url:'mr/md/shareElement',
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
            },{
                selector: 'xapgrid',
                event: 'turnpage',
                chain: 'search'
            }]
        }
	},
	initComponent : function() {
		this.callParent();
	}
});