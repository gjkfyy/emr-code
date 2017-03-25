Ext.define('iih.sy.patient.view.PatientRightView', {
    extend: 'Xap.ej.template.BaseTemplate',

    requires: ['iih.sy.patient.block.PatientRightBlock',
               'iih.sy.patient.action.OutMrDocEditAction',
               'iih.sy.patient.action.PatientRightListAction'],
    alias: 'widget.patientrightview',
    layout:  'fit',
    id:'patientrightview',
    xapConfig: {
        blocks: {
            'content': {
                xclass: 'iih.sy.patient.block.PatientRightBlock',
                flex: 1
            }
        },

        actions: {
            /*'init': {
                xclass: 'iih.sy.patient.view.OutMrDocEditView',
                blocks: {
                    content: 'content'
                }
            },*/
            /*'init': {
                xclass: 'iih.sy.patient.action.OutMrDocEditAction',
                blocks: {
                    content: 'content'
                }
            }*/
        },
       
        chains: {
            //'init': ['init'],
            //'open':['open']
        },

        connections: {
            
        }
    }
})