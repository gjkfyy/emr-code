package pkuhit.iih.mr.wr;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;

import org.apache.commons.lang3.StringUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.xml.sax.InputSource;

import pkuhit.iih.en.md.PatientInfoForXMLModel;
import pkuhit.iih.mr.dao.auto.MrDao;
import pkuhit.iih.mr.dao.auto.entity.Mr;
import pkuhit.iih.mr.md.MrSignLevel;
import pkuhit.iih.mr.md.dao.auto.MdMrTpDao;
import pkuhit.iih.mr.md.dao.auto.entity.MdMrTp;
import pkuhit.iih.mr.pub.MessageCode;
import pkuhit.iih.pub.IihUtils;
import pkuhit.me.DataObjectService;
import pkuhit.xap.file.FileObject;
import pkuhit.xap.file.FileService;
import pkuhit.xap.pm.ParamsSetService;
import xap.sv.annotation.Reference;
import xap.sv.model.SingleResult;
import xap.sv.notification.Notification;
import xap.sv.notification.exception.NotificationException;

import com.founder.xmlconvert.ConvertHeaderService;
import com.founder.xmlconvert.ConvertHeaderServiceWS;

import ei.pa.service.PatientInfoForXMLService;

public class MrXMLServiceImpl implements MrXMLService {
	
	private Logger log = LoggerFactory.getLogger(MrXMLServiceImpl.class);
	@Autowired
	MrDao mrDao;
	
	@Autowired
	MdMrTpDao mdMrTpDao;
	
	@Reference
	FileService fileService;
	
	@Reference
	ParamsSetService paramsSetService;
	
	@Reference
	DataObjectService dataObjectService;
	
