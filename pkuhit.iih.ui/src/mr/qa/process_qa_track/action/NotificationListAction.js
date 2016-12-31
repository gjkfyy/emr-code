/** 
 * 查询环节质控-整改通知单一览列表
 * @author ：cheng_feng
 */
Ext.define('iih.mr.qa.process_qa_track.action.NotificationListAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

	doExecute: function(context) {
		this. showLoading();
	    this.prepareOperations(context);
	 },
	 prepareOperations: function(context) {
	 	
		var operations = context.operations;
		
        var contentBlock = this.getBlock('result');
        
        var notificationGrid = contentBlock.down('xapgrid');
        
        // 开始审核按钮
         var inQaWork = contentBlock.down('xapgrid xapbutton[action=inQaWork]');
        
        // 设置按钮可用
        inQaWork.setDisabled(true);
        
        var sourceView=this.getOwner();	
		
		var typeFlag = sourceView.typeFlag;
		
		var qaTypeCode = "";
		if(typeFlag==1){
			qaTypeCode = iih.mr.qa.QaStatusGlobal.qaTypeCodeProcess;
			notificationGrid.setTitle('环节整改通知');
		} else if(typeFlag==2){
			qaTypeCode = iih.mr.qa.QaStatusGlobal.qaTypeCodeTerminal;
			notificationGrid.setTitle('终末整改通知');
		} else if(typeFlag==3){
			qaTypeCode = iih.mr.qa.QaStatusGlobal.qaTypeCodeDept;
			notificationGrid.setTitle('科室整改通知');
		}
		
        var isVerifiedBox = contentBlock.down('xapgrid xapcheckbox');
        
        var verifiedChecked = isVerifiedBox.checked;
        
        var verifiedDeadline = 0;
        
        if(verifiedChecked){
        	verifiedDeadline = iih.mr.qa.QaStatusGlobal.verifiedDeadline;
        }

        var url = this.url;
        url+= '?workScreen='+iih.mr.qa.QaStatusGlobal.workScreenTrack+'&qaTypeCode='+qaTypeCode+'&verifiedDeadline='+verifiedDeadline;
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
        var block = this.getBlock('result');
        var m = operation.result.dataList;
        if(m==null){
        	block.setData([]);
        }else{
        	block.setData(m);
        }
    }
});
