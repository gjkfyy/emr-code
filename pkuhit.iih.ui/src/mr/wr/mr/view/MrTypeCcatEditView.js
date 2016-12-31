Ext.define('iih.mr.wr.mr.view.MrTypeCcatEditView', {
    extend : 'Xap.ej.template.BaseTemplate',

    requires: [],

    alias:'widget.mrtypeccateditview',
    
    border: 0,
    
    layout: 'fit',

    xapConfig: {
        blocks: {
            'content': {
                xclass: 'iih.mr.wr.mr.block.MrTypeCcatEditBlock'
            }
        },

        actions: {
            'init': {
                xclass: 'iih.mr.wr.mr.action.MrTypeCcatEditAction',
                blocks: {
                    content: 'content'
                }
            },
            'save': {
                xclass: 'iih.mr.wr.mr.action.MrTypeCcatSaveAction',
                url: 'mrtypecustomcategory',
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