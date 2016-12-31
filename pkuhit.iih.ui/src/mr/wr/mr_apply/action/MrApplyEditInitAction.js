Ext.define('iih.mr.wr.mr_apply.action.MrApplyEditInitAction', {
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
        var enPk =  block.down('xaptextfield[name=enPk]');
        if(context.btnName=='add'){
	    	enPk.enable();
	    	applyDesc.enable();
	    	memo.disable();
        }else if (context.btnName=='send') {
        	applyDesc.enable();
	    	enPk.disable();
	    	memo.disable();
        }else{
        	applyDesc.disable();
	    	enPk.disable();
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
        
        if (context.btnName!='add') {
	    	this.editOperations(operations, applyCd);
        }
        
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