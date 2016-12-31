Ext.define('iih.mr.tm.gro.action.GroupElementPropertyInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	requires: ['Xap.ej.block.Layer'],

	doExecute: function(context) {
	    this.callParent();
        var operations = context.operations;
        var owner = this.getOwner();
        var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        properties.setData({
            customerData: context.customerData,   
            code:context.code, 
            filePk:context.filePk, 
            sourceView:context.sourceView,   
            block:context.block
        });
        if(context.customerData=='new'){
            return
        } /*else if(context.customerData=='edit'){
            if(!operations) {
                return;
            }
            console.log(context.sourceView);
            this.prepareOperations(operations,context.verMrTplKc);
        }*/
	},  
	 prepareOperations: function(operations,data) {
        var condition = data;
        var url = this.url +'?verMrTplKc='+data;      
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_GET,
            condition: null,
            data:condition,
            scope: this,
            success:this.onSuccess,
            //fail: this.onFail
        };
        operations.push(operation);	    
	 },
	    
    onSuccess: function(operation) {
        //alert("success");
        var block = this.getBlock('result');
        var m = operation.result;
		if(m){
			// TODO 数据格式就这样了？
			if(m instanceof Ext.data.Model) {
				block.setData({
					mclass: operation.mclass,
					data: m.getData(true)
				});
			}
			else {
				//分布赋值
				//block.setData(m);
				
				var owner = this.getOwner();
				
				var verMrTplKc = owner.down('[name=verMrTplKc]');
				var TypeCd = owner.down('[name=mrTypeCd]');
				var BaseTplKc = owner.down(' [name=verBaseTplKc]');
				var TplNm = owner.down('[name=mrTplNm]');
				var ownerTypeCd = owner.down('[name=ownerTypeCd]');
				var diagnosisCd = owner.down('[name=diagnosisCd]');
				var ownerCd = owner.down('[name=ownerCd]');
				
				verMrTplKc.setValue(m.verMrTplKc);
				TypeCd.setValue(m.mrTypeCd);
				BaseTplKc.setValue(m.verBaseTplKc);
				TplNm.setValue(m.mrTplNm);
				ownerTypeCd.setValue(m.ownerTypeCd);
				
				//辅助录入设置值 需要后端，grid存name不只是code
				
			   /*  diagnosisCd.setRecordData({code:deptCd,dept:deptNm});
				
				ownerCd.setRecordData({code:deptCd,dept:deptNm});*/
				
				/*
				console.log("++++++++++++++++++++++++");
				console.log(properties.sourceView);
				console.log(block.down('flowgrid'));*/
				
			}
		}
    }    
});
