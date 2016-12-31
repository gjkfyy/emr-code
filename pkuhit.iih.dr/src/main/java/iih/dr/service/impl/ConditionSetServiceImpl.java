package iih.dr.service.impl;

import iih.dr.dao.auto.IemrRetrievalCondDao;
import iih.dr.dao.auto.IemrRetrievalDao;
import iih.dr.dao.auto.entity.IemrRetrieval;
import iih.dr.dao.auto.entity.IemrRetrievalCond;
import iih.dr.dao.custom.CusRetrievalCondDao;
import iih.dr.dao.custom.CusRetrievalDao;
import iih.dr.dao.custom.CusRetrievalResultDao;
import iih.dr.model.BaseTemplateModel;
import iih.dr.model.IemrRetrievalCondModel;
import iih.dr.model.IemrRetrievalModel;
import iih.dr.model.MrDocTreeBean;
import iih.dr.model.PatientRetrievalModel;
import iih.dr.service.intf.ConditionSetService;
import iih.dr.service.intf.DataRetrievalService;
import iih.dr.service.intf.TaskDataRetrievalService;
import iih.dr.util.AnalyticXmlUtil;

import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.md.DictionaryService;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import xap.sv.model.TreeBuilder;
import xap.sv.model.TreeNode;
import xap.sv.model.TreeResult;
import xap.util.UUIDGenerator;

/**
 * ConditionSetServiceImpl
 * 
 * @author cheng_feng
 * @version 0.0.0
 */
public class ConditionSetServiceImpl implements ConditionSetService {
	
	final String NULL_STRING = "null";
	final static Logger logger = LoggerFactory.getLogger(ConditionSetServiceImpl.class);
	
	@Autowired
	private IemrRetrievalDao iemrRetrievalDao; 
	
	@Autowired
	private IemrRetrievalCondDao iemrRetrievalCondDao; 
	
	@Autowired
	private CusRetrievalCondDao cusRetrievalCondDao; 
	
	@Autowired
	private CusRetrievalDao cusRetrievalDao; 
	
	@Autowired
	CusRetrievalResultDao cusRetrievalResultDao; 
	
	@Reference
	DataRetrievalService dataRetrievalService;
	
	@Reference
	DictionaryService dictionaryService;
	
	/*@Reference
	TaskDataRetrievalService taskDataRetrievalService;*/

	@Override
	public ArrayResult<IemrRetrievalCondModel> create(IemrRetrievalCondModel ircm)
			throws Throwable {
		String retrievalCd = "";
		if(null!=ircm){
			retrievalCd = ircm.getRetrievalCd();
			try{
				String retrievalCondCd = UUIDGenerator.getUUID();
				ircm.setCondCd(retrievalCondCd);
				IemrRetrievalCond retrievalCond = new IemrRetrievalCond();
				BeanCopyUtil.modelToEntity(retrievalCond, ircm);
				//获取当前方案下条件最大的排序号
				short condNo = (short)(cusRetrievalCondDao.selectMaxCondNoByRetrievalcd(retrievalCd)+1);
				retrievalCond.setCondNo(condNo);
				//第一层条件无父节点
				if("1".equals(retrievalCond.getGrade())){
					retrievalCond.setUpcond("");
				}
				//存储病历模板编码
				retrievalCond.setObjCode(ircm.getMrPk());
				iemrRetrievalCondDao.insert(retrievalCond);
			}catch(Exception e){
				throw new RuntimeException(e);
			}
		}
		Map param = new HashMap();
		param.put("retrievalCd", retrievalCd);
		ArrayResult<IemrRetrievalCondModel> retrievalCondArrayResult = retrievalCondList(param);
		return retrievalCondArrayResult;
	}

	@Override
	public ArrayResult<IemrRetrievalCondModel> retrievalCondList(Map map) {
		String retrievalCd = getValueFromMap(map,"retrievalCd","检索方案编码");
		ArrayResultBuilder<IemrRetrievalCondModel> builder = ArrayResultBuilder.newArrayResult(IemrRetrievalCondModel.class);
		int total = 0;
		List<Map<String, Object>> retrievalCondList = cusRetrievalCondDao.selectRetrievalCondByRetrievalcd(retrievalCd, "", "1");
		Map<String, Object> mapRetrievalCond = null;
		if(null!=retrievalCondList){
			total = retrievalCondList.size() ;
			IemrRetrievalCondModel[] retrievalCondArr = new IemrRetrievalCondModel[retrievalCondList.size()];
			if(retrievalCondList.size()>0){
				for(int i = 0; i < retrievalCondList.size(); i++ ){
					mapRetrievalCond = retrievalCondList.get(i);
					IemrRetrievalCondModel retrievalCondModel = new IemrRetrievalCondModel();
					BeanCopyUtil.mapToModel(retrievalCondModel, mapRetrievalCond,dictionaryService);
					retrievalCondArr[i] = retrievalCondModel;
				}
				if(retrievalCondArr!=null){
					builder.withData(retrievalCondArr);
				}
			}
		}
		ArrayResult<IemrRetrievalCondModel> rs = builder.build();
		rs.setTotal(total);
		return rs;
	}
	
