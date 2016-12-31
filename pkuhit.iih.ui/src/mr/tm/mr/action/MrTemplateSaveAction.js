Ext.define('iih.mr.tm.mr.action.MrTemplateSaveAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	requires: ['iih.po.com.view.ResourceNavigationView'],
	/*
	 * @Override
	 */
	execute: function(context) {
	    var operations = context.operations;
        if(!operations) {
            return;
        }
        console.log('------------------------ MrTemplateSaveAction -----------------------------------');
        var plugin = document.getElementById('iemrEditor');
	    plugin.tagName='ext';
	    var view = this.getOwner().ownerCt;
	    var properties = this.getOwner().getLayer(Xap.ej.block.Layer.PROPERTIES);
	    var opType = view.opType;
	    var data ={'odtFile':plugin.SaveToString()};
	    if(opType!=undefined){
	    	this.showSubmitProgressBar();
            if(opType=='new' || opType=='saveAs'){
            	var properties = view.getLayer(Xap.ej.block.Layer.PROPERTIES);
            	var mView = properties.owner;
                data = mView.data;
            	data.baseTemplateCode = mView.data.baseTemplateCode;
            	data.name = mView.data.mrTplNm;//"新建";
            	data.description = mView.data.description;
            	if((mView.data.ownerTypeCode==null)||("" ==mView.data.ownerTypeCode)){
            		data.ownerTypeCode = IMER_CONSTANT.OWNERTYPE_HOS;//"MDM08.01";全院
            	}else{
            		data.ownerTypeCode =mView.data.ownerTypeCode;
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
            	data.signLevel = mView.data.signLevelCode;
            	
            	if((mView.data.mrTypeCd==null)||("" ==mView.data.mrTypeCd)){
            		//alert(mView.data.mrTypeCd);
            		data.mrTypeCode ="MRM16.13";;//"MRM01.02";全院
            	}else{
            		//alert(mView.data.mrTypeCd);
                    data.mrTypeCode = mView.data.mrTypeCd//"MRM01.02";
            	}
            	if((mView.data.diCds==null)||("" ==mView.data.diCds)){
            		//alert(mView.data.mrTypeCd);
            		data.diCds ="";
            	}else{
                    data.diCds =mView.data.diCds;
            	}
                
                //delete  data.data;//删除多余的json对象
                data.odtFile = plugin.SaveToString();
                if(data.odtFile == null || data.odtFile == ""){
                	data.odtFile = context.odtFile;
                }
                data.xmlFile = plugin.ExportXML();
                if(data.xmlFile == null || data.xmlFile == ""){
                	data.xmlFile = context.xmlFile;
                }
                this.addPrepareOperations(operations,data);
            }else if(opType=='open'){
                data.actionType = 'save';
                data.code = view.code;
                data.filePk = view.filePk;
                data.xmlFilePk = view.xmlFilePk;
                data.xmlFile = plugin.ExportXML();
                //Xap.debug('模板编码：'+data.code);
                this.openPrepareOperations(operations, data);
            }
        }
    },
    
    addPrepareOperations: function(operations,data) {
        var METHODS = this.getInvocationMethods();
        var url=this.url;
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
    	var code  = data.code;
        var METHODS = this.getInvocationMethods();
        var url = this.url+"/"+code;
        var operation = {
            url: url,
            method: METHODS.METHOD_UPDATE,
            data:data,
            scope: this,
            success: this.onOpenSuccess,
            fail: this.onFail
        };
        operations.push(operation);
    },
    onOpenSuccess: function(operation) {
    	var mrTemplateEditPage = this.getOwner().ownerCt,chain,basCode,code;
    	if(mrTemplateEditPage.templateReset!=undefined && !Ext.isEmpty(mrTemplateEditPage.templateReset,false) && mrTemplateEditPage.templateReset=='reset'){
    		//保存基础模板的code
        	chain = mrTemplateEditPage.getActionChain('saveBaseCode');
        	code = mrTemplateEditPage.code;
        	baseCode = mrTemplateEditPage.baseTemplateCode;
        	if(!chain) {
                 //如果没找到chain执行结果
                 console.log("faile");   
            }
            if(chain) {
                 chain.execute({
                 	code:code,
                 	baseCode:baseCode
                 });
            }
    	}
    },
    onAddSuccess: function(returnData) {
    	var mrTemplateEditPage = this.getOwner().ownerCt,chain,code,baseCode;
    	if(mrTemplateEditPage.templateReset!=undefined && !Ext.isEmpty(mrTemplateEditPage.templateReset,false) && mrTemplateEditPage.templateReset=='reset'){
    		//保存基础模板的code
        	chain = mrTemplateEditPage.getActionChain('saveBaseCode');
        	code = mrTemplateEditPage.code;
        	baseCode = mrTemplateEditPage.baseTemplateCode;
        	if(!chain) {
                 //如果没找到chain执行结果
                 console.log("faile");   
            }
            if(chain) {
                 chain.execute({
                 	code:code,
                 	baseCode:baseCode
                 });
            }
    	}
    	mrTemplateEditPage.opType = 'open';
    	mrTemplateEditPage.filePk = returnData.result.data.filePk;
    	mrTemplateEditPage.code = returnData.result.data.code;
    	mrTemplateEditPage.mrTypeCode = returnData.result.data.mrTypeCode;
    	mrTemplateEditPage.enTypeCode = returnData.result.data.enTypeCode;
    	mrTemplateEditPage.mrTemplate = returnData.result.data;
    	var plugin = document.getElementById('iemrEditor');
    	var emrSaveAs = 'com.founder.iemr.editor.toolbar:emrSaveAs';//保存
		plugin.SetCommandEnable(emrSaveAs,true);
		plugin.UpdateToolbar();
    },
    onFail: function(operation) {
    }
});
