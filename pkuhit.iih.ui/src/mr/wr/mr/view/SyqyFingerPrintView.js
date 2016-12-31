Ext.define('iih.mr.wr.mr.view.SyqyFingerPrintView',{
	extend : 'Xap.ej.template.BaseTemplate',

	requires: [],

	alias:'widget.syqyfingerprintview',

	xapConfig: {
		blocks: {
			'content': {
				xclass: 'iih.mr.wr.mr.block.SyqyComponentsBlock'
			}
		},
        actions: {
        	'init': {
				xclass: 'iih.mr.wr.mr.action.SyqyCompInitAction'
            }
        },  
        chains: {
        	'init': ['init']
        }
	}
})