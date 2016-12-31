Ext.define('iih.po.com.view.MessageView', {
    extend : 'Xap.ej.template.BaseTemplate',

    requires: [],

    alias:'widget.messageview',
    
    border: 0,
    
    layout: 'fit',

    xapConfig: {
        blocks: {
            'content': {
                xclass: 'iih.po.com.block.MessageListBlock'
            }
        },

        actions: {
            'search': {
                xclass: 'iih.po.com.action.MessageSearchAction',
                url: 'message',
                blocks: {
                    content: 'content'
                }
            },
            'read': {
                xclass: 'iih.po.com.action.MessageReadAction',
                url: 'message/batch',
                blocks: {
                    content: 'content'
                }
            },
            'delete': {
                xclass: 'iih.po.com.action.MessageDeleteAction',
                url: 'message/batch',
                blocks: {
                    content: 'content'
                }
            },
            'open': {
                xclass: 'iih.po.com.action.MessageOpenAction',
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
            'read': ['read'],
            'delete': ['delete'],
            'open': ['open'],
            'jump': ['jump']
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
    }
})