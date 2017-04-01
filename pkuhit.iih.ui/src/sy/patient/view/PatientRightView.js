Ext.define('iih.sy.patient.view.PatientRightView', {
    extend: 'Xap.ej.template.BaseTemplate',

    requires: ['iih.sy.patient.block.PatientRightGridBlock',
               'iih.sy.patient.block.PatientRightBlock',
               'iih.sy.patient.action.OutMrDocEditAction',
               'iih.sy.patient.action.PatientRightListAction',
               'iih.sy.patient.action.PatientRightSearchAction'],
    alias: 'widget.patientrightview',
    id:'patientrightview',
    xapConfig: {
        blocks: {
        	'condition':{
				xclass: 'iih.sy.patient.block.PatientRightBlock',
				height:35,
				hidden:true
			},
            'result': {
                xclass: 'iih.sy.patient.block.PatientRightGridBlock',
                flex: 1
            }
        },

        actions: {
        	'init': {
				xclass: 'iih.sy.patient.action.PatientRightSearchAction',
				url: 'omrs2',
				blocks: {
					result: 'result'
				}
			}
        },
       
        chains: {
            'init': ['init']
        },

        connections: {
        	'result': [{// 翻页操作
				selector : 'xapgrid',
				event : 'turnpage',
				chain : 'init'
			},{
				event: 'afterrender',
				chain: 'init'
			}]
        }
    }
})