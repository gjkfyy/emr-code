/***********************************************************  
名称: 网证通PKI中间件 JS 接口  
功能描述：涉及到数字证书的相关业务处理；此接口可自行修订
1 证书查询及证书解析 
2 电子签名及验证
3 加密及解密
4 工具 

修订记录：
版本号		编辑时间		编辑人		修改描述
2.0.0		03/20/2012		符利华		1.根据secuInter当前最新版本(V4.1)修改创建对象的方式，解决WIN7下多次弹出的问题。
2.0.1		08/16/2013	    陆汉民		2.整理
***********************************************************/

//全局变量，根据项目实际应用定制，可修订

var NETCAPKI_SUPPORTCA = "NETCA;GDCA;SZCA;CFCA";  //默认的证书筛选条件
/* 编码格式 */
var NETCAPKI_CP = 65001;                //默认字符串编码方式:UTF8(UTF16LE=1200;UTF8 = 65001;GBK = 936;BIG5 = 950;GB18030 = 54936;ACP = 0;系统的代码页)
var NETCAPKI_ALGORITHM_HASH = 8192;     //默认哈希算法:SHA1 
var INCLUDE_CERT_OPTION=2;// SignedData.INCLUDE_CERT_OPTION_SELF;

var NETCAPKI_ENVELOPEDDATA_ALGORITHM_AES256CBC =6;// NetcaPkiLib.Constants.NETCAPKI_ENVELOPEDDATA_ALGORITHM_AES256CBC;//RSA加密算法
var NETCAPKI_ENVELOPEDDATA_ALGORITHM_SM1CBC =8;// NetcaPkiLib.Constants.NETCAPKI_ENVELOPEDDATA_ALGORITHM_SM1CBC;//SM2加密算法

//搜索密钥的方式-值-说明
var NETCAPKI_SEARCH_KEYPAIR_FLAG_CURRENT_USER = 1073741824;  //	从当前用户证书库中搜索
var NETCAPKI_SEARCH_KEYPAIR_FLAG_LOCAL_MACHINE = 536870912;   //	从本机证书库中搜索
var NETCAPKI_SEARCH_KEYPAIR_FLAG_DEVICE = 268435456;           //	从当前连接的设备中搜索


/* 证书存储区存储类型常量
* 特别注意：本地计算机为 0，当前用户为1； 为了兼容SecuInter，此处常量定义的字面值与实际意义
* 刚好相反。
*/
var NETCAPKI_CURRENT_USER_STORE = 0;
var NETCAPKI_LOCAL_MACHINE_STORE = 1;
/* 证书存储区类型常量 */
var NETCAPKI_CERT_STORE_NAME_MY = 0;
var NETCAPKI_CERT_STORE_NAME_OTHERS = 1;
var NETCAPKI_CERT_STORE_NAME_CA = 2;
var NETCAPKI_CERT_STORE_NAME_ROOT = 3;
var NETCAPKI_CERT_STORE_NAME = new Array("my", "others", "ca", "root"); // 兼容SecuInter

/* 证书类别常量 */
var NETCAPKI_CERTTYPE_ALL = 0;
var NETCAPKI_CERTTYPE_SIGN = 1;
var NETCAPKI_CERTTYPE_ENV = 2;

/* 证书用法 */
var NETCAPKI_KEYUSAGE_NO = -1;
var NETCAPKI_KEYUSAGE_DIGITALSIGNATURE = 1;
var NETCAPKI_KEYUSAGE_NONREPUDIATION = 2;
var NETCAPKI_KEYUSAGE_CONTENTCOMMITMENT = 2;
var NETCAPKI_KEYUSAGE_KEYENCIPHERMENT = 4;
var NETCAPKI_KEYUSAGE_DATAENCIPHERMENT = 8;
var NETCAPKI_KEYUSAGE_KEYAGRESSMENT = 16;
var NETCAPKI_KEYUSAGE_KEYCERTSIGN = 32;
var NETCAPKI_KEYUSAGE_CRLSIGN = 64;

//签名算法-值-说明
var NETCAPKI_ALGORITHM_MD5WITHRSA = 1;    //	MD5WithRSA
var NETCAPKI_ALGORITHM_SHA1WITHRSA = 2;  //	SHA1WithRSA
var NETCAPKI_ALGORITHM_SHA224WITHRSA = 3; //	SHA224WithRSA
var NETCAPKI_ALGORITHM_SHA256WITHRSA = 4; //	SHA256WithRSA
var NETCAPKI_ALGORITHM_SHA384WITHRSA = 5; //	SHA384WithRSA
var NETCAPKI_ALGORITHM_SHA512WITHRSA = 6; //	SHA512WithRSA
var NETCAPKI_ALGORITHM_SM3WITHSM2 = 25;   //	SM3WithSM2
var NETCAPKI_ALGORITHM_SM3WITHRSA = 31;   //	SM3WithRSA

//证书用途-值-说明
var NETCAPKI_CERT_PURPOSE_ENCRYPT = 1; //	加密
var NETCAPKI_CERT_PURPOSE_SIGN = 2; //	签名

// 证书状态
var NETCAPKI_CERT_STATUS_REVOKED = 0;

var NETCAPKI_CERT_STATUS_UNDETERMINED = -1;

var NETCAPKI_CERT_STATUS_UNREVOKED = 1;

var NETCAPKI_CERT_STATUS_ERROR = 3; //	证书格式有误
var NETCAPKI_CERT_STATUS_NO_VALID = 4; //	证书已过有效期
var NETCAPKI_CERT_STATUS_NOT_NETCA = 5; //	不是NETCA颁发的证书
var NETCAPKI_CERT_STATUS_OTHER_ERROR = 8; //其他错误

// 证书作废原因
var NETCAPKI_CRL_REASON_UNSPECIFIED = 0;
var NETCAPKI_CRL_REASON_KEYCOMPROMISE = 1;
var NETCAPKI_CRL_REASON_CACOMPROMISE = 2;
var NETCAPKI_CRL_REASON_AFFILIATION_CHANGED = 3;
var NETCAPKI_CRL_REASON_SUPERSEDED = 4;
var NETCAPKI_CRL_REASON_CESSATION_OF_OPERATION = 5;
var NETCAPKI_CRL_REASON_CERTIFATE_HOLD = 6;
var NETCAPKI_CRL_REASON_REMOVE_FROM_CRL = 8;
var NETCAPKI_CRL_REASON_PRIVILEGE_WITHDRAWN = 9;
var NETCAPKI_CRL_REASON_AACOMPROMISE = 10;

