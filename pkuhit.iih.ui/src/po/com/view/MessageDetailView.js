Ext.define('iih.po.com.view.MessageDetailView', {
    extend : 'Xap.ej.template.BaseTemplate',

    requires: [],

    alias:'widget.messagedetailview',
    
    border: 0,
    
    layout: 'fit',

    xapConfig: {
        blocks: {
            'content': {
                xclass: 'iih.po.com.block.MessageDetailBlock'
            }
        },

        actions: {
            'search': {
                xclass: 'iih.po.com.action.MessageDetailSearchAction',
                url:'message',
                blocks: {
                    content: 'content'
                }
            },
            'jump': {
                xclass: 'iih.po.com.action.JumpFunctionAction',
                blocks: {
                    content: 'content'
                }
            }
        },

        chains: {
            'search': ['search'],
            'jump': ['jump']
        },

        connections: {
            /*'content': [{
                selector: 'button[name=confim]',
                event: 'click',
                chain: 'jump'
            }]*/
        }
    }
})