	@Override
	public TreeResult<IemrRetrievalCondModel> retrievalCondTree(Map map) throws Throwable {
		String retrievalCd = getValueFromMap(map,"retrievalCd","检索方案编码");
		IemrRetrievalCondModel rootNode = new IemrRetrievalCondModel() ;
		String sessionOrgName = "检索条件结构树根节点";
		rootNode.setId("rootCode");
		rootNode.setText(sessionOrgName);
		rootNode.setLeaf(Boolean.FALSE);
		rootNode.setExpanded(Boolean.TRUE);
		TreeBuilder<IemrRetrievalCondModel> builder = TreeBuilder.newTree("/",sessionOrgName,rootNode);
		List<Map<String, Object>> retrievalCondList = cusRetrievalCondDao.selectRetrievalCondByRetrievalcd(retrievalCd, "", "1");//第一层节点
		Map<String, Object> mapRetrievalCond = null;
		if(null!=retrievalCondList){
			if(retrievalCondList.size()>0){
				for(int i=0;i<retrievalCondList.size();i++){
					IemrRetrievalCondModel retrievalCond = new IemrRetrievalCondModel();
					mapRetrievalCond = retrievalCondList.get(i);
					BeanCopyUtil.mapToModel(retrievalCond, mapRetrievalCond,dictionaryService);
					String conditionName = (String) retrievalCond.getConditionName();
					String condPath = "/"+retrievalCond.getCondCd();
					//判断是否有以该id为父节点的节点
					List<Map<String, Object>> retrievalCondChildList =  cusRetrievalCondDao.selectRetrievalCondByUpcond(retrievalCond.getCondCd());
					boolean isLeaf = false;
					if(null==retrievalCondChildList || retrievalCondChildList.isEmpty() == true || retrievalCondChildList.size()==0){
						isLeaf = true;
					}
					builder.addChildByData( condPath, conditionName, retrievalCond, isLeaf);
					builder = buildCondChildrenTree(builder, retrievalCond, retrievalCondChildList, condPath+"/");
				}
			}
		}
		TreeNode<IemrRetrievalCondModel> tree = builder.build();
		TreeResult<IemrRetrievalCondModel> r = new TreeResult<IemrRetrievalCondModel>();
		r.setRoot(tree);
		return r;
	}
	
	private TreeBuilder<IemrRetrievalCondModel>  buildCondChildrenTree(TreeBuilder<IemrRetrievalCondModel> builder , IemrRetrievalCondModel parentNode, List<Map<String, Object>> resultTree, String condPath) throws DocumentException{
		Map<String, Object> mapRetrievalCond = null;
		if(null!=resultTree){
			if (resultTree.isEmpty() != true){
	            for (int i=0;i<resultTree.size();i++){
	            	IemrRetrievalCondModel node = new IemrRetrievalCondModel();//resultTree.get(i);
	            	mapRetrievalCond = resultTree.get(i);
	            	BeanCopyUtil.mapToModel(node, mapRetrievalCond,dictionaryService);
	            	String currentPath = condPath+node.getCondCd();
	            	String conditionName = (String) node.getConditionName();
	            	//判断是否有以该id为父节点的节点
					List<Map<String, Object>> retrievalCondChildList =  cusRetrievalCondDao.selectRetrievalCondByUpcond(node.getCondCd());
					boolean isLeaf = false;
					if(null==retrievalCondChildList || retrievalCondChildList.isEmpty() == true || retrievalCondChildList.size()==0){
						isLeaf = true;
					}
					builder = buildCondChildrenTree(
							builder.addChildByData( currentPath, conditionName, node, isLeaf)
			    			,node 
			    			,retrievalCondChildList
			    			,currentPath+"/");
	            }
			}
		}
		return builder;
	}
	
