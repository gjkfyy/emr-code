Ext.define('iih.mr.wr.omr.view.CreateOrderView',{
	extend : 'Xap.ej.template.BaseTemplate',

	requires: [
	    'iih.mr.wr.omr.block.CreateOrderBlock',
	    'iih.mr.wr.omr.action.CreateOrderInitAction'
	],

	alias:'widget.createorderview',
	
	xapConfig: {
		blocks: {
		    'content': {
                xclass: 'iih.mr.wr.omr.block.CreateOrderBlock',
                flex:1
            }
		},
        actions: {
        	'init': {
				xclass: 'iih.mr.wr.omr.action.CreateOrderInitAction',
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
			},{
		        selector: 'xaptabpanel',
		        event: 'tabchange',
		        chain: 'init'
		    }]
	}}
})