Ext.define('iih.mr.wr.nsv.action.HasEditConfirmAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

	requires: [],
	/*
	* @Override
	*/
	execute: function(context) {
		//验证新建前是否修该过文档
		var owner=this.getOwner();
		var nmrDocEditPage=this.getOwner().getBlock('right');
		var callback=function(){
			var create=owner.getActionChain('showcreateview');
			create.execute();
		};
		if(nmrDocEditPage.hasEdit()){
			XapMessageBox.confirm('是否保存对当前病历的修改？',
	            function(btn, text){
	                if (btn == 'yes') {
	                	var saveActionChain=nmrDocEditPage.getActionChain('emrSave');
	                	saveActionChain.execute({callback:callback});
	                } else if (btn == 'no') {
	                	callback();
	                } else if (btn == 'cancel') {
	                	
	                }
	            },nmrDocEditPage
	        );
		}else{
			callback();
		}
    }
});
