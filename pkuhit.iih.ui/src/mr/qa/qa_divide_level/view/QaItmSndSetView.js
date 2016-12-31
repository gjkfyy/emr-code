/** 
 * 一级分类设置（新增、编辑）视图
 * @author ：yao_lijie
 */

Ext.define('iih.mr.qa.qa_divide_level.view.QaItmSndSetView',{
	extend : 'Xap.ej.template.BaseTemplate',
	
	alias:'widget.qaitmsndsetview', 
	
	requires:[
	          'Xap.ej.block.ToolbarBlock',
	   		  'Xap.ej.element.button.Button',
	   		  'Xap.ej.element.grid.plugin.CellEditing',
	          'Xap.ej.element.grid.column.CheckColumn',
	          'Xap.ej.element.grid.column.Number',
	          'Xap.ej.element.field.NumberField',
	          'Xap.ej.block.GridBlock',
	          'Xap.ej.element.field.RangeNumberField',
	          'iih.mr.qa.qa_divide_level.block.QaItmSndSetBlock',
	          'iih.mr.qa.qa_divide_level.action.QaItmFstCobSearchAction',
	          'iih.mr.qa.qa_divide_level.action.QaItmSndSetSearchAction',
	          'iih.mr.qa.qa_divide_level.action.QaItmSndVaidatorNmAction',
	          'iih.mr.qa.qa_divide_level.action.QaItmSndSaveAction',
	          'iih.mr.qa.process_qa_work.action.FaultInputCloseAction'
	          ],
	
	xapConfig:{         
		blocks: {
			'content':{
				xclass: 'iih.mr.qa.qa_divide_level.block.QaItmSndSetBlock',
				height:180
			}
		},
		actions:{
			'initQaItmFst':{ 
                xclass:'iih.mr.qa.qa_divide_level.action.QaItmFstCobSearchAction',
                url:'qaitmfst',
                blocks:{
                    content: 'content'
                }
            },
            'init':{ 
                xclass:'iih.mr.qa.qa_divide_level.action.QaItmSndSetSearchAction',
                url:'qaitmsnd/set',
                blocks:{
                    content: 'content'
                }
            },
			'vaidatorNm':{
				xclass: 'iih.mr.qa.qa_divide_level.action.QaItmSndVaidatorNmAction',
				url:'qaitmsnd/vaidatorNm',
				blocks: {
				    content: 'content'
				}
			},
			'saveQaItmSnd':{
				xclass: 'iih.mr.qa.qa_divide_level.action.QaItmSndSaveAction',
				url:'qaitmsnd/save',
				blocks: {
				    content: 'content'
				}
			},
			'closeQaItmSnd':{
				xclass: 'iih.mr.qa.process_qa_work.action.FaultInputCloseAction',
				blocks: {
				    content: 'content'
				}
			}
		},
		chains:{
			'initQaItmFst':['initQaItmFst'],
			'init':['init'],
			'vaidatorNm':['vaidatorNm'],
			'saveQaItmSnd':['saveQaItmSnd'],
			'closeQaItmSnd':['closeQaItmSnd']
		},
		connections:{
			'content':[/*{
                event:'afterrender',
                chain:'init'
            },*/{
				selector: 'button[action=save]',
				event: 'click',
				chain: 'vaidatorNm'
			},{
				selector: 'button[action=cancel]',
				event: 'click',
				chain: 'closeQaItmSnd'
			}/*,{
				selector: 'xaptextfield[name=nm]',
				event: 'blur',
				chain: 'vaidatorNm'
			}*/]
		}
	}
})