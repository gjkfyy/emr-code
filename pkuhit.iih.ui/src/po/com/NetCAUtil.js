Ext.define("iih.po.com.NetCAUtil", {
	     singleton: true,
	
    initialObj: null,
    
	//判断控件是否安装成功
	isPKIInstalled: function(){
	    initialObj = document.getElementById("net_ca");
        try {
            utilObj = initialObj.CreateDeviceObject();
            if(typeof(utilObj).toString().indexOf("object") != -1){
                return true;
            }
            return false;
        }
        catch (e) {
            return false;
        }
    },
    
    /*-------------------数据编码--------------------------------(UTF-16BE的编码，暂时不支持)
     * 参数   encodetype  编码方式，可以是"Base64","UTF-8"
     * 参数   data        被编码的字节数据
     * 返回值             编码后的字符串
     */
    StrEncode: function(encodetype, data){
        var ecode;
        switch(encodetype){
            case "HEX":
                ecode = initialObj.BinaryToHex(data, true);
                break;
            case "hex":
                ecode = initialObj.BinaryToHex(data, false);
                break;
            case "Base64":
                ecode = initialObj.Base64Encode(data, NETCAPKI_BASE64_ENCODE_NO_NL);
                break;
            case "UTF-8":
                ecode = initialObj.Decode(encodetype, data);
                break;
            case "GBK":
                ecode = initialObj.Decode(encodetype, data);
                break;
            case "UTF-16LE":
                ecode = initialObj.Decode(encodetype, data);
                break;
        }
        return ecode;
    },
    
    /*------------------数据解码--------------------(UTF-16BE的编码，暂时不支持)
     *参数  encodetype   编码方式,可以是"Base64","UTF-8"
     *参数  str          编码字符串
     *返回值             解码后的字节数据
     */
    StrDecode: function(encodetype, str){
        var dcode;
        switch(encodetype){
            case "HEX":
                dcode = initialObj.HexToBinary(str, true);
                break;
            case "hex":
                dcode = initialObj.HexToBinary(str, false);
                break;
            case "Base64":
                dcode = initialObj.Base64Decode(str, NETCAPKI_BASE64_ENCODE_NO_NL);
                break;
            case "UTF-8":
                dcode = initialObj.Encode(encodetype, str);
                break;
            case "GBK":
                dcode = initialObj.Encode(encodetype, str);
                break;
            case "UTF-16LE":
                dcode = initialObj.Encode(encodetype, str);
                break;
        }
        return dcode;
    },
    
    /*--------------从多个证书里面选择一个证书（带私钥）-----------------------
     *参数  type       证书类型，1 签名证书， 2 加密证书
     *参数  filter     证书过滤条件，比如"IssuerCN~'NETCA'"。如果传空值，则不过滤
     *参数  guioption  证书选择框图形界面选项 1：只有一张证书时不弹提示框，否则弹框；
                                              2：只能有一张符合条件的证书；
                                              3：无论有无证书都要UI提示；
    *参数  from        证书来源，0：从设备读证书，1：从windows证书库读证书
    *返回值            成功返回证书对象
    */
    SelectMyCert: function(type, filter, guioption, from)
    {
        var oCert;  
        if (type == 1)
        {
            filter += "&&CertType='Signature'";
        }
        else if (type == 2)
        {
            filter += "&&CertType='Encrypt'";
        }       
        try
        {
            if (from == 0)
            {
                oCert = this.getX509CertificateFromKey(filter, guioption);
            }
            else if (from == 1)
            {
                oCert = this.getX509Certificate(filter, guioption);
            }
        }
        catch(e)
        {
            throw (NETCAPKI_ERROR_PREFIX_INFO + e);
        }
        return oCert;
    },
    
    /*----------------直接从USBKEY中获取证书-----------------------------
     * 参数 filter        证书筛选条件，例如"IssuerCN~'NETCA'"
     * 参数 guioption     证书选择框的形式，1：只有一个证书是不弹框，2：只能有一个符合条件的证书；3：始终有证书选择框
     */
    getX509CertificateFromKey: function(filter, guioption){
        var deviceSet;
        var deviceCount;
        var cert;
        try
        {
            deviceSet = initialObj.GetAllDevices(NETCAPKI_DEVICETYPE_ANY, NETCAPKI_DEVICEFLAG_CACHE_PIN_IN_PROCESS); 
        }
        catch(e)
        {
            throw (NETCAPKI_ERROR_2_ACTIVEXFAIL);
            return null;
        }
        
        deviceCount = deviceSet.Count;
        if (deviceCount <= 0)
        {
            throw (NETCAPKI_ERROR_8_ARG_NODEVICES);
            return null;
        }
        if (guioption == 1)
        {
            cert = deviceSet.FindCertificate(filter, 1); //在只有一个或没有证书的情况下，不弹出对话框让用户选择
        }
        else if (guioption == 2)
        {
            cert = deviceSet.FindCertificate(filter, 2); //从不弹出对话框让用户选择
        }
        else if (guioption == 3)
        {
            cert = deviceSet.FindCertificate(filter, 3); //总是弹出对话框让用户选择
        }
        if (cert == null)
        {
            throw (NETCAPKI_ERROR_1_NOCERT);
        }
        return cert;
    },
    
    /*-------------从证书库中获取证书--------------------------            
     * 参数 filter        证书筛选条件，例如"IssuerCN~'NETCA'"
     * 参数 guioption     证书选择框的形式，1：只有一个证书是不弹框，2：只能有一个符合条件的证书；3：始终有证书选择框
     */
    getX509Certificate: function(filter, guioption)
    {
        var storeObj;
        var cert;
        var count = 0;
        var storeLocation = 1;
        var storeName = 0;
        try
        {
            storeObj = initialObj.OpenStore(0, "my");
            if(storeObj == null)
            {
                throw (NETCAPKI_ERROR_2_ACTIVEXFAIL);
            }
        }
        catch(e)
        {
            throw (NETCAPKI_ERROR_2_ACTIVEXFAIL);
            return null;
        }
        count = storeObj.GetCertificateCount(); 
        if(count <= 0)
        {
            storeObj.Close();
            storeObj = null;
            throw NETCAPKI_ERROR_1_NOCERT;
            return null;
        }
            
        
        if (guioption == 1)
        {
            cert = storeObj.FindCertificate(filter, 1); //在只有一个或没有证书的情况下，不弹出对话框让用户选择
        }
        else if (guioption == 2)
        {
            cert = storeObj.FindCertificate(filter, 2); //从不弹出对话框让用户选择
        }
        else if (guioption == 3)
        {
            cert = storeObj.FindCertificate(filter, 3); //总是弹出对话框让用户选择
        }
        storeObj.Close();
        storeObj = null;
        if (cert == null)
        {
            throw (NETCAPKI_ERROR_1_NOCERT);
        }
        return cert;    
    },
    
    /*---------------数据电子签名----------------------
     * 参数 ocert       证书对象
     * 参数 content     被签名的内容，byte数组
     * 参数 isAttached  签名值是否带原文，0：不带原文，1：带原文
     * 参数 tsaurl      时间戳服务器URL
     * 参数 pin         密码
     * 返回值：P7签名
     */
    SignPKCS7: function(ocert, content, isAttached, tsaurl, pin)
    {

        var signObj;
        var certObj;
        var signAlgo;
        var pwd = pin;
        if (content == null || content == "")
        {
            throw (NETCAPKI_ERROR_PREFIX_INFO + NETCAPKI_ERROR_4_ARG_CONTENTEMPTY);
            return null;
        }
        if (ocert == null)
        {
            throw (NETCAPKI_ERROR_PREFIX_INFO + NETCAPKI_ERROR_5_ARG_CERTEMPTY);
            return null;
        }
        try{
            signObj = initialObj.CreateSignedDataObject(true);
        }
        catch(e) 
        {
            throw (NETCAPKI_ERROR_PREFIX_INFO + NETCAPKI_ERROR_2_ACTIVEXFAIL);
            return null;
        }

        if (signObj.SetSignCertificate(ocert, pwd, false) == false) 
        {
            throw ("设置签名证书失败");
            return null;
        }
        signAlgo = this.getAlgoFromCert(ocert);
        if (signAlgo == 2)
        {
            signObj.SetSignAlgorithm(-1,NETCAPKI_ALGORITHM_SHA1WITHRSA);
        }
        else if (signAlgo == 25)
        {
            signObj.SetSignAlgorithm(-1, NETCAPKI_ALGORITHM_SM3WITHSM2);
        }
        
        var str;
        if (isAttached == 0 || isAttached == "0" || isAttached == false) 
        {
            // 带原文
            signObj.Detached = true;
        }
        else {
            //不带原文
            signObj.Detached = false;
        }
        try
        {
            if (tsaurl == "") 
            {
                str = signObj.Sign(content, NETCAPKI_CMS_ENCODE_DER);
            }
            else 
            {
                str = signObj.SignWithTSATimeStamp(tsaurl, content, NETCAPKI_CMS_ENCODE_DER);
            }
        }
        catch(e)
        {
            throw (NETCAPKI_ERROR_PREFIX_INFO + NETCAPKI_ERROR_3_SIGNFAIL);
        }
        signObj = null;
        return str;
    },
    
    /*----------------------从证书对象里面获取签名算法 -------------------
     * 参数 oCert     证书对象
     */
    getAlgoFromCert: function(oCert)
    {
        var signAlgo = 0;
        var algo = oCert.PublicKeyAlgorithm;
        switch(algo)
        {
            case 1:
                signAlgo = 2;
                break;
            case 4:
                signAlgo = 25;
                break;
            default:
                signAlgo = 2;
                break;
        }   
        return signAlgo;    
    },
    
    //获取证书微缩图
    GetCertInfo: function(cert) 
    {
        return initialObj.BinaryToHex(cert.ThumbPrint(NETCAPKI_ALGORITHM_SHA1), true);
    },
    
    /*-----------------获取证书绑定值--------------------------
     * 参数 cert     证书对象
     */
    GetCertExtensionStringValue: function(cert, oid) 
    {
        var boidval = cert.GetExtension(oid); 
        var oidval = initialObj.DecodeASN1String(1, boidval);
        return oidval;
    },
    
    /*-----------------获取证书信息--------------------------
     * 参数 cert     证书对象
     */
    getX509CertificateInfo: function(oCert, iValueType){
        var rvStr;
        if (oCert == null) {
            return null;
        }
        if (iValueType == null) {
            return null;
        }
        switch (iValueType) {
            case NETCAPKI_CERT_SUBJECT_CN: //Subject中的CN项（人名）
                try {
                    return oCert.GetStringInfo(NETCAPKI_CERT_ATTRIBUTE_SUBJECT_CN);
                }
                catch (e) {
                    return "";
                }
            default:
                return "";
        }
        return rvStr;
    },
    
    /*---------------签名结果验证--------------------------------
     * 参数 bcms     调用SignPKCS7得到签名结果，byte数组形式
     * 参数 content  签名原文，byte数组形式
     */
    SimpleVerifyPKCS7: function(cms, content){
        var signObj;
        if(cms == ""){
            throw (NETCAPKI_ERROR_6_ARG_SIGNEMPTY);
            return null;
        }
        try{
            signObj1 = initialObj.CreateSignedDataObject(false);
            signObj2 = initialObj.CreateSignedDataObject(false);
        }
        catch(e)
        {
            throw (NETCAPKI_ERROR_2_ACTIVEXFAIL);
            return null;
        }
        try
        {//带原文
            isOK = true//标志是否通过
            var tbs;
            if(content != "")
            {
                tbs = signObj1.Verify(cms);
                isOK = content.Equals(tbs);                             
            }
            else if(content == "")
            {
                tbs = signObj1.verify(cms);
                if(tbs == "")
                {
                    isOK = false;
                }
            }
            if(!isOK)
            {
                throw (NETCAPKI_ERROR_PREFIX_INFO + NETCAPKI_ERROR_13_ARG_VERIFY);
                return null;
            }
            else
            {
                certObj = signObj1.GetSignCertificate(-1);  //获取当前签名的证书
                return certObj;
            }
        }
        catch(e)
        {//不带原文
            if(content == ""){
                throw (NETCAPKI_ERROR_PREFIX_INFO + NETCAPKI_ERROR_7_ARG_SIGNCONTENTEMPTY);
                return null;
            }

            var tbs;
            try 
            {
                tbs = signObj2.DetachedVerify(content, cms, false);
                if (!tbs)
                {
                    throw (NETCAPKI_ERROR_PREFIX_INFO + NETCAPKI_ERROR_13_ARG_VERIFY);
                    return null;
                }
                else
                {
                    certObj = signObj2.GetSignCertificate(-1);  //获取当前签名的证书
                    return certObj;
                }
            }
            catch(e)
            {
                throw (NETCAPKI_ERROR_PREFIX_INFO + NETCAPKI_ERROR_13_ARG_VERIFY);
            }
        }
    }
});