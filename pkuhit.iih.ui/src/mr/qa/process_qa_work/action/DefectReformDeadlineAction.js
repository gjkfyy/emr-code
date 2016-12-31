Ext.define('iih.mr.qa.process_qa_work.action.DefectReformDeadlineAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/** 
	 * 本次质控完成确认页面修改[整改期限]监听
	 * @extends Xap.ej.action.Action
	 * @author ：yao_lijie
	 */
	execute: function(context) {
    	var owner = this.getOwner();
    	var b = this.getBlock('result');
        var form = b.down('xapform'); 
        var executeEndTime = form.down('xapdisplayfield[name=executeEndTime]');		//质控时间
        var executeEndTimeValue = executeEndTime.value;
        var reformDeadline = form.down('xapnumberfield[name=reformDeadline]');		//整改期限
        var reformDeadlineValue = reformDeadline.value;
        var deadline = form.down('xapdisplayfield[name=deadline]');		//整改截止日期
        reformDeadline.setDisabled(false);
//		 var v = new Date(1411315200000 + reformDeadlineValue*24*60*60*1000);
		 var times = parseInt(executeEndTimeValue) + (reformDeadlineValue*24*60*60*1000);
		 var v = new Date(times);
		 var value = Ext.util.Format.date(v, 'Y-m-d H:i');
		 deadline.setValue(value);
       /*	if(submitedValue == "0"){
       		reformDeadline.setDisabled(true);
       	}else{
       		reformDeadline.setDisabled(false);
//       		 var v = new Date(1411315200000 + reformDeadlineValue*24*60*60*1000);
       		 var times = parseInt(executeEndTimeValue) + (reformDeadlineValue*24*60*60*1000);
       		 var v = new Date(times);
       		 var value = Ext.util.Format.date(v, 'Y-m-d H:i');
       		 deadline.setValue(value);
       	}*/
    }
});