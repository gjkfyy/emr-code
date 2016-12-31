Ext.define('iih.mr.wr.mr.action.MrTemplateInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
	    var owner = this.getOwner();   
		var opType = context.opType;
		owner.opType=opType;
//		console.log('MrTemplateInitAction');
//		console.log(owner);
		var ccatCode = context.id;
		var omrDocEditPage=context.omrDocEditPage;
		var workpageview = context.workpageview;
		//储存画面间参数
	    var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        properties.setData({
        	ccatCode:ccatCode,    //树节点中选择的病历文书分类
        	opType:opType,
        	omrDocEditPage:omrDocEditPage,
        	workpageview:workpageview  //得到当前打开的病历文书页面
        });
    }
});
