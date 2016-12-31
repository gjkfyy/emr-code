/** 
 * 通知书缺陷列表
 * @author ：yao_lijie
 */
Ext.define('iih.mr.qa.dept_qa_auto_search.action.ToQaAutoDefectAction', {
extend: 'Xap.ej.action.Action',
	
	requires: ['iih.mr.qa.dept_qa_auto_search.view.QaAutoDefectView'],
	
	execute: function(context) {
		
		var me = this;
		
		var owner = this.getOwner();   
		
		var conditionBlock = this.getBlock('condition');
		var block = conditionBlock.getBlock('content');
    	var condition = block.getData();
    	var enStaCd = condition.enStaCd;
		
		var topBlock = this.getBlock('result');
	        
	    var enGrid = topBlock.down('xapgrid');
	     
	    var selModel = enGrid.getSelectionModel();
	        
	    var record = selModel.getSelection()[0];
	    
	    var pk = record.data.pk;
	    
	    var workScreen = iih.mr.qa.QaStatusGlobal.workScreenScoreAuto;
	    
	    var sourceView=this.getOwner();	
		
	    var event = context.event;
	    var pageCode = 'qaAutoDefectView';
	    var pageTitle = '自动质控缺陷列表';

	    var viewConfig = {
	    	patientRecord:record.data,
	    	pk: pk,
	    	enStaCd:enStaCd,
	    	workScreen:workScreen
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