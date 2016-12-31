/** 
 * 质控规则保存Action
 * @extends Xap.ej.action.ServiceInvocation
 * @author ：yao_lijie
 */

Ext.define('iih.mr.qa.qa_divide_level.action.QaAutoConfigSaveAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	requires:['iih.mr.qa.QaStatusGlobal'],
	
	/*   
	* @Override
	*/
	execute: function(context) {   
    	var owner = this.getOwner();
		var block = this.getBlock('content');
		var qaItmTpCd = block.down('xapcombobox[name=qaItmTpCd]').value; //质控项目类别
		var timeAuto = block.down('xapform[name=timeAuto]');
        var frequencyAuto = block.down('xapform[name=frequencyAuto]');
        var integrityAuto = block.down('xapform[name=integrityAuto]');
        var dependentAuto = block.down('xapform[name=dependentAuto]');
        var req;
        var showInfo;
        var data;
        if(qaItmTpCd == 'QAM06.02'){
        	req = timeAuto.down('xaptextfield[name=req]').value;
        	showInfo = timeAuto.down('xapdisplayfield[name=showInfo]');
        	data = timeAuto.getValues();
    	   if(data.deadHours == ""){
	    		showInfo.setValue('<font color=red>规则运算值未设置</font>');
				return null;
			}else if(data.unit == ""){
	    		showInfo.setValue('<font color=red>单位未设置</font>');
				return null;
			}else if(data.mrOpType == ""){
	    		showInfo.setValue('<font color=red>文书操作类型未设置</font>');
				return null;
			}else{
				var deadHours = data.deadHours;
		        if(data.unit == 'day'){
		        	deadHours = deadHours*24;
		        	data.deadHours = deadHours;
		        }
		    }
        }else if(qaItmTpCd == 'QAM06.05'){
        	req = frequencyAuto.down('xaptextfield[name=req]').value;
        	showInfo = frequencyAuto.down('xapdisplayfield[name=showInfo]');
        	data = frequencyAuto.getValues();
        	var qaRlTpCd = data.qaRlTpCd;
        	/*data.mrTypes = data.mrTypes1;
			data.eventTypeCode = data.eventTypeCodeF;
			var qaRlTpCd = data.qaRlTpCd;
			var number = data.number;
			if(qaRlTpCd == '01'){
				if(number == undefined){
					var repNum = data.repNum;
					data.qaRlCd = qaRlTpCd+':'+data.eventTypeCodeF+':'+data.repNum;
				}else if(number.length >= 1){
					data.qaRlCd = qaRlTpCd+':'+data.eventTypeCodeF[0]+':'+data.repNum;
					for(var i=0;i<number.length;i++){
						var rule = qaRlTpCd+':'+data.eventTypeCodeF[i+1]+':'+number[i];
						data.qaRlCd += ','+rule;
						if(number[i] == ''){
							showInfo.setValue('<font color=red>规则运算值天数未设置</font>');
							return null;
						}
					}
				}
			}else{
				data.qaRlCd = data.conNum;
			}*/
        	if(data.mrOpType == ""){
	    		showInfo.setValue('<font color=red>文书操作类型未设置</font>');
				return null;
			}
			if(qaRlTpCd == '01'){
				if(data.repNum == ""){
		    		showInfo.setValue('<font color=red>规则运算值天数未设置</font>');
					return null;
				}else{
					data.qaRlCd = data.repNum;
				}
			}else{
				if(data.conNum == ""){
		    		showInfo.setValue('<font color=red>规则运算值天数未设置</font>');
					return null;
				}else{
					data.qaRlCd = data.conNum;
				}
			}
			
        }else if(qaItmTpCd == 'QAM06.04'){
        	req = integrityAuto.down('xaptextfield[name=req]').value;
        	showInfo = integrityAuto.down('xapdisplayfield[name=showInfo]');
        	data = integrityAuto.getValues();
        	 /*if(data.jobTitleCd == ""){
	    		showInfo.setValue('<font color=red>医师职称未设置</font>');
				return null;
			}else if(data.dctOpTpCd == ""){
	    		showInfo.setValue('<font color=red>医师操作类型未设置</font>');
				return null;
			}*/
        }else if(qaItmTpCd == 'QAM06.03'){
			req = dependentAuto.down('xaptextfield[name=req]').value;
			showInfo = dependentAuto.down('xapdisplayfield[name=showInfo]');
			data = dependentAuto.getValues();
	    }
         if(data.mrTypes == ""){
    		showInfo.setValue('<font color=red>文书类型未设置</font>');
			return null;
    	}else if(data.eventTypeCode == "" && qaItmTpCd != 'QAM06.03'){
    		showInfo.setValue('<font color=red>事件类型未设置</font>');
			return null;
		}
        data.req = req;
        data.qaItmTpCd = qaItmTpCd;
		var operations = context.operations;
	        if(!operations) {
	     		return;
		    }
			this.addOperations(operations,data);
    },
    addOperations: function(operations,data){
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
    	operations.length = 0;
    	operations.push(operation);
    },
    onSuccess: function(operation) {
 		XapMessageBox.info("保存成功");
    	var owner = this.getOwner();
    	var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
    	var qaItmData = properties.data.qaItmData;
    	var sourceView = properties.data.sourceView;
		if(sourceView.xtype=='qaitmview'){
			var chain = sourceView.getActionChain('treeSelect');
	    	chain.execute({
	    		fstCd:qaItmData.fstCd,
	    		sndCd:qaItmData.sndCd
	    	});
		}else{
			 var mrTypeCcatId = properties.data.mrTypeCcatId;
		        var qaItmCd = properties.data.qaItmCd;
		        var chain = sourceView.getActionChain('search');
		    	chain.execute({
		    		mrTypeCcatId:mrTypeCcatId,
		    		qaItmCd:qaItmCd
		    	});
		}
    }
});