package pkuhit.iih.mr.wr;

import java.beans.IntrospectionException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.aspectj.apache.bcel.generic.IF_ACMPEQ;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.en.md.EncounterType;
import pkuhit.iih.mr.dao.auto.MrAmrDao;
import pkuhit.iih.mr.dao.auto.MrDao;
import pkuhit.iih.mr.dao.auto.MrTplDao;
import pkuhit.iih.mr.dao.auto.entity.Mr;
import pkuhit.iih.mr.dao.auto.entity.MrAmr;
import pkuhit.iih.mr.dao.auto.entity.MrTpl;
import pkuhit.iih.mr.md.MrSignLevel;
import pkuhit.iih.mr.md.MrSource;
import pkuhit.iih.mr.md.MrStatus;
import pkuhit.iih.mr.md.dao.custom.CusMdMrOrDao;
import pkuhit.iih.mr.wr.dao.CusFileDao;
import pkuhit.iih.mr.wr.dao.CusMrAmrDao;
import pkuhit.iih.mr.wr.dao.CusMrDao;
import pkuhit.iih.pub.IihUtils;
import pkuhit.me.DataObjectService;
import pkuhit.utils.OdtTurnPdfUtil;
import pkuhit.xap.ac.Session;
import pkuhit.xap.ac.User;
import pkuhit.xap.ac.UserService;
import pkuhit.xap.file.FileObject;
import pkuhit.xap.file.FileService;
import pkuhit.xap.pm.ParamsService;
import xap.sv.annotation.Reference;
import xap.sv.app.Application;
import xap.sv.model.ArrayResult;
import xap.sv.scope.ScopeManager;
import xap.sv.session.SessionScope;
import xap.sv.util.UUIDGenerator;

@WebService
public class IEMRWebServiceImpl implements IEMRWebService {
	private static Logger log = LoggerFactory.getLogger(IEMRWebServiceImpl.class);

	@Autowired
	CusMrDao cusmrDao;

	@Autowired
	CusMdMrOrDao cusMdMrOrDao;
	
	@Autowired
	MrAmrDao mrAmrDao;

	@Autowired
	MrDao mrDao;
	
	@Autowired
	CusMrAmrDao cusMrAmrDao;

	//模板获取dao
	@Autowired  
	MrTplDao mrTplDao ;
	
	@Autowired
	CusFileDao mrFileDao;

	@Reference
	ParamsService paramsService;

	@Reference
	FileService fileService;

	@Reference
	DataObjectService dataObjectService;
	
	@Reference
	UserService userService;

