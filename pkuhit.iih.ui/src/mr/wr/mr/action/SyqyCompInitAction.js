Ext.define('iih.mr.wr.mr.action.SyqyCompInitAction', {
    extend: 'Xap.ej.action.ServiceInvocation',

    execute: function(context) {
		var zkonline = document.getElementById("zkonline");
		zkonline.FPEngineVersion = "10";
		zkonline.FakeFunOn = 1;	//防止假指纹
		zkonline.EnrollCount=3;	//设置按指纹次数
		zkonline.CheckFinger='1111011111';
		var self=this;
		//zkonline.SetLanguageFile=ZKOnline.chs;
		if (zkonline.Register()){
			   for(i = 1; i < 11; i++)
			   {		   
				   var zkRegFTL="";
				   try
				   {
					   zkRegFTL=zkonline.GetRegFingerTemplate(i);
				   }
				   catch(err)
				   {
					   console.log(err.message);
				   }
					if (zkRegFTL&&zkRegFTL.length >= 2)
					{
						var str;
						var Base64Jpg;
						  try
						   {
							   str= zkonline.GetRegFingerTemplate(i);
							   Base64Jpg= zkonline.GetFpImageEx(i);
						   }
						   catch(err)
						   {
							   console.log(err.message);
						   }
						var plugin = document.getElementById('iemrEditor');
						//var reg=new RegExp("\r\n","g");
						plugin.SelectElement("MR.M.013.D.1");
						plugin.OfficeCommand(".uno:GoRight");
						plugin.ImportImage(Base64Jpg.replace(/\r\n/g,""),1);
						//Ext.Msg.alert('提示',"指纹信息录入成功");
						var win=self.getOwner().ownerCt;
						if(win)
						win.close();
					}
				}
			 }else{
				 Ext.Msg.alert('提示',"指纹录入失败");
				 var win=self.getOwner().ownerCt;
					if(win)
					win.close();
			 }
    }
});