// 证书基本信息：
var NETCAPKI_CERT_PEM = 0;    //	NETCA为证书Base64编码
var NETCAPKI_CERT_THUMBPRINT = 1;    //	NETCA为证书姆印
var NETCAPKI_CERT_SERIALNUMBER = 2;  //	证书序列号
var NETCAPKI_CERT_SUBJECT = 3;       //	证书Subject
var NETCAPKI_CERT_ISSUER = 4;        //	证书颁发者
var NETCAPKI_CERT_VALIDFROMDATE = 5; //	证书有效期起
var NETCAPKI_CERT_VALIDTODATE = 6;   //	证书有效期止
var NETCAPKI_CERT_KEYUSAGE = 7;      //	密钥用法 KeyUsage
var NETCAPKI_CERT_PUBLICKEYALGO = 8;      //	证书公钥算法
var NETCAPKI_CERT_USRCERTNO = 9;     //	UsrCertNO：证书绑定号；//NETCA绑定姆印，编号为1；GDCA绑定为TrustID，编号为51；
var NETCAPKI_CERT_OLDUSRCERTNO = 10; // OldUsrCertNo：旧的用户证书绑定值；NETCA：绑定旧姆印，编号为31；GDCA：绑定为TrustID，编号为51；
// 证书基本信息细化解析：
var NETCAPKI_CERT_SUBJECT_NAME = 11; //	证书主题名称；有CN项取CN项值；无CN项，取O的值
var NETCAPKI_CERT_SUBJECT_CN = 12;   //	Subject中的CN项（人名）
var NETCAPKI_CERT_SUBJECT_O = 13;    //	Subject中的O项（单位）
var NETCAPKI_CERT_SUBJECT_L = 14;    //	Subject中的L项（地址）
var NETCAPKI_CERT_SUBJECT_EMAIL = 15; //	Subject中的Email
var NETCAPKI_CERT_SUBJECT_DEPARTMENT = 16; //	Subject中的部门名
var NETCAPKI_CERT_SUBJECT_COUNTRY = 17;   //	用户国家名
var NETCAPKI_CERT_SUBJECT_CITY = 18;      //	用户省州名
// 特定证书信息：
var NETCAPKI_CERT_CAID = 21;               //	CA ID： CA的ID:1：NETCA；2：GDCA；3：SZCA；0：未知CA
var NETCAPKI_CERT_CERTCLASSIFY = 22;      //	CertClassify：证书类型；1：服务器证书；2：个人证书 3: 机构证书；4：机构员工证书；5：机构业务证书；注：该类型国密标准待定0：其他证书
var NETCAPKI_CERT_CERTID = 23;            //	CertID；证书唯一标识； GDCA为信任号，见编号51 NETCA：目前无，以后可能有，兼容以后
// NETCA扩展域		
var NETCAPKI_CERT_PREVCERT_THUMBPRINT = 31; //	旧姆印信息（如保含该域，则取出，否则为“”）
var NETCAPKI_CERT_TAXPAYERNUM = 32;         //	纳税人编码（如保含该域，则取出，否则为“”）
var NETCAPKI_CERT_ENTERPRISENUM = 33;       //	企业法人代码（如保含该域，则取出，否则为“”）
var NETCAPKI_CERT_TAXREGISTERNUM = 34;       //	税务登记号（如保含该域，则取出，否则为“”）
var NETCAPKI_CERT_CERTFROM = 35;             //	证书来源地（如保含该域，则取出，否则为“”）
// GDCA扩展域		
var NETCAPKI_CERT_TRUSTID = 51;              //	GDCA的信任号TrustID


//证书属性	值	说明
var NETCAPKI_CERT_ATTRIBUTE_ISSUER_DISPLAY_NAME = 9; //	颁发者显示名
var NETCAPKI_CERT_ATTRIBUTE_ISSUER_C = 10; //	颁发者的C
var NETCAPKI_CERT_ATTRIBUTE_ISSUER_O = 11; //	颁发者的O
var NETCAPKI_CERT_ATTRIBUTE_ISSUER_OU = 12; //	颁发者的OU
var NETCAPKI_CERT_ATTRIBUTE_ISSUER_CN = 13; //	颁发者的CN
var NETCAPKI_CERT_ATTRIBUTE_ISSUER_EMAIL = 14; //	颁发者的Email
var NETCAPKI_CERT_ATTRIBUTE_SUBJECT_DISPLAY_NAME = 16; //	主体显示名
var NETCAPKI_CERT_ATTRIBUTE_SUBJECT_C = 17; //	主体的C
var NETCAPKI_CERT_ATTRIBUTE_SUBJECT_O = 18; //	主体的O
var NETCAPKI_CERT_ATTRIBUTE_SUBJECT_OU = 19; //	主体的OU
var NETCAPKI_CERT_ATTRIBUTE_SUBJECT_CN = 20; //	主体的CN
var NETCAPKI_CERT_ATTRIBUTE_SUBJECT_EMAIL = 21; //	主体的Email
var NETCAPKI_CERT_ATTRIBUTE_EX_FRIENDLY_NAME = 22; //	好记的名字
var NETCAPKI_CERT_ATTRIBUTE_EX_NAME = 23; //	证书拥有者名称
var NETCAPKI_CERT_ATTRIBUTE_EX_ORGANIZATION = 24; //   证书拥有者所在的单位
var NETCAPKI_CERT_ATTRIBUTE_EX_DEPARTMENT = 25; //   证书拥有者所在的部门
var NETCAPKI_CERT_ATTRIBUTE_EX_EMAIL = 26; //	证书拥有者的EMail
var NETCAPKI_CERT_ATTRIBUTE_PREVCERT_THUMBPRINT = 29; //	更新前的证书的姆印
var NETCAPKI_CERT_ATTRIBUTE_UPN = 36; //   UPN
var NETCAPKI_CERT_ATTRIBUTE_ISSUER_ST = 37; //	颁发者的ST
var NETCAPKI_CERT_ATTRIBUTE_ISSUER_L = 38; //   颁发者的L
var NETCAPKI_CERT_ATTRIBUTE_SUBJECT_ST = 39; //   主体的ST
var NETCAPKI_CERT_ATTRIBUTE_SUBJECT_L = 40; //   主体的L

