Ext.define('iih.mr.tm.mr.action.ConfimTemplatePropertyEditAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	doExecute: function(context) {
	   this.callParent();
	   console.log('--------------------- ConfimTemplatePropertyEditAction -----------------------------');
	   var operations = context.operations;
       var properties = this.getOwner().getLayer(Xap.ej.block.Layer.PROPERTIES);
       console.log(properties);
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
       data.diCds = properties.data.diCds;
       
       //修改内容
       data.code = data.verMrTplKc;//医疗记录模板编码
       data.name = data.mrTplNm;//名称
       data.mrTypeCode = data.mrTypeCd;//医疗记录类型编码
       data.baseFile = data.basetemplatefilePk;//文件流对象
       var view = this.getOwner();
       var owner = properties.data.sourceView;
       if(typeof(data.enTypeCode)==undefined && Ext.isEmpty(data.enTypeCode,false)){
    	   data.enTypeCode = owner.enTypeCode;
       }
       if(properties.data.customerData=='new' || properties.data.customerData=='saveAs'){
    	   var page = owner.ownerCt;
    	   var workpageview = page.items.items[1];
           if(workpageview){
	           	var mrSn = workpageview.filePk;
	           	var pk = data.basetemplatefilePk;
	           	if(properties.data.customerData=='new'){
	           		if(mrSn!=pk){
		           		page.remove(workpageview);
		           	}
	           	}else if(properties.data.customerData=='saveAs'){
	           		var plugin = document.getElementById('iemrEditor');
	           		data.odtFile = plugin.SaveToString();
	           		data.xmlFile = plugin.ExportXML();
	           		page.remove(workpageview);
	           	}
           }
           var canvas = Xap.getCanvas();            
           var config = {
        		   pageCode:'mrtpleditview',
                   xclass: 'iih.mr.tm.mr.view.MrTemplateEditView',
                   pageTitle: data.mrTplNm,
                   viewConfig:{
                       opType:properties.data.customerData,
                       emrPrintSelected:this.getOwner().emrPrintSelected,
                       data:data
                   }
           };       
           canvas.fireEvent("addWorkPage",config);
           //this.addOperations(operations,data);
       } else if(properties.data.customerData=='edit'){
    	   if((data.ownerTypeCode==null)||("" ==data.ownerTypeCode)){
	       		data.ownerTypeCode = IMER_CONSTANT.OWNERTYPE_HOS;//"MDM08.01";全院
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
	       data.ownDeptCd = data.deptCode;
	       data.tplUseCode = data.ownDeptCd;
	       data.signLevel = data.signLevelCode;
           this.prepareOperations(operations,data);
       }
	},
    addOperations: function(operations,data) {
        var condition = data;
        var url = this.url;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_CREATE,
            condition: null,
            data:condition,
            scope: this,
            success: this.onSuccess,
            fail: this.onFail
        };
        operations.push(operation);
    },
    onSuccess: function() {
        //调用模板列表刷新页面
        var properties = this.getOwner().getLayer(Xap.ej.block.Layer.PROPERTIES);
        var view = properties.data.sourceView;
        if(view.tabId!='mrtpleditview'){
        	var chain = view.getActionChain('init');
            var treeBlock = view.down('mrtemplateTreeBlock');
            var mrTplCCat = treeBlock.down('xapcombobox[name=mrTplCCat]');
     		var mrTplTypeCd = treeBlock.down('xapcombobox[name=mrTplTypeCd]');
     		var mrTplStatCd = treeBlock.down('xapcombobox[name=mrTplStatCd]');
     		var mrTemplateTrigger = treeBlock.down('xaptrigger[name=mrTemplateTrigger]');
     		var mrTplCCatValue = mrTplCCat.value;
     		var mrTplTypeCdValue = mrTplTypeCd.value;
     		var mrTplStatCdValue = mrTplStatCd.value;
     		var mrTemplateTriggerValue = mrTemplateTrigger.value;
             var gridBlock = view.down('mrtemplatelistblock');
             var pageNum = gridBlock.currentPage;
             if(!chain) {
                 //如果没找到chain执行结果
                 console.log("faile");   
             }
             console.log(chain);
             if(chain) {
                 chain.execute({
                 	pageNum:pageNum,
                 	pageSize:'25',
             		statusCode :mrTplStatCdValue,
     				mrCategoryCode :mrTplCCatValue,
     				typeCode :mrTplTypeCdValue,
     				name:mrTemplateTriggerValue
                 });
             }
        }
    },
    onFail: function(operation) {
        var message = '新增失败!!!';
        XapMessageBox.info(message);
    },    
    prepareOperations: function(operations,data) {
    	console.log(data);
        var url = this.url+'/'+data.verMrTplKc;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_UPDATE,
            condition: null,
            data:data,
            scope: this,
            success: this.onSuccess
            // fail: this.onFail
        };
        operations.push(operation);
    }        
});
