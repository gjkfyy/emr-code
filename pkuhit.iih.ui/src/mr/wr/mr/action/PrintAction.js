Ext.define('iih.mr.wr.mr.action.PrintAction', {
     extend: 'Xap.ej.action.ServiceInvocation',
//    userName:'',
    /*
    * @Override
    */
    execute: function(context) {
    	var owner = this.getOwner();
    	var opType=this.getOwner().opType;
        var editorName="iemrEditor";
    	if("readonly"==opType){
    		editorName="iemrEditorRead";
    	}
    	var plugin = document.getElementById(editorName);
    	if(this.getOwner().ownerCt.printTimesLimit==true){
    		var medicalRecord= this.getOwner().medicalRecord;
    		if(medicalRecord.statusCode!='MRM04.02'){
    			Ext.MessageBox.alert('提示', '该病历尚未提交，不可打印，请联系您的医生提交后再试！');
    			return;
    		}
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
			plugin.PrintEx(emptyParagNames,arrayObj,false);
    	}else{
    	    if(plugin.IsModified()){
                Ext.MessageBox.alert('提示', '当前修改未保存，请保存后重试！');
            }else{			
            	var arrayObj = new Array(0);
    	    	var emptyParagNames = new Array(0);
    	    	plugin.PrintEx(emptyParagNames,arrayObj,true);
    	    	if(CONFIG_PARAM.MR_PRINT_OP_LOG_UEE){//是否记录打印日志
    	    		var mrPrintOPLog = owner.getActionChain('mrPrintOPLog');
    	            if(mrPrintOPLog) {
    	            	mrPrintOPLog.execute();
    	            }
    	    	}
            }
    	}
    },mrCheckPrint: function(operations,mrPk) {
    	
        var METHODS = this.getInvocationMethods();
        var url=this.url+"/"+mrPk;
        var operation = {
            url: url,
            method: METHODS.METHOD_CREATE,
            scope: this,
            success: this.onSuccess,
            fail: this.onFail
        };
        operations.push(operation);
    }, onSuccess: function(returnData) {
    	if(returnData.result.data.checkPrint==false){
    		Ext.MessageBox.alert('提示', '超出打印次数，请到服务台打印！');
    		return;
    	}else{
		var plugin = document.getElementById("iemrEditorRead");
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
			plugin.PrintEx(emptyParagNames,arrayObj,false);
		var mrbPrint =this.getOwner().getActionChain("mrbPrint");
	    	mrbPrint.execute();
			}
    }
});