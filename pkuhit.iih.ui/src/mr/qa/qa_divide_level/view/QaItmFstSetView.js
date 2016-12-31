/** 
 * 一级分类设置（新增、编辑）视图
 * @author ：yao_lijie
 */

Ext.define('iih.mr.qa.qa_divide_level.view.QaItmFstSetView',{
	extend : 'Xap.ej.template.BaseTemplate',
	
	alias:'widget.qaitmfstsetview', 
	
	requires:[
	          'Xap.ej.block.ToolbarBlock',
	   		  'Xap.ej.element.button.Button',
	   		  'Xap.ej.element.grid.plugin.CellEditing',
	          'Xap.ej.element.grid.column.CheckColumn',
	          'Xap.ej.element.grid.column.Number',
	          'Xap.ej.element.field.NumberField',
	          'Xap.ej.block.GridBlock',
	          'Xap.ej.element.field.RangeNumberField',
	          'iih.mr.qa.qa_divide_level.block.QaItmFstSetBlock',
	          'iih.mr.qa.qa_divide_level.action.QaItmFstSetSearchAction',
	          'iih.mr.qa.qa_divide_level.action.QaItmFstVaidatorNmAction',
	          'iih.mr.qa.process_qa_work.action.FaultInputSaveAction',
	          'iih.mr.qa.process_qa_work.action.FaultInputCloseAction'
	          ],
	
	xapConfig:{         
		blocks: {
			'content':{
				xclass: 'iih.mr.qa.qa_divide_level.block.QaItmFstSetBlock',
				height:180
			}
		},
		actions:{
			'init':{
				xclass: 'iih.mr.qa.qa_divide_level.action.QaItmFstSetSearchAction',
				url:'qaitmfst/set',
				blocks: {
				    content: 'content'
				}
			},
			'vaidatorNm':{
				xclass: 'iih.mr.qa.qa_divide_level.action.QaItmFstVaidatorNmAction',
				url:'qaitmfst/vaidatorNm',
				blocks: {
				    content: 'content'
				}
			},
			'saveQaItmFst':{
				xclass: 'iih.mr.qa.qa_divide_level.action.QaItmFstSaveAction',
				url:'qaitmfst/save',
				blocks: {
				    content: 'content'
				}
			},
			'closeQaItmFst':{
				xclass: 'iih.mr.qa.process_qa_work.action.FaultInputCloseAction',
				blocks: {
				    content: 'content'
				}
			}
		},
		chains:{
			'init':['init'],
			'vaidatorNm':['vaidatorNm'],
			'saveQaItmFst':['saveQaItmFst'],
			'closeQaItmFst':['closeQaItmFst']
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
				chain: 'closeQaItmFst'
			}/*,{
				selector: 'xaptextfield[name=nm]',
				event: 'blur',
				chain: 'vaidatorNm'
			}*/]
		}
	}
})