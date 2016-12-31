/** 
 * 质控项目保存Action
 * @extends Xap.ej.action.ServiceInvocation
 * @author ：wu_guocheng
 */

Ext.define('iih.mr.qa.process_qa_work.action.FaultInputSaveAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	requires:['iih.mr.qa.QaStatusGlobal'],
	
	/*   
	* @Override
	*/
	execute: function(context) {   
		
    	var owner = this.getOwner();
    	      
    	//获取质控项目block
		var block = this.getBlock('content');
	 	var isValid = block.getForm().isValid();
    	if(!isValid){
    		return;
    	}
		var rfmDes = block.getData().rfmDes;
		var rfmUserId = block.getData().rfmUser;
//		if(CONFIG_PARAM.QA_RFMUSER_SELECT&&!rfmUserId){
//			Ext.Msg.alert("提示",'请选择整改人！');
//			return;
//		}
		var qaItemGrid = block.down('xapgrid');
		
		var socuseOwner = owner.socuseOwner;
		var properties = socuseOwner.ownerCt.ownerCt.getLayer(Xap.ej.block.Layer.PROPERTIES);
    	
    	//参数处理
    	var selModel = qaItemGrid.getSelectionModel();
        var selRecord = selModel.getSelection()[0];
        if(selRecord == undefined){
        	XapMessageBox.info('请选择一条评分项目');
        }else{
        	 selRecord.data.rfmDes = rfmDes;
        	 selRecord.data.rfmUserId = rfmUserId;
         	var listdata = this.getData(selRecord.data,properties,socuseOwner);
         	
         	var operations = context.operations;
         	if(!operations) {
         		return;
         	}
         	this.prepareOperations(operations,listdata);
        }
    	
    },
    prepareOperations: function(operations,data){
        var url = this.url;
        var mclass = null;
        var METHODS = this.getInvocationMethods();
    	var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_CREATE,
            condition: null,	
            data:data,
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.push(operation);
    },
    onSuccess: function(operation) {
        
    	//获取质控项目block
		var block = this.getBlock('content');
		var defectinGrid = block.down('xapgrid');
	    var m = operation.result;
	    
	    //质控工作画面中的缺陷一览进行查询
	    var owner = this.getOwner();
	    
	    //关闭此画面
	    var parentOwner = owner.ownerCt;
	    parentOwner.close();
    	/*var closeChain = owner.getActionChain('closeFaultAction');
    	closeChain.execute(); wangyanli 这样调用报错*/
	    
    	//刷新缺陷一览的记录
    	var socuseOwner = owner.socuseOwner;
    	var chain = socuseOwner.getActionChain('searchDefectsAction');
    	chain.execute();
    	
    	
    },
    getData:function(data,properties,socuseOwner){
    	//保存的参数集合
    	var datasArr = [];
    	var me = this;
    	var faultBlock = me.getBlock('content');
    	var associateMr = faultBlock.down('xapcheckbox');
    	var obj = new Object();
		obj.qaItmCd = data.qaItmCd;
		obj.deductScrTimes = data.deductScrTimes;//缺陷次数
		obj.qaPk = properties.data.currentQaPk; 
		obj.mrPk = data.mrPk;
		if(associateMr.checked){
			if(properties.data.medicalRecord){
				obj.mrPk = properties.data.medicalRecord.mrPk;
			}
		}
		
		//根据工作场景判断质控类型环节=1、科室=8、终末=4
		var workscreen = properties.data.workScreen;
		var qaTyCd = '';
		if(workscreen == '1'){
			
			qaTyCd = iih.mr.qa.QaStatusGlobal.qaTypeCodeProcess; 
		}else if(workscreen == '4'){
			
			qaTyCd = iih.mr.qa.QaStatusGlobal.qaTypeCodeTerminal; 
			
	    }else if(workscreen == '8'){
	    	
	    	qaTyCd = iih.mr.qa.QaStatusGlobal.qaTypeCodeDept; 
	    }else if(workscreen == '13'){
	    	
	    	qaTyCd = iih.mr.qa.QaStatusGlobal.qaTypeCodeOrder; 
	    }
		obj.statusCode = iih.mr.qa.QaStatusGlobal.faultToReform; 
		obj.qaTyCd = qaTyCd; 
		obj.rfmDes = data.rfmDes; 
		
    	datasArr.push(obj);
    	
    	var curMngDctId ='';
    	//配置开关 提缺陷 选择整改护士，且 当前登录用户有护士角色 ，则整改人，为用户选择设定
    	if(CONFIG_PARAM.QA_RFMUSER_SELECT && iih.mr.qa.QaStatusGlobal.isNurseRole){
    		curMngDctId = data.rfmUserId;
    	}else{
    		curMngDctId = faultBlock.data.mrCreateUserCode;
    	}
    	 var data={enPk:properties.data.encounterPk,qaTypeCode:properties.data.qaTypeCode,curMngDctId:curMngDctId,currentDeptCode:faultBlock.data.mrCreateDeptCode,qaFaultArray:datasArr};
    	 
    	 return data;
    }
});