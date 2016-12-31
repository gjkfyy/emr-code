/** 
 * 点击记录，判断按钮状态
 * @author ：yao_lijie
 */
Ext.define('iih.mr.qa.qa_divide_level.action.QaItmTypeAction', {
	extend: 'Xap.ej.action.Action',
	
	execute: function(context) {
		var me = this;
		var contentBlock = this.getBlock('content');	
		//质控项目类别
		var qaItmTpCd = contentBlock.down('xapcombobox[name=qaItmTpCd]');
		qaItmTpCd.on('change',function(btn){
//			context.event.name='change';
			var qaItmTypeChain = me.getOwner().getActionChain("qaItmTypeChain");
			qaItmTypeChain.execute(context);
		});
		
		var owner = this.getOwner();
		var qaItmData = owner.qaItmData;
		var qaItmTpCd = qaItmData.qaItmTpCd;//质控项目类别
		var qaItmCd = owner.qaItmCd; 
		var sourceView = owner.sourceView;
		var isMrConfig = owner.isMrConfig;//是否病历文书配置(病历模板下，病历文书下进行质控配置)
		var mrTypeCcatId = owner.mrTypeCcatId;//病历文书类型组编码
        var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        properties.setData({
            qaItmData : qaItmData,
            qaItmCd:qaItmCd,
            isMrConfig:isMrConfig,
            mrTypeCcatId:mrTypeCcatId,
            sourceView : sourceView
        });
		var block = this.getBlock('content');
		var timeAuto = block.down('xapform[name=timeAuto]');
		var frequencyAuto = block.down('xapform[name=frequencyAuto]');
		var integrityAuto = block.down('xapform[name=integrityAuto]');
		var dependentAuto = block.down('xapform[name=dependentAuto]');
		var qaItmTpCdBox = block.down('xapcombobox[name=qaItmTpCd]');
		var value = qaItmTpCdBox.value;
		if(qaItmTpCd !="" && value == null && qaItmTpCd !=undefined){
			qaItmTpCdBox.setValue(qaItmTpCd);
			value = qaItmTpCd;
		}else if(qaItmTpCd =="" && value == null){
			qaItmTpCdBox.setValue('QAM06.02');
			value = qaItmTpCd;
		}else if(qaItmTpCd == undefined && value == null){//已质控的文书类型
			qaItmTpCdBox.setValue('QAM06.03');
			value = 'QAM06.03';
		}
		if(value == 'QAM06.02'){
			timeAuto.show();
			frequencyAuto.hide();
			integrityAuto.hide();
			dependentAuto.hide();
			var initChain = owner.getActionChain('searchMrType');
            initChain.execute({});
		}else if(value == 'QAM06.05'){
			frequencyAuto.show();
			timeAuto.hide();
			integrityAuto.hide();
			dependentAuto.hide();
			var initChain = owner.getActionChain('searchMrType');
            initChain.execute({});
		}else if(value == 'QAM06.04'){
			integrityAuto.show();
			timeAuto.hide();
			frequencyAuto.hide();
			dependentAuto.hide();
			var initChain = owner.getActionChain('searchMrType');
            initChain.execute({});
		}else if(value == 'QAM06.03'){
			dependentAuto.show();
			timeAuto.hide();
			frequencyAuto.hide();
			integrityAuto.hide();
			var initChain = owner.getActionChain('searchMrType');
            initChain.execute({});
		}
	}
});
