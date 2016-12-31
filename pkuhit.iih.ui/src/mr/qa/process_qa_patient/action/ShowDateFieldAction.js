/** 
 * 点击记录，判断按钮状态
 * @author ：yao_lijie
 */
Ext.define('iih.mr.qa.process_qa_patient.action.ShowDateFieldAction', {
	extend: 'Xap.ej.action.Action',
	
	execute: function(context) {
		var block = this.getBlock('condition');
		var beginTime = block.down('xapdatefield[name=beginTime]').rawValue;
    	var endTime = block.down('xapdatefield[name=endTime]').rawValue;
    	var changeTime = block.down('xapradiogroup[method=changeTime]')
    	if(beginTime !='' || endTime !=''){
    		changeTime.setDisabled(true);
    	}else{
    		changeTime.setDisabled(false);
    	}
	}
});