	@Override
	public SingleResult<IemrRetrievalCondModel> retrievalCondMemo(Map map){
		String retrievalCd = getValueFromMap(map,"retrievalCd","检索方案编码");
		SingleResultBuilder<IemrRetrievalCondModel> builder = SingleResultBuilder.newSingleResult(IemrRetrievalCondModel.class);
		List<Map<String, Object>> retrievalCondList = cusRetrievalCondDao.selectRetrievalCondByRetrievalcd(retrievalCd, "", "1");
		Map<String, Object> mapRetrievalCond = null;
		StringBuffer sb = new StringBuffer();
		if(null!=retrievalCondList){
			if(retrievalCondList.size()>0){
				IemrRetrievalCondModel retrievalCond = new IemrRetrievalCondModel();
				for(int i=0;i<retrievalCondList.size();i++){
					mapRetrievalCond = retrievalCondList.get(i);
					if(i>0){
						sb.append(" ");
						sb.append(mapRetrievalCond.get("REL_TYPE"));//并且 或者
						sb.append(" ");
					}
					sb.append(" (");
					sb.append(mapRetrievalCond.get("VAL_NAME"));//约束对象
					sb.append(mapRetrievalCond.get("LOGIC"));//大于小于等于等等信息
					sb.append("'");
					sb.append(mapRetrievalCond.get("VAL_CODE"));//约束值域
					sb.append("'");
					
					//判断是否有以该id为父节点的节点
					List<Map<String, Object>> retrievalCondChildList =  cusRetrievalCondDao.selectRetrievalCondByUpcond(mapRetrievalCond.get("COND_CD").toString());
					sb.append(appendCondChildrenMemo(retrievalCondChildList));
					
					sb.append(") ");
				}
				retrievalCond.setRetrievalCd(retrievalCd);
				retrievalCond.setMemo(sb.toString());
				builder.withData(retrievalCond);
			}
		}
		return builder.build();
	}
	
	private StringBuffer appendCondChildrenMemo(List<Map<String, Object>> condChildList){
		Map<String, Object> mapRetrievalCond = null;
		StringBuffer sb = new StringBuffer();
		if(null!=condChildList){
			if(condChildList.size()>0){
				sb.append(" and ");
				for(int i=0;i<condChildList.size();i++){
					mapRetrievalCond = condChildList.get(i);
					
					//判断是否有以该id为父节点的节点
					List<Map<String, Object>> retrievalCondChildList =  cusRetrievalCondDao.selectRetrievalCondByUpcond(mapRetrievalCond.get("COND_CD").toString());
					
					if(i>0){
						sb.append(" ");
						sb.append(mapRetrievalCond.get("REL_TYPE"));//并且 或者
						sb.append(" ");
					}
					if(retrievalCondChildList.size()>0 || i==0){
						sb.append(" (");
					}
					sb.append(mapRetrievalCond.get("VAL_NAME"));//约束对象
					sb.append(mapRetrievalCond.get("LOGIC"));//大于小于等于等等信息
					sb.append("'");
					sb.append(mapRetrievalCond.get("VAL_CODE"));//约束值域
					sb.append("'");
					
					sb.append(appendCondChildrenMemo(retrievalCondChildList));
					
					if(null!=retrievalCondChildList){
						if(retrievalCondChildList.size()>0){
							sb.append(") ");
						}
					}
					if(condChildList.size()>1 && i!=0){
						sb.append(") ");
					}
				}
			}
		}
		return sb;
	}
	
