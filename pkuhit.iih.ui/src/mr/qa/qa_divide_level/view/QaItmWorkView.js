/** 
 * 质控项目设置视图
 * @author ：yao_lijie
 */

Ext.define('iih.mr.qa.qa_divide_level.view.QaItmWorkView',{
	extend : 'Xap.ej.template.BaseTemplate',
	
	alias:'widget.qaitmworkview', 
	
	requires:[
	          'Xap.ej.block.ToolbarBlock',
	          'Xap.ej.element.tree.Tree',
	   		  'Xap.ej.element.button.Button',
	   		  'Xap.ej.element.grid.plugin.CellEditing',
	          'Xap.ej.element.grid.column.CheckColumn',
	          'Xap.ej.element.grid.column.Number',
	          'Xap.ej.element.field.NumberField',
	          'Xap.ej.block.GridBlock',
	          'iih.mr.qa.qa_divide_level.block.QaItmWorkBlock',
	          'iih.mr.qa.qa_divide_level.action.QaItmWorkInitAction'
	          ],
	          
	layout: {
        type: 'fit'
    },
	
	xapConfig:{         
		blocks: {
			'content':{
				xclass: 'iih.mr.qa.qa_divide_level.block.QaItmWorkBlock',
				flex:1
			}
		},
		actions:{
			'init':{
				xclass: 'iih.mr.qa.qa_divide_level.action.QaItmWorkInitAction',
				blocks: {
				    content: 'content'
				}
			}
		},
		chains:{
			'init':['init']
		},
		connections:{
			'content':[{
				event: 'afterrender',
				chain: 'init'
			},{
                selector: 'xaptabpanel',
                event: 'tabchange',
                chain: 'init'
            }]
		}
	}
})