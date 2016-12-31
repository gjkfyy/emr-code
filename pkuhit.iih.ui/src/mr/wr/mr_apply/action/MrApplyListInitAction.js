Ext.define('iih.mr.wr.mr_apply.action.MrApplyListInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	doExecute: function(context) {
		this. showLoading();
//		var curDeptNm = context.curDeptNm;
//		var crtUserNm = context.crtUserNm;
		var owner = this.getOwner();
        var block = owner.getBlock('top');
    	var condition = block.getData();
    	var timeStart = condition.timeStart;
    	var timeEnd = condition.timeEnd;
    	if(timeEnd != "" && timeStart != ""){
    		if(timeEnd < timeStart){
				 XapMessageBox.info("开始日期大于结束日期，请重新选择！");
	    		return null;
    		}
    	}
    	if(timeEnd != "" && timeStart == ""){
			 XapMessageBox.info("申请开始时间不能为空！");
    		return null;
    	}
    	if(timeEnd == "" && timeStart != ""){
			 XapMessageBox.info("申请结束时间不能为空！");
    		return null;
    	}
    	
    	var bottomBlock = owner.getBlock('bottom');
    	var addApplyBtn =  bottomBlock.down('button[method=addApply]');
    	var roleFlag = owner.roleFlag; 
    	if(roleFlag == '1'){
    		addApplyBtn.show();
    	}else{
    		addApplyBtn.hide();
    	}
    	
		var pageNum, pageSize;
		if(context.event == undefined){
			pageNum = context.pageNum; 
			pageSize = context.pageSize; 
		}else{
			pageNum = context.event.arguments[0]; 
			pageSize = context.event.arguments[1]; 
		}
		var block = this.getBlock('bottom');
		block.pageSize = pageSize;
		var data = {
			pageNum : pageNum,
			pageSize : pageSize
		}
		
		var owner = this.getOwner();
        var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        properties.setData({
            pageSize:pageSize,
            pageNum:pageNum
        });
    	var operations = context.operations;
    	if(!operations) {
    		return;
    	}
        this.prepareOperations(operations, data);
	 },
	 
	 prepareOperations: function(operations, data) {
		 var me = this;
	     var owner = this.getOwner();   
		 var roleFlag = owner.roleFlag; 
		 var applyType = owner.applyType;
         var bottomBlock = owner.getBlock('top');
         var condition = bottomBlock.getData();
         var url = this.url;
         url += '?roleFlag=' + roleFlag +'&applyType='+applyType;
         if(condition) {
             var qs = Ext.Object.toQueryString(condition);
              url += '&' + qs;
         }
//         var qs = 'revisionCd=' + revisionCd + '&qaTypeCode='+qaTypeCode;
         if(data.pageSize != undefined && typeof(data.pageSize)!='object'){
 			url += "&pageNum="+data. pageNum +"&pageSize="+data.pageSize;
 		 }
         
       	 var operation = {
            url: url , //+ '?' +qs,
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
        var block = this.getBlock('bottom');
        var m = operation.result; 
        var pageSize = block.pageSize;
        m.pageSize = pageSize;
        if(m.total>0) {
        	block.setData(m);
        }else {
        	block.setData([]);
        }
    }
});
