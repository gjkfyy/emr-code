Ext.define('iih.mr.tm.mr.action.MrTemplateLoadTreeDataAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

	doExecute: function(context) {
		this.showLoading();
        var operations = context.operations;
        var view = this.getBlock('result').ownerCt;
        var enTypeCode = view.enTypeCode;
        var dctNsF = view.dctNsF;
        var properties = view.getLayer(Xap.ej.block.Layer.PROPERTIES);
        var left = view.getBlock('left');
		var mrTplCCat = left.down('xapcombobox[name=mrTplCCat]');
		var mrTplTypeCd = left.down('xapcombobox[name=mrTplTypeCd]');
		var mrTplStatCd = left.down('xapcombobox[name=mrTplStatCd]');
		var mrTemplateTrigger = left.down('xaptrigger[name=mrTemplateTrigger]');
		var mrTplCCatValue = mrTplCCat.value;
		var mrTplTypeCdValue = mrTplTypeCd.value;
		var mrTplStatCdValue = mrTplStatCd.value;
		var mrTemplateTriggerValue = mrTemplateTrigger.value;
		//树节点选择病历分类编号
		var condition,data;
		if(properties.data != undefined){
			condition = properties.data.condition;
		}else{
			condition = {name:mrTemplateTriggerValue,
	            	mrCategoryCode:mrTplCCatValue,
	            	statusCode:mrTplStatCdValue,
	            	typeCode:mrTplTypeCdValue};
		}
		if(condition.mrCategoryCode == 'ALL' ){
			condition.mrCategoryCode = null ;
			delete condition.mrCategoryCode ;
		}
		if(condition.typeCode == 'ALL' ){
			condition.typeCode = null ;
			delete condition.typeCode ;
		}
		if(condition.statusCode == 'ALL' ){
			condition.statusCode = null ;
			delete condition.statusCode ;
		}

		if(condition.name == undefined || condition.name ==""){
			condition.name = null ;
			delete condition.name ;
		}
		data = {
				condition:condition,
				enTypeCode:enTypeCode,
				dctNsF:dctNsF
		}
        this.prepareOperations(operations,data);    
    }, 
    prepareOperations: function(operations,data) {
    	var condition = data.condition;
    	var enTypeCode = data.enTypeCode;
    	var dctNsF = data.dctNsF;
        var url = this.url+'?enTypeCode='+enTypeCode+'&dctNsF='+dctNsF;
        if(Ext.Object.getSize(condition) > 0 ){
	        var queryString = Ext.Object.toQueryString(condition);
	        url = url + '&'+queryString;
        }

        var mclass = null;        
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: mclass,
            method:METHODS.METHOD_GET,
            condition: null,
            scope: this,
            success: this.onSuccessTree
        };
        operations.push(operation);
    },
       
    onSuccessTree: function(operation) {
        var block = this.getBlock('result');
        var noTree = block.down('xaptree');
        var m = operation; 
        if(m instanceof Ext.data.Model) {
        	gridBlock.setData({
                mclass: operation.mclass,
                data: m.getData(true)
            });
        }else {
        	console.log(operation.result);
        	if(operation.result.root.children){
        		block.setData(operation.result.root.children);
        	}else{
        		block.setData(null);
        	}
        }
        noTree.collapseAll();
        var ownerCode;
        if(operation.result.root.children && operation.result.root.children.length>0){
        	ownerCode = operation.result.root.children[0].data.ownerCode;
        }
//        var chain =  this.getOwner().getActionChain('mrTemplateTreeNodeChange');
//        chain.execute({
//        	ownerCode:ownerCode
//        });
        var view = this.getBlock('result').ownerCt;
        var properties = view.getLayer(Xap.ej.block.Layer.PROPERTIES);
        var left = view.getBlock('left');
		var mrTplCCat = left.down('xapcombobox[name=mrTplCCat]');
		var mrTplTypeCd = left.down('xapcombobox[name=mrTplTypeCd]');
		var mrTplStatCd = left.down('xapcombobox[name=mrTplStatCd]');
		var mrTemplateTrigger = left.down('xaptrigger[name=mrTemplateTrigger]');
		var mrTplCCatValue = mrTplCCat.value;
		var mrTplTypeCdValue = mrTplTypeCd.value;
		var mrTplStatCdValue = mrTplStatCd.value;
		var mrTemplateTriggerValue = mrTemplateTrigger.value;
		var mrTemTree = left.down('xaptree[name=mrTemplate]');  
		var nodeId = mrTemTree.nodeId;
		var condition={},temp,mrCategoryCode,typeCode,path;
		if(typeof(nodeId)!=undefined && nodeId!=null && nodeId!=''){//如果非空
        	temp = nodeId.split('_');
        	if(temp.length==2){
        		ownerCode = temp[temp.length-1];
        	}else if(temp.length==3){
        		ownerCode = temp[temp.length-2];
        		mrCategoryCode = temp[temp.length-1];
        	}else if(temp.length==4){
        		ownerCode = temp[temp.length-3];
        		mrCategoryCode = temp[temp.length-2];
        		typeCode = temp[temp.length-1];
        	}
        }
		if(properties.data != undefined){
			condition = properties.data.condition;
		}else{
			condition = {name:mrTemplateTriggerValue,
	            	mrCategoryCode:mrTplCCatValue,
	            	statusCode:mrTplStatCdValue,
	            	typeCode:mrTplTypeCdValue};
		}
		if(typeof(mrCategoryCode)!=undefined && mrCategoryCode!=null && mrCategoryCode!=''){
			condition.mrCategoryCode = mrCategoryCode;
		}else{
			if(condition.mrCategoryCode == 'ALL' ){
				condition.mrCategoryCode = null ;
				delete condition.mrCategoryCode ;
			}
		}
		if(typeof(typeCode)!=undefined && typeCode!=null && typeCode!=''){
			condition.typeCode = typeCode;
		}else{
			if(condition.typeCode == 'ALL' ){
				condition.typeCode = null ;
				delete condition.typeCode ;
			}
		}
		if(condition.statusCode == 'ALL' ){
			condition.statusCode = null ;
			delete condition.statusCode ;
		}

		if(condition.name == undefined || condition.name ==""){
			condition.name = null ;
			delete condition.name ;
		}
        var gridBlock = view.down('mrtemplatelistblock');
        var pageNum = gridBlock.currentPage;
        var chainList =  this.getOwner().getActionChain('init');
        chainList.execute({
        	pageNum:pageNum,
        	pageSize:'25',
    		statusCode :condition.statusCode,
			mrCategoryCode :condition.mrCategoryCode,
			typeCode :condition.typeCode,
			name:condition.name,
			ownerCode:ownerCode
        });
        if(typeof(typeCode)!=undefined && !Ext.isEmpty(typeCode,false)){
        	path = '/root/_'+ownerCode+'/_'+ownerCode+'_'+mrCategoryCode+'/_'+ownerCode+'_'+mrCategoryCode+'_'+typeCode;
        }else{
        	if(typeof(mrCategoryCode)!=undefined && !Ext.isEmpty(mrCategoryCode,false)){
        		path = '/root/_'+ownerCode+'/_'+ownerCode+'_'+mrCategoryCode;
        	}else{
        		if(typeof(ownerCode)!=undefined && !Ext.isEmpty(ownerCode,false)){
        			path = '/root/_'+ownerCode;
        		}
        	}
        }
//        mrTemTree.expandPath('/root/_004942/_004942_MRM14.02/_004942_MRM14.02_MRM16.14', 'id')
        if(nodeId){
			var r = mrTemTree.getStore().getNodeById(nodeId);
			mrTemTree.getSelectionModel().select(r);
			mrTemTree.expandPath(path, 'id');
		}else{
			mrTemTree.getSelectionModel().select(0);
			mrTemTree.expandPath(path, 'id');
			mrTemTree.nodeId = '_'+ownerCode;
		}
		//var xaptree = this.getBlock('result').down('xaptree');
		/*noTree.expandAll(function(){//树展开所有节点
			//console.trace();
			//alert("xaptree.expandAll");
		});*/
    }/*,
    onExpandPathComplete: function(bSuccess, oLastNode) { 
    	if(!bSuccess) 
    		return;
    	//focus 节点，并选中节点！，以下代码不可少 
    	oLastNode.ensureVisible();
    	oLastNode.select();
    	oLastNode.fireEvent('click', oLastNode);
	}*/
});
