Ext.define('iih.mr.wr.omr.action.CreateErpSingAction', {
	extend : 'Xap.ej.action.PopAction',
	requires : [ 'iih.mr.wr.omr.view.CreateErpSignView' ],
	id : 'createErpSingAction',
	/*
	 * @Override
	 */
	execute : function(context) {
		var erpSignType = context.erpSignType;
		var title = '浏览签名';
		if (erpSignType && 'erpSign' == erpSignType) {
			title = '电子签名';
		}
		var config = {
			modal : true,
			width : 915,
			height : erpSignType=='erpSign'?560:530,
			title : title,
			contentConfig : {
				xtype : 'createerpsignview',
				initChain : {
					name : 'init',
					context : context
				}
			}
		};
		this.callParent([ config ]);
		// var createerpsignview=Ext.getCmp('createErpSingAction');
		// createerpsignview.erpSignType=context.erpSignType;
	}

});
