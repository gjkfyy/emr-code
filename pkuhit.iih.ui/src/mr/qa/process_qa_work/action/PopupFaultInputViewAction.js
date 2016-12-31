/** 
 * 弹出录入缺陷画面Action
 * @extends Xap.ej.action.PopAction
 * @author ：wang_yanli
 */

Ext.define('iih.mr.qa.process_qa_work.action.PopupFaultInputViewAction', {
	extend: 'Xap.ej.action.PopAction',
	
	requires:['iih.mr.qa.process_qa_work.view.FaultInputView'],
	
	execute: function(context){  
		this.closeAction = 'hide';
		var owner=this.getOwner();	
		
		var properties = owner.ownerCt.ownerCt.getLayer(Xap.ej.block.Layer.PROPERTIES);
		
		//就诊序号
		var encounterPk = '';
		var qaTypeCode = '';
		var firstCode = '';
		encounterPk = properties.data.encounterPk;
		if(properties.data.workScreen!='13'){
			 firstCode = properties.data.firstCode;
		}else {
			/*//wangyanli add 医嘱质控 20160315
		    var patientRecord = owner.patientRecord;
	    	encounterPk = patientRecord.pk;//encounterPk;
*/	    	
	    	firstCode = 'QAM14.06';//基本要求及医嘱单
		}
		
		var mrdoceditview = owner.down('mrdoceditview');
		var mrTypeCode = '';
		var mrTypeName = '';
		var mrCreateUserCode = '';
		var mrCreateDeptCode = '';
		
		
        
        //新建对象，赋值给弹出的画面
		var workScreen = '';
		if(properties.data!=undefined){
			  workScreen = properties.data.workScreen;
		}
      
        //主画面传递过来的参数
        var mainPageParams;
        var currentDeptCode; //患者当前科室
        var currentWardCode; //患者当前病区
		var curMngDctId; //整改医生编码
		var curMngNurId; //整改护士编码
		var currentDeptName;
		var currentManageDoctorName;
        if(workScreen == '1' || workScreen == '4' || workScreen == '8'){//环节、科室、终末工作画面
        	mainPageParams = properties.data.patientRecord;
        	currentDeptCode = mainPageParams.currentDeptCode; //患者当前科室
        	currentWardCode = mainPageParams.currentWardCode; //患者当前病区
			curMngDctId = mainPageParams.currentManageDoctorId;//整改医生编码
			curMngNurId = mainPageParams.currentManageNurseId;//整改护士编码
			currentDeptName = mainPageParams.currentDeptName;
			currentManageDoctorName = mainPageParams.currentManageDoctorName;
        }else if(workScreen == '2' || workScreen == '5' || workScreen == '9'){//追踪画面
        	mainPageParams = properties.data.patientRecord.data;
        	//环节质控追踪的参数有变化，故改为给变量赋值
        	currentDeptCode = mainPageParams.rfmDeptCd; //患者当前科室
			curMngDctId = mainPageParams.rfmDoctorCd;//整改医生编码
			currentDeptName = mainPageParams.rfmDeptNM;
			currentManageDoctorName = mainPageParams.rfmDoctorNM;
        }else if(properties.data.workScreen == '13'){ //医嘱质控画面
        	mainPageParams = properties.data.patientRecord;
        	currentDeptCode = mainPageParams.currentDeptCode; //患者当前科室
			curMngDctId = mainPageParams.currentManageDoctorId;//整改医生编码
			curMngNurId = mainPageParams.currentManageNurseId;//整改护士编码
			currentDeptName = mainPageParams.currentDeptName;
			currentManageDoctorName = mainPageParams.currentManageDoctorName;
        	qaTypeCode = iih.mr.qa.QaStatusGlobal.qaTypeCodeOrder; //质控类型为医嘱质控
        }
		
        
        //如果没有关联文书则，则发给主管医生/责任护士
		if(mrdoceditview == null){
			// 护理质控时，整个人如果为主管护士，则需要把curMngDctId赋值为主管护士
			if(iih.mr.qa.QaStatusGlobal.isNurseRole && (workScreen == '1' || workScreen == '4' || workScreen == '8')){
	        	curMngDctId = curMngNurId;
	        	currentDeptCode = currentWardCode;
	        }
			mrCreateUserCode = curMngDctId;
			mrCreateDeptCode = currentDeptCode;
		}else{
			//医疗记录编码和医疗记录段落类型编码获取的是打开当前文书的
			var medicalRecord = owner.down('mrdoceditview').medicalRecord;
			if(medicalRecord != null){
				//医疗记录编码
				mrTypeCode = medicalRecord.typeCode;
				
				//医疗记录名称
				mrTypeName = medicalRecord.typeName;
				//var blockTitle = "["+mrTypeName+"]质控项目";
				
				//病历文书起草人
				mrCreateUserCode = medicalRecord.createUserId;
				
				//病历文书起草科室
				mrCreateDeptCode = medicalRecord.deptCd;
			}
		}
		
		
		//医疗记录段落类型编码
		var mrSegmemtTypeCode = '';
		
		//获取缺陷一览的Grid,通过grid获取病历文书PK及段落PK
		var defectinGrid = owner.down('defectsinblock').down('xapgrid');
		
		var config = {
				title:"病案评分标准项目",
//	    		width: 800,
	    		width: 850,
	    		height:500,
	    		contentConfig: {
	    			xtype: 'faultinputview',
	    			socuseOwner:owner,  //传入上级视图
	    			initChain: {
	    				name: 'initQaItmFst',
	    				context: {
	    					encounterPk: encounterPk,
	    					mrTypeCode: mrTypeCode,
	    					mrTypeName: mrTypeName,
	    					mrCreateUserCode:mrCreateUserCode,
	    					mrCreateDeptCode:mrCreateDeptCode,
	    					mrSegmemtTypeCode:mrSegmemtTypeCode,
	    					firstCode:firstCode,
	    					qaTypeCode:qaTypeCode //医嘱质控时用到该字段
	    				}
	    			}
	    		}
	    	};
		
		this.callParent([config]);
		
	}
})