Ext.define('iih.mr.qa.qa_apply.action.PopupApplyInferAction', {
	extend: 'Xap.ej.action.PopAction',
	requires : [
	            'iih.mr.qa.qa_apply.view.QaApplyInferView'
	],
	execute: function(context) {

        var owner = this.getOwner();   
    	
    	//获取储存于画面间的参数
        var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        
		var config = {
    		width: 700,
    		height:608,
    		title:'病历超时申请',
    		contentConfig: {
    			xtype: 'qaapplyinferview',
    			sourceOwner:owner,  //传入上级视图
    			initChain: {
    				name: 'init',
    				context: {
    					data : context.data,
    					btnName : 'send'
    				}
    			}
    		}
    	};
    	this.callParent([config]);
	}
});
