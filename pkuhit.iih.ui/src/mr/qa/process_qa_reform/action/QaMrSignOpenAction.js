/** 
 * 打开病历文书(可编辑/只读)
 * @author ：yao_lijie
 */
Ext.define('iih.mr.qa.process_qa_reform.action.QaMrSignOpenAction', {
    extend: 'Xap.ej.action.Action',

    execute: function(context) {
    	var owner = this.getOwner();
    	var topBlock = this.getBlock('top');
	    var bottomBlock = this.getBlock('bottom');
	    var defectGrid = bottomBlock.down('xapgrid');
		var rfmBtn = bottomBlock.down('xapgrid xapbutton[action=rfm]');    //整改按钮
		var finishRfmBtn = bottomBlock.down('xapgrid xapbutton[action=finishRfm]');    //本次质控完成确认
		var selModel = defectGrid.getSelectionModel();
	    var record = selModel.getSelection()[0];
	    var fltStaCd = record.data.fltStaCd;
	    var mrPk = record.data.mrPk;
	    topBlock.mrPk = mrPk;
	    topBlock.sbmtTime = record.data.sbmtTime;
	    topBlock.qaFltPk = record.data.qaFltPk;
        var page = this.getOwner();
        var operations = context.operations;
        if(mrPk!=undefined && mrPk !=""){
        	if(finishRfmBtn.disabled == false){
        		if(fltStaCd == iih.mr.qa.QaStatusGlobal.faultToReform ){
					var config = {
	                xclass: 'iih.mr.wr.mr.view.MrDocQaEditView',
	                viewConfig:{
	                    mrSn:mrPk,
	                    opType:'reform'
	                	},
	                assistantConfig:{
	                	 tgtObCd: 'MRB02',
	                     tgtObPk: mrPk
	                	}
	            	};  
				}else{
					var config = {
	                xclass: 'iih.mr.wr.mr.view.MrDocEditView',
	                viewConfig:{
	                    mrSn:mrPk,
	                    opType:'readonly'
	                	}
	            	};  
				}
        	}else{
        		var config = {
	                xclass: 'iih.mr.wr.mr.view.MrDocEditView',
	                viewConfig:{
	                    mrSn:mrPk,
	                    opType:'readonly'
	                	}
	            	};  
        	}
        	var workContent = page.getBlock('top');
            var workView =  Ext.create(config.xclass,config.viewConfig);
            workContent.removeAll();
            workContent.add(workView);
         	/*var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
         	properties.setData({
            	workView:workView
        });*/
        }
    }
});
