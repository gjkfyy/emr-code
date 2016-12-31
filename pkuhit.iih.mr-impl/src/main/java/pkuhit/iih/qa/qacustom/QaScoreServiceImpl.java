package pkuhit.iih.qa.qacustom;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.mr.dao.auto.MrAmrDao;
import pkuhit.iih.mr.dao.auto.entity.MrAmr;
import pkuhit.iih.mr.md.AmrStatus;
import pkuhit.iih.mr.wr.Amr;
import pkuhit.iih.qa.QaDivideLevelModel;
import pkuhit.iih.qa.QaDivideModel;
import pkuhit.iih.qa.dao.auto.QaDivideDao;
import pkuhit.iih.qa.dao.auto.entity.QaDivide;
import pkuhit.iih.qa.dao.qacustom.CusQaDivideDao;
import pkuhit.iih.qa.md.QaDropScoreType;
import pkuhit.iih.qa.md.QaFltStatus;
import pkuhit.iih.qa.qacustom.bizmodel.CusCreateQaDivide;
import pkuhit.iih.qa.util.ArithmeticUtil;
import pkuhit.iih.qa.util.QaUtil;
import pkuhit.md.DictionaryService;
import pkuhit.xap.ac.Session;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import xap.sv.util.UUIDGenerator;

/**
 * 
 * @author wang_yanli
 *
 */
public class QaScoreServiceImpl implements QaScoreService {

	
	@Reference
	DictionaryService dictionaryService;
	
	@Autowired
	QaDivideDao qaDivideDao;
	
	@Autowired
	MrAmrDao mrAmrDao;

	@Autowired
	CusQaDivideDao cusQaDivideDao;
	
	public QaScoreServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public SingleResult<QaDivideModel> delete(String id) throws Throwable {
		QaDivide qaDivide = qaDivideDao.selectById(id);
		qaDivide.setDelF((short)1);
		qaDivideDao.markDelete(qaDivide);
		return SingleResultBuilder.newSingleResult(QaDivideModel.class).build();
	}

	@Override
	public ArrayResult<QaDivideModel> search(Map map) throws Throwable {
		
		ArrayResultBuilder<QaDivideModel> builder = ArrayResultBuilder
				.newArrayResult(QaDivideModel.class);
		ArrayResult<QaDivideModel> qaDivideArrayResult = null;
		if(map!=null){
			
			QaDivideModel qaDivide = new QaDivideModel();
			
			//查询条件准备==================================开始===================================================
			String encounterPk = null ;
			//质控类型包括环节质控、科室质控、终末质控
			String qaTypeCode = null ;
			
			String workScreen = "";
			
			if(map.containsKey("encounterPk")){
				encounterPk = map.get("encounterPk").toString();
			}					
			Session session = Session.get();
			//当前登录者=提出人（SBMT_USER_ID）
			String userId = session.getUserId();
			//当前登录者部门=提出人所在科室（SBMT_DEPT_CD）
			String deptId = session.getDeptId();
			//当前登录者=提出人（SBMT_USER_ID）
			if(map.containsKey("workScreen")){
				workScreen = map.get("workScreen").toString();
			}
			String reformUserId = "";
			String reformDeptId = "";
			//根据不同的工作场景查询给查询条件赋值7=终末质控评分
			//QA_TY_CD质控类型
			//如果为终末质控评分：查询QA_TY_CD=QAM13.03 ,科室 终末评分 QA_TY_CD=QAM13.02
			if(workScreen.equals("7")){
				qaTypeCode =  QaFltStatus.QA_TY_CD_TERMINAL;
			}else if(workScreen.equals("11")){
				qaTypeCode =  QaFltStatus.QA_TY_CD_DEPT;
			}else if(workScreen.equals("12")){
				qaTypeCode =  QaFltStatus.QA_TY_CD_AUTO_PROCESS;//暂时自动质控
				
			}
			
			//添加分页部分
			String pageNum = null;
			String pageSize = null;
			if(map.containsKey("pageNum") && map.containsKey("pageSize")){
				pageNum = (String)map.get("pageNum");
				pageSize = (String)map.get("pageSize");
			}
			if(null == pageNum || !StringUtils.isNumeric(pageNum)   || null == pageSize || !StringUtils.isNumeric(pageSize)  )
			{
				pageNum= "1";
				pageSize = "25";
			}
			//查询条件准备=======================================结束===========================================		
			
			ArrayResultBuilder<QaDivideModel> arrayBuilder = ArrayResultBuilder.newArrayResult(QaDivideModel.class);
			List<Map<String, Object>> qaDivideList = null;
			Map<String, Object> mapQaDivide = null;
			SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();			
			long count = options.getCount();
			int total = Long.valueOf(count).intValue();
			
			qaDivideList = cusQaDivideDao.selectQaDivideByCondition(encounterPk, 
					qaTypeCode,options);
			if(null != qaDivideList){
				if(qaDivideList.size()>0){
					QaDivideModel[] qaDivideModelArray = new QaDivideModel[qaDivideList.size()];
					for(int i=0;i<qaDivideList.size();i++){
						QaDivideModel qaDivideModel = new QaDivideModel();
						mapQaDivide = qaDivideList.get(i);
						BeanCopyUtil.mapToModel(qaDivideModel, mapQaDivide,dictionaryService);
						qaDivideModelArray[i] = qaDivideModel;
					}
					if(qaDivideModelArray!=null){
						arrayBuilder.withData(qaDivideModelArray);
					}
				}
			}
			
			qaDivideArrayResult = arrayBuilder.build();
			qaDivideArrayResult.setTotal(total);			
		}
		return qaDivideArrayResult;
	}

