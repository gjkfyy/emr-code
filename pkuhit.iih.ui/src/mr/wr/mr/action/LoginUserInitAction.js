Ext.define('iih.mr.wr.mr.action.LoginUserInitAction', {
	extend : 'Xap.ej.action.ServiceInvocation',

	/*
	 * @Override
	 */
	execute : function(context) {
		//this.getOwner().ownerCt.closable=false;
		this.getOwner().ownerCt.addListener('close', function(){
			var plugin = document.getElementById('iemrEditor');
            plugin.EnableOCX(true);
	        });
	}
});
