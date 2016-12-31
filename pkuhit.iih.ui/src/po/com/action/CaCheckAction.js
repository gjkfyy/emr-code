Ext.define('iih.po.com.action.CaCheckAction', {
	extend: 'Xap.ej.action.Action',
	
	requires:['iih.po.com.BJCAUtil','iih.po.com.NetCAUtil'],
	/*
	* @Override
	*/
	execute: function(context) {
    	this.callParent();
    	var view = this.getOwner();
    	var block = this.getBlock('lvblock');
        var showInfo = block.down('xapdisplayfield');
        showInfo.setValue(null);
        var username = block.down('xaptextfield[name=username]');
        var causer = block.down('xapcombobox[name=causer]');
        var password = block.down('xaptextfield[name=password]');
        var capass = block.down('xaptextfield[name=capass]');
        var rememberCheck = block.down('xapcheckboxgroup[name=rememberCheck]');
        var data = block.getForm().getValues();
        if(data.caLogin){
            //BJCA登录
            if(CONFIG_PARAM.CA_SUBJECT == 1){
                //检测BJCA客户端环境
                if(!iih.po.com.BJCAUtil.init()){
                    showInfo.setValue('<font color=red>请检查证书应用环境是否正确安装!</font>');
                    return;
                }
                //获取证书用户列表
                var strUserList = iih.po.com.BJCAUtil.GetList();
                if(strUserList){
                    var array = new Array();
                    while (1) {
                        var i = strUserList.indexOf("&&&");
                        if (i <= 0 ) {
                            break;
                        }
                        var strOneUser = strUserList.substring(0, i);
                        var strName = strOneUser.substring(0, strOneUser.indexOf("||"));
                        var strUniqueID = strOneUser.substring(strOneUser.indexOf("||") + 2, strOneUser.length);
                        array.push({'text':strName,'value':strUniqueID});
                        var len = strUserList.length;
                        strUserList = strUserList.substring(i + 3,len);
                    }
                    causer.setData(array);
                    var record = causer.getStore().getAt(0);
                    causer.select(record);
                }else{
                    showInfo.setValue('<font color=red>获取证书用户列表失败!</font>');
                    causer.clearValue();
                }
            }
            //网政通CA登录
            if(CONFIG_PARAM.CA_SUBJECT == 2){
                //检测网政通CA客户端环境
                if(!iih.po.com.NetCAUtil.isPKIInstalled()){
                    showInfo.setValue('<font color=red>请检查证书应用环境是否正确安装!</font>');
                    return;
                }
                var cert = iih.po.com.NetCAUtil.SelectMyCert(1, "IssuerCN~'NETCA'", 1, 0);
                if (cert == null) 
                {
                    showInfo.setValue('<font color=red>请插入网证通证书!</font>');
                    return;
                }
                var strUniqueID = iih.po.com.NetCAUtil.GetCertExtensionStringValue(cert,"1.3.6.1.4.1.18760.1.12.11");
                var strName = iih.po.com.NetCAUtil.getX509CertificateInfo(cert, 12);
                if(strUniqueID && strName){
                    var array = new Array();
                    array.push({'text':strName,'value':strUniqueID});
                    causer.setData(array);
                    var record = causer.getStore().getAt(0);
                    causer.select(record);
                }else{
                    showInfo.setValue('<font color=red>获取证书用户失败!</font>');
                    causer.clearValue();
                }
            }
            username.hide();
            causer.show();
            password.hide();
            capass.setValue(null);
            capass.show();
        }else{
            username.show();
            causer.hide();
            causer.clearValue();
            password.show();
            capass.setValue(null);
            capass.hide();
        }
    }
});
