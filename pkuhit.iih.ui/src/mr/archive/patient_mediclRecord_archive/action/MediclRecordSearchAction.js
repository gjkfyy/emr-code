Ext.define('iih.mr.archive.patient_mediclRecord_archive.action.MediclRecordSearchAction', {
    	extend: 'Xap.ej.action.ServiceInvocation',
    	execute: function(context) {
    		var enPk=Ext.getCmp('patientandmediclrecordview').pk;
    		if(context.event != undefined && context.event.name=='combochange' && context.event.from.rawValue != ""){
    			return;
    		}
    		this.showLoading();
    		var pageNum,pageSize;
    		if(context.event == undefined){
    			pageNum = context.pageNum; 
    			pageSize = context.pageSize; 
    		}else{
    			pageNum = context.event.arguments[0]; 
    			pageSize = context.event.arguments[1]; 
    		}
    		var medicalBlock = Ext.getCmp('mediclrecordviewid').getBlock('content');
    		medicalBlock.pageSize = pageSize;
    		var data = {
    				enPk : enPk,
    				pageNum:pageNum,
    				pageSize:pageSize
    		};
        	var owner = Ext.getCmp('mediclrecordviewid');
            var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
            properties.setData({
                parentWindow: context.parentWindow,
                sourceView: context.sourceView,
                pageSize:pageSize,
                pageNum:pageNum
            });
        	var operations = context.operations;
        	if(!operations) {
        		return;
        	}
        	this.prepareOperations(operations,data);
        },
        
        prepareOperations: function(operations,data) {
            var view = Ext.getCmp('mediclrecordviewid').getBlock('condition');
            var block = Ext.getCmp('mediclrecordviewid').getBlock('content');
        	var condition = view.getData();
        	if(data.enPk != undefined){
        		condition.enPk = data.enPk;
        	}
            var url = this.url;
            var pageNum = data.pageNum; 
    		var pageSize = data.pageSize; 
            if(condition) {
                var qs = Ext.Object.toQueryString(condition);
                	if(data.pageSize == undefined || typeof(data.pageSize)=='object'){
                		if(qs) {
                			url += '?' + qs; //+"&workScreen=" + iih.mr.qa.QaStatusGlobal.workScreenWorkProcess;
                		}else{
                			url += '?';// +"&workScreen=" + iih.mr.qa.QaStatusGlobal.workScreenWorkProcess;
                		}
                	}else{
                		if(qs) {
                    		url += '?' + qs+"&pageNum="+ pageNum +"&pageSize="+ pageSize;//+"&workScreen=" + iih.mr.qa.QaStatusGlobal.workScreenWorkProcess 
                		}else{
                			url +='?' + "pageNum="+ pageNum +"&pageSize="+ pageSize;// + "&workScreen=" + iih.mr.qa.QaStatusGlobal.workScreenWorkProcess
                		}
                	}
                console.log(url);
            }
            var mclass = null;
            if(block.getModelClass) {
                mclass = block.getModelClass();
            }
        	var operation = {
                url: url,
        		mclass: mclass,
        		method: 'get',
        		condition: condition,
        		scope: this,
        		success: this.onSuccess
        	};
        	operations.length = 0;
        	operations.push(operation);
        },

        onSuccess: function(operation) {
        	var block = Ext.getCmp('mediclrecordviewid').getBlock('content');
            if(block){
    	        var pageSize =block.pageSize;//取的是上面保存的block.pageSize值
    	        var m = operation.result;
    	        m.pageSize = pageSize;
    	        if(m){
	    	        if(m instanceof Ext.data.Model) {
	    	            block.setData({
	    	                mclass: operation.mclass,
	    	                data: m.getData(true)
	    	            });
	    	        }
	    	        else {
	    	        	block.setData(m);
	    	        	console.log(m);
	    	        }
	    	     
	            }
            }
            var grid =block.down('xapgrid');
            var mydata=grid.getStore().data.items;
            for (var i = 0; i < mydata.length; i++) {
				if(mydata[i].data.arcF!=1){
					grid.getSelectionModel().select(i,true,true);
				}
			}
            var reds=grid.getSelectionModel().getSelection();
    		var btn=Ext.getCmp('mediclrecordviewid').getBlock('condition').down('button[name=uploadFileBtn]');
    		if(reds&&reds.length>0){
    			btn.setDisabled(false);
    		}else{
    			btn.setDisabled(true);
    		}
	        if(mydata!=null&&mydata.length<1){
	        	this.getOwner().ownerCt.close();
	        }
        }
    });
