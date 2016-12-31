Ext.define('iih.mr.wr.omr.view.CreateOmrDocView',{
	extend : 'Xap.ej.template.BaseTemplate',

	requires: [
	    'iih.mr.wr.omr.view.OmrTemplateSelectView',
	    'iih.mr.wr.omr.view.OmrDocPropertyView',
		'iih.mr.wr.omr.action.OmrTemplateSearchAction'
	],

	alias:'widget.createomrdocview',

	xapConfig: {
		blocks: {
		    'content': {
                xclass: 'iih.mr.wr.omr.view.OmrTemplateSelectView',
                height:427
            }/*,
			'bottom': {
				xclass: 'iih.mr.wr.omr.view.OmrDocPropertyView',
				height:120
			}*/
		}
	}
})