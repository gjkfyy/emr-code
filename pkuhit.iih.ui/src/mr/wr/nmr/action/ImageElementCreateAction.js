Ext.define('iih.mr.wr.nmr.action.ImageElementCreateAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
		var path = require('path');
		var nwPath = process.execPath;
		var nwDir = path.dirname(nwPath);
		ocx = document.getElementById("graphicocx");
		var jsonValue= this.getOwner().newValue;		
		ret = ocx.GraphicNew(nwDir+'\\img resources',jsonValue);  //ocx中的新建图像方法
		var picbase64= ret.substring(ret.lastIndexOf(":")+2,ret.length-2);
		var plugin = document.getElementById('iemrEditor');
		plugin.ImportImage(picbase64.replace(/\s+/g,""),1);
		this.getOwner().ownerCt.close();
		
    },
    
});
