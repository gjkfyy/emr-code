Ext.define('iih.mr.dr.plan.action.ToConditionAction', {
extend: 'Xap.ej.action.Action',
	
	requires: ['iih.mr.dr.condition_set.view.ConditionView'],
	
	execute: function(context) {
		var me = this;
		var owner = this.getOwner();   
	    var event = context.event;
	    var pageCode ="conditionInitView";//plugin里设置的
	    var pageTitle="方案设置";
		
		var gridBlock = this.getBlock('result');
	    var enGrid = gridBlock.down('xapgrid');
	    var selModel = enGrid.getSelectionModel();
	    var record = selModel.getSelection()[0];
	    if(record!=undefined && record!=null){
		    var retrievalCd = record.data.retrievalCd;
		    
		    var viewConfig = {
		    	sourceView:owner,
		    	retrievalRecord:record,
		    	retrievalCd: retrievalCd
		    }
	        if(event) {
	            var config = {
	            	pageCode: pageCode,
	            	pageTitle: pageTitle,
	                xclass: 'iih.mr.dr.condition_set.view.ConditionView',
	                viewConfig:  viewConfig
	            };
	            var canvas = Xap.getCanvas();
	            canvas.fireEvent("addWorkPage",config);
	        };
	    }else{
			XapMessageBox.info('请选择检索方案！');
		}
	}
});