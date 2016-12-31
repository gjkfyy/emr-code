Ext.define('iih.mr.tm.mr.action.MrTemplateListSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	requires: ['Xap.ej.block.Layer'],

	doExecute: function(context) {
		this.showLoading();
	    this.callParent();
	    console.log('------------------------ MrTemplateListSearchAction ----------------------------');
	    var sourceView = this.getOwner();
		var enTypeCode = sourceView.enTypeCode;
		var dctNsF = sourceView.dctNsF;
		var eventName,pageNum,pageSize,condition,block;
		if(context.event != undefined){
			eventName = context.event.name ;
		}
		var data = null ;
		var left = this.getBlock('left');
		var view = left.ownerCt;
		var mrTplCCat = left.down('xapcombobox[name=mrTplCCat]');
		var mrTplTypeCd = left.down('xapcombobox[name=mrTplTypeCd]');
		var mrTplStatCd = left.down('xapcombobox[name=mrTplStatCd]');
		var mrTemplateTrigger = left.down('xaptrigger[name=mrTemplateTrigger]');
		var xaptreemrTemplate = left.down('xaptree[name=mrTemplate]');    
		var mrTplCCatValue = mrTplCCat.value;
		var mrTplTypeCdValue = mrTplTypeCd.value;
		var mrTplStatCdValue = mrTplStatCd.value;
		var mrTemplateTriggerValue = mrTemplateTrigger.value;
		//var chain = view.getActionChain('initTree');
		var properties = view.getLayer(Xap.ej.block.Layer.PROPERTIES);
		block = this.getBlock('result');
		//获取模板列表组件	
		grid = block.down('mrtemplatelistblock');
		var nodeId = xaptreemrTemplate.nodeId;
		var temp,nodeClick,ownerCode,mrCategoryCode,typeCode;
		if(typeof(nodeId)!=undefined && nodeId!=null && nodeId!=''){//如果非空
        	temp = nodeId.split('_');
        	if(temp.length==2){
        		ownerCode = temp[temp.length-1];
        	}else if(temp.length==3){
        		ownerCode = temp[temp.length-2];
        		mrCategoryCode = temp[temp.length-1];
        		if(mrTplCCatValue == 'ALL' ){
        			mrTplCCatValue = mrCategoryCode;
        		}
        	}else if(temp.length==4){
        		ownerCode = temp[temp.length-3];
        		mrCategoryCode = temp[temp.length-2];
        		typeCode = temp[temp.length-1];
        		if(mrTplCCatValue == 'ALL' ){
        			mrTplCCatValue = mrCategoryCode;
        		}
        		if(mrTplTypeCdValue == 'ALL' ){
        			mrTplTypeCdValue = typeCode;
        		}
        	}
        }
		if(context.event == undefined){
			pageNum = context.pageNum;
			pageSize = context.pageSize;
			statusCode = context.statusCode;
			if(mrCategoryCode!=undefined && !Ext.isEmpty(mrCategoryCode,false)){
			}else{
				mrCategoryCode = context.mrCategoryCode;
			}
			if(typeCode!=undefined && !Ext.isEmpty(typeCode,false)){
			}else{
				typeCode = context.typeCode;
			}
			name = context.name;
			if(context.ownerCode!=undefined && context.ownerCode!=null && context.ownerCode!=''){
				ownerCode = context.ownerCode;
			}
			//获取模板列表的 block
			data = {
					pageNum : pageNum,
					pageSize : pageSize,
					statusCode :statusCode,
					mrCategoryCode :mrCategoryCode,
					typeCode :typeCode,
					name:name,
					ownerCode:ownerCode,
					enTypeCode:enTypeCode,
					dctNsF:dctNsF
			};
			
		}else{
			if(eventName == "afterrender"){
				data = {
						pageNum : '1',
						pageSize : '25',
						statusCode :"ALL",
						mrCategoryCode:"ALL",
						typeCode:"ALL",
						name:name,
						enTypeCode:enTypeCode,
						dctNsF:dctNsF
				};
			}else if(eventName ==  'onTriggerClick' || eventName ==  'select' ){
				pageNum  = grid.currentPage ;
				pageSize = grid.pageSize ;
				data = {
						pageNum : pageNum,
						pageSize : pageSize,
						statusCode :mrTplStatCdValue,
						mrCategoryCode :mrTplCCatValue,
						typeCode :mrTplTypeCdValue,
						ownerCode:ownerCode,
						name:name,
						enTypeCode:enTypeCode,
						dctNsF:dctNsF
				};
			}else{
			    pageNum = context.event.arguments[0]; 
				pageSize = context.event.arguments[1]; 
				//获取模板列表的 block
				data = {
						pageNum : pageNum,
						pageSize : pageSize,
						statusCode :mrTplStatCdValue,
						mrCategoryCode :mrTplCCatValue,
						typeCode :mrTplTypeCdValue,
						name:name,
						enTypeCode:enTypeCode,
						ownerCode:ownerCode,
						dctNsF:dctNsF
				};
			}
		}
		if(data.mrCategoryCode == 'ALL' ){
			data.mrCategoryCode = null ;
			delete data.mrCategoryCode ;
		}
		if(data.typeCode == 'ALL' ){
			data.typeCode = null ;
			delete data.typeCode ;
		}
		if(data.statusCode == 'ALL' ){
			data.statusCode = null ;
			delete data.statusCode ;
		}
		var name = data.name;
		if(typeof(name) == undefined || name == ""){
			data.name = null ;
			delete data.name ;
		}
        var operations = context.operations;      
        this.prepareOperations(operations,data);        
	},  
	 prepareOperations: function(operations,data) {  
		var url = this.url;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_GET,
            params: data,
            data:null,
            scope: this,
            success: this.onSuccessList,
            //fail: this.onFail
        };
        operations.push(operation);	    
	 },
	 onSuccessList: function(operation) {
	        var block = this.getBlock('result');
	        var gridBlock =block.down('mrtemplatelistblock');
		    //保存查询参数到store中
			Ext.apply(gridBlock.store.lastOptions,{// 把查询条件放到ds的参数对象中 
            		sourceEvent:'listSearch',
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
			} else {        
				gridBlock.setGridData(m); //设置数据
			}
			var chain =  this.getOwner().getActionChain('selectionchange');
            chain.execute();
	 }    
});
