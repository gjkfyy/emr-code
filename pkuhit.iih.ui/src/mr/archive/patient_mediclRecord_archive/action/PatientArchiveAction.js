Ext.define('iih.mr.archive.patient_mediclRecord_archive.action.PatientArchiveAction', {
    	extend: 'Xap.ej.action.ServiceInvocation',
    	execute: function(context) {
    		this.getOwner().getEl().mask('正在处理中，请稍候......');
    		var enPk=context.record.data.pk;//患者编号
    		//确认了归档将enPk传到后台
    		this.prepareOperations(context.operations,enPk);
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
        	var date=operation.result.dataList;
        	var defeat=0;
        	var succeed=0;
        	if(date!=null){
	        	for (var i = 0; i < date.length; i++) {
					if(date[i].result!=0){
						defeat++;
					}else{
						succeed++;
					}
				}
        	}
        	var succeedMsg="succeed+'份病历归档成功。"; 
        	if(defeat>0){
        		if(succeed>0){
        			Ext.Msg.alert('提示',succeedMsg+defeat+'份病历归档失败,请重新选择归档!');
        		}else{
        			Ext.Msg.alert('提示',defeat+'份病历归档失败,请重新选择归档!');
        		}
        	}else{
        		Ext.Msg.alert('提示','归档成功');
        	}
        	
        	var search=Ext.getCmp('patientandmediclrecordview').getActionChain("search");
        	search.execute();
        	
        }
       
    });
