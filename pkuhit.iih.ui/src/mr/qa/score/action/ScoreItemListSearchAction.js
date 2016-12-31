/** 
 * 查询：质控评分画面---扣分项目列表
 * @author ：wang_yanli
 */

Ext.define('iih.mr.qa.score.action.ScoreItemListSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	doExecute: function(context) {
		this.prepareOperations(context);
	 },
	 prepareOperations: function(context) {
	 	var owner = this.getOwner(); 
	 	var block = this.getBlock('bottom');
	    var patientRecord = owner.patientRecord;
	    var workScreen = owner.workScreen;
	    var ifScore = owner.ifScore;
	    var qaScoreItemAdd = block.down('xapbutton[action=qaScoreItemAdd]');
	    var qaScoreComplete = block.down('xapbutton[action=qaScoreComplete]');
	    var ScoreItemGrid = block.down('xapgrid');	
	    if(ifScore == '2'){
	    	qaScoreItemAdd.setDisabled(true);
	    	qaScoreComplete.setDisabled(true);
	    	ScoreItemGrid.columns[5].hidden=true;
	    }else{
	    	qaScoreItemAdd.setDisabled(false);
	    	qaScoreComplete.setDisabled(false);
	    	ScoreItemGrid.columns[5].hidden=false;
	    }
		var operations = context.operations;
        var url = this.url;
        
        
        // 获取选中患者的就诊序号
        var enPk;
    	enPk = patientRecord.pk;
        url += '?' + 'encounterPk=' + enPk + '&workScreen='+ workScreen;
    	var operation = {
            url: url,
    		mclass: null,
    		method: 'get',
    		condition: null,
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.length = 0;
    	operations.push(operation);
    },

   onSuccess: function(operation) {
	    var owner = this.getOwner(); 
	    var workScreen = owner.workScreen;
	    var block = this.getBlock('bottom');
        var m = operation.result;
        var dataList = m.dataList;
        var qaTyCd ,qaAutoTyCd;//人工质控编码，自动质控编码
        if(workScreen == '7'){//终末
			qaTyCd = iih.mr.qa.QaStatusGlobal.qaTypeCodeTerminal; 
			qaAutoTyCd = iih.mr.qa.QaStatusGlobal.qaAutoTypeCodeTerminal;
		}else if(workScreen == '11'){ //科室
			qaTyCd = iih.mr.qa.QaStatusGlobal.qaTypeCodeDept; 
			qaAutoTyCd = iih.mr.qa.QaStatusGlobal.qaAutoTypeCodeDept;
		}else if(workScreen == '12'){
			qaTyCd = iih.mr.qa.QaStatusGlobal.qaTypeCodeAuto; 
		}
        if(dataList != null){
	        //质控医师赋值
	        for(var i=0;i<dataList.length;i++){
	        	var qaTypeCd = dataList[i].qaTyCd;
	        	var sbmtUserNm = dataList[i].sbmtUserNm;
		        	if(qaTypeCd == qaAutoTyCd && sbmtUserNm == null){
		        		dataList[i].sbmtUserNm = '自动';
		        	}
	        	}
        }
        block.setData(m);
        var owner = this.getOwner(); //scoreWorkView
        var patientRecord = owner.patientRecord;
        var enPk = patientRecord.pk;
        var scoreWorkProperites = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
       
        scoreWorkProperites.setData({
	        	enPk:enPk,  //就诊PK
	        	qaTypeCode:qaTyCd,    //质控类型编码
				workScreen:workScreen
	    });
        
	    if(workScreen == '12'){
	    	var chain = owner.getActionChain('qaScoreSearch');
	        if(chain) {
	            chain.execute();
	        }
	    }else{
	    	//刷新按钮
			//获取缺陷一览的GRID
			var ScoreItemGrid = block.down('xapgrid');
			/*//设置删除按钮不可编辑
			ScoreItemGrid.down('xapbutton[action=qaScoreItemDelete]').setDisabled(true);*/
	        
	        var chain = owner.getActionChain('qaScoreSearch');
	        
	        if(chain) {
	            chain.execute();
	        }
	    }
    }
});
