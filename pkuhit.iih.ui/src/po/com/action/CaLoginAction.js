Ext.define('iih.po.com.action.CaLoginAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
	
    requires:['iih.po.com.BJCAUtil','iih.po.com.NetCAUtil'],
    
    showInfo: null,//消息提示
    strUserName: null,//用户名
    strPin: null,//密码
    strServerCert: null,//证书
    strServerRan: null,//随机数
    strServerSignedData: null,//数字签名
    doExecute: function(context) {
    	this.callParent();
    	var view = this.getOwner();
    	var block = this.getBlock('lvblock');
    	showInfo = block.down('xapdisplayfield');
        showInfo.setValue(null);
    	var data = block.getForm().getValues();
    	if(Ext.isEmpty(data.causer, false)){
            showInfo.setValue('<font color=red>请选择登录用户!</font>');
            return null;
        }
    	strUserName = data.causer;
    	if(Ext.isEmpty(data.capass, false)){
            showInfo.setValue('<font color=red>密码不能为空!</font>');
            return null;
        }
    	strPin = data.capass;
    	
    	//BJCA登录
        if(CONFIG_PARAM.CA_SUBJECT == 1){
            var url = 'ca/getBJCASigndata';
            var METHODS = this.getInvocationMethods();
            var operation = {
                url: url,
                method: METHODS.METHOD_GET,
                scope: this,
                success: this.onSuccess_BJCA,
                fail: this.onFail_BJCA
            };
            var operations = context.operations;
            operations.push(operation);
        }
        //网政通CA登录
        if(CONFIG_PARAM.CA_SUBJECT == 2){
            var random = Math.floor(Math.random()*100000 + 100000);//产生随机数
            var content = "" + random;
            var bRand = iih.po.com.NetCAUtil.StrDecode("UTF-8", content);
            var cert = iih.po.com.NetCAUtil.SelectMyCert(1, "IssuerCN~'NETCA'", 1, 1);
            if (cert == null) 
            {
                showInfo.setValue('<font color=red>请插入网证通证书!</font>');
                return;
            }
            var sign = iih.po.com.NetCAUtil.SignPKCS7(cert, bRand, 1, "", strPin);
            if (sign == null) 
            {
                showInfo.setValue('<font color=red>签名失败!</font>');
                return;
            }
            var b64Sign = iih.po.com.NetCAUtil.StrEncode("Base64", sign);
            var cms = iih.po.com.NetCAUtil.StrDecode("Base64", b64Sign);
            if (content != "" && content != null)
            {
                bcontent = iih.po.com.NetCAUtil.StrDecode("UTF-8", content);

            }                   
            var ocert = iih.po.com.NetCAUtil.SimpleVerifyPKCS7(cms, bcontent);
            if (!ocert)
            {
                showInfo.setValue('<font color=red>签名验证失败!</font>');
                return;
            }
            var chain = this.getOwner().getActionChain("getCertUser");
            chain.execute({
                'caSubject':2,
                'uniqueId':strUserName
            });
        }
    },
    
    onSuccess_BJCA : function(operation) {
        var data = operation.result;
        strServerCert = data.cert;
        strServerRan = data.random;
        strServerSignedData = data.signData;
        var uniqueId = iih.po.com.BJCAUtil.login(showInfo, strUserName, strPin, strServerCert, strServerRan, strServerSignedData);
        if(uniqueId){
            if(uniqueId == -1){
                var userCert = iih.po.com.BJCAUtil.GetSignCert(strUserName);
                var chain = this.getOwner().getActionChain("getCertInfo");
                chain.execute({
                    'strCert':userCert,
                    'strOid':'1.2.86.11.7.8'//'2.16.840.1.113732.2'
                });
            }else{
                var chain = this.getOwner().getActionChain("getCertUser");
                chain.execute({
                    'caSubject':1,
                    'uniqueId':uniqueId//210105198506020176
                });
            }
            IMER_GLOBAL.certID = strUserName;
        }
            
    },
    
    onFail_BJCA: function(operation) {
        showInfo.setValue(null);
        showInfo.setValue('<font color=red>登录失败，请检查UKEY!</font>');
    }
});
