Ext.define('iih.po.com.view.DataSyncView', {
    extend : 'Xap.ej.template.BaseTemplate',

    requires: [],

    alias:'widget.datasyncview',

    layout: 'fit',
    
    border: 0,

    xapConfig: {
        blocks: {
            'content': {
                xclass: 'iih.po.com.block.DataSyncBlock'
            }
        },

        actions: {
            'syncDept': {
                xclass: 'iih.po.com.action.DataSyncAction',
                url: 'sync/xapbatch',
                blocks: {
                    portal: 'content'
                }
            },
            'syncAmr': {
                xclass: 'iih.po.com.action.DataSyncAction',
                url: 'sync/mramr',
                blocks: {
                    portal: 'content'
                }
            },
            'syncDi': {
                xclass: 'iih.po.com.action.DataSyncAction',
                url: 'sync/mddi',
                blocks: {
                    portal: 'content'
                }
            },
            'importNisWardConfig': {
                xclass: 'iih.po.com.action.DataImportNisWardConfig',
                url: 'ei/ob/importNisWardConfig',
                blocks: {
                    portal: 'content'
                }
            }
        },

        chains: {
            'syncDept': ['syncDept'],
            'syncAmr': ['syncAmr'],
            'importNisWardConfig':['importNisWardConfig'],
            'syncDi': ['syncDi']
        },

        connections: {
            'content': [{
                selector: 'button[action=syncEn]',
                event: 'click',
                chain: 'syncAmr'
            },{
                selector: 'button[action=syncDept]',
                event: 'click',
                chain: 'syncDept'
            },{
                selector: 'button[action=syncDi]',
                event: 'click',
                chain: 'syncDi'
            },{
                selector: 'button[action=importNisWardConfig]',
                event: 'click',
                chain: 'importNisWardConfig'
            }]
        }
    },
    
    initComponent : function() {
        var me = this;
        this.callParent();
    }
})