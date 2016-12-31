Ext.define('iih.mr.tm.mr.action.TemplateResetConfimAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

	/*
	* @Override
	*/
	doExecute: function(context) {
		console.log('---------------------- TemplateResetConfimAction --------------------------------');
	    var operations = context.operations;
	    var view = this.getOwner();
	    var grid = view.down('bastemplateresetlistblock');
	    var records = grid.getSelectionModel().getSelection();
	    var properties = view.getLayer(Xap.ej.block.Layer.PROPERTIES);
	    var owner = view.ownerCt;  
	    if(records.length>0){
	    	owner.close();
	    	properties.data.basCode = records[0].data.code;
	    	this.prepareOperations(operations,records[0].data.filePk);
	    }else{
	    	var msg = '请选择基础模板!';
    		XapMessageBox.info(msg);
	    }
    },
    
    prepareOperations: function(operations,data) {  
    	var url = 'mr/tpl/smbtcr?filePk='+data;
    	var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: METHODS.GET,
            data: data,
            scope: this,
            success: this.onSuccess,
            fail: this.onFail
        };
        operations.push(operation);
    },
    
    onSuccess: function(operation) {
    	var result = operation.result;
    	var file = result.data.odtFile;
    	var plugin = document.getElementById('iemrEditor');
	    plugin.tagName='ext';
	    var temp = plugin.SaveToString();
	    //plugin.CloseDocument();
	    plugin.OpenFromString(file,2);
	    plugin.InsertFromString(temp,0);
	    //控制按钮0
	    var me = this;
        var emrStartApprove ='com.founder.iemr.editor.toolbar:emrStartApprove';//开始审签
        setTimeout(function() {
        	plugin.SetCommandVisible(emrStartApprove,false);
        	plugin.UpdateToolbar();
        },350);
        
        //更新基础模板编码
        var view = this.getOwner();
        var properties = view.getLayer(Xap.ej.block.Layer.PROPERTIES);
        var sourceView = properties.data.sourceView;
        var code = sourceView.code,basCode,chain;
    	basCode = properties.data.basCode;
    	sourceView.baseTemplateCode = basCode;
    	sourceView.templateReset = 'reset';
    	/*chain = view.getActionChain('save');
    	if(!chain) {
             //如果没找到chain执行结果
             console.log("faile");   
        }
        if(chain) {
             chain.execute({
             	code:code,
             	basCode:basCode
             });
        }*/
    	return;
    },
    
    onFail: function(operation) {
    	return;
    }
});
