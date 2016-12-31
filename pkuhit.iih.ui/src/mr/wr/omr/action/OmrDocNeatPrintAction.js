Ext.define('iih.mr.wr.omr.action.OmrDocNeatPrintAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	 * @Override
	 */
	execute: function(context) {
		var showPrintWindow=true;
		if(context.submitF&&context.submitF==1){//第三方socket调用刷新处置后提交标识
			showPrintWindow=false;
		}
		var plugin = document.getElementById('iemrEditor');
	    if(plugin.IsModified()){
            Ext.MessageBox.alert('提示', '当前修改未保存，请保存后重试！');
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
