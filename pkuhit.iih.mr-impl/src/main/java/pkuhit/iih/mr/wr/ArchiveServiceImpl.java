package pkuhit.iih.mr.wr;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.xml.namespace.QName;

import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.jdbc.SelectOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.mr.dao.auto.MrAmrDao;
import pkuhit.iih.mr.dao.auto.MrDao;
import pkuhit.iih.mr.dao.auto.entity.Mr;
import pkuhit.iih.mr.dao.auto.entity.MrAmr;
import pkuhit.iih.mr.pub.MessageCode;
import pkuhit.iih.mr.wr.dao.CusMrAmrDao;
import pkuhit.iih.mr.wr.dao.CusMrDao;
import pkuhit.iih.pub.IihUtils;
import pkuhit.md.DictionaryService;
import pkuhit.md.SysFunctionCode;
import pkuhit.me.DataObjectService;
import pkuhit.utils.OdtTurnPdfUtil;
import pkuhit.xap.ac.Session;
import pkuhit.xap.file.FileObject;
import pkuhit.xap.file.FileService;
import pkuhit.xap.pm.Param;
import pkuhit.xap.pm.ParamsService;
import pkuhit.xap.pm.ParamsSetService;
import pkuhit.xap.util.BeanCopyUtil;
import sun.misc.BASE64Decoder;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.notification.Notification;
import xap.sv.notification.exception.NotificationException;

import com.founder.webservice.EmrArchiveService;
import com.founder.webservice.EmrArchiveServicePortType;

public class ArchiveServiceImpl implements ArchiveService {
	private static Logger log = LoggerFactory.getLogger(ArchiveServiceImpl.class);
	@Reference
	ParamsService paramsService;
	@Reference
	FileService fileService;
	@Autowired
	CusMrAmrDao cusMrAmrDao;
	@Autowired
	CusMrDao cusMrDao;
	@Autowired
	MrDao mrDao;
	@Autowired
	MrAmrDao mrAmrDao;
	@Reference
	DataObjectService dataObjectService;
	@Reference
	DictionaryService dictionaryService;
	@Reference
	ParamsSetService paramsSetService;
	
