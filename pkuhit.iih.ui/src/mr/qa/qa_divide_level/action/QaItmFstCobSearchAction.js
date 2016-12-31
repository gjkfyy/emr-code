Ext.define('iih.mr.qa.qa_divide_level.action.QaItmFstCobSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
		var owner = this.getOwner();
		owner.sndNm = context.sndNm;
	    var fstCd = context.fstCd;
	    owner.sndCd = context.sndCd;//新增时将分类树选中的二级分类 默认 赋值
//		var typeFlag = context.typeFlag;
		var groupType = context.groupType;
		var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
		var block = this.getBlock('content');
		var data;
		if(groupType == '3'){
			properties.setData({
            	eventNm : context.eventNm,
            	sndCd: context.sndCd,
            	groupType : groupType
        	});
			data = {
				eventNm : context.eventNm,
				sndCd: context.sndCd,
				fstCd:fstCd,
				groupType:groupType
			}
		}else if(groupType == '4'){
			properties.setData({
            	eventNm : context.eventNm,
            	qaItmCd: context.qaItmCd,
            	groupType : groupType
        	});
			data = {
				eventNm : context.eventNm,
				qaItmCd: context.qaItmCd,
				fstCd:fstCd,
				groupType:groupType
			}
		}
		block.data = data;
		var operations = context.operations;
    	if(!operations) {
    		return;
    	}
		this.prepareOperations(operations);
    },
    prepareOperations: function(operations) {
        var url = this.url;
        var operation = {
                url: url,
                method: 'get',
                scope: this,
                success: this.onSuccess
            };
        operations.length = 0;
        operations.push(operation);
    },
    onSuccess: function(operation) {
    	var view = this.getOwner();
        var block = this.getBlock('content');
        var data = block.data;
        var qaItmFst=block.down('[name=fstCd]');

        if(operation.result){
            qaItmFst.setData(operation.result);
            if(data.groupType == '3'){
            	qaItmFst.select(data.fstCd);
            	var initChain = view.getActionChain('init');
	            initChain.execute({
	            	data: data
	            });
            }else if(data.groupType == '4'){
            	qaItmFst.select(data.fstCd);
            	if(data.eventNm == 'editClick'){
            		qaItmFst.selectAt(0);
            	}
            }
        }else{
        	 qaItmFst.setData(null);
        }
    }
});
