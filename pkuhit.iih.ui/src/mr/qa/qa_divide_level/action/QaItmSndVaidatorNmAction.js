Ext.define('iih.mr.qa.qa_divide_level.action.QaItmSndVaidatorNmAction', {
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
			this.prepareOperations(operations,data);
    	}
	},
    
    prepareOperations: function(operations,data) {
		var url = this.url + '?nm=' + data.nm + '&fstCd=' +data.fstCd +'&score='+data.score;
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
    	var sndNm = owner.sndNm;
        var block = this.getBlock('content');
        var nm = block.down('xaptextfield[name=nm]');
        var showInfo = block.down('xapdisplayfield[name=showInfo]');
        var nmValue = nm.value;
        var m = operation.result;
		if(m == '1'){
			if(sndNm == nmValue){
				var saveQaItmFstChain = owner.getActionChain('saveQaItmSnd');
				saveQaItmFstChain.execute();
			}else{
				XapMessageBox.info("二级分类名已存在");
				showInfo.setValue('');
			}
		}else if(m == '2'){
			XapMessageBox.info("当前分数大于一级分类分数");
			showInfo.setValue('');
		}else{
			var saveQaItmFstChain = owner.getActionChain('saveQaItmSnd');
			saveQaItmFstChain.execute();
		}
    }
});
