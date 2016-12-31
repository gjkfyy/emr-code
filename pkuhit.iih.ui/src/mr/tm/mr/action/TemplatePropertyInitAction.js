Ext.define('iih.mr.tm.mr.action.TemplatePropertyInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	requires: ['Xap.ej.block.Layer'],

	doExecute: function(context) {
	    this.callParent();
	    console.log('----------------------------- TemplatePropertyInitAction ------------------------------');
	    if(context.sourceView){
	    	this.getOwner().emrPrintSelected=context.sourceView.emrPrintSelected;
	    }
        var operations = context.operations;
        var owner = this.getOwner();
        var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        properties.setData({
            customerData: context.customerData,   
            verMrTplKc:context.verMrTplKc, 
            sourceView:context.sourceView, 
            //增加
            name:context.name,
            block:context.block
        });
        var sourceView = context.sourceView;
		var initChain = owner.getActionChain('mrTypeCdInit');
		initChain.execute({
			enTypeCode:sourceView.enTypeCode,
			dctNsF:sourceView.dctNsF
		});
        if(context.customerData=='new'){
        	var enTypeCode = owner.down('[name=enTypeCode]');
        	var dctNsF = owner.down('[name=dctNsF]');
    		enTypeCode.setValue(sourceView.enTypeCode);
    		dctNsF.setValue(sourceView.dctNsF);
        }else if(context.customerData=='edit'){
            if(!operations) {
                return;
            }
            this.prepareOperations(operations,context.verMrTplKc);
        }else if(context.customerData=='saveAs'){
        	if(!operations) {
                return;
            }
            this.prepareOperationsSaveAs(operations,context.verMrTplKc);
        }else if(context.customerData=='mrSaveAs'){
        	if(!operations) {
                return;
            }
        	this.prepareOperationsMrSaveAs(operations,context.verMrTplKc);
        }else if(context.customerData=='readOnly'){
        	if(!operations) {
                return;
            }
        	this.prepareOperationsReadOnly(operations,context.verMrTplKc);
        }
	},  
	 prepareOperations: function(operations,data) {
        var condition = data;
        var url = this.url +'/'+data;      
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
        var n = operation.result;
        var m  ;
        if( n ){
        	m = n.data ;
        }
       
		if(m){
			// TODO 数据格式就这样了？
			if(m instanceof Ext.data.Model) {
				block.setData({
					mclass: operation.mclass,
					data: m.getData(true)
				});
			}else {
				//分布赋值
				//block.setData(m);
				var owner = this.getOwner();
				var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
				var sourceView = properties.data.sourceView;
				properties.data.baseTemplateCode = m.baseTemplateCode;
				properties.data.mrTypeCode = m.mrTypeCode;
				var enTypeCode = owner.down('[name=enTypeCode]');
				var dctNsF = owner.down('[name=dctNsF]');
				var verMrTplKc = owner.down('[name=verMrTplKc]');
				var xmlFilePk = owner.down('[name=xmlFilePk]');
				var customerData = owner.down('[name=customerData]');
				var TypeCd = owner.down('[name=mrTypeCd]');
				var BaseTplKc = owner.down(' [name=baseTemplateCode]');
				var TplNm = owner.down('[name=mrTplNm]');
				var ownerTypeCd = owner.down('[name=ownerTypeCode]');
				var diagnosisCd = owner.down('[name=diCds]');
				var ownerCd = owner.down('[name=deptCode]');
				var signLevelCode = owner.down('[name=signLevelCode]');
				var description = owner.down('[name=description]');
				enTypeCode.setValue(m.enTypeCode);
				dctNsF.setValue(sourceView.dctNsF);
				xmlFilePk.setValue(m.xmlFilePk);
				customerData.setValue(properties.data.customerData);
				verMrTplKc.setValue(m.code);
//				TypeCd.setValue(m.mrTypeCode);
//				TypeCd.setRawValue(m.mrTypeName);
//				BaseTplKc.setValue(m.baseTemplateCode);
//				BaseTplKc.setRawValue(m.baseTemplateName);
				if(!Ext.isEmpty(m.baseTemplateCode,false)){
					BaseTplKc.select(m.baseTemplateCode,false,true);
				}
				TplNm.setValue(m.name);
				signLevelCode.setValue(m.signLevelCode);//审签级别
				description.setValue(m.description);
				ownerTypeCd.select(m.ownerTypeCode,false,true);//设置所属类型，且不触发select事件
	            var deptCd = m.ownerCode;
	            var deptNm = m.ownerName;
		        ownerCd.setRecordData({code:deptCd,name:deptNm});
			
				var diCdArr = m.diCodes;
				var diNmArr = m.diNames;
				diagnosisCd.setRecordData({value:diCdArr,text:diNmArr}); //设置适应病种
			}
		}
    },
    prepareOperationsReadOnly: function(operations,data) {
        var condition = data;
        var url = this.url +'/'+data;      
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_GET,
            condition: null,
            data:condition,
            scope: this,
            success:this.onSuccessReadOnly,
            //fail: this.onFail
        };
        operations.push(operation);	    
	 },
	    
	 onSuccessReadOnly: function(operation) {
        //alert("success");
        var block = this.getBlock('result');
        var n = operation.result;
        var m  ;
        if( n ){
        	m = n.data ;
        }
		if(m){
			// TODO 数据格式就这样了？
			if(m instanceof Ext.data.Model) {
				block.setData({
					mclass: operation.mclass,
					data: m.getData(true)
				});
			}else {
				//分布赋值
				//block.setData(m);
				var owner = this.getOwner();
				var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
				var enTypeCode = owner.down('[name=enTypeCode]');
				var xmlFilePk = owner.down('[name=xmlFilePk]');
				var customerData = owner.down('[name=customerData]');
				var verMrTplKc = owner.down('[name=verMrTplKc]');
				var TypeCd = owner.down('[name=mrTypeCd]');
				var dctNsF = owner.down('[name=dctNsF]');
				var BaseTplKc = owner.down(' [name=baseTemplateCode]');
				var TplNm = owner.down('[name=mrTplNm]');
				var ownerTypeCd = owner.down('[name=ownerTypeCode]');
				var diagnosisCd = owner.down('[name=diCds]');
				var ownerCd = owner.down('[name=deptCode]');
				var signLevelCode = owner.down('[name=signLevelCode]');
				var description = owner.down('[name=description]');
				TypeCd.setDisabled(true);
				BaseTplKc.setDisabled(true);
				TplNm.setDisabled(true);
				ownerTypeCd.setDisabled(true);
				diagnosisCd.setDisabled(true);
				ownerCd.setDisabled(true);
				signLevelCode.setDisabled(true);
				description.setDisabled(true);
				enTypeCode.setValue(m.enTypeCode);
				xmlFilePk.setValue(m.xmlFilePk);
				customerData.setValue(properties.data.customerData);
				verMrTplKc.setValue(m.code);
				BaseTplKc.select(m.baseTemplateName,false,true);
				TypeCd.setValue(m.mrTypeName);
				TypeCd.setRawValue(m.mrTypeName);
//				BaseTplKc.setValue(m.baseTemplateCode);
//				BaseTplKc.setRawValue(m.baseTemplateName);
				TplNm.setValue(m.name);
				signLevelCode.setValue(m.signLevelCode);//审签级别
				description.setValue(m.description);
				ownerTypeCd.select(m.ownerTypeCode,false,true);//设置所属类型，且不触发select事件
	            var deptCd = m.ownerCode;
	            var deptNm = m.ownerName;
		        ownerCd.setRecordData({code:deptCd,name:deptNm});
			
				var diCdArr = m.diCodes;
				var diNmArr = m.diNames;
				diagnosisCd.setRecordData({value:diCdArr,text:diNmArr}); //设置适应病种
				//按钮控制
				var cancel = owner.down('button[name=cancel]');
				var confim = owner.down('button[name=confim]');
				cancel.setText('关闭');
				cancel.setIconCls('icon-close');
				confim.setVisible(false);
			}
		}
    },  
	 prepareOperationsSaveAs: function(operations,data) {
        var condition = data;
        var url = this.url +'/'+data;      
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_GET,
            condition: null,
            data:condition,
            scope: this,
            success:this.onSuccessSaveAs
            //fail: this.onFail
        };
        operations.push(operation);	    
	 },
	    
	 onSuccessSaveAs: function(operation) {
        //alert("success");
        var block = this.getBlock('result');
        var n = operation.result;
        var m  ;
        if( n ){
        	m = n.data ;
        }
		if(m){
			// TODO 数据格式就这样了？
			if(m instanceof Ext.data.Model) {
				block.setData({
					mclass: operation.mclass,
					data: m.getData(true)
				});
			}else {
				//分布赋值
				var owner = this.getOwner();
				var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
				properties.data.baseTemplateCode = m.baseTemplateCode;
				var enTypeCode = owner.down('[name=enTypeCode]');
				var TypeCd = owner.down('[name=mrTypeCd]');
				var xmlFilePk = owner.down('[name=xmlFilePk]');
				var dctNsF = owner.down('[name=dctNsF]');
				var customerData = owner.down('[name=customerData]');
				var BaseTplKc = owner.down('[name=baseTemplateCode]');
				var TplNm = owner.down('[name=mrTplNm]');
				var ownerTypeCd = owner.down('[name=ownerTypeCode]');
				var diagnosisCd = owner.down('[name=diCds]');
				var ownerCd = owner.down('[name=deptCode]');
				var signLevelCode = owner.down('[name=signLevelCode]');
				var description = owner.down('[name=description]');
				BaseTplKc.select(m.baseTemplateCode,false,true);
				//TypeCd.select(m.mrTypeCode,false,true);
				enTypeCode.setValue(m.enTypeCode);
				xmlFilePk.setValue(m.xmlFilePk);
				customerData.setValue(properties.data.customerData);
				TplNm.setValue(m.name);
				signLevelCode.setValue(m.signLevelCode);//审签级别
				description.setValue(m.description);
				ownerTypeCd.select(m.ownerTypeCode,false,true);//设置所属类型，且不触发select事件
	            var deptCd = m.ownerCode;
	            var deptNm = m.ownerName;
		        ownerCd.setRecordData({code:deptCd,name:deptNm});
			
				var diCdArr = m.diCodes;
				var diNmArr = m.diNames;
				diagnosisCd.setRecordData({value:diCdArr,text:diNmArr}); //设置适应病种
			}
		}
    },  
    prepareOperationsMrSaveAs: function(operations,data) {
        var condition = data;
        var url = this.url +'/'+data;      
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_GET,
            condition: null,
            data:condition,
            scope: this,
            success:this.onSuccessMrSaveAs,
            //fail: this.onFail
        };
        operations.push(operation);	    
	 },
	 onSuccessMrSaveAs: function(operation) {
        //alert("success");
        var block = this.getBlock('result');
        var n = operation.result;
        var m  ;
        if( n ){
        	m = n.data ;
        }
		if(m){
			// TODO 数据格式就这样了？
			if(m instanceof Ext.data.Model) {
				block.setData({
					mclass: operation.mclass,
					data: m.getData(true)
				});
			}else {
				//分布赋值
				//block.setData(m);
				var owner = this.getOwner();
				var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
				var enTypeCode = owner.down('[name=enTypeCode]');
				var xmlFilePk = owner.down('[name=xmlFilePk]');
				var customerData = owner.down('[name=customerData]');
				var verMrTplKc = owner.down('[name=verMrTplKc]');
				var TypeCd = owner.down('[name=mrTypeCd]');
				var dctNsF = owner.down('[name=dctNsF]');
				var BaseTplKc = owner.down(' [name=baseTemplateCode]');
				var TplNm = owner.down('[name=mrTplNm]');
				var ownerTypeCd = owner.down('[name=ownerTypeCode]');
				var diagnosisCd = owner.down('[name=diCds]');
				var ownerCd = owner.down('[name=deptCode]');
				var signLevelCode = owner.down('[name=signLevelCode]');
				var description = owner.down('[name=description]');
				enTypeCode.setValue(m.enTypeCode);
				xmlFilePk.setValue(m.xmlFilePk);
				customerData.setValue(properties.data.customerData);
				verMrTplKc.setValue(m.code);
//				TypeCd.setValue(m.mrTypeCode);
//				TypeCd.setRawValue(m.mrTypeName);
				BaseTplKc.select(m.baseTemplateCode,false,true);
				//BaseTplKc.setRawValue(m.baseTemplateName);
//				BaseTplKc.setDisabled(true);
				TplNm.setValue(m.name);
				signLevelCode.setValue(m.signLevelCode);//审签级别
				description.setValue(m.description);
				ownerTypeCd.select('MDM08.03',true,true);//设置所属类型，且不触发select事件
				ownerTypeCd.setReadOnly(true);
	            var deptCd = IMER_GLOBAL.user.code;
	            var deptNm = IMER_GLOBAL.user.name;
		        ownerCd.setRecordData({code:deptCd,name:deptNm});
		        ownerCd.setReadOnly(true);
				var diCdArr = m.diCodes;
				var diNmArr = m.diNames;
				diagnosisCd.setRecordData({value:diCdArr,text:diNmArr}); //设置适应病种
			}
		}
    }   
});
