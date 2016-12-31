Ext.define('iih.mr.tm.mr.action.MrTypeCdChangeAction', {
	extend: 'Xap.ej.action.Action',
	
	/*
	* @Override
	*/
	execute: function(context) {
	// console.log('---------------MrTypeCdChangeAction-----------------');
	 var rs = this.getBlock('result');   
	 //找到combox的框值
	 var text = context.event.arguments[0].rawValue;
	 var singlevelcode = context.event.arguments[0].getValue();
	 
	 //将值放到模板名称中
	 //console.log(text);
	// console.log( 'context.event.arguments[0].getStore().count:'+context.event.arguments[0].getStore().getCount() );
	 if(context.event.arguments[0].getStore().getCount() > 0){
		// console.log(context.event.arguments[0].getStore().data.items[0].raw );
		// console.log(context.event.arguments[0] );
		// console.log(context.event.arguments[0].lastSelection[0].raw);
		if( context.event.arguments[0].lastSelection.length > 0 ){
			 var comsignLevelCode = rs.down('[name=signLevelCode]');
			 var singlevelcode = context.event.arguments[0].lastSelection[0].raw.signLevelCode ;
			 comsignLevelCode.setValue(singlevelcode);
			 var mrTplNm  = rs.down('[name=mrTplNm]') ;
			 var properties = this.getOwner().getLayer(Xap.ej.block.Layer.PROPERTIES);
			 //console.log('------' + properties.data.customerData ) ;
			  if(properties.data.customerData=='new'){
			  //病历模板页面为新建时，设置病历模板名称
		    	mrTplNm.setValue( context.event.arguments[0].lastSelection[0].raw.name);
			  }
			  if(properties.data.customerData=='edit'){
			  }
		}
	 }

    }
});
