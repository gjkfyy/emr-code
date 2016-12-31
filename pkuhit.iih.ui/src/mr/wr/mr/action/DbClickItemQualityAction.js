Ext.define('iih.mr.wr.mr.action.DbClickItemQualityAction', {
	extend : 'Xap.ej.action.ServiceInvocation',

	/*
	 * @Override
	 */
	execute : function(context) {
		var createmrdocview= this.getOwner().up('createmrdocview');
		var quality= createmrdocview.getBlock('bottom').getActionChain('quality');
		quality.execute();
	}
});
