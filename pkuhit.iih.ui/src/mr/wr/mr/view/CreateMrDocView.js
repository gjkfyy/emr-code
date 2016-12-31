Ext.define('iih.mr.wr.mr.view.CreateMrDocView',{
	extend : 'Xap.ej.stl.view.TopBottomContainerTemplate',

	requires: [
	    'iih.mr.wr.mr.view.MrTemplateSelectView',
	    'iih.mr.wr.mr.view.MrDocPropertyView',
		'iih.mr.wr.mr.action.MrTemplateSearchAction'
	],

	alias:'widget.createmrdocview',

	xapConfig: {
		blocks: {
		    'top': {
                xclass: 'iih.mr.wr.mr.view.MrTemplateSelectView',
                height:335
            },
			'bottom': {
				xclass: 'iih.mr.wr.mr.view.MrDocPropertyView'
			}
		},
        actions: {
        	'init': {
				xclass: 'iih.mr.wr.mr.action.MrTemplateInitAction'
            }
        },  
        chains: {
        	'init': ['init']
        }
	}
})