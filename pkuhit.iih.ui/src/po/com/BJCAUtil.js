Ext.define("iih.po.com.BJCAUtil", {
	     singleton: true,
	
	XTXAPP: null,
	SVSCOM: null,
	GETKEYPIC: null,
	//初始化com组件
	init: function(){
	    try{
    	    XTXAPP = document.getElementById("bj_ca_xtx");
    	    var version = XTXAPP.SOF_GetVersion();
    	    console.log(version);
    	    SVSCOM = document.getElementById("bj_ca_dsvs");
    	    var random = SVSCOM.GenRandom(6);
    	    console.log(random);
    	    GETKEYPIC = document.getElementById("bj_ca_pic");
            var pic = this.GetKeyPic();
    	    console.log(pic);
	    }catch(e){
	        console.log(e.message);
	        return false;
	    }
	    return true;
	},
	
	//初始化com组件
    reInit: function(){
        try{
            XTXAPP = document.getElementById("bj_ca_xtx2");
            SVSCOM = document.getElementById("bj_ca_dsvs2");
            GETKEYPIC = document.getElementById("bj_ca_pic2");
        }catch(e){
            console.log(e.message);
            return false;
        }
        return true;
    },
    
	//获取用户列表 并填充到证书列表
	GetList: function(){
	    try{
    	    var strUserList = XTXAPP.SOF_GetUserList();
	    }catch(e){
            console.log(e.message);
            return null;
        }
	    return strUserList;
	},
	
	//登录
	login: function(showInfo, strUserName, strPin, strServerCert, strServerRan, strServerSignedData){
	    if (strPin.length < 6 || strPin.length > 16) {
	        showInfo.setValue('<font color=red>密码长度应该在6-16位之间!</font>');
	        return null;
	    }
	    //客户端验证服务端签名
	    if(!this.VerifySignedData(strServerCert,strServerRan,strServerSignedData))
	    {
	        showInfo.setValue('<font color=red>验证服务器签名失败!</font>');
            return null;
	    }
	    //校验密码
	    if(!XTXAPP.SOF_Login(strUserName,strPin))
	    {   
	        var retryCount = XTXAPP.SOF_GetPinRetryCount(strUserName);
	        if (retryCount > 0) {
	            showInfo.setValue('<font color=red>校验证书密码失败!您还有' + retryCount + '次机会重试!</font>');
	            return null;
	        } else if (retryCount == 0) {
	            showInfo.setValue('<font color=red>您的证书密码已被锁死,请联系BJCA进行解锁!</font>');
                return null;
	        } else {
	            showInfo.setValue('<font color=red>登录失败!</font>');
                return null;
	        }   
	    }
	    //导出客户端证书
	    var userCert = this.GetSignCert(strUserName);
	    if (userCert == null || userCert == "") {
	        showInfo.setValue('<font color=red>导出用户证书失败!</font>');
            return null;
	    }
	    //检查证书有效期
	    if (!this.CheckValid(showInfo, userCert)) {
	        return null;
	    }
	    // 客户端证书对随机数做签名
	    var strClientSignedData = this.SignedData(strUserName,strServerRan);
	    if (strClientSignedData == null || strClientSignedData == "") {
	        showInfo.setValue('<font color=red>客户端签名失败!</font>');
	        return null;
	    }
	    //客户端证书验证
	    var i_ret = this.CertisValid(userCert);
	    if (i_ret != 0) {
            if (i_ret == -1) {
                showInfo.setValue('<font color=red>证书不是所信任的根!</font>');
            } else if (i_ret == -2) {
                showInfo.setValue('<font color=red>证书超过有效期!</font>');
            } else if (i_ret == -3) {
                showInfo.setValue('<font color=red>证书已作废!</font>');
            } else if (i_ret == -4) {
                showInfo.setValue('<font color=red>证书已加入黑名单!</font>');
            } else if (i_ret == -5) {
                showInfo.setValue('<font color=red>证书未生效!</font>');
            } else {
                showInfo.setValue('<font color=red>证书验证失败!</font>');
            }
            return null;
        }
	    //获取证书唯一标识
	    var uniqueId = XTXAPP.SOF_GetCertInfoByOid(userCert, "1.2.156.112562.2.1.1.1");
        if (uniqueId==null || uniqueId==""){
            return -1;
        }
        uniqueId = uniqueId.substr(uniqueId.indexOf("SF")+2);
        console.log('uniqueId = ' + uniqueId);
        return uniqueId;
	},
	
	//客户端验证服务端签名
	VerifySignedData: function(cert,indata,signvalue){
	    return XTXAPP.SOF_VerifySignedData(cert,indata,signvalue);
	},
	
	//签名证书
	GetSignCert: function(strContainerName){
	    if(!Ext.isFunction(XTXAPP.SOF_ExportUserCert))
	        this.reInit();
	    var UserCert = XTXAPP.SOF_ExportUserCert(strContainerName);
	    return UserCert;
	},
	
	//判断证书有效期天数
	CheckValid: function(showInfo, userCert){
	    // 日期类型格式化方法的定义
	    Date.prototype.Format = function(fmt) 
	    {
    	    var o = { 
    	        "M+" : this.getMonth()+1,                 //月份 
    	        "d+" : this.getDate(),                    //日 
    	        "h+" : this.getHours(),                   //小时 
    	        "m+" : this.getMinutes(),                 //分 
    	        "s+" : this.getSeconds(),                 //秒 
    	        "q+" : Math.floor((this.getMonth()+3)/3), //季度 
    	        "S" : this.getMilliseconds()             //毫秒 
    	    }; 
    	    if(/(y+)/.test(fmt)) 
    	        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
    	    for(var k in o) 
    	        if(new RegExp("("+ k +")").test(fmt)) 
    	    fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length))); 
    	    return fmt; 
	    };
	    var strNotBefore = XTXAPP.SOF_GetCertInfo(userCert,this.CERT_NOT_BEFORE);
	    var notBeforeDate = strNotBefore.substring(0,4)+"/"+strNotBefore.substring(4,6)+"/"+strNotBefore.substring(6,8);
	    var nowDate = new Date().Format("yyyy/MM/dd");
	    var days = (Date.parse(notBeforeDate) - Date.parse(nowDate)) / (1000*60*60*24);
	    if (days > 0) {
	        showInfo.setValue('<font color=red>您的证书尚未生效!距离生效日期还剩' + days + '天!</font>');
	        return false;
	    }
	    var strNotAfter = XTXAPP.SOF_GetCertInfo(userCert, this.CERT_NOT_AFTER);
	    var notAfterDate = strNotAfter.substring(0,4)+"/"+strNotAfter.substring(4,6)+"/"+strNotAfter.substring(6,8);
	    var nowDate = new Date().Format("yyyy/MM/dd");
	    days = (Date.parse(notAfterDate) - Date.parse(nowDate)) / (1000*60*60*24);
	    
	    if (days <= -45) {
	        showInfo.setValue('<font color=red>您的证书已过期' + days + '天，超过了最后使用期限,请尽快更新!</font>');
	        return false;
	    }
	    if (days >= 0 && days <= 60) {
	        alert("您的证书还有" + days + "天过期，请尽快更新!");
	        return true;
	    }
	    if (days < 0) {
	        alert("您的证书已过期 "+ -days +" 天，请尽快更新!");
	    }
	    return true;
	},
	
	SignedData: function(sContainerName,sInData){
	    if(!Ext.isFunction(XTXAPP.SOF_SignData))
            this.reInit();
	    if (sContainerName != null)
	        return XTXAPP.SOF_SignData(sContainerName,sInData);
	    else
	        return "";
	},
	
	CertisValid: function(cert){
	    var i_ret = SVSCOM.ValidateCertificate(cert);
        return i_ret;
	},
	
	GetKeyPic: function(){
	    if(!Ext.isFunction(GETKEYPIC.GetPic))
            this.reInit();
        var i_ret = GETKEYPIC.GetPic();
        return i_ret;
    }
});