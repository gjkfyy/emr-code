/** 
 * 初始化环节质控工作画面：
 * @author ：wang_yanli
 */
Ext.define('iih.mr.qa.process_qa_work.action.ProcessWorkAction', {
extend: 'Xap.ej.action.Action',
	
	requires: ['iih.mr.qa.process_qa_work.view.QaWorkView'],
	
	/*
	* @Override
	*/
	execute: function(context) {
		
		 var me = this;
		 //判断是否打开tab页
		 var owner = this.owner;
		 var record = context.record;
		 var event = context.event;;
		 var typeFlag;
		 if(record != undefined){
			 typeFlag = context.typeFlag;
			 var patientName = record.data.patientName;
	    	 iih.mr.qa.QaStatusGlobal.patient.name = patientName;
		 }else{
		 	 typeFlag = owner.typeFlag;
		 }
		 
		 
//		 var typeFlag = owner.typeFlag;
		 
		 //3=待签收患者列表
		 if(typeFlag == '3'){
		 	return;
		 }
		 var topBlock = this.getBlock('result');

	     //判断是患者质控还是终末质控
//	     var typeFlag = owner.typeFlag;
	     var enGrid;
	     var workScreen = '';
	     var pageTitle = '';
	     var pageCode = '';
	     if(typeFlag == '1'){
	     	enGrid = topBlock.down('xapgrid');
	     	workScreen = iih.mr.qa.QaStatusGlobal.workScreenWorkProcess;
	     	pageCode = "processQaWorkView";
	     	pageTitle = '环节质控工作';
	     }else if(typeFlag == '2'){
	     	enGrid = topBlock.down('xapgrid[name=alreadySignGrid]');
	   		workScreen = iih.mr.qa.QaStatusGlobal.workScreenWorkTerminal;
	   		pageCode = "terminalQaWorkView";
	   		pageTitle = '终末质控工作';
	     }else if(typeFlag == '5'){
	     	enGrid = topBlock.down('xapgrid');
	   		workScreen = iih.mr.qa.QaStatusGlobal.workScreenWorkDept; //8
	   		pageCode = "deptQaWorkView";
	   		pageTitle = '科室质控工作';
	     }else if(typeFlag == '6'){
		     	enGrid = topBlock.down('xapgrid');
		   		workScreen = iih.mr.qa.QaStatusGlobal.workScreenWorkOrder; //13
		   		pageCode = "orderQaWorkView";
		   		pageTitle = '医嘱质控工作';
		 }
	     
	     if(record == undefined){
			 var selModel = enGrid.getSelectionModel();
	     	 record = selModel.getSelection()[0];
		 }
	     /*var selModel = enGrid.getSelectionModel();
	     var record = selModel.getSelection()[0];*/
	     
	      if(record == undefined){
	    	  XapMessageBox.info('请选择患者');
         }else{
		     var viewConfig = {		    		
					patientRecord: record.data,
					workScreen:workScreen
		     }
		    
	        if(event) {
	            var config = {
	                    pageCode: pageCode,
	                    pageTitle: pageTitle,
	                    viewConfig:  viewConfig
	                   // assistantConfig: item.assistantConfig
	                };
	            var canvas = Xap.getCanvas();
	            canvas.fireEvent("updatePatient",{patient:record.data});  // top患者信息刷新
	            canvas.fireEvent("addWorkPage",config);
	        };
         }
    }
});