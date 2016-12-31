Ext.define('iih.mr.tm.mr.action.EditorCallBackAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    /*
    * @Override
    */
    execute: function(context) {
//    	Ext.MessageBox.hide();
    	var self = this;
    	var opType = this.getOwner().ownerCt.opType;
    	var plugin = document.getElementById('iemrEditor');
    	if('new'==opType || 'saveAs'==opType){
    		//设置编辑器按钮状态
    		var disabledOfficeToolBarAction = self.getOwner().getActionChain("disabledOfficeToolBarAction");
    		disabledOfficeToolBarAction.execute();
    		
    		//设置newF为1，则刷新宏元素后会自动刷新引用元素
    		this.getOwner().newF=1;
    	}else if ('open'==opType){
    		var operations = context.operations;
            if(!operations) {
                return;
            }
            //设置编辑器按钮状态
    		var disabledOfficeToolBarAction=self.getOwner().getActionChain("disabledOfficeToolBarAction");
    		disabledOfficeToolBarAction.execute();
    	}
		plugin.GotoSection('主诉',true);
		plugin.SetModified(false);
    }
});
