Ext.define('iih.mr.wr.mr.action.SelectedPrintAction', {
    extend: 'iih.mr.action.editor.EmrEditorOperatorAction',
//    userName:'',
    /*
    * @Override
    */
    execute: function(context) {
    	var plugin = document.getElementById('iemrEditor');
	    if(plugin.IsModified()){
            Ext.MessageBox.alert('提示', '当前修改未保存，请保存后重试！');
        }else{
            plugin.PrintContinue();
        }
    }
});
