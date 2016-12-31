/** 
 * 完成本次整改
 * @author ：yao_lijie
 */
Ext.define('iih.mr.qa.process_qa_reform.action.DefectFinishRfmAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	doExecute: function(context) {
	        this.prepareOperations(context);
	 },
	 prepareOperations: function(context) {
		var me = this;
	    var owner = this.getOwner();   
	    var revisionCd = owner.revisionCd;
    	//储存画面间参数
	    var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        properties.setData({
        	revisionCd:revisionCd  //整改通知编码
        });
		var operations = context.operations;
		
        var url = this.url;
        url+= '/' + revisionCd;
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
    },

    onSuccess: function(operation) {
	 	XapMessageBox.info("整改成功");
	 	var view = this.getOwner();
		var bottomBlock = this.getBlock('bottom');
	    var defectGrid = bottomBlock.down('xapgrid');
//		var rfmBtn = bottomBlock.down('xapgrid xapbutton[action=rfm]');    //整改按钮
		var finishRfmBtn = bottomBlock.down('xapgrid xapbutton[action=finishRfm]');    //本次质控完成确认
//		rfmBtn.setDisabled(true);
		if(view.tabId != 'orderRfmdefectview'){
			var properties = view.getLayer(Xap.ej.block.Layer.PROPERTIES);
	        var revisionCd = properties.getData().revisionCd
			//刷新
			var initChain = view.getActionChain('init');
	    	if(initChain) {
	    		initChain.execute({
		        	rownum:0,
	        		revisionCd: revisionCd
	        	});
	    	}
		}
    	finishRfmBtn.setDisabled(true);
		/*//编辑器只读
		var plugin = document.getElementById('iemrEditor'); 
		if(plugin){
			plugin.SetReadOnly();
			plugin.OfficeCommand('com.founder.iemr.editor.toolbar:emrBrowsMode'); 
//			plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrSave',false);
//			plugin.UpdateToolbar();
		}*/
    }
});
