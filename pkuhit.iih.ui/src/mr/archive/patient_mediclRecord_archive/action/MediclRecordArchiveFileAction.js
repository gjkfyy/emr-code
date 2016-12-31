Ext.define('iih.mr.archive.patient_mediclRecord_archive.action.MediclRecordArchiveFileAction', {
    	extend: 'Xap.ej.action.ServiceInvocation',
    	execute: function(context) {
    		this.getOwner().getEl().mask('正在处理中，请稍候......'); 
    		var view=this.getOwner();
    		var grid=view.getBlock('content').down('xapgrid');
    		var s= grid.getSelectionModel().getSelection();
    		var btn=view.getBlock('condition').down('button[name=uploadFileBtn]');
    		var dataList =[];
    		btn.setDisabled(true);//归档按钮致灰
    		//获取患者病历mr_pk
    		for(var i=0;i<s.length;i++){
    			dataList.push(s[i].data);
    	    }
    	    //参照接口文件，多条记录启用
    		//"archiveUserId":IMER_GLOBAL.user.code
    		var data ={"list":dataList};
    		this.prepareOperations(context.operations,data);
    		//将mrpks传入后台进行处理
        },
        
        prepareOperations: function(operations,data) {
        	var view=this.getOwner();
    		var block=view.getBlock('content');
        	 var mclass = null;
             if(block.getModelClass) {
                 mclass = block.getModelClass();
             }
        	var METHODS = this.getInvocationMethods();
            var operation = {
                    url:this.url,
                    mclass:mclass,
                    method:METHODS.METHOD_UPDATE,//METHOD_CREATE,
                    data: data,
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
        	//返回所有odt文档
        	var succeedMsg=succeed+"份病历归档成功。"; 
        	if(defeat>0){
        		if(succeed>0){
        			Ext.Msg.alert('提示',succeedMsg+defeat+'份病历归档失败,请重新选择归档!');
        		}else{
        			Ext.Msg.alert('提示',defeat+'份病历归档失败,请重新选择归档!');
        		}
        	}else{
        		Ext.Msg.alert('提示','归档成功');
        	}
        	var search=Ext.getCmp('mediclrecordviewid').getActionChain("search");
        	search.execute();
        	
        	var view=this.getOwner();
        	var btn=view.getBlock('condition').down('button[name=uploadFileBtn]');
    		btn.setDisabled(false);
        }
       
    });
