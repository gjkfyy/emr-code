Ext.define('iih.sy.search.view.MrDocListView', {
    extend: 'Xap.ej.template.BaseTemplate',

    requires: ['iih.sy.patient.block.PatientRightGridBlock',
               'iih.sy.patient.block.PatientRightBlock',
               'iih.sy.patient.action.OutMrDocEditAction',
               'iih.sy.patient.action.PatientRightListAction',
               'iih.sy.patient.action.OpenMrDocAction',
               'iih.sy.patient.action.PatientRightSearchAction',
               'iih.sy.search.action.SearchMrDocListAction'],
    alias: 'widget.mrdoclistview',
    id:'mrdoclistview',
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
				xclass: 'iih.sy.search.action.SearchMrDocListAction',
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
                selector: 'button[method=delDoc]',
                event: 'click',
                chain: 'delDoc'
            },{
				event: 'afterrender',
				chain: 'init'
			}]
        }
    }
})