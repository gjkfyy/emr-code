Ext.define('iih.mr.wr.mr.action.CheckUseRoleAction', {
	extend : 'Xap.ej.action.ServiceInvocation',

	/*
	 * @Override
	 */
	checkUseRoleAction:'',
	execute : function(context) {
		checkUseRoleAction=this;
		var method= context.event.arguments[0];
		checkUseRoleAction.cmdName=method;
		console.info("iih.mr.wr.mr.action.CheckUseRoleAction");
		data={"encounterPk":IMER_GLOBAL.encounterSn,"crtUserId":IMER_GLOBAL.user.code,"deptCd":IMER_GLOBAL.department.code};
		this.openPrepareOperations(context.operations,data);
	},
    openPrepareOperations: function(operations,data) {
    	var url=this.url;
    	 var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            method: METHODS.METHOD_CREATE,
            data:data,
            success: this.onSuccess,
            fail: this.onFail
        };
        operations.push(operation);
    },
    onSuccess: function(operation) {
    	var view=checkUseRoleAction.getOwner();
    	if(operation.result!=null&&operation.result.memo=="XAPM14.24"){
	    	var showLoginWin = view.getActionChain('showLoginWin');
	    		//请后验证患者申签权限
	    	showLoginWin.execute({
	    		'mastDoctorCd' :operation.result.curMojDctId,// 上级申签医师
	    		'code' : IMER_GLOBAL.user.code,// 账号角色
	    		'deptCd' : IMER_GLOBAL.department.code
	    	});
    	}else{
    		var emrSubmit1=	view.getActionChain('emrSubmit1');
        	emrSubmit1.execute({'method':checkUseRoleAction.cmdName});
    	}
    }
});
