Ext.define('iih.sy.patient.view.CreateOmrDocView',{
	extend : 'Xap.ej.template.BaseTemplate',

	requires: [
	    'iih.sy.patient.view.OmrTemplateSelectView',
	    'iih.sy.patient.view.OmrDocPropertyView',
		'iih.sy.patient.action.OmrTemplateSearchAction'
	],

	alias:'widget.createomrdocview',

	xapConfig: {
		blocks: {
			'content': {
                xclass: 'iih.sy.patient.view.OmrTemplateSelectView',
                height:427
            }/*,
			'bottom': {
				xclass: 'iih.mr.wr.omr.view.OmrDocPropertyView',
				height:120
			}*/
		}
	}
})