// 证书验证标志	值	说明
var NETCAPKI_CERT_VERIFY_FLAG_VERIFY_REVOKE = 1;          //	验证作废信息
var NETCAPKI_CERT_VERIFY_FLAG_ONLINE = 2;                 //	在线验证
var NETCAPKI_CERT_VERIFY_FLAG_VERIFY_CACERT_REVOKE = 4;   //	验证CA的作废信息
var NETCAPKI_CERT_VERIFY_FLAG_VERIFY_OCSP = 16;           //	使用OCSP来验证
var NETCAPKI_CERT_VERIFY_FLAG_VERIFY_CRL = 32;            //	使用CRL来验证


//Hash算法	值	说明
var NETCAPKI_ALGORITHM_MD5 = 4096;            //	MD5算法
var NETCAPKI_ALGORITHM_SHA1 = 8192;           //    SHA1算法
var NETCAPKI_ALGORITHM_SHA224 = 12288;        //	SHA224算法
var NETCAPKI_ALGORITHM_SHA256 = 16384;        //	SHA256算法
var NETCAPKI_ALGORITHM_SHA384 = 20480;        //	SHA384算法
var NETCAPKI_ALGORITHM_SHA512 = 24576;        //	SHA512算法
var NETCAPKI_ALGORITHM_SM3 = 28672;           //	SM3算法


//BASE64的选项	值	说明
var NETCAPKI_BASE64_ENCODE_NO_NL = 1;         //	编码选项，如果设置了该位，则编码时不换行
var NETCAPKI_BASE64_DECODE_STRICT = 2;        //	解码选项，如果设置了该位，则解码时不允许包含换行

//CMS编码方式	值	说明
var NETCAPKI_CMS_ENCODE_DER = 1;              //	DER编码
var NETCAPKI_CMS_ENCODE_BASE64 = 2;           //	DER编码后再经过不分行的BASE64编码
var NETCAPKI_CMS_ENCODE_BASE64_MULTILINE = 3; //	DER编码后再经过分行的BASE64编码



//UI标志	值	说明
var NETCAPKI_UIFLAG_DEFAULT_UI = 1;  //	缺省值，在只有一个或没有证书的情况下，不弹出对话框让用户选择
var NETCAPKI_UIFLAG_NO_UI = 2;       //	从不弹出对话框让用户选择
var NETCAPKI_UIFLAG_ALWAYS_UI = 3;   //	总是弹出对话框让用户选择

//ASN.1的字符串类型	值	说明
var NETCAPKI_UTF8STRING = 1;  //UTF8String
var NETCAPKI_PRINTABLESTRING = 2;  //PrintableString
var NETCAPKI_IA5STRING = 3;  //	IA5String
var NETCAPKI_VISIBLESTRING = 4;  //	VisibleString
var NETCAPKI_BMPSTRING = 5;  //	BMPString
var NETCAPKI_OID = 6;  //	OID



/* 作用是在WIN7下载入JS时就提示加载控件 */
//var initialObj = new ActiveXObject("NetcaPki.Utilities");  //{FD4D8357-45B2-4321-B4B9-E722E98549ED}
var initialObj = document.getElementById("obj_ca");


/***************************************************/
/***********  1.  检测类 2012.3.24       ***********/
/***************************************************/

/***************5.2.1 判断控件是否安装成功 ***************/
function isPKIInstalled() {
    try {
        //var utilObj = new ActiveXObject("NetcaPki.Utilities"); //{FD4D8357-45B2-4321-B4B9-E722E98549ED}
		var utilObj = document.getElementById("obj_ca");
		initialObj = document.getElementById("obj_ca");
        if (typeof (utilObj) == "object") {
            //utilObj = null;
            return true;
        }
        utilObj = null;
        return false;
    }
    catch (e) {
        return false;
    }
}

/*************** 5.2.2 判断是否有证书  ***************/
function isHasCert() {
    var certs = getX509Certificates(NETCAPKI_CURRENT_USER_STORE, NETCAPKI_CERT_STORE_NAME_MY, NETCAPKI_CERTTYPE_ALL);
    if (certs == null || certs.Count <= 0) {
        alert("未检测到整数,请确认是否插入证书!");
        return false;
    }
    return true;
}

/**********  5.2.3 判断是否有网证通证书链 ************/
function isHasChain() {
    var certs = getX509Certificates(NETCAPKI_CURRENT_USER_STORE, NETCAPKI_CERT_STORE_NAME_ROOT, NETCAPKI_CERTTYPE_ALL);
    if (certs == null || certs.Count <= 0) {
        alert("未安装网证通证书链,请到www.cnca.net下载证书链,并安装!");
        return false;
    }
    return true;
}

/***************************************************/
/***********   2. 证书类 2012.3.23       ***********/
/***************************************************/

