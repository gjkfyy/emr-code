Ext.define('iih.mr.wr.nmr.action.NmrDocProgressBarAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
		//该方法主要为了弹进度条
		this.showSubmitProgressBar();
		var self=this;
		setTimeout(function() {
			var saveDocProgressBar=self.getOwner().getActionChain('saveDocProgressBar');
			console.info(saveDocProgressBar);
			saveDocProgressBar.execute({context:context});
		},500);
    }
});
