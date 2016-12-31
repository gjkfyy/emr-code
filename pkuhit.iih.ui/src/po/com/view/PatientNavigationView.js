Ext.define('iih.po.com.view.PatientNavigationView', {
    extend : 'Xap.ej.stl.view.TopBottomContainerTemplate',

    requires: ['Xap.ej.element.tree.Tree'],

    alias:'widget.patientnavigationview',
    
    id:'patientnavigationview',
    
    title: '患者',
    
    border: 0,

    xapConfig: {
        blocks: {
            'top': {
                xclass: 'iih.po.com.block.PatientSearchBlock'
            },
            'bottom': {
                xclass: 'iih.po.com.block.PatientListBlock'
            }
        },

        actions: {
            'refresh': {
                xclass: 'iih.po.com.action.PatientTreeInitAction',
                url: 'mr/ens',
                blocks: {
                    tree: 'bottom'
                }
            },
            'selectPatient': {
                xclass: 'iih.po.com.action.SelectPatientAction',
                blocks: {
                    portal: 'bottom'
                }
            }
        },

        chains: {
            'init': ['refresh'],
            'selectPatient': ['selectPatient']
        },

        connections: {
            'bottom': [{
                chain: 'init'
            },{
                selector: 'xaptree',
                event: 'itemclick',
                chain: 'selectPatient'
            }]
        }
    }
});