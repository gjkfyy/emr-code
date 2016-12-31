Ext.define('iih.mr.wr.omr.action.EditorCallBackAction', {
    extend: 'Xap.ej.action.ServiceInvocation',

    
    /*
    * @Override
    */
    execute: function(context) {
    	var self=this;
    	var operations = context.operations;
        if(!operations) {
            return;
        }
    	var opType=this.getOwner().opType;
    	var gui = require('nw.gui');
		var win = gui.Window.get();
		var page = this.getOwner();
		win.on('close', function() {
			var a=this;
			var plugin = document.getElementById('iemrEditor');
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
			                } else if (btn == 'no') {
			                	close();
			                } else if (btn == 'cancel') {
			                }
			            },win
			        );
	        }else{
				a.close(true);
			}
		});
    	if(opType.indexOf('new')>-1){
    		setTimeout(function() {
    			var plugin = document.getElementById('iemrEditor');
    			plugin.EnableOCX(false);
    			//图片签名
    			var omrUseSign=self.getOwner().getActionChain("omrUseSign");
    			omrUseSign.execute();
    			
    			//设置编辑器按钮状态
        		var disabledOfficeToolBarAction=self.getOwner().getActionChain("disabledOfficeToolBarAction");
        		disabledOfficeToolBarAction.execute();
        		
        		//刷新宏元素
        		var emrRefreshMacro=self.getOwner().getActionChain("emrRefreshMacro");
        		emrRefreshMacro.execute();
        		
        		var emrRefreshDiagnosis=self.getOwner().getActionChain("emrRefreshDiagnosis");
        		emrRefreshDiagnosis.execute();
        		
        		/*var emrRefreshPrescription=self.getOwner().getActionChain("emrRefreshOutpatientDisposal");
        		emrRefreshPrescription.execute();*/
   		 	},450);
    		self.prepareOperations(operations);
    		//设置newF为1，则刷新宏元素后会自动刷新引用元素
    		self.getOwner().newF=1;
    		
    	}else if ('open'==opType){
            //设置编辑器按钮状态
    		var disabledOfficeToolBarAction=self.getOwner().getActionChain("disabledOfficeToolBarAction");
    		disabledOfficeToolBarAction.execute();
    	}else if ('reSelect'==opType){
    		this.getOwner().opType='open';
    		setTimeout(function() {
    			var emrRefreshMacro=self.getOwner().getActionChain("omrUseSign");
        		emrRefreshMacro.execute({'userId':IMER_GLOBAL.user.code});
   		 	},400);
    		
    		
    		//设置编辑器按钮状态
    		var disabledOfficeToolBarAction=self.getOwner().getActionChain("disabledOfficeToolBarAction");
    		disabledOfficeToolBarAction.execute();
    		
    		//刷新宏元素
    		var emrRefreshMacro=this.getOwner().getActionChain("emrRefreshMacro");
    		emrRefreshMacro.execute();
    		
    		var emrRefreshDiagnosis=this.getOwner().getActionChain("emrRefreshDiagnosis");
    		emrRefreshDiagnosis.execute();
    		self.prepareOperations(operations);
    	}
    	setTimeout(function() {
    		var plugin = document.getElementById('iemrEditor');
    		plugin.GotoMark('');
//    		plugin.SwitchRedline(2, IMER_GLOBAL.user.name);
//    		plugin.ShowRedline(0);
//    		plugin.SetModified(false);
    		plugin.EnableOCX(true);
    		if(IMER_GLOBAL.mr.encounterIsOver){//cis诊毕，打开病历同时刷新处方并提交
    		    setTimeout(function() {
                    iih.po.com.hisToiemrUtil.encounterOver();
                    IMER_GLOBAL.mr.encounterIsOver = null;
    		    },2000);
            }
		},1000);
    },
    
    prepareOperations: function(operations) {
        var url=this.url+'/SYSM01.6';
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
		var parms=operation.result.dataList;
		console.log(parms);
		console.log(IMER_GLOBAL.department.code);
		for(parm in parms ){
			if(parms[parm].value==IMER_GLOBAL.department.code){
				//如果当前科室设置了不自动刷新处方，则退出此方法，不执行刷新处方的chain
				return;
			}
		}
		console.log('emrRefreshPrescription');
		var emrRefreshPrescription=this.getOwner().getActionChain("emrRefreshOutpatientDisposal");
		emrRefreshPrescription.execute();
    }
});
