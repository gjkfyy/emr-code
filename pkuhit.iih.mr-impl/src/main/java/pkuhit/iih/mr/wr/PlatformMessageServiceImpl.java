package pkuhit.iih.mr.wr;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import org.xml.sax.InputSource;

import com.founder.xmlconvert.ConvertHeaderService;
import com.founder.xmlconvert.ConvertHeaderServiceWS;

import ei.en.mz.service.MzEiEncounterService;

import pkuhit.iih.ass.di.AssDiagnosisService;
import pkuhit.iih.ass.or.AssOrderService;
import pkuhit.iih.di.DiagnosisModel;
import pkuhit.iih.en.md.EncounterForXMLModel;
import pkuhit.iih.en.md.PatientModel;
import pkuhit.iih.mr.dao.auto.MrAmrDao;
import pkuhit.iih.mr.wr.MedicalRecord;
import pkuhit.iih.or.OrderModel;
import pkuhit.iih.pub.IihUtils;
import pkuhit.me.DataObjectService;
import pkuhit.xap.ac.Session;
import pkuhit.xap.file.FileObject;
import pkuhit.xap.file.FileService;
import pkuhit.xap.pm.ParamsSetService;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;

public class PlatformMessageServiceImpl implements PlatformMessageService
{
    public static Logger log = LoggerFactory.getLogger(PlatformMessageServiceImpl.class);
            
    @Autowired
    MrAmrDao mrAmrDao;
    
    @Reference
    DataObjectService dataObjectService;
    
    @Reference
    FileService fileService;
    
    @Reference
    ParamsSetService paramsSetService;
    
    @Reference
    MzEiEncounterService mzEncounterService;
    
    @Reference
    AssDiagnosisService assDiagnosisService;
    
    @Reference
    AssOrderService assOrderService;
    
