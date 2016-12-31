package iih.dr.service.impl;

import iih.dr.dao.auto.IemrRetrievalResultDao;
import iih.dr.dao.auto.entity.IemrRetrievalResult;
import iih.dr.dao.custom.CusRetrievalCondDao;
import iih.dr.dao.custom.CusRetrievalDao;
import iih.dr.dao.custom.CusRetrievalResultDao;
import iih.dr.model.AmrRetrievalModel;
import iih.dr.service.intf.TaskDataRetrievalService;
import iih.dr.util.AnalyticXmlUtil;

import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import xap.util.UUIDGenerator;

/**
 * TaskDataRetrievalServiceImpl
 * 
 * @author cheng_feng
 * @version 0.0.0
 */
public class TaskDataRetrievalServiceImpl implements TaskDataRetrievalService {
	
	IemrRetrievalResultDao iemrRetrievalResultDao; 
	
	@Autowired
	CusRetrievalCondDao cusRetrievalCondDao; 
	
	@Autowired
	CusRetrievalDao cusRetrievalDao; 
	
	@Autowired
	CusRetrievalResultDao cusRetrievalResultDao; 
	
	@Autowired
	public void setIemrRetrievalResultDao(IemrRetrievalResultDao iemrRetrievalResultDao) {
		this.iemrRetrievalResultDao = iemrRetrievalResultDao;
	}
	
