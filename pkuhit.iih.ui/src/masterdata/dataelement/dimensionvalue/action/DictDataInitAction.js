Ext.define('iih.masterdata.dataelement.dimensionvalue.action.DictDataInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	doExecute: function(context) {
		this. showLoading();
	     this.prepareOperations(context);
	 },
	 prepareOperations: function(context) {
	    var owner = this.getOwner();   
	    
	    var block = owner.getBlock('top');
	    if(block == undefined){
	    	block = owner.ownerCt.getBlock('top');
	    }
		var grid = block.down('xapgrid');
        var record = grid.getSelectionModel().getSelection();
        if(record ==undefined || Ext.isEmpty(record,false)){
			XapMessageBox.info('请选择通用字典项目所属的通用字典！');
			return;
		}
        
        var contentBlock = owner.getBlock('result');
	    if(contentBlock == undefined){
	    	contentBlock = owner.getBlock('bottom').getBlock('result');
	    }
/*	    var isVerifiedBox = contentBlock.down('xapgrid xapcheckbox');
        var verifiedChecked = isVerifiedBox.checked;
        var verified = 1;//默认勾选的启用checkbox
        if(!verifiedChecked){
        	verified = 0;
        }*/
		var operations = context.operations;
        var url = this.url;
        var dimensionCode = record[0].data.dataElementCd ;
        //console.info(dimensionCode);
        var qs = 'fkDictgeneral=' + record[0].data.pkDictgeneral + '&verified=1' ;
    	var operation = {
            url: url + '/' +dimensionCode,
    		mclass: null,
    		method: 'get',
    		condition: null,
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.length = 0;
    	operations.push(operation);
    },

    onSuccess: function(operation) {
    	var owner = this.owner;
        var block = owner.getBlock('result');
        if(block ==  undefined){
        	block = owner.getBlock('bottom').getBlock('result');
        }
        var m = operation; 
        if(m.result.total>0) {
        	block.setData(m.result);
        }else {
        	block.setData(null);
        }
    }
});
