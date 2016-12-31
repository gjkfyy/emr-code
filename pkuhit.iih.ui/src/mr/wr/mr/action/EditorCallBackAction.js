Ext.define('iih.mr.wr.mr.action.EditorCallBackAction', {
    extend: 'Xap.ej.action.ServiceInvocation',

    
    /*
    * @Override
    */
    execute: function(context) {
    	var self=this;
    	var opType=this.getOwner().opType;
    	var editorName="iemrEditor";
    	if("readonly"==opType){
    		editorName="iemrEditorRead";
    	}
    	var plugin = document.getElementById(editorName);
    	var printable=this.getOwner().ownerCt.printable;
    	if(printable==undefined){
    		printable=this.getOwner().printable;
    	}
    	var gui = require('nw.gui');
		var win = gui.Window.get();
		var page = this.getOwner();
		win.on('close', function() {
			var a=this;
			if(plugin&&plugin.valid&&plugin.IsModified()){
//				alert('当前对病历所做修改未保存，是否保存？');
				var close=function(){
					a.close(true);
				};
				XapMessageBox.confirm('是否保存对当前病历的修改？',
			            function(btn, text){
			                if (btn == 'yes') {
			                	var saveActionChain=page.getActionChain('emrSave');
			                	saveActionChain.execute({callback:close});
//			                    return me.callMethod(yesCallback, me);
			                } else if (btn == 'no') {
			                	close();
			                } else if (btn == 'cancel') {
//			                    return me.callMethod(cancelCallback, me);
			                }
			            },page
			        );
				/*
	            FuiMessageBox.confirm('当前对病历所做修改未保存，是否保存？', function(btn) {
					console.log(btn);
	                if (btn == 'yes') {
	                    self.doSave(function(){
							a.close(true);
	                    },mrDocEditPage);
	                }else if (btn == 'cancel'){
	                    
	                }else{
						a.close(true);
					}
	            });*/
	        }else{
				a.close(true);
			}
		});
		setTimeout(function() {
			plugin.EnableOCX(false);
			console.log('----------plugin.EnableOCX(false);------------');
		 	},750);
    	if('new'==opType){
    		self.getOwner().count=0;
    		
    		//设置编辑器按钮状态
    		var disabledOfficeToolBarAction=self.getOwner().getActionChain("disabledOfficeToolBarAction");
    		disabledOfficeToolBarAction.execute();
    		
    		//刷新宏元素
    		var emrRefreshMacro=this.getOwner().getActionChain("emrRefreshMacro");
    		emrRefreshMacro.execute();
    		
    		var emrRefreshDiagnosis=this.getOwner().getActionChain("emrRefreshDiagnosis");
    		emrRefreshDiagnosis.execute();
    		
    		//设置newF为1，则刷新宏元素后会自动刷新引用元素
    		this.getOwner().newF=1;
    	}else if ('open'==opType){
    		var operations = context.operations;
            if(!operations) {
                return;
            }
            //设置编辑器按钮状态
    		var disabledOfficeToolBarAction=self.getOwner().getActionChain("disabledOfficeToolBarAction");
    		disabledOfficeToolBarAction.execute();
    		//判断是否为审签模式
    		var medicalRecord=self.getOwner().medicalRecord;
    		medicalRecord.xmlFileData=plugin.ExportXML();
    		if(medicalRecord.canApprove&&medicalRecord.canApprove==1){
//    			console.log('----------------------plugin.ShowRedline(1);');
    			self.openPrepareOperations(operations);
    		}
    	}else if('readonly'==opType){
    		if(printable!=undefined&&printable==true){
                //设置编辑器按钮状态
        		var disabledOfficeToolBarAction=self.getOwner().getActionChain("disabledOfficeToolBarAction");
        		disabledOfficeToolBarAction.execute();
    		}
    	}
//		plugin.GotoSection('主诉',true);
    	plugin.GotoMark('');
		plugin.SetModified(false);
		setTimeout(function() {
			plugin.EnableOCX(true);
			console.log('----------plugin.EnableOCX(true);------------');
		},900);
    },
    openPrepareOperations: function(operations) {
    	var url=this.url+'?userId='+IMER_GLOBAL.user.code;
        var operation = {
            url: url,
            method: 'get',
            scope: this,
            success: this.onSuccess,
            fail: this.onFail
        };
        operations.push(operation);
    },
    onSuccess: function(operation) {
    	var user=operation.result.data;
        var plugin = document.getElementById('iemrEditor');
        //设置审签痕迹
        var signatureLevel=0;
        if('MRM02.03'==user.signLevelCode){
        	signatureLevel=2;
        	
        }else if('MRM02.04'==user.signLevelCode){
        	signatureLevel=3;
        }
//        console.log('----------plugin.SwitchRedline(signatureLevel, user.id);------------');
        //signatureLevel传0为停止记录修订，1为无下划线，2为1条下划线，3为2条下划线分别对应停止记录修订痕迹，一级审签、二级审签和三级审签
        plugin.SwitchRedline(signatureLevel, user.id);
        plugin.ShowRedline(1);
//        console.log('----------plugin.SwitchRedline('+signatureLevel+',' +user.id+');------------');
        setTimeout(function() {
        	//将编辑器对文档自动做的修改（此处为设置审签痕迹），设置为未发生修改，因为医生未修改文书内容
            plugin.SetModified(false);
        },200);
        
    }
});
