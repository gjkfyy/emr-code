
/** 
 * 医嘱质控工作主画面
 * @extends Xap.ej.template.BaseTemplate
 * @author ：wang_yanli
 */

Ext.define('iih.mr.qa.order_qa_work.view.OrderQaWorkView',{
	extend:'Xap.ej.template.BaseTemplate',
	alias:'widget.iih.mr.qa.order_qa_work.view.OrderQaWorkView', 
	
	layout: 'fit',
	
	
	requires:[
	          'iih.mr.qa.order_qa_work.block.OrderQaWorkBlock',
	          'iih.mr.qa.process_qa_work.action.QaWorkInitAction'
	          ],
	          
	layout: {
        type : 'vbox',
        align : 'stretch'
    },
	
	xapConfig:{
		blocks: {
			'content': {
				xclass: 'iih.mr.qa.order_qa_work.block.OrderQaWorkBlock'
			}
		},
		actions:{
			'init': {
				xclass: 'iih.mr.qa.process_qa_work.action.QaWorkInitAction',
				blocks: {
					content:'content'
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
			}
			]
		}
	}
})
	