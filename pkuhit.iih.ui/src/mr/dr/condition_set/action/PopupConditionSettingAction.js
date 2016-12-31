Ext.define('iih.mr.dr.condition_set.action.PopupConditionSettingAction', {
	extend: 'Xap.ej.action.PopAction',
	requires : [
		'iih.mr.dr.condition_set.view.ConditionSettingView'
	],
	execute: function(context) {

        var owner = this.getOwner();   
        
    	//获取储存于画面间的参数
        var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        
        var block = owner.getBlock('right');
        var conditionType = block.down('xapcombobox[name=conditionType]').value;
        
		var config = {
    		width: 700,
    		height:520,
    		title:'检索条件设置',
    		contentConfig: {
    			xtype: 'conditionsettingview',
    			socuseOwner:owner,  //传入上级视图
    			initChain: {
    				name: 'refresh',
    				context: {
    					conditionType:conditionType
    				}
    			}
    		}
    	};
    	this.callParent([config]);
	}
});
