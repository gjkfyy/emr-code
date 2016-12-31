/** 
 * 完成本次整改前判断整改通知书下的缺陷状态
 * @author ：yao_lijie
 */
Ext.define('iih.mr.qa.process_qa_reform.action.DefectStatusJudgeAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	doExecute: function(context) {
	        this.prepareOperations(context);
	 },
	 prepareOperations: function(context) {
		var me = this;
	    var owner = this.getOwner();   
	    var revisionCd = owner.revisionCd;
	    var typeFlag = owner.typeFlag

		var operations = context.operations;
		var workScreen = "";
		if(typeFlag==1){
			workScreen = iih.mr.qa.QaStatusGlobal.workScreenReformProcess;
		}else if(typeFlag==2){
			workScreen = iih.mr.qa.QaStatusGlobal.workScreenReformTerminal;
		}else if(typeFlag==3){
			workScreen = iih.mr.qa.QaStatusGlobal.workScreenReformDept;
		}
        var url = this.url;
        url += '?' + 'revisionCd=' + revisionCd + '&workScreen='+ workScreen;
        console.log(url);
    	var operation = {
            url: url,
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
    	var me = this;
	    var owner = this.getOwner();   
	    var revisionCd = owner.revisionCd;
    	//储存画面间参数
	    var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        properties.setData({
        	revisionCd:revisionCd  //整改通知编码
        });
        var m = operation.result;
        if(m=="2"){
			 XapMessageBox.info("存在待整改的缺陷");
        }else{
        	//完成本次整改
        	var chain = this.getBlock('bottom').ownerCt.getActionChain('finishRfm');
        	if(chain) {
            	chain.execute({
    	        	rownum:0,
            		revisionCd: revisionCd
            	});
        	}
        }
    	
    }
});
