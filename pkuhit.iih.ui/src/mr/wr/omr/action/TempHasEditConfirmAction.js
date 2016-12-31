Ext.define('iih.mr.wr.omr.action.TempHasEditConfirmAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

	requires: ['iih.mr.wr.omr.view.CreateOmrView',
	           'iih.mr.wr.omr.view.CreateOmrDocView',
	           'iih.mr.wr.omr.view.PastMrSelectView'],
	/*
	* @Override
	*/
	execute: function(context) {
		var owner=this.getOwner();
		var omrDocEditPage=this.getOwner().getBlock('right');
		var callback=function(){
			var create=owner.getActionChain('showDoctor');
			create.execute();
		};
		if(omrDocEditPage.hasEdit()){
			XapMessageBox.confirm('是否保存对当前病历的修改？',
	            function(btn, text){
	                if (btn == 'yes') {
	                	var saveActionChain=omrDocEditPage.getActionChain('emrSave');
	                	saveActionChain.execute({callback:callback});
	                } else if (btn == 'no') {
	                	callback();
	                } else if (btn == 'cancel') {
	                	
	                }
	            },omrDocEditPage
	        );
		}else{
			callback();
		}
    }
});
