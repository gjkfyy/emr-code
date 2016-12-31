Ext.define('iih.mr.wr.omr.action.RefreshMacroAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    /*
     * @Override
     */
    execute: function(context) {
        var operations = context.operations;
        if(!operations) {
            return;
        }
//        Ext.Msg.alert("提示",'刷新宏元素成功!');
        this.prepareOperations(operations);
    },
    
    prepareOperations: function(operations) {
        
        var condition=this.getOwner().medicalRecord;
        condition.opType=this.getOwner().opType;
        var url=this.url+'?opType='+condition.opType+'&encounterPk='+condition.encounterPk+'&typeCode='+condition.typeCode+'&mrPk='+condition.mrPk;
        var operation = {
            url: url,
            method: 'get',
            condition: condition,
            scope: this,
            success: this.onSuccess,
            fail: this.onFail
        };
        operations.push(operation);
    },
    onSuccess: function(operation) {
        var plugin = document.getElementById('iemrEditor');
//        console.log(operation);
        this.refreshMacroElement(plugin,operation.result.data);
//        Ext.Msg.alert("提示",'刷新宏元素成功!');
    },
    onFail: function(operation) {
        Ext.Msg.alert("提示",'获取宏元素失败!');
    },
    refreshMacroElement:function(plugin,macroElementValue){
        var self=this;
        var data = this.getOwner().medicalRecord;
        function trim(str) {
            if (typeof str == "string") {
                str = str.replace(/^(\s|\u00A0)+/, '');
                for ( var i = str.length - 1; i >= 0; i--) {
                    if (/\S/.test(str.charAt(i))) {
                        str = str.substring(0, i + 1);
                        break;
                    }
                }
            }
            return str;
        };
        function nullToNbsp(str) {
            if (str == null||str.length==0) {
                str = '&nbsp;';
            }
            return str;
        };
        function rtrim(str){ //删除右边的空格
        	return str.replace(/(\s*$)/g,"");
        };
        Date.prototype.format = function(fmt)   
        {
          var o = {   
            "M+" : this.getMonth()+1,                 //月份   
            "d+" : this.getDate(),                    //日   
            "h+" : this.getHours(),                   //小时   
            "m+" : this.getMinutes(),                 //分   
            "s+" : this.getSeconds(),                 //秒   
            "q+" : Math.floor((this.getMonth()+3)/3), //季度   
            "S"  : this.getMilliseconds()             //毫秒   
          };   
          if(/(y+)/.test(fmt))   
            fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
          for(var k in o)   
            if(new RegExp("("+ k +")").test(fmt))   
          fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
          return fmt;   
        };
        function getFormatDate(date, pattern) {
            if (date == undefined) {
                date = new Date();
            }
            if (pattern == undefined) {
                pattern = "yyyy-MM-dd hh:mm:ss";
            }
            return date.format(pattern);
        };
        var patient = macroElementValue.patient;
        var encounter = macroElementValue.amr;
//        console.log(encounter);
        var temperature=macroElementValue.vitalsign;//生命体征
        var allMacroIds = plugin.GetAllMacro();//获取文档中所有的宏元素id
        var sAllMacroValue = null;//所有宏元素的值
        var allMacroIdKeys = null;//所有宏元素的key（ID）
        var unKnownMacros = '';//未知宏元素id
        var macroConstants = IMER_CONSTANT;//常量
        var allMacroIdsArray = allMacroIds.split("\n");//将宏元素id转换成数组以便遍历
        if(patient){
            self.disposeBySex(plugin, patient.sexCd);//根据性别特殊处理
        }else{
        	Ext.Msg.alert("提示",'病人基本信息不存在，请检查HIS或者CIS视图!');
        	return false;
        }
        for ( var i = 0; i < allMacroIdsArray.length; i++) {
            var macroId = allMacroIdsArray[i];
            var macroValue = null;
            switch (macroId) {
            case macroConstants.MR_ELEMENT_CD_1:
                macroValue = patient.nm; // 患者姓名
                break;
            case macroConstants.MR_ELEMENT_CD_2:// 性别名称
                macroValue = patient.sexNm;
                break;
            case macroConstants.MR_ELEMENT_CD_3: // 年龄
                macroValue = encounter.age;
                break;
            case macroConstants.MR_ELEMENT_CD_4:// 婚姻状况
                macroValue = patient.mariNm;
                break;
            case macroConstants.MR_ELEMENT_CD_5:// 民族
                macroValue = patient.nationNm;
                break;
            case macroConstants.MR_ELEMENT_CD_6:// 职业
                macroValue = patient.occuNm;
                break;
            case macroConstants.MR_ELEMENT_CD_7:// 出生地信息
                macroValue = patient.distNm;
                break;
            case macroConstants.MR_ELEMENT_CD_8:// 工作单位
                macroValue = patient.workOrgNm;
                break;
            case macroConstants.MR_ELEMENT_CD_9:// 身份证号
                macroValue = patient.idCardNo;
                break;
            case macroConstants.MR_ELEMENT_CD_10:// 现住址信息
                macroValue = patient.homeAddress;
                break;
            case macroConstants.MR_ELEMENT_CD_11:// 患者电话
                macroValue = patient.telNo;
                break;
            case macroConstants.MR_ELEMENT_CD_12:// 暂时取的patientId
            	macroValue=patient.paId;
                break;
            case macroConstants.MR_ELEMENT_CD_13:// 住院号
                macroValue = encounter.inpatientNo;
                break;
            case macroConstants.MR_ELEMENT_CD_14:// 住院次数信息
                macroValue = encounter.encounterCount;
                break;
            case macroConstants.MR_ELEMENT_CD_15:// 床号
                macroValue = encounter.currentBedCode;
                break;
            case macroConstants.MR_ELEMENT_CD_16:// 入院时间
                if (encounter.receiveTime != undefined) {
                    macroValue = getFormatDate(new Date(encounter.receiveTime), 'yyyy-MM-dd hh:mm');
                }
                break;
            case macroConstants.MR_ELEMENT_CD_17:// 出院日期
                if (encounter.finishTime != undefined) {
                    macroValue = getFormatDate(new Date(encounter.finishTime), 'yyyy-MM-dd hh:mm');
                }
                break;
            case macroConstants.MR_ELEMENT_CD_18:// 科室
                macroValue = encounter.currentDeptName;
                break;
            case macroConstants.MR_ELEMENT_CD_19:// 病区
                macroValue = encounter.currentDeptName;
                break;
            case macroConstants.MR_ELEMENT_CD_20:// 国籍（不需要）
                break;
            case macroConstants.MR_ELEMENT_CD_21:// 邮编（暂不要）
                break;
            case macroConstants.MR_ELEMENT_CD_22:// 主要诊断（暂不要）
                break;
            case macroConstants.MR_ELEMENT_CD_23:// 费用类型（暂不要）
                break;
            case macroConstants.MR_ELEMENT_CD_24:// 主任医师签名（暂不要）
                break;
            case macroConstants.MR_ELEMENT_CD_25:// 主治医师签名（暂不要）
                break;
            case macroConstants.MR_ELEMENT_CD_26:// 管床医师签名（暂不要）
                break;
            case macroConstants.MR_ELEMENT_CD_27:// 业务时间
                if (data != undefined && data.bizTime != undefined) {
                    macroValue = getFormatDate(new Date(data.bizTime), 'yyyy-MM-dd hh:mm');
                }
                break;
            case macroConstants.MR_ELEMENT_CD_28:// 住院天数
                if (encounter.receiveTime != undefined) {
                    var inpDeptTime=new Date(encounter.receiveTime);
                    var endTime=new Date();
                    
                    if(encounter.encounterStatusCode=='ENM02.04'||encounter.encounterStatusCode=='ENM02.06'){
                    	endTime=new Date(encounter.finishTime);
                    }
                    macroValue=parseInt((endTime-inpDeptTime)/(24*60*60*1000))+1;
                }
                break;
            case macroConstants.MR_ELEMENT_CD_29:// 出生日期
                if (patient.birthday != undefined) {
                    macroValue=getFormatDate(new Date(patient.birthday), 'yyyy-MM-dd');
                }
                break;
            case macroConstants.MR_ELEMENT_CD_30:// 心率
                if (temperature.heartRate) {
                    macroValue=temperature.heartRate;
                }
                break;
            case macroConstants.MR_ELEMENT_CD_31:// 体重
                if (temperature.weight) {
                    macroValue=temperature.weight;
                }
                break;
            case macroConstants.MR_ELEMENT_CD_32:// 上级医生
                if (data != undefined && data.superiorDoctorName!= undefined) {
                    var higherLvlDoctorNm=data.superiorDoctorName;
                    if(higherLvlDoctorNm.indexOf(' ')>0){
                        macroValue=higherLvlDoctorNm.substring(0,higherLvlDoctorNm.indexOf(' '));
                    }else{
                        macroValue=higherLvlDoctorNm;
                    }
                }
                break;
            case macroConstants.MR_ELEMENT_CD_34:// 血氧
            	if (temperature.bldOxygen) {
                    macroValue=temperature.bldOxygen;
                }
                break;
            case macroConstants.MR_ELEMENT_CD_35://患者id
           	 	if(patient.paId!= undefined){
           	 		macroValue = patient.paId;
           	 	}
                break;
            case macroConstants.MR_ELEMENT_CD_36://就诊日期
           	 	if(encounter.receiveTime!= undefined){
           	 		macroValue = getFormatDate(new Date(encounter.receiveTime), CONFIG_PARAM.MR_ELEMENT_RECEIVE_TIME_FORMAT);//wangyanli 20160701 就诊日期格式改为可配置项
           	 	}
                break;
            case macroConstants.MR_ELEMENT_CD_101://体温
                if(temperature.temper){
                    macroValue=temperature.temper;
                }
                break;
            case macroConstants.MR_ELEMENT_CD_102://呼吸
                if(temperature.breathe){
                    macroValue=temperature.breathe;
                }
                break;
            case macroConstants.MR_ELEMENT_CD_103://脉搏
                if(temperature.pulse){
                    macroValue=temperature.pulse;
                }
                break;
            case macroConstants.MR_ELEMENT_CD_104://收缩压
                if(temperature.systolicPress){
                    macroValue=temperature.systolicPress;
                }
                break;
            case macroConstants.MR_ELEMENT_CD_105://舒张压
                if(temperature.diastolicPress){
                    macroValue=temperature.diastolicPress;
                }
                break;
            case macroConstants.MR_ELEMENT_CD_106://上级医师
            	var mr = this.getOwner().medicalRecord;
            	if(mr.superiorDoctorName&&null!=mr.superiorDoctorName){
                    macroValue=mr.superiorDoctorName;
                }
                break;
            case macroConstants.MR_ELEMENT_CD_106://上级医师
            	var mr = this.getOwner().medicalRecord;
            	if(mr.superiorDoctorName&&null!=mr.superiorDoctorName){
                    macroValue=mr.superiorDoctorName;
                }
                break;
            case macroConstants.MR_ELEMENT_CD_107://门诊卡号
            	macroValue = patient.encounterCardNo;
                break;
            case macroConstants.MR_ELEMENT_CD_110://急诊病历编号
                if(macroElementValue.emergencyMrNumber&&macroElementValue.emergencyMrNumber!= undefined){
                    macroValue=macroElementValue.emergencyMrNumber;
                }
                break;
            case macroConstants.MR_ELEMENT_CD_111://全部诊断
                if(macroElementValue.allDiagnosis&&macroElementValue.allDiagnosis!= undefined){
                    macroValue=macroElementValue.allDiagnosis;
                }
                break;
            case macroConstants.MR_ELEMENT_CD_115://户口地址
            	macroValue = patient.idCardAdress;
                break;
            default:
                if (unKnownMacros == '') {
                    unKnownMacros = macroId;
                } else {
                    unKnownMacros = unKnownMacros + ',' + macroId;
                }
            }
            if(macroId!='MR.M.013.D.24'&&macroId!='MR.M.013.D.25'&&macroId!='MR.M.013.D.26'){
            	macroValue=nullToNbsp(macroValue);
                macroValue=trim(macroValue);//delete spaces
            }
            if (macroValue != undefined && macroValue.length != 0) {
            	macroValue=macroValue+'';
            	macroValue=macroValue.replace('&nbsp;',' ');
                if (sAllMacroValue == null) {
                    sAllMacroValue = macroValue;
                } else {
                    sAllMacroValue = sAllMacroValue + '\n' + macroValue;
                }
                if (allMacroIdKeys == null) {
                    allMacroIdKeys = macroId;
                } else {
                    allMacroIdKeys = allMacroIdKeys + '\n' + macroId;
                }
            }
        }
        if (unKnownMacros.length > 1) {
            Ext.MessageBox.alert('错误', '文档中存在未识别的宏元素编码:' + unKnownMacros + '可能是文档中宏元素的版本不对，请联系管理员！');
        }
        if (null != allMacroIdKeys && null != sAllMacroValue){
        	console.log(allMacroIdKeys);
        	console.log(sAllMacroValue);
            plugin.ImportMacroValue(allMacroIdKeys, sAllMacroValue);
        }
        plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrSave', true);
        plugin.UpdateToolbar();
        /*var count=this.getOwner().count;
        console.log('-------------------'+count);
        if(count&&count==2){
        	console.log('----------plugin.EnableOCX(true);---------'+count);
        	plugin.EnableOCX(true);
        }else{
        	this.getOwner().count=count+1;
        }*/
        /*if(this.getOwner().newF==1){
        	//刷新引用元素
   		 	setTimeout(function() {
   		 		var emrRefreshMrDocValue=self.getOwner().getActionChain("emrRefreshMrDocValue");
   		 		emrRefreshMrDocValue.execute();
   		 		self.getOwner().newF==0;
   		 	},100);
        }*/
    },
    /**
     * 性别特殊处理
     * plugin：编辑器插件对象
     * sexCode 男：M,女：F
     */
    disposeBySex: function(plugin,sexCode) {
//    	console.log('-----------------------执行月经史处理：'+sexCode);
        if(sexCode=='M'){
//        	console.log('-----------------------执行删除月经史：'+sexCode);
            plugin.RemoveNamedElement('生育史');
            plugin.RemoveNamedElement('月经史');
        }
    }
});
