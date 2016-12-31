/** 
 * QA领域公共函数调用
 * @author ：wu_guocheng
 */
Ext.define('iih.mr.qa.QaFunction', {
	
	singleton: true,
    
	taskTimes:0.05,   //时间数
	
    //创建病历
    qaCreateMrdoc:function(mrdocBlock,mrSn){
    	
    	var config = {
				xclass: 'iih.mr.wr.mr.view.MrDocEditView',
                viewConfig:{
                    mrSn:mrSn,
                    opType:'readonly'
                    //opType:'open'
                }
            };   
		
		 var mrdocEditView =  Ext.create(config.xclass,config.viewConfig);
		 mrdocBlock.removeAll();
		 mrdocBlock.add(mrdocEditView);
		 
		 return mrdocEditView;
    },
    
    //设置缺陷按钮
    setButDisabled:function(grid,owner,b){
    	
    	if(b){
    		
    		grid.down('xapbutton[action=defectsin]').setDisabled(false);
    		
    	}else{
    		
    		 var medicalRecord  = owner.down('mrdoceditview').medicalRecord;
    		 
	   		 //不是 整改要求已发送 和整改要求已接收 才可编辑
	   		 if(null!=medicalRecord.qaStatusCode && medicalRecord.qaStatusCode!='QAM04.02' && medicalRecord.qaStatusCode!='QAM04.03'){
	   			 
	   			 grid.down('xapbutton[action=defectsin]').setDisabled(false);
	   		 }
    	}
    },
    
    //设置病历TITLE
    setBlockTitle:function(mrdocBlock,properties,treeRecord){
    	
    	 var text = '';
    	 
    	 if(treeRecord.text!=undefined){
    		 
    		 text = treeRecord.text;
    		 
    	 }else{
    		 
    		 //text = treeRecord.mrName;
    	 }
    	
    	 if(properties.data.typeFlag == iih.mr.qa.QaStatusGlobal.workScreenWorkProcess || properties.data.typeFlag == iih.mr.qa.QaStatusGlobal.workScreenTrackProcess){
			 //环节质控
			 mrdocBlock.setTitle(text+'&nbsp &nbsp &nbsp('+properties.data.patientRecord.patientName+' &nbsp &nbsp &nbsp '+properties.data.patientRecord.currentDeptName+')');
			 
		 }else if(properties.data.typeFlag == iih.mr.qa.QaStatusGlobal.workScreenTrackTerminal || properties.data.typeFlag == iih.mr.qa.QaStatusGlobal.workScreenWorkTerminal || properties.data.typeFlag == iih.mr.qa.QaStatusGlobal.workScreenScore){
			 //终末质控
			 mrdocBlock.setTitle(text+'&nbsp &nbsp &nbsp('+properties.data.patientRecord.patientName+' &nbsp &nbsp &nbsp '+properties.data.patientRecord.currentDeptName+')');
		 }
    },
    
    //判断质控类型返回Boolean
    getQaTypeBoolean:function(properties){
    	
    	var b = false;
    	
    	if(properties.data.typeFlag == iih.mr.qa.QaStatusGlobal.workScreenTrackTerminal || properties.data.typeFlag == iih.mr.qa.QaStatusGlobal.workScreenWorkTerminal || properties.data.typeFlag == iih.mr.qa.QaStatusGlobal.workScreenScore){
    		
    		b = true;
    	}
    	
    	return b;
    },
    
    //获取Task
    getTask:function(fun){
    	return new Ext.util.DelayedTask(function(){fun}); 
    }
})