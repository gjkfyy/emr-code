Ext.define('iih.mr.wr.mr.action.CloseProgressAction', {
    extend: 'iih.mr.action.editor.EmrEditorOperatorAction',
//    userName:'',
    /*
    * @Override
    */
    execute: function(context) {
    	var owner=this.getOwner();
    	var page=owner.ownerCt;
    	if(page.tabId&&page.tabId=="mr_doc_helper"){
    		var bolck=page.getBlock('left');
        	var tree=bolck.down('xaptree');
        	tree.enable();
        	this.closeProgress();//关闭进度条
    	}
    }
});
