Ext.define('iih.mr.tm.mr.action.ChangeTemplatePropertyEditAction', {
	extend: 'Xap.ej.action.Action',
	
	/*
	* @Override
	*/
	execute: function(context) {
	 //console.log(context);
	 var rs = this.getBlock('result');   
	 //console.log(context.event.arguments[0].rawValue);
	 //找到combox的框值
	 var text =context.event.arguments[0].rawValue
	 //将值放到模板名称中
	 rs.down('[name=mrTemplateNm]').setValue(text);       
	 //console.log(rs);
    }
});
