Ext.define('iih.mr.wr.mr_apply.action.PopupApplyInferPassAction', {
	extend: 'Xap.ej.action.PopAction',
	requires : [
	            'iih.mr.wr.mr_apply.view.MrApplyInferView'
	],
	execute: function(context) {

        var owner = this.getOwner();   
    	
    	//获取储存于画面间的参数
        var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        
		var config = {
    		width: 700,
    		height:480,
    		title:'归档撤回申请',
    		contentConfig: {
    			xtype: 'mrapplyinferview',
    			sourceOwner:owner,  //传入上级视图
    			initChain: {
    				name: 'init',
    				context: {
    					data : context.data,
    					btnName : 'pass'
    				}
    			}
    		}
    	};
    	this.callParent([config]);
	}
});
