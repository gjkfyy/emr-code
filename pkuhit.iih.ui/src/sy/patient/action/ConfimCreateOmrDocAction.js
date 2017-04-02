Ext.define('iih.sy.patient.action.ConfimCreateOmrDocAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	doExecute: function(context) {
		var owner=this.getOwner();
		var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
		var tab=owner.getBlock('content').down('xaptabpanel');
		var activeTab=tab.getActiveTab();
		var tabName=activeTab.name;
		//病历文书类型
		var typeCode;
		if(tabName=='pastmrselectview'){
			
		}else if(tabName=='createomrdocview'){
			var grid= this.getBlock('content').down('createomrdocview').getBlock('content').down('xapgrid');
			var rb = grid.getSelectionModel().getSelection(); 
			if(rb.length == 0){
				XapMessageBox.info('请先选一个模板！');
	            return
	        }else{
	        	typeCode = rb[0].data.mrTypeCode;
	        }
		}else if(tabName=='csakrview'){
			
		}
		
		//就诊号
		var encounterSn = IMER_GLOBAL.encounterSn;
		//templeCode为模板id
		var data = {'typeCode':typeCode,'encounterPk':encounterSn,templeCode:rb[0].data.code}
		this.prepareOperations(context.operations,data);
		
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
    	//yangjianbo
    	var form= this.getBlock('content').getForm();
    	var data =form.getValues();
    	var owner=this.getOwner();
    	var tab=owner.getBlock('content').down('xaptabpanel');
		var activeTab=tab.getActiveTab();
		var tabName=activeTab.name;
		var typecode;
		//var mrTypeCustomCode;
		var diagnosisModels = [];
		
		if(tabName=='pastmrselectview'){
			
		}else if(tabName=='createomrdocview'){
			var grid = this.getBlock('content').down('createomrdocview').getBlock('content').down('xapgrid');
		    var rb = grid.getSelectionModel().getSelection(); 
		    var conditionBlock=this.getBlock('content').down('createomrdocview').getBlock('content').getBlock('condition');
		   
		    	
	
	/* var mrCustClaCd=conditionBlock.down('[name=mrCategoryCode]');
		    mrTypeCustomCode=mrCustClaCd.getValue();*/
//			if(rb.length == 0){
//				XapMessageBox.info('请先选一个模板！');
//	            return
//	        }else{
	        	typeCode = rb[0].data.mrTypeCode;
	        	var rbData=rb[0].data;
	        	data.code=rbData.code;
	        	//data.mrTypeCustomCode=mrTypeCustomCode;
	            if(data && rbData){
	                for(var p in rbData){
	                    data[p] = rbData[p];
	                }
	             }
//	        }
		}else if(tabName=='csakrview'){
			
		}
            if(typecode=='MRM16.19'||typecode=='MRM16.20'){
            	  if(data.higherLvlEmpId==''){
            		  XapMessageBox.info('请选择上级查房医师！');
            		  return
            	  }
            }
        	/*if(data==undefined){
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
            }*/
            var outDiagnosisView = Ext.getCmp('outdiagnosisview');
            if(outDiagnosisView){
            	outDiagnosisView.csaInsertDiagnosis(diagnosisModels);
            }
            var higherLvlEmpId = this.getBlock('content').down('[name=higherLvlEmpId]');
            var superiorDoctorName='';
            if(higherLvlEmpId){
            	superiorDoctorName=higherLvlEmpId.rawValue.substring(0,higherLvlEmpId.rawValue.indexOf(' '));
            }
            var medicalRecord={filePk:data.filePk,
            		name:data.mrNm,
            		encounterPk:IMER_GLOBAL.encounterSn,
            		bizTime:data.logicSmtDate,
            		typeCode:data.mrTypeCode,
            		//mrTypeCustomCode:mrTypeCustomCode,
            		signLevelCode:data.signLevelCode,
            		superiorDoctorId:data.higherLvlEmpId,
            		superiorDoctorName:superiorDoctorName,
            		templeCode:data.code};
            var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
//            alert(11);
            
		    //得到文书编辑器页面
//            var right = properties.data.omrDocEditPage;
//            //right = Ext.getCmp('patientoutmrdoceditview');
//            if(right){
//      			delete right.mrTpCcatCd;
//      			var objView=right.down("objectview");
//      			if(objView){
//      				right.remove(objView);
//      			}
//				right.opType = 'new';
//				right.medicalRecord=medicalRecord;
//		        var initChain =  right.getActionChain('init');
//		        initChain.execute();
//          	}
            
           
            
            var canvas = Xap.getCanvas();            
            var config = {
         		   pageCode:'mrdoceditview',
                    xclass: 'iih.mr.wr.mr.view.MrWriteView',
                    pageTitle: medicalRecord.name,
                    viewConfig:{
                        opType:'new',
                        medicalRecord:medicalRecord
                    }
            };       
            canvas.fireEvent("addWorkPage",config);
            
            owner.ownerCt.close();
    }       
});
