Ext.define('iih.po.inp.view.InpPatientSearchView', {
    extend : 'Xap.ej.template.BaseTemplate',

    requires: [],

    alias:'widget.inppatientsearchview',
    
    border: 0,
    
    id: 'inppatientsearchview',

    xapConfig: {
        blocks: {
            'content': {
                xclass: 'iih.po.inp.block.PatientSearchBlock'
            }
        },

        actions: {
            'init': {
                xclass: 'iih.po.inp.action.PatientGridInitAction',
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
            'init': ['init'],
            'selectPatient': ['selectPatient']
        },

        connections: {
            'content': [{
                event: 'afterrender',
                chain: 'init'
            },{
                selector: 'xapgrid',
                event: 'turnpage',
                chain: 'init'
            }]
        }
    }
})