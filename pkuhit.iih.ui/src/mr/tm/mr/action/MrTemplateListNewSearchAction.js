Ext.define('iih.mr.tm.mr.action.MrTemplateListNewSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	requires: ['Xap.ej.block.Layer'],

	doExecute: function(context) {
		this.showLoading();
	    this.callParent();
	    var pageNum = context.pageNum||1;
        var pageSize = context.pageSize||25;
        if(context.event && context.event.name == 'turnpage'){
            pageNum = context.event.arguments[0];
            pageSize = context.event.arguments[1];
        }
        var view = this.getOwner();
        var left = view.getBlock('left');
        var mrTemTree = left.down('xaptree[name=mrTemplate]');
        var dataArray = mrTemTree.getSelectionModel().getSelection();
        if(dataArray && dataArray.length > 0){
            r = dataArray[0];
            console.log(r);
            statusCode = r.raw.data.scStatusCode,
            mrCategoryCode = r.raw.data.templateCategoryCode==""?r.raw.data.scTemplateCategoryCode:r.raw.data.templateCategoryCode,
            typeCode = r.raw.data.templateTypeCode==""?r.raw.data.scTemplateTypeCode:r.raw.data.templateTypeCode,
            keyWord = r.raw.data.keyWord,
            ownertypeCode = r.raw.data.ownerTypeCode,
            ownerCode = r.raw.data.ownerCode,
            enTypeCode = r.raw.data.enTypeCode,
            dctNsF = r.raw.data.dctNsF
            
            var data = {
                'pageNum':pageNum,
                'pageSize':pageSize, 
                'statusCode':statusCode, 
                'mrCategoryCode':mrCategoryCode, 
                'typeCode':typeCode, 
                'name':keyWord, 
                'ownerTypeCode':ownertypeCode, 
                'ownerCode':ownerCode, 
                'enTypeCode':enTypeCode, 
                'dctNsF':dctNsF
            };
            console.log(data);
            var operations = context.operations;      
            this.prepareOperations(operations,data); 
        }else{
            this.hideLoading();
            return;
        }      
	},  
	 prepareOperations: function(operations,data) {  
		var url = this.url;
		var qs = Ext.Object.toQueryString(data);
        if(qs){
            url += '?' + qs;
        }
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_GET,
            data:null,
            scope: this,
            success: this.onSuccessList
        };
        operations.push(operation);	    
	 },
	 onSuccessList: function(operation) {
	        var view = this.getOwner();
	        var block = view.getBlock('right');
	        var gridBlock =block.down('mrtemplatelistblock');
		    //保存查询参数到store中
			Ext.apply(gridBlock.store.lastOptions,{// 把查询条件放到ds的参数对象中 
            		sourceEvent:'listSearch',
                    params : operation.params
                } 
            );
	        var m = operation.result;
	        console.log(m);
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
