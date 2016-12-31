Ext.define('iih.mr.wr.nmr.action.CloseImageElement', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
		console.info("进入了关闭新建窗体");
		//console.info(document.getElementById("ret").value);//json
		console.info(this.getOwner().newValue);
		console.info(this.getOwner().ownerCt);
		this.getOwner().ownerCt.close();
//		ocx = document.getElementById("graphicocx");
//		//path = document.getElementById("path").value;
//		params = document.getElementById("params").value;
//		console.info(params);
//		ret = ocx.GraphicNew('C:\\Users\\sun_yuhang\\Desktop\\GraphicEdit\\resources',params);  //ocx中的新建图像方法
//		document.getElementById("ret").value=ret;
    },
    
});