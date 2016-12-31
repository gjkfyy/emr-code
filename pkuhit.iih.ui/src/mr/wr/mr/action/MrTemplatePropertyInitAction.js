Ext.define('iih.mr.wr.mr.action.MrTemplatePropertyInitAction', {
	extend : 'Xap.ej.action.PopAction',

	requires : [ 'iih.mr.tm.mr.view.MrTemplatePropertyEditView' ],
	/*
	 * @Override
	 */
	execute : function(context) {
		var mr = this.getOwner().mr;
		var enTypeCode;
		var enTypeCode;
		if(IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_1 || IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_8 ){
			enTypeCode = 'ENM01.01';
		}else if(IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_2){
			enTypeCode = 'ENM01.04';
		}
		this.getOwner().enTypeCode = enTypeCode;
		var templeCode = mr.templeCode;
		var config = {
			modal : true,
			height : 280,
			width : 530,
			title : '模板属性',
			contentConfig : {
				xtype : 'mrTemplatePropertyEditView',
				initChain : {
					name : 'init',
					context : {
						customerData : 'readOnly',
						verMrTplKc : templeCode,
						sourceView : this.getOwner()
					}
				}
			}
		};
		this.callParent([ config ]);
	}
});
