Ext.define('iih.mr.wr.mr.action.MrPrintAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    /*
     * @Override
     */
    execute: function(context) {
        var operations = context.operations;
        if(!operations) {
            return;
        }
        
        var plugin = document.getElementById('iemrEditor');
        var arrayObj = new Array(0);
    	var emptyParagNames = new Array(0);
    	/*if(tabList){                	    		
    		for(var i=0;i<tabList.length;i++){
	    		var tabName = tabList[i];
	    		var tabContent =plugin.ExportTable(tabName);
	    		if(!(tabContent&&tabContent.length>0)){
	    			arrayObj.push(tabName);
	    		}
	    	}
    	}    */            	    	
    	plugin.PrintEx(emptyParagNames,arrayObj,true);
    }
});
