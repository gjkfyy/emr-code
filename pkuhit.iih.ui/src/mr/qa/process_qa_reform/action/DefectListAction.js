/** 
 * 查询：环节质控追踪画面---缺陷一览列表
 * @author ：cheng_feng
 */
Ext.define('iih.mr.qa.process_qa_reform.action.DefectListAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	doExecute: function(context) {
		this.showLoading();
		var owner = this.getOwner(); 
		var bottom = this.getBlock('bottom');
		var reformback = bottom.down('xapactioncolumn[name=reformback]');
		var reform = bottom.down('xapactioncolumn[name=reform]');
		if(owner.tabId == 'orderRfmdefectview'){
			reformback.hidden = true;
			reform.hidden = false;
		}else{
			reformback.hidden = false;
			reform.hidden = true;
		}		
		var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
         	properties.setData({
            	rfmNotificationView:owner.rfmNotificationView
        });
	        this.prepareOperations(context);
	 },
	prepareOperations: function(context) {
		var me = this;
		var topBlock = this.getBlock('top');
	    var bottomBlock = this.getBlock('bottom');
	    var defectGrid = bottomBlock.down('xapgrid');
//		var rfmBtn = bottomBlock.down('xapgrid xapbutton[action=rfm]');    //整改按钮
		var finishRfmBtn = bottomBlock.down('xapgrid xapbutton[action=finishRfm]');    //本次质控完成确认
		var owner = this.getOwner(); 
		var typeFlag = owner.typeFlag; 
	    var revisionCd = owner.revisionCd;
	    var revisionStatus = owner.revisionStatus;
	    if(revisionStatus == iih.mr.qa.QaStatusGlobal.revisionNoticeReformed || revisionStatus == iih.mr.qa.QaStatusGlobal.revisionNoticeVerified){
//			rfmBtn.setDisabled(true);
			finishRfmBtn.setDisabled(true);
		}else{
//			rfmBtn.setDisabled(false);
			finishRfmBtn.setDisabled(false);
		}
	    
	 	//储存画面间参数
	    var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        properties.setData({
        	revisionCd : revisionCd,  //整改通知编码
        	typeFlag : typeFlag
        });
	 	
		var operations = context.operations;
        
		var url = this.url;
		var qaTypeCode = "";
		var workScreen = "";
		if(typeFlag==1){
			workScreen = iih.mr.qa.QaStatusGlobal.workScreenReformProcess;
			qaTypeCode = iih.mr.qa.QaStatusGlobal.qaTypeCodeProcess;
		}else if(typeFlag==2){
			workScreen = iih.mr.qa.QaStatusGlobal.workScreenReformTerminal;
			qaTypeCode = iih.mr.qa.QaStatusGlobal.qaTypeCodeTerminal;
		}else if(typeFlag==3){
			workScreen = iih.mr.qa.QaStatusGlobal.workScreenReformDept;
			qaTypeCode = iih.mr.qa.QaStatusGlobal.qaTypeCodeDept;
		}else if(typeFlag==4){
	    	   qaTypeCode = iih.mr.qa.QaStatusGlobal.qaTypeCodeOrder;
	    }

        url += '?' + 'revisionCd=' + revisionCd + '&workScreen='+ workScreen + "&qaTypeCode=" + qaTypeCode;
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
        var defectBlock = this.getBlock('bottom');
        var defectGrid = defectBlock.down('xapgrid');
        var m = operation.result;
        defectBlock.setData(m.data.qaFaultList.dataList);
    }
});
