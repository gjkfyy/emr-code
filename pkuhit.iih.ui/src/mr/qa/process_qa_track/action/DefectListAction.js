/** 
 * 查询：环节质控追踪画面---缺陷一览列表
 * @author ：cheng_feng
 */
Ext.define('iih.mr.qa.process_qa_track.action.DefectListAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	doExecute: function(context) {
			this. showLoading();
	        this.prepareOperations(context);
	 },
	 prepareOperations: function(context) {
		 var me = this;
		
	    var owner = this.getOwner();   
	    
	    var record = owner.revisionRecord;
	    
	    var revisionCd = owner.revisionCd;
	    
	    var revisionStatus = owner.revisionStatus;
	    
	    var typeFlag = owner.typeFlag;
	    
	    //储存画面间参数
	    var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        properties.setData({
        	revisionRecord:record,
    		revisionCd: revisionCd,//整改通知编码
    		revisionStatus:revisionStatus,
    		typeFlag:typeFlag
        });
	    
		var operations = context.operations;
		
        var bottomBlock = this.getBlock('result');  
        
       var event = context.event;
       
       var qaTypeCode = "";
       if(typeFlag==1){
    	   qaTypeCode = iih.mr.qa.QaStatusGlobal.qaTypeCodeProcess;
       } else if(typeFlag==2){
    	   qaTypeCode = iih.mr.qa.QaStatusGlobal.qaTypeCodeTerminal;
       } else if(typeFlag==3){
    	   qaTypeCode = iih.mr.qa.QaStatusGlobal.qaTypeCodeDept;
       }
        
        var url = this.url;
        var qs = 'revisionCd=' + revisionCd + '&qaTypeCode='+qaTypeCode;
    	var operation = {
            url: url + '?' +qs,
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
    	var revisionStatus = owner.revisionStatus;
        var block = this.getBlock('result');
        var defectBlock = block.ownerCt.getBlock('bottom');
        var defectGrid = defectBlock.down('xapgrid');
        var m = operation.result;
        for(var i=0;i<m.data.qaFaultList.dataList.length;i++){
        	m.data.qaFaultList.dataList[i].revisionStatus = revisionStatus;
        }
        defectBlock.setData(m.data.qaFaultList.dataList);
    }
});
