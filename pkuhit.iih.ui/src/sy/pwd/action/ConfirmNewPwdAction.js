Ext.define('iih.sy.pwd.action.ConfirmNewPwdAction', {
	extend: 'Xap.ej.action.Action',
	
	execute: function(context) {
		var owner = this.getOwner();
		var block = this.getBlock('content');
		var showInfo = block.down('xapdisplayfield');
		var form= block.getForm();
        var data = form.getValues();
        var iemrPassword =data.iemrPassword;
        var confirmPwd = data.confirmPwd;
        if(data.oldPwd == null || data.oldPwd == ''){
        	alert(999);
			showInfo.setValue('<font color=red>原密码不能为空123!</font>');
			return null;
		}else if(iemrPassword == null || iemrPassword == ''){
			showInfo.setValue('<font color=red>新密码不能为空!</font>');
			return null;
		}else if(data.confirmPwd == null || data.confirmPwd ==''){
			showInfo.setValue('<font color=red>确认密码不能为空!</font>');
			return null;
		}else if(confirmPwd != iemrPassword){
        	showInfo.setValue('<font color=red>确认密码与新密码不一致!</font>');
			return null;
        }else{
        	showInfo.setValue('');
        	var chain = owner.getActionChain('saveNewPwd');
        	chain.execute();
        }
	}
});
