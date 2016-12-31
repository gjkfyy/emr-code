
/** 
 * 自动缺陷列表
 * @author ：yao_lijie
 */
 
Ext.define('iih.mr.qa.dept_qa_auto_search.view.QaAutoDefectView',{
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
	           'iih.mr.qa.score.block.ScoreFormBlock',
	           'iih.mr.qa.dept_qa_auto_search.block.QaAutoDefectListBlock',
			   'iih.mr.qa.score.action.ScoreItemListSearchAction',
			   'iih.mr.qa.process_qa_track.action.QaMrSignOpenAction'
	],

	alias:'widget.qaautodefectview',
	
	layout: {
        type : 'vbox',
        align : 'stretch'
    },
    
	xapConfig: {
		blocks: {
		    'condition': {
                xclass: 'iih.mr.qa.dept_qa_auto_search.block.QaAutoPatientListBlock',
                height: 76
            },
            'toolbar': {
				xclass: 'Xap.ej.block.ToolbarBlock',
				items: [{
					xtype: 'button',
					iconCls: 'icon-Search',
					text: '查询',
					action: 'search'
				}]
			},
			'result': {
				xclass: 'iih.mr.qa.dept_qa_auto_search.block.QaAutoDefectListBlock',
				flex:1
			}
		},
		
		actions: {
			'init': {
				xclass: 'iih.mr.qa.dept_qa_auto_search.action.QaAutoFltSearchAction',
				url: 'qacustom/qaAutoFlt',
				blocks: {
					condition:'condition',
					result: 'result'
				}
			},
			'searchMrType':{
                xclass:'iih.mr.qa.dept_qa_auto_search.action.SearchMrTypeAction',
                url:'mrtypes',
                blocks:{
                	condition:'condition'
                }
            },
			'popupMrDocList':{
                xclass:'iih.mr.qa.dept_qa_auto_search.action.PopupMrDocListAction',
                blocks:{
                	result:'result'
                }
            }
		},

		chains: {
			'init':['init'],
			'searchMrType':['searchMrType'],
			'popupMrDocList':['popupMrDocList']
		},

		connections: {
			'condition':[{
                selector: 'xapcombobox[name=mrTypes]',
                event: 'change',
                chain: 'init'
			}],
			'result':[{
				event: 'afterrender',
				chain: 'searchMrType'
			},{
				selector: 'xapgrid',
				event : 'itemdblclick',
				chain: 'popupMrDocList'
			},{//翻页操作
				selector: 'xapgrid',
				event: 'turnpage',
				chain: 'init'
			}],
			'toolbar': [{
				selector: 'button[action=search]',
				event: 'click',
				chain: 'init'
			}]
		
		},
		
		initComponent : function() {
				this.callParent();
				this.addEvents("pageRefresh");//为视图添加刷新事件
				this.addListener('pageRefresh', function(){//添加监听事件
					 var properties = this.getLayer(Xap.ej.block.Layer.PROPERTIES);
			        var chain = this.getActionChain('init');
			        var block = this.getBlock('result');
//			        var pageSize = block.pageSize;
			        if(properties.data == undefined){
			        	 if(chain) {
			            chain.execute({});
			        	}
			        }else{
			        	var pageSize = properties.data.pageSize;
				        var pageNum = properties.data.pageNum;
				        if(chain) {
				            chain.execute({
				            	pageSize:pageSize,
				            	pageNum:pageNum
				            });
				        }
			        }
				});
			}
	}
})