/*********** 5.3.1 选择证书集 ***********   
* storeLocation:NETCAPKI_LOCAL_MACHINE_STORE = 1;NETCAPKI_CURRENT_USER_STORE= 0;
* storeName:NETCAPKI_MY_STORE=0(个人);NETCAPKI_OTHER_STORE:1(其他人);NETCAPKI_CA_STORE= 2;NETCAPKI_ROOT_STORE= 3;
* certType: NETCAPKI_CERTTYPE_ALL= 0;NETCAPKI_CERTTYPE_SIGN= 1;NETCAPKI_CERTTYPE_ENV= 2;
*/
function getX509Certificates(storeLocation, storeName, certType) {
    var storeObj;
    try {
        storeObj = initialObj.CreateStoreObject(); 
    }
    catch (e) {
        storeObj = null;
        alert("获取ActiveXObject失败!");
        return null;
    }

    storeObj.Open(storeLocation, NETCAPKI_CERT_STORE_NAME[storeName]);
    var count = storeObj.GetCertificateCount();
    if (count <= 0) {
        storeObj.Close();
        storeObj = null;
        alert("证书库没有证书!");
        return null;
    }

    var certArray = new Array();
    for (var i = 1; i < count + 1; i++) {
        var oCert= storeObj.GetCertificate(i);
        if (NETCAPKI_SUPPORTCA!="" ) {
            var sSupportCAs = NETCAPKI_SUPPORTCA.split(";");
            for (var j = 0; j < sSupportCAs.length; j++)
            {
                if (oCert.Issuer.indexOf("CN=" + sSupportCAs[j]) < 0)
                {
                    break;
                }
            }
        }
        if (certType == NETCAPKI_CERTTYPE_SIGN) 
        {
            if (!((oCert.KeyUsage == (NETCAPKI_KEYUSAGE_DIGITALSIGNATURE | NETCAPKI_KEYUSAGE_NONREPUDIATION))
				|| (oCert.KeyUsage == NETCAPKI_KEYUSAGE_NO) || (oCert.KeyUsage == NETCAPKI_KEYUSAGE_DIGITALSIGNATURE))) 
                break;
              
        }
        if (certType == NETCAPKI_CERTTYPE_ENV) {
            if (!((oCert.KeyUsage == (NETCAPKI_KEYUSAGE_KEYENCIPHERMENT | NETCAPKI_KEYUSAGE_DATAENCIPHERMENT))
				|| (oCert.KeyUsage == NETCAPKI_KEYUSAGE_NO)
				|| (oCert.KeyUsage == NETCAPKI_KEYUSAGE_KEYENCIPHERMENT)))
                break;
               
        }
        certArray.push(oCert);
      
    } // End for

    storeObj.Close();
    storeObj = null;
    return certArray;
}

/***********  5.3.2	获取证书 ***********             
* storeLocation:NETCAPKI_LOCAL_MACHINE_STORE = 0(本地计算机);NETCAPKI_CURRENT_USER_STORE= 1(当前用户);
* storeName:NETCAPKI_MY_STORE=0(个人);NETCAPKI_OTHER_STORE:1(其他人);NETCAPKI_CA_STORE= 2;NETCAPKI_ROOT_STORE= 3;
* certType: NETCAPKI_CERTTYPE_ALL= 0(所有);NETCAPKI_CERTTYPE_SIGN= 1(签名);NETCAPKI_CERTTYPE_ENV= 2(加密);
*/
function getX509Certificate(storeLocation, storeName, certType) {
    var storeObj;
    try {
        storeObj = initialObj.CreateStoreObject();
    }
    catch (e) {
        alert("获取ActiveXObject失败!");
        return null;
    }
    storeObj.Open(storeLocation, NETCAPKI_CERT_STORE_NAME[storeName]);
    var count = storeObj.GetCertificateCount();
    if (count <= 0) {
        storeObj.Close();
        storeObj = null;
        alert("证书库没有证书!");
        return null;
    }
    var filter = "InValidity='True'";
    if (certType == NETCAPKI_CERTTYPE_SIGN) 
        filter += "&&CertType='Signature'";
    else if (certType == NETCAPKI_CERTTYPE_ENV) 
         filter += "&&CertType='Encrypt'";
    if (NETCAPKI_SUPPORTCA!="" )
    {
        filter += "&&(";
        var sSupportCAs =  NETCAPKI_SUPPORTCA.split(";");
        for (var j = 0; j < sSupportCAs.length; j++)
        {
            if (j == 0)
            {
                filter += "IssuerO~'" + sSupportCAs[j] + "'";
            }
            else {
                filter += "||IssuerO~'" + sSupportCAs[j] + "'";
            }
        }
        filter += ")";
    }
   

    var oCert = storeObj.FindCertificate(filter);
    storeObj.Close();
    storeObj = null;
    return oCert;
}


/** 5.3.3	获取证书对象。
* 
*/
function getX509CertificateByString(certContent) {
    var certObj;
    if (certContent == null) {
        return null;
    }

    try {
        certObj = initialObj.CreateCertificateObject(); 
    }
    catch (e) {
        alert("获取ActiveXObject失败!");
        return null;
    }

    return certObj.Decode(certContent);
}

/***********  5.3.4	获取证书：根据特定域的值获取证书 **********　　##还没有测试，该函数功能没有写完
* storeLocation:NETCAPKI_CURRENT_USER_STORE= 0(当前用户);NETCAPKI_LOCAL_MACHINE_STORE = 1(本地计算机);
* storeName:NETCAPKI_MY_STORE=0(个人);NETCAPKI_OTHER_STORE:1(其他人);NETCAPKI_CA_STORE= 2;NETCAPKI_ROOT_STORE= 3;
* certType: NETCAPKI_CERTTYPE_ALL= 0(所有);NETCAPKI_CERTTYPE_SIGN= 1(签名);NETCAPKI_CERTTYPE_ENV= 2(加密);
* iValueType:   证书信息特定域类别
* value:        证书信息特定域值
*/
function getX509CertificateByInfo(storeLocation, storeName, certType,  iValueType, value) {
    var myCerts = getX509Certificates(storeLocation, storeName, certType);
    var certCount = myCerts.length;
    if (certCount <= 0) {
        alter("证书库没有证书!");
        return null;
    }

    // 按需求，暂时只考虑 证书姆印
    for (var i = 0; i < certCount; i++) {
        var oCert = myCerts[i];
        if (getX509CertificateInfo(oCert, iValueType).toLowerCase() == value.toLowerCase()) {
            return oCert;
        }
    }

    return null;
}

