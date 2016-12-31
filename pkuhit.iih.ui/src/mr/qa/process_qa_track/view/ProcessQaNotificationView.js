
/** 
 * 环节质控追踪整改通知列表
 * @author ：cheng_feng
 */
 
Ext.define('iih.mr.qa.process_qa_track.view.ProcessQaNotificationView',{
	extend: 'Xap.ej.template.BaseTemplate',

	requires: [
	           'Xap.ej.element.grid.Grid', 
	           'Xap.ej.element.field.Checkbox',
	           'Xap.ej.element.field.ComboBox',
	           'Xap.ej.element.button.Button',
	           'Xap.ej.element.label.Label',
	           'Xap.ej.element.grid.column.Date',
	           'iih.mr.qa.QaStatusGlobal',
	           'iih.mr.qa.process_qa_track.block.NotificationListBlock',
	           'iih.mr.qa.process_qa_track.action.NotificationListAction',
	           'iih.mr.qa.process_qa_track.action.ToProcessQaDefectAction',
	           'iih.mr.qa.process_qa_track.action.ProcessQaNotificationViewreadyAction',
	           'iih.mr.qa.process_qa_track.action.WakeNotificationButtonAction'
	],

	alias:'widget.processqanotificationview',
	layout: {
        type: 'fit'
    },
    
	xapConfig: {
		blocks: {
            'content': {
                xclass: 'iih.mr.qa.process_qa_track.block.NotificationListBlock',
                flex: 1
            }
		},
		
		actions: {
			'init': {
				xclass: 'iih.mr.qa.process_qa_track.action.NotificationListAction',
				url: 'qa/notifications',
				blocks: {
					condition: 'properties',
					result: 'content'
				}
			},
			'wakeButton': {
				xclass: 'iih.mr.qa.process_qa_track.action.WakeNotificationButtonAction',
				blocks: {
					condition: 'properties',
					result: 'content'
				}
			},
			'processQaNotificationViewreadyAction': {
				xclass: 'iih.mr.qa.process_qa_track.action.ProcessQaNotificationViewreadyAction',
				blocks: {
					condition: 'properties',
					result: 'content'
				}
			},
			'toProcessQaDefect': {
				xclass: 'iih.mr.qa.process_qa_track.action.ToProcessQaDefectAction',
				blocks: {
					condition: 'properties',
					result: 'content'
				}
			}
		},

		chains: {
			'init':['init'],
			'toProcessQaDefect':['toProcessQaDefect'],
			'processQaNotificationViewreadyAction':['processQaNotificationViewreadyAction'],
			'wakeButton':['wakeButton']
		},

		connections: {
			'content': [/*{
				event: 'afterrender',
				chain: 'init'
			},*/{
				selector: 'xapgrid',
				event: 'itemdblclick',
				chain: 'toProcessQaDefect'
			},{
				selector: 'xapgrid',
				event: 'select',
				chain: 'wakeButton'
			},{
				selector: 'xapgrid',
				event: 'viewready',
				chain: 'processQaNotificationViewreadyAction'
			}
			]
		}
	},
		initComponent : function() {
			this.callParent();
			this.addEvents("pageRefresh");//为视图添加刷新事件
			this.addListener('pageRefresh', function(){//添加监听事件
				 var properties = this.getLayer(Xap.ej.block.Layer.PROPERTIES);
		        var chain = this.getActionChain('init');
//		        var block = this.getBlock('result');
//		        var pageSize = block.pageSize;
//		        var pageSize = properties.data.pageSize;
//		        var pageNum = properties.data.pageNum;
		        if(chain) {
		            chain.execute({
//		            	pageSize:pageSize,
//		            	pageNum:pageNum
		            });
		        }
			});
		}
})