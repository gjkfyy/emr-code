Ext.define('iih.mr.qa.qa_apply.action.QaApplyEditInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	requires: [],
	
	execute: function(context) {
		var owner = this.getOwner();
		var block = owner.getBlock('content');
		var sourceOwner = this.getOwner().sourceOwner;
		var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        properties.setData({
            sourceView: context.sourceView,
            btnName:context.btnName
        });
        
        var applyDesc =  block.down('xaptextarea[name=applyDesc]');
        var memo =  block.down('xaptextarea[name=memo]');
//        var sendBtn =  block.down('button[method=send]');
        if(context.btnName=='send'){
//        	sendBtn.text.innerHTML='发送申请';
	    	applyDesc.enable();
	    	memo.disable();
        }else  if(context.btnName=='pass'){
//        	sendBtn.innerHTML='通过申请';
        	applyDesc.disable();
	    	memo.enable();
        }else  if(context.btnName=='refuse'){
//        	sendBtn.text.innerHTML='驳回申请';
        	applyDesc.disable();
	    	memo.enable();
        }
        
        var operations = context.operations;
        if(!operations) {
     		return;
	    }
        if(!context.data){
	       return;
        } 
        var applyCd = context.data.data.applyCd;
        this.editOperations(operations, applyCd);
    },
    editOperations: function(operations, applyCd) {
    	//获取选择的人员的基本信息
        var url = 'mr/getapplyinfo/'+applyCd;
        var operation = {
            url: url ,
    		mclass: null,
    		method: 'get',
    		condition: null,
    		scope: this,
    		success: this.editSuccess,
            fail: this.editFail
    	};
    	operations.length = 0;
    	operations.push(operation);
    },
    
    editSuccess: function(operation) {
    	var owner = this.getOwner();
    	var sourceOwner = owner.sourceOwner;
	    var block = owner.getBlock('content');
	    var form = block.getForm();
    	//给Form赋值
	    var m = operation.result; 
    	form.setValues(m.data);
    },
    
    editFail: function(operation) {
        XapMessageBox.info('病历超时申请表初始化失败~~');
    }
});