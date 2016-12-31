Ext.define('iih.mr.dr.condition_set.action.ConditionInferSaveAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	execute: function(context) {    
		
    	var owner = this.getOwner();
		var block = owner.getBlock('result').ownerCt.getBlock('condition').getBlock('right');
		var conditionType = block.down('xapcombobox[name=conditionType]').value;
		var constraintObject = block.down('xaptextarea[name=constraintObject]').value;
		var logicSymbolCode = block.down('xapcombobox[name=logicSymbolCode]').value;
		var constraintDomain = block.down('xaptextarea[name=constraintDomain]').value;
		var elemPath = block.down('xaptextfield[name=elemPath]').value;
		var mrPk = block.down('xaptextfield[name=mrPk]').value;
		var docType = block.down('xaptextfield[name=docType]').value;
		
		if(Ext.isEmpty(constraintObject,false)){
			XapMessageBox.info('请选择约束对象！');
			return;
		}
		if(Ext.isEmpty(logicSymbolCode,false)){
			XapMessageBox.info('请选择逻辑关系！');
			return;
		}
		if(Ext.isEmpty(constraintDomain,false)){
			XapMessageBox.info('请输入约束值域！');
			return;
		}
		if(Ext.isEmpty(conditionType,false)){
			XapMessageBox.info('请选择条件类型！');
			return;
		}
		
		//储存画面间参数
	    var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        properties.setData({
        	conditionType:conditionType,
    		constraintObject: constraintObject,
    		logicSymbolCode:logicSymbolCode,
    		constraintDomain:constraintDomain,
    		elemPath:elemPath,
    		mrPk:mrPk,
    		docType:docType
        });
        
        var owner = this.getOwner();
    	//调用初始化Action，刷新方案条件设置画面
    	var refreshChain = owner.getActionChain('refresh');
    	refreshChain.execute();
    	
        owner.ownerCt.close();//关闭保存页面
    }
});