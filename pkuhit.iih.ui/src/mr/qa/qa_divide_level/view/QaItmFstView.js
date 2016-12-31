/** 
 * 病案等级设置视图
 * @author ：yao_lijie
 */

Ext.define('iih.mr.qa.qa_divide_level.view.QaItmFstView',{
	extend : 'Xap.ej.template.BaseTemplate',
	
	alias:'widget.qaitmfstview', 
	
	requires:[
	          'Xap.ej.block.ToolbarBlock',
	   		  'Xap.ej.element.button.Button',
	   		  'Xap.ej.element.grid.plugin.CellEditing',
	          'Xap.ej.element.grid.column.CheckColumn',
	          'Xap.ej.element.grid.column.Number',
	          'Xap.ej.element.field.NumberField',
	          'Xap.ej.block.GridBlock',
	          'iih.mr.qa.qa_divide_level.block.QaItmFstBlock',
	          'iih.mr.qa.qa_divide_level.action.QaDivideLevelSearchAction',
	          'iih.mr.qa.qa_divide_level.action.QaDivideLevelViewreadyAction',
	          'iih.mr.qa.qa_divide_level.action.PopupQaItmFstAction',
	          'iih.mr.qa.qa_divide_level.action.QaDivideLevelEditAction',
	          'iih.mr.qa.qa_divide_level.action.QaDivideLevelDelAction'
	          ],
	          
	layout: {
        type : 'fit'
    },
	
	xapConfig:{         
		blocks: {
			'content':{
				xclass: 'iih.mr.qa.qa_divide_level.block.QaItmFstBlock',
				flex:1
			}
		},
		actions:{
			'init':{
				xclass: 'iih.mr.qa.qa_divide_level.action.QaDivideLevelSearchAction',
				url:'qaitmfst',
				blocks: {
				    content: 'content'
				}
			},
			'qaDivideLevelViewready':{
				xclass: 'iih.mr.qa.qa_divide_level.action.QaDivideLevelViewreadyAction',
				blocks: {
				    content: 'content'
				}
			},
			'addLevel':{
				xclass: 'iih.mr.qa.qa_divide_level.action.PopupQaItmFstAction',
				blocks: {
				    content: 'content'
				}
			},
			/*'judgeBtn':{
				xclass: 'iih.mr.qa.qa_divide_level.action.JudgeBtnAction',
				blocks: {
				    content: 'content'
				}
			},*/
			'editLevel':{
				xclass: 'iih.mr.qa.qa_divide_level.action.QaDivideLevelEditAction',
				blocks: {
				    content: 'content'
				}
			},
			'popupQaItmFst':{
				xclass: 'iih.mr.qa.qa_divide_level.action.PopupQaItmFstAction',
				blocks: {
				    content: 'content'
				}
			},
			'delLevel':{
				xclass: 'iih.mr.qa.qa_divide_level.action.QaDivideLevelDelAction',
				url:'qaitmfst/del',
				blocks: {
				    content: 'content'
				}
			}
		},
		chains:{
			'init':['init'],
			'qaDivideLevelViewready':['qaDivideLevelViewready'],
			'addLevel':['addLevel'],
//			'judgeBtn':['judgeBtn'],
			'editLevel':['editLevel'],
			'popupQaItmFst':['popupQaItmFst'],
			'delLevel':['delLevel']
		},
		connections:{
			'content':[/*{
				event: 'afterrender',
				chain: 'init'
			},*/{
				selector: 'xapgrid',
				event : 'viewready',
				chain: 'qaDivideLevelViewready'
			}/*,{
				selector: 'xapgrid',
				event : 'itemclick',
				chain: 'judgeBtn'
			}*/]
		}
	}
})