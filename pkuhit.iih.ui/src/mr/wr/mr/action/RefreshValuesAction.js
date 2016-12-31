Ext.define('iih.mr.wr.mr.action.RefreshValuesAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    /*
     * @Override
     */
    execute: function(context) {
        var operations = context.operations;
        if(!operations) {
            return;
        }
        var plugin = document.getElementById('iemrEditor');
        //获取文档中所有引用目标元素的id
        var elemIds=plugin.GetReferenceElem();
        elemIds=elemIds.replace(new RegExp(/(\n)/g),",");
        if(elemIds.length>0){
        	this.prepareOperations(operations,elemIds);
        }
//        Ext.Msg.alert("提示",'刷新宏元素成功!');
//        this.prepareOperations(operations);
    },
    
    prepareOperations: function(operations,elemIds) {
//        var url=this.url+'/'+IMER_GLOBAL.encounterSn;
        var url=this.url+'/'+elemIds+'?enPk='+IMER_GLOBAL.encounterSn;
//        console.log(url);
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
        var macroElementValue=operation.result.data.macroElementValue;
        if(null!=macroElementValue){
        	this.refreshMacroElement(plugin,macroElementValue);
        }
        var mrElemValues=operation.result.data.mrElemValues;
        if(null!=mrElemValues&&mrElemValues.length>0){
        	this.importReferenceElem(plugin,mrElemValues);
        }
    },
    onFail: function(operation) {
        Ext.Msg.alert("提示",'获取宏元素失败!');
    },
    importReferenceElem:function(plugin,elemValues){
    	if (elemValues != null && elemValues.length > 0) {
            for ( var i = 0; i < elemValues.length; i++) {
            	var dataElementId=elemValues[i].dataElementId;
            	var value=elemValues[i].value;
            	//循环遍历引用元素值并刷新文档中的引用目标元素
                plugin.ImportReferenceElem(dataElementId, value);
            }
            plugin.SetModified(false);
        }
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
        }  
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
        var temperature='';//macroElementValue.temperature;
        var allMacroIds = plugin.GetAllMacro();
        var sAllMacroValue = null;
        var allMacroIdKeys = null;
        var unKnownMacros = '';
        var macroConstants = IMER_CONSTANT;
        var allMacroIdsArray = allMacroIds.split("\n");
        if(patient){
            self.disposeBySex(plugin, patient.sexCd);//根据性别特殊处理
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
                macroValue = patient.occupationNm;
                break;
            case macroConstants.MR_ELEMENT_CD_7:// 出生地信息
                macroValue = patient.nativeDistrictNm;
                break;
            case macroConstants.MR_ELEMENT_CD_8:// 工作单位
                macroValue = patient.workOrgNm;
                break;
            case macroConstants.MR_ELEMENT_CD_9:// 身份证号
                macroValue = patient.idCardNo;
                break;
            case macroConstants.MR_ELEMENT_CD_10:// 现住址信息
                macroValue = patient.workAddr;
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
                if (encounter.admissionDay != undefined) {
//                    var inpDeptTime=new Date(encounter.admissionDay);
//                    var encounterEndTime=new Date(encounter.encounterEndTime);
                    macroValue=encounter.admissionDay;
                }
                break;
            case macroConstants.MR_ELEMENT_CD_29:// 出生日期
                if (patient.birthday != undefined) {
                    macroValue=getFormatDate(new Date(patient.birthday), 'yyyy-MM-dd hh:mm');
                }
                break;
            case macroConstants.MR_ELEMENT_CD_30:// 心率
                if (temperature.heart) {
                    macroValue=temperature.heart;
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
            case macroConstants.MR_ELEMENT_CD_101://体温
                if(temperature.bodyTemperature){
                    macroValue=temperature.bodyTemperature;
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
                if(temperature.systolicPressure){
                    macroValue=temperature.systolicPressure;
                }
                break;
            case macroConstants.MR_ELEMENT_CD_105://舒张压
                if(temperature.diagstolicPressure){
                    macroValue=temperature.diagstolicPressure;
                }
                break;
            default:
                if (unKnownMacros == '') {
                    unKnownMacros = macroId;
                } else {
                    unKnownMacros = unKnownMacros + ',' + macroId;
                }
            }
            if (macroValue != undefined && trim(macroValue).length != 0) {
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
            plugin.ImportMacroValue(allMacroIdKeys, sAllMacroValue);
        }
        plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrSave', true);
        plugin.UpdateToolbar();
        plugin.SetModified(false);
        var count=this.getOwner().count;
        console.log(count);
        if(count&&count==3){
        	console.log('----------plugin.EnableOCX(true);---------'+count);
        	plugin.EnableOCX(true);
        }else{
        	this.getOwner().count=count+1;
        }
    },
    /**
     * 性别特殊处理
     * plugin：编辑器插件对象
     * sexCode 男：M,女：F
     */
    disposeBySex: function(plugin,sexCode) {
        if(sexCode=='M'){
            plugin.RemoveNamedElement('生育史');
            plugin.RemoveNamedElement('月经史');
        }
    }
});
