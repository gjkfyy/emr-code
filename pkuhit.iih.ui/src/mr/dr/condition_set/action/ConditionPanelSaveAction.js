Ext.define('iih.mr.dr.condition_set.action.ConditionPanelSaveAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	execute: function(context) {
		var owner = this.getOwner();
		var block = owner.getBlock('condition').getBlock('right');
		var form= block.getForm();
        var data = form.getValues();
	    var retrievalCd = owner.retrievalCd;
	    data.retrievalCd = retrievalCd;
	    
	    if(data.elemPath==undefined || Ext.isEmpty(data.elemPath,false)){
			XapMessageBox.info('请点击【条件设置】按钮设置条件！');
			return;
		}
	    if(data.relationType==undefined || Ext.isEmpty(data.relationType,false)){
			XapMessageBox.info('请选择关联类型！');
			return;
		}
		if(data.conditionName==undefined || Ext.isEmpty(data.conditionName,false)){
			XapMessageBox.info('请输入条件名称！');
			return;
		}
	    if(data.constraintObject==undefined || Ext.isEmpty(data.constraintObject,false)){
			XapMessageBox.info('请选择约束对象！');
			return;
		}
		if(data.logicSymbolCode==undefined || Ext.isEmpty(data.logicSymbolCode,false)){
			XapMessageBox.info('请选择逻辑关系！');
			return;
		}
		if(data.constraintDomain==undefined || Ext.isEmpty(data.constraintDomain,false)){
			XapMessageBox.info('请输入约束值域！');
			return;
		}
		if(data.conditionType==undefined || Ext.isEmpty(data.conditionType,false)){
			XapMessageBox.info('请选择条件类型！');
			return;
		}
	    
    	var operations = context.operations;
        if(!operations) {
     		return;
	    }
	    this.addOperations(operations,data);
	},
    
    addOperations: function(operations,data){
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
    		success: this.addSuccess,
    		failure: this.addFail
    	};
    	operations.push(operation);
    },
    
    addSuccess: function(operation) {
    	var owner = this.getOwner();
    	//提示保存成功
    	XapMessageBox.info('保存成功');
    	
    	//调用刷新树Action，刷新条件树
    	var initChain = owner.getActionChain('init');
    	initChain.execute();
    	
    	//调用ResetAction，清空设置条件
    	var resetChain = owner.getActionChain('reset');
    	resetChain.execute();
    	
    },
    
    addFail:function(operation){
    	XapMessageBox.info('保存失败');
    }
});