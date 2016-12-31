Ext.define('iih.mr.qa.qa_divide_level.action.QaItmFstVaidatorNmAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
		var owner = this.getOwner();
		var block = this.getBlock('content');
		var showInfo = block.down('xapdisplayfield[name=showInfo]');
		var form= block.getForm();
        var data = form.getValues();
        var nmValue = data.nm;
        var score = data.score;
        if(nmValue == ""){
    		showInfo.setValue('<font color=red>名称不能为空</font>');
			return null;
    	}else if(score == ""){
    		showInfo.setValue('<font color=red>分数不能为空</font>');
			return null;
    	}else if(score<1 || score >100){
    		showInfo.setValue('<font color=red>分数超出范围</font>');
			return null;
    	}else{
    		var operations = context.operations;
	    	if(!operations) {
	    		return;
	    	}
			this.prepareOperations(operations,nmValue);
    	}
	},
    
    prepareOperations: function(operations,nmValue) {
		var url = this.url + '/' + nmValue;
    	var operation = {
            url: url ,
    		mclass: null,
    		method: 'get',
    		condition: null,
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.length = 0;
    	operations.push(operation);
    },

    onSuccess: function(operation) {
    	var owner = this.getOwner();
    	var fstNm = owner.fstNm;
        var block = this.getBlock('content');
        var showInfo = block.down('xapdisplayfield[name=showInfo]');
        var nm = block.down('xaptextfield[name=nm]');
        var nmValue = nm.value;
        var m = operation.result;
		if(m == '1'){
			if(fstNm != nmValue){
				XapMessageBox.info("一级分类名已存在");
				showInfo.setValue('');
			}else{
				var saveQaItmFstChain = owner.getActionChain('saveQaItmFst');
				saveQaItmFstChain.execute();
			}
		}else{
			var saveQaItmFstChain = owner.getActionChain('saveQaItmFst');
			saveQaItmFstChain.execute();
		}
    }
});
