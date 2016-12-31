Ext.define('iih.sy.pwd.action.SaveNewPwdAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	requires:['iih.mr.qa.QaStatusGlobal'],

	execute: function(context) {   
    	var owner = this.getOwner();
    	var userId = IMER_GLOBAL.user.code;
		var block = this.getBlock('content');
		var form= block.getForm();
        var data = form.getValues();
//        var showInfo = block.down('xapdisplayfield');
//		//进行前台登录框验证
//		if(data.oldPwd == null || data.oldPwd == ''){
//			showInfo.setValue('<font color=red>原密码不能为空!</font>');
//			return null;
//		}else if(data.iemrPwd == null || data.iemrPwd == ''){
//			showInfo.setValue('<font color=red>新密码不能为空!</font>');
//			return null;
//		}else if(data.confirmPwd == null || data.confirmPwd ==''){
//			showInfo.setValue('<font color=red>确认密码不能为空!</font>');
//			return null;
//		}else{
			data.id = userId;
			var operations = context.operations;
	        if(!operations) {
	     		return;
		    }
	        this.prepareOperations(operations,data);
//		}
    },
    prepareOperations: function(operations,data){
        var url = this.url; 
        var mclass = null;
        var METHODS = this.getInvocationMethods();
    	var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_UPDATE,
            condition: null,	
            data:data,
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.length = 0;
    	operations.push(operation);
    },
    onSuccess: function(operation) {
    	XapMessageBox.info("保存成功");
    	var owner = this.getOwner();
    	var chain = owner.getActionChain('cancel');
    	chain.execute();
    }
});