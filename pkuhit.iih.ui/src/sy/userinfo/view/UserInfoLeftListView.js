Ext.define('iih.sy.userinfo.view.UserInfoLeftListView',{
	extend : 'Xap.ej.stl.view.SearchTemplate',

	alias:'widget.userinfoleftlistview',
	
	requires :[
		'iih.sy.userinfo.block.UserInfoLeftBlock',
		'iih.sy.userinfo.block.UserInfoLeftGridBlock',
		'iih.sy.userinfo.action.UserInfoLeftSearchAction',
		'iih.sy.userinfo.action.UserRightListAction'
	],

	xapConfig: {
		blocks: {
			'condition':{
				xclass: 'iih.sy.userinfo.block.UserInfoLeftBlock',
				height:90
			},
			'toolbar': {
				xclass: 'Xap.ej.block.ToolbarBlock',
				items: [{
					xtype: 'button',
					text: '查询',
					iconCls: 'icon-Search',
					action: 'search'
				}]
			},
			'result':{
				xclass: 'iih.sy.userinfo.block.UserInfoLeftGridBlock'
			}
		},
		actions: {
			'init': {
				xclass: 'iih.sy.userinfo.action.UserInfoLeftSearchAction',
				//url: 'http://172.18.100.116:8081/dm-xap/users',
				url: 'users',
				blocks: {
					condition: 'condition',
					result: 'result'
				}
			}
		},

		chains: {
			'init':['init']
		},

		connections: {
			'result': [
//			           {
//				event: 'afterrender',
//				chain: 'init'
//			}, 
			{// 翻页操作
				selector : 'xapgrid',
				event : 'turnpage',
				chain : 'init'
			}],
			'toolbar': [{
				selector: 'button[action=search]',
				event: 'click',
				chain: 'init'
			}]
		}
	}
})