/***********5.3.5 获取证书信息: 根据证书 和  证书信息特定域类别 获取证书信息
// 证书基本信息：
1	证书姆印              2	证书序列号
3	证书Subject           4	证书颁发者
5	证书有效期起          6	证书有效期止
7	密钥用法 KeyUsage     8 证书密钥算法
9   证书用户唯一标示       
// 证书基本信息细化解析：
11	证书主题名称；有CN项取CN项值；无CN项，取O的值      12	Subject中的CN项（人名）
13	Subject中的O项（单位）14	Subject中的L项（地址）
15	Subject中的Email      16	Subject中的部门名
17	用户国家名            18	用户省州名

// 特定证书信息：
21	CAID证书类型:1：NETCA；2：GDCA；3：SZCA；0：未知CA
22	CertID：证书类型；1：服务器证书；2：个人证书；3: 机构证书；4：机构员工证书；5：机构业务证书；注：该类型国密标准待定 0：其他证书
23	CertID；证书唯一标识；GDCA为信任号，见编号51;NETCA：目前无，以后可能有，兼容以后
    
// NETCA扩展域		
31	旧姆印信息（如保含该域，则取出，否则为“”）
32	纳税人编码（如保含该域，则取出，否则为“”）
33	企业法人代码（如保含该域，则取出，否则为“”）
34	税务登记号（如保含该域，则取出，否则为“”）
35	证书来源地（如保含该域，则取出，否则为“”）
// GDCA扩展域		
51	GDCA的信任号TrustID

* 输出：（字符串）返回证书信息
*/
function getX509CertificateInfo(oCert, iValueType) {
    var rvStr;
    var temp;


    if (oCert == null) {
        return null;
    }
    if (iValueType == null) {
        return null;
    }

    switch (iValueType) {
        case NETCAPKI_CERT_PEM:
            try {
                var certPem = oCert.Encode(2);
                var certHeader = "-----BEGIN CERTIFICATE-----\r\n";
                var certEnd = "-----END CERTIFICATE-----\r\n";
                if (certPem.indexOf(certHeader) >= 0) {
                    certPem = certPem.substring(certHeader.length, certPem.length);
                    certPem = certPem.substring(0, certPem.length - certEnd.length);
                }
                return certPem;
            }
            catch (e) { return ""; }
        case NETCAPKI_CERT_THUMBPRINT: //证书姆印
            try {
                return initialObj.BinaryToHex(oCert.ThumbPrint(NETCAPKI_ALGORITHM_SHA1), true);
            }
            catch (e) {
                return "";
            }
        case NETCAPKI_CERT_SERIALNUMBER: //证书序列号
            return oCert.SerialNumber;
        case NETCAPKI_CERT_SUBJECT: //证书Subject
            return oCert.Subject;
        case NETCAPKI_CERT_ISSUER: // 证书颁发者
            return oCert.Issuer;
        case NETCAPKI_CERT_VALIDFROMDATE: //证书有效期起
            var fromDate = new Date(oCert.ValidFromDate);
            return fromDate.toString(); //2012-05-02 lu modify toDate.toDateString()
        case NETCAPKI_CERT_VALIDTODATE: //证书有效期止
            var toDate = new Date(oCert.ValidToDate);
            return toDate.toString(); //2012-05-02 lu modify toDate.toDateString()
        case NETCAPKI_CERT_KEYUSAGE: //密钥用法 KeyUsage
            return "" + oCert.KeyUsage;
        case NETCAPKI_CERT_PUBLICKEYALGO: //证书的公钥算法
            return "" + oCert.PublicKeyAlgorithm;
        case NETCAPKI_CERT_USRCERTNO: // UsrCertNO：证书绑定号；NETCA绑定姆印，编号为1；GDCA绑定为TrustID，编号为51；
            if (getX509CertificateInfo(oCert, 21) == "1") {
                rvStr = "" + getX509CertificateInfo(oCert, 23); //取证书唯一标识
                if (rvStr == "") {
                    rvStr = "" + getX509CertificateInfo(oCert, 36); //取证书证件号码扩展域信息
                    if (rvStr == "") {
                        rvStr = "" + getX509CertificateInfo(oCert, 1); //取证书姆印
                    }
                }
                return rvStr;
            }
            else if (getX509CertificateInfo(oCert, 21) == "2") {
                return "" + getX509CertificateInfo(oCert, 51);
            }
            else {
                return "未知CA";
            }
           
        case NETCAPKI_CERT_OLDUSRCERTNO:
            if (getX509CertificateInfo(oCert, 21) == "1") {
                return getX509CertificateInfo(oCert, 31);
            }
            else  {
                return "";
            }
        case NETCAPKI_CERT_SUBJECT_NAME: // 证书主题名称；有CN项取CN项值；无CN项，取O的值； 
            var rvStr = getX509CertificateInfo(oCert, 12);
            if (rvStr == "") {
                rvStr = getX509CertificateInfo(oCert, 13);
            }
            return rvStr;
        case NETCAPKI_CERT_SUBJECT_CN: //Subject中的CN项（人名）
            try {
                return oCert.GetStringInfo(NETCAPKI_CERT_ATTRIBUTE_SUBJECT_CN);
            }
            catch (e) {
                return "";
            }
           
        case NETCAPKI_CERT_SUBJECT_O: //Subject中的O项（单位)
            try {
                return oCert.GetStringInfo(NETCAPKI_CERT_ATTRIBUTE_SUBJECT_O);
            }
            catch (e) {
                return "";
            }
           
        case NETCAPKI_CERT_SUBJECT_L: //Subject中的L项（地址）
            try {
                return oCert.GetStringInfo(NETCAPKI_CERT_ATTRIBUTE_SUBJECT_L);
            }
            catch (e) {
                return "";
            }
           
        case NETCAPKI_CERT_SUBJECT_EMAIL: //Subject中的Email
           
                try {
                    return oCert.GetStringInfo(NETCAPKI_CERT_ATTRIBUTE_SUBJECT_EMAIL);
                }
                catch (e) {
                    return "";
                }
           
        case NETCAPKI_CERT_SUBJECT_DEPARTMENT:  //Subject中的部门名
            try {
                return oCert.GetStringInfo(NETCAPKI_CERT_ATTRIBUTE_EX_DEPARTMENT);
            }
            catch (e) {
                return "";
            }
            
        case NETCAPKI_CERT_SUBJECT_COUNTRY:   //用户国家名         
            try {
                return oCert.GetStringInfo(NETCAPKI_CERT_ATTRIBUTE_SUBJECT_C);
            }
            catch (e) {
                return "";
            }
            
        case NETCAPKI_CERT_SUBJECT_CITY: //  用户省州名 
            try {
                return oCert.GetStringInfo(NETCAPKI_CERT_ATTRIBUTE_SUBJECT_ST);

            }
            catch (e) {
                return "";
            }

        case NETCAPKI_CERT_CAID: // CAID  1：NETCA；2：GDCA；3：SZCA；0：未知CA
            if (NETCAPKI_SUPPORTCA != "") {
                var sSupportCAs = new Array(); 
                sSupportCAs = NETCAPKI_SUPPORTCA.split(";");
                for (var j = 0; j < sSupportCAs.length; j++) {
                    if (getX509CertificateInfo(oCert, 4).indexOf(sSupportCAs[j]) > 0) {
                        return "" + (j + 1);
                    }
                }
            }
             return "0";
        case NETCAPKI_CERT_CERTCLASSIFY: //CertID：证书类型
            if (getX509CertificateInfo(oCert, 21)=="1")
            {
                try
                {
                    var netcaCaType = initialObj.DecodeASN1String(1, oCert.GetExtension("1.3.6.1.4.1.18760.1.12.12.2"));//netca证书类型扩展OID
                    if (netcaCaType=="001")
                    {
                        return "3";
                    }
                    else if (netcaCaType=="002")
                    {
                        return "5";
                    }
                    else if (netcaCaType=="003")
                    {
                        return "4";
                    }
                    else if (netcaCaType=="004")
                    {
                        return "2";
                    }
                    return "0";
                }
                catch (e) {
                    return "0";
                }
            }
            else
                return "0";
        case NETCAPKI_CERT_CERTID: // 证书唯一标识
            if (getX509CertificateInfo(oCert, 21) == "1") {
                return "";
            }
            else if (getX509CertificateInfo(oCert, 21) == "2") {
                return getX509CertificateInfo(oCert, 51);
            }
            return "";
        case NETCAPKI_CERT_PREVCERT_THUMBPRINT:  // 旧姆印信息 
            if (getX509CertificateInfo(oCert, 21) == "1")//NETCA 
            {
                try {
                    return initialObj.BinaryToHex(oCert.GetStringInfo(NETCAPKI_CERT_ATTRIBUTE_PREVCERT_THUMBPRINT), true);
                }
                catch (e) {
                    return "";
                }
            }
            else {
                return "";
            }
            break;
        /* 需求没有提供 OID信息，无法获取，暂未实现
        case NETCAPKI_CERT_TAXPAYERNUM: //纳税人编码（如保含该域，则取出，否则为“”）
        break;
        case NETCAPKI_CERT_ENTERPRISENUM:    //企业法人代码（如保含该域，则取出，否则为“”）
        break;

        case NETCAPKI_CERT_TAXREGISTERNUM:    //税务登记号（如保含该域，则取出，否则为“”）	
        break;

        case NETCAPKI_CERT_CERTFROM:    //证书来源地	
        break;
        */
        case 36:
            if (getX509CertificateInfo(oCert, 21) == "1")//NETCA 
            {
                try {
                    return initialObj.DecodeASN1String(1, oCert.GetExtension("1.3.6.1.4.1.18760.1.12.11"));//NETCA证书用户标示OID
                }
                catch (e) {
                    return "";
                }
            }
            else {
                return "";
            }
            break;
        case 37:
            var rt = getX509CertificateInfo(oCert, 36);
            if (rt.length > 13) {//00011@0006PO1MTIzNDU2Nzg5MDEyMzQ1Njc4
                var beginIndex = rt.indexOf('@');
                if (beginIndex == -1) {
                    //alert("获取证件号码失败：无法定位@");
                    return "";
                }
                var iClassify = rt.substring(beginIndex + 7, beginIndex + 8); //获取编码标志位
                if (iClassify == "1") {
                    var b64Identity = rt.substring(beginIndex + 8);
                    var bIdentity = initialObj.Base64Decode(b64Identity);
                    return initialObj.Decode(bIdentity, 65001);
                }
                else if (iClassify == "0") {
                    return rt.substring(beginIndex + 8);
                }
                return "";
            }
            else {
                return "";
            }
            break;
        case NETCAPKI_CERT_TRUSTID:    //GDCA的信任号TrustID	
            var issuer_o;
            var oid = "1.2.86.21.1.3";
            try {
                issuer_o = oCert.GetStringInfo(NETCAPKI_CERT_ATTRIBUTE_ISSUER_O);
                if (issuer_o.indexOf("GDCA") >= 0) {

                    temp = initialObj.Decode(oCert.GetExtension(oid), NETCAPKI_CP);
                    rvStr = temp.substr(2, temp.length - 2);
                    // rvStr = initialObj.Decode(temp.slice(2) , NETCAPKI_CP);
                }
                else {
                    rvStr = "";
                }
            }
            catch (e) {
                rvStr = "";
            }

            break;
        default:
            return "";
           
    }
    return rvStr;
}

