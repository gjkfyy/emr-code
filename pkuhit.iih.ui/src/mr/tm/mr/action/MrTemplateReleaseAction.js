Ext.define('iih.mr.tm.mr.action.MrTemplateReleaseAction', {
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
	    var view = this.getOwner();
	    var properties = view.getLayer(Xap.ej.block.Layer.PROPERTIES);
	    var opType = view.ownerCt.opType;
	    var dataList =[];
	    console.log(opType);
	    var data = {};
	    if(opType!=undefined){
	    	if(view.mrTemplate!=undefined){
	    		data = view.mrTemplate;
	    	}else{
	    		data = properties.owner.ownerCt.data;
	    	}
            data.odtFile = plugin.SaveToString();
            data.statusCode = 'release';
            var code = view.ownerCt.code;
            if(opType == 'new'){
            	data.baseTemplateCode = properties.owner.ownerCt.data.baseTemplateCode;
            	data.name = properties.owner.ownerCt.data.mrTplNm;//"新建";
            	data.description = properties.owner.ownerCt.data.description;
            	if((properties.owner.ownerCt.data.ownerTypeCode==null)||("" ==properties.owner.ownerCt.data.ownerTypeCode)){
            		data.ownerTypeCode = IMER_CONSTANT.OWNERTYPE_HOS;//"MDM08.01";全院
            	}else{
            		data.ownerTypeCode =properties.owner.ownerCt.data.ownerTypeCode;
            	}
            	if(data.ownerTypeCode == IMER_CONSTANT.OWNERTYPE_HOS){
            		data.tplUseTypeCode ="MDM12.01";
            	}
            	if(data.ownerTypeCode == IMER_CONSTANT.OWNERTYPE_DEPT){
            		data.tplUseTypeCode ="MDM12.02";
            	}
            	if(data.ownerTypeCode == IMER_CONSTANT.OWNERTYPE_PERSON){
            		data.tplUseTypeCode ="MDM12.03";
            	}
            	data.ownDeptCd = data.deptCode ;
            	data.tplUseCode = data.ownDeptCd ;
            	data.signLevel = properties.owner.ownerCt.data.signLevelCode;
            	
            	if((properties.owner.ownerCt.data.mrTypeCd==null)||("" ==properties.owner.ownerCt.data.mrTypeCd)){
            		//alert(properties.owner.data.mrTypeCd);
            		data.mrTypeCode ="MRM16.13";;//"MRM01.02";全院
            	}else{
            		//alert(properties.owner.data.mrTypeCd);
                    data.mrTypeCode = properties.owner.ownerCt.data.mrTypeCd//"MRM01.02";
            	}
            	if((properties.owner.ownerCt.data.diCds==null)||("" ==properties.owner.ownerCt.data.diCds)){
            		//alert(properties.owner.data.mrTypeCd);
            		data.diCds ="N93.801";;//"N93.801"
            	}else{
                    data.diCds =properties.owner.ownerCt.data.diCds
            	}
                this.addPrepareOperations(operations,data);
            }else if(opType == 'open'){
            	dataList.push(code);
            	data ={"ids":dataList};
                this.openPrepareOperations(operations, data);
            }
        }
    },
    
    addPrepareOperations: function(operations,data) {
        var METHODS = this.getInvocationMethods();
        var url = this.url;
        console.log(url);
        var operation = {
            url: url,
            method: METHODS.METHOD_CREATE,
            data:data,
            scope: this,
            success: this.onAddSuccess,
            fail: this.onFail
        };
        operations.push(operation);
    },
    
    openPrepareOperations: function(operations,data) {
        var METHODS = this.getInvocationMethods();
        var code = data.code;
        var url = 'mr/tpl/activated/template';
        var operation = {
            url: url,
            method: METHODS.METHOD_CREATE,
            data:data,
            scope: this,
            success: this.onOpenSuccess,
            fail: this.onFail
        };
        operations.push(operation);
    },
    onOpenSuccess: function(operation) {
    	var plugin = document.getElementById('iemrEditor');
    	var emrSave = 'com.founder.iemr.editor.toolbar:emrSave';//保存
        var emrRelease = 'com.founder.iemr.editor.toolbar:emrRelease';//保存
		plugin.SetCommandEnable(emrSave,false);
		plugin.SetCommandEnable(emrRelease,false);
		plugin.UpdateToolbar();
    	var msg = '启用成功!!!';
		XapMessageBox.info(msg);
    },
    onAddSuccess: function(returnData) {
        this.getOwner().opType='open';
        this.getOwner().mrTemplateCd = returnData.result.mrTplVerKc;
        var plugin = document.getElementById('iemrEditor');
        var emrSave = 'com.founder.iemr.editor.toolbar:emrSave';//保存
        var emrRelease = 'com.founder.iemr.editor.toolbar:emrRelease';//保存
		plugin.SetCommandEnable(emrSave,false);
		plugin.SetCommandEnable(emrRelease,false);
		plugin.UpdateToolbar();
        var msg = '启用成功!!!';
		XapMessageBox.info(msg);
    },
    onFail: function(operation) {
    	var msg = '启用失败!!!';
		XapMessageBox.info(msg);
    }
        
});
