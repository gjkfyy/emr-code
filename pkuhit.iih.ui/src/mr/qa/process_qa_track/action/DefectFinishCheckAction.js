/** 
 * 审核通过
 * @author ：cheng_feng
 */
Ext.define('iih.mr.qa.process_qa_track.action.DefectFinishCheckAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	doExecute: function(context) {
	        this.prepareOperations(context);
	 },
	 prepareOperations: function(context) {
		var me = this;
			
	    var owner = this.getOwner();   
	    
	    var revisionCd = owner.revisionCd;
	    
		var operations = context.operations;
		
        var url = this.url;
        url+= '/' + revisionCd;
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
	    var me = this;
    	XapMessageBox.info("完成本次审核成功");
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
    	var contentBlock = me.getBlock('result');
	    // 审核通过按钮
        var checkPass = contentBlock.down('xapgrid xapbutton[action=checkPass]');
        // 扣分按钮
        var deduction = contentBlock.down('xapgrid xapbutton[action=deduction]');
        // 再整改按钮
        var rectification = contentBlock.down('xapgrid xapbutton[action=rectification]');
        // 完成本次审核按钮
        var finishCheck = contentBlock.down('xapgrid xapbutton[action=finishCheck]');
        // 设置按钮可用
        checkPass.setDisabled(true);
        deduction.setDisabled(true);
        rectification.setDisabled(true);
        finishCheck.setDisabled(true);
        
        //储存画面间参数
	    var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        properties.setData({
    		revisionStatus:iih.mr.qa.QaStatusGlobal.revisionNoticeVerified
        });
        
    }
});
