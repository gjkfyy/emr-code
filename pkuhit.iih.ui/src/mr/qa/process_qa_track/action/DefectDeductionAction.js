/** 
 * 扣分
 * @author ：cheng_feng
 */
Ext.define('iih.mr.qa.process_qa_track.action.DefectDeductionAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	doExecute: function(context) {
	        this.prepareOperations(context);
	 },
	 prepareOperations: function(context) {
		var me = this;
		var resultBlock = this.getBlock('result');
	        
	    /*var enGrid = resultBlock.down('xapgrid');
	     
	    var selModel = enGrid.getSelectionModel();
	        
	    var record = selModel.getSelection()[0];*/
	    
		var record = context.record;
		
	    var faultPk = record.data.qaFltPk;
	    
		var operations = context.operations;
		
        var url = this.url;
        url+= '/' + faultPk;
        console.log(url);
    	var operation = {
            url: url,
    		mclass: null,
    		method: 'put',
    		condition: null,
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.length = 0;
    	operations.push(operation);
    },

    onSuccess: function(operation) {
    	var owner = this.getOwner();   
	    var revisionCd = owner.revisionCd;
    	//刷新
    	var chain = this.getBlock('result').ownerCt.getActionChain('init');
    	if(chain) {
        	chain.execute({
	        	rownum:0,
        		revisionCd: revisionCd
        	});
    	}
    	var contentBlock = this.getBlock('result');
	    // 审核通过按钮
        var checkPass = contentBlock.down('xapgrid xapbutton[action=checkPass]');
        // 扣分按钮
        var deduction = contentBlock.down('xapgrid xapbutton[action=deduction]');
        // 再整改按钮
        var rectification = contentBlock.down('xapgrid xapbutton[action=rectification]');
        // 设置按钮可用
        checkPass.setDisabled(true);
        deduction.setDisabled(true);
        rectification.setDisabled(true);
    }
});
