/** 
 * 编辑整改说明视图
 * @author ：yao_lijie
 */

Ext.define('iih.mr.qa.process_qa_work.view.DefectEditView',{
	extend : 'Xap.ej.template.BaseTemplate',
	
	alias:'widget.defecteditview', 
	
	requires:[
	          'Xap.ej.block.ToolbarBlock',
	   		  'Xap.ej.element.button.Button',
	   		  'Xap.ej.element.grid.plugin.CellEditing',
	          'Xap.ej.element.grid.column.CheckColumn',
	          'Xap.ej.element.grid.column.Number',
	          'Xap.ej.element.field.NumberField',
	          'Xap.ej.block.GridBlock',
	          'Xap.ej.element.field.RangeNumberField',
	          'iih.mr.qa.process_qa_work.block.DefectEditBlock',
	          'iih.mr.qa.process_qa_work.action.DefectEditInitAction',
	          'iih.mr.qa.process_qa_work.action.DefectEditSaveAction',
	          'iih.mr.qa.process_qa_work.action.FaultInputCloseAction'
	          ],
	
	xapConfig:{         
		blocks: {
			'content':{
				xclass: 'iih.mr.qa.process_qa_work.block.DefectEditBlock',
				height:210
			}
		},
		actions:{
			'init':{
				xclass: 'iih.mr.qa.process_qa_work.action.DefectEditInitAction',
				blocks: {
				    content: 'content'
				}
			},
			'saveDefect':{
				xclass: 'iih.mr.qa.process_qa_work.action.DefectEditSaveAction',
				url:'qacustom/saverfmdes',
				blocks: {
				    content: 'content'
				}
			},
			'close':{
				xclass: 'iih.mr.qa.process_qa_work.action.FaultInputCloseAction',
				blocks: {
				    content: 'content'
				}
			}
		},
		chains:{
			'init':['init'],
			'saveDefect':['saveDefect'],
			'close':['close']
		},
		connections:{
			'content':[{
				selector: 'button[action=save]',
				event: 'click',
				chain: 'saveDefect'
			},{
				selector: 'button[action=cancel]',
				event: 'click',
				chain: 'close'
			}]
		}
	}
})