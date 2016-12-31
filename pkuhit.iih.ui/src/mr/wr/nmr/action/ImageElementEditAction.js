Ext.define('iih.mr.wr.nmr.action.ImageElementEditAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
		console.info("进入了修改图片");
		ocx = document.getElementById("graphicocx");
		//path = document.getElementById("path").value;
		var jsonValue= this.getOwner().newValue;
		//params = document.getElementById("ret").value;//params
		ret = ocx.GraphicModify('C:\\Users\\sun_yuhang\\Desktop\\GraphicEdit\\resources',jsonValue);  //ocx中的修改图像方法
		//document.getElementById("ret").value=ret;
		this.getOwner().newValue=ret;
		
    },
    
});
