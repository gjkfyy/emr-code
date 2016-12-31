Ext.define('iih.mr.wr.mr.action.MrDocCanEditAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	 * @Override
	 */
	execute: function(context) {
	    var operations = context.operations;
        if(!operations) {
            return;
        }
        var medicalRecord=this.getOwner().medicalRecord;
        this.prepareOperations(operations,medicalRecord);
    },
    
    prepareOperations: function(operations,data) {
        var METHODS = this.getInvocationMethods();
        var url=this.url+'/'+data.mrPk;
        var operation = {
            url: url,
            method: METHODS.METHOD_CREATE,
            data:data,
            scope: this,
            success: this.onSuccess,
            fail: this.onFail
        };
        operations.push(operation);
    },
    onSuccess: function(returnData) {
        var plugin = document.getElementById('iemrEditor');
        this.getOwner().medicalRecord=returnData.result.data;
        var medicalRecord=returnData.result.data;
        if(medicalRecord.canEdit==1){
        	plugin.SetCommandVisible('com.founder.iemr.editor.toolbar:emrReadOnly', true);
    		plugin.SetCommandVisible('com.founder.iemr.editor.toolbar:emrEdit', false);
        	plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrSave', true);
            plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrDocDelete',true);
            plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrDocProperty',true);
            plugin.EditDocument();
            plugin.UpdateToolbar();
        }else{
        	Ext.Msg.alert('提示','编辑申请失败!');
        }
        Ext.Msg.alert('提示','编辑申请成功!');
    },
    onFail: function(operation) {
    	 plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrSave', false);
    	 plugin.UpdateToolbar();
        Ext.Msg.alert('提示','编辑申请失败!');
    }
});
