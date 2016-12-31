Ext.define('iih.po.inp.view.InpPatientNavigationView', {
    extend : 'Xap.ej.stl.view.TopBottomContainerTemplate',

    requires: [
        'iih.po.inp.block.InpPatientData',
        'iih.po.inp.block.InpPatientSearchBlock',
        'iih.po.inp.block.InpPatientListBlock',
        'iih.po.com.action.PatientTreeInitAction',
        'iih.po.com.action.SelectPatientAction',
        'iih.po.com.action.PatientTreeInitAction'
    ],

    alias:'widget.inppatientnavigationview',
    
    title: '患者',
    
    border: 0,

    xapConfig: {
        blocks: {
            'top': {
                xclass: 'iih.po.inp.block.InpPatientSearchBlock',
                height: 55
            },
            'bottom': {
                xclass: 'iih.po.inp.block.InpPatientListBlock',
                flex: 1
            }
        },

        actions: {
            'refresh': {
                xclass: 'iih.po.com.action.PatientTreeInitAction',
                url: 'mr/ens',
                blocks: {
                    search: 'top',
                    list: 'bottom'
                }
            },
            'selectPatient': {
                xclass: 'iih.po.com.action.SelectPatientAction',
                blocks: {
                    list: 'bottom'
                }
            },
            'searchPatient': {
                xclass: 'iih.po.com.action.PatientTreeInitAction',
                url: 'mr/ens',
                blocks: {
                    search: 'top',
                    list: 'bottom'
                }
            }
        },

        chains: {
            'init': ['refresh'],
            'selectPatient': ['selectPatient'],
            'searchPatient': ['searchPatient']
        },

        connections: {
            'bottom': [{
                chain: 'init'
            },{
                selector: 'inppatientdata',
                event: 'itemclick',
                chain: 'selectPatient'
            }],
            'top': [{
                chain: 'searchPatient'
            }]
        }
    }
})