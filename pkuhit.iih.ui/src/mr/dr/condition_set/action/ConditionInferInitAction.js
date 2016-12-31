Ext.define('iih.mr.dr.condition_set.action.ConditionInferInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	execute: function(context) {
		var conditionSettingInferView = this.getBlock('result');
		var conditionPanelView = conditionSettingInferView.ownerCt.socuseOwner;
    	var panelRightBlock = conditionPanelView.getBlock('right');
    	
		var properties = this.getOwner().getLayer(Xap.ej.block.Layer.PROPERTIES);
    	if(properties.data != null || properties.data != undefined){
	        var conditionType = properties.data.conditionType;
	        var constraintObject = properties.data.constraintObject;
	        var logicSymbolCode = properties.data.logicSymbolCode;
	        var constraintDomain = properties.data.constraintDomain;
	        var elemPath = properties.data.elemPath;
	        var mrPk = properties.data.mrPk;
	        var docType = properties.data.docType;
	        
	        panelRightBlock.down('xapcombobox[name=conditionType]').select(conditionType);
			panelRightBlock.down('xaptextarea[name=constraintObject]').setValue(constraintObject);
			panelRightBlock.down('xapcombobox[name=logicSymbolCode]').select(logicSymbolCode);
			panelRightBlock.down('xaptextarea[name=constraintDomain]').setValue(constraintDomain);
			panelRightBlock.down('xaptextfield[name=elemPath]').setValue(elemPath);
			panelRightBlock.down('xaptextfield[name=mrPk]').setValue(mrPk);
			panelRightBlock.down('xaptextfield[name=docType]').setValue(docType);
    	}
		
        var conditionTypeC = context.conditionType;
    	if(!Ext.isEmpty(conditionTypeC, false)){
    		panelRightBlock.down('xapcombobox[name=conditionType]').select(conditionTypeC);
    	}
	}
});