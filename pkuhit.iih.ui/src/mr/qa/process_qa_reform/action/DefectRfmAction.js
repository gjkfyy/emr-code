/** 
 * 整改
 * @author ：yao_lijie
 */
Ext.define('iih.mr.qa.process_qa_reform.action.DefectRfmAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	doExecute: function(context) {
	    this.prepareOperations(context);
	 },
	 prepareOperations: function(context) {
		var me = this;
		var topBlock = this.getBlock('top');
		var mrPkFirst = topBlock.mrPk;
	    var sbmtTimeFirst = topBlock.sbmtTime;
	    var qaFltPkFirst = topBlock.qaFltPk;
		var resultBlock = this.getBlock('bottom');
	    var defectGrid = resultBlock.down('xapgrid');
	    /*var selModel = defectGrid.getSelectionModel();
	    var record = selModel.getSelection()[0];*/
	    var record = context.record;
	    var faultPk;
	    if(record == undefined){
			XapMessageBox.info("请选择一条缺陷");
		}else{
			//修改缺陷状态以当前打开文书为准
			var mrPk = record.data.mrPk;
	   		var sbmtTime = record.data.sbmtTime;
//	   		if(mrPk != ""){
				var owner = this.getOwner();
				var topBlock = this.getBlock('top');
				var workView = topBlock.down();  //获取病历编辑器页面
				var plugin = document.getElementById('iemrEditor'); 
				
//	   		}
	   		if(mrPk != ""  && mrPkFirst != mrPk && mrPkFirst != undefined){
				if(sbmtTimeFirst != null && sbmtTimeFirst != sbmtTime){
					faultPk = qaFltPkFirst;
					XapMessageBox.info("当前打开文书与所选中缺陷不一致，以文书为准");
					return null;
				}else{
					if(plugin&&plugin.valid&&plugin.IsModified()){
						var emrSave = workView.getActionChain('emrSave');
			    		if(emrSave){
				        	emrSave.execute({});
				    	}
					}
					if(plugin&&plugin.valid){
						setTimeout(function() {
			        		plugin.SetReadOnly();
							plugin.OfficeCommand('com.founder.iemr.editor.toolbar:emrBrowsMode'); 
			        	},250);
					}
					faultPk = record.data.qaFltPk;
				}
	   		}else{
	   			if(mrPk != ""){
	   				if(plugin&&plugin.valid&&plugin.IsModified()){
						var emrSave = workView.getActionChain('emrSave');
			    		if(emrSave){
				        	emrSave.execute({});
				    	}
					}
					if(plugin&&plugin.valid){
						setTimeout(function() {
			        		plugin.SetReadOnly();
							plugin.OfficeCommand('com.founder.iemr.editor.toolbar:emrBrowsMode'); 
			        	},250);
					}
	   			}
	   			faultPk = record.data.qaFltPk;
	   		}
			var operations = context.operations;
	        var url = this.url;
	        url+= '/' + faultPk;
	        console.log(url);
	    	var operation = {
	            url: url,
	    		mclass: null,
	    		method: 'put',
	    		condition: null,
	    		scope: this,
	    		success: this.onSuccess
	    	};
	    	operations.length = 0;
	    	operations.push(operation);
	    }
    },

    onSuccess: function(operation) {
        
    	var me = this;
		
	    var owner = this.getOwner();   
	    
	    var revisionCd = owner.revisionCd;
	    
    	//储存画面间参数
	    var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        properties.setData({
        	revisionCd:revisionCd  //整改通知编码
        });
    	//刷新
    	var chain = this.getBlock('bottom').ownerCt.getActionChain('init');
    	if(chain) {
        	chain.execute({
	        	rownum:0,
        		revisionCd: revisionCd
        	});
    	}
    	
    	/*var resultBlock = this.getBlock('bottom');
	    var defectGrid = resultBlock.down('xapgrid');
		var rfmBtn = resultBlock.down('xapgrid xapbutton[action=rfm]');    //整改按钮
		rfmBtn.setDisabled(true);*/
    }
});
