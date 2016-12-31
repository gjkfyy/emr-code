
/** 
 * 环节整改通知列表(住院医生站)
 * @author ：yao_lijie
 */
 
Ext.define('iih.mr.qa.process_qa_reform.view.ProcessRfmNotificationView',{
	extend: 'Xap.ej.template.BaseTemplate',

	requires: [
	           'Xap.ej.element.grid.Grid', 
	           'Xap.ej.element.field.Checkbox',
	           'Xap.ej.element.field.ComboBox',
	           'Xap.ej.element.button.Button',
	           'Xap.ej.element.label.Label',
	           'Xap.ej.element.grid.column.Date',
	           'iih.mr.qa.QaStatusGlobal',
	           'iih.mr.qa.process_qa_reform.block.RfmNotificationListBlock',
	           'iih.mr.qa.process_qa_reform.action.NotificationListSearchAction',
	           'iih.mr.qa.process_qa_reform.action.ProcessRfmNotificationViewreadyAction',
	           'iih.mr.qa.process_qa_reform.action.ToStartRfmAction',
	           'iih.mr.qa.process_qa_reform.action.PopProcessRfmDefectAction'
	],

	alias:'widget.processnotificationwrview',
	layout: {
        type: 'fit'
    },
    
	xapConfig: {
		blocks: {
            'content': {
                xclass: 'iih.mr.qa.process_qa_reform.block.RfmNotificationListBlock',
                flex: 1
            }
		},
		
		actions: {
			'init': {
				xclass: 'iih.mr.qa.process_qa_reform.action.NotificationListSearchAction',
				url: 'qa/notifications',
				blocks: {
					content: 'content'
				}
			},
			'processRfmNotificationViewReadyAction': {
				xclass: 'iih.mr.qa.process_qa_reform.action.ProcessRfmNotificationViewreadyAction',
				blocks: {
					content: 'content'
				}
			},
			'stertRfm': {
				xclass: 'iih.mr.qa.process_qa_reform.action.ToStartRfmAction',
				url: 'qa/notification/startRfm',
				blocks: {
					content: 'content'
				}
			},
			'popProcessRfmDefect': {
				xclass: 'iih.mr.qa.process_qa_reform.action.PopProcessRfmDefectAction',
				blocks: {
					content: 'content'
				}
			}
		},

		chains: {
			'init':['init'],
			'stertRfm':['stertRfm'],
			'popProcessRfmDefect':['popProcessRfmDefect'],
			'processRfmNotificationViewReadyAction':['processRfmNotificationViewReadyAction']
		},

		connections: {
			'content': [{
				event: 'afterrender',
				chain: 'init'
			},{
				selector: 'xapgrid',
				event: 'itemdblclick',
				chain: 'stertRfm'
			},{
				selector: 'xapgrid',
				event: 'viewready',
				chain: 'processRfmNotificationViewReadyAction'
			}
			]
		}

	},
		
	initComponent : function() {
			this.callParent();
			this.addEvents("pageRefresh");//为视图添加刷新事件
			this.addListener('pageRefresh', function(){//添加监听事件
		        var chain = this.getActionChain('init');
		        if(chain) {
		            chain.execute();
		        }
			});
		}
})