Ext.define('iih.mr.wr.omr.action.RefreshPrescriptionAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    /*
     * @Override
     */
    execute: function(context) {
    	var plugin = document.getElementById('iemrEditor');
    	if(plugin!=undefined && plugin.IsReadOnly()){
    		return;
    	}else if(plugin == undefined){
    		return;
    	}
        var operations = context.operations;
        if(!operations) {
            return;
        }
        if(context.submitF){//第三方socket调用刷新处置后提交标识
			this.submitF=context.submitF;
		}
        var medicalRecord=this.getOwner().medicalRecord;
        //如果文档为提交状态，则不执行刷新处置
        if(medicalRecord&&medicalRecord.statusCode=='MRM04.02'){
        	//执行整洁打印
            var emrNeatPrint = this.getOwner().getActionChain('emrNeatPrint');
            if(emrNeatPrint) {
            	emrNeatPrint.execute({submitF:this.submitF});
            }
            return;
        }
        this.prepareOperations(operations);
    },
    
    prepareOperations: function(operations) {
    	var medicalRecord=this.getOwner().medicalRecord;
    	
        var url=this.url+'/'+medicalRecord.encounterPk;
        var operation = {
            url: url,
            method: 'get',
            scope: this,
            success: this.onSuccess,
            fail: this.onFail
        };
        operations.push(operation);
    },
    onSuccess: function(operation) {
        var plugin = document.getElementById('iemrEditor');
        var prescriptionsArr=operation.result.data.prescriptions;//西药处方
        var cpmPrescriptionsArr=operation.result.data.cpmPrescriptions;//中成药处方
        var cmXdPrescriptionsList=operation.result.data.cmXdPrescriptionsList;//中草协定处方
        var cmFxdPrescriptionsList=operation.result.data.cmFxdPrescriptionsList;//中草药非协定处方
        var cZlPrescriptionsList=operation.result.data.cZlPrescriptionsList;//中医治疗
        var disposals=operation.result.data.disposals;//处置
        var prescriptionsTemplateOdtFile=operation.result.data.prescriptionsTemplateFile;
        var cmFxdPrescriptionsTemplateFile=operation.result.data.cmFxdPrescriptionsTemplateFile;
        var cpmPrescriptionsTemplateFile=operation.result.data.cpmPrescriptionsTemplateFile;
        var cpmPrescriptionsSignTemplateFile=operation.result.data.cpmPrescriptionsSignTemplateFile;
        this.importPrescription(plugin, prescriptionsArr, prescriptionsTemplateOdtFile,operation.result.data.prescriptionsSignTemplateFile);
        this.importCpmPrescription(plugin, cpmPrescriptionsArr, cpmPrescriptionsTemplateFile, cpmPrescriptionsSignTemplateFile);
        this.importFXDCHM(plugin, cmFxdPrescriptionsList,cmFxdPrescriptionsTemplateFile);
        this.importXDCHM(plugin, cmXdPrescriptionsList);
        this.importAdvice(plugin, disposals);
        this.importCZhiliao(plugin, cZlPrescriptionsList);
        this.disposeTable(plugin);
        this.gotoFront(plugin);
        if(this.submitF==1){//第三方socket调用刷新处置后提交标识
			this.submitF==0;
			if(CONFIG_PARAM.OMR_EN_OVER_IS_SUBMIT == 1)
			    this.getOwner().getActionChain('emrPrint').execute({submitF:1});
		}
    },
    onFail: function(operation) {
        Ext.Msg.alert("提示",'获取处方处置失败，请重试！');
    },
    disposeTable: function(plugin) {
    	setTimeout(function() {
    		plugin.RemoveBlankPreTable('门诊处方表');
    	},100);
    	setTimeout(function() {
    		plugin.RemoveBlankPreTable('门诊中成药处方表');
    	},200);
    	setTimeout(function() {
    		plugin.RemoveBlankPreTable('草药协定处方表');
    	},300);
    	setTimeout(function() {
    		plugin.RemoveBlankPreTable('草药非协定处方表');
    	},400);
    	setTimeout(function() {
    		plugin.RemoveBlankPreTable('门诊处置表');
    	},500);
    	setTimeout(function() {
    		plugin.RemoveBlankPreTable('中医治疗处方表');
    	},600);
    },
    /**
     * 光标跳到首行
     */
    gotoFront:function(plugin){
    	setTimeout(function() {
    		plugin.GotoMark('');
    	},1000);
	}, 
    /**
     * 刷新中草药协定处方
     */
    importXDCHM:function(plugin,cmXdPrescriptionsList){
    	var prescriptions = '';
    	for(var i=0;i<cmXdPrescriptionsList.length;i++){
    		if(prescriptions == ''){
    			prescriptions = cmXdPrescriptionsList[i].svNm+'                                                               '+cmXdPrescriptionsList[i].boilTpNm+cmXdPrescriptionsList[i].freqNm;
            }else{
            	prescriptions = prescriptions + '\n' + cmXdPrescriptionsList[i].svNm+'                                                               '+cmXdPrescriptionsList[i].boilTpNm+cmXdPrescriptionsList[i].freqNm;
            }
    	}
    	if(prescriptions==''){
    		plugin.Table2Placeholder('草药协定处方表');
    	}else{
    		plugin.RefreshSpecifyTable('草药协定处方表',1, prescriptions);
    	}
    },
    /**
     * 刷新中草药非协定处方
     */
    importFXDCHM:function(plugin,cmFxdPrescriptionsList,cmFxdPrescriptionsTemplateFile){
    	var cmFxdPrescriptionArr = new Array();
    	var dosStr=' ';
    	for(var i=0;i<cmFxdPrescriptionsList.length;i++){
    		dosStr=cmFxdPrescriptionsList[i].boilTpNm+cmFxdPrescriptionsList[i].freqNm;
    		cmFxdPrescriptionArr.push(cmFxdPrescriptionsList[i].svNm+cmFxdPrescriptionsList[i].takeAmount+cmFxdPrescriptionsList[i].dosageUnitNm);	
    	}
//alert(dosStr);
        var dosesArr = new Array(dosStr.replace('\n',''));
        var cmFxdPrescriptionTable = new Array('草药非协定处方表');
        plugin.RemoveTables(cmFxdPrescriptionTable);
        if(cmFxdPrescriptionArr.length>0){
        	plugin.ImportCHM("草药协定处方表", cmFxdPrescriptionsTemplateFile, "草药非协定处方表", cmFxdPrescriptionArr, 4, dosesArr);	
        }
        
    },
    /**
     * 刷新中医治疗处方
     */
    importCZhiliao:function(plugin,cZlPrescriptionsList){
    	var czls = '';
    	for(var i=0;i<cZlPrescriptionsList.length;i++){
    		if(czls == ''){
    			czls = cZlPrescriptionsList[i].svNm+'\n'+cZlPrescriptionsList[i].freqNm;
            }else{
            	czls = czls + '\n' + cZlPrescriptionsList[i].svNm+'\n'+cZlPrescriptionsList[i].freqNm;
            }
    	}
    	if(czls==''){
    		plugin.Table2Placeholder('中医治疗处方表');
    	}else{
    		plugin.AppendTableRow('中医治疗处方表', 2, czls, false);
    	}
    	
    },
    /**
     * 刷新门诊处置（包括检验，检查，诊疗）
     */
    importAdvice:function(plugin,disposals){
  	  	var all = null;
        for(var i=0;i<disposals.length;i++){
      	  if(all == null){
      		  all = disposals[i].svNm;
      		  if("03"==disposals[i].orTpCd){//03为门诊诊疗，可能有单位，需要特殊处理
      			  var freqNm='';
      			  if(disposals[i].freqNm !=undefined){
      				freqNm=disposals[i].freqNm+"          数量："+disposals[i].amount;
      			  }
      			  all = all+'          '+freqNm;
      		  }
      	  }else{
      		  all = all + '\n' + disposals[i].svNm;
      		  if("03"==disposals[i].orTpCd){
      			  var freqNm='';
          		  if(disposals[i].freqNm!=undefined){
          			freqNm=disposals[i].freqNm+"          数量："+disposals[i].amount;
          		  }
          		  all = all + '          '+freqNm;
      		  }
      	  }
        }
        if(all==null){
        	plugin.Table2Placeholder('门诊处置表');
        }else{
        	plugin.RefreshSpecifyTable('门诊处置表',1, all);
        }
    },
    /**
     * 刷新处方
     */
    importPrescription:function(plugin,prescriptionsArr,prescriptionsTemplateOdtFile,prescriptionsSignTemplateFile){
    	var prescriptionsStr = new Array(0);
    	if(null!=prescriptionsArr&&undefined!=prescriptionsArr){
    		if(prescriptionsArr.length>0){
    			if(null!=prescriptionsTemplateOdtFile&&undefined!=prescriptionsTemplateOdtFile){
        			for(var i = 0; i < prescriptionsArr.length; i++){
      					var specifDosage=prescriptionsArr[i].specifDosage;
      					if(specifDosage!=undefined&&specifDosage.indexOf('&nbsp')>0){
      						specifDosage=specifDosage.substr(0,specifDosage.indexOf('&nbsp'));
      					}
      					//增加门诊处方，分组
      					var specification=prescriptionsArr[i].specification==null?'':prescriptionsArr[i].specification;
            			var prescriptionStr = 'yp_zl_name\n'+prescriptionsArr[i].name+'\nspeci_dosage\n'+specifDosage+'\nfrename\n'+prescriptionsArr[i].frename+'\nyz_supply\n'+prescriptionsArr[i].supply+'\nspecification\n'+specification+'\nmz_charge_group\n'+prescriptionsArr[i].chargeGroup+'\ndrug_amount\n'+prescriptionsArr[i].drugAmount;
            			if(prescriptionsArr[i].parentOrderSn!=null&&prescriptionsArr[i].parentOrderSn!=undefined){
            				prescriptionStr=prescriptionStr+'\ngroup\n'+prescriptionsArr[i].parentOrderSn;
      					}else{
      						prescriptionStr=prescriptionStr+'\ngroup\n&nbsp';
      					}
            			prescriptionsStr.push(prescriptionStr);	
        			}
        			plugin.ImportPrescription('门诊处方表',prescriptionsTemplateOdtFile,prescriptionsStr,true);
    			}else{
    	        	Ext.MessageBox.alert('提示', '门诊处方表小模板不存在，无法刷新处方！');
    	        }
    		}else{
    			plugin.Table2Placeholder('门诊处方表');
    			/*var tabList = plugin.GetTables();
    	    	var tabs = new Array(0);
    	    	if(tabList){                	    		
    	    		for(var i=0;i<tabList.length;i++){
        	    		var tabName = tabList[i];
        	    		if(tabName=='门诊处方表'){
        	    			var tabContent =plugin.ExportTable(tabName);
        	    			if((tabContent&&tabContent.length>0)){
        	    				tabs.push(tabName);
            	    		}
        	    		}
        	    	}
    	    	}  
    	    	if(tabs.length>0){
    	    		plugin.RemoveTables(tabs);
        			plugin.InsertFromString(prescriptionsSignTemplateFile,0);
        			plugin.RemoveBlankPreTable('门诊处方表');
    	    	}*/
    		}
    	}
    },
    /**
     * 刷新中成药处方
     */
    importCpmPrescription:function(plugin,cpmPrescriptionsArr,cpmPrescriptionsTemplateOdtFile,cpmPrescriptionsSignTemplateFile){
    	var prescriptionsStr = new Array(0);
    	if(null!=cpmPrescriptionsArr&&undefined!=cpmPrescriptionsArr){
    		if(cpmPrescriptionsArr.length>0){
    			if(null!=cpmPrescriptionsTemplateOdtFile&&undefined!=cpmPrescriptionsTemplateOdtFile){
//        			var prescriptionsStr = new Array(0);
        			for(var i = 0; i < cpmPrescriptionsArr.length; i++){
      					var specifDosage=cpmPrescriptionsArr[i].specifDosage;
      					if(specifDosage!=undefined&&specifDosage.indexOf('&nbsp')>0){
      						specifDosage=specifDosage.substr(0,specifDosage.indexOf('&nbsp'));
      					}
      					//增加门诊处方，分组
      					var specification=cpmPrescriptionsArr[i].specification==null?'':cpmPrescriptionsArr[i].specification;
            			var prescriptionStr = 'yp_zl_name\n'+cpmPrescriptionsArr[i].name+'\nspeci_dosage\n'+specifDosage+'\nfrename\n'+cpmPrescriptionsArr[i].frename+'\nyz_supply\n'+cpmPrescriptionsArr[i].supply+'\nspecification\n'+specification+'\nmz_charge_group\n'+cpmPrescriptionsArr[i].chargeGroup+'\ndrug_amount\n'+cpmPrescriptionsArr[i].drugAmount;
            			if(cpmPrescriptionsArr[i].parentOrderSn!=null&&cpmPrescriptionsArr[i].parentOrderSn!=undefined){
            				prescriptionStr=prescriptionStr+'\ngroup\n'+cpmPrescriptionsArr[i].parentOrderSn;
      					}else{
      						prescriptionStr=prescriptionStr+'\ngroup\n&nbsp';
      					}
            			prescriptionsStr.push(prescriptionStr);	
        			}
        			plugin.ImportPrescription('门诊中成药处方表',cpmPrescriptionsTemplateOdtFile,prescriptionsStr,true);
    			}else{
    	        	Ext.MessageBox.alert('提示', '门诊中成药处方表小模板不存在，无法刷新处方！');
    	        }
    		}else{
    			plugin.Table2Placeholder('门诊中成药处方表');
    			/*var tabList = plugin.GetTables();
    	    	var tabs = new Array(0);
    	    	if(tabList){                	    		
    	    		for(var i=0;i<tabList.length;i++){
        	    		var tabName = tabList[i];
        	    		if(tabName=='门诊中成药处方表'){
        	    			var tabContent =plugin.ExportTable(tabName);
        	    			if((tabContent&&tabContent.length>0)){
        	    				tabs.push(tabName);
            	    		}
        	    		}
        	    	}
    	    	}  
    	    	if(tabs.length>0){
    	    		plugin.RemoveTables(tabs);
        			plugin.InsertFromString(cpmPrescriptionsSignTemplateFile,0);
        			plugin.RemoveBlankPreTable('门诊中成药处方表');
    	    	}
    		*/}
    	}
    }
});
