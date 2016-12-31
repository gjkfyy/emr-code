Ext.define('iih.mr.tm.mr.action.MrTemplateLoadTreeAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

	doExecute: function(context) {
		this.showLoading();
        var operations = context.operations;
        var view = this.getOwner();
        var left = view.getBlock('left');
        var mrTplCCat = left.down('xapcombobox[name=mrTplCCat]');
        var mrTplTypeCd = left.down('xapcombobox[name=mrTplTypeCd]');
        var mrTplStatCd = left.down('xapcombobox[name=mrTplStatCd]');
        var mrTemplateTrigger = left.down('xaptrigger[name=mrTemplateTrigger]');
        var mrTplCCatValue = mrTplCCat.value;
        if(mrTplCCatValue == 'ALL' ){
            mrTplCCatValue = null;
        }
        var mrTplTypeCdValue = mrTplTypeCd.value;
        if(mrTplTypeCdValue == 'ALL' ){
            mrTplTypeCdValue = null;
        }
        var mrTplStatCdValue = mrTplStatCd.value;
        if(mrTplStatCdValue == 'ALL' ){
            mrTplStatCdValue = null;
        }
        var mrTemplateTriggerValue = mrTemplateTrigger.value;
        var enTypeCode = view.enTypeCode;
        var dctNsF = view.dctNsF;
		var data = {
		    'mrTplCCat':mrTplCCatValue,
		    'mrTplTypeCd':mrTplTypeCdValue,
		    'mrTplStatCd':mrTplStatCdValue,
		    'keyWord': mrTemplateTriggerValue,
		    'enTypeCode':enTypeCode,
            'dctNsF':dctNsF
		};
        this.prepareOperations(operations,data);    
    }, 
    prepareOperations: function(operations,data) {
        var condition = data;
        var url = this.url;
        var qs = Ext.Object.toQueryString(condition);
        if(qs){
            url += '?' + qs;
        }        
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            method:METHODS.METHOD_GET,
            condition: condition,
            scope: this,
            success: this.onSuccessTree
        };
        operations.push(operation);
    },
       
    onSuccessTree: function(operation) {
        var block = this.getBlock('result');
        var noTree = block.down('xaptree');
        var mrTemTree = block.down('xaptree[name=mrTemplate]');
    	if(operation.result.root.children){
    		block.setData(operation.result.root.children);
    		if(!mrTemTree.nodeId){
    		    path = '/root'+ operation.result.root.children[0].data.id;
    		    mrTemTree.expandPath(path, 'id');
            }else{
                path = '/root/'+ mrTemTree.nodeId;
                mrTemTree.expandPath(path, 'id');
            }
    		var chainList =  this.getOwner().getActionChain('init');
		    chainList.execute();
    	}else{
    		block.setData(null);
    	}
    }
});
