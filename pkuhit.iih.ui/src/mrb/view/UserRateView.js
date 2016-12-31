Ext.define('iih.mrb.view.UserRateView', {
	extend: 'Xap.ej.template.BaseTemplate',

	requires: [
	       'iih.mrb.action.UseRateSearchDeptListAction',
	       'iih.mrb.action.UseRateSearchDoctorListByDeptAction',
	       'iih.mrb.block.UseRateSeachBlock',
	       'iih.mrb.action.UseRateViewReportAction',
	       'iih.mrb.action.UseRateEnTypeSelectAction'
	           ],
    
	alias:'widget.userrateview',
	id : 'userrateview',
	layout : {
		type : 'vbox',
		align : 'stretch'
	},
	
	xapConfig: {
		blocks: {
            'condition': {
                xclass: 'iih.mrb.block.UseRateSeachBlock'
                ,height : 100
            }
			,'toolbar' : {
				xclass : 'Xap.ej.block.ToolbarBlock',
				items : [ {
					xtype : 'button',
					iconCls : 'icon-reset',
					text : '重置',
					action : 'init'
				}, {
					xtype : 'button',
					iconCls : 'icon-Search',
					text : '查询',
					action : 'search'
				} ]
			}
			,'content': {
                xclass: 'iih.mrb.block.UseRateReportBlock'
            }
		},
        actions: {
			'init' : {
				xclass : 'iih.mrb.action.UseRateInitAction',
				url : 'user/roles',
				blocks : {
					content : 'condition'
				}
			},
            'searchDeptList' : {
				xclass : 'iih.mrb.action.UseRateSearchDeptListAction',
				url : 'departments/entype',
				blocks : {
					result : 'condition'
				}
			},
			'searchDoctorByDeptList' : {
				xclass : 'iih.mrb.action.UseRateSearchDoctorListByDeptAction',
				url : 'org/dept/employee',
				blocks : {
					result : 'condition'
				}
			},
			'useRateEnTypeSelectAction':{
				xclass : 'iih.mrb.action.UseRateEnTypeSelectAction',
				blocks : {
					content : 'condition'
				}
			},
            'viewReport': {
                xclass: 'iih.mrb.action.UseRateViewReportAction',
                url: 'qa/reports',
                blocks: {
                    content: 'content'
                }
            }
        },  
        chains: {
        	'init' : [ 'init' ],
           'viewReport': ['viewReport'],
            'searchDoctorByDeptList':['searchDoctorByDeptList'],
            'searchDeptList':['searchDeptList'],
            'useRateEnTypeSelectAction':['useRateEnTypeSelectAction']
        },
        connections: {
        	condition:[
					{
						event : 'afterrender',
						chain : 'init'
					},  {	
  		            	selector : 'xapcombobox[action=useRateTypeCode]',
  				     	event : 'select',
  				     	chain : 'useRateEnTypeSelectAction'
  				     },{	
  		            	selector : 'xapcombobox[action=enTypeCode]',
  				     	event : 'select',
  				     	chain : 'searchDeptList'
  				     }, {
  				     	selector : 'xapcombobox[action=deptCodeList]',
  				     	event : 'select',
  				     	chain : 'searchDoctorByDeptList'
  				     }  
  				     ]
        , 		'toolbar' : [ {
			selector : 'button[action=search]',
			event : 'click',
			chain : 'viewReport'
		}  ]
        }
	},
	initComponent : function() {
		this.callParent();
	}
});