	/*
	 * 根据检索方案查询出符合条件的患者及其病案
	 */
	@Override
	public String searchRetrieval() {
		//获取病案结果表中最后的更新时间
		Map<String, Object> lastUpdTimeMap = cusRetrievalResultDao.selectResultLastUpdTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		Date lastUpdTime = null;
		try {
			lastUpdTime = lastUpdTimeMap.get("LAST_UPD_TIME")==null?null:sdf.parse(lastUpdTimeMap.get("LAST_UPD_TIME").toString());
			//1.查询出修改过的检索方案，重新生成检索结果
			getUpdRetrieval(lastUpdTime);
			//2.查询出新增的病案，查询出所有的检索方案
			List<AmrRetrievalModel> amrRetrievalList = getAmrRetrieval(lastUpdTime, "newNull");
			
			//检索出未更改的检索方案
			List<Map<String, Object>> retrievalList = cusRetrievalDao.selectRetrievalByCondition("", "", "", "", "", "", lastUpdTime);
			//生成方案结果集
			if(null!=amrRetrievalList && amrRetrievalList.size()>0){
				AmrRetrievalModel amrRetrievalN = new AmrRetrievalModel();
				for(int j=0;j<amrRetrievalList.size();j++){
					amrRetrievalN = amrRetrievalList.get(j);
					getRetrievalCond(amrRetrievalN.getXmlStr(), amrRetrievalN.getEnPk(), amrRetrievalN.getMrPk(), retrievalList);
				}
			}
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		return "";
	}
	
	private void getUpdRetrieval(Date lastUpdTime){
		String retrievalCd = "";
		String xmlFilePkCond = "";
		List<Map<String, Object>> retrievalList = cusRetrievalDao.selectRetrievalByCondition("", "", "", "", "", "", lastUpdTime);//新增、修改的方案
		if(null!=retrievalList){
			if(retrievalList.size()>0){
				for(int i = 0; i < retrievalList.size(); i++ ){
					retrievalCd  = retrievalList.get(i).get("RETRIEVAL_CD").toString();
					xmlFilePkCond  = retrievalList.get(i).get("OBJ_CODE").toString();//病历模板编码：MR_TPL.XML_FILE_PK
					//1.删除查询结果数据
					delRetrievalResult(retrievalCd);
					//2.重新生成结果
					//2.1查询出所有使用该模板书写的病历文书，以及设置的检索条件
					List<AmrRetrievalModel> amrRetrievalList = getAmrRetrieval(null, xmlFilePkCond);
					//2.2生成方案结果集
					if(null!=amrRetrievalList && amrRetrievalList.size()>0){
						AmrRetrievalModel amrRetrievalO = new AmrRetrievalModel();
						for(int j=0;j<amrRetrievalList.size();j++){
							amrRetrievalO = amrRetrievalList.get(j);
							getRetrievalCond(amrRetrievalO.getXmlStr(), amrRetrievalO.getEnPk(), amrRetrievalO.getMrPk(), retrievalList);
						}
					}
				}
			}
		}
	}
	
	private void delRetrievalResult(String retrievalCd){
		//删除以前生成的检索结果
		List<Map<String, Object>> resultList =cusRetrievalResultDao.selectResultByRetrievalCd(retrievalCd);
		if(null!=resultList){
			if(resultList.size()>0){
				String resultCd = "";
				for(int i=0;i<resultList.size();i++){
					resultCd =  resultList.get(i).get("RESULT_CD").toString();
					IemrRetrievalResult result= cusRetrievalResultDao.selectByResultCd(resultCd);
					result.setDelF((short)1);
					iemrRetrievalResultDao.markDelete(result);
				}
			}
		}
	}
	
	private List<AmrRetrievalModel> getAmrRetrieval(Date lastUpdTime, String xmlFilePkCond){
		String enPk="", mrPk="", xmlStr="",xmlFilePk="";
		Clob xmlClob=null;
		List<AmrRetrievalModel>  amrRetrievalList = new ArrayList<AmrRetrievalModel>();
		List<Map<String, Object>> amrList =cusRetrievalResultDao.selectRetrievalAmrByCondition(lastUpdTime);
		if(null!=amrList && amrList.size()>0){
			Reader inStream=null;
			for(int m=0;m<amrList.size();m++){
				enPk = amrList.get(m).get("EN_PK").toString();
				mrPk = amrList.get(m).get("MR_PK").toString();
				xmlFilePk = amrList.get(m).get("MR_TPL_CD").toString();
				if(!"newNull".equals(xmlFilePkCond)){
					if(!xmlFilePk.equals(xmlFilePkCond)){
						return null;
					}
				}
				xmlClob = (Clob) amrList.get(m).get("FILE_DATA");
				try {
					inStream = xmlClob.getCharacterStream();
					char[] c = new char[(int) xmlClob.length()];
					inStream.read(c);
					xmlStr = new String(c);
					xmlStr.replaceAll("[\\x00-\\x08\\x0b-\\x0c\\x0e-\\x1f]", "");
					xmlStr.replaceAll("\\?\\?\\? ", "");
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						inStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				AmrRetrievalModel amrRetrieval = new AmrRetrievalModel();
				amrRetrieval.setEnPk(enPk);
				amrRetrieval.setMrPk(mrPk);
				amrRetrieval.setXmlStr(xmlStr);
				amrRetrievalList.add(amrRetrieval);
			}
		}
		return amrRetrievalList;
	}
	
	private void getRetrievalCond(String xmlStr, String enPk, String mrPk, List<Map<String, Object>> retrievalList){
		String retrievalCd = "";
		if(null!=retrievalList){
			if(retrievalList.size()>0){
				for(int i = 0; i < retrievalList.size(); i++ ){
					retrievalCd  = retrievalList.get(i).get("RETRIEVAL_CD").toString();
					//根据检索方案检索出对应的检索条件
					List<Map<String, Object>> retrievalCondList = cusRetrievalCondDao.selectRetrievalCondByRetrievalcd(retrievalCd, "", "");
					addRetrievalCondText(xmlStr, retrievalCd, enPk, mrPk, retrievalCondList);
				}
			}
		}
	}
	
	private void addRetrievalCondText(String xmlStr, String retrievalCd, String enPk, String mrPk, List<Map<String, Object>> retrievalCondList){
		//查询出检索条件，查询出内容存到数据库
		if(null!=retrievalCondList){
			for(int i=0;i<retrievalCondList.size();i++){
				String condCd = retrievalCondList.get(i).get("COND_CD").toString();
				String condNm = retrievalCondList.get(i).get("COND_NAME").toString();
				String fullPath = retrievalCondList.get(i).get("FULL_PATH").toString();
				String contentText="";
				try {
					contentText = AnalyticXmlUtil.getElementTextByXpath(xmlStr, fullPath);
				} catch (Exception e) {
					System.out.println(mrPk);
					System.out.println(fullPath);
					System.out.println(xmlStr);
					e.printStackTrace();
				}
				if(!StringUtils.isEmpty(contentText)){
					String retrievalResultCd = UUIDGenerator.getUUID();
					IemrRetrievalResult retrievalResult = new IemrRetrievalResult();
					retrievalResult.setResultCd(retrievalResultCd);
					retrievalResult.setRetrievalCd(retrievalCd);
					retrievalResult.setEnPk(enPk);
					retrievalResult.setMrPk(mrPk);
					retrievalResult.setCondCd(condCd);
					retrievalResult.setCondName(condNm);
					retrievalResult.setCondText(contentText);
					iemrRetrievalResultDao.insertExludeNull(retrievalResult);
				}
			}
		}
	}
	
}