	//查询病历模板列表
	@Override
	public ArrayResult<BaseTemplateModel> getBaseTemplate( Map<String, String> condition) throws Throwable{
		List<Map<String, Object>> tempList = cusRetrievalCondDao.selectBaseTemplate("");
		int total = 0;
		ArrayResultBuilder<BaseTemplateModel> builder  = ArrayResultBuilder.newArrayResult(BaseTemplateModel.class);
		if(null!=tempList && tempList.size()>0){
			Map<String, Object> map = new HashMap<String, Object>();
			BaseTemplateModel[] templateArr = new BaseTemplateModel[tempList.size()];
			for(int i=0;i<tempList.size();i++){
				BaseTemplateModel tempModel = new BaseTemplateModel();
				tempModel.setNm(tempList.get(i).get("NM").toString());
				tempModel.setMrTplCd(tempList.get(i).get("MR_TPL_CD").toString());
				tempModel.setXmlFilePk(tempList.get(i).get("XML_FILE_PK").toString());
				templateArr[i] = tempModel;
			}
			if(templateArr!=null){
				builder.withData(templateArr);
			}
		}
		ArrayResult<BaseTemplateModel> rs = builder.build();
		rs.setTotal(total);
		return rs;
	}
	
	
	@Override
	public TreeResult<MrDocTreeBean> analyticMrDocTree(Map<String, String> condition) throws Throwable {
		MrDocTreeBean rootNode = new MrDocTreeBean() ;
		String sessionOrgName = "病历结构树根节点";
		rootNode.setId("rootCode");
		rootNode.setText(sessionOrgName);
		rootNode.setLeaf(Boolean.FALSE);
		rootNode.setExpanded(Boolean.TRUE);
		TreeBuilder<MrDocTreeBean> builder = TreeBuilder.newTree("/",sessionOrgName,rootNode);
		ArrayList<MrDocTreeBean> resultTree = null; 
		String xmlFilePk = getValueFromMap(condition,"xmlFilePk","xml编码");
		//查询病历模板列表
		List<Map<String, Object>> baseTemplateList= cusRetrievalCondDao.selectBaseTemplate(xmlFilePk);
		Clob xmlClob=null;
		String xmlStr = "";
		if(null!=baseTemplateList && baseTemplateList.size()>0){
			Reader inStream=null;
			for(int m=0;m<baseTemplateList.size();m++){
				xmlClob = (Clob) baseTemplateList.get(m).get("FILE_DATA");
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
			}
		}
		if(!"".equals(xmlStr)){
			resultTree = AnalyticXmlUtil.getMrTree(xmlStr, "", "");
		}
		builder = buildChildrenTree(builder, rootNode, resultTree, "/", "", "");
		TreeNode<MrDocTreeBean> tree = builder.build();
		TreeResult<MrDocTreeBean> r = new TreeResult<MrDocTreeBean>();
		r.setRoot(tree);
		return r;
	}
	
	private TreeBuilder<MrDocTreeBean>  buildChildrenTree(TreeBuilder<MrDocTreeBean> builder , MrDocTreeBean parentNode, ArrayList<MrDocTreeBean> resultTree, String parentPath, String mrPk, String docType) throws DocumentException{
		if(null!=resultTree){
			if (resultTree.isEmpty() != true){
	            for (int i=0;i<resultTree.size();i++){
	            	MrDocTreeBean node = new MrDocTreeBean();//resultTree.get(i);
	            	node = resultTree.get(i);
	            	String currentPath = node.getElemPath();
	            	if("element".equalsIgnoreCase(node.getNodeType())){
	            		resultTree.remove(node);
	            		builder = buildChildrenTree(
	            				builder.addChildByData( currentPath, node.getElemName(), node, Boolean.TRUE)
		            			,node
		            			,resultTree
		            			,currentPath+"/"
		            			,mrPk
		            			,docType);
	            	}else if("group".equalsIgnoreCase(node.getNodeType())){//当父节点为group时
	            		resultTree.remove(node);
		            	builder = buildChildrenTree(
		            			builder.addChildByData( currentPath, node.getGroupName(), node) 
		            			,node
		            			,resultTree
		            			,currentPath+"/"
		            			,mrPk
		            			,docType);
	            	}else if("segment".equalsIgnoreCase(node.getNodeType())){//当父节点为segment时
	            		resultTree.remove(node);
		            	builder = buildChildrenTree(
		            			builder.addChildByData( currentPath, node.getSegmName(), node) 
		            			,node 
		            			,resultTree
		            			,currentPath+"/"
		            			,mrPk
		            			,docType);
	            	} 
	            }
	        }
		}
		return builder;	
	}
	
	@Override
	public SingleResult<IemrRetrievalCond> delete(String id) throws Throwable {
		IemrRetrievalCond retrievalCond= iemrRetrievalCondDao.selectById(id);
		retrievalCond.setDelF((short)1);
		iemrRetrievalCondDao.markDelete(retrievalCond);
		return SingleResultBuilder.newSingleResult(IemrRetrievalCond.class).build();
	}
	
	@Override
	public SingleResult<IemrRetrievalCond> retrievalCondUp(String id)
			throws Throwable {
		String changeNo = "up";
		changeNo(id, changeNo);
		return SingleResultBuilder.newSingleResult(IemrRetrievalCond.class).build();
	}

	@Override
	public SingleResult<IemrRetrievalCond> retrievalCondDown(String id)
			throws Throwable {
		String changeNo = "down";
		changeNo(id, changeNo);
		return SingleResultBuilder.newSingleResult(IemrRetrievalCond.class).build();
	}
	
