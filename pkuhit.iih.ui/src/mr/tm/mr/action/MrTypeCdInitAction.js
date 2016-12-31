Ext.define('iih.mr.tm.mr.action.MrTypeCdInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

	doExecute: function(context) {
	    this.callParent();
	    console.log('------------------ MrTypeCdInitAction -----------------------');
	    var view = this.getOwner();
	    var enTypeCode = context.enTypeCode;
	    var dctNsF = context.dctNsF;
	    var properties = view.getLayer(Xap.ej.block.Layer.PROPERTIES);
	    var sourceView = properties.data.sourceView.ownerCt;
	    if(enTypeCode==undefined){
	    	if(sourceView){
	    		enTypeCode = sourceView.enTypeCode;
	    		dctNsF = sourceView.dctNsF;
	    	}
	    }
        var operations = context.operations;
        var data = {};
        data.enTypeCode = enTypeCode;
        data.dctNsF = dctNsF;
        this.prepareOperations(operations,data);        
	},  
	 prepareOperations: function(operations,data) {
		 var enTypeCode = data.enTypeCode;
		 var dctNsF = data.dctNsF;
		 if(Ext.isEmpty(dctNsF,false)){
			 dctNsF = 1;
		 }
		 var url = this.url+'?enTypeCode='+enTypeCode+'&dctNsF='+dctNsF;   
		 console.log(url);
		 var METHODS = this.getInvocationMethods();
		 var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_GET,
            condition: null,
            data:null,
            scope: this,
            success: this.onSuccess,
            //fail: this.onFail
		 };
		 operations.push(operation);	    
	 },
	    
    onSuccess: function(operation) {
    	var create = this.getBlock('result');
        var block = this.getBlock('result').down('[name=mrTypeCd]');
        var signLevelCode = this.getBlock('result').down('[name=signLevelCode]');
        var mrTplNm = this.getBlock('result').down('[name=mrTplNm]'); 
        var m = operation.result;
		if(m){
			if(m instanceof Ext.data.Model) {
				block.setData({
					mclass: operation.mclass,
					data: m.getData(true)
				});
			}else{
				var data = m.dataList
				Ext.Array.forEach(data,function(node,index,array){
					node.mrTypeCd = node.name;
				});
				block.setData(m.dataList);
			}
			var properties = this.getOwner().getLayer(Xap.ej.block.Layer.PROPERTIES);
			var view = properties.data.sourceView;
			var mrTypeCodeCodeValue,xtree,grid,deptCd,deptNm,signLelCd,typeName='',nodeId;
	       //console.log(properties.data.customerData ) ;
			if(properties.data.customerData=='new'){
				xtree = view.down('xaptree[name=mrTemplate]');
				mrTypeCodeCodeValue = view.typeCode;
				for(var i=0;i<data.length;i++){
					if(data[i].code==mrTypeCodeCodeValue){
						signLelCd = data[i].signLevelCode;
						typeName = data[i].name;
					}
				}
				mrTplNm.setValue(typeName);
				signLevelCode.select(signLelCd,false,true);
				var ownerCode = view.ownerCode;
				var mrCategoryCode = view.mrCategoryCode;
				var ownerTypeCode = create.down('[name=ownerTypeCode]');
				var deptCode = create.down('[name=deptCode]');
	    	   	nodeId = view.nodeId;
	    	   	if(typeof(ownerCode)!=undefined && ownerCode!=null && ownerCode!=''){
	    	   		deptCd = ownerCode;
	    	   		node = xtree.getStore().getNodeById(nodeId);
	    	   		if(ownerCode==IMER_GLOBAL.hospitalArea.code){
	    	   			ownerTypeCode.select(IMER_CONSTANT.OWNERTYPE_HOS,false,true);
	    	   			deptNm = node.raw.data.ownerName;
	    	   			deptCode.setRecordData({code:deptCd,name:deptNm});
	    	   			deptCode.setReadOnly(true);
	    	   		}else if(ownerCode==IMER_GLOBAL.user.code){
	    	   			ownerTypeCode.select(IMER_CONSTANT.OWNERTYPE_PERSON,false,true);
	    	   			deptCd = IMER_GLOBAL.user.code;
	    	   			deptNm = IMER_GLOBAL.user.name;
	    	   			deptCode.setRecordData({code:deptCd,name:deptNm});
	    	   			deptCode.setReadOnly(true);
	    	   		}else{
	    	   			ownerTypeCode.select(IMER_CONSTANT.OWNERTYPE_DEPT,false,true);
	    	   			deptNm = node.raw.data.ownerName;
	    	   			deptCode.setRecordData({code:deptCd,name:deptNm});
	    	   		}
	    	   	}
			}else if(properties.data.customerData=='edit'){
	    	   var grid = view.down('mrtemplatelistblock');
	    	   var selectedItemArr,item;
	    	   if(grid){
	    	   		selectedItemArr = grid.getSelectionModel().getSelection();
		    	   	item = selectedItemArr[0].raw;
		    	   	mrTypeCodeCodeValue = item.mrTypeCode ;
	    	   	}else{
	    	   		mrTypeCodeCodeValue = properties.data.mrTypeCode;
	    	   	}
			}else if(properties.data.customerData=='saveAs'){
	    	   if(view.opType=='open'){
	    		   mrTypeCodeCodeValue = view.mrTypeCode;
	    	   }else if(view.opType=='new'){
	    		   mrTypeCodeCodeValue = view.data.mrTypeCode;
	    	   }
	       	}else if(properties.data.customerData=='mrSaveAs'){
	    	   mrTypeCodeCodeValue = view.medicalRecord.typeCode;
	       	}else if(properties.data.customerData=='readOnly'){
	    	   if(view.mrDocEditView!=undefined){
	    		   mrTypeCodeCodeValue = view.mrDocEditView.medicalRecord.typeCode;
	    	   }else{
	    		   mrTypeCodeCodeValue = view.mr.typeCode;
	    	   }
	       	}
			block.select(mrTypeCodeCodeValue,false,true);
		}
    }    
});

