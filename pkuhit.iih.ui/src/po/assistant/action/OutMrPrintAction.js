Ext.define('iih.po.assistant.action.OutMrPrintAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	 * @Override
	 */
	execute: function(context) {
		var showPrintWindow=true;
		//获取当前打开的助手区病历文书
		var plugin = document.getElementById('iemrEditorRead');
	    if(undefined == plugin){
            XapMessageBox.info('请打开需要打印的文书！');
            return;
        }else{
        	var tabList = plugin.GetTables();
	    	var arrayObj = new Array(0);
	    	var emptyParagNames = new Array(0);
	    	if(tabList){                	    		
	    		for(var i=0;i<tabList.length;i++){
    	    		var tabName = tabList[i];
    	    		var tabContent =plugin.ExportTable(tabName);
    	    		if(!(tabContent&&tabContent.length>0)){
    	    			arrayObj.push(tabName);
    	    		}
    	    	}
	    	}                	    	
//	    	alert(showPrintWindow);
	    	plugin.PrintEx(emptyParagNames,arrayObj,showPrintWindow);
	        //审签后设置编辑器为只读
//	        plugin.SetReadOnly();
	    	if(CONFIG_PARAM.MR_PRINT_OP_LOG_UEE){//是否记录打印日志
	    		var mrPrintOPLog = this.getOwner().getActionChain('mrPrintOPLog');
	            if(mrPrintOPLog) {
	            	mrPrintOPLog.execute();
	            }
	    	}
        }
    }
});
