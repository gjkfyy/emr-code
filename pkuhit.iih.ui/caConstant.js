
/*设备类型*/
var NETCAPKI_DEVICETYPE_ANY = -1;

//-------设备标识-------//
var NETCAPKI_DEVICEFLAG_SILENT					= 1;	//如果这一位设置，则不会显示UI
var NETCAPKI_DEVICEFLAG_CACHE_PIN_IN_PROCESS	= 0;	//在进程中缓存PIN码
var NETCAPKI_DEVICEFLAG_CACHE_PIN_IN_HANDLE		= 2;	//在句柄中缓存PIN码
var NETCAPKI_DEVICEFLAG_NOT_CACHE_PIN			= 4;	//不缓存PIN码

/*签名算法*/
var NETCAPKI_ALGORITHM_SHA1WITHRSA = 2;
var NETCAPKI_ALGORITHM_SM3WITHSM2 = 25;


/* 编码格式 */
var NETCAPKI_CP_ACP = 0; //	系统的代码页
var NETCAPKI_CP_UTF8 = 65001;
var NETCAPKI_CP_GBK = 936;
var NETCAPKI_CP_BIG5 = 950;
var NETCAPKI_CP_GB18030 = 54936;
var NETCAPKI_CP_UTF16LE = 1200;

/*CMS编码方式*/
var NETCAPKI_CMS_ENCODE_DER = 1;
var NETCAPKI_CMS_ENCODE_BASE64 = 2;
var NETCAPKI_CMS_ENCODE_BASE64_MULTILINE = 3;


/* BASE64的选项	值	说明 */
var NETCAPKI_BASE64_ENCODE_NO_NL = 1;        //	编码选项，如果设置了该位，则编码时不换行
var NETCAPKI_BASE64_DECODE_STRICT = 2;        // 解码选项，如果设置了该位，则解码时不允许包含换行


/* 证书存储区存储类型常量 */
var NETCAPKI_CERT_STORE_TYPE = new Array("1", "0");

/* 证书存储区类型常量 */
var NETCAPKI_CERT_STORE_NAME = new Array("my", "others", "ca", "root"); // 兼容SecuInter
/* 抛出错误说明 */
var NETCAPKI_ERROR_PREFIX_INFO='操作失败，可能发生以下情况：\n';
var NETCAPKI_ERROR_1_NOCERT = '没有符合条件的证书。';
var NETCAPKI_ERROR_2_ACTIVEXFAIL = 'NETCA控件安装失败。';
var NETCAPKI_ERROR_3_SIGNFAIL = '签名过程中发生错误。';
var NETCAPKI_ERROR_4_ARG_CONTENTEMPTY = '签名时签名原文不能为空。';
var NETCAPKI_ERROR_5_ARG_CERTEMPTY = '签名时签名证书不能为空。';
var NETCAPKI_ERROR_6_ARG_SIGNEMPTY = '验签时签名值不为空。';
var NETCAPKI_ERROR_7_ARG_SIGNCONTENTEMPTY = '不带源文的验签时源文不能为空。';
var NETCAPKI_ERROR_8_ARG_NODEVICES = '请检查是否已插入USBKEY。';
var NETCAPKI_ERROR_9_ARG_DECRYPTDATAEMPTY = '解密数据为空。';
var NETCAPKI_ERROR_10_ARG_PINEMPTY = '用户PIN码为空。';
var NETCAPKI_ERROR_11_ARG_FILEPATHEMPTY = '文件路径为空。';
var NETCAPKI_ERROR_12_ARG_CERTDIFF = '签名时候的证书与验证时候的证书不一致。';
var NETCAPKI_ERROR_13_ARG_VERIFY = '签名验证失败，数据可能被篡改。';
var NETCAPKI_ERROR_14_ARG_SELETECERTFAIL = '证书选择失败。';
var NETCAPKI_ERROR_15_ARG_ADDENCCERTFAIL = '添加加密证书失败。';
var NETCAPKI_ERROR_16_ARG_DECRYFAIL = '解密失败,找不到解密证书或者密文被修改。';

var NETCAPKI_ALGORITHM_SHA1 = 8192;

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

//获取的证书信息类型
var CERT_VERSION     = 1;  // 证书版本 返回V1 V2 V3
var CERT_SERIAL      = 2;  // 证书序列号
var CERT_SIGN_METHOD = 3;  // 获取证书类型 返回 rsa或sm2
var CERT_ISSUER_C    = 4;  // 证书发放者国家名 多个之间用&&&隔开
var CERT_ISSUER_O    = 5;  // 证书发放者组织名
var CERT_ISSUER_OU   = 6;  // 证书发放者部门名
var CERT_ISSUER_ST   = 7;  // 证书发放者省州名
var CERT_ISSUER_CN   = 8;  // 证书发放者通用名
var CERT_ISSUER_L    = 9;  // 证书发放者城市名
var CERT_ISSUER_E    = 10; // 证书发放者EMAIL地址
var CERT_NOT_BEFORE  = 11; // 证书有效期起始 格式YYYYMMDDHHMMSS 
var CERT_NOT_AFTER   = 12; // 证书有效期截止 格式YYYYMMDDHHMMSS
var CERT_SUBJECT_C   = 13; // 用户国家名
var CERT_SUBJECT_O   = 14; // 用户组织名
var CERT_SUBJECT_OU  = 15; // 用户部门名
var CERT_SUBJECT_ST  = 16; // 用户省州名
var CERT_SUBJECT_CN  = 17; // 用户通用名
var CERT_SUBJECT_L   = 18; // 用户城市名
var CERT_SUBJECT_E   = 19; // 用户EMAIL地址
var CERT_PUBKEY      = 20; // 证书公钥
var CERT_SUBJECT_DN  = 33; // 用户DN
var CERT_ISSUER_DN   = 34; // 颁发者DN
var CERT_UNIQUEID    = 35; // 唯一实体ID

