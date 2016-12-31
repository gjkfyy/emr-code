Ext.define('iih.po.com.view.SelectPortal', {
	extend: 'Xap.ej.template.BaseTemplate',
	
	requires: ['Xap.ej.element.field.ComboBox'],
	
	alias:'widget.selectportal',
	
	layout: 'fit',

	xapConfig: {
		blocks: {
			'selectportalview': {
				xclass: 'iih.po.com.block.SelectPortalBlock'
			}
		},

		actions: {
			'init': {
				xclass: 'iih.po.com.action.SelectPortalInitAction',
				blocks:{
					selectportals: 'selectportalview'
				}
			},
			'searchHospitalArea': {
                xclass: 'iih.po.com.action.SearchHospitalAreaAction',
                url:'searchHospitalArea',
                blocks:{
                    context: 'selectportalview'
                }
            },
            'searchDepartment': {
                xclass: 'iih.po.com.action.SearchDepartmentAction',
                //url:'user/departments',
                url:'searchDepartment',
                blocks:{
                    context: 'selectportalview'
                }
            },
            'searchPortal': {
                xclass: 'iih.po.com.action.SearchPortalAction',
                url:'searchPortal',
                blocks:{
                    context: 'selectportalview'
                }
            },
            'enterPortal': {
                xclass: 'iih.po.com.action.SelectPortalAction',
                blocks:{
                    selectportals: 'selectportalview'
                }
            },
            'back': {
                xclass: 'iih.po.com.action.BackPortalAction'
            }
		},

		chains: {
			'init':['init'],
			'searchHospitalArea':['searchHospitalArea'],
			'searchDepartment':['searchDepartment'],
			'searchPortal':['searchPortal'],
			'enterPortal':['enterPortal'],
            'back':['back']
		},

		connections: {
			'selectportalview': [{
				selector: 'xapcombobox[name=hosArea]',
				event: 'change',
				chain: 'searchDepartment'
			},{
                selector: 'xapcombobox[name=dept]',
                event: 'change',
                chain: 'searchPortal'
            }]
		}
	}
})