	@Override
	public String getMrPdfList(String enPk, Boolean pdfFlag, Boolean odtFlag) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (!StringUtils.isBlank(enPk)) {
			List<Mr> mrs = cusmrDao.selectMrsByEnPkAndDel(enPk);
			if (mrs.size() > 0) {
				List<ArchiveFile> files = new ArrayList<ArchiveFile>();
				for (Mr mr : mrs) {
					ArchiveFile file = new ArchiveFile();
					file.setMrPk(mr.getMrPk());
					FileObject fileObject = fileService.getFile(mr.getFilePk());
					FileObject pdfFileObject;
					try {
						if (!StringUtils.isBlank(mr.getCaFilePk())) {
							pdfFileObject = fileService.getFile(mr.getCaFilePk());
							file.setPdfBase64(new String(pdfFileObject.asByteArray()));
						}
						file.setOdtBase64(new String(fileObject.asByteArray()));
					} catch (IOException e) {
						e.printStackTrace();
					}
					file.setNm(mr.getNm());
					file.setMrSatusCode(mr.getMrStaCd());
					file.setCreatorName(IihUtils.userIdToName(dataObjectService, mr.getCrtUserId()));
					file.setCreateDateTime(mr.getCrtTime() != null ? df.format(mr.getCrtTime()) : "");
					file.setLastModifyDateTime(mr.getLastUpdTime() != null ? df.format(mr.getLastUpdTime()) : "");
					file.setSignPaperDatetime(mr.getSubmitDate() != null ? df.format(mr.getSubmitDate()) : "");
					file.setCreateDisplayDateTime(mr.getCrtTime() != null ? df.format(mr.getCrtTime()) : "");
					if (MrSignLevel.LEVEL_ONE_SIGN.equals(mr.getSignLvlCd())
							|| MrSignLevel.NEED_NOT_SIGN.equals(mr.getSignLvlCd())) {// 1级
						file.setFileFlag("1");
					} else if (MrSignLevel.LEVEL_TWO_SIGN.equals(mr.getSignLvlCd())) {// 2级
						file.setFileFlag("2");
					} else if (MrSignLevel.LEVEL_THREE_SIGN.equals(mr.getSignLvlCd())) {// 3级申签
						file.setFileFlag("3");
					} else {
						file.setFileFlag("T");
					}
					file.setnRate(null);// 完成比率
					files.add(file);
				}
				/*
				 * String odtPath=filePath+"/odt.odt"; String
				 * pdfPath=filePath+"/pdf.pdf";
				 */
				if (files != null) {
					String xmlString = getXmlString(files, null, null, null, null, pdfFlag, odtFlag);
					return xmlString;
				}
			}
		}
		return null;
	}

	/**
	 * 将对象组装成xml
	 */
	private String getXmlString(List<ArchiveFile> files, String filePath, String openOfficeHome, String odtFilePath,
			String pdfFilePath, Boolean pdfFlag, Boolean odtFlag) {

		Document doc = null;
		String xmlStr = "<?xml version='1.0' encoding='UTF-8'?><mrList></mrList>";
		doc = IihUtils.xmlConvertDom(xmlStr);
		if (!pdfFlag && odtFlag) {// result odt
			for (ArchiveFile archiveFile : files) {
				archiveFile.setPdfBase64(null);
			}
			assembleNodes(files, doc);
		} else if (pdfFlag && !odtFlag) {// result pdf
			// files=ConvertListPdfBase64(filePath,openOfficeHome,odtFilePath,pdfFilePath,files);
			for (ArchiveFile archiveFile : files) {
				archiveFile.setOdtBase64(null);
			}
			assembleNodes(files, doc);
		} else if (pdfFlag && odtFlag) {// result odt pdf
			// files=ConvertListPdfBase64(filePath,openOfficeHome,odtFilePath,pdfFilePath,files);
			assembleNodes(files, doc);
		} else {
			for (ArchiveFile archiveFile : files) {
				archiveFile.setOdtBase64(null);
				archiveFile.setPdfBase64(null);
			}
			assembleNodes(files, doc);
		}
		if (doc != null) {
			try {
				return docString(doc);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	private String docString(Document doc) throws Exception {
		Format format = Format.getPrettyFormat();
		format.setEncoding("UTF-8");// 设置xml文件的字符为UTF-8，解决中文问题
		XMLOutputter xmlout = new XMLOutputter(format);
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		PrintWriter out = new PrintWriter(bo);
		xmlout.output(doc, out);
		return bo.toString();
	}

	private void assembleNodes(List<ArchiveFile> files, Document doc) {
		Element root = doc.getRootElement();
		if (files != null) {
			for (ArchiveFile archiveFile : files) {
				Element element = new Element("mr");
				Element nodeMrPk = new Element("mrPk");
				nodeMrPk.setText(archiveFile.getMrPk());
				Element nodeMrName = new Element("mrName");
				nodeMrName.setText(archiveFile.getNm());
				Element mrStatusCode = new Element("mrStatusCode");
				mrStatusCode.setText(archiveFile.getMrSatusCode());
				nodeMrName.setText(archiveFile.getNm());
				Element nodeMrPdfContent = new Element("mrPdfContent");
				Element nodeMrOdtContent = new Element("mrOdtContent");
				Element nodeMrXmlContent = new Element("mrXmlContent");
				try {
					if (!StringUtils.isBlank(archiveFile.getPdfBase64())) {
						nodeMrPdfContent.setText(new String(archiveFile.getPdfBase64()));
					}
					if (!StringUtils.isBlank(archiveFile.getOdtBase64())) {
						nodeMrOdtContent.setText(archiveFile.getOdtBase64());
					}
					if (!StringUtils.isBlank(archiveFile.getXmlFileData())) {
						nodeMrXmlContent.setText(archiveFile.getXmlFileData());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				Element creatorName = new Element("creatorName");
				Element createDateTime = new Element("createDateTime");
				Element lastModifyDateTime = new Element("lastModifyDateTime");
				Element signPaperDatetime = new Element("signPaperDatetime");
				Element createDisplayDateTime = new Element("createDisplayDateTime");
				Element fileFlag = new Element("fileFlag");
				Element nRate = new Element("nRate");
				creatorName.setText(archiveFile.getCreatorName());
				createDateTime.setText(archiveFile.getCreateDateTime());
				lastModifyDateTime.setText(archiveFile.getLastModifyDateTime());
				signPaperDatetime.setText(archiveFile.getSignPaperDatetime());
				createDisplayDateTime.setText(archiveFile.getCreateDisplayDateTime());
				fileFlag.setText(archiveFile.getFileFlag());
				nRate.setText(archiveFile.getnRate() != null && !archiveFile.getnRate().equals("") ? archiveFile
						.getnRate().toString() : "0");
				element.addContent(mrStatusCode);
				element.addContent(nodeMrPk);
				element.addContent(nodeMrName);
				element.addContent(nodeMrPdfContent);
				element.addContent(nodeMrOdtContent);
				element.addContent(nodeMrXmlContent);
				element.addContent(creatorName);
				element.addContent(createDateTime);
				element.addContent(lastModifyDateTime);
				element.addContent(signPaperDatetime);
				element.addContent(createDisplayDateTime);
				element.addContent(fileFlag);
				element.addContent(nRate);
				root.addContent(element);
			}
		}
	}

	/**
	 * 多个odtBase64转换pdfBase64
	 */
	private List<ArchiveFile> ConvertListPdfBase64(String filePath, String openOfficeHome, String odtFilePath,
			String pdfFilePath, List<ArchiveFile> odtList) {
		try {
			File uploadPath = new File(filePath);
			if (!uploadPath.exists()) {
				uploadPath.mkdir();
			}
			List<ArchiveFile> files = OdtTurnPdfUtil.getPdfBytes(openOfficeHome, odtFilePath, pdfFilePath, odtList);
			return files;
		} catch (IOException e) {
			log.error("进行处理文件程序出错，请联系工程师！！！");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String updMrPrintCount(String enPk) {
		try {
			List<Mr> mrs = cusmrDao.selectMrsByEnPkAndDel(enPk);
			if (mrs != null) {
				for (Mr mr : mrs) {
					Integer cnt = mr.getPrintCount() == null ? 0 : Integer.valueOf(mr.getPrintCount());
					mr.setPrintCount(cnt + 1);
					mrDao.updateExcludeNull(mr);
				}
			}
			return "1";

		} catch (Exception e) {
			e.printStackTrace();
			return "0";

		}
	}

	
	@Override
	public String selectXmlOnEnPk(String enPk) throws IOException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (!StringUtils.isBlank(enPk)) {
			List<MrXMLFile> mxfs = new ArrayList<MrXMLFile>();
			List<Mr> mrs = cusmrDao.selectMrsByEnPkAndDel(enPk);
			MrAmr mrAmr = mrAmrDao.selectById(enPk);
			if (mrs != null && mrs.size() > 0) {
				for (Mr mr : mrs) {
					MrXMLFile mxf = new MrXMLFile();
					mxf.setMrPk(mr.getMrPk());
					mxf.setMrName(mr.getNm());
					mxf.setPatientId(mrAmr.getPaId());
					mxf.setMrSatusCode(mr.getMrStaCd());
					mxf.setLastModifyDateTime(mr.getLastUpdTime() != null ? df.format(mr.getLastUpdTime()) : "");
					mxf.setCreatorName(IihUtils.userIdToName(dataObjectService, mr.getCrtUserId()));
					mxf.setCreateDateTime(mr.getCrtTime() != null ? df.format(mr.getCrtTime()) : "");
					if(!StringUtils.isBlank(mr.getXmlFilePk())){
						FileObject xmlFileObject = fileService.getFile(mr.getXmlFilePk());
						mxf.setMrXmlData(new String(xmlFileObject.asByteArray(),"UTF-8"));
					}else{
						mxf.setMrXmlData("");
					}
					mxfs.add(mxf);
				}
				// 将对象转成xml
				String xmlString = getMxfConvertDom(mxfs);
				return xmlString;
			}
		}
		return null;
	}

	private String getMxfConvertDom(List<MrXMLFile> mxfs) {
		String xmlStr = "<?xml version='1.0' encoding='UTF-8'?><mrList></mrList>";
		Document doc = IihUtils.xmlConvertDom(xmlStr);
		Element root = doc.getRootElement();
		for (MrXMLFile mrXMLFile : mxfs) {
			Element node = new Element("mr");
			try {
				Map<String,String> map = IihUtils.convertBean(mrXMLFile);
				for (String s : map.keySet()) {
					Element element = new Element(s);
					element.addContent(map.get(s));
					node.addContent(element);
				}
			} catch (IntrospectionException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			root.addContent(node);
		}
		try {
			return docString(doc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取病历模板列表
	 * */
	@Override
	public String selectMrTypeCodeList(String hospitalId,
			String hospitalId_DeptCode_EmpId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String selectMrInfosList(String enc_id, String pa_id, String times,
			String templateId)  {
		String rsMess = null ;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (!StringUtils.isBlank(enc_id)) {
			log.debug("enc_id="+enc_id+"|templateId="+templateId);
			List<Mr> mrs = cusmrDao.selectMrsByEnPkAndMrTypeCode(enc_id,templateId);
			if (null!=mrs && mrs.size() > 0) {
				List<ArchiveFile> files = new ArrayList<ArchiveFile>();
				for (Mr mr : mrs) {
					ArchiveFile file = new ArchiveFile();
					file.setMrPk(mr.getMrPk());
					file.setNm(mr.getNm());
					file.setMrSatusCode(mr.getMrStaCd());
					file.setCreatorName(IihUtils.userIdToName(dataObjectService, mr.getCrtUserId()));
					file.setCreateDateTime(mr.getCrtTime() != null ? df.format(mr.getCrtTime()) : "");
					file.setLastModifyDateTime(mr.getLastUpdTime() != null ? df.format(mr.getLastUpdTime()) : "");
					file.setSignPaperDatetime(mr.getSubmitDate() != null ? df.format(mr.getSubmitDate()) : "");
					file.setCreateDisplayDateTime(mr.getCrtTime() != null ? df.format(mr.getCrtTime()) : "");
					if (MrSignLevel.LEVEL_ONE_SIGN.equals(mr.getSignLvlCd())
							|| MrSignLevel.NEED_NOT_SIGN.equals(mr.getSignLvlCd())) {// 1级
						file.setFileFlag("1");
					} else if (MrSignLevel.LEVEL_TWO_SIGN.equals(mr.getSignLvlCd())) {// 2级
						file.setFileFlag("2");
					} else if (MrSignLevel.LEVEL_THREE_SIGN.equals(mr.getSignLvlCd())) {// 3级申签
						file.setFileFlag("3");
					} else {
						file.setFileFlag("T");
					}
					files.add(file);
				}
				if (files != null && files.size() > 0 ) {
					Document doc = null;
					String xmlStr = "<?xml version='1.0' encoding='UTF-8'?><mrList></mrList>";
					doc = IihUtils.xmlConvertDom(xmlStr);
					for (ArchiveFile archiveFile : files) {
							archiveFile.setOdtBase64(null);
							archiveFile.setPdfBase64(null);
					}
					assembleNodes(files, doc);
					try {
						String rs =  docString(doc);
						String temId = templateId ;if(null==templateId){temId ="";} ;
						rs = rs.replace("<mrList>", "<mrList>\n<enc_id>"+ enc_id+"</enc_id>\n<templateId>"+temId+"</templateId>");
						return rs ;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}else{
				if(null==mrs ){
					log.info("mrs is null");
					rsMess ="MR_LIST_IS_NULL" ;
				}else{
					log.info("mrs is empty");
					rsMess ="MR_LIST_IS_EMPTY" ;
				}

			}
		}else{
			log.info("enc_id is blank");
			rsMess ="ENC_ID_IS_BLANK" ;
		}
		return rsMess;
	
	}

	@Override
	public String getMrXml(String enPk,String pa_id,String times, String ctrTime, String templateId,
			String mrPk,String empId) {
		String rsMess = null ;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (!StringUtils.isBlank(enPk)) {
			Mr mr = null ;
			if(StringUtils.isNotBlank(mrPk)){
				log.debug("mrPk="+mrPk);
				//mrPk 病历记录的主键不为空，直接获取
				mr = mrDao.selectById(mrPk);
			}else{
				//根据enPk,创建时间，病历类型来获得未删除的病历列表
				log.debug("enPk:"+enPk+"|ctrTime:"+ctrTime+"|templateId:"+templateId);
				List<Mr> mrList = cusmrDao.selectMrsByConds(enPk,ctrTime,templateId) ;
				if (null !=mrList && mrList.size() > 0) {
					//如果大于0,取第一个
					mr = mrList.get(0);
				}else{
					if(null==mrList ){
						log.info("mrList is null");
						rsMess ="MR_LIST_IS_NULL" ;
					}else{
						log.info("mrList is empty");
						rsMess ="MR_LIST_IS_EMPTY" ;
					}
				}
			}
			ArchiveFile file = new ArchiveFile();
			if(null==mr){
				log.debug("mr == null ,病程记录不存在,则返回该类型病历模板的xml数据,templateId="+templateId);
				//如果病程记录不存在，则返回该类型病历模板的xml数据
				MrTpl mrTemplate = mrTplDao.selectById(templateId) ;
				file.setMrPk(null);
				if(null == mrTemplate){
					//如果病历不存在，则返回异常
					log.info("mrTemplate is null,templateId="+templateId);
					return null ;
				}else{
					FileObject fileObject = fileService.getFile(mrTemplate.getXmlFilePk());
					file.setMrPk(null);
					try {
						file.setXmlFileData(new String(fileObject.asByteArray(),"UTF-8"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}else{
				log.debug("返回病历数据，包括xml数据");
				//返回病历数据，包括xml数据
				FileObject fileObject = fileService.getFile(mr.getXmlFilePk());
				file.setMrPk(mr.getMrPk());
				try {
					file.setXmlFileData(new String(fileObject.asByteArray(),"UTF-8"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				file.setNm(mr.getNm());
				file.setMrSatusCode(mr.getMrStaCd());
				file.setCreatorName(IihUtils.userIdToName(dataObjectService, mr.getCrtUserId()));
				file.setCreateDateTime(mr.getCrtTime() != null ? df.format(mr.getCrtTime()) : "");
				file.setLastModifyDateTime(mr.getLastUpdTime() != null ? df.format(mr.getLastUpdTime()) : "");
				file.setSignPaperDatetime(mr.getSubmitDate() != null ? df.format(mr.getSubmitDate()) : "");
				file.setCreateDisplayDateTime(mr.getCrtTime() != null ? df.format(mr.getCrtTime()) : "");
				if (MrSignLevel.LEVEL_ONE_SIGN.equals(mr.getSignLvlCd())
						|| MrSignLevel.NEED_NOT_SIGN.equals(mr.getSignLvlCd())) {// 1级
					file.setFileFlag("1");
				} else if (MrSignLevel.LEVEL_TWO_SIGN.equals(mr.getSignLvlCd())) {// 2级
					file.setFileFlag("2");
				} else if (MrSignLevel.LEVEL_THREE_SIGN.equals(mr.getSignLvlCd())) {// 3级申签
					file.setFileFlag("3");
				} else {
					file.setFileFlag("T");
				}
				file.setnRate(null);// 完成比率
			}
			
			if (file != null ) {
				Document doc = null;
				String xmlStr = "<?xml version='1.0' encoding='UTF-8'?><mrList></mrList>";
				doc = IihUtils.xmlConvertDom(xmlStr);
				List<ArchiveFile> files = new ArrayList<ArchiveFile>();
				files.add(file);
				assembleNodes(files, doc);
				try {
					String rs =  docString(doc);
					String temId = templateId ;if(null==templateId){temId ="";} ;
					rs = rs.replace("<mrList>", "<mrList>\n<enc_id>"+ enPk+"</enc_id>\n<templateId>"+temId+"</templateId>");
					return rs ;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else{
			log.info("enc_id is blank");
			rsMess ="ENC_ID_IS_BLANK" ;
		}
		return rsMess;
	}

	@Override
	public String saveMrXml(String enPk,String pa_id,String times, String ctrTime, String templateId,
			String mrPk, String xmlData, String empId) {
		// TODO Auto-generated method stub
		String rsMess = "success" ;
		if (!StringUtils.isBlank(enPk)) {
			Mr mr = null ;
			if(StringUtils.isNotBlank(mrPk)&&!"\"\"".equalsIgnoreCase(mrPk)){
				//mrPk 病历记录的主键不为空，直接获取
				log.debug("mrPk="+mrPk);
				mr = mrDao.selectById(mrPk);
			}else{
				//根据enPk,创建时间，病历类型来获得未删除的病历列表
				log.debug("enPk:"+enPk+"|ctrTime:"+ctrTime+"|templateId:"+templateId);
				List<Mr> mrList = cusmrDao.selectMrsByConds(enPk,ctrTime,templateId) ;
				if (mrList.size() > 0) {
					//如果大于0,取第一个
					mr = mrList.get(0);
				}else{
					if(null==mrList ){
						log.info("mrList is null");
						rsMess ="MR_LIST_IS_NULL" ;
					}else{
						log.info("mrList is empty");
						rsMess ="MR_LIST_IS_EMPTY" ;
					}
				}
			}

			if(!setSession(empId)){
				log.info("登陆失败，empId:"+empId);
				rsMess ="{\"success\":\"false\",\"message\":\"NO_EMPLOYEE\",\"mrPk\":\"\"}" ;
				return rsMess;
			}else{
				log.debug("登陆成功，empId:"+empId);
			}
	        //String deptId = ss.get(Session.SESSION_DEPT_ID_KEY, String.class);
			log.debug("xmlData");
			log.debug(xmlData);
			if(null==mr){
				//如果不存在病程记录,新建病程记录，并保存
				log.debug("mr == null ,病程记录不存在,新建病历,templateId="+templateId);
				
				MrTpl mrTpl = mrTplDao.selectById(templateId) ;
			
				Mr mrNew = new Mr();
/*				Session session = Session.get();
				session*/
				FileObject xmlFileObject = fileService.createFile("biz", xmlData.getBytes());
				mrNew.setXmlFilePk(xmlFileObject.getId());
				java.sql.Timestamp bizTime = java.sql.Timestamp.valueOf( ctrTime);
				mrNew.setBizTime(bizTime);
				mrNew.setCrtUserId(empId);
				if(null != mrTpl){
					mrNew.setMrTpCd(mrTpl.getMrTpCd());
					mrNew.setSignLvlCd(mrTpl.getMrSignLvlCd());
					mrNew.setNm(mrTpl.getNm());
				}
				mrNew.setEncounterSn(enPk);
				mrNew.setMrStaCd(MrStatus.CREATED);
				mrNew.setEnPk(enPk);
				mrNew.setMrPk(UUIDGenerator.getUUID());
				mrNew.setMrTplCd(templateId);
				mrNew.setMrSource(MrSource.XML);
				mrDao.insert(mrNew) ;
				rsMess ="{\"success\":\"true\",\"message\":\"create_success\",\"mrPk\":\""+mrNew.getMrPk()+"\"}" ;
				log.debug("new mrPk is "+ mrNew.getMrPk()+"|xml_file_pk is "+ mrNew.getXmlFilePk());
			}else{
				//如果
				FileObject xmlFileObject = fileService.updateFile(mr.getXmlFilePk(), xmlData.getBytes());
				mr.setXmlFilePk(xmlFileObject.getId());
				java.sql.Timestamp bizTime = java.sql.Timestamp.valueOf( ctrTime);
				mr.setBizTime(bizTime);
				mr.setMrSource(MrSource.XML);
				//mr.setUpdCnt(mr.getUpdCnt().add(BigInteger.valueOf(1l))) ;
				mrDao.updateExcludeNull(mr) ;
				rsMess ="{\"success\":\"true\",\"message\":\"update_success\",\"mrPk\":\""+mr.getMrPk()+"\"}" ;
				log.debug("更新病历数据,mrPk is "+ mr.getMrPk()+"|XmlFilePk is " + mr.getXmlFilePk());
			}
			
		}else{
			log.info("enc_id is blank");
			rsMess ="{\"success\":\"false\",\"message\":\"ENC_ID_IS_BLANK\",\"mrPk\":\"\"}" ;
			//rsMess ="ENC_ID_IS_BLANK" ;
		}
		return rsMess;
	}

	private boolean setSession(String empId) {
		// TODO Auto-generated method stub
		Map params = new HashMap();
		params.put("empId", empId);
		log.debug("empId:"+empId);
		ArrayResult<User> userList = userService.search(params);
		User user = null ;
		if(null == userList ){
			log.info("userList is null");
			return false ;
		}else if( null == userList.getDataList()){
			log.info("userList.getDataList is null");
			return false ;
		}else if( userList.getDataList().length == 0){
			log.info("userList.getDataList().length == 0");
			return false ;
		}else{
			User[] userArr = userList.getDataList();
			user = userArr[0];
		}
		log.debug("login_nm="+user.getLoginName()+"|pass="+user.getPassword());
        Subject currentUser = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginName(),user.getPassword(), false,"127.0.0.1");
		currentUser.login(token);
        ScopeManager scopeMgr = Application.getInstance().getBundleContext().getServiceOfType(
                ScopeManager.class);
        SessionScope ss = scopeMgr.getScope(SessionScope.class);
        ss.put(Session.SESSION_USER_ID_KEY, empId);
       ss.put(Session.SESSION_USER_NAME_KEY, user.getName());
       return true;
	}

	@Override
	public String deleteMr(String mrPk, String empId) {
		if (StringUtils.isBlank(mrPk)) {
			log.info("mrPk is blank");
			return "NO_MRPK";
		}else{
			log.debug("mrPk is ："+mrPk);
		}
		if (StringUtils.isBlank(empId)) {
			log.info("empId is blank");
			return "NO_EMPID";
		}else{
			log.debug("empId is ："+empId);
		}
		if(!setSession(empId)){
			log.info("NOT FIND EMP");
			return "NOT_FIND_EMP";
		}
		Mr mrToDelete = mrDao.selectById(mrPk);
		if(null == mrToDelete){
			log.info("null == mrToDelete,mrPk="+mrPk);
			return "NOT_FIND_MR";
		}
		mrToDelete.setDelF(Short.valueOf("1"));
		mrDao.markDelete(mrToDelete);
		return "success";
	}

	
	@Override
	public List<Map<String, Object>> getMrByEnPkAndMrType(String enPk, String mrTpCd){
	    return cusmrDao.selectMrsByEnPkAndMrType(enPk, mrTpCd);
	}
	
	@Override
	public List<Map<String, Object>> getMrTypeByOrType(String orTpCd){
	    return cusMdMrOrDao.selectMrTpByOrTp(orTpCd);
	}

	@Override
	public String mrOrigFileList(String patientId, Integer times,String visitFlag) {
		String name="";
		if(visitFlag.equalsIgnoreCase("MZ")){
			visitFlag=EncounterType.OUTPATIENT;
			name="门诊";
		}else if(visitFlag.equalsIgnoreCase("ZY")){
			visitFlag=EncounterType.INPATIENT;
			name="住院";
		}else if(visitFlag.equalsIgnoreCase("TJ")){
			visitFlag=EncounterType.PHYSICAL_EXAMINATION;
			name="体检";
		}
		Element element=createElement("FileList",null);
		if(!StringUtils.isBlank(patientId)&&times!=null){
			MrAmr amr=cusMrAmrDao.selectByPaIdAndEnCntAndVisitFlag(patientId, times, visitFlag);
			if(amr!=null){
				List<Mr> mrs=cusmrDao.selectMrsByEnPkAndDel(amr.getEnPk());
				if(mrs!=null&&mrs.size()>0){
					element.setAttribute("total", mrs.size()+"");
					element.addContent(createElement("patId",amr.getPaId()));
					element.addContent(createElement("patName",amr.getPaNm()));
					element.addContent(createElement("inOrOut",name));
					for (Mr mr : mrs) {
						Element fElement=createElement("File",null);
						fElement.addContent(createElement("code",mr.getMrPk()));
						fElement.addContent(createElement("fileName","EMR_"+mr.getMrPk()));
						fElement.addContent(createElement("name",mr.getNm()));
						fElement.addContent(createElement("arcYN",mr.getArcF()!=null&&mr.getArcF().equals("1")?"Y":"N"));
						fElement.addContent(createElement("repTime",mr.getArcTime()==null?"":mr.getArcTime()+""));
						fElement.addContent(createElement("desc",""));
						element.addContent(fElement);
					}
				}
			}
			XMLOutputter outputter = new XMLOutputter(); 
			return outputter.outputString(element);
		}
		return null;
	} 
	private static Element createElement(String eName,String value){
		Element element=new Element(eName);
		if(value!=null)
		element.addContent(value);
		return element;
	}

	@Override
	public String getMrListByPaIdAndEnCnt(String paId, String ent, Boolean pdfFlag, Boolean odtFlag) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		MrAmr mrAmr= cusMrAmrDao.selectByPaIdAndEnCntAndVisitFlag(paId, Integer.valueOf(ent), null);
		if(mrAmr!=null){
			List<Mr> mrs = cusmrDao.selectMrsByEnPkAndDel(mrAmr.getEnPk());
			if (mrs.size() > 0) {
				List<ArchiveFile> files = new ArrayList<ArchiveFile>();
				for (Mr mr : mrs) {
					ArchiveFile file = new ArchiveFile();
					file.setMrPk(mr.getMrPk());
					FileObject fileObject = fileService.getFile(mr.getFilePk());
					FileObject pdfFileObject;
					try {
						if (!StringUtils.isBlank(mr.getCaFilePk())) {
							pdfFileObject = fileService.getFile(mr.getCaFilePk());
							file.setPdfBase64(new String(pdfFileObject.asByteArray()));
						}
						file.setOdtBase64(new String(fileObject.asByteArray()));
					} catch (IOException e) {
						e.printStackTrace();
					}
					file.setNm(mr.getNm());
					file.setMrSatusCode(mr.getMrStaCd());
					file.setCreatorName(IihUtils.userIdToName(dataObjectService, mr.getCrtUserId()));
					file.setCreateDateTime(mr.getCrtTime() != null ? df.format(mr.getCrtTime()) : "");
					file.setLastModifyDateTime(mr.getLastUpdTime() != null ? df.format(mr.getLastUpdTime()) : "");
					file.setSignPaperDatetime(mr.getSubmitDate() != null ? df.format(mr.getSubmitDate()) : "");
					file.setCreateDisplayDateTime(mr.getCrtTime() != null ? df.format(mr.getCrtTime()) : "");
					if (MrSignLevel.LEVEL_ONE_SIGN.equals(mr.getSignLvlCd())
							|| MrSignLevel.NEED_NOT_SIGN.equals(mr.getSignLvlCd())) {// 1级
						file.setFileFlag("1");
					} else if (MrSignLevel.LEVEL_TWO_SIGN.equals(mr.getSignLvlCd())) {// 2级
						file.setFileFlag("2");
					} else if (MrSignLevel.LEVEL_THREE_SIGN.equals(mr.getSignLvlCd())) {// 3级申签
						file.setFileFlag("3");
					} else {
						file.setFileFlag("T");
					}
					file.setnRate(null);// 完成比率
					files.add(file);
				}
				/*
				 * String odtPath=filePath+"/odt.odt"; String
				 * pdfPath=filePath+"/pdf.pdf";
				 */
				if (files != null) {
					String xmlString = getXmlString(files, null, null, null, null, pdfFlag, odtFlag);
					return xmlString;
				}
			}
		}
		return null;
	}

	@Override
	public String selectMrAreas(String paId, String encounterCount, String typeCodes, String names) throws IOException {
		if (!StringUtils.isBlank(paId) && !StringUtils.isBlank(encounterCount) && !StringUtils.isBlank(typeCodes)) {
			List<String> types=new ArrayList<String>();
			String[] ts=typeCodes.split(",");
			if(ts!=null&&ts.length>0){
				for (String string : ts) {
					if(!StringUtils.isBlank(string))
						types.add(string);
				}
			}
			Map<String, Object> map = mrFileDao.selectBizFileIsXml(paId, encounterCount, types);
			if (map != null) {
				String key = map.keySet().iterator().next();
				String filePk = map.get(key).toString();
				FileObject xmlFileObject = fileService.getFile(filePk);
				if(!StringUtils.isBlank(names)){
					String[] strs=names.split(",");
					Element fElement=createElement("areaList",null);
					for (String nm : strs) {
						Element element=createElement("areaNm",null);
						element.addContent(createElement("nm",nm));
						String result = IihUtils.xmlStringReader(new String(xmlFileObject.asByteArray(), "UTF-8"),
								nm,0);
						element.addContent(createElement("content",result));
						fElement.addContent(element);
					}
					XMLOutputter outputter = new XMLOutputter(); 
					return outputter.outputString(fElement);
				}else{
					Element element=createElement("areaNm",null);
					element.addContent(createElement("nm","病历纯文本内容"));
					String result = IihUtils.xmlStringReader(new String(xmlFileObject.asByteArray(), "UTF-8"),null,0);
					element.addContent(createElement("content",result));
					XMLOutputter outputter = new XMLOutputter(); 
					return outputter.outputString(element);
				}
				
			}
		}
		return null;
	}
}
