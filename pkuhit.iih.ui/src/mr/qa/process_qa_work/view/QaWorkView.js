
/** 
 * 质控工作主画面
 * @extends Xap.ej.template.BaseTemplate
 * @author ：wang_yanli
 */

Ext.define('iih.mr.qa.process_qa_work.view.QaWorkView',{
	extend:'Xap.ej.template.BaseTemplate',
	alias:'widget.qaworkview', 
	
	layout: 'fit',
	
	requires:[
              'iih.mr.qa.process_qa_work.block.QaWorkBlock',
              'iih.mr.qa.process_qa_work.action.QaWorkInitAction',
              'iih.mr.qa.process_qa_work.action.MrInTreeItemClickAction',
              'Ext.grid.plugin.CellEditing',
	          'Xap.ej.element.grid.plugin.CellEditing',
	          'Xap.ej.element.grid.column.ActionColumn',
	          'Xap.ej.element.button.Button',
	          'Xap.ej.element.field.Checkbox',
	          'Xap.ej.element.field.ComboBox',
	          'Xap.ej.element.field.TextField',
	          'Xap.ej.element.grid.column.Date',
	          'Xap.ej.element.grid.Grid',
	          'Xap.ej.element.grid.column.RowNumberer',
	          'iih.mr.qa.QaStatusGlobal',
	          'iih.mr.qa.process_qa_work.view.DefectNoticeInferView',
	          'iih.mr.qa.process_qa_work.action.IfShowHelperAction'
	         ],
	         
	xapConfig:{ 
			blocks: {   
				'content': {
					xclass: 'iih.mr.qa.process_qa_work.block.QaWorkBlock'
				}
			},
			actions:{
				'init': {
					xclass: 'iih.mr.qa.process_qa_work.action.QaWorkInitAction',
					blocks: {
						content:'content'
					}
				},
				'treeItemClickAction':{
					xclass: 'iih.mr.qa.process_qa_work.action.MrInTreeItemClickAction',
					blocks: {
						content:'content'
					}
				},
				'ifShowHelperAction':{
	            	xclass: 'iih.mr.qa.process_qa_work.action.IfShowHelperAction',
	            	url: 'param/set/getflagbykey',
	                blocks:{
	                	content:'content'	
					}
	            }
			},
			chains:{
				'init':['init'],
				'treeItemClickAction':['treeItemClickAction'],
				'ifShowHelperAction':['ifShowHelperAction']
				//'closeAction':['closeAction']
			},
			connections:{
				'content':[{
					event: 'afterrender',
					chain: 'ifShowHelperAction'
				},
				{
					selector : 'mrinblock qamrdoctreeview xaptree',
					event: 'itemclick',
					chain: 'treeItemClickAction'
				}]
			}
	  }	     	

	
})