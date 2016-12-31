
/** 
 * 质控工作画面BLOCK 集成病历树和编辑器及缺陷一览
 * @extends Xap.ej.block.Block
 * @author ：wang_yanli
 */

Ext.define('iih.mr.qa.qa_work_assistant.block.QaWorkHelperBlock',{
	extend : 'Xap.ej.block.Block',
	
	alias:'widget.qaworkhelperblock',  
	
	requires:[
	          'iih.mr.qa.process_qa_work.view.DefectInAndMrEditView',
	          'iih.mr.qa.process_qa_work.view.DefectInAndMrEditAndHelperView',
	          'iih.mr.qa.process_qa_work.block.MrInBlock'
	         ],
	layout: 'border',
	 
	items:[{
		
		region:'west',
        xtype: 'mrinblock',
        width: 200,
        padding:'0 2 0 0'
       // split: true,
       // collapsible: true
       
//        region:'west',
//        xtype: 'mrinblock',
//        header: false,
//        split: true,
//        collapsible: true,
//        width: 200
	},{
		region: 'center',
	    xtype: 'defectinandmreditandhelperview'
	}]
	
})