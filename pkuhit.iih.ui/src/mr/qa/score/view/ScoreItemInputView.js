/** 
 * 集成编辑器和缺陷一览视图
 * @extends Xap.ej.stl.view.TopBottomContainerTemplate
 * @author ：wu_guocheng
 */

Ext.define('iih.mr.qa.score.view.ScoreItemInputView',{
	extend : 'Xap.ej.template.BaseTemplate',
	
	alias:'widget.scoreiteminputview', 
	
	requires:[
	          'Xap.ej.block.ToolbarBlock',
	   		  'Xap.ej.element.button.Button',
	   		  'Xap.ej.element.grid.plugin.CellEditing',
	          'Xap.ej.element.grid.column.CheckColumn',
	          'Xap.ej.element.grid.column.Number',
	          'Xap.ej.element.field.NumberField',
	          'Xap.ej.block.GridBlock',
	          'iih.mr.qa.score.action.ScoreItemSaveAction',
	          'iih.mr.qa.process_qa_work.action.QaItmFstSearchAction',
	          'iih.mr.qa.process_qa_work.action.QaItmSndSearchAction',
	          'iih.mr.qa.process_qa_work.action.QaItmSearchAction',
	   		  'iih.mr.qa.process_qa_work.action.FaultInputSearchAction',
	   		  'iih.mr.qa.process_qa_work.action.FaultInputSaveAction',
	   		  'iih.mr.qa.process_qa_work.action.FaultInputCloseAction'
	          ],
	
	xapConfig:{         
		blocks: {
			'top':{
				xclass: 'iih.mr.qa.score.block.ScoreFaultInputBlock',
				height: 460
			}/*,
			'bottom':{
				xclass: 'Xap.ej.block.ToolbarBlock',
				items:[{
					xtype: 'xapbutton',
					text: '确认',
					action: 'save',
					iconCls: 'icon-send'
				},{
					xtype: 'xapbutton',
					text: '取消',
					action: 'cancel',
					iconCls: 'icon-cancel'
				}]
			}*/
		},
		actions:{
			'initQaItmFst':{ 
                xclass:'iih.mr.qa.process_qa_work.action.QaItmFstSearchAction',
                url:'mr/qaitm/init',
                blocks:{
                    content: 'top'
                }
            },
			'init':{
				xclass: 'iih.mr.qa.process_qa_work.action.FaultInputSearchAction',
				url:'qacustom/item',
				blocks: {
				    content: 'top'
				}
			},
			'searchQaItmSnd':{
                xclass:'iih.mr.qa.process_qa_work.action.QaItmSndSearchAction',
                url:'itmsnd',
                blocks:{
                    content:'top'
                }
            },
            'searchQaItm':{
                xclass:'iih.mr.qa.process_qa_work.action.QaItmSearchAction',
                blocks:{
                    content:'top'
                }
            },
			'scoreItemSave':{
				xclass: 'iih.mr.qa.score.action.ScoreItemSaveAction',
				url:'qacustom/dropScoreItems',
				blocks: {
				    content: 'top'
				}
			},
			'closeFaultAction':{
				xclass: 'iih.mr.qa.process_qa_work.action.FaultInputCloseAction',
				blocks: {
				    content: 'top'
				}
			}
		},
		chains:{
			'initQaItmFst':['initQaItmFst'],
			'init':['init'],
			'searchQaItmSnd':['searchQaItmSnd'],
			'searchQaItm':['searchQaItm'],
			'scoreItemSave':['scoreItemSave'],
			'closeFaultAction':['closeFaultAction']
		},
		connections:{
			'top':[/*{
                event:'afterrender',
                chain:'initAmrScore'
            },*/{
                selector: 'xapcombobox[name=qaItmFst]',
                event: 'change',
                chain: 'searchQaItmSnd'
            },{
                selector: 'xapcombobox[name=qaItmSnd]',
                event: 'change',
                chain: 'searchQaItm'
            },{
				selector: 'button[action=save]',
				event: 'click',
				chain: 'scoreItemSave'
			},{
				selector: 'xapgridblock',
				event: 'itemdblclick',
				chain: 'scoreItemSave'
			},{
				selector: 'button[action=cancel]',
				event: 'click',
				chain: 'closeFaultAction'
			}]
		}
	}
})