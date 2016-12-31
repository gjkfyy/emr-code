Ext.define('iih.mr.qa.qa_divide_level.action.QaDivideLevelVaidatorNmAction', {
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
        var lvlValue = data.lvl;
        var minScr = data.minScr;
        var maxScr = data.maxScr;
        if(lvlValue == ""){
    		showInfo.setValue('<font color=red>等级不能为空</font>');
			return null;
    	}else if(minScr == "" || maxScr == ""){
    		showInfo.setValue('<font color=red>分数不能为空</font>');
			return null;
    	}else if(minScr<0 || minScr >100){
    		showInfo.setValue('<font color=red>分数超出范围</font>');
			return null;
    	}else if(maxScr<0 || maxScr >100){
    		showInfo.setValue('<font color=red>分数超出范围</font>');
			return null;
    	}else{
    		var operations = context.operations;
			if(!operations) {
				return;
			}
			this.prepareOperations(operations,lvlValue);
    	}
	},
    
    prepareOperations: function(operations,qaDivideLevelCd) {
		var url = this.url + '/' + qaDivideLevelCd;
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
        var block = this.getBlock('content');
        var showInfo = block.down('xapdisplayfield[name=showInfo]');
        var nm = block.down('xapcombobox[name=lvl]');
        var m = operation.result;
		if(m == '1'){
			XapMessageBox.info("病案等级已添加");
			showInfo.setValue('');
		}else{
			var saveQaDivideLevelChain = owner.getActionChain('saveQaDivideLevel');
			saveQaDivideLevelChain.execute();
		}
    }
});
