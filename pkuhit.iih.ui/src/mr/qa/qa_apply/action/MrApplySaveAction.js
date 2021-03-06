Ext.define('iih.mr.qa.qa_apply.action.MrApplySaveAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	execute: function(context) {    
    	var owner = this.getOwner();
		var block = owner.getBlock('content');
		var form= block.getForm();
        var data = form.getValues();

    	var operations = context.operations;
        if(!operations) {
     		return;
	    }
        var applyCd = data.applyCd;
        
    	var recordData = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
    	var btnName = recordData.data.btnName;
    	
		this.editOperations(operations, data, applyCd, btnName);
    },
    
    //修改
    editOperations: function(operations, data, applyCd, btnName) {
    	var url ;
    	if(btnName == "refuse"){
    		url = 'mr/editapplyrefuse/'+applyCd;
    	}else if(btnName == "pass"){
    		url = 'mr/editapplypass/'+applyCd;
    	}else{
    		url = 'mr/editapply/'+applyCd;
    	}
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
//    	XapMessageBox.info('病历超时申请成功发送~');
    	
    	//调用查询Action，刷新列表
    	var searchChain = sourceOwner.getActionChain('init');
    	searchChain.execute();
    	
        owner.ownerCt.close();//关闭保存页面
    },
    
    editFail: function(operation) {
//        XapMessageBox.info('病历超时申请发送失败~');
    }
});