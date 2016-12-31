Ext.define('iih.mr.tm.fr.action.FrTplEditReleaseAction', {
    extend: 'Xap.ej.action.ServiceInvocation',  
    
    doExecute: function(context) {
    	console.log('--------------------- FrTplEditReleaseAction -----------------------------------');
    	var operations = context.operations;
    	var owner = this.getOwner();
        //模板id//rb instanceof Array
        var dataList =[];
        var mrFrTplCd = owner.mrFrTplCd;
        var opType = owner.opType;
        var plugin = document.getElementById('iemrEditor');
	    plugin.tagName = 'ext';
        var data = {};
        if(opType=='new'){
        	data.nm = owner.title;
        	data.memo = owner.memo;
        	data.mrFrTplTpCd = owner.mrFrTplTpCd;
        	data.odtFile = plugin.SaveToString();
        	data.statusCode ='release';
        	this.addPrepareOperations(operations,data);
        }else if(opType=='open'){
        	dataList.push(mrFrTplCd);
        	data ={"ids":dataList};
            this.prepareOperations(operations,data);
        }
    },

    prepareOperations: function(operations,data) {       
        var url = this.url;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_CREATE,
            condition: null,
            data:data,
            scope: this,
            success: this.onOpenSuccess
            // fail: this.onFail
        };
        operations.push(operation);
    },
    
    onOpenSuccess: function(operation) {
		var plugin = document.getElementById('iemrEditor');
		var emrSave = 'com.founder.iemr.editor.toolbar:emrSave';//保存
        var emrRelease = 'com.founder.iemr.editor.toolbar:emrRelease';//保存
		plugin.SetCommandEnable(emrSave,false);
		plugin.SetCommandEnable(emrRelease,false);
		plugin.UpdateToolbar();
		var msg = '启用成功!!!';
		XapMessageBox.info(msg);
        /*var owner = this.getOwner();
        var listView = owner.ownerCt.down('basicTemplateListView');
        var grid = listView.down('bastemplatelistblock');
        var pageNum = grid.currentPage;
        var chain = listView.getActionChain('init');
        if(!chain) {
            //如果没找到chain执行结果
            console.log("faile");
            console.log(chain);            
            //chain = owner.getActionChain('init');
        }
        if(chain) {
            chain.execute({
            	pageNum:pageNum,
            	pageSize:'25'
            });
        }*/
    },
    
    addPrepareOperations: function(operations,data) {
        var METHODS = this.getInvocationMethods();
        var url = 'mr/tpl/frtpl';
        console.log(url);
        var operation = {
            url: url,
            method: METHODS.METHOD_CREATE,
            data:data,
            scope: this,
            success: this.onAddSuccess,
            fail: this.onFail
        };
        operations.push(operation);
    },
    
    onAddSuccess: function(returnData) {
    	var editBasTem = this.getOwner();
    	editBasTem.opType='open';
    	var plugin = document.getElementById('iemrEditor');
    	editBasTem.code = returnData.result.data.code;
    	var emrSave = 'com.founder.iemr.editor.toolbar:emrSave';//保存
        var emrRelease = 'com.founder.iemr.editor.toolbar:emrRelease';//保存
		plugin.SetCommandEnable(emrSave,false);
		plugin.SetCommandEnable(emrRelease,false);
		plugin.UpdateToolbar();
        var msg = '启用成功!!!';
		XapMessageBox.info(msg);
    },
    onFail: function(operation) {
    	var msg = '启用成功!!!';
		XapMessageBox.info(msg);
    }
});
