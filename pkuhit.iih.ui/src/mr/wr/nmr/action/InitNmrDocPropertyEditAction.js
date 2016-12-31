Ext.define('iih.mr.wr.nmr.action.InitNmrDocPropertyEditAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
		this.getOwner().mrPk=context.mrSn;
		this.getOwner().mrDocListView=context.mrDocListView;
		this.getOwner().mrDocEditView=context.mrDocEditView;
        this.initMrDocProperty(context.operations,context.mrSn);
    },
    initMrDocProperty: function(operations,mrSn) {
        var url = 'nmr/'+mrSn+'?withFile=false';
        var operation = {
                url: url,
                method: 'get',
                scope: this,
                success: this.onSearchSuccess
        };
        operations.push(operation);
    },
    onSearchSuccess: function(operation) {
    	var owner=this.getOwner();
    	this.getOwner().mr=operation.result.data;
    	var mr=this.getOwner().mr;
        var block = this.getOwner().getBlock('content');
        var confimUpPro=block.down('[name=confimUpPro]');
        var cancel=block.down('[name=cancel]');
        var close=block.down('[name=close]');
        if(!('MRM04.01'==mr.statusCode&&mr.canEdit==1)){
        	close.setVisible(true);
        }else{
        	confimUpPro.setVisible(true);
        	cancel.setVisible(true);
        }
        var mrType=block.down('[name=mrType]');
        mrType.setValue(mr.typeName);
        mrType.setDisabled(true);
        var bizTime=block.down('[name=logicSmtDate]');
        bizTime.setValue(mr.bizTime);
        bizTime.setDisabled(true);
        var createUserName=block.down('[name=createUserName]');
        createUserName.setValue(mr.createUserName);
        createUserName.setDisabled(true);
        var templeName=block.down('[name=templeName]');
        templeName.setValue(mr.templeName);
        var a=document.getElementById('temp');
        a.onclick = function showmsg(){ 
        	var templateProperty=owner.getActionChain('templateProperty');
        	templateProperty.execute();
        }; 
        var createTime=block.down('[name=createTime]');
        createTime.setValue(mr.crtTime);
        createTime.setDisabled(true);
        var mrNm=block.down('[name=mrNm]');
        mrNm.setDisabled(true);
        mrNm.setValue(mr.name);
        var statusName=block.down('[name=statusName]');
        statusName.setValue(mr.statusName);
        statusName.setDisabled(true);
//        var qaStatusName=block.down('[name=qaStatusName]');
//        qaStatusName.setValue(mr.qaStatusName);
//        qaStatusName.setDisabled(true);
        var completedFlag=block.down('[name=completedFlag]');
        completedFlag.setValue(mr.completedFlag==1?'已完成':'未完成');
        completedFlag.setDisabled(true);
        var signLevelName=block.down('[name=signLevelName]');
        signLevelName.setValue(mr.signLevelName);
        signLevelName.setDisabled(true);
        var submitName=block.down('[name=submitName]');
        submitName.setValue(mr.submitName);
        submitName.setDisabled(true);
        var submitDate=block.down('[name=submitDate]');
        submitDate.setValue(mr.submitDate);
        submitDate.setDisabled(true);
        var logicSubmitTime=block.down('[name=logicSubmitTime]');
        logicSubmitTime.setValue(mr.submitDate);
        logicSubmitTime.setDisabled(true);
        var deptName=block.down('[name=deptName]');
        deptName.setValue(IMER_GLOBAL.department.name);//mr.deptName);
        deptName.setDisabled(true);
        var dirDoctorDate=block.down('[name=dirDoctorDate]');
        dirDoctorDate.setValue(mr.dirDoctorDate);
        dirDoctorDate.setDisabled(true);
        var lastUpdateUserName=block.down('[name=lastUpdateUserName]');
        lastUpdateUserName.setValue(mr.lastUpdateUserName);
        lastUpdateUserName.setDisabled(true);
        var lastUpdateTime=block.down('[name=lastUpdateTime]');
        lastUpdateTime.setValue(mr.lastUpdateTime);
        lastUpdateTime.setDisabled(true);
        var mastDoctorDate=block.down('[name=mastDoctorDate]');
        mastDoctorDate.setValue(mr.mastDoctorDate);
        mastDoctorDate.setDisabled(true);
        if('MRM04.01'==mr.statusCode&&mr.canEdit==1){
        	mrNm.setDisabled(false);
        	bizTime.setDisabled(false);
        }
    }
});
