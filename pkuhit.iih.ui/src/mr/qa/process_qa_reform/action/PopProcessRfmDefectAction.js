/** 
 * 环节整改通知开始整改
 * @author ：yao_lijie
 */
Ext.define('iih.mr.qa.process_qa_reform.action.PopProcessRfmDefectAction', {
extend: 'Xap.ej.action.Action',
	
	requires: ['iih.mr.qa.process_qa_reform.view.ProcessRfmDefectView',
	           'iih.mr.qa.order_qa_reform.view.OrderRfmDefectView'],
	
	execute: function(context) {
	    var revisionCd = context.revisionCd;
	    var revisionStatus = context.revisionStatus;
	    var record = context.record;
	    //为了top页显示患者信息，将后台模板enPk的值赋给pk
	    var data = record.data;
	   	data.pk = data.enPk;
	    var sourceView=this.getOwner();	
	    var typeFlag = sourceView.typeFlag;
	    var event = context.event;
	    var pageCode ;
	    var pageTitle;
	    if(typeFlag==1){
	    	pageTitle = '环节整改通知工作';
	    	pageCode = "processRfmDefectView";
	    }else if(typeFlag==2){
	    	pageCode = "terminalRfmDefectView";
	    	pageTitle = '终末整改通知工作';
	    }else if(typeFlag==3){
	    	pageCode = "deptRfmDefectView";
	    	pageTitle = '科室整改通知工作';
	    }else if(typeFlag==4){
	    	pageCode = "orderRfmdefectview";
	    	pageTitle = '医嘱整改通知工作';
	    }

	    var viewConfig = {
	    	revisionCd: revisionCd,
	    	revisionStatus:revisionStatus,
	    	typeFlag:typeFlag,
	    	record:record
	    }

        var config = {
            pageCode: pageCode,
            pageTitle: pageTitle,
            viewConfig: viewConfig
        };
        var canvas = Xap.getCanvas();
        canvas.fireEvent("updatePatient",{patient:record.data});  // top患者信息刷新
        canvas.fireEvent("addWorkPage",config);
	}
});