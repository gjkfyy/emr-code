Ext.define('iih.sy.userinfo.view.UserInfoContentView', {
			extend : 'Xap.ej.stl.view.LeftRightContainerTemplate',
			alias : 'widget.userinfocontentview',
			requires : ['iih.sy.userinfo.view.UserInfoLeftListView',
					'iih.sy.userinfo.block.UserInfoRightBlock',
					'iih.sy.userinfo.action.UserRightDeptDelAction',
					'iih.sy.userinfo.action.UserInfoLeftSearchAction',
					'iih.sy.userinfo.action.UserRightListAction',
					'iih.sy.userinfo.action.DeptInsertRowAction'],

			xapConfig : {
				blocks : {
					'left' : {
						xclass : 'iih.sy.userinfo.view.UserInfoLeftListView',
						width : 300
					},
					'right' : {
						xclass : 'iih.sy.userinfo.block.UserInfoRightBlock',
						flex : 1
					}
				},

					actions : {
						'init' : {
							xclass : 'iih.sy.userinfo.action.RoleInitAction',
							url: 'role',
							blocks : {
								result : 'right'
							}
						},
						'editRow' : {
							xclass : 'iih.sy.userinfo.action.UserRightDeptEditAction',
							blocks : {
								result : 'right'
							}
						},
						'deleteRow' : {
							xclass : 'iih.sy.userinfo.action.UserRightDeptDelAction',
							blocks : {
								result : 'right'
							}
						},
						'chooseRole' : {
							xclass : 'iih.sy.userinfo.action.ChooseRoleAction',
							url: 'choose_role_search',
							blocks : {
								result : 'right'
							}
						},
						'deptsaverole' : {
							xclass : 'iih.sy.userinfo.action.DeptSaveRoleAction',
							blocks : {
								result : 'right'
							}
						}
						,
						'userRightList': {
							xclass: 'iih.sy.userinfo.action.UserRightListAction',
							url: 'user',
							blocks: {
								condition: 'left',
								result: 'right'
							}
						},
						'deptInsertRow':{				
							xclass: 'iih.sy.userinfo.action.DeptInsertRowAction',
							blocks: {
								result: 'right'
							}
						},
						'showSignPic':{				
							xclass: 'iih.sy.userinfo.action.ShowSignPicAction',
							blocks: {
								result: 'right'
							}
						}
						
					},

					chains : {
						'init' : ['init'],
						'editRow' : ['editRow'],
						'deleteRow' : ['deleteRow'],
						'chooseRole' : ['chooseRole'],
						'deptsaverole':['deptsaverole'],
						'userRightList': ['userRightList'],
						'deptInsertRow': ['deptInsertRow'],
						'showSignPic':['showSignPic']
					},

					connections : {
						'left'	:[{
							selector: 'xapgrid',
							event: 'itemclick',
							chain: 'userRightList'
						}],
						'right' : [
						           {
									event: 'afterrender',
									chain: 'init'
								}/*,{
									selector : 'xapactioncolumn[name=editRow]',
									event : 'editclick',
									chain : 'editRow'
								}*/,{//显示签名图片
									selector: 'filefield',
									event: 'change',
									chain: 'showSignPic'
								},{
									selector : 'xapactioncolumn[name=deleteRow]',
									event : 'deleteclick',
									chain : 'deleteRow'
								},{
									selector : 'xapgrid',
									event : 'comboxclick',
									chain : 'chooseRole'
								},{
									selector : 'xapgrid[name=rolegrid]',
									event : 'selectionchange',
									chain : 'deptsaverole'
								},
								{
									selector : 'xapactioncolumn[name=editRow]',
									event: 'editclick',
									chain: 'deptInsertRow'
								}]
					}
				}
		});