	@Reference
	PatientInfoForXMLService patientInfoForXMLService;
	
	
	private SingleResult<MrXML> searchMrModel(Mr mr) throws Throwable {
		SingleResult<MrXML> result=new SingleResult<MrXML>();
		MrXML mrXML=new MrXML();
		if(mr!=null){
			mrXML.setId(mr.getMrPk());//文档流水号
			mrXML.setEffectiveTime(transferLongToDate("yyyyMMddHHmmss",mr.getCrtTime().getTime()));//文档生成时间
			mrXML.setDomainId(null);//域Id
			mrXML.setAuthorId(null);//文档创作者ID
			mrXML.setAuthorName(null);//文档创作者姓名
			mrXML.setTitle(mr.getNm());
			mrXML.setDocTime(transferLongToDate("yyyyMMdd",mr.getBizTime().getTime()));//文档时间
			mrXML.setDoctorId(mr.getCrtUserId());//文档医生Id
			mrXML.setDoctorName(IihUtils.userIdToName(dataObjectService, mr.getCrtUserId()));//文档医生
			mrXML.setEnPk(mr.getEnPk());
			mrXML.setMrStatusCode(mr.getMrStaCd());
			if(!StringUtils.isBlank(mr.getTreatDoctorCd())){
				mrXML.setTreatDoctorId(mr.getTreatDoctorCd());
				mrXML.setTreatDoctorName(IihUtils.userIdToName(dataObjectService, mr.getTreatDoctorCd()));
				mrXML.setTreatDoctorTime(transferLongToDate("yyyyMMdd",mr.getCrtTime().getTime()));
			}
			if(!StringUtils.isBlank(mr.getMastDoctorCd())&&mr.getMastDoctorDate()!=null){
				mrXML.setMastDoctorId(mr.getMastDoctorCd());
				mrXML.setMastDoctorName(IihUtils.userIdToName(dataObjectService, mr.getMastDoctorCd()));
				mrXML.setMastDoctorTime(transferLongToDate("yyyyMMdd",mr.getMastDoctorDate().getTime()));
			}
			if(!StringUtils.isBlank(mr.getDirDoctorCd())&&mr.getDirDoctorDate()!=null){
				mrXML.setDirDoctorId(mr.getDirDoctorCd());
				mrXML.setDirDoctorName(IihUtils.userIdToName(dataObjectService, mr.getDirDoctorCd()));
				mrXML.setDirDoctorTime(transferLongToDate("yyyyMMdd",mr.getDirDoctorDate().getTime()));
			}
			//最后审签医师
			if(mr.getSignLvlCd().equals(MrSignLevel.LEVEL_TWO_SIGN)&&mr.getMastDoctorDate()!=null){//二级审签主治
				mrXML.setAuditDoctorId(mr.getMastDoctorCd());//审核医生编码
				mrXML.setAuditDoctorName(IihUtils.userIdToName(dataObjectService, mr.getMastDoctorCd()));
				mrXML.setAuditTime(transferLongToDate("yyyyMMdd",mr.getMastDoctorDate().getTime()));//审核日期
			}else if(mr.getSignLvlCd().equals(MrSignLevel.LEVEL_THREE_SIGN)&&mr.getMastDoctorDate()!=null){//三级审签主任
				mrXML.setAuditDoctorId(mr.getDirDoctorCd());
				mrXML.setAuditDoctorName(IihUtils.userIdToName(dataObjectService,mr.getDirDoctorCd()));
				mrXML.setAuditTime(transferLongToDate("yyyyMMdd",mr.getDirDoctorDate().getTime()));
			}else{//无需审签和一级审签
				mrXML.setAuditDoctorId(mr.getCrtUserId());
				mrXML.setAuditDoctorName(IihUtils.userIdToName(dataObjectService, mr.getCrtUserId()));
				if(mr.getMastDoctorDate()!=null)
				mrXML.setAuditTime(transferLongToDate("yyyyMMdd",mr.getBizTime().getTime()));
			}
			result.setData(mrXML);
			return result;
		}
		result.setData(new MrXML());
		return result;
	}
	/**
	 * @param mr_pk
	 * @return xml域信息
	 */
	@Transactional
	@Override
	public SingleResult<String> assembledXML(String id) throws Throwable {
		String xmlSource=null;
		String jsonStr=null;
		String templateStr =null;
		FileObject fileObject=null;
		SingleResult<String> result=new SingleResult<String>();
		Mr mr= mrDao.selectById(id);
		//返回病历类型
		MdMrTp mdMrTp=mdMrTpDao.selectById(mr.getMrTpCd());
		if(mdMrTp!=null&&mdMrTp.getXmlJsonPk()!=null&&mdMrTp.getXmlTemplatePk()!=null){
			fileObject=fileService.getFile(mdMrTp.getXmlJsonPk());
			jsonStr=new String(fileObject.asByteArray());
			fileObject=fileService.getFile(mdMrTp.getXmlTemplatePk());
			templateStr=new String(fileObject.asByteArray());
			if(mr!=null){
				fileObject=fileService.getFile(mr.getXmlFilePk());
				xmlSource=new String(fileObject.asByteArray());
				//返回病历信息
				MrXML mrXML=searchMrModel(mr).getData();
				//患者信息
				PatientInfoForXMLModel patientInfoForXMLModel=patientInfoForXMLService.getPatientInfoForXML(mr.getEnPk()).getData();
				
				StringReader read = new StringReader(xmlSource);
				InputSource source = new InputSource(read);
				SAXBuilder saxbBuilder = new SAXBuilder();
				// 通过输入源构造一个Document
				try {
					Document doc = saxbBuilder.build(source);
					//获取病历信息xml
					Element head = new Element("head");
					Element element=createXmlNode(mrXML,head);
					//获取基本信息xml
					Element basic = new Element("PatientBasicInfo");
					Element basicElement=createXmlNode(patientInfoForXMLModel,basic);
					Element root= doc.getRootElement();
					root.addContent(0, element);
					root.addContent(1,basicElement);
					xmlSource=doc2String(doc);
					//result.setData(); 
					//调用webservice接口
					String serviceUrl=paramsSetService.searchFunFlagByKey("XML_CONVERT_WEBSERVICE_URL").getData();
					if(StringUtils.isBlank(serviceUrl)){
						log.error("xmlWebService接口地址未设定");
					}
		            URL url = null;
					try {
						url = new URL(serviceUrl);
					} catch (MalformedURLException e) {
						e.printStackTrace();
					}
					ConvertHeaderServiceWS ws=new ConvertHeaderServiceWS(url, new QName("xmlconvert.founder.com", "ConvertHeaderServiceWS"));
					ConvertHeaderService cs=ws.getConvertHeaderServicePort();
					String str=cs.convert(xmlSource, jsonStr, templateStr, false);
					result.setData(str);
//					System.out.println("****************************************结果数据****************************************");
//					System.out.println(str);
					return result;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		result.setData("");
		return result;
	}
	/**
	 * oracle.sql.Clob类型转换成String类型
	 */
	public static String clobToString(Clob clob) {
        String reString = "";
        Reader is = null;
        try {
            is = clob.getCharacterStream();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 得到流
        BufferedReader br = new BufferedReader(is);
        String s = null;
        try {
            s = br.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        StringBuffer sb = new StringBuffer();
        while (s != null) {
            //执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING
            sb.append(s);
            try {
                s = br.readLine();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        reString = sb.toString();
        return reString;
    }
	/**
	 * Document转换String
	 */
	public static String doc2String(Document doc) throws Exception {     
        Format format = Format.getPrettyFormat();     
        format.setEncoding("UTF-8");// 设置xml文件的字符为UTF-8，解决中文问题     
        XMLOutputter xmlout = new XMLOutputter(format);     
        ByteArrayOutputStream bo = new ByteArrayOutputStream();     
        xmlout.output(doc, bo);     
        return bo.toString();     
    } 
	/**
	 * 对象转换节点
	 */
	private static Element createXmlNode(Object object,Element element) {
		try {
			Map<String, Object> map= objectToMap(object);
			 for (String key : map.keySet()) {
				Element id = new Element(key); 
				if(map.get(key)!=null){
					id.setAttribute("value", map.get(key).toString());
				}else{
					id.setAttribute("value", "");
				}
				element.addContent(id);
			 }		
			 return element;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
		
	}
	/**
	 * Object转换Map
	 */
	 private static  Map<String, Object> objectToMap(Object obj) throws Exception {    
	        if(obj == null)  
	            return null;      
	  
	        Map<String, Object> map = new HashMap<String, Object>();   
	        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());    
	        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();    
	        for (PropertyDescriptor property : propertyDescriptors) {    
	            String key = property.getName();    
	            if (key.compareToIgnoreCase("class") == 0) {   
	                continue;  
	            }  
	            Method getter = property.getReadMethod();  
	            Object value = getter!=null ? getter.invoke(obj) : null;  
	            map.put(key, value);  
	        }    
	        return map;  
	    }    
	 /**
	  * Date转指定格式yyyy-MM-dd HH:ss:mm
	  */
	 private String transferLongToDate(String dateFormat,Long dateTime){
	     SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
	     Date date= new Date(dateTime);
	     return sdf.format(date);
	    }
}
