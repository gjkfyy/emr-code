
/** 
 * 环节质控追踪缺陷列表
 * @author ：cheng_feng
 */
 
Ext.define('iih.mr.qa.process_qa_track.view.ProcessQaDefectView',{
//	extend : 'Xap.ej.stl.view.TopBottomContainerTemplate',
	extend: 'Xap.ej.template.BaseTemplate',
	requires: [
	           'Xap.ej.element.grid.Grid', 
	           'Xap.ej.element.field.Checkbox',
	           'Xap.ej.element.field.ComboBox',
	           'Xap.ej.element.button.Button',
	           'Xap.ej.element.label.Label',
	           'Xap.ej.element.grid.column.Date',
	           'iih.mr.qa.QaStatusGlobal',
	           'Xap.ej.block.GridBlock',
	           'iih.mr.qa.process_qa_work.block.QaMrEditBlock',
	           'iih.mr.qa.process_qa_track.block.DefectListBlock',
			   'iih.mr.qa.process_qa_track.action.DefectListAction',
			   'iih.mr.qa.process_qa_track.action.ProcessQaDefectViewreadyAction',
			   'iih.mr.qa.process_qa_track.action.WakeDefectButtonAction',
			   'iih.mr.qa.process_qa_track.action.QaMrSignOpenAction',
			   'iih.mr.qa.process_qa_track.action.DefectCheckPassAction',
			   'iih.mr.qa.process_qa_track.action.DefectDeductionAction',
			   'iih.mr.qa.process_qa_track.action.DefectRectificationAction',
			   'iih.mr.qa.process_qa_track.action.DefectFinishCheckAction',
			   'iih.mr.qa.process_qa_track.action.DefectStatisticalAction',
			   'iih.mr.qa.process_qa_work.view.DefectNoticeInferView',
			   'iih.mr.qa.process_qa_track.action.PopupNotificationAction'
	],

	alias:'widget.processqadefectview',
	
	layout: {
        type : 'vbox',
        align : 'stretch'
    },
    
	xapConfig: {
		blocks: {
		    'top': {
                xclass: 'iih.mr.qa.process_qa_work.block.QaMrEditBlock',
                flex:1
            },
			'bottom': {
				xclass: 'iih.mr.qa.process_qa_track.block.DefectListBlock',
				height:200
			}
		},
		
		actions: {
			'init': {
				xclass: 'iih.mr.qa.process_qa_track.action.DefectListAction',
				url: 'qa/notification/faults',
				blocks: {
					condition: 'properties',
					result: 'bottom'
				}
			},
			'processQaDefectViewready': {
				xclass: 'iih.mr.qa.process_qa_track.action.ProcessQaDefectViewreadyAction',
				blocks: {
					top: 'top',
					bottom: 'bottom'
				}
			},
			'wakeDefectButton': {
				xclass: 'iih.mr.qa.process_qa_track.action.WakeDefectButtonAction',
				blocks: {
					condition: 'properties',
					result: 'bottom'
				}
			},
			'qaMrSignOpen': {
				xclass: 'iih.mr.qa.process_qa_track.action.QaMrSignOpenAction',
				blocks: {
					condition: 'properties',
					top: 'top',
					result: 'bottom'
				}
			},
			'checkPass': {
				xclass: 'iih.mr.qa.process_qa_track.action.DefectCheckPassAction',
				url: 'qa/fault/checkpass',
				blocks: {
					condition: 'properties',
					result: 'bottom'
				}
			},
			'deduction': {
				xclass: 'iih.mr.qa.process_qa_track.action.DefectDeductionAction',
				url: 'qa/fault/deduction',
				blocks: {
					condition: 'properties',
					result: 'bottom'
				}
			},
			'rectification': {
				xclass: 'iih.mr.qa.process_qa_track.action.DefectRectificationAction',
				url: 'qa/fault/rectification',
				blocks: {
					condition: 'properties',
					result: 'bottom'
				}
			},
			'finishCheck': {
				xclass: 'iih.mr.qa.process_qa_track.action.DefectFinishCheckAction',
				url: 'qa/notification/finishCheck',
				blocks: {
					condition: 'properties',
					result: 'bottom'
				}
			},
			'statistical': {
				xclass: 'iih.mr.qa.process_qa_track.action.DefectStatisticalAction',
				url: 'qa/notification/faultStatistical',
				blocks: {
					condition: 'properties',
					result: 'bottom'
				}
			},
			'popupNotification': {
				xclass: 'iih.mr.qa.process_qa_track.action.PopupNotificationAction',
				blocks: {
					condition: 'properties',
					result: 'bottom'
				}
			}
		},

		chains: {
			'init':['init'],
			'processQaDefectViewready':['processQaDefectViewready'],
			'wakeDefectButton':['wakeDefectButton'],
			'qaMrSignOpen':['qaMrSignOpen'],
			'checkPass':['checkPass'],
			'deduction':['deduction'],
			'rectification':['rectification'],
			'finishCheck':['finishCheck'],
			'statistical':['statistical'],
			'popupNotification':['popupNotification']
		},

		connections: {
			'bottom':[{
				event: 'afterrender',
				chain: 'init'
			},/*{
				selector: 'xapgrid',
				event:'itemclick',
				chain: 'inQaWork'
			},*/{
				selector: 'xapgrid',
				event: 'viewready',
				chain: 'processQaDefectViewready'
			},{
                selector: 'xapgrid',
                event: 'linkClick',
                chain: 'qaMrSignOpen'
            },{
				selector: 'xapgrid',
				event:'select',
				chain: 'wakeDefectButton'
			},{
				selector: 'xapgrid',
				event:'itemdblclick',
				chain: 'qaMrSignOpen'
			}]
		}
	}/*,
	
	initComponent : function() {
		this.callParent();
		this.addEvents("pageRefresh");//为视图添加刷新事件
		this.addListener('pageRefresh', function(){//添加监听事件
	        var chain = this.getActionChain('init');
	        if(chain) {
	            chain.execute();
	        }
		});
	}*/
})