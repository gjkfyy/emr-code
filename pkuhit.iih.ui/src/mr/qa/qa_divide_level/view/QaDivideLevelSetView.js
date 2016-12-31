/** 
 * 病案等级设置（新增、编辑）视图
 * @author ：yao_lijie
 */

Ext.define('iih.mr.qa.qa_divide_level.view.QaDivideLevelSetView',{
	extend : 'Xap.ej.template.BaseTemplate',
	
	alias:'widget.qadividelevelsetview', 
	
	requires:[
	          'Xap.ej.block.ToolbarBlock',
	   		  'Xap.ej.element.button.Button',
	   		  'Xap.ej.element.grid.plugin.CellEditing',
	          'Xap.ej.element.grid.column.CheckColumn',
	          'Xap.ej.element.grid.column.Number',
	          'Xap.ej.element.field.NumberField',
	          'Xap.ej.block.GridBlock',
	          'Xap.ej.element.field.RangeNumberField',
	          'iih.mr.qa.qa_divide_level.block.QaDivideLevelSetBlock',
	          'iih.mr.qa.qa_divide_level.action.QaDivideLevelSetSearchAction',
	          'iih.mr.qa.qa_divide_level.action.QaDivideLevelVaidatorNmAction',
	          'iih.mr.qa.qa_divide_level.action.QaDivideLevelSaveAction',
	          'iih.mr.qa.process_qa_work.action.FaultInputCloseAction'
	          ],
	
	xapConfig:{         
		blocks: {
			'content':{
				xclass: 'iih.mr.qa.qa_divide_level.block.QaDivideLevelSetBlock',
				height:180
			}
		},
		actions:{
			'init':{
				xclass: 'iih.mr.qa.qa_divide_level.action.QaDivideLevelSetSearchAction',
				url:'qadividelevel/set',
				blocks: {
				    content: 'content'
				}
			},
			'vaidatorNm':{
				xclass: 'iih.mr.qa.qa_divide_level.action.QaDivideLevelVaidatorNmAction',
				url:'qadividelevel/vaidatorNm',
				blocks: {
				    content: 'content'
				}
			},
			'saveQaDivideLevel':{
				xclass: 'iih.mr.qa.qa_divide_level.action.QaDivideLevelSaveAction',
				url:'qadividelevel/save',
				blocks: {
				    content: 'content'
				}
			},
			'closeQaDivideLevel':{
				xclass: 'iih.mr.qa.process_qa_work.action.FaultInputCloseAction',
				blocks: {
				    content: 'content'
				}
			}
		},
		chains:{
			'init':['init'],
			'vaidatorNm':['vaidatorNm'],
			'saveQaDivideLevel':['saveQaDivideLevel'],
			'closeQaDivideLevel':['closeQaDivideLevel']
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
				chain: 'closeQaDivideLevel'
			}/*,{
				selector: 'xapcombobox[name=lvl]',
				event: 'blur',
				chain: 'vaidatorNm'
			}*/]
		}
	}
})