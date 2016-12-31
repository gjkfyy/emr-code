
/** 
 * 质控工作画面BLOCK 集成医嘱列表及缺陷一览
 * @extends Xap.ej.block.Block
 * @author ：wang_yanli
 */

Ext.define('iih.mr.qa.order_qa_work.block.OrderQaWorkBlock',{
	extend : 'Xap.ej.block.Block',
	
	alias:'widget.orderqaworkblock',  
	
	requires:[
	          'iih.mr.qa.order_qa_work.view.DefectInAndOrderView'
	         ],
	layout: 'fit',
	 
	items:[{
	    xtype: 'defectinandorderview'
	}]
	
})