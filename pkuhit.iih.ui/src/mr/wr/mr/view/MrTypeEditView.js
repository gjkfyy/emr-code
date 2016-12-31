Ext.define('iih.mr.wr.mr.view.MrTypeEditView', {
    extend : 'Xap.ej.template.BaseTemplate',

    requires: [],

    alias:'widget.mrtypeeditview',
    
    border: 0,
    
    layout: 'fit',

    xapConfig: {
        blocks: {
            'content': {
                xclass: 'iih.mr.wr.mr.block.MrTypeEditBlock'
            }
        },

        actions: {
            'init': {
                xclass: 'iih.mr.wr.mr.action.MrTypeEditAction',
                blocks: {
                    content: 'content'
                }
            },
            'save': {
                xclass: 'iih.mr.wr.mr.action.MrTypeSaveAction',
                url: 'mr/md/mrtype',
                blocks: {
                    content: 'content'
                }
            },
            'mrTpCcatSearch': {
                xclass: 'iih.mr.wr.mr.action.MrTypeCcatSearchAction',
                url: 'mr/md/mrccat',
                blocks: {
                    content: 'content'
                }
            },
            'mrTpCcatItmSearch': {
                xclass: 'iih.mr.wr.mr.action.MrTypeCcatItmSearchAction',
                url: 'mr/md/mrccatitem/ccat',
                blocks: {
                    content: 'content'
                }
            },
            'encounterTypeSearch': {
                xclass: 'iih.mr.wr.mr.action.EncounterTypeSearchAction',
                url: 'mr/md/mrccatitem/entype',
                blocks: {
                    content: 'content'
                }
            }
        },

        chains: {
            'init': ['init'],
            'save': ['save'],
            'mrTpCcatSearch': ['mrTpCcatSearch'],
            'mrTpCcatItmSearch': ['mrTpCcatItmSearch'],
            'encounterTypeSearch': ['encounterTypeSearch']
        },

        connections: {
            'content': [/*{
                event: 'afterrender',
                chain: 'mrTpCcatSearch'
            }*/]
        }
    }
})