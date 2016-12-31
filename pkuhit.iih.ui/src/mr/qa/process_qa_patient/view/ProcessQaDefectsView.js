/** 
 * 环节质控缺陷列表
 * @author ：yao_lijie
 */
 
Ext.define('iih.mr.qa.process_qa_patient.view.ProcessQaDefectsView',{
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
	           'iih.mr.qa.process_qa_search.block.NotificationDefectListBlock',
	           'iih.mr.qa.process_qa_patient.action.QaDefectListAction',
	           'iih.mr.qa.process_qa_track.action.QaMrSignOpenAction'
	],

	alias:'widget.processqadefectsview',
	
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
				xclass: 'iih.mr.qa.process_qa_search.block.NotificationDefectListBlock',
				height:200
			}
		},
		
		actions: {
			'init': {
				xclass: 'iih.mr.qa.process_qa_patient.action.QaDefectListAction',
				url: 'qa/patient/faults',
				blocks: {
					condition: 'properties',
					top:'top',
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
			'processQaDefectViewready': {
				xclass: 'iih.mr.qa.process_qa_search.action.ProcessQaDefectViewreadyAction',
				blocks: {
					top: 'top',
					bottom: 'bottom'
				}
			}
		},

		chains: {
			'init':['init'],
			'qaMrSignOpen':['qaMrSignOpen'],
			'processQaDefectViewready':['processQaDefectViewready']
		},

		connections: {
			'bottom':[/*{
				event: 'afterrender',
				chain: 'init'
			},*/{
				selector: 'xapgrid',
				event: 'viewready',
				chain: 'processQaDefectViewready'
			},{
				selector: 'xapgrid',
				event:'itemdblclick',
				chain: 'qaMrSignOpen'
			},{
                selector: 'xapgrid',
                event: 'linkClick',
                chain: 'qaMrSignOpen'
            }]
		}
	},
		
	initComponent : function() {
			this.callParent();
			this.addEvents("pageRefresh");//为视图添加刷新事件
			this.addListener('pageRefresh', function(){//添加监听事件
				var properties = this.getLayer(Xap.ej.block.Layer.PROPERTIES);
		        var chain = this.getActionChain('init');
		        if(chain) {
		            chain.execute({});
		        }
			});
		}
})