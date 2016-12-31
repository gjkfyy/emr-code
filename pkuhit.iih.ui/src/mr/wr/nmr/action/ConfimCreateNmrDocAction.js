Ext.define('iih.mr.wr.nmr.action.ConfimCreateNmrDocAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	doExecute: function(context) {
		var owner=this.getOwner();
		//var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
		//var opType=properties.data.opType;
//		var tab=owner.getBlock('content').down('xaptabpanel');
		//var activeTab=tab.getActiveTab();
		//var tabName=activeTab.name;
		//病历文书类型
		var typeCode;
		var templateCode;
		var filePk;
		var form= this.getBlock('bottom').getForm();
		var data =form.getValues();
		//if(tabName=='pastmrselectview'){
		//	var mr=owner.getBlock('content').down('pastmrselectview').getBlock('right').medicalRecord;
		//	if(!mr){
		//		XapMessageBox.info('请选择一份既往病历！');
		//		return;
		//	}
		//	typeCode=mr.typeCode;
		//}else if(tabName=='createomrdocview'){
			var grid=Ext.getCmp('createdocview').down('xapgrid');
			var rb = grid.getSelectionModel().getSelection(); 
			if(rb.length == 0){
				XapMessageBox.info('请先选一个模板！');
	            return
	        }else{
	        	var rbData=rb[0].data;
	        	for(var p in rbData){
	        		data[p] = rbData[p];
	            }
	        	typeCode = rb[0].data.mrTypeCode;
	        	templateCode= rb[0].data.code;
	        	filePk= rb[0].data.filePk;
	        }
//		}else if(tabName=='csakrview'){
//			var csaDiAndMrTemplateBlock=Ext.getCmp('csaDiAndMrTemplateBlock');
//			var csakrview=Ext.getCmp('csakrview');
//			var csaTreeBlock=csakrview.getBlock('left');
//			var csaTree=csaTreeBlock.down('xaptree');
//			var treeNode = csaTree.getSelectionModel().getSelection();
//			var text=treeNode[0].raw.text;
//			var diCode=treeNode[0].raw.diCode;
//	        var diGrid = csaDiAndMrTemplateBlock.down('xapgrid[action=digrid]');
//	        var mrGrid = csaDiAndMrTemplateBlock.down('xapgrid[action=mrgrid]');
//	        
//	        var diSelModel=diGrid.getSelectionModel(); 
//	        var mrSelModel=mrGrid.getSelectionModel();
//	        
//	        var diSelection = diSelModel.getSelection();
//	        var mrSelection = mrSelModel.getSelection();
//	        if(diSelection.length==0&&text!='通用'&&diCode!='*'){
//	        	XapMessageBox.info('请选择诊断记录!');
//	        	return;
//	        }
//	        if(mrSelection.length == 0){
//	        	XapMessageBox.info('请先选一个模板！');
//	            return;
//	        }
	        //console.log(mrSelection);
//			alert(mrSelection.length);
			//typeCode = mrSelection[0].data.mrTypeCode;
		//}
		
//		if(opType&&opType=='reSelectTemp'){
//			var right = properties.data.omrDocEditPage;
//            if(right){
//      			delete right.mrTpCcatCd;
//      			var objView=right.down("objectview");
//      			if(objView){
//      				right.remove(objView);
//      			}
//				var tab=owner.getBlock('content').down('xaptabpanel');
//				var activeTab=tab.getActiveTab();
//				var tabName=activeTab.name;
//				if(tabName=='pastmrselectview'){
//					var mr=owner.getBlock('content').down('pastmrselectview').getBlock('right').medicalRecord;
//					right.opType = 'reSelectMr';
//					right.fileData=mr.fileData;
//					right.medicalRecord.templeCode=mr.templeCode;
//				}else if(tabName=='createomrdocview'){
//					var grid = this.getBlock('content').down('createomrdocview').getBlock('content').down('xapgrid');
//			        var rb = grid.getSelectionModel().getSelection(); 
//			        var data=rb[0].data;
//			        right.medicalRecord.templeCode=data.code;
//			        right.tempFilePk=data.filePk;
//					right.opType = 'reSelectTemp';
//				}else if(tabName=='csakrview'){
//					var csaDiAndMrTemplateBlock=Ext.getCmp('csaDiAndMrTemplateBlock');
////			        var diGrid = csaDiAndMrTemplateBlock.down('xapgrid[action=digrid]');
//			        var mrGrid = csaDiAndMrTemplateBlock.down('xapgrid[action=mrgrid]');
//			        
////			        var diSelModel=diGrid.getSelectionModel(); 
//			        var mrSelModel=mrGrid.getSelectionModel();
//			        
////			        var diSelection = diSelModel.getSelection();
//			        var mrSelection = mrSelModel.getSelection();
//			        right.medicalRecord.templeCode=mrSelection[0].data.mrTemplateCode;
//			        right.tempFilePk=mrSelection[0].data.filePk;
//					right.opType = 'reSelectTemp';
////					alert(mrSelection.length);
//				}
			var nmrCategoryCode= Ext.getCmp('nmrCategoryCode');
			var block= Ext.getCmp('nursingrecordspropertyblock');
			var mrNm=block.down('[name=mrNm]').getValue();
			var logicSmtDate=block.down('[name=logicSmtDate]').getValue().getTime();
			//稍后带提示
			var medicalRecord={
					filePk:filePk,
            		name:mrNm,
            		encounterPk:IMER_GLOBAL.encounterSn,
            		bizTime:logicSmtDate,
            		typeCode:typeCode,
            		mrTypeCustomCode:nmrCategoryCode.getValue(),
            		signLevelCode:data.signLevelCode,
            		//superiorDoctorId:data.higherLvlEmpId,
            		//superiorDoctorName:superiorDoctorName,
            		templeCode:templateCode};
//			var data = {'typeCode':typeCode,'encounterPk':encounterSn}
				var nursingrecordscontentview = Ext.getCmp('nursingrecordscontentview');
				nursingrecordscontentview.opType='new';
				nursingrecordscontentview.medicalRecord=medicalRecord;
		        var initChain =  nursingrecordscontentview.getActionChain('init');
		        initChain.execute();
         //}
            owner.ownerCt.close();
            return
		//}
		
//		//就诊号
//		var encounterSn = IMER_GLOBAL.encounterSn;
		var data = {'typeCode':typeCode,'encounterPk':encounterSn}
	//	this.prepareOperations(context.operations,data);
		
	},
    prepareOperations: function(operations,data) {
        var url = 'omr/canCreate';
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            method: METHODS.METHOD_CREATE,
            data:data,
            condition: null,
            scope: this,
            success: this.onSuccess
        };
        operations.push(operation);
    },
    onSuccess: function(operation) {

    	var form= this.getBlock('content').getForm();
    	var data =form.getValues();
    	var owner=this.getOwner();
    	//var tab=owner.getBlock('content').down('xaptabpanel');
		//var activeTab=tab.getActiveTab();
		//var tabName=activeTab.name;
		var typecode;
		var mrTypeCustomCode;
//		if(tabName=='pastmrselectview'){
//			var mr=owner.getBlock('content').down('pastmrselectview').getBlock('right').medicalRecord;
//			if(!mr){
//				XapMessageBox.info('请选择一份既往病历！');
//				return;
//			}
//			typeCode=mr.typeCode;
//			mrTypeCustomCode=mr.mrTypeCustomCode;
//		}else if(tabName=='createomrdocview'){
		var grid=Ext.getCmp('createdocview').down('xapgrid');
		var rb = grid.getSelectionModel().getSelection(); 
		data.signLevelCode=rb[0].data.signLevelCode;
//		    var conditionBlock=this.getBlock('content').down('createomrdocview').getBlock('content').getBlock('condition');
//		    var mrCustClaCd=conditionBlock.down('[name=mrCategoryCode]');
//		    mrTypeCustomCode=mrCustClaCd.getValue();
////			if(rb.length == 0){
////				XapMessageBox.info('请先选一个模板！');
////	            return
////	        }else{
//	        	typeCode = rb[0].data.mrTypeCode;
//	        	var rbData=rb[0].data;
//	        	data.code=rbData.code;
//	        	data.mrTypeCustomCode=mrTypeCustomCode;
//	            if(data && rbData){
//	                for(var p in rbData){
//	                    data[p] = rbData[p];
//	                }
//	             }
////	        }
//		}else if(tabName=='csakrview'){
//			var csaDiAndMrTemplateBlock=Ext.getCmp('csaDiAndMrTemplateBlock');
//	        var diGrid = csaDiAndMrTemplateBlock.down('xapgrid[action=digrid]');
//	        var mrGrid = csaDiAndMrTemplateBlock.down('xapgrid[action=mrgrid]');
//	        
//	        var diSelModel=diGrid.getSelectionModel(); 
//	        var mrSelModel=mrGrid.getSelectionModel();
//	        
//	        var diSelection = diSelModel.getSelection();
//	        var mrSelection = mrSelModel.getSelection();
//	        /*if(mrSelection.length == 0){
//	        	XapMessageBox.info('请先选一个模板！');
//	            return;
//	        }*/
//	        /*if(diSelection.length==0){
//	        	XapMessageBox.info('请选择诊断记录!');
//	        	return;
//	        }else{*/
//	        	for(var i=0;i<diSelection.length;i++){
//	        		//返回的诊断结果应该包含ownerType,ownerCd.
//	        		var node = {
//		          		      'diNm':diSelection[i].data.diName,
//		    	       	      'diEmpNm':IMER_GLOBAL.user.name,
//		    	       	      'diEmpCd':IMER_GLOBAL.user.code,
//		    	       	      'diTime':'',
//		    	       	      'diCd':diSelection[i].data.diCode,
//		    				  'diSn':'',
//		    				  'icdCd':diSelection[i].data.icdCode,
//		    				  'setOwnerTypeCd':diSelection[i].data.ownerType,
//		              	      'setOwnerCd':diSelection[i].data.ownerCode,
//		    	        	   leaf:true	 
//		             };
//	        		
//	        		diagnosisModels.push(node);
//	        	}
//	        
//			typeCode = mrSelection[0].data.mrTypeCode;
//			data.mrTypeCode=typeCode;
//			data.filePk=mrSelection[0].data.filePk;
//			data.code=mrSelection[0].data.mrTemplateCode;
//		}
        	if(data==undefined){
                XapMessageBox.info('请填写必要属性！');
                return
            }
            if(data.mrNm==''){
                XapMessageBox.info('请填写病历文书名称！');
                return
            }
            if(data.logicSmtDate==''){
                XapMessageBox.info('请填写业务时间！');
                return
            }
//            var outDiagnosisView = Ext.getCmp('outdiagnosisview');
//            if(outDiagnosisView){
//            	outDiagnosisView.csaInsertDiagnosis(diagnosisModels);
//            }
//            var higherLvlEmpId = this.getBlock('content').down('[name=higherLvlEmpId]');
//            var superiorDoctorName='';
//            if(higherLvlEmpId){
//            	superiorDoctorName=higherLvlEmpId.rawValue.substring(0,higherLvlEmpId.rawValue.indexOf(' '));
//            }
            var medicalRecord={filePk:data.filePk,
            		name:data.mrNm,
            		encounterPk:IMER_GLOBAL.encounterSn,
            		bizTime:data.logicSmtDate,
            		typeCode:data.mrTypeCode,
            		mrTypeCustomCode:mrTypeCustomCode,
            		signLevelCode:data.signLevelCode,
            		superiorDoctorId:data.higherLvlEmpId,
            		superiorDoctorName:superiorDoctorName,
            		templeCode:data.code};
            var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
		    //得到文书编辑器页面
            var right = properties.data.omrDocEditPage;
            if(right){
      			delete right.mrTpCcatCd;
      			var objView=right.down("objectview");
      			if(objView){
      				right.remove(objView);
      			}
//				var tab=owner.getBlock('content').down('xaptabpanel');
				//var activeTab=tab.getActiveTab();
//				var tabName=activeTab.name;
//				if(tabName=='pastmrselectview'){
//					var mr=owner.getBlock('content').down('pastmrselectview').getBlock('right').medicalRecord;
//					right.opType = 'newFromPastMr';
//					right.fileData=mr.fileData;
//					medicalRecord.typeCode=mr.typeCode;
//					medicalRecord.signLevelCode=mr.signLevelCode;
//					medicalRecord.encounterPk=mr.encounterPk;
//					medicalRecord.templeCode=mr.templeCode;
//				}
				
				right.medicalRecord=medicalRecord;
		        var initChain =  right.getActionChain('init');
		        initChain.execute();
          	}
            
            owner.ownerCt.close();
        
    
    }       
});
