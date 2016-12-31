package pkuhit.iih.iemr.sys;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Set;
/*
import net.netca.asn1.ASN1InputStream;
import net.netca.asn1.DERObjectIdentifier;
import net.netca.asn1.DEROctetString;
import net.netca.asn1.DERSequence;
import net.netca.pki.Base64;
import net.netca.pki.Certificate;
import net.netca.pki.CertStore;
import net.netca.pki.Device;
import net.netca.pki.DeviceSet;
import net.netca.pki.Hash;
import net.netca.pki.PkiException;
import net.netca.pki.Signature;
import net.netca.pki.SignedData;
import net.netca.pki.Util;
import net.netca.util.encoders.Hex;*/

import java.security.*;

public class NetcaPKI {
    /**
     * 证书信息域常量解析
     */
   /* public static String[] CERTVALUEPARSE = { "0:证书PEM编码", "1:姆印", "2:序列号",
            "3:主题", "4:颁发者", "5:有效期开始时间", "6:有效期截止时间",
            "7:密钥用法",
            "8:证书公钥算法",
            "9:用户证书绑定值",
            "10:旧证书用户证书绑定值", // 1-10

            "11:主体名", "12:人名CN", "13:单位O", "14:地址L", "15:EmailAddress",
            "16:部门OU", "17:国家C", "18:省ST",
            "",
            "", // 11-20
            "21:CAID", "22:证书类型", "23:证书客服号", "", "", "", "", "",
            "",
            "", // 21-30
            "31:旧姆印", "32:纳税人编码", "33:企业法人代码", "34:税务登记号", "35:证书来源地",
            "36:证件号码信息扩展域值", "37:明文证件号码", "", "",
            "", // 31-40
            "", "", "", "", "", "", "", "", "",
            "", // 41-50
            "51:GDCA TrustID[1.2.86.21.1.3]",
            "52:GDCA TrustID2[1.2.86.21.1.1]", "", "", "", "", "", "", "", "" // 51

    };
    private static final String BYTE_CODE = "UTF8";
    public static String NETCAPKI_SUPPORTCA = "NETCA;GDCA";
    public static int INCLUDE_CERT_OPTION = SignedData.INCLUDE_CERT_OPTION_SELF;
    public static int NETCAPKI_ALGORITHM_HASH = 8192; // 默认哈希算法:SHA1
    public static int NETCAPKI_ALGORITHM_RSASIGN = Signature.SHA1WITHRSA;// SignedData.NETCAPKI_ALGORITHM_SHA1WITHRSA;//RSA签名算法
    public static int NETCAPKI_ALGORITHM_SM2SIGN = Signature.SM3WITHSM2;// SM2签名算法

    // 获取任意类型设备的设备集
    private static DeviceSet getDeviceSet() throws PkiException {
        DeviceSet set = new DeviceSet(Device.ANY_DEVICE,
                Device.DEVICE_FLAG_CACHE_PIN_IN_PROCESS);
        return set;
    }

    private static Device getDevice(DeviceSet set, int index)
            throws PkiException {
        if (set == null) {
            throw new PkiException("请输入设备集!");
        }
        if (index < 0 || index > set.count()) {
            throw new PkiException("请输入正确的设备索引值:大于0且小于" + set.count() + "的整数");
        }
        Device device = set.get(index);
        return device;
    }

    *//**
     * 5.2.1获取签名证书，多张证书取第1张
     * 
     * @return
     * @throws PkiException
     *//*
    public static Certificate getSignX509Certificate() throws PkiException
    // ,storeType,certType,netcaType)
    {
        CertStore oCertStore = null;
        try {
            oCertStore = new CertStore(CertStore.CURRENT_USER, CertStore.MY);
            int Count = oCertStore.getCertificateCount();
            for (int i = 0; i < Count; i++) {
                Certificate oCert = oCertStore.getCertificate(i);
                java.util.Date oDateEnd = oCert.getValidityEnd();
                java.util.Date oDateBegin = oCert.getValidityStart();
                java.util.Date oDateNow = new java.util.Date();
                if (oDateNow.compareTo(oDateBegin) > 0
                        && oDateNow.compareTo(oDateEnd) < 0) {// 找出有效期内证书
                    String keyUse = getX509CertificateInfo(oCert, 7);
                    if (keyUse.equals("3")) {// 找出签名证书
                        return oCert;
                    }
                }

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            if (oCertStore != null) {

                oCertStore.close();
            }
        }

        return null;
    }

    *//**
     * 5.2.2获取证书信息 该函数时间调用了SecuinterForJava中对应函数
     * 
     * @param oCert
     * @param iValueType
     *            参见5.1.1
     * @return
     * @throws PkiException
     *//*
    public static String getX509CertificateInfo(Certificate oCert,
            int iValueType) throws PkiException {
        if (oCert == null) {
            throw new PkiException("请输入证书!");
        }
        // java.security.cert.X509Certificate oSunCert =
        // oCert.toX509Certificate();
        // if (oCert == null) {
        // return "";
        // }

        switch (iValueType)// 证书基本信息
        {
        case 0:// 证书PEM编码
            byte[] bCert = oCert.derEncode();
            String base64Cert = base64Encode(bCert);

            return base64Cert;
        case 1:// 证书姆印
            byte[] sha1Bytes = oCert.computeThumbprint(Hash.SHA1);
            return Util.HexEncode(false, sha1Bytes);

        case 2:// 证书序列号
            String serial = oCert.getSerialNumber();// .toString(16);
            // if (serial.length() % 2 == 1) {
            // serial = "0" + serial;
            // }
            return serial.toUpperCase();

        case 3:
            return oCert.getSubject();
        case 4:
            return oCert.getIssuer();
        case 5:
            return oCert.getValidityStart().toLocaleString();
        case 6:
            return oCert.getValidityEnd().toLocaleString();
        case 7:
            int iKeyUse = oCert.getKeyUsage();

            return iKeyUse + "";
        case 8:
            int iSignAlgorithm = oCert.getPublicKeyAlgorithm();

            return iSignAlgorithm + "";
        case 9:
            // 1.先判断是否有唯一标识23，如有返回(GDCA必有)；
            // 2.NETCA再判断是否有证书证件号码36，如有返回(NETCA可能有，可能无，有则证书更新后该号不变)；
            // 3.都没，返回证书姆印；
            // 20121122 luhanmin modify
            String CertID = getX509CertificateInfo(oCert, 23);
            if (CertID.length() > 0) {
                return CertID;
            }
            if (getX509CertificateInfo(oCert, 21).equalsIgnoreCase("1")) {// netca
                String CertNo = getX509CertificateInfo(oCert, 36);
                if (CertNo.length() > 0) {
                    return CertNo;
                }
            }
            return getX509CertificateInfo(oCert, 1);
        case 10:
            // 先判断CA类型
            // NETCA取证书旧姆印；
            // GDCA取证书唯一标识
            // 20120809 luhanmin modify

            if (getX509CertificateInfo(oCert, 21).equalsIgnoreCase("1")) {// netca
                return getX509CertificateInfo(oCert, 31);
            } else if (getX509CertificateInfo(oCert, 21).equalsIgnoreCase("2")) {// gdca
                return getX509CertificateInfo(oCert, 23);
            }
        case 11:// 证书主题名称，有CN项取CN项值；无CN项，取O的值
            if (oCert.getSubjectCN() != null) {
                return oCert.getSubjectCN();
            } else {
                return oCert.getSubjectO();
            }

        case 12:// Subject中的CN项（人名）
            return oCert.getSubjectCN();
        case 13:// Subject中的O项（单位）
            return oCert.getSubjectO();
        case 14:// Subject中的L项（地址）
            return oCert.getSubjectL();
        case 15:// Subject中的Email
            return oCert.getSubjectEmail();
        case 16:
            return oCert.getSubjectOU();
        case 17:
            return oCert.getSubjectC();
        case 18:
            return oCert.getSubjectST();
        case 21:
            String issuer = oCert.getIssuerO();
            String[] sSupportCAs = NETCAPKI_SUPPORTCA.split(";");
            for (int i = 0; i < sSupportCAs.length; i++) {
                if (issuer.indexOf(sSupportCAs[i]) >= 0) {
                    return "" + (i + 1);
                }
            }
            return "0";
        case 22:// 证书类型
            if (getX509CertificateInfo(oCert, 21).equalsIgnoreCase("1"))// netca
            {
                if (oCert.hasExtension("1.3.6.1.4.1.18760.1.12.12.2")) {
                    byte[] bValue = oCert
                            .getExtensionValue("1.3.6.1.4.1.18760.1.12.12.2");
                    String netcaCaType = Util.decodeDERString(1, bValue);
                    if (netcaCaType.equalsIgnoreCase("001")) {
                        return "3";
                    } else if (netcaCaType.equalsIgnoreCase("002")) {
                        return "5";
                    } else if (netcaCaType.equalsIgnoreCase("003")) {
                        return "4";
                    } else if (netcaCaType.equalsIgnoreCase("004")) {
                        return "2";
                    }
                    return "0";
                }
                return "0";

            } else {
                return "0";
            }
        case 23:// 证书唯一标识(一般为客户号等)
            if (getX509CertificateInfo(oCert, 21).equalsIgnoreCase("1")) {
                return "";
            } else if (getX509CertificateInfo(oCert, 21).equalsIgnoreCase("2")) {
                return getX509CertificateInfo(oCert, 51);
            }
        case 31:// "31:旧姆印"
            if (getX509CertificateInfo(oCert, 21).equalsIgnoreCase("1")) {
                String value = "";
                // Set<String> critSet = oCert.getCriticalExtensionOIDs();
                if (oCert.hasExtension("1.3.6.1.4.1.18760.1.12.1")) {

                    byte[] bValue = oCert
                            .getExtensionValue("1.3.6.1.4.1.18760.1.12.1");
                    if (bValue.length > 4)
                        value = getThumbprintStr(bValue, "1.3.14.3.2.26"); // 微缩图:sha1编码"1.3.14.3.2.26";MD5编码"1.2.840.113549.2.5"
                    if (value.length() < 4)
                        value = getThumbprintStr(bValue, "1.2.840.113549.2.5"); // 微缩图:sha1编码"1.3.14.3.2.26";MD5编码"1.2.840.113549.2.5"
                    break;
                }
                if (oCert.hasExtension("1.3.6.1.4.1.18760.1.12.5")) {
                    byte[] bValue = oCert
                            .getExtensionValue("1.3.6.1.4.1.18760.1.12.5");
                    if (bValue.length > 4)
                        value = getString(bValue);
                    break;

                }

                return value;
            }
            return "";
            // "32:纳税人编码", "33:企业法人代码", "34:税务登记号", "35:证书来源地",

        case 36:// "36:证件号码信息扩展域值[1.3.6.1.4.1.18760.1.12.11]"
            if (getX509CertificateInfo(oCert, 21).equalsIgnoreCase("1")) {
                if (oCert.hasExtension("1.3.6.1.4.1.18760.1.12.11")) {

                    byte[] bValue = oCert
                            .getExtensionValue("1.3.6.1.4.1.18760.1.12.11");
                    String sTrustID = new String(bValue);
                    return sTrustID.substring(2, sTrustID.length());

                }
            }

            return "";
        case 37:// 证书证件号码扩展域

            String rt = getX509CertificateInfo(oCert, 36);

            if (rt.length() > 13) {// 00011@0006PO1MTIzNDU2Nzg5MDEyMzQ1Njc4
                int beginIndex = rt.indexOf('@');
                if (beginIndex == -1) {
                    // alert("获取证件号码失败：无法定位@");
                    return "";
                }
                String iClassify = rt.substring(beginIndex + 7,
                        beginIndex + 7 + 1); // 获取编码标志位
                if (iClassify.equalsIgnoreCase("1")) {

                    String b64Identity = rt.substring(beginIndex + 8);
                    byte[] bIdentity = base64Decode(b64Identity);
                    return convertString(bIdentity);
                } else if (iClassify == "0") {
                    return rt.substring(beginIndex + 8);
                }
                return "";
            } else {
                return "";
            }

        case 52:
            if (getX509CertificateInfo(oCert, 21).equalsIgnoreCase("2")) {
                if (oCert.hasExtension("1.2.86.21.1.1")) {

                    byte[] bValue = oCert.getExtensionValue("1.2.86.21.1.1");
                    String sTrustID = new String(bValue);
                    return sTrustID.substring(4, sTrustID.length());

                }

            }
            return "";

        default:
            return "";
        }
        return "";
    }

    *//**
     * 5.3.1 用指定证书进行PKCS7签名
     * 
     * @param sSource
     * @param IsNotHasSource
     * @param pwd
     * @param oCert
     * @return
     * @throws PkiException
     *//*
    public static String signedDataByCertificate(Certificate oCert,
            String sSource, Boolean IsNotHasSource, String pwd)
            throws PkiException {
        if (sSource == null || "".equals(sSource)) {
            throw new PkiException("输入原文为空!");
        }

        if (oCert == null) {
            throw new PkiException("证书为空!");
        }
        byte[] bSource = convertByte(sSource);

        SignedData oSD = new SignedData(true);

        byte[] signedBytes = null;
        try {
            oSD.setSignCertificate(oCert, pwd);// 设置签名证书和密码
            oSD.setDetached(IsNotHasSource);
            oSD.setSignAlgorithm(0, getX509CertificateInfo(oCert, 8)
                    .equals("1") ? NETCAPKI_ALGORITHM_RSASIGN
                    : NETCAPKI_ALGORITHM_SM2SIGN);// 表示第0个证书,并设置签名算法Signature.SHA1WITHRSA
            oSD.setIncludeCertOption(INCLUDE_CERT_OPTION);

            signedBytes = oSD.sign(bSource);
        } catch (PkiException ex) {
            throw new PkiException("PKCS7签名失败:" + ex.getMessage());
        } finally {
            if (oSD != null)
                oSD.free();
        }
        String signedStr = base64Encode(signedBytes);
        return signedStr;
    }

    *//**
     * 5.3.2 PKCS#7签名验证(字符串数据)
     * 
     * @param sSource
     * @param sSignature
     * @param IsNotHasSource
     * @return
     * @throws PkiException
     *//*
    public static Certificate verifySignedData(String sSource,
            String sSignature, boolean IsNotHasSource) throws PkiException {
        if (sSource == null || "".equals(sSource)) {
            throw new PkiException("签名验证失败：原文信息为空!");
        }
        if (sSignature == null || sSignature.equals("")) {
            throw new PkiException("签名验证失败：签名信息为空!");
        }
        SignedData signedData = new SignedData(false);
        byte[] bSignature = base64Decode(sSignature);
        if (!IsNotHasSource) {// 含原文
            byte[] originalBytes = null;
            signedData.verifyInit();
            try {
                originalBytes = signedData.verifyUpdate(bSignature);
                signedData.verifyFinal();
            } catch (PkiException ex) {
                if (signedData != null)
                    signedData.free();
                throw new PkiException("签名验证失败:" + ex.getMessage());
            }
            byte[] bSource = convertByte(sSource);
            if (!Arrays.equals(bSource, originalBytes)) {
                if (signedData != null)
                    signedData.free();
                throw new PkiException("签名验证失败：原文与签名信息不匹配!");
            }

        } else {
            byte[] bSource = convertByte(sSource);

            if (!(signedData.detachedVerify(bSource, bSignature))) {
                if (signedData != null)
                    signedData.free();
                throw new PkiException("原文与签名信息不匹配！！!");
            }
        }
        Certificate cert = signedData.getSignCertificate(0);
        if (cert == null) {
            if (signedData != null)
                signedData.free();
            throw new PkiException("获取签名证书失败!");
        }
        signedData.free();
        return cert;
    }

    *//**
     * 5.3.3 PKCS#7签名验证(二进制数据)
     * 
     * @param bFile
     * @param sSignature
     * @param IsNotHasSource
     * @return
     * @throws PkiException
     *//*
    public static Certificate verifyFilePKCS7(byte[] bFile, String sSignature,
            boolean IsNotHasSource) throws PkiException {
        if (sSignature == null || sSignature.equals("")) {
            throw new PkiException("输入签名值为空!");
        }
        if (bFile == null) {
            throw new PkiException("验证文件为空!");
        }
        SignedData signedData = null;

        signedData = new SignedData(false);
        byte[] bSignature = base64Decode(sSignature);
        if (!IsNotHasSource) {// 含原文
            byte[] originalBytes = null;
            signedData.verifyInit();
            try {
                originalBytes = signedData.verifyUpdate(bSignature);// 从签名信息中获得的原文
                signedData.verifyFinal();
            } catch (PkiException ex) {
                if (signedData != null)
                    signedData.free();
                throw new PkiException("PKCS7签名验证失败:" + ex.getMessage());
            }
            // 长度不等，不匹配
            if (bFile.length != originalBytes.length) {
                if (signedData != null)
                    signedData.free();
                throw new PkiException("原文与签名信息不匹配1!");
            }
            // 每个字节比对
            for (int i = 0; i < bFile.length; i++) {
                if (bFile[i] != originalBytes[i]) {
                    if (signedData != null)
                        signedData.free();
                    throw new PkiException("原文与签名信息不匹配2!");
                }
            }
        } else {
            if (!(signedData.detachedVerify(bFile, bSignature))) {
                if (signedData != null)
                    signedData.free();
                throw new PkiException("原文与签名信息不匹配3!");
            }
        }
        Certificate cert = signedData.getSignCertificate(0);
        if (cert == null) {
            if (signedData != null)
                signedData.free();
            throw new PkiException("获取签名证书失败!");
        }
        signedData.free();
        return cert;
    }
    
     * 
     
    public static byte[] convertByte(String sData) throws PkiException {
        try {
            return sData.getBytes(BYTE_CODE);
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
            throw new PkiException("字符串转字符编码错误:" + ex.getMessage());
        }
    }

    public static String convertString(byte[] sData) throws PkiException {
        try {
            return new String(sData, BYTE_CODE);
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
            throw new PkiException("字符串转字符编码错误:" + ex.getMessage());
        }
    }

    *//**
     * Base64编码
     * 
     * @param sSource
     * @return
     * @throws PkiException
     *//*
    public static String base64Encode(byte[] sSource) throws PkiException {
        if (sSource == null || "".equals(sSource)) {
            throw new PkiException("输入需要Base64编码的数据为空!");
        }
        return Base64.encode(0, sSource);
    }

    *//**
     * Base64解码，对数据进行Base64解码得到相应的字节数组
     * 
     * @param strBase64     需要进行解码的字符串
     * @return 解码后的字节数组
     * @throws PkiException
     *//*
    public static byte[] base64Decode(String strBase64) throws PkiException {
        if (strBase64 == null || strBase64.equals("")) {
            throw new PkiException("输入需要Base64解码的字符串为空!");
        }
        return Base64.decode(0, strBase64);
    }

    *//**
     * 获取随机数
     * 
     * @param length  生产的随机数的长度
     * @return  随机数
     * @throws PkiException
     *//*
    public static byte[] getRandom(int length) throws PkiException {
        if (length < 1) {
            throw new PkiException("请输入正确的随机数位数!");
        }
        
         * DeviceSet set = new
         * DeviceSet(Device.ANY_DEVICE,//BUILDIN_SOFTWARE_DEVICE
         * .ANY_DEVICE,//Device.SJY05B_DEVICE,
         * Device.DEVICE_FLAG_CACHE_PIN_IN_PROCESS); Device dev = getDevice(set,
         * 0); byte[] random = dev.generateRandom(length); dev.free();
         * set.free(); return random;
         

        try {
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            byte[] bytes = new byte[length];
            random.nextBytes(bytes);
            return bytes;
        } catch (Exception ex) {
            throw new PkiException(ex.getMessage());

        }

    }

    *//**
     * 二进制读文件
     * 
     * @param sFilePath
     * @return
     *//*
    public static byte[] readFile(String sFilePath) {
        File f = new File(sFilePath);
        if (!f.exists()) {
            
             * try { f.createNewFile(); } catch (IOException ex) {
             * ex.printStackTrace(); }
             
            return null;
        }
        FileInputStream fis = null;
        ArrayList<byte[]> al = new ArrayList<byte[]>();
        int len = 0;
        int totallen = 0;
        byte[] totalin = null;
        try {
            fis = new FileInputStream(f);
            while (true) {
                byte[] bin = new byte[8129];
                len = fis.read(bin);
                totallen = totallen + len;
                if (len == bin.length) {
                    al.add(bin);
                } else {
                    byte[] lastin = new byte[len];
                    System.arraycopy(bin, 0, lastin, 0, len);
                    al.add(lastin);
                    break;
                }
            }

            totalin = new byte[totallen];
            int templen = 0;
            for (int i = 0; i < al.size(); i++) {
                System.arraycopy(al.get(i), 0, totalin, templen,
                        (al.get(i)).length);
                templen = templen + al.get(i).length;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (al != null)
                    al.clear();
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return totalin;
    }

    *//**
     * 写文件
     * 
     * @param sFilePath
     * @param bContent
     *//*
    private static void writeFile(String sFilePath, byte[] bContent) {
        File f = new File(sFilePath);
        FileOutputStream outStream = null;
        try {
            outStream = new FileOutputStream(f);
            outStream.write(bContent);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (outStream != null)
                try {
                    outStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    // 返回密钥用法字符串
    private static String PrintKeyUsage(int keyUsage) {

        String kustr = "";
        boolean first = true;

        if ((keyUsage | Certificate.KEYUSAGE_DIGITALSIGNATURE) == keyUsage) {
            if (first) {
                kustr += "数字签名";
            } else {
                kustr += ",数字签名";
            }
            first = false;
        }

        if ((keyUsage | Certificate.KEYUSAGE_NONREPUDIATION) == keyUsage) {
            if (first) {
                kustr += "不可否认";
            } else {
                kustr += ",不可否认";
            }
            first = false;
        }

        if ((keyUsage | Certificate.KEYUSAGE_CONTENTCOMMITMENT) == keyUsage) {
            if (first) {
                kustr += "内容承诺";
            } else {
                kustr += ",内容承诺";
            }
            first = false;
        }
        if ((keyUsage | Certificate.KEYUSAGE_KEYENCIPHERMENT) == keyUsage) {
            if (first) {
                kustr += "加密密钥";
            } else {
                kustr += ",加密密钥";
            }
            first = false;
        }

        if ((keyUsage | Certificate.KEYUSAGE_DATAENCIPHERMENT) == keyUsage) {
            if (first) {
                kustr += "加密数据";
            } else {
                kustr += ",加密数据";
            }
            first = false;
        }

        if ((keyUsage | Certificate.KEYUSAGE_KEYAGREEMENT) == keyUsage) {
            if (first) {
                kustr += "密钥协商";
            } else {
                kustr += ",密钥协商";
            }
            first = false;
        }

        if ((keyUsage | Certificate.KEYUSAGE_KEYCERTSIGN) == keyUsage) {
            if (first) {
                kustr += "签证书";
            } else {
                kustr += ",签证书";
            }
            first = false;
        }

        if ((keyUsage | Certificate.KEYUSAGE_CRLSIGN) == keyUsage) {
            if (first) {
                kustr += "签CRL";
            } else {
                kustr += ",签CRL";
            }
            first = false;
        }

        if ((keyUsage | Certificate.KEYUSAGE_ENCIPHERONLY) == keyUsage) {
            if (first) {
                kustr += "只加密";
            } else {
                kustr += ",只加密";
            }
            first = false;
        }

        if ((keyUsage | Certificate.KEYUSAGE_DECIPHERONLY) == keyUsage) {
            if (first) {
                kustr += "只解密";
            } else {
                kustr += ",只解密";
            }
            first = false;
        }

        if ("".equals(kustr)) {
            return "密钥用法:没有密钥用法";
        } else {
            return "密钥用法:" + kustr;
        }
    }

    private static String hexToStr(byte pBytes[]) {
        byte NUMBER_KEY = 48;
        byte UPPER_KEY = 55;
        byte LOWER_KEY = 87;
        byte HEX_KEY = 16;
        String result = "";
        for (int i = 0; i < pBytes.length; i++) {
            int tmpInt = (new Byte(pBytes[i])).intValue();
            if (tmpInt < 0) {
                tmpInt += 256;
            }
            byte strList[] = new byte[2];
            strList[1] = (new Integer(tmpInt % 16)).byteValue();
            strList[0] = (new Integer((tmpInt / 16) % 16)).byteValue();
            if (strList[1] > 9 && strList[1] < 16) {
                strList[1] += UPPER_KEY;
            }
            if (strList[1] >= 0 && strList[1] < 10) {
                strList[1] += NUMBER_KEY;
            }
            if (strList[0] > 9 && strList[0] < 16) {
                strList[0] += UPPER_KEY;
            }
            if (strList[0] >= 0 && strList[0] < 10) {
                strList[0] += NUMBER_KEY;
            }
            result = result + new String(strList);
        }

        return result;
    }

    private static String getThumbprintStr(byte[] b, String oid)
            throws PkiException {
        try {
            String value = "";

            int byteLength = getStringLength(b);
            byte[] b0 = new byte[b.length - byteLength];
            for (int j = 0; j < b.length - byteLength; j++) {
                b0[j] = b[j + byteLength];
            }

            ASN1InputStream asn1Stream = new ASN1InputStream(
                    new ByteArrayInputStream(b0));
            DERSequence deSequences = (DERSequence) asn1Stream.readObject();
            for (Enumeration e = deSequences.getObjects(); e.hasMoreElements();) {
                DERSequence deSequence = ((DERSequence) e.nextElement());
                Enumeration e1 = deSequence.getObjects();

                DERSequence deSq = (DERSequence) e1.nextElement();
                Enumeration e2 = deSq.getObjects();
                DERObjectIdentifier iden = (DERObjectIdentifier) e2
                        .nextElement();
                // System.out.println("11:" + iden.getId());

                if (oid.equalsIgnoreCase(iden.getId()) && e1.hasMoreElements()) {
                    DEROctetString derStr = (DEROctetString) e1.nextElement();
                    byte tt[] = derStr.getOctets();
                    // System.out.println("22:" + Hex.EncodeToString(tt));
                    value = Hex.EncodeToString(tt);
                }
            }
            return value;
        } catch (Exception ex) {
            throw new PkiException(ex.getMessage());

        }
    }

    *//**
     * 解出asn1编码（两层）中的数据内容。
     * 
     * @param b
     *            byte[]
     * @throws Exception
     * @return String
     *//*
    private static String getString(byte[] b) throws PkiException {
        try {
            int byteLength = getStringLength(b);
            byte[] b0 = new byte[b.length - byteLength];
            for (int j = 0; j < b.length - byteLength; j++) {
                b0[j] = b[j + byteLength];
            }
            String charSet = "";
            if (b0[0] == 0x04) {
                charSet = "GBK";
            } else {
                // if(b0[0] == 0x0c)
                charSet = "UTF-8";
            }

            int byteLength1 = getStringLength(b0);
            byte[] b1 = new byte[b0.length - byteLength1];
            for (int j = 0; j < b0.length - byteLength1; j++) {
                b1[j] = b0[j + byteLength1];
            }

            return new String(b1, charSet);
        } catch (Exception ex) {
            throw new PkiException(ex.getMessage());

        }
    }

    *//**
     * 得到asn1编码的头标志长度
     * 
     * @param b
     *            byte[]
     * @return int
     *//*
    private static int getStringLength(byte[] b) {
        // byte[] b0 = null;
        int ccc[] = new int[8];
        for (int z = 0; z < 8; z++) {
            char tem = 1;
            tem <<= z;
            tem &= b[1];
            tem >>= z;
            ccc[z] = tem;
        }
        int byteLength = 2;
        if (ccc[7] == 1) {
            byteLength = 2 + ccc[0] + ccc[1] * 2 + ccc[2] * 4 + ccc[3] * 8
                    + ccc[4] * 16 + ccc[5] * 32 + ccc[6] * 64;
        }
        return byteLength;
    }
*/
}
