/** 
 * 通知书缺陷列表
 * @author ：yao_lijie
 */
Ext.define('iih.mr.qa.process_qa_search.action.ToProcessQaDefectAction', {
extend: 'Xap.ej.action.Action',
	
	requires: ['iih.mr.qa.process_qa_search.view.ProcessQaDefectView'],
	
	execute: function(context) {
		
		var me = this;
		
		var owner = this.getOwner();   
		
		var topBlock = this.getBlock('result');
	        
	    var enGrid = topBlock.down('xapgrid');
	     
	    var selModel = enGrid.getSelectionModel();
	        
	    var record = selModel.getSelection()[0];
	    
	    var revisionCd = record.data.revisionCd;
	    if(revisionCd == '' || revisionCd == null){
	    	return;
	    }
	    
	    var revisionStatus = record.data.status;
	    
	    var sourceView=this.getOwner();	
		
	    var typeFlag = sourceView.typeFlag;
	       
	    var event = context.event;
	    var pageCode = 'processQaDefectSearchView';
	    var pageTitle = '缺陷列表';

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
                viewConfig:  viewConfig
            };
            var canvas = Xap.getCanvas();
            canvas.fireEvent("updatePatient",{patient:record.data});  // top患者信息刷新
            canvas.fireEvent("addWorkPage",config);
        };
    }
});