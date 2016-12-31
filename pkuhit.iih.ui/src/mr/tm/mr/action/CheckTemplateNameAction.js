Ext.define('iih.mr.tm.mr.action.CheckTemplateNameAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	doExecute: function(context) {
		this.callParent();
	   	var operations = context.operations;
	   	var view = this.getOwner();
	   	var rs = this.getBlock('result').ownerCt;      
       	//向后台发送form表单   
       	var form = this.getBlock('result').getForm();
       	//拿到的form的value有问题       
       	var data = this.getBlock('result').getForm().getValues();
       	if((data!=undefined)||(data!=null)){
           data = this.getBlock('result').getForm().getValues();
       	}else{
           data = null;
       	}
       	var msgInfo = view.down('xapdisplayfield[name=msgInfo]');
       	//基础模板文件主键
       	var comboboxBaseTemplateCode,properties,errorText;
       	if(data.mrTypeCd!=undefined && !Ext.isEmpty(data.mrTypeCd,false)){//判断病历文书类型不能为空
       		if(data.baseTemplateCode!=undefined && !Ext.isEmpty(data.baseTemplateCode,false)){//判断基础摸板不能为空
       			if(data.mrTplNm!=undefined && !Ext.isEmpty(data.mrTplNm,false)){//判断模板名称不能为空
       				//if(data.diCds!=undefined && !Ext.isEmpty(data.diCds,false)){//判断适应病种不能为空
       					if(data.ownerTypeCode!=undefined && !Ext.isEmpty(data.ownerTypeCode,false)){//判断模板所属类别不能为空
       						if(data.deptCode!=undefined && !Ext.isEmpty(data.deptCode,false)){//判断模板所属不能为空
       							if(data.signLevelCode!=undefined && !Ext.isEmpty(data.signLevelCode,false)){//判断审签级别不能为空
       								comboboxBaseTemplateCode =  this.getOwner().getBlock('content').down('[name=baseTemplateCode]') ;
       						   	   	properties = this.getOwner().getLayer(Xap.ej.block.Layer.PROPERTIES);
       						       	if(properties.data.customerData=='new'){
       						       		data.basetemplatefilePk = comboboxBaseTemplateCode.lastSelection[0].raw.filePk ;
       						       	}else if(properties.data.customerData == 'saveAs'){
       						       		data.basetemplatefilePk = properties.data.sourceView.filePk;
       						       	}else if(properties.data.customerData == 'mrSaveAs'){
       						       		data.basetemplatefilePk = properties.data.sourceView.medicalRecord.filePk;
       						       	}
       						       	//数据存储在properties对象
       						       	properties.data.baseTemplateCode = data.baseTemplateCode;
       						   		properties.data.basetemplatefilePk = data.basetemplatefilePk;
       						   		properties.data.deptCode = data.deptCode;
       						   		properties.data.xmlFilePk = data.xmlFilePk;
       						   		properties.data.description = data.description;
       						   		properties.data.enTypeCode = data.enTypeCode;
       						   		properties.data.mrTplNm = data.mrTplNm;
       						   		properties.data.mrTypeCd = data.mrTypeCd;
       						   		properties.data.ownDeptCd = data.ownDeptCd;
       						   		properties.data.ownerTypeCd = data.ownerTypeCd;
       						   		properties.data.ownerTypeCode = data.ownerTypeCode;
       						   		properties.data.signLevelCode = data.signLevelCode;
       						   		properties.data.verMrTplKc = data.verMrTplKc;
       						   		properties.data.diCds = data.diCds;
       						   		var params={};
       						   		if(properties.data.customerData=='edit'){
       						   			params = {code:data.verMrTplKc,name:data.mrTplNm,ownDeptCd:data.deptCode};
       						   		}else{
       						   			params = {name:data.mrTplNm,ownDeptCd:data.deptCode};
       						   		}
       						   		this.CheckTemplateName(operations, params);
       	           	       		}else{
       	           	       			errorText = '审签级别不能为空，请选择！';
       	           	           		msgInfo.setValue('<font color=red>' + errorText + '</font>');
       	           	           		return;
       	           	           	}
               	       		}else{
               	       			errorText = '模板所属不能为空，请选择！';
               	           		msgInfo.setValue('<font color=red>' + errorText + '</font>');
               	           		return;
               	           	}
           	       		}else{
           	       			errorText = '模板所属类别不能为空，请选择！';
           	           		msgInfo.setValue('<font color=red>' + errorText + '</font>');
           	           		return;
           	           	}
       	       		/*}else{
       	       			errorText = '适应病种不能为空，请选择！';
       	           		msgInfo.setValue('<font color=red>' + errorText + '</font>');
       	           		return;
       	           	}*/
           		}else{
           			errorText = '模板名称不能为空，请输入！';
               		msgInfo.setValue('<font color=red>' + errorText + '</font>');
               		return;
               	}
       		}else{
       			errorText = '基础模板不能为空，请选择！';
           		msgInfo.setValue('<font color=red>' + errorText + '</font>');
           		return;
           	}
       	}else{
       		errorText = '病历文书类型不能为空，请选择！';
       		msgInfo.setValue('<font color=red>' + errorText + '</font>');
       		return;
       	}
	},
    CheckTemplateName: function(operations,params) {
        var url = this.url;
//        console.log(url);
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_GET,
            params: params,
            scope: this,
            success: this.onTemplateSuccess,
            fail: this.onFail
        };
        operations.push(operation);
    },
    onTemplateSuccess: function(returnData) {
    	var view = this.getOwner();
    	var chain = view.getActionChain('check');
    	var isexist = returnData.result.data;
    	if(!isexist){
    		chain.execute();
    	}else{
    		var msg = '病历模板名称重复，请重新输入!!!';
    		XapMessageBox.info(msg);
    	}
    },
    onFail: function(operation) {
    	var msg = '验证失败!!!';
    	XapMessageBox.info(msg);
    }
});
