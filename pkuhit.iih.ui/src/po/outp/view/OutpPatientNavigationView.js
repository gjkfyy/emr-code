Ext.define('iih.po.outp.view.OutpPatientNavigationView', {
    extend : 'Xap.ej.stl.view.TopBottomContainerTemplate',

    requires: ['iih.po.outp.block.OutpPatientData'],

    alias:'widget.outppatientnavigationview',
    
    title: '患者',
    
    border: 0,

    xapConfig: {
        blocks: {
            'top': {
                xclass: 'iih.po.outp.block.OutpPatientSearchBlock',
                height: 50
            },
            'bottom': {
                xclass: 'iih.po.outp.block.OutpPatientListBlock',
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
                url: 'navigation_patient',
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
                selector: 'outppatientdata',
                event: 'itemclick',
                chain: 'selectPatient'
            }],
            'top': [{
                chain: 'searchPatient'
            }]
        }
    }
})