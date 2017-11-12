Ext.define('iih.sy.patient.view.PatientRightView', {
    extend: 'Xap.ej.template.BaseTemplate',

    requires: ['iih.sy.patient.block.PatientRightGridBlock',
               'iih.sy.patient.block.PatientRightBlock',
               'iih.sy.patient.action.OutMrDocEditAction',
               'iih.sy.patient.action.PatientRightListAction',
               'iih.sy.patient.action.OpenMrDocAction',
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
			},
        	'openMrDocAction': {
				xclass: 'iih.sy.patient.action.OpenMrDocAction',
				url: 'omr',
				blocks: {
					result: 'result'
				}
			},
        	'delMrDocAction': {
				xclass: 'iih.sy.patient.action.DelMrDocAction',
				url: 'omr',
				blocks: {
					result: 'result'
				}
			}
        
        },
       
        chains: {
            'init': ['init'],
            'openMrDocAction':['openMrDocAction'],
            'delDoc':['delMrDocAction']
        },

        connections: {
        	'result': [{// 翻页操作
				selector : 'xapgrid',
				event : 'turnpage',
				chain : 'init'
			},{// 翻页操作
				selector : 'xapgrid',
				event : 'itemdblclick',
				chain : 'openMrDocAction'
			},{
				event: 'afterrender',
				chain: 'init'
			}]
        }
    }
})