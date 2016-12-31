Ext.define('iih.mr.tm.mr.action.CheckTemplateRoleAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	doExecute: function(context) {
	   this.callParent();
	   var operations = context.operations;
	   var view = this.getOwner();
	   var properties = view.getLayer(Xap.ej.block.Layer.PROPERTIES);
	   var data = {};
       data.baseTemplateCode = properties.data.baseTemplateCode;//医疗记录基础模板编码
       data.basetemplatefilePk = properties.data.basetemplatefilePk;
       data.filePk = properties.data.basetemplatefilePk;//文件主键
       data.xmlFilePk = properties.data.xmlFilePk;//文件主键
       data.customerData = properties.data.customerData;//文件主键
       data.deptCode = properties.data.deptCode;
       data.description = properties.data.description;//描述
       data.mrTplNm = properties.data.mrTplNm;
       data.mrTypeCd = properties.data.mrTypeCd;
       data.ownDeptCd = properties.data.ownDeptCd;
       data.ownerTypeCd = properties.data.ownerTypeCd;
       data.ownerTypeCode = properties.data.ownerTypeCode;//所属类型编码
       data.signLevelCode = properties.data.signLevelCode;
       data.verMrTplKc = properties.data.verMrTplKc;
       data.enTypeCode = properties.data.enTypeCode;
       data.ownerCode = properties.data.ownerCode;
       data.diCds = properties.data.diCds;
       //修改内容
       data.code = data.verMrTplKc;//医疗记录模板编码
       data.name = data.mrTplNm;//名称
       data.mrTypeCode = data.mrTypeCd;//医疗记录类型编码
       data.baseFile = data.basetemplatefilePk;//文件流对象
       var owner = properties.data.sourceView;
       data.enTypeCode = owner.enTypeCode;
       var chain = view.getActionChain('confim');
       if(properties.data.customerData=='new' || properties.data.customerData=='saveAs'){
      		this.CheckOperations(operations,data);
		}else if(properties.data.customerData=='mrSaveAs'){
			this.getOwner().ownerCt.close();
			var plugin = document.getElementById('iemrEditor');
			var allMacroIds = plugin.GetAllMacro();
			//设置可编辑
			plugin.EditDocument();
			//清空红元素
			plugin.ClearMacroValue(allMacroIds);                                        
			data.odtFile = plugin.SaveToString();  
			data.xmlFile = plugin.ExportXML();
			//设置只读
			plugin.SetReadOnly(); 
           
	       	data.baseTemplateCode = properties.data.baseTemplateCode;
	       	data.name = properties.data.mrTplNm;//"新建";
	       	data.description = properties.data.description;
	       	if((properties.data.ownerTypeCode==null)||("" ==properties.data.ownerTypeCode)){
	       		data.ownerTypeCode =IMER_CONSTANT.OWNERTYPE_HOS;//"MDM08.01";全院
	       	}else{
	       		data.ownerTypeCode = properties.data.ownerTypeCode;
	       	}
	       	if(data.ownerTypeCode == IMER_CONSTANT.OWNERTYPE_HOS){
	       		data.tplUseTypeCode = IMER_CONSTANT.OWNERTYPE_HOS;
	       	}
	       	if(data.ownerTypeCode == IMER_CONSTANT.OWNERTYPE_DEPT){
	       		data.tplUseTypeCode ="MDM12.02";
	       	}
	       	if(data.ownerTypeCode == IMER_CONSTANT.OWNERTYPE_PERSON){
	       		data.tplUseTypeCode ="MDM12.03";
	       	}
	       	data.deptCode = IMER_GLOBAL.user.code;
	       	data.ownDeptCd = data.deptCode ;
	       	data.tplUseCode = data.ownDeptCd ;
	       	data.signLevel = properties.data.signLevelCode;
	       	
	       	if((properties.data.mrTypeCd==null)||("" ==properties.data.mrTypeCd)){
	       		//alert(properties.owner.data.mrTypeCd);
	       		data.mrTypeCode ="MRM16.13";;//"MRM01.02";全院
	       	}else{
	       		//alert(properties.owner.data.mrTypeCd);
	               data.mrTypeCode = properties.data.mrTypeCd//"MRM01.02";
	       	}
	       	if((properties.data.diCds==null)||("" ==properties.data.diCds)){
	       		//alert(properties.owner.data.mrTypeCd);
	       		data.diCds ="";;//由"N93.801"改为字符串空，modify by guo-zhongbao 2016-09-08 ，后端来判空
	       	}else{
	               data.diCds =properties.data.diCds
	       	}
	       	data.statusCode = 'MRM07.05';
			this.MrSaveAsOperations(operations,data);
		}else{
			this.CheckPropertyOperations(operations,data);
		}
	},
    MrSaveAsOperations: function(operations,data) {
        var url = 'mr/tpl/template';
//      console.log(url);
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_CREATE,
            data: data,
            scope: this,
            success: this.onSuccessSaveAs,
            fail: this.onFailSaveAs
        };
        operations.push(operation);
    },
    onSuccessSaveAs: function(returnData) {
    	var properties = this.getOwner().getLayer(Xap.ej.block.Layer.PROPERTIES);
    	var sourceView = properties.data.sourceView;
    	var pk = sourceView.medicalRecord.mrPk;
    	var name = sourceView.medicalRecord.name;
 	    var workpageview = sourceView.ownerCt.ownerCt;
        if(workpageview){
        	workpageview.ownerCt.remove(workpageview);
        }
        var canvas = Xap.getCanvas();
        var config = {
                pageCode: 'mrdoceditview',
                xclass: 'iih.mr.wr.mr.view.MrDocEditView',
                pageTitle: name,
                viewConfig:{
                    mrSn:pk,
                    opType:'open'
                },
                assistantConfig:{
                    tgtObCd: 'MRB02',
                    tgtObPk: pk
                }
        };       
        canvas.fireEvent("addWorkPage",config);
    },
    onFailSaveAs: function(returnData) {
    	var msg = '模板另存失败!!!';
		XapMessageBox.info(msg);
    },
    CheckOperations: function(operations,data) {
        var ownerTypeCode = data.ownerTypeCode;
        var ownDeptCd = data.deptCode;
        var url = this.url+'?ownerTypeCode='+ownerTypeCode+'&ownDeptCd='+ownDeptCd;
//        console.log(url);
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_GET,
            condition: null,
            scope: this,
            success: this.onSuccess,
            fail: this.onFail
        };
        operations.push(operation);
    },
    onSuccess: function(returnData) {
    	var properties = this.getOwner().getLayer(Xap.ej.block.Layer.PROPERTIES);
    	var view = this.getOwner();
    	var chain = view.getActionChain('confim');
    	var isexist = returnData.result.data;
    	if(isexist){
    		this.getOwner().ownerCt.close();
    		chain.execute();
    	}else{
    		var ownerTypeCode = properties.data.ownerTypeCode;
    		var msg;
    		if(ownerTypeCode == 'MDM08.01'){
    			msg = '没有权限创建全院病历模板!!!';
    		}else if(ownerTypeCode == 'MDM08.02'){
    			msg = '没有权限创建科室病历模板!!!';
    		}else{
    			msg = '没有权限创建病历模板!!!';
    		}
    		XapMessageBox.info(msg);
    	}
    },
    CheckPropertyOperations: function(operations,data) {
        var ownerTypeCode = data.ownerTypeCode;
        var ownDeptCd = data.deptCode;
        var url = this.url+'?ownerTypeCode='+ownerTypeCode+'&ownDeptCd='+ownDeptCd;
//        console.log(url);
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_GET,
            condition: null,
            scope: this,
            success: this.onSuccessProperty,
            fail: this.onFail
        };
        operations.push(operation);
    },
    onSuccessProperty: function(returnData) {
    	var properties = this.getOwner().getLayer(Xap.ej.block.Layer.PROPERTIES);
    	var view = this.getOwner();
    	var chain = view.getActionChain('confim');
    	var isexist = returnData.result.data;
    	if(isexist){
    		this.getOwner().ownerCt.close();
    		chain.execute();
    	}else{
    		var ownerTypeCode = properties.data.ownerTypeCode;
    		var msg;
    		if(ownerTypeCode == 'MDM08.01'){
    			msg = '没有权限修改模板所属类型为全院!!!';
    		}else if(ownerTypeCode == 'MDM08.02'){
    			msg = '没有权限修改模板所属类型为科室!!!';
    		}else{
    			msg = '没有权限修改病历模板属性!!!';
    		}
    		XapMessageBox.info(msg);
    	}
    },
    onFail: function(operation) {
    	var msg = '验证失败!!!';
    	XapMessageBox.info(msg);
    }
});
