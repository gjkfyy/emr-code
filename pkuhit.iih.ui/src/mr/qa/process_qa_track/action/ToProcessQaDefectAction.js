/** 
 * 初始化环节质控追踪画面，缺陷列表
 * @author ：cheng_feng
 */
Ext.define('iih.mr.qa.process_qa_track.action.ToProcessQaDefectAction', {
extend: 'Xap.ej.action.Action',
	
	requires: ['iih.mr.qa.process_qa_track.view.ProcessQaDefectView'],
	
	execute: function(context) {
		
		var me = this;
		
		var owner = this.getOwner();   
		
		var topBlock = this.getBlock('result');
	        
	    var enGrid = topBlock.down('xapgrid');
	     
	    var selModel = enGrid.getSelectionModel();
	        
	    var record = selModel.getSelection()[0];
	    
	    var revisionCd = record.data.revisionCd;
	    
	    record.data.pk = record.data.encounterNo;
	    
	    var revisionStatus = record.data.status;
	    
	    var sourceView=this.getOwner();	
		
	    var typeFlag = sourceView.typeFlag;
	       
	    var event = context.event;
	    var pageCode ;
	    var pageTitle;
	    if(typeFlag==1){
	    	pageTitle = '环节质控追踪工作画面';
	    	pageCode = "processQaDefectView";
	    }else if(typeFlag==2){
	    	pageCode = "terminalQaDefectView";
	    	pageTitle = '终末质控追踪工作画面';
	    }else if(typeFlag==3){
	    	pageCode = "departmentQaDefectView";
	    	pageTitle = '科室质控追踪工作画面';
	    }

	    var viewConfig = {
	    	revisionRecord:record,
	    	revisionCd: revisionCd,
	    	revisionStatus:revisionStatus,
	    	typeFlag:typeFlag
	    }
        if(event) {
            var config = {
            	pageCode: pageCode,
            	pageTitle: pageTitle,
                xclass: 'iih.mr.qa.process_qa_track.view.ProcessQaDefectView',
                viewConfig:  viewConfig
            };
            var canvas = Xap.getCanvas();
            canvas.fireEvent("updatePatient",{patient:record.data});  // top患者信息刷新
            canvas.fireEvent("addWorkPage",config);
        };
    }
});