Ext.define('iih.sy.pwd.action.VaidatorIemrPwdAction', {
	extend: 'Xap.ej.action.Action',
	
	execute: function(context) {
		var owner = this.getOwner();
		var block = this.getBlock('content');
		var showInfo = block.down('xapdisplayfield');
		var form= block.getForm();
        var data = form.getValues();
        var iemrPassword =data.iemrPassword;
        if(iemrPassword.length <4 || iemrPassword.length >10){
        	showInfo.setValue('<font color=red>只允许输入4到10位</font>');
        }else{
//        	if(showInfo.getValue() == '<font color=red>只允许输入4到10位</font>'){
        		showInfo.setValue('');
//        	}
        }
	}
});
