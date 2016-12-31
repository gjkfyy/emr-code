/** 
 * 质控项目设置视图
 * @author ：yao_lijie
 */

Ext.define('iih.mr.qa.qa_divide_level.view.QaItmView',{
	extend: 'Xap.ej.stl.view.LeftRightContainerTemplate',
	
	alias:'widget.qaitmview', 
	
	requires:[
	          'Xap.ej.block.ToolbarBlock',
	          'Xap.ej.element.tree.Tree',
	   		  'Xap.ej.element.button.Button',
	   		  'Xap.ej.element.grid.plugin.CellEditing',
	          'Xap.ej.element.grid.column.CheckColumn',
	          'Xap.ej.element.grid.column.Number',
	          'Xap.ej.element.field.NumberField',
	          'Xap.ej.block.GridBlock',
	          'iih.mr.qa.qa_divide_level.block.QaItmSndTreeBlock',
	          'iih.mr.qa.qa_divide_level.block.QaItmBlock',
	          'iih.mr.qa.qa_divide_level.action.QaItmSndTreeInitAction',
	          'iih.mr.qa.qa_divide_level.action.QaItmSndTreeSelectAction',
	          'iih.mr.qa.qa_divide_level.action.QaDivideLevelViewreadyAction',
	          'iih.mr.qa.qa_divide_level.action.PopupQaItmAction',
	          'iih.mr.qa.qa_divide_level.action.QaItmSndEditAction',
	          'iih.mr.qa.qa_divide_level.action.QaDivideLevelDelAction',
	          'iih.mr.qa.qa_divide_level.action.ToQaAutoConfig'
	          ],
	
	xapConfig:{         
		blocks: {
			'left':{
				xclass: 'iih.mr.qa.qa_divide_level.block.QaItmSndTreeBlock',
				width:300
			},
			'right':{
				xclass: 'iih.mr.qa.qa_divide_level.block.QaItmBlock'
			}
		},
		actions:{
			'initTree':{
				xclass: 'iih.mr.qa.qa_divide_level.action.QaItmSndTreeInitAction',
				url:'qaitm/tree',
				blocks: {
				    left: 'left',
				    right:'right'
				}
			},
			'treeSelect': {
				xclass: 'iih.mr.qa.qa_divide_level.action.QaItmSndTreeSelectAction',
				url: 'qacustom/item',
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
				xclass: 'iih.mr.qa.qa_divide_level.action.PopupQaItmAction',
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
			'popupQaItm':{
				xclass: 'iih.mr.qa.qa_divide_level.action.PopupQaItmAction',
				blocks: {
				   left: 'left',
				   right: 'right'
				}
			},
			'delLevel':{
				xclass: 'iih.mr.qa.qa_divide_level.action.QaDivideLevelDelAction',
				url:'qaitm/del',
				blocks: {
				   left: 'left',
				   content: 'right'
				}
			},
			'toQaAutoConfig':{
				xclass: 'iih.mr.qa.qa_divide_level.action.ToQaAutoConfig',
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
			'popupQaItm':['popupQaItm'],
			'delLevel':['delLevel'],
			'toQaAutoConfig':['toQaAutoConfig']
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
			},/*{
				selector: 'xapgrid',
				event : 'itemclick',
				chain: 'judgeBtn'
			},*/{
				selector: 'xapgrid',
				event : 'itemdblclick',
				chain: 'toQaAutoConfig'
			}]
		}
	}
})