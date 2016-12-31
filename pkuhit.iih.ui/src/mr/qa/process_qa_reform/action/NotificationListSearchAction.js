/** 
 * 整改通知单一览列表（环节、终末整改）
 * @author ：yao_lijie
 */
Ext.define('iih.mr.qa.process_qa_reform.action.NotificationListSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	doExecute: function(context) {
		this.showLoading();
	    this.prepareOperations(context);
	        
	 },
	 prepareOperations: function(context) {
		var operations = context.operations;
		var sourceView=this.getOwner();	
		var typeFlag = sourceView.typeFlag; 
		var url = this.url;
		var qaTypeCode = "";
		var workScreen = "";
		if(typeFlag==1){
			workScreen = iih.mr.qa.QaStatusGlobal.workScreenReformProcess;
			qaTypeCode = iih.mr.qa.QaStatusGlobal.qaTypeCodeProcess;
		} else if(typeFlag==2){
			workScreen = iih.mr.qa.QaStatusGlobal.workScreenReformTerminal;
			qaTypeCode = iih.mr.qa.QaStatusGlobal.qaTypeCodeTerminal;
		}else if(typeFlag==3){
			workScreen = iih.mr.qa.QaStatusGlobal.workScreenReformDept;
			qaTypeCode = iih.mr.qa.QaStatusGlobal.qaTypeCodeDept;
		}else if(typeFlag==4){
			workScreen = iih.mr.qa.QaStatusGlobal.workScreenReformOrder;
			qaTypeCode = iih.mr.qa.QaStatusGlobal.qaTypeCodeOrder;
		}
		
		url += "?workScreen=" + workScreen + "&qaTypeCode=" + qaTypeCode;
		
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
    	var block = this.getBlock('content');
        var m = operation.result.dataList;
        // TODO 数据格式就这样了？
        if(m instanceof Ext.data.Model) {
            block.setData({
                mclass: operation.mclass,
                data: m.getData(true)
            });
        }
        else {
        	block.setData(m);
        	console.log(m);
        }
        //点击消息链接到通知单
        var grid = block.down('xapgrid');
    	var revisionCd = this.getOwner().revisionCd;
    	if(revisionCd){
	        grid.selectById(revisionCd);
	        grid.nodeId = revisionCd;
	        var stertRfmChain = this.getOwner().getActionChain("stertRfm");
			stertRfmChain.execute({});
			this.getOwner().revisionCd = null;
    	}
    }
});
