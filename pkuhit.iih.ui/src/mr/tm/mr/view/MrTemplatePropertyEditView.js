Ext.define('iih.mr.tm.mr.view.MrTemplatePropertyEditView',{
	extend : 'Xap.ej.stl.view.SingleRecordEditTemplate',

	requires: [
	           'iih.mr.tm.mr.block.MrTemplatePropertyEditViewBlock',
	           'iih.mr.tm.mr.action.BaseTplInitAction',
	           'iih.mr.tm.mr.action.TemplatePropertyInitAction',
               'iih.mr.tm.mr.action.ConfimTemplatePropertyEditAction',
               'iih.mr.tm.mr.action.CancelTemplatePropertyEditAction',
               'iih.mr.tm.mr.action.MrTypeCdChangeAction',
               'iih.mr.tm.mr.action.OwnerTypeCdChangeAction',
				'iih.mr.tm.mr.action.CheckTemplateRoleAction',
				'iih.mr.tm.mr.action.CheckTemplateNameAction'
	           ],
	alias:'widget.mrTemplatePropertyEditView',
	
	layout: 'fit',

	xapConfig: {
		blocks: {
			'content': {
				xclass: 'iih.mr.tm.mr.block.MrTemplatePropertyEditViewBlock'
			}
		},

		actions: {
			'create': { 
			    url:'mr/tpl/template',
				xclass: 'iih.mr.tm.mr.action.TemplatePropertyInitAction',
				blocks: {
                    result:'content'
                }
			},
			'baseTplInit': { 
				xclass: 'iih.mr.tm.mr.action.BaseTplInitAction',
				url:'mr/tpl/baseTemplate',
				blocks: {
                    result:'content'
                }
			},
			'mrTypeCdInit': { 
				xclass: 'iih.mr.tm.mr.action.MrTypeCdInitAction',
				url:'mr/type/tree',
				blocks: {
                    result:'content'
                }
			},
			'confim': {
                xclass: 'iih.mr.tm.mr.action.ConfimTemplatePropertyEditAction',
                url:'mr/tpl/template',
                blocks: {
                    result: 'content'
                }
            },
            'cancel': {
                xclass: 'iih.mr.tm.mr.action.CancelTemplatePropertyEditAction',
                blocks: {
                    result: 'content'
                }
            },
            'mrTypeCdChange': {
                xclass: 'iih.mr.tm.mr.action.MrTypeCdChangeAction',
                blocks: {
                    result: 'content'
                }
            },
            'ownerTypeCdChange': {
                xclass: 'iih.mr.tm.mr.action.OwnerTypeCdChangeAction',
                blocks: {
                    result: 'content'
                }
            },
			'check': {
                xclass: 'iih.mr.tm.mr.action.CheckTemplateRoleAction',
                url:'mr/tpl/template/userRoleCanCreate',
                blocks: {
                    result: 'content'
                }
            },
			'checkName': {
                xclass: 'iih.mr.tm.mr.action.CheckTemplateNameAction',
                url:'mr/tpl/template/HasDuplicationOfName',
                blocks: {
                    result: 'content'
                }
            }
			
		},

		chains: {
			//'init': ['baseTplInit','mrTypeCdInit','create'],
			'init': ['create'],
			'check': ['check'],
			'checkName': ['checkName'],
			'baseTplInit': ['baseTplInit'],
			'mrTypeCdInit': ['mrTypeCdInit'],
            'confim': ['confim'],
            'cancel': ['cancel'],
            'mrTypeCdChange': ['mrTypeCdChange'],
            'ownerTypeCdChange': ['ownerTypeCdChange']
		},

		connections: {
			'content': [/*{    
			    //加载数据
                event: 'afterrender',
                chain: 'init'
            },{    
                //基础模板初始化
                selector: '[name=baseTemplateCode]',
                event: 'afterrender',
                chain: 'baseTplInit'
            },{    
                //文书类型的初始化
                selector: '[name=mrTypeCd]',
                event: 'afterrender',
                chain: 'mrTypeCdInit'
            },*/{    
                //确认按钮
                selector: 'button[method=confim]',
                event: 'click',
                chain: 'checkName'
            },{    
                //取消按钮
                selector: 'button[method=cancel]',
                event: 'click',
                chain: 'cancel'
            },{
                //combox的change时间
                selector: '[name=mrTypeCd]',
                event: 'select',
                chain: 'mrTypeCdChange'
            },{
                //combox的change时间
                selector: '[name=ownerTypeCode]',
                event: 'select',
                chain: 'ownerTypeCdChange'
            }]
		}
	}
})