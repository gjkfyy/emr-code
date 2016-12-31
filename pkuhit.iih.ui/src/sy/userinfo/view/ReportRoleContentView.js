Ext.define('iih.sy.userinfo.view.ReportRoleContentView', {
			extend : 'Xap.ej.stl.view.LeftRightContainerTemplate',
			alias : 'widget.reportrolecontentview',
			requires : ['iih.sy.userinfo.block.RoleLeftGridBlock',
					'iih.sy.userinfo.block.ReportRightGridBlock',
					'iih.sy.userinfo.action.ReportRoleInitAction',
					'iih.sy.userinfo.action.ReportListInitAction',
					'iih.sy.userinfo.action.ChooseRoleReportsAction'],

			xapConfig : {
				blocks : {
					'left' : {
						xclass : 'iih.sy.userinfo.block.RoleLeftGridBlock',
						width : 300
					},
					'right' : {
						xclass : 'iih.sy.userinfo.block.ReportRightGridBlock',
						flex : 1
					}
				},

				actions : {
					'init' : {
						xclass : 'iih.sy.userinfo.action.ReportRoleInitAction',
						url : 'role',
						blocks : {
							result : 'left'
						}
					},
					'reportRightList' : {
						xclass : 'iih.sy.userinfo.action.ReportListInitAction',
						url : '/role/reports',
						blocks : {
							result : 'right'
						}
					},
					'chooseRoleReports' : {
						xclass : 'iih.sy.userinfo.action.ChooseRoleReportsAction',
						url : '/role/choosereports',
						blocks : {
							result : 'right'
						}
					}
				},

				chains : {
					'init' : ['init'],
					'reportRightList' : ['reportRightList'],
					'chooseRoleReports' : ['chooseRoleReports']
				},

				connections : {
					'left' : [{
						event : 'afterrender',
						chain : 'init'
					},{
						selector : 'xapgrid',
						event : 'itemclick',
						chain : 'chooseRoleReports'
					}],
					'right' : [{
						event : 'afterrender',
						chain : 'reportRightList'
					}]
				}
			}
		});