    @Override
    public String sendMessage(Map<String, String> params, MedicalRecord value) throws Throwable {
        FileObject fileObject = fileService.getFile(value.getXmlFilePk());
        String xmlSource = new String(fileObject.asByteArray(),"UTF-8");
        log.info("log MQ源数据：" + xmlSource);
        
        StringReader read = new StringReader(xmlSource);
        InputSource source = new InputSource(read);
        SAXBuilder saxbBuilder = new SAXBuilder();
        Session session = Session.get();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 通过输入源构造一个Document
        try {
            int index = 0;
            log.info("log 创建XML文档 begin...");
            Document doc = saxbBuilder.build(source);
            log.info("log 创建XML文档 end...");
            Element root= doc.getRootElement();
            //文档头信息
            Map<String,Object> headInfo = new HashMap<String,Object>();
            String versionNumber = params.get("versionNumber");
            headInfo.put("versionNumber", versionNumber);//文档的操作版本:0表示新增, 1表示修改，-1表示删除
            String serviceId = params.get("serviceId");
            headInfo.put("ServiceId", serviceId);//服务ID,固定值为：BS333
            headInfo.put("documentLid", value.getMrPk());//文档流水号
            String domainId = params.get("domainId");
            headInfo.put("domainId", domainId);//域ID,门诊:01,住院：02
            headInfo.put("authorCode", value.getSubmitCd());//提交人
            headInfo.put("authorName", IihUtils.userIdToName(dataObjectService, value.getSubmitCd()));//提交人
            headInfo.put("submitTime", sdf.format(value.getSubmitDate()==null?new Date():value.getSubmitDate()));//提交时间
            headInfo.put("orgCode", session.getOrgCd());//医疗机构
            headInfo.put("orgName", IihUtils.deptCodeToName(dataObjectService, session.getOrgCd()));//医疗机构
            FileObject pdfObject = fileService.getFile(value.getCaFilePk());
            String pdfSource = new String(pdfObject.asByteArray());
            headInfo.put("pdf", pdfSource);//PDF文件的Base64码
            Element head = new Element("head");
            Element element = createXmlNode(headInfo,head,true);
            root.addContent(index, element);
            index++;
            //就诊信息
            EncounterForXMLModel encounter = mzEncounterService.getEncounterDetailForMz(value.getEncounterPk(), null, null);
            if(EncounterForXMLModel.ENCOUNTER_TYPE_ONP_CODE.equals(encounter.getEnTpCd())){
                encounter.setEnTpNm(EncounterForXMLModel.ENCOUNTER_TYPE_ONP_NAME);
            }else if(EncounterForXMLModel.ENCOUNTER_TYPE_EMG_CODE.equals(encounter.getEnTpCd())){
                encounter.setEnTpNm(EncounterForXMLModel.ENCOUNTER_TYPE_EMG_NAME);
            }else{
                encounter.setEnTpNm(EncounterForXMLModel.ENCOUNTER_TYPE_INP_NAME);
            }
            encounter.setRcvDeptNm(IihUtils.deptCodeToName(dataObjectService, encounter.getRcvDeptCd()));
            encounter.setAge(encounter.getAge()==null?"":encounter.getAge().replace("岁", ""));
            Element encounterInfo = new Element("encounter");
            Element enElement = createXmlNode(encounter,encounterInfo,false);
            root.addContent(index, enElement);
            index++;
            //患者基本信息
            PatientModel patient = mzEncounterService.getPatientDetailForMz(encounter.getPaId());
            Element patientInfo = new Element("patient");
            Element paElement = createXmlNode(patient,patientInfo,false);
            root.addContent(index, paElement);
            index++;
            //诊断信息
            ArrayResult<DiagnosisModel> diRs = assDiagnosisService.search(value.getEncounterPk(), null, null, null, null);
            DiagnosisModel[] dis = diRs.getDataList();
            if(dis.length>0){
                Element diagnosis = new Element("diagnosis");
                for (int i=0; i<dis.length; i++) {
                    DiagnosisModel di = dis[i];
                    Element diEntry = new Element("entry");
                    Element diElement = createXmlNode(di,diEntry,false);
                    diagnosis.addContent(i, diElement);
                }
                root.addContent(index, diagnosis);
                index++;
            }
            //医嘱信息
            ArrayResult<OrderModel> orRs = assOrderService.search(value.getEncounterPk(),null,null, null, null, null, null);
            OrderModel[] orders = orRs.getDataList();
            if(orders.length>0){
                Element orderInfo = new Element("order");
                int j = 0;
                for (OrderModel order : orders) {
                    SingleResult<String> param= paramsSetService.searchFunFlagByKey("OMR_PRESCRIPTION_REFRESH_TIMELIMIT");
                    Calendar c = Calendar.getInstance();
                    int timeLimit = 0;
                    if(!StringUtils.isEmpty(param.getData()))
                        timeLimit = Integer.parseInt(param.getData());
                    c.add(Calendar.HOUR, 0-timeLimit);
                    Date beginTime= c.getTime();
                    Date crtTimeStr = order.getCrtTime();
                    
                    String orUserId = order.getOrCrtDctCd();
                    String loginUserId = session.getUserId();
                    if (crtTimeStr.after(beginTime) && loginUserId.equals(orUserId)) {
                        StringBuilder sb = new StringBuilder();
                        if(order.getSvNm()!=null && !"".equals(order.getSvNm())){
                            sb.append(order.getSvNm());
                        }
                        if(order.getSpec()!=null && !"".equals(order.getSpec())){
                            if(sb.length()>0)
                                sb.append(" ");
                            sb.append("规格:"+order.getSpec());
                        }
                        if(order.getDosage()!=null && !"".equals(order.getDosage())){
                            if(sb.length()>0)
                                sb.append(" ");
                            sb.append("剂量:"+order.getDosage());
                        }
                        if(order.getRouteNm()!=null && !"".equals(order.getRouteNm())){
                            if(sb.length()>0)
                                sb.append(" ");
                            sb.append("用法:"+order.getRouteNm());
                        }
                        if(order.getFreqNm()!=null && !"".equals(order.getFreqNm())){
                            if(sb.length()>0)
                                sb.append(" ");
                            sb.append("频率:"+order.getFreqNm());
                        }
                        order.setSvNm(sb.toString());
                        order.setOrCrtDctNm(IihUtils.userIdToName(dataObjectService, order.getOrCrtDctCd()));
                        
                        Element orEntry = new Element("entry");
                        Element orElement = createXmlNode(order,orEntry,false);
                        orderInfo.addContent(j, orElement);
                        j++;
                    }
                }
                root.addContent(index, orderInfo);
                index++;
            }
            xmlSource = doc2String(doc);
            log.info("log MQ参数：" + xmlSource);
            
            //调用webservice接口
            String serviceUrl=paramsSetService.searchFunFlagByKey("XML_CONVERT_WEBSERVICE_URL").getData();
            URL url = null;
            try {
                url = new URL(serviceUrl);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            ConvertHeaderServiceWS ws=new ConvertHeaderServiceWS(url, new QName("xmlconvert.founder.com", "ConvertHeaderServiceWS"));
            ConvertHeaderService cs=ws.getConvertHeaderServicePort();
            String str = cs.sendMq(xmlSource);
            return str;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * Document转换String
     */
    public static String doc2String(Document doc) throws Exception {     
        Format format = Format.getPrettyFormat();     
        format.setEncoding("GBK");// 设置xml文件的字符为UTF-8，解决中文问题     
        XMLOutputter xmlout = new XMLOutputter(format);     
        ByteArrayOutputStream bo = new ByteArrayOutputStream();     
        xmlout.output(doc, bo);     
        return bo.toString();     
    }
    
    /**
     * 对象转换节点
     */
    @SuppressWarnings("unchecked")
    private static Element createXmlNode(Object object,Element element,boolean isMap) {
        try {
            Map<String, Object> map = null;
            if(isMap){
                map = (Map<String, Object>)object;
            }else{
                map= objectToMap(object);
            }
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
}
