Ext.define('iih.mr.wr.mr.view.MrShareElementEditView', {
    extend : 'Xap.ej.template.BaseTemplate',

    requires: [],

    alias:'widget.mrshareelementeditview',
    
    border: 0,
    
    layout: 'fit',

    xapConfig: {
        blocks: {
            'content': {
                xclass: 'iih.mr.wr.mr.block.MrShareElementEditBlock'
            }
        },

        actions: {
            'init': {
                xclass: 'iih.mr.wr.mr.action.MrShareElementEditAction',
                blocks: {
                    content: 'content'
                }
            },
            'save': {
                xclass: 'iih.mr.wr.mr.action.MrShareElementSaveAction',
                url: 'mr/md/shareElement',
                blocks: {
                    content: 'content'
                }
            }
        },

        chains: {
            'init': ['init'],
            'save': ['save']
        },

        connections: {
            'content': [{
                event: 'afterrender',
                chain: 'init'
            }]
        }
    }
})