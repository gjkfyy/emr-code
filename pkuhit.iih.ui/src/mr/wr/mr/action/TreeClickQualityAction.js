Ext.define('iih.mr.wr.mr.action.TreeClickQualityAction', {
	extend : 'Xap.ej.action.ServiceInvocation',

	/*
	 * @Override
	 */
	execute : function(context) {
		if(CONFIG_PARAM.CRT_MR_YN_QUALITY){
			//enPk qaItmTpCd qaMrType QAM06.03 依赖质控
			var tplTree = Ext.getCmp('mrTempSortTree');
		       //病历文书类型
			var treeNode = tplTree.getSelectionModel().getSelection();
			var treeNodeData=treeNode[0].raw.data;
		    var qaMrType= treeNodeData.templateTypeCode;
		    var enPk=IMER_GLOBAL.encounterSn;
			var data={"enPk":enPk,"qaMrType":qaMrType};
			this.openPrepareOperations(context.operations,data);
		}else{
			var confim= this.getOwner().getActionChain('showDoctor');
	    	confim.execute();
		}
	},
    openPrepareOperations: function(operations,data) {
    	var url=this.url+"?enPk="+data.enPk+"&qaMrType="+data.qaMrType;
    	var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            method: METHODS.METHOD_GET,
            scope: this,
            success: this.onSuccess,
            fail: this.onFail
        };
        operations.push(operation);
    },
    onSuccess: function(operation) {
    	if(operation.result.data!=null&&operation.result.data.validateResult==1){
    		Ext.Msg.alert('提示',operation.result.data.msg);
    		return;
    	}
    	var confim= this.getOwner().getActionChain('showDoctor');
    	confim.execute();
    }
});
