/** 
 * 进入评分工作页面
 * @author ：yao_lijie
 */
Ext.define('iih.mr.qa.score.action.TerminalScoreAction', {
extend: 'Xap.ej.action.Action',
	
	requires: ['iih.mr.qa.score.view.ScoreWorkView'],
	
	/*
	* @Override
	*/
	execute: function(context) {
		
		 var me = this;
		 
		 var owner = this.owner;
		 
		 var block = this.getBlock('condition');
		 var condition = block.getData();
	     var ifScore = condition.score;
		 
		 var typeFlag = owner.typeFlag;
		 
		 if(typeFlag == '3'){
		 	return;
		 }
		 var topBlock = this.getBlock('result');
	        
	     var enGrid = topBlock.down('xapgrid');
	     
	     var selModel = enGrid.getSelectionModel();
	        
	     var record = selModel.getSelection()[0];
	     
	     //todo 判断是科室评分还是终末评分
	     var typeFlag = owner.typeFlag;
	     var workScreen = '';
	     var pageTitle = '';
	     if(typeFlag == '1'){
	    	 workScreen = iih.mr.qa.QaStatusGlobal.workScreenScore;
		     pageTitle = '终末评分';
	     }else if(typeFlag == '2'){
	    	 workScreen = iih.mr.qa.QaStatusGlobal.workScreenScoreDept;
		     pageTitle = '科室终末评分';
	     }
	     
	     if(record == undefined){
	    	 XapMessageBox.info('请选择患者');
         }else{
		     var viewConfig = {		    		
					patientRecord: record.data,
					ifScore:ifScore,
					workScreen:workScreen
		     }
		    var event = context.event;
	        if(event) {
	            var config = {
	                    pageCode: 'scoreworkview',
	                    pageTitle: pageTitle,
	                    viewConfig:  viewConfig
	                };
	            var canvas = Xap.getCanvas();
	            canvas.fireEvent("updatePatient",{patient:record.data});  // top患者信息刷新
	            canvas.fireEvent("addWorkPage",config);
	        };
         }
    }
});