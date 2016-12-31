Ext.define('iih.mr.qa.pat_case.view.PatCasePopView',{
	extend : 'Xap.ej.template.BaseTemplate',

	requires: [
	    'iih.mr.qa.pat_case.block.PatCaseBlock',
	    'iih.mr.qa.pat_case.action.PatCaseInitAction'
	],

	alias:'widget.patcasepopview',
	
	xapConfig: {
		blocks: {
		    'content': {
                xclass: 'iih.mr.qa.pat_case.block.PatCaseBlock',
                flex:1
            }
		},
        actions: {
        	'init': {
				xclass: 'iih.mr.qa.pat_case.action.PatCaseInitAction',
				url:'externalInterf',
		        blocks: {
		            content:'content'
		        }
        }},  
        chains: {
        	'init': ['init']
        },
        connections: {
			'content': [{
				event: 'afterrender',
				chain: 'init'
		}]
	}}
})