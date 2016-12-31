/** 
 * 通知书缺陷列表
 * @author ：yao_lijie
 */
Ext.define('iih.mr.qa.qa_divide_level.action.ToQaAutoConfig', {
extend: 'Xap.ej.action.Action',
	
	requires: ['iih.mr.qa.qa_divide_level.view.QaAutoConfigView'],
	
	execute: function(context) {
		var me = this;
		var owner = this.getOwner();   
		var contentBlock = this.getBlock('content');
	    var itmGrid = contentBlock.down('xapgrid');
	    var selModel = itmGrid.getSelectionModel();
	    var record = selModel.getSelection()[0];
	    var qaItmData = record.data;
	    var autoQaF = qaItmData.autoQaF;
	    if(autoQaF == 0){
	    	return;
	    }
	    //var qaItmCd = qaItmData.qaItmCd;
	    var qaItmCd ,isMrConfig,mrTypeCcatId;
	    if(owner.tabId=='XAPM07.86'){
	    	qaItmCd = qaItmData.code; //病历文书规则设定
	    	isMrConfig = true;
	    	mrTypeCcatId=contentBlock.mrTypeCcatId;
	    }else{
	    	qaItmCd = qaItmData.qaItmCd;
	    	isMrConfig = false;
	    }
	    var pageTitle = '自动质控项配置';
	    var	pageCode = "qaAutoConfigView";
	    var viewConfig = {
	    	qaItmData:qaItmData,
	    	qaItmCd:qaItmCd,
	    	isMrConfig:isMrConfig,
	    	mrTypeCcatId:mrTypeCcatId,
	    	sourceView:owner
	    }
        if(event) {
            var config = {
            	pageCode: pageCode,
            	pageTitle: pageTitle,
                viewConfig:  viewConfig
            };
            var canvas = Xap.getCanvas();
            canvas.fireEvent("addWorkPage",config);
        };
    }
});