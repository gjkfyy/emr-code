Ext.define('iih.sy.pwd.action.VaidatorOldPwdAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
		var owner = this.getOwner();
		var userId = IMER_GLOBAL.user.code;
		var block = this.getBlock('content');
		var oldPwd = block.down('xaptextfield[name=oldPwd]');
		var form= block.getForm();
        var data = form.getValues();
		var showInfo = block.down('xapdisplayfield');
		//进行前台登录框验证
		if(Ext.isEmpty(data.oldPwd, false)){
			showInfo.setValue('<font color=red>原密码不能为空!</font>');
			return null;
		}else{
			showInfo.setValue('');
            data.userId = userId;
        	var operations = context.operations;
    	    if(!operations) {
    	    	return;
    	    }
    		this.prepareOperations(operations,data);
		}
	},
    
    prepareOperations: function(operations,data) {
		var url = this.url + '?userId=' + data.userId +'&oldPwd='+data.oldPwd;
    	var operation = {
            url: url ,
    		mclass: null,
    		method: 'get',
    		condition: null,
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.length = 0;
    	operations.push(operation);
    },

    onSuccess: function(operation) {
    	var block = this.getBlock('content');
    	var showInfo = block.down('xapdisplayfield[name=showInfo]');
        var m = operation.result;
		if(m == '1'){ 
			showInfo.setValue('<font color=red>原密码输入错误</font>');
		}else{
			showInfo.setValue('');
		}
    }
});