	@Override
	public ArrayResult<ArchiveFile> mrArchive(MedicalRecordList ms) {
		return archiveFile(ms);
	}
	public String getUrl(){
    	Param[] params=paramsService.getParam(SysFunctionCode.EMR_WRITER_FILE_PATH).getDataList();
    	String filePath=null;
    	for (Param param : params) {
			if(param.getKey().equals("EMR_WEBSERVICE_URL"))
			{
				filePath=param.getValue();
			}
		}
    	return filePath;
    }
	private ArrayResult<ArchiveFile> archiveFile(MedicalRecordList ms) {
		Param[] params=paramsService.getParam(SysFunctionCode.EMR_WRITER_FILE_PATH).getDataList();
		String officePath=null;
		String webServiceUrl=null;
		if(params.length>0){
			for (Param param : params) {
				if(param.getKey().equals("EMR_WRITER_HOME"))
				{
					officePath=param.getValue();
				}
				if(param.getKey().equals("EMR_WEBSERVICE_URL")){
					{
						webServiceUrl=param.getValue();
					}
				}
			}
		} 
		if(webServiceUrl==null){
			Notification notification = new Notification(MessageCode.MR_ARCHIVE_UPLOAD_CONFIG);
			throw new NotificationException(notification);
		}
		if(StringUtils.isBlank(officePath)){
			String str="";
			if(StringUtils.isBlank(officePath)){
				str="电子病历编辑器安装目录";
			}
			
			Notification notification = new Notification(MessageCode.MR_ARCHIVE_UPLOAD_CONFIG_ERROR,str);
			throw new NotificationException(notification);
		}
		String filePath=officePath+"/convert";
		String odtPath=filePath+"/odt.odt";
		String pdfPath=filePath+"/pdf.pdf";
		ArrayResultBuilder<ArchiveFile> builder = ArrayResultBuilder.newArrayResult(ArchiveFile.class);
		List<ArchiveFile> files=new ArrayList<ArchiveFile>();
		List<MedicalRecord> medicalRecords=ms.getList();
		MrAmr mrAmr=null;
		Session session = Session.get();
		String userId = session.getUserId();
		if(medicalRecords.size()>0){
			short reg=1;
			for (MedicalRecord medicalRecord :medicalRecords) {
				Mr mr=mrDao.selectById(medicalRecord.getMrPk());
				if(null==mrAmr){
					mrAmr=mrAmrDao.selectById(mr.getEnPk());
				}
				ArchiveFile afile=new ArchiveFile();
				afile.setEnPk(mr.getEnPk());
				afile.setEmpSn(userId);
				afile.setPatientId(mrAmr.getPaId());
				afile.setMrPk(mr.getMrPk());
				FileObject fileObject=fileService.getFile(mr.getFilePk());
				FileObject pdfObject=null;
				if(mr.getCaFilePk()!=null){
					pdfObject=fileService.getFile(mr.getCaFilePk());
				}
//				String odtBase64=cusMrAmrDao.selectFileCode();
				try {
					byte[] odtbuffer = new BASE64Decoder().decodeBuffer(new String(fileObject.asByteArray()));
					afile.setOdtBuffer(odtbuffer);
					if(pdfObject!=null&&pdfObject.asByteArray().length>0){
						byte[] pdfbuffer = new BASE64Decoder().decodeBuffer(new String(pdfObject.asByteArray()));
						afile.setPdfBuffer(pdfbuffer);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				afile.setSysCode("EMR_"+mr.getMrPk());
				afile.setTimes(mrAmr.getEnCnt().toString());
				afile.setDocType(mr.getMrTpCd());
				afile.setVisitFlag("ZY");
				if(mr.getArcF()==null||mr.getArcF()!=reg){	//已归档的不再归档				
					files.add(afile);
				}
				
			}
		}
		if(files.size()<1){
			//没有要归档的数据
			ArrayResult<ArchiveFile> arrayResult=null;
			ArrayResultBuilder<ArchiveFile> bd = ArrayResultBuilder.newArrayResult(ArchiveFile.class);
			bd.withData(new ArchiveFile[0]);
			arrayResult=bd.build();
			return arrayResult;
		}else{
			try {
				File uploadPath = new File(filePath);
				if (!uploadPath.exists()) {
					uploadPath.mkdir();
				}
				files=OdtTurnPdfUtil.getPdfBytes(officePath, odtPath, pdfPath, files);
			} catch (IOException e) {
				log.error("进行处理文件程序出错，请联系工程师！！！");
				e.printStackTrace();
			}
			
			if(files!=null&&files.size()>0){
				URL baseUrl;
	            baseUrl = com.founder.webservice.EmrArchiveService.class.getResource(".");
	            URL url = null;
				try {
					url = new URL(baseUrl,webServiceUrl);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				for (ArchiveFile archive: files) {
					EmrArchiveService service=new EmrArchiveService(url,new QName("http://webservice.founder.com","EmrArchiveService"));
					EmrArchiveServicePortType es=service.getEmrArchiveServiceHttpSoap11Endpoint();			//"000733169200","1"
					String result= "1";
					try {
						result=es.arcUPFile(archive.getPdfBuffer(), archive.getSysCode(), archive.getEmpSn(),archive.getPatientId(),archive.getTimes(), archive.getDocType(), archive.getVisitFlag());					
					} catch (Exception e) {
						Notification notification = new Notification(MessageCode.MR_ARCHIVE_UPLOAD_FILE_ERROR);
						throw new NotificationException(notification);
					}
					//根据返回结果修改数据库
					Mr mr= mrDao.selectById(archive.getMrPk());
					if(result.equals("0")){
						short arcF=1;//归档成功
						mr.setArcF(arcF);
						mr.setMrPk(archive.getMrPk());
						mr.setArcTime(new Timestamp(new Date().getTime()));
						mrDao.updateExcludeNull(mr);
					}else{
						log.error("该病例归档失败！错误原因"+result);
						short arcF=0;//归档失败
						mr.setArcF(arcF);
						mr.setMrPk(archive.getMrPk());
						mr.setArcTime(new Timestamp(new Date().getTime()));
						mrDao.update(mr);
					}
					archive.setOdtBase64(null);
					archive.setOdtBuffer(null);
					archive.setPdfBase64(null);
					archive.setPdfBuffer(null);
					archive.setResult(result);
					//归档完成验证患者的所有出院病历是否都已归档
					
					SelectOptions options = SelectOptions.get().offset(0).limit(10000).count();	
					List<String> mrTypeCodes=null;
					if(params.length>0){//获取需要归档类型
						for (Param parameter : params) {
							if(parameter.getKey().equals("TYPE_ARCHIVE_PARAM"))
							{
								mrTypeCodes=Arrays.asList(parameter.getValue().split(","));
							}
						}
					}
					List<Mr> mrs= cusMrDao.selectMrsByEnPk(mrAmr.getEnPk(),mrTypeCodes,options);
					if(mrs.size()==0){
						mrAmr.setArcF(Amr.ARC_F);
						mrAmrDao.update(mrAmr);
					}
				}
			}//medrs.toArray(new MedicalRecord[0])
			builder.withData(files.toArray(new ArchiveFile[0]));
			return builder.build();
		}
	}
	@Override
	public ArrayResult<ArchiveFile> amrArchive(String enPk) {
		SelectOptions options = SelectOptions.get().offset(0).limit(10000).count();	
		Param[] params=paramsService.getParam(SysFunctionCode.EMR_WRITER_FILE_PATH).getDataList();
		List<String> mrTypeCodes=null;
		if(params.length>0){//获取需要归档类型
			for (Param parameter : params) {
				if(parameter.getKey().equals("TYPE_ARCHIVE_PARAM"))
				{
					mrTypeCodes=Arrays.asList(parameter.getValue().split(","));
					break;
				}
			}
		}
		if(mrTypeCodes==null){
			Notification notification = new Notification(MessageCode.ARCHIVE_TYPE_PARAM_CONFIG);//请设置归档类型参数！
			throw new NotificationException(notification);
		}
		List<Mr> mrs= cusMrDao.selectMrsByEnPk(enPk,mrTypeCodes,options);
		List<MedicalRecord>  medrs=new ArrayList<MedicalRecord>();
		if(mrs!=null&&mrs.size()>0){
			for (Mr mr : mrs) {
				MedicalRecord medr = new MedicalRecord();
				BeanCopyUtil.entityToModel(medr, mr, MedicalRecord.OBJ_CD, dictionaryService);
				medr.setCreateUserName(IihUtils.userIdToName(dataObjectService, mr.getCrtUserId()));
				medrs.add(medr);
				
			}
			if(medrs!=null&&medrs.size()>0){
				MedicalRecordList ms=new MedicalRecordList();
				ms.setList(medrs);
				ArrayResult<ArchiveFile> list= archiveFile(ms);
				return list;
			}
		}
		ArrayResult<ArchiveFile> arrayResult=null;
		ArrayResultBuilder<ArchiveFile> builder = ArrayResultBuilder.newArrayResult(ArchiveFile.class);
		builder.withData(new ArchiveFile[0]);
		arrayResult=builder.build();
		return arrayResult;
	}
	@Override
	public SingleResult<ArchiveFile> amrListArchive(String enPks) {
		String[] eps=enPks.split(",");
		SingleResult<ArchiveFile> result=new SingleResult<ArchiveFile>();
		ArchiveFile af=new ArchiveFile();
		if(eps.length>0){
			int count=0;
			for (String enPk : eps) {
				ArrayResult<ArchiveFile> archiveFiles= this.amrArchive(enPk);
				ArchiveFile[] afs= archiveFiles.getDataList();
				for (ArchiveFile archiveFile : afs) {
					if(!archiveFile.getResult().equals("0")){
						count++;
						break;
					}
				}
			}
			af.setResultCount(count);
			result.setData(af);//返回失败的患者总数
		}
		return result;
	}
	
	/**
	 * 实现定时归档
	 * 出院、质控流程完的患者
	 */
	public void takeAmrListArchive() {
		String nurArchiveCheck=paramsSetService.searchFunFlagByKey("NUR_ARCHIVE_CHECK").getData();
		if(!StringUtils.isBlank(nurArchiveCheck)&&nurArchiveCheck.equals("1")){
			SelectOptions options = SelectOptions.get().offset((Integer.valueOf(1)-1)*Integer.valueOf(1000)).limit(Integer.valueOf(1000)).count();
			List<MrAmr> mrAmrs=cusMrAmrDao.selectParientAll(null, null, null, null, null, 1, 0,nurArchiveCheck, options);
			if(mrAmrs!=null&&mrAmrs.size()>0){
				int count=0;
				for (MrAmr mrAmr : mrAmrs) {
					ArrayResult<ArchiveFile> archiveFiles= this.amrArchive(mrAmr.getEnPk());
					ArchiveFile[] afs= archiveFiles.getDataList();
					for (ArchiveFile archiveFile : afs) {
						if(!archiveFile.getResult().equals("0")){
							count++;
							break;
						}
					}
				}
				log.debug(count+"个患者病历,自动归档上传到病案管理系统失败！-时间");
			}
		}
	}
}
