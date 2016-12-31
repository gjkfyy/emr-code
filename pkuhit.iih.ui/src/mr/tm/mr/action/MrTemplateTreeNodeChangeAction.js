Ext.define('iih.mr.tm.mr.action.MrTemplateTreeNodeChangeAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
    doExecute: function(context) {
    	this.showLoading();
        var operations = context.operations; 
        var view = this.getOwner();
        var treeBlock = view.down('mrtemplateTreeBlock');
        console.log('------------------- MrTemplateTreeNodeChangeAction ------------------------');
        var mrTplCCat = treeBlock.down('xapcombobox[name=mrTplCCat]');
		var mrTplTypeCd = treeBlock.down('xapcombobox[name=mrTplTypeCd]');
		var mrTplStatCd = treeBlock.down('xapcombobox[name=mrTplStatCd]');
		var mrTemplateTrigger = treeBlock.down('xaptrigger[name=mrTemplateTrigger]');
		var mrTplCCatValue = mrTplCCat.value;//自定义类型
		var mrTplTypeCdValue = mrTplTypeCd.value;//病历类型
		var mrTplStatCdValue = mrTplStatCd.value;//模板状态
		var mrTemplateTriggerValue = mrTemplateTrigger.value;//名称
        var block = this.getBlock('right');
        var layout = block.getLayout();
        var treeNode,data,evn,treeTem,nodeId;
        if(context.event != undefined){
        	treeNode = context.event.arguments[1];
            data = treeNode.raw.data;
        }else{
        	data={};
        	data.ownerCode = context.ownerCode;
        }
        var operations = context.operations;
        /*if(mrTplCCatValue == 'ALL'){
			mrTplCCatValue = '';
		}else{
			data.templateCategoryCode = mrTplCCatValue;
		}
        if(mrTplTypeCdValue == 'ALL'){
        	mrTplTypeCdValue = '';
		}else{
			data.templateCategoryCode = mrTplTypeCdValue;
		}*/
        if(mrTplStatCdValue == 'ALL'){
        	mrTplStatCdValue = '';
		}
		data.statusCode = mrTplStatCdValue;
        if(mrTemplateTriggerValue == undefined){
        	mrTemplateTriggerValue = '';
		}
		data.name = mrTemplateTriggerValue;
        this.prepareOperations(operations,data);
    	layout.setActiveItem(0);
        /*if(treeNode.data.leaf==true){
        	var gridBlock = block.down('mrtemplateeditview')
        	//console.log(context.event.arguments[1].raw.data.templateCode);
        	var code = context.data.data.code;
        	var filePk = context.data.data.filePk;
        	//console.log(context.data);
        	var properties = gridBlock.getLayer(Xap.ej.block.Layer.PROPERTIES);
            properties.setData({
            	opType: 'open',  
            	filePk:filePk,
                code:code
            });
            //先remove掉编译器打开的odt
            var owner = this.getOwner();
            var chain = owner.getActionChain('beforeActivate');
            chain.execute();
            layout.setActiveItem(1);
        }else{
        	//点击非叶子结点，对树进行查询
        	//按条件查询，修改列表显示
            console.log(context.event.arguments[1]);
            var operations = context.operations;      
            var data = treeNode.raw.data;
            console.log(data);
            this.prepareOperations(operations,data);
        	layout.setActiveItem(0);
        } */       
    }, 
    prepareOperations: function(operations,data) { 
    	var typeCode = data.templateTypeCode;
    	if(Ext.isEmpty(typeCode,false)){
    		typeCode = data.scTemplateTypeCode;
    	}
    	var mrCategoryCode = data.templateCategoryCode;
    	if(Ext.isEmpty(mrCategoryCode,false)){
    		mrCategoryCode = data.scTemplateCategoryCode;
    	}
    	var ownerCode = data.ownerCode;
    	var sourceView = this.getOwner();
		var enTypeCode = sourceView.enTypeCode;
		var dctNsF = sourceView.dctNsF;
		var statusCode = data.statusCode;
		var name = data.name;
//    	typeCode = "MRM11.01";
        var url = this.url ;//+'?typeCode='+typeCode+'&mrCategoryCode='+mrCategoryCode+'&ownerCode='+ownerCode+'&enTypeCode='+enTypeCode;  
        var searchParam = {
				pageNum : 1,
				pageSize : 25,
        		typeCode:typeCode,//病历类型
        		statusCode:statusCode,//状态码
        		name:name,//
        		mrCategoryCode:mrCategoryCode,//自定义分类
        		ownerCode:ownerCode,//所属编码
        		enTypeCode:enTypeCode,//就诊类型
        		dctNsF:dctNsF
        }
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_GET,
            params: searchParam,
            data:null,
            scope: this,
            success: this.onSuccess,
            //fail: this.onFail
        };
        operations.push(operation);	    
	 },
	    
	 onSuccess: function(operation) {
	        var block = this.getBlock('right');
	        var gridBlock =block.down('mrtemplatelistblock');
	       //保存查询参数到store中
			Ext.apply( 
            	gridBlock.store.lastOptions,  
                {   // 把查询条件放到ds的参数对象中 
            		sourceEvent:'treeNodeItemClick',
                    params : operation.params
                } 
            );
	        
	        var m = operation.result;
	        // TODO 数据格式就这样了？
	        if(m instanceof Ext.data.Model) {
	        	gridBlock.setData({
	                mclass: operation.mclass,
	                data: m.getData(true)
	            });
	        }else{        
	        	console.log(m);
	        	gridBlock.setGridData(m);
	        }
			var chain =  this.getOwner().getActionChain('selectionchange');
            chain.execute();
	 }     
});