/****** 获取证书信息: 根据证书 和  OID 获取证书信息 。 目前DecodeASN1String 解码失败*******
* oCert: 证书;
* OID:	String类型，OID的值
* 输出：OID信息的base64编码 
*/
function getX509CertificateInfoByOID(oCert, OID) {
    var OIDStr;

    if (oCert == null) {
        return null;
    }
    OIDStr = oCert.GetExtension(OID);
    return initialObj.Base64Encode(OIDStr, 1);
}

/***************************************************/
/***********  4.签名类 2012.3.23         ***********/
/***************************************************/
/**5.4.1	PKCS#7签名（兼容以前）**/
function signNetCA(bContent, IsNotHasSource) {
    return signedDataByPwd(bContent, IsNotHasSource, "");
}

/**5.4.2	PKCS#7签名 **/
function signedData(sSource, IsNotHasSource) {
	alert("a0");
    return signedDataByPwd(sSource, IsNotHasSource);
}

/**5.4.3	PKCS#7签名 **/
function signedDataByPwd(sSource, IsNotHasSource, pwd) {
    var oCert;
    try {
        oCert =initialObj.CreateCertificateObject();
    }
    catch (e) {
        alert("获取ActiveXObject失败!");
        return null;
    }

    oCert = null;//getX509Certificate(NETCAPKI_CURRENT_USER_STORE, NETCAPKI_CERT_STORE_NAME_MY, NETCAPKI_CERTTYPE_SIGN);
    /*if (oCert == null) {
        alert("未选择证书,请检查是否插入密钥!");
        return null;
    }*/
//alert(getX509CertificateInfo(oCert, 1));
    return signedDataByCertificate(oCert, sSource, IsNotHasSource, pwd);
}

