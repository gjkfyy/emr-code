/** 
 * 病案等级设置视图
 * @author ：yao_lijie
 */

Ext.define('iih.mr.qa.qa_divide_level.view.QaItmSndView',{
	extend: 'Xap.ej.stl.view.LeftRightContainerTemplate',
	
	alias:'widget.qaitmsndview', 
	
	requires:[
	          'Xap.ej.block.ToolbarBlock',
	          'Xap.ej.element.tree.Tree',
	   		  'Xap.ej.element.button.Button',
	   		  'Xap.ej.element.grid.plugin.CellEditing',
	          'Xap.ej.element.grid.column.CheckColumn',
	          'Xap.ej.element.grid.column.Number',
	          'Xap.ej.element.field.NumberField',
	          'Xap.ej.block.GridBlock',
	          'iih.mr.qa.qa_divide_level.block.QaItmFstTreeBlock',
	          'iih.mr.qa.qa_divide_level.block.QaItmSndBlock',
	          'iih.mr.qa.qa_divide_level.action.QaItmFstTreeInitAction',
	          'iih.mr.qa.qa_divide_level.action.QaItmFstTreeSelectAction',
	          'iih.mr.qa.qa_divide_level.action.QaDivideLevelViewreadyAction',
	          'iih.mr.qa.qa_divide_level.action.PopupQaItmSndAction',
	          'iih.mr.qa.qa_divide_level.action.QaItmSndEditAction',
	          'iih.mr.qa.qa_divide_level.action.QaDivideLevelDelAction'
	          ],
	
	xapConfig:{         
		blocks: {
			'left':{
				xclass: 'iih.mr.qa.qa_divide_level.block.QaItmFstTreeBlock',
				width:300
			},
			'right':{
				xclass: 'iih.mr.qa.qa_divide_level.block.QaItmSndBlock'
			}
		},
		actions:{
			'initTree':{
				xclass: 'iih.mr.qa.qa_divide_level.action.QaItmFstTreeInitAction',
				url:'qaitmsnd/tree',
				blocks: {
				    left: 'left',
				    right:'right'
				}
			},
			'treeSelect': {
				xclass: 'iih.mr.qa.qa_divide_level.action.QaItmFstTreeSelectAction',
				url: 'itmsnd',
				blocks: {
				   left: 'left',
				   right: 'right'
				}
            },
			'qaDivideLevelViewready':{
				xclass: 'iih.mr.qa.qa_divide_level.action.QaDivideLevelViewreadyAction',
				blocks: {
				    content: 'right'
				}
			},
			'addLevel':{
				xclass: 'iih.mr.qa.qa_divide_level.action.PopupQaItmSndAction',
				blocks: {
				   left: 'left',
				   right: 'right'
				}
			},
			/*'judgeBtn':{
				xclass: 'iih.mr.qa.qa_divide_level.action.JudgeBtnAction',
				blocks: {
				    content: 'right'
				}
			},*/
			'editLevel':{
				xclass: 'iih.mr.qa.qa_divide_level.action.QaItmSndEditAction',
				blocks: {
				   left: 'left',
				   right: 'right'
				}
			},
			'popupQaItmSnd':{
				xclass: 'iih.mr.qa.qa_divide_level.action.PopupQaItmSndAction',
				blocks: {
				   left: 'left',
				   right: 'right'
				}
			},
			'delLevel':{
				xclass: 'iih.mr.qa.qa_divide_level.action.QaDivideLevelDelAction',
				url:'qaitmsnd/del',
				blocks: {
				   left: 'left',
				   content: 'right'
				}
			}
		},
		chains:{
			'initTree':['initTree'],
			'treeSelect':['treeSelect'],
			'qaDivideLevelViewready':['qaDivideLevelViewready'],
			'addLevel':['addLevel'],
//			'judgeBtn':['judgeBtn'],
			'editLevel':['editLevel'],
			'popupQaItmSnd':['popupQaItmSnd'],
			'delLevel':['delLevel']
		},
		connections:{
			'left':[/*{
				event: 'afterrender',
				chain: 'initTree'
			},*/{
                selector: 'xaptree',
                event: 'select',
                chain: 'treeSelect'
            }],
			'right':[{
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