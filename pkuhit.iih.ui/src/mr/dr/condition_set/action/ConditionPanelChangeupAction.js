Ext.define('iih.mr.dr.condition_set.action.ConditionPanelChangeupAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	doExecute: function(context)  {
    	this.callParent();
    	var me = this;
    	var owner = this.getOwner();
		var block = owner.ownerCt.getBlock('right');
		var upcond = block.down('xaptextfield[name=upcond]').value
		if(Ext.isEmpty(upcond,false)){
			XapMessageBox.info('请选择要上移的节点！');
			return;
		}
		var operations = context.operations;
        if(!operations) {
        	return;
        }
        me.prepareOperations(operations);
    },
    
    prepareOperations: function(operations){
    	var owner = this.getOwner();
		var block = owner.ownerCt.getBlock('right');
		var upcond = block.down('xaptextfield[name=upcond]').value
        var url = this.url+'/'+upcond;
        var mclass = null;
        var METHODS = this.getInvocationMethods();
    	var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_UPDATE,
            condition: null,	
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.push(operation);
    },
    
    onSuccess: function(operation) {
        //刷新条件设置画面
    	var owner = this.getOwner().ownerCt.ownerCt;
    	
    	//调用刷新树Action，刷新条件树
    	var initChain = owner.getActionChain('init');
    	initChain.execute();
    	
    	//调用ResetAction，清空设置条件
    	var resetChain = owner.getActionChain('reset');
    	resetChain.execute();
    }
});