	private void changeNo(String id, String changeNo){
		IemrRetrievalCond retrievalCondCurrent= iemrRetrievalCondDao.selectById(id);
		short condNoCurrent = (short)retrievalCondCurrent.getCondNo();
		String retrievalCd = retrievalCondCurrent.getRetrievalCd();
		int grade = retrievalCondCurrent.getGrade();
		String upcond = retrievalCondCurrent.getUpcond();
		List<Map<String, Object>> retrievalCondListNew =  cusRetrievalCondDao.selectRetrievalCondByCondno(retrievalCd, grade, upcond);
		Map<String, Object> mapRetrievalCond = null;
		if(null!=retrievalCondListNew){
			int condListSize = retrievalCondListNew.size();
			if(condListSize>0){
				int condListNo = 0;
				for(int i=0;i<condListSize;i++){
					if(id.equals(retrievalCondListNew.get(i).get("COND_CD"))){
						condListNo=i;
					}
				}
				if("up".equals(changeNo)){
					if(condListNo!=0)
						mapRetrievalCond = retrievalCondListNew.get(condListNo-1);
				}else if("down".equals(changeNo)){
					if(condListSize>0 && condListNo!=(condListSize-1) )
						mapRetrievalCond = retrievalCondListNew.get(condListNo+1);
				}
				
				if(null!=mapRetrievalCond){
					short condNoNew = Short.parseShort(mapRetrievalCond.get("COND_NO").toString());
					String retrievalCondCdNew = (String) mapRetrievalCond.get("COND_CD");
					IemrRetrievalCond retrievalCondNew= iemrRetrievalCondDao.selectById(retrievalCondCdNew);
					short maxCondNo = (short) (cusRetrievalCondDao.selectMaxCondNoByRetrievalcd(retrievalCd)+1);
					
					retrievalCondNew.setCondNo(maxCondNo);
					iemrRetrievalCondDao.updateExcludeNull(retrievalCondNew);
					
					retrievalCondCurrent.setCondNo(condNoNew);
					iemrRetrievalCondDao.updateExcludeNull(retrievalCondCurrent);
					
					retrievalCondNew.setCondNo(condNoCurrent);
					iemrRetrievalCondDao.updateExcludeNull(retrievalCondNew);
				}
			}
		}
	}
	

