Ext.define('iih.mr.wr.nmr.action.NmrEditorCallBackAction', {
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
//    			plugin.ImportMacroValue('MR.M.013.D.37', IMER_GLOBAL.user.name);//进行签名
    			//设置编辑器按钮状态
        		var disabledOfficeToolBarAction=self.getOwner().getActionChain("disabledOfficeToolBarAction");
        		disabledOfficeToolBarAction.execute();
        		
        		//刷新宏元素
        		var emrRefreshMacro=self.getOwner().getActionChain("emrRefreshMacro");
        		emrRefreshMacro.execute();
        		
        		//if(self.getOwner().medicalRecord.typeCode=='MRM16.105')//入院病人护理评估单
        		//{
        			var emrSplData=self.getOwner().getActionChain("emrSplData");
        			emrSplData.execute();
        		//}
//        		var emrRefreshDiagnosis=self.getOwner().getActionChain("emrRefreshDiagnosis");
//        		emrRefreshDiagnosis.execute();
        		
        		/*var emrRefreshPrescription=self.getOwner().getActionChain("emrRefreshOutpatientDisposal");
        		emrRefreshPrescription.execute();*/
   		 	},450);
//    		self.prepareOperations(operations);
    		//设置newF为1，则刷新宏元素后会自动刷新引用元素
//    		self.getOwner().newF=1;
    		
    	}else if ('open'==opType){
            //设置编辑器按钮状态
    		var disabledOfficeToolBarAction=self.getOwner().getActionChain("disabledOfficeToolBarAction");
    		disabledOfficeToolBarAction.execute();
    		
    	}/*else if ('reSelect'==opType){
    		this.getOwner().opType='open';
    		setTimeout(function() {
    			var plugin = document.getElementById('iemrEditor');
    			plugin.ImportMacroValue('MR.M.013.D.26', IMER_GLOBAL.user.name);//进行签名
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
    	}*/
    	setTimeout(function() {
    		var plugin = document.getElementById('iemrEditor');
    		plugin.GotoMark('');
//    		plugin.SwitchRedline(2, IMER_GLOBAL.user.name);
//    		plugin.ShowRedline(0);
//    		plugin.SetModified(false);
         	var owner = Ext.getCmp('nursingrecordsview');
            var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
    		var mergeXmlDataToTemplate  ;
    		var refreshMacro ;
			if(properties.data){
				mergeXmlDataToTemplate = properties.data.mergeXmlDataToTemplate ;
				refreshMacro = properties.data.refreshMacro
				if(mergeXmlDataToTemplate){
					if(refreshMacro){
			       		//刷新宏元素
		        		var emrRefreshMacro=self.getOwner().getActionChain("emrRefreshMacro");
		        		emrRefreshMacro.execute();
					}
					var xmlFileData = properties.data.xmlFileData ;
					//如果需要合并xml到odt中
					plugin.ImportXML(xmlFileData);
					//合并后保存
					var nursingrecordscontentview = Ext.getCmp('nursingrecordscontentview') ;
					var emrSaveAction = nursingrecordscontentview.getActionChain('emrSave');
					emrSaveAction.execute();
				}
				//重置参数为默认值
	             properties.setData({
	                 mergeXmlDataToTemplate:false
	             });
			}
    		plugin.EnableOCX(true);
		},700);
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
