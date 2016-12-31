Ext.define('iih.mr.tm.mr.view.BasTemplateResetListView',{
	extend : 'Xap.ej.template.BaseTemplate',

	requires: [
	           'Xap.ej.element.grid.column.Date',
	           'iih.mr.tm.mr.block.BasTemplateResetListBlock',
	           'iih.mr.tm.mr.action.BasTemplateResetInitAction',
	           'iih.mr.tm.mr.action.TemplatePropertySaveAction',
	           'iih.mr.tm.mr.action.TemplateResetConfimAction'
	          ],
	
	alias:'widget.basictemplateresetlistview',	
	layout:{
		type: 'vbox',
	    align: 'stretch'
	},
	xapConfig: {
		blocks: {
            'top': {
                xclass: 'iih.mr.tm.mr.block.BasTemplateResetListBlock',
                height: 270
            },
			'bottom': {
				xclass: 'Xap.ej.block.ToolbarBlock',
				height:40,
				items:[{
			        xtype: "button",
			        name: 'confim',
			        method:'confim',
			        text: '确认',
			        iconCls: 'icon-OK'
			    },{
			        xtype: "button",
			        name: 'close',
			        method:'close',
			        text: '关闭',
			        iconCls: 'icon-close'
			    }]
			}
		},

		actions: {
            //查询列表
           'init': {
				xclass: 'iih.mr.tm.mr.action.BasTemplateResetInitAction',
				url:'mr/tpl/baseTemplate',
				blocks: {
					result: 'top'
				}
			},
			'close': {
                xclass: 'iih.mr.tm.mr.action.CancelTemplatePropertyEditAction',
                blocks: {
                    result: 'top'
                }
            },
			'confim': {
                xclass: 'iih.mr.tm.mr.action.TemplateResetConfimAction',
                blocks: {
                    result: 'top'
                }
            },
			'save': {
                xclass: 'iih.mr.tm.mr.action.TemplatePropertySaveAction',
                url:'mr/tpl/template/reset',
                blocks: {
                    result: 'top'
                }
            }
		},

		chains: {
			'init': ['init'],
			'close':['close'],
			'confim':['confim'],
			'save':['save']
		},

		connections: {	
		'top': [
	            {	//翻页操作
					event: 'turnpage',
					chain: 'init'
				 },{
	                event: 'afterrender',
	                chain: 'init'
	            }
			],
		'bottom':[
				{
					//取消按钮
	                selector: 'button[method=confim]',
	                event: 'click',
	                chain: 'confim'
				},
				{
					//取消按钮
	                selector: 'button[method=close]',
	                event: 'click',
	                chain: 'close'
				}
			]
    	}
	},
	
	initComponent : function() {
		this.callParent();
	}
})
