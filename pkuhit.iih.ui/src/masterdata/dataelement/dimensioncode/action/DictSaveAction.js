Ext.define('iih.masterdata.dataelement.dimensioncode.action.DictSaveAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	execute: function(context) {    
    	var owner = this.getOwner();
    	var recordData = owner.getLayer(Xap.ej.block.Layer.PROPERTIES).data;
    	var customerData = recordData.customerData;
		var block = owner.getBlock('content');
		var form= block.getForm();
        var data = form.getValues();

    	var operations = context.operations;
        if(!operations) {
     		return;
	    }
	    if(customerData=='new'){
		    this.addOperations(operations,data);
		}else if(customerData=='edit'){
			var pkDictgeneral = recordData.data[0].data.dataElementCd;
			this.editOperations(operations, data, pkDictgeneral);
		}
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
    	var sourceOwner = owner.sourceOwner;
    	//提示保存成功
    	XapMessageBox.info('保存成功');
    	
    	//调用查询Action，刷新列表
    	var searchChain = sourceOwner.getActionChain('init');
    	searchChain.execute();
    	
        owner.ownerCt.close();//关闭保存页面
    },
    
    addFail:function(operation){
    	XapMessageBox.info('保存失败');
    },
    
    //修改
    editOperations: function(operations,data, pkDictgeneral) {
        var url = 'md/mr/Dimen/code/'+pkDictgeneral;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_UPDATE,
            condition: null,
            data:data,
            scope: this,
            success: this.editSuccess,
            fail: this.editFail
        };
        operations.push(operation);
    },
    
    editSuccess: function() {
    	var owner = this.getOwner();
    	var sourceOwner = owner.sourceOwner;
    	//提示保存成功
    	XapMessageBox.info('修改成功');
    	
    	//调用查询Action，刷新列表
    	var searchChain = sourceOwner.getActionChain('init');
    	searchChain.execute();
    	
        owner.ownerCt.close();//关闭保存页面
    },
    
    editFail: function(operation) {
        XapMessageBox.info('修改失败');
    }
});