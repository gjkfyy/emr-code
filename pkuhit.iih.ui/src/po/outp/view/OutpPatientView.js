Ext.define('iih.po.outp.view.OutpPatientView', {
    extend : 'Xap.ej.template.BaseTemplate',

    requires: [],

    alias:'widget.outppatientview',
    
    border: 0,
    
    layout: 'fit',
    
    id: 'outppatientview',

    xapConfig: {
        blocks: {
            'content': {
                xclass: 'iih.po.outp.block.OutpPatientSearchBlock'
            }
        },

        actions: {
            'search': {
                xclass: 'iih.po.outp.action.OutpPatientSearchAction',
                url: 'mr/ens',
                blocks: {
                    content: 'content'
                }
            },
            'selectPatient': {
                xclass: 'iih.po.com.action.SelectPatientAction',
                blocks: {
                    content: 'content'
                }
            }
        },

        chains: {
            'search': ['search'],
            'selectPatient': ['selectPatient']
        },

        connections: {
            'content': [{
                selector: 'xapgrid[groupType=1]',
                event: 'turnpage',
                chain: 'search'
            },{
                selector: 'xapgrid[groupType=2]',
                event: 'turnpage',
                chain: 'search'
            },{
                selector: 'xapgrid[groupType=3]',
                event: 'turnpage',
                chain: 'search'
            },{
                selector: 'xaptabpanel',
                event: 'tabchange',
                chain: 'search'
            }]
        }
    }
})