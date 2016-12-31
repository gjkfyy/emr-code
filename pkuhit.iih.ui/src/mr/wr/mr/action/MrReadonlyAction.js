Ext.define('iih.mr.wr.mr.action.MrReadonlyAction', {
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
    	if(plugin.IsModified()){
//    		var emrSaveAction=this.getOwner().getActionChain('emrSave');
//    		emrSaveAction.execute(context);
    		Ext.Msg.alert('提示','当前文档发生修改，请保存后进行只读操作!');
    		return false;
    	}
    	var medicalRecord=this.getOwner().medicalRecord;
    	medicalRecord.xmlFileData=plugin.ExportXML();
    	medicalRecord.txtFileData=plugin.ExportText();//获取病历文本
    	this.prepareOperations(operations,medicalRecord);
    },
    prepareOperations: function(operations,medicalRecord) {
        var METHODS = this.getInvocationMethods();
        var url=this.url+'/'+medicalRecord.mrPk;
        var operation = {
            url: url,
            method: METHODS.METHOD_DELETE,
            data:medicalRecord,
            scope: this,
            success: this.onSuccess,
            fail: this.onFail
        };
        operations.shift();
        operations.push(operation);
    },
    onSuccess: function(returnData) {
    	var plugin = document.getElementById('iemrEditor');
    	plugin.SetReadOnly();
		plugin.SetCommandVisible('com.founder.iemr.editor.toolbar:emrReadOnly', false);
		plugin.SetCommandVisible('com.founder.iemr.editor.toolbar:emrEdit', true);
		plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrSave', false);
		plugin.UpdateToolbar();
    },
    onFail: function(operation) {
    	 plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrSave', false);
    	 plugin.UpdateToolbar();
        Ext.Msg.alert('提示','只读申请失败!');
    }
});