/**5.4.4	使用指定证书,PKCS#7签名 **/
function signedDataByCertificate(oCert, bContent, IsNotHasSource, pwd) 
{
    if (bContent == "") {
        alert("原文内容为空!");
        return null;
    }
	alert("dd0");
    var signObj;
   
    try {

        signObj = initialObj.CreateSignedDataObject();
    }
    catch (e) {
        alert("安装不成功!");
        return null;
    }
    var tbs;
    if (typeof (bContent) == "string" || typeof (bContent) == "String") {
        tbs = initialObj.Encode(bContent, NETCAPKI_CP);
    }
    else {// 原文是数组
         tbs = bContent;
    }
	oCert = initialObj.CreateCertificateObject();
                oCert.Select("Signature", "IssuerCN~'NETCA' || IssuerCN~'GDCA' || IssuerCN~'SZCA' || IssuerCN~'CFCA'");
alert("dd1");
try{
alert(getX509CertificateInfo(oCert, 1));
/*var flag = oCert.HasPrivateKey();
alert(flag);
var keypair = oCert.GetKeyPair("admin888",1073741824,3);
alert(keypair.Label);
alert("dd2");
oCert.SetKeyPair(keypair);
alert("dd3");*/
    signObj.SetSignCertificate(oCert, "");
	alert("dd2");
}
catch(e)
	{
	alert("错误");
	alert(e.message);
}
    signObj.SetIncludeCertificateOption(INCLUDE_CERT_OPTION);
	
    signObj.SetSignAlgorithm(-1,getX509CertificateInfo(oCert, 8)=="1" ? NETCAPKI_ALGORITHM_SHA1WITHRSA : NETCAPKI_ALGORITHM_SM3WITHSM2 );
	alert("dd3");
    var str;
    // 1：不带原文；0：带原文
    if (IsNotHasSource == 0 || IsNotHasSource == "0" || IsNotHasSource == false) {
        // 带原文
        signObj.Detached = false;
        str = signObj.Sign(tbs, NETCAPKI_CMS_ENCODE_BASE64);
    }
    else {
        signObj.Detached = true;
        str = signObj.Sign(tbs, NETCAPKI_CMS_ENCODE_BASE64);
    }
    signObj = null;
   
    return str;
}

/// <summary>6.3.6 PKCS#7时间戳签名
///2013-05-01 update
/// </summary>
/// <param name="sSource">签名内容</param>
/// <param name="sTsaUrl">时间戳服务器URL</param>
/// <param name="bNoHasSource">是否带原文</param>
/// <returns>签名值</returns>
function signedDataWithTSA( bContent,  sTsaUrl,  bNoHasSource)
{
    if (bContent == "") {
        alert("原文内容为空!");
        return null;
    }
    var oCert;
    try {
        oCert =initialObj.CreateCertificateObject();
    }
    catch (e) {
        alert("获取ActiveXObject失败!");
        return null;
    }
    var signObj;
    try {

        signObj = initialObj.CreateSignedDataObject();
    }
    catch (e) {
        alert("安装不成功!");
        return null;
    }

    oCert = getX509Certificate(NETCAPKI_CURRENT_USER_STORE, NETCAPKI_CERT_STORE_NAME_MY, NETCAPKI_CERTTYPE_SIGN);
    if (oCert == null) {
        alert("未选择证书,请检查是否插入密钥!");
        return null;
    }
    var tbs;
    if (typeof (bContent) == "string" || typeof (bContent) == "String") {
        tbs = initialObj.Encode(bContent, NETCAPKI_CP);
    }
    else {// 原文是数组
        tbs = bContent;
    }
    if (signObj.SetSignCertificate(oCert, "", false) == false) {
        alert("设置签名证书失败");
        return null;
    }
    signObj.SetIncludeCertificateOption(2);
    signObj.SetSignAlgorithm(-1,getX509CertificateInfo(oCert, 8)=="1" ? NETCAPKI_ALGORITHM_SHA1WITHRSA : NETCAPKI_ALGORITHM_SM3WITHSM2 );
    var str;
    // 1：不带原文；0：带原文
    if (bNoHasSource == 0 || bNoHasSource == "0" || bNoHasSource == false) {
        // 带原文
        signObj.Detached = false;
        str = signObj.SignWithTSATimeStamp(sTsaUrl, tbs, NETCAPKI_CMS_ENCODE_BASE64);
    }
    else {
        signObj.Detached = true;
        str = signObj.SignWithTSATimeStamp(sTsaUrl, tbs, NETCAPKI_CMS_ENCODE_BASE64);
    }
    signObj = null;
    oCert = null;
    return str;
}

/**5.4.5	PKCS#7签名验证**/
function verifySignedData(sSource, sSignature, IsNotHasSource) 
{
    if (sSource == "") {
        alert("原文内容为空!");
        return null;
    }
    if (sSignature == "") {
        alert("签名信息为空!");
        return null;
    }

    var signObj;
    try {

        signObj = initialObj.CreateSignedDataObject(); 

    }
    catch (e) {
        alert("安装不成功!");
        return null;
    }
    
    var sSourceS;
    var tbs;
    if (typeof (sSource) == "string" || typeof (sSource) == "String") {// 原文是字符串
        sSourceS = initialObj.Encode(sSource, NETCAPKI_CP);
    }
    else {// 原文是数组
        sSourceS = sSource;
    }

    // 1：不带原文；0：带原文
    if (IsNotHasSource == 0 || IsNotHasSource == "0" || IsNotHasSource == false) {// 带原文
        
        signObj.Detached = false;
        tbs = signObj.Verify(sSignature);
        if (tbs == "") {
            alert("原始签名信息验证没通过!");
            return null;
        }
        else {
            alert("签名验证通过!");
        }
    }
    else {// 不带原文
        signObj.Detached = true;
        tbs = signObj.DetachedVerify(sSourceS, sSignature, false);
        if (!tbs) {
            alert("原始签名信息验证没通过!");
            return null;
        }
        else {
            alert("签名验证通过!");
        }
    }

    var certObj = signObj.GetSignCertificate(-1);
    return certObj;
}

function getSourceFromSignature(sSignature) 
{
    if (sSignature == "") {
        alert("签名信息为空!");
        return null;
    }

    var signObj;
    try {

        signObj = initialObj.CreateSignedDataObject(); 
    }
    catch (e) {
        alert("安装不成功!");
        return null;
    }

    return initialObj.Decode(signObj.Verify(sSignature, true), NETCAPKI_CP);
}

