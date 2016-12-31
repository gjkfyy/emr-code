Ext.define('iih.mr.di.action.InDiagnosisSaveAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

	requires: [],

    doExecute: function(context) {
    	var owner = this.getOwner();
		var block = this.getBlock('content');
		var form= block.getForm();
		var showInfo = block.down('xapdisplayfield[name=showInfo]');
		var diCdCom = block.down('comboxgrid[name=diCd]');
		var diCd = diCdCom.getValue();  //诊断字典编码
		var diNm = diCdCom.rawValue;  //诊断字典名称
		var diTypeCdCom = block.down('xapcombobox[name=diTypeCd]');
		var diTypeNm = diTypeCdCom.rawValue; //诊断类别名称
        var enSn = IMER_GLOBAL.encounterSn; //就诊序号
        var diEmpId = IMER_GLOBAL.user.code; //登录者
        var diDeptCd = IMER_GLOBAL.department.code //登录科室
        var data = form.getValues();
        data.enSn = enSn;
        data.diEmpId = diEmpId;
        data.diDeptCd = diDeptCd;
        data.diCd = diCd;
        data.diNm = diNm;
        data.diTypeNm = diTypeNm;
        if(data.diTypeCd == ""){
    		showInfo.setValue('<font color=red>诊断类别为空</font>');
			return null;
    	}else if(data.diCd == ""){
    		showInfo.setValue('<font color=red>诊断名称为空</font>');
			return null;
    	}else if(data.diTime ==""){
    		showInfo.setValue('<font color=red>诊断日期为空</font>');
			return null;
    	}else{
    		var operations = context.operations;
            if(!operations) {
         		return;
    	    }
    	     	this.prepareOperations(operations,data);
    	}
    },

    prepareOperations: function(operations,data) {
        var url = this.url;
        var mclass = null;
        var METHODS = this.getInvocationMethods();
    	var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_CREATE,
            condition: null,	
            data:data,
    		scope: this,
    		success: this.onSuccess,
            fail: this.onFail
    	};
    	operations.length = 0;
    	operations.push(operation);
},
   
    onSuccess: function(operation){
    	var block = this.getBlock('content');
//    	block.getForm().reset(); //清空form
    	var view = this.getOwner();
    	var chain = view.getActionChain('init');
    	chain.execute({
    		flag:'1',
    	});
    	XapMessageBox.info('保存成功!');
    	var canvas = Xap.getCanvas();
    	var patient = {
    		'pk':IMER_GLOBAL.encounterSn
    	};
    	canvas.fireEvent("updatePatient",{
    		'patient':patient
    	});
    },
    
    onFail: function(operation) {
    	XapMessageBox.info('保存失败!');
    }
});
