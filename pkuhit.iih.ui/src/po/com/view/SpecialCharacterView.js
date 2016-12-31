Ext.define('iih.po.com.view.SpecialCharacterView', {
	extend: 'Xap.ej.template.BaseTemplate',

	requires: [],

	alias:'widget.specialcharacterview',

	layout: 'fit',
	
	border: 0,
	
	xapConfig: {
        blocks: {
            'content': {
                xclass: 'iih.po.com.block.SpecialCharacterBlock'
            }
        },

        actions: {
            'search': {
                xclass: 'iih.po.com.action.SpecialCharacterSearchAction',
                blocks: {
                    content: 'content'
                }
            }
        },

        chains: {
            'search': ['search']
        },

        connections: {
            'content': [{
                event: 'afterrender',
                chain: 'search'
            }]
        }
    },

    initComponent: function() {
    	this.callParent();
    }
});