/// <summary>6.3.11 PKCS1签名
/// 2016-12-29
/// 
/// </summary>
/// <param name="sSource"></param>
/// <param name="oCert"></param>
/// <returns></returns>
function sign(bContent) {
    if (bContent == "") {
        alert("待签名内容为空!");
        return null;
    }
    var oCert = getX509Certificate(NETCAPKI_CURRENT_USER_STORE, NETCAPKI_CERT_STORE_NAME_MY, NETCAPKI_CERTTYPE_SIGN);
    if (oCert == null) {
        alert("未选择证书,请检查是否插入密钥!");
        return null;
    }
    var tbs = null;
    if (typeof (bContent) == "string" || typeof (bContent) == "String") {
        tbs = initialObj.Encode(bContent, NETCAPKI_CP);
    }
    else {// 原文是数组
        tbs = bContent;
    }
    var arrRT = oCert.Sign(getX509CertificateInfo(oCert, 8) == "1" ? NETCAPKI_ALGORITHM_SHA1WITHRSA : NETCAPKI_ALGORITHM_SM3WITHSM2, tbs);
    return initialObj.Base64Encode(arrRT, NETCAPKI_BASE64_ENCODE_NO_NL);
}

/*** 5.4.10	PKCS#1签名验证 ***/
function verify(bContent, sP1SignData) {
    if (bContent == "") {
        alert("待签名内容为空!");
        return null;
    }
    var oCert = getX509Certificate(NETCAPKI_CURRENT_USER_STORE, NETCAPKI_CERT_STORE_NAME_MY, NETCAPKI_CERTTYPE_SIGN);
    if (oCert == null) {
        alert("找不到数字证书,请检查是否插好电子密钥!");
        return null;
    }
    var tbs = null;
    if (typeof (bContent) == "string" || typeof (bContent) == "String") {
        tbs = initialObj.Encode(bContent, NETCAPKI_CP);
    }
    else {
        // 原文是数组
        tbs = bContent;
    }
    return oCert.Verify(getX509CertificateInfo(oCert, 8) == "1" ? NETCAPKI_ALGORITHM_SHA1WITHRSA : NETCAPKI_ALGORITHM_SM3WITHSM2, tbs, initialObj.Base64Decode(sP1SignData, NETCAPKI_BASE64_ENCODE_NO_NL));
    
}

/***************************************************/
/***********    加密类 2012.3.23         ***********/
/***************************************************/

/**	PKCS#7加密  *******
* 输入：sSource:	String：原文;
*        oCert	证书
* 输出：byte 数组
*/
function envelopedData(oCert,bContent ) {
    var envObj;
    try {
        envObj = initialObj.CreateEnvelopedDataObject(); 
    }
    catch (e) {
        alert("获取ActiveXObject失败!");
        return null;
    }

    var data = initialObj.Encode(bContent, NETCAPKI_CP);
    envObj.EncryptAlgorithm = NETCAPKI_ENVELOPEDDATA_ALGORITHM_AES256CBC;
    if (envObj.AddCert(oCert) == false) {
        alert("添加加密证书失败");
        return null;
    }

    return envObj.Encrypt(data, NETCAPKI_CMS_ENCODE_BASE64);
}

/**	PKCS#7解密  *******
* 输入：bEnvData:	 	byte[]：加密数据;
* 输出：String 	PKCS#7解密后的信息
*/
function developedData(bEnvData) {
    var envObj;
    try {

        envObj = initialObj.CreateEnvelopedDataObject(); 
    }
    catch (e) {
        alert("获取ActiveXObject失败!");
        return null;
    }
    return initialObj.Decode(envObj.Decrypt(bEnvData), NETCAPKI_CP);
}


/***************************************************/
/***********    工具类 2012.3.23         ***********/
/***************************************************/

/** Base64编码 
* 输入：sSource	byte[]:原文
* 输出：String	BASE64信息; 
*/
function base64Encode(sSource) {
    return initialObj.Base64Encode(sSource, NETCAPKI_BASE64_ENCODE_NO_NL);
}

/** Base64解码 
* 输入：string strBase64
* 输出：Byte[]	原文
*/
function base64Decode(strBase64) {
    return initialObj.Base64Decode(strBase64, NETCAPKI_BASE64_DECODE_STRICT);
}

/** 
* Hash 
* 输入：algo Hash算法
*       sSource 原文
* 输出：Hash值，Byte数组
*/
function hash(sSource) {
    var deviceObj;
    try {
        deviceObj = initialObj.CreateDeviceObject();
    }
    catch (e) {
        alert("安装不成功!");
        return null;
    }
    
   var rt= deviceObj.Hash(NETCAPKI_ALGORITHM_HASH, initialObj.Encode(sSource, NETCAPKI_CP));
   return initialObj.BinaryToHex(rt);
}


/** 获取随机数
* 输入：length; 
* 输出：Byte[]	随机数
*/
function getRandom(length) {
    var deviceObj;
    try {
        deviceObj = initialObj.CreateDeviceObject();
    }
    catch (e) {
        alert("安装不成功!");
        return null;
    }

    return deviceObj.GenerateRandom(length);
}

/**
* 二进制读文件
* 输入：sFilePath:String，文件名（含路径）; 
* 输出：Byte[]	文件内容
*/
function readFile(sFilePath) {
    if (sFilePath == "") {
        alert("文件路径为空");
        return null;
    }

    
    var fileProcessObj;
    try {
       
        fileProcessObj = new ActiveXObject("LittleUtils.BinaryFile");  //{B18F58AA-291A-48DD-8DC5-147069A6D59E}
    }
    catch (e) {
        alert("安装不成功!");
        return null;
    }
    return fileProcessObj.Read(sFilePath);
   
}


/**
* 二进制写文件
* 输入：sFilePath:String，文件名（含路径）; 
*       bContent，Byte[]:二进制内容  
* 输出：无
*/
function writeFile(sFilePath, bContent) {
    if (sFilePath == "") {
        alert("文件路径为空");
        return;
    }
    var fileProcessObj;
    try {
        fileProcessObj = new ActiveXObject("LittleUtils.BinaryFile"); ;//{B18F58AA-291A-48DD-8DC5-147069A6D59E}
    }
    catch (e) {
        alert("安装不成功!");
        return;
    }
   
    fileProcessObj.Write(sFilePath, bContent);
    return;
}