	@Override
	public ArrayResult<QaDivideModel> create(CusCreateQaDivide createParams)
			throws Throwable {
		Session session = Session.get();
		String userId = session.getUserId();
		String deptId = session.getDeptId();
		QaDivideModel[] qaDivideModelArray = createParams.getQaDivideArray();
		try{
			Timestamp tm = new Timestamp(System.currentTimeMillis());
			if (qaDivideModelArray != null && qaDivideModelArray.length > 0) {
				String qaDivideCd = "";
				for (int i = 0; i < qaDivideModelArray.length; i++) {
					QaDivideModel qaDivideModel = qaDivideModelArray[i];
					qaDivideCd = UUIDGenerator.getUUID();
					qaDivideModel.setQaDivideCd(qaDivideCd);
					qaDivideModel.setSbmtTime(tm);
					qaDivideModel.setSbmtUserId(userId);
					qaDivideModel.setSbmtDeptCd(deptId);
					
					//保存扣分记录
					QaDivide qaDivide = new QaDivide();
					BeanCopyUtil.modelToEntity(qaDivide, qaDivideModel);
					qaDivideDao.insert(qaDivide);
				}
			}
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		ArrayResultBuilder<QaDivideModel> builder = ArrayResultBuilder.newArrayResult(QaDivideModel.class);
		return builder.build();
	}


	/**
	 * 该版本扣分规则：单否不受一级分类最大分的限制，一级分类扣分=单项扣分总和+单否扣分
	 */
	@Override
	public SingleResult<Amr> score(String enPk, String qaTypeCode,
			String qaSysCode) throws Exception {
		try {
			//返回值放在arm中
			SingleResultBuilder<Amr> builder = SingleResultBuilder.newSingleResult(Amr.class);
			List<Map<String, Object>> qaDivideItemsList = cusQaDivideDao.selectQaDivide(enPk,qaTypeCode);
			Map<String, Object> mapQaDivide = null;
			
			if(null != qaDivideItemsList){
				
				//返回的查询结果转换成qaDivideModel放到数组中
				QaDivideModel[] qaDivideModelArray = new QaDivideModel[qaDivideItemsList.size()];
				
				for(int i=0;i<qaDivideItemsList.size();i++){
					
					QaDivideModel qaDivideModel = new QaDivideModel();
					mapQaDivide = qaDivideItemsList.get(i);
					BeanCopyUtil.mapToModel(qaDivideModel, mapQaDivide,dictionaryService);
					qaDivideModelArray[i] = qaDivideModel;
					
				}
				//二级扣分=====================================================================
				//循环数组，按二级分类分组
				//2015-3-5 新增功能 二级分类中如果有【单否】类的项目，则不受二级分类限制，只受一级分类限制，实现方式：在QaDivideModel中增加单否乙级和单否丙级得分，在一级分类时限制
				Map<String,Object> secondDivideMap = new HashMap();
				
				for(QaDivideModel qaDiv:qaDivideModelArray){
					
					String sndCd = qaDiv.getSndCd();
					BigDecimal onceDropScore = ArithmeticUtil.bigDecimalExcludeNull(qaDiv.getOnceDropScore(), "0.00");
					//扣分类型
					String qaDrpScrTpCd = qaDiv.getQaDrpScrTpCd();
					//map中不存在该二级分类，则put进该二级分类，并存入当前model的信息
					if(!secondDivideMap.containsKey(sndCd)){
						
						QaDivideModel qaDivideModel = new QaDivideModel();
						qaDivideModel.setFstCd(qaDiv.getFstCd());
						qaDivideModel.setSndCd(qaDiv.getSndCd());
						qaDivideModel.setFirstMaxScore(qaDiv.getFirstMaxScore());
						qaDivideModel.setSecondMaxScore(qaDiv.getSecondMaxScore());
						
						//如果扣分类型是单否乙，则model中存入单否乙的分值
						if(null!=qaDrpScrTpCd && qaDrpScrTpCd.equals(QaDropScoreType.GRADE_B)){
							qaDivideModel.setGradeBScore(onceDropScore);
						//单否丙同上	
						}else if(null!=qaDrpScrTpCd && qaDrpScrTpCd.equals(QaDropScoreType.GRADE_C)){
							qaDivideModel.setGradeCScore(onceDropScore);
						//如果是其他扣分类型，则按照不能超过二级分类总分进行处理，并将处理结果放入二级分类扣分中(secondDropScore)	
						}else {
							
							BigDecimal secondDropScore = ArithmeticUtil.bigDecimalExcludeNull(qaDiv.getItemScore(), "0.00");
							BigDecimal secondMaxScore =  ArithmeticUtil.bigDecimalExcludeNull(qaDiv.getSecondMaxScore(), "0.00");
							if(secondDropScore.compareTo(secondMaxScore)==-1){
								qaDivideModel.setSecondDropScore(secondDropScore);
							}else{
								qaDivideModel.setSecondDropScore(secondMaxScore);
								qaDivideModel.setSecondScoreFlag(true);
							}
						}						
						
						secondDivideMap.put(sndCd, qaDivideModel);
						
					}else {
						QaDivideModel oldQaDivideModel = (QaDivideModel)secondDivideMap.get(sndCd);
						
						//如果当前oldQaDivideModel中已经有单否乙、单否丙的值，则再有单否乙、丙的记录出现时，需要累加
						if(null!=qaDrpScrTpCd && qaDrpScrTpCd.equals(QaDropScoreType.GRADE_B)){
							
							BigDecimal oldGradeBScore = ArithmeticUtil.bigDecimalExcludeNull(oldQaDivideModel.getGradeBScore(), "0.00");
							BigDecimal newGradeBScore = oldGradeBScore.add(onceDropScore);
							oldQaDivideModel.setGradeBScore(newGradeBScore);
							
						}else if(null!=qaDrpScrTpCd && qaDrpScrTpCd.equals(QaDropScoreType.GRADE_C)){
							BigDecimal oldGradeCScore = ArithmeticUtil.bigDecimalExcludeNull(oldQaDivideModel.getGradeCScore(), "0.00");
							BigDecimal newGradeCScore = oldGradeCScore.add(onceDropScore);
							oldQaDivideModel.setGradeCScore(newGradeCScore);
						}else{
							if(oldQaDivideModel.isSecondScoreFlag()){
								continue;
							}else{
								//得到已有的二级总分
								BigDecimal oldSecondScore = ArithmeticUtil.bigDecimalExcludeNull(oldQaDivideModel.getSecondDropScore(), "0.00");
								BigDecimal itemScore = ArithmeticUtil.bigDecimalExcludeNull(qaDiv.getItemScore(), "0.00");
								BigDecimal secondMaxScore = ArithmeticUtil.bigDecimalExcludeNull(qaDiv.getSecondMaxScore(), "0.00");
								BigDecimal newSecondScore = oldSecondScore.add(itemScore);//二级总分累加
								
								//secondMaxScore < newSecondScore 
								if(secondMaxScore.compareTo(newSecondScore) == -1){
									oldQaDivideModel.setSecondDropScore(secondMaxScore);
									oldQaDivideModel.setSecondScoreFlag(true);
								}else{
									oldQaDivideModel.setSecondDropScore(newSecondScore);
								}
							}
						}	
						secondDivideMap.put(sndCd, oldQaDivideModel);
						
						
					}
				}
				//二级扣分完成--------------------一级分类扣分开始========================================================================
				//将二级map中的values转换成数组，沿用二级中的实现方式，对一级进行扣分累加
				QaDivideModel[] qa =new QaDivideModel[secondDivideMap.size()];
				QaDivideModel[] qaDivideModelSecondArray = secondDivideMap.values().toArray(qa);//.toArray();
				
				Map<String,Object> firstDivideMap = new HashMap();
				
				for(QaDivideModel qaDiv:qaDivideModelSecondArray){
					
					String fstCd = qaDiv.getFstCd();
					BigDecimal secondDropScore = ArithmeticUtil.bigDecimalExcludeNull(qaDiv.getSecondDropScore(), "0.00");
					BigDecimal gradeBScore = ArithmeticUtil.bigDecimalExcludeNull(qaDiv.getGradeBScore(), "0.00");
					BigDecimal gradeCScore = ArithmeticUtil.bigDecimalExcludeNull(qaDiv.getGradeCScore(), "0.00");
					BigDecimal firstMaxScore = ArithmeticUtil.bigDecimalExcludeNull(qaDiv.getFirstMaxScore(), "0.00");
					
					//一级分类扣分 = 二级分类扣分+单否乙扣分+单否丙扣分
					BigDecimal firstDropScore = secondDropScore;//add(gradeBScore).add(gradeCScore);
					
					if(!firstDivideMap.containsKey(fstCd)){
						QaDivideModel qaDivideModel = new QaDivideModel();
						qaDivideModel.setFstCd(qaDiv.getFstCd());
						qaDivideModel.setSndCd(qaDiv.getSndCd());
						qaDivideModel.setFirstMaxScore(qaDiv.getFirstMaxScore());
						qaDivideModel.setSecondMaxScore(qaDiv.getSecondMaxScore());
						qaDivideModel.setSecondDropScore(qaDiv.getSecondDropScore());
						qaDivideModel.setGradeBScore(gradeBScore);
						qaDivideModel.setGradeCScore(gradeCScore);
						if(firstDropScore.compareTo(firstMaxScore) == -1){
							qaDivideModel.setFirstDropScore(firstDropScore);
						}else{
							qaDivideModel.setFirstDropScore(firstMaxScore);
							qaDivideModel.setFirstScoreFlag(true);
						}
						
						firstDivideMap.put(fstCd, qaDivideModel);
						
					}else {
						QaDivideModel oldQaDivideModel = (QaDivideModel)firstDivideMap.get(fstCd);

						//得到已有的一级总分
						BigDecimal oldFirstScore = ArithmeticUtil.bigDecimalExcludeNull(oldQaDivideModel.getFirstDropScore(), "0.00");
						BigDecimal newFirstScore = oldFirstScore.add(firstDropScore);//firstDropScore
						BigDecimal oldGradeBScore = ArithmeticUtil.bigDecimalExcludeNull(oldQaDivideModel.getGradeBScore(), "0.00");
						BigDecimal oldGradeCScore = ArithmeticUtil.bigDecimalExcludeNull(oldQaDivideModel.getGradeCScore(), "0.00");
						
						oldQaDivideModel.setGradeBScore(oldGradeBScore.add(gradeBScore));//当前的乙级得分加上已有的乙级得分
						oldQaDivideModel.setGradeCScore(oldGradeCScore.add(gradeCScore));//当前的丙级得分加上已有的丙级得分
						if(!oldQaDivideModel.isFirstScoreFlag()){
							if(firstMaxScore.compareTo(newFirstScore) == -1){
								oldQaDivideModel.setFirstDropScore(firstMaxScore);
								oldQaDivideModel.setFirstScoreFlag(true);
								
							}else{
								oldQaDivideModel.setFirstDropScore(newFirstScore);
								
							}
						}
						firstDivideMap.put(fstCd, oldQaDivideModel);
						
					}
				}
				//算总扣分
				
				BigDecimal  dropTotal = new BigDecimal(0.00);
				if(firstDivideMap.size()>0){
					for (String key : firstDivideMap.keySet()) {
						QaDivideModel qaDivideModel = (QaDivideModel)firstDivideMap.get(key);
						if(null!=qaDivideModel.getFirstDropScore()){
							dropTotal = dropTotal
									.add(qaDivideModel.getFirstDropScore())
									.add(qaDivideModel.getGradeBScore())
									.add(qaDivideModel.getGradeCScore());
						}
					}
				}
				
				//查询病案级别
				BigDecimal totalScore = new BigDecimal(100.00);
				BigDecimal qaScore = totalScore.subtract(dropTotal);

				String armLevel = "";
				String armLevelCd = "";
				List<Map<String, Object>> qaDivideLevelList = cusQaDivideDao.selectQaDivideLevel();
				Map<String, Object> mapQaDivideLevel = null;
				if(null != qaDivideLevelList){
					//QaDivideLevelModel[] qaDivideLevelModelArray = new QaDivideLevelModel[qaDivideLevelList.size()];
					if(qaDivideLevelList.size()>0){
						for(int i=0;i<qaDivideLevelList.size();i++){
								QaDivideLevelModel qaDivideLevelModel = new QaDivideLevelModel();
								mapQaDivideLevel = qaDivideLevelList.get(i);
								BeanCopyUtil.mapToModel(qaDivideLevelModel, mapQaDivideLevel,dictionaryService);
								BigDecimal minSrc = qaDivideLevelModel.getMinScr();
								BigDecimal maxSrc = qaDivideLevelModel.getMaxScr();
								//以下qaTempScore用来处理得分为0和负的情况：如果得分为负数则设为0，病案级别按丙级处理------------20150324
								BigDecimal qaTempScore = new BigDecimal(0.00);
								if(qaScore.compareTo(new BigDecimal(0.00)) == -1 || qaScore.compareTo(new BigDecimal(0.00)) == 0){
									qaTempScore = new BigDecimal(1.00);
									qaScore = new BigDecimal(0.00);
								}else{
									qaTempScore = qaScore;
								}
								//根据得分算出病案级别
								if((qaTempScore.compareTo(minSrc) == 1) && (qaTempScore.compareTo(maxSrc) == -1 || qaTempScore.compareTo(maxSrc) == 0)){
									armLevel = qaDivideLevelModel.getLvl();
									armLevelCd = qaDivideLevelModel.getQaDivideLevelCd();
								}
							}
						}
					}
				
				Amr amr = new Amr();
				amr.setScore(qaScore);
				amr.setLvl(armLevel);
				amr.setQaDivideLevelCd(armLevelCd);
				return builder.withData(amr).build();
			}
		} catch (Exception e) {
			throw e;
		} finally {
		}
		return null;
	}


	@Override
	public SingleResult<Amr> completeScore(String enPk,Map map) throws Exception {
		
		String qaDeptTerminalParalle = QaUtil.getStringValueFromMap(map, "qaDeptTerminalParalle"); //科室终末并行开关
		String qaTypeCode = QaFltStatus.QA_TY_CD_TERMINAL;
		SingleResult<Amr> singleAmr =  this.score(enPk, qaTypeCode,	"");
		Amr scoreAmr = singleAmr.getData();
		BigDecimal dropTotalScore = new BigDecimal(100.00);
		if(scoreAmr.getScore()!=null){
			dropTotalScore = scoreAmr.getScore();
		}
		String lvlCd = scoreAmr.getQaDivideLevelCd();
		MrAmr mrAmr = mrAmrDao.selectById(enPk);
		mrAmr.setQaScr(dropTotalScore);
		mrAmr.setAmrRankCd(lvlCd);
		if(qaDeptTerminalParalle.equals("true")){
			
			mrAmr.setTerminalQaStaCd(AmrStatus.QA_SCORED);//已终末质控评分
		}else{
			mrAmr.setAmrStaCd(AmrStatus.QA_SCORED);//已终末质控评分
		}
		mrAmrDao.updateExcludeNull(mrAmr);
		SingleResultBuilder<Amr> builder = SingleResultBuilder.newSingleResult(Amr.class);
		return builder.build();
	}

	@Override
	public SingleResult<Amr> deptCompleteScore(String enPk,Map map) throws Exception {
		String qaDeptTerminalParalle = QaUtil.getStringValueFromMap(map, "qaDeptTerminalParalle"); //科室终末并行开关
		String qaTypeCode = QaFltStatus.QA_TY_CD_DEPT;
		SingleResult<Amr> singleAmr =  this.score(enPk, qaTypeCode,	"");
		Amr scoreAmr = singleAmr.getData();
		BigDecimal dropTotalScore = new BigDecimal(100.00);
		if(scoreAmr.getScore()!=null){
			dropTotalScore = scoreAmr.getScore();
		}
		String lvlCd = scoreAmr.getQaDivideLevelCd();
		MrAmr mrAmr = mrAmrDao.selectById(enPk);
		mrAmr.setDeptQaScr(dropTotalScore);
		mrAmr.setAmrRankCd(lvlCd); //?????????????????????????????/有问题，病案状态用的同一个字段
		if(qaDeptTerminalParalle.equals("true")){
			
			mrAmr.setDeptQaStaCd(AmrStatus.QA_DEPT_SCORED);//已科室质控评分
		}else{
			mrAmr.setAmrStaCd(AmrStatus.QA_DEPT_SCORED);//已科室质控评分
		}
		
		mrAmrDao.updateExcludeNull(mrAmr);
		SingleResultBuilder<Amr> builder = SingleResultBuilder.newSingleResult(Amr.class);
		return builder.build();
	}

	
	
}
