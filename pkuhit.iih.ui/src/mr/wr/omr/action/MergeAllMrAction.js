Ext.define('iih.mr.wr.omr.action.MergeAllMrAction', {
    extend: 'iih.mr.action.editor.EmrEditorOperatorAction',
    
    /*
     * @Override
     */
    execute: function(context) {
    	var me=this;
        var mrList=this.getOwner().mrList;
        setTimeout(function() {
        	var plugin = document.getElementById('iemrEditor');
            for(var i=0;i<mrList.length;i++){
            	if(i>0){
            		var fileData=mrList[i].fileData;
            		plugin.InsertFromString(fileData,1);
            	}
            }
            var emrSave = 'com.founder.iemr.editor.toolbar:emrSave';//保存
            var emrSubmit = 'com.founder.iemr.editor.toolbar:emrSubmit';//提交
            var emrRevoke = 'com.founder.iemr.editor.toolbar:emrRevoke';//撤销
            var emrDocProperty='com.founder.iemr.editor.toolbar:emrDocProperty';//属性
            var emrStartApprove='com.founder.iemr.editor.toolbar:emrStartApprove';//开始审签
            var emrApprove='com.founder.iemr.editor.toolbar:emrApprove';//审签
            var emrAuditRevoke='com.founder.iemr.editor.toolbar:emrAuditRevoke';//审签撤回
            var emrReject = 'com.founder.iemr.editor.toolbar:emrReject';//驳回
            var emrDocDelete = 'com.founder.iemr.editor.toolbar:emrDocDelete';//删除
            var emrRefreshMacro = 'com.founder.iemr.editor.toolbar:emrRefreshMacro';//刷新宏元素
            var emrRefreshDiagnosis = 'com.founder.iemr.editor.toolbar:emrRefreshDiagnosis';//刷新诊断
            var emrImageLibraries = 'com.founder.iemr.editor.toolbar:emrImageLibraries';//插入图片
            var emrContinuePrint = 'com.founder.iemr.editor.toolbar:emrContinuePrint';//续打
            var emrSelectContinuePrint = 'com.founder.iemr.editor.toolbar:emrSelectContinuePrint';//选页打印
            var emrSaveAsTemplate = 'com.founder.iemr.editor.toolbar:emrSaveAsTemplate';//病历另存为模板
            var emrRefreshOutpatientDisposal='com.founder.iemr.editor.toolbar:emrRefreshOutpatientDisposal';//刷新门诊处置
            setTimeout(function() {
    			plugin.SetCommandVisible(emrSave,false);
    			plugin.SetCommandVisible(emrContinuePrint,false);
                plugin.SetCommandVisible(emrSubmit,false);
                plugin.SetCommandVisible(emrRevoke,false);
                plugin.SetCommandVisible(emrDocDelete,false);
                plugin.SetCommandVisible('com.founder.iemr.editor.toolbar:emrNeatPrint',false);
                plugin.SetCommandVisible(emrRefreshMacro,false);
                plugin.SetCommandVisible(emrRefreshDiagnosis,false);
                plugin.SetCommandVisible(emrImageLibraries,false);
                plugin.SetCommandVisible(emrRefreshOutpatientDisposal,false);
//                plugin.SetCommandVisible(emrRefreshMacro,false);
                
                //删除空区域
                var sections = plugin.GetSections();
                var sectionNames="";
				for(var i=0;i<sections.length;i++){
					if(sectionNames==""){
						sectionNames=sections[i];
					}else{
						sectionNames=sectionNames+'\n'+sections[i];
					}
				}
				var emptySectionNames=new Array(0);
				if(sectionNames.length>0){
	                var sectionContents = plugin.ExportSections(sectionNames);
	                var sectionContentsJson=JSON.parse(sectionContents);
	                for(var i=0;i<sections.length;i++){
	                	var secionName=sections[i];
	                	var sectionContent=sectionContentsJson[secionName];
	                	var newContent=sectionContent.replace(secionName+':','');
	                	newContent=newContent.replace(secionName+'：','');
	                	if(!newContent||newContent.length==0){
	                		emptySectionNames.push(secionName);
	                	}
	                	if(emptySectionNames.length>0){
	                		plugin.RemoveSections(emptySectionNames);//删除空白区域
	                	}
	                }
				}
                //删除空表格
                var tabList = plugin.GetTables();
    			var arrayObj = new Array(0);
    			if(tabList){                	    		
    				for(var i=0;i<tabList.length;i++){
    					var tabName = tabList[i];
    					var tabContent =plugin.ExportTable(tabName);
    					if(!(tabContent&&tabContent.length>0)){
    						arrayObj.push(tabName);
    					}
    				}
    			} 
    			plugin.RemoveTables(arrayObj);//删除空白表格
    			plugin.SetModified(false);
    			plugin.SetReadOnly();
    			setTimeout(function() {
    				plugin.UpdateToolbar();
    				me.closeProgress();
            		plugin.ShowOCX(true);
    			},250);
    		}, 250);
        },200);
    }
});
