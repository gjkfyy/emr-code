Ext.define('iih.mr.tm.mr.action.MrTemplatePrintAction', {
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
    	if(!Ext.isEmpty(plugin.SaveToString(),false)){
    	    if(plugin.IsModified()){
                Ext.MessageBox.alert('提示', '当前修改未保存，请保存后重试！');
            }else{
            	plugin.PrintEx(emptyParagNames,arrayObj,true);
            }
    	}else{
    		Ext.MessageBox.alert('提示', '当前模板未保存，请保存后重试！');
    	}
    }
});
