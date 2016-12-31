Ext.define('iih.mr.wr.nsv.action.NurScoreDocNeatPrintAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	 * @Override
	 */
	execute: function(context) {
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
	    	plugin.PrintEx(emptyParagNames,arrayObj,true);
	        //审签后设置编辑器为只读
//	        plugin.SetReadOnly();
        }
    }
});
