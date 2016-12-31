Ext.define('iih.mr.qa.process_qa_work.action.DefectEditInitAction', {
	extend: 'Xap.ej.action.Action',
	
	requires: [],
	
	execute: function(context) {
		var data = context.data;
    	var block = this.getBlock('content');
    	var textarea = block.down('xaptextarea');
    	block.setData(data);
    	textarea.focus();
    	
    }
});