	@Override
	public ArrayResult<PatientRetrievalModel> getMrContentByRetrieval(String retrievalCd) throws Throwable {
		//查出检索方案信息
		IemrRetrieval retrieval = iemrRetrievalDao.selectById(retrievalCd);
		//根据检索方案查询出符合条件的患者及其病案
		/*
		 select * from mr_amr m where m.en_sta_cd='ENM02.04'--完成（诊毕、出院出科）
			and m.amr_sta_cd='MRM22.07'--已归档
			and m.en_tp_cd='ENM01.04'--住院
			--
			mr
			mr_tpl
			xap_bizfile
		 */
		
		/*taskDataRetrievalService.searchRetrieval();*/
		
		//根据检索方案检索出对应的检索条件
		List<Map<String, Object>> retrievalCondList = cusRetrievalCondDao.selectRetrievalCondByRetrievalcd(retrievalCd, "", "");

		Map param = new HashMap();
		ArrayResult<IemrRetrievalModel> retrievalArrayResult = dataRetrievalService.retrievalListBrowses(param);
		//筛选符合条件的病案
		List<Map<String, Object>> suitAmrList =cusRetrievalResultDao.selectRetrievalAmrByCondition(null);
		
		List<String>  enPkList = new ArrayList<String>();
		for(int i=0;i<suitAmrList.size();i++){
			param.put("retrievalCd", retrievalCd);
			param.put("enPk", suitAmrList.get(i).get("EN_PK").toString());
			String resultValue = retrievalCond(param);
//	    	System.out.println("~~~resultValue~~~"+resultValue);
	    	if(!StringUtils.isEmpty(resultValue)){
	    		ScriptEngineManager manager = new ScriptEngineManager();  
				ScriptEngine engine = manager.getEngineByName("js");  
		        Object result = engine.eval(resultValue);  
		        if(null!=result){
			        if(!result.toString().isEmpty()){
				        if(Boolean.parseBoolean(result.toString())){
				        	//拼接 in 条件
				        	enPkList.add(suitAmrList.get(i).get("EN_PK").toString());
				         }
			        }
		        }
	    	}
		}
        ArrayResultBuilder<PatientRetrievalModel> builder = ArrayResultBuilder.newArrayResult(PatientRetrievalModel.class);
		int total = 0;
        if(null!=enPkList && enPkList.size()>0){
	        List<Map<String, Object>> amrList = cusRetrievalDao.selectAmrByEnpkstr(enPkList);
	        if(null!=amrList){
	        	Map<String, Object> amrMap = null;
	        	total = amrList.size();
	        	PatientRetrievalModel[] patientRetrievalArr = new PatientRetrievalModel[total];
	        	for(int i=0;i<amrList.size();i++){
	        		PatientRetrievalModel patientRetrievalModel = new PatientRetrievalModel();
	        		amrMap = amrList.get(i);
					BeanCopyUtil.mapToModel(patientRetrievalModel, amrMap, dictionaryService);
					patientRetrievalArr[i] = patientRetrievalModel;
	        	}
	        	if(patientRetrievalArr!=null){
					builder.withData(patientRetrievalArr);
				}
	        }
		}
        ArrayResult<PatientRetrievalModel> rs = builder.build();
		rs.setTotal(total);
		return rs;
	}
	
	
	private String retrievalCond(Map map){
		String retrievalCd = getValueFromMap(map,"retrievalCd","检索方案编码");
		String enPk = getValueFromMap(map,"enPk","就诊编码");
		List<Map<String, Object>> retrievalCondList = cusRetrievalCondDao.selectCondLogicByRetrieval(retrievalCd, enPk);
		Map<String, Object> mapRetrievalCond = null;
		StringBuffer sb = new StringBuffer();
		if(null!=retrievalCondList){
			if(retrievalCondList.size()>0){
				for(int i=0;i<retrievalCondList.size();i++){
					mapRetrievalCond = retrievalCondList.get(i);
					
					if(i>0){
						if("or".equals(mapRetrievalCond.get("REL_TYPE"))){
							sb.append("||");//或者
						}else{
							sb.append("&&");//并且
						}
					}
					sb.append(mapRetrievalCond.get("RESULTVALUE"));//结果
					
					//判断是否有以该id为父节点的节点
					List<Map<String, Object>> retrievalCondChildList =  cusRetrievalCondDao.selectRetrievalCondByUpcond(mapRetrievalCond.get("COND_CD").toString());
					sb.append(appendCondChildren(retrievalCondChildList));
					
				}
			}
		}
		return sb.toString();
	}
	
	private StringBuffer appendCondChildren(List<Map<String, Object>> condChildList){
		Map<String, Object> mapRetrievalCond = null;
		StringBuffer sb = new StringBuffer();
		if(null!=condChildList){
			if(condChildList.size()>0){
				sb.append(" && ");
				for(int i=0;i<condChildList.size();i++){
					mapRetrievalCond = condChildList.get(i);
					
					//判断是否有以该id为父节点的节点
					List<Map<String, Object>> retrievalCondChildList =  cusRetrievalCondDao.selectRetrievalCondByUpcond(mapRetrievalCond.get("COND_CD").toString());
					
					if(i>0){
						if("or".equals(mapRetrievalCond.get("REL_TYPE"))){
							sb.append("||");//或者
						}else{
							sb.append("&&");//并且
						}
					}
					if(retrievalCondChildList.size()>0 || i==0){
						sb.append(" (");
					}
					sb.append(mapRetrievalCond.get("RESULTVALUE"));//结果
					
					sb.append(appendCondChildrenMemo(retrievalCondChildList));
					
					if(null!=retrievalCondChildList){
						if(retrievalCondChildList.size()>0){
							sb.append(") ");
						}
					}
					if(condChildList.size()>1 && i!=0){
						sb.append(") ");
					}
				}
			}
		}
		return sb;
	}

	
	//判断map中是否存在key
	private boolean verifyExistKey(Map map, String key) { 
		if (map.containsKey(key) && null != map.get(key)) {
			String value = (String) map.get(key) ;
			if(!NULL_STRING.equalsIgnoreCase(value) && value.length() > 0)
			return true;
		}
		return false;
	}
	
	private String getValueFromMap(Map map,String key,String name){
		String value = null ;
		if(verifyExistKey(map,key)){
			Object object = map.get(key);
			value = object.toString();
			if(StringUtils.isBlank(value)){
				logger.debug(name+"为空");
				value = null ;
			}
			logger.debug(name+":"+ value);
		}else{
			logger.debug(name+"为空");
		}
		return value;
	}
	
}
