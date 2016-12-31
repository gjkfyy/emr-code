Ext.define('iih.po.com.view.TopView', {
	extend: 'Xap.ej.template.BaseTemplate',

	requires: ['iih.po.com.view.TopPage'],

	alias:'widget.topview',
	
	layout:'fit',
	
	border: 0,

	xapConfig: {
		blocks: {
		    'tview': {
		    	xclass: 'iih.po.com.view.TopPage'
            }
		},
		actions: {
		    'init': {
		        xclass: 'iih.po.com.action.TopInitAction',
		        url: 'search_topinfo',
                blocks:{
                    tview: 'tview'
                }
		    },
		    'searchDepartment': {
                xclass: 'iih.po.com.action.SearchDepartmentAction',
                //url:'user/departments',
                url:'searchDepartment',
                blocks:{
                    context: 'tview'
                }
            },
            'searchPortal': {
                xclass: 'iih.po.com.action.SearchPortalAction',
                url:'searchPortal',
                blocks:{
                    context: 'tview'
                }
            },
            'topBaseButtons': {
                xclass: 'iih.po.com.action.TopBaseButtonsAction',
                blocks:{
                    context: 'tview'
                }
            }
		},

		chains: {
		    'init':['init'],
		    'searchDepartment':['searchDepartment'],
            'searchPortal':['searchPortal'],
            'topBaseButtons':['topBaseButtons']
		},

		connections: {
			'tview': [{
			    chain: 'init'
			}]
		}
	}
	
})