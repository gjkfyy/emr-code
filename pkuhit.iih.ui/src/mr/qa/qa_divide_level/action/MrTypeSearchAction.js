Ext.define('iih.mr.qa.qa_divide_level.action.MrTypeSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
	    this.prepareOperations(context.operations);
    },
    prepareOperations: function(operations) {
        var block = this.getOwner().getBlock('content');
        var mrCustClaCd = '';
        var condition={"mrTypeCustomCategoryCd":mrCustClaCd,"enTypeCd":'ENM01.04'};
        var url = this.url;
        var operation = {
                url: url,
                method: 'get',
                params: condition,
                scope: this,
                success: this.onSuccess
            };
        operations.push(operation);
    },
    onSuccess: function(operation) {
    	var owner = this.getOwner();
        var block = owner.getBlock('content');
        var qaItmTpCd = block.down('xapcombobox[name=qaItmTpCd]').value;
        var timeAuto = block.down('xapform[name=timeAuto]');
        var frequencyAuto = block.down('xapform[name=frequencyAuto]');
        var integrityAuto = block.down('xapform[name=integrityAuto]');
        var dependentAuto = block.down('xapform[name=dependentAuto]');
        var qaItmData = owner.qaItmData;
		var qaItmCd = owner.qaItmCd;
		var isMrConfig = owner.isMrConfig;//是否病历文书配置(病历模板下，病历文书下进行质控配置)
		var sourceView = owner.sourceView;
        var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        properties.setData({
            qaItmData : qaItmData,
            isMrConfig:isMrConfig,
            sourceView : sourceView
        });
    	if(operation.result){
    		if(qaItmTpCd == 'QAM06.02'){
        		var mrTypeCd = timeAuto.down('xapcombobox[name=mrTypes]');
        	}else if(qaItmTpCd == 'QAM06.05'){
        		var mrTypeCd = frequencyAuto.down('xapcombobox[name=mrTypes]');
        	}else if(qaItmTpCd == 'QAM06.04'){
        		var mrTypeCd = integrityAuto.down('xapcombobox[name=mrTypes]');
        	}else if(qaItmTpCd == 'QAM06.03'){
        		var mrTypeCd = dependentAuto.down('xapcombobox[name=mrTypes]');
        	}
            mrTypeCd.setData(operation.result.dataList);
            var result = this.getOwner();
            var initChain = result.getActionChain('init');
            initChain.execute({
            	qaItmCd:qaItmCd,
            	qaItmData:qaItmData,
            	isMrConfig:isMrConfig
            });
        }
    }
});
