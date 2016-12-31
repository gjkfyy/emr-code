Ext.define('iih.mr.archive.patient_mediclRecord_archive.action.PatientListArchiveAction', {
    	extend: 'Xap.ej.action.ServiceInvocation',
    	execute: function(context) {
    		var view=this.getOwner();
    		var grid=view.getBlock('content').down('xapgrid');
    		var s= grid.getSelectionModel().getSelection();
    		//s是个list带有选中的数据行 		
    		if(s.length<1){
    			Ext.Msg.alert('提示','请选中病历后归档!');
    			return;
    		}
    		this.getOwner().getEl().mask('正在处理中，请稍候......'); 
    		var str="";
    		for (var i = 0; i < s.length; i++) {
    			str+=s[i].data.pk+",";
			}
    		str=str.substring(0, str.length-1);
    		this.prepareOperations(context.operations,str);
    	},
        
        prepareOperations: function(operations,data) {
            var operation = {
                    url:this.url+"/"+data,
                    method:'get',//METHOD_CREATE,
                    //data: data,
                    scope: this,
                    success: this.onSuccess
                    // fail: this.onFail
                };
            operations.push(operation);
        },
        onSuccess: function(operation) {
        	this.getOwner().getEl().unmask();   
        	if(operation.result.data.resultCount>0){
        		Ext.Msg.alert('提示',operation.result.data.resultCount+'位患者失败,请重新选择归档!');
        	}else{
        		Ext.Msg.alert('提示','归档成功');
        	}
        	var search=Ext.getCmp('patientandmediclrecordview').getActionChain("search");
        	search.execute();
        	
        }
    });
