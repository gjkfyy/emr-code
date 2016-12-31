Ext.define('iih.mr.qa.qa_divide_level.action.QaItmVaidatorAction', {
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
        var sndCd = data.sndCd;
       	var req = data.req;
        var qaDrpScrTpCd = data.qaDrpScrTpCd;
        var onceDrpScr = data.onceDrpScr;
        var deductDes = data.deductDes;
        var maxDrpScr = data.maxDrpScr;
        if(sndCd == ""){
    		showInfo.setValue('<font color=red>二级分类未设置</font>');
			return null;
    	}else if(req == ""){
    		showInfo.setValue('<font color=red>项目名称不能为空</font>');
			return null;
    	}else if(qaDrpScrTpCd == ""){
    		showInfo.setValue('<font color=red>扣分类型不能为空</font>');
			return null;
    	}else if(onceDrpScr == ""){
    		showInfo.setValue('<font color=red>单次扣分值不能为空</font>');
			return null;
    	}else if(deductDes == ""){
    		showInfo.setValue('<font color=red>扣分描述不能为空</font>');
			return null;
    	}else if(onceDrpScr<0 || onceDrpScr >100){
    		showInfo.setValue('<font color=red>分数超出范围</font>');
			return null;
    	}else if(maxDrpScr<0 || maxDrpScr >100){
    		showInfo.setValue('<font color=red>分数超出范围</font>');
			return null;
    	}else if(qaDrpScrTpCd == iih.mr.qa.QaStatusGlobal.qaDrpScrTpCdB || qaDrpScrTpCd == iih.mr.qa.QaStatusGlobal.qaDrpScrTpCdC){
    		var saveQaItmFstChain = owner.getActionChain('saveQaItm');
			saveQaItmFstChain.execute();
			showInfo.setValue('');
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
		var url = this.url + '?sndCd=' + data.sndCd +'&onceDrpScr='+data.onceDrpScr;
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
        var m = operation.result;
		if(m == '2'){
			XapMessageBox.info("单次扣分值大于二级分类分数");
			showInfo.setValue('');
		}else{
			var saveQaItmFstChain = owner.getActionChain('saveQaItm');
			saveQaItmFstChain.execute();
		}
    }
});
