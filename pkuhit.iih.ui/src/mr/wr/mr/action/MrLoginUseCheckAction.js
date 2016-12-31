Ext.define('iih.mr.wr.mr.action.MrLoginUseCheckAction', {
	extend: 'iih.mr.action.editor.EmrEditorOperatorAction',

	requires: [],
	/*
	* @Override
	*/
	execute: function(context) {
		var block =this.getOwner().getBlock('content');
		var loginNm=block.down('xaptextfield[name=loginNm]').getValue();
		var loginPwd=block.down('xaptextfield[name=loginPwd]').getValue();
		var code=this.getOwner().code;//账号
		var mastDoctorCd=this.getOwner().mastDoctorCd;
		var deptCd=this.getOwner().deptCd;
		if(!loginNm&&!loginPwd){
			Ext.Msg.alert('提示','登录名和密码不能为空');
			return;
		}
					//账号角色				上级申签医师		科室					登录密码								
		data={"id":code,"xapUserPk":mastDoctorCd,"employeeId":deptCd,"password":loginPwd,"loginName":loginNm};
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
    	var mrLoginWinView= Ext.getCmp('mrloginwinview');
    	var mrdoceditView=mrLoginWinView.mrdoceditView;
    	var emrSubmit= mrdoceditView.getActionChain('emrSubmit1');
    	if(operation.result.statusCode=="2"){
    		//上级医师账号密码不正确
    		Ext.Msg.alert('提示','登录医师不能为实习医师');
    		return;
    	}else if(operation.result.statusCode=="0"){
    		//上级医师账号密码不正确
    		Ext.Msg.alert('提示','登录名或密码不正确');
    		return;
    	}else if(operation.result.name!=null){
    		//返回上级申签医师信息
    		mrdoceditView.loginId=operation.result.id;
    		mrdoceditView.name=operation.result.name;
    		mrdoceditView.practiceDoctor='1';
    		mrdoceditView.signPicture=operation.result.signPicture;
    		emrSubmit.execute({'method':'emrSubmit'});
    		var plugin = document.getElementById('iemrEditor');
            plugin.EnableOCX(true);
    		mrLoginWinView.ownerCt.close();
    	}else{
    		//登录医师不属于当前科室
    		Ext.Msg.alert('提示','登录医师不属于当前科室');
    		return;
    	}
    	
    }
});
