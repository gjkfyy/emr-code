package pkuhit.iih.qa.qacustom;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.en.md.EncounterType;
import pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat;
import pkuhit.iih.qa.QaDivideLevelModel;
import pkuhit.iih.qa.QaDivideSetModel;
import pkuhit.iih.qa.QaItem;
import pkuhit.iih.qa.dao.auto.QaDivideLevelDao;
import pkuhit.iih.qa.dao.auto.QaItmDao;
import pkuhit.iih.qa.dao.auto.QaItmFstDao;
import pkuhit.iih.qa.dao.auto.QaItmSndDao;
import pkuhit.iih.qa.dao.auto.entity.QaDivideLevel;
import pkuhit.iih.qa.dao.auto.entity.QaItm;
import pkuhit.iih.qa.dao.auto.entity.QaItmFst;
import pkuhit.iih.qa.dao.auto.entity.QaItmSnd;
import pkuhit.iih.qa.dao.qacustom.CusQaDivideDao;
import pkuhit.iih.qa.dao.qacustom.CusQaFltItmDao;
import pkuhit.iih.qa.dao.qacustom.CusQaItemnDao;
import pkuhit.iih.qa.qacustom.bizmodel.QaItemCreateInit;
import pkuhit.iih.qa.qacustom.bizmodel.QaItmFstCategory;
import pkuhit.iih.qa.qacustom.bizmodel.QaItmSndCategory;
import pkuhit.iih.qa.qasys.QaSystemQaItem;
import pkuhit.md.DictionaryService;
import pkuhit.xap.me.MeCdRuService;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import xap.sv.servlet.mvc.annotation.RequestParam;

public class AmrQAItmServiceImpl implements AmrQAItmService {
	
	@Reference
	DictionaryService dictionaryService;
	
	@Reference
	MeCdRuService meCdRuService;
	
	@Autowired
	CusQaFltItmDao cusQaFltItmDao;
	
	@Autowired
	CusQaDivideDao cusQaDivideDao;
	
	@Autowired
	QaDivideLevelDao qaDivideLevelDao;
	
	@Autowired
	QaItmFstDao qaItmFstDao;
	
	@Autowired
	QaItmSndDao qaItmSndDao;
	
	@Autowired
	private QaItmDao qaItmDao;
	
	@Autowired
	private CusQaItemnDao cusQaItemnDao;
	
	@Override
	public SingleResult<QaItemCreateInit> createQaItmInit(
			Map<String, String> value) throws Throwable {
		SingleResult<QaItemCreateInit> result;
		SingleResultBuilder<QaItemCreateInit> builder = SingleResultBuilder
				.newSingleResult(QaItemCreateInit.class);
		QaItemCreateInit qaItemCreateInit = new QaItemCreateInit();
		Map<String, String> map = new HashMap<String, String>();
		qaItemCreateInit.setQaItmSndCategory(this
				.getAmrItmSndCategoryCd(map).getDataList());
		qaItemCreateInit.setQaItmFstCategory(this
				.getAmrScoreCategory(EncounterType.INPATIENT));
		builder.withData(qaItemCreateInit);
		result = builder.build();
		return result;
	}
	
	/**
	 * 评分项目二级分类
	 * 
	 * @param enTypeCd
	 * @return
	 */
	public ArrayResult<QaItmSndCategory> getAmrItmSndCategoryCd(
			Map<String, String> value) {

		ArrayResult<QaItmSndCategory> result = null;
		List<QaItmSndCategory> amrItmSnds = new ArrayList<QaItmSndCategory>();
		ArrayResultBuilder<QaItmSndCategory> builder = ArrayResultBuilder
				.newArrayResult(QaItmSndCategory.class);
		String qaItmFst = value.get("qaItmFst");
		List<QaItmSnd> qaItmSndList = cusQaFltItmDao.selectQaSndItm(qaItmFst);
		for (QaItmSnd qaItmSnd : qaItmSndList) {
			QaItmSndCategory amrItmSnd = new QaItmSndCategory();
			BeanCopyUtil.entityToModel(amrItmSnd, qaItmSnd,null,
					dictionaryService);
			amrItmSnds.add(amrItmSnd);
		}
		if (qaItmSndList.size() > 0) {
			builder.withData(amrItmSnds.toArray(new QaItmSndCategory[0]));
		}
		result = builder.build();
		result.setTotal(qaItmSndList.size());
		return result;
	}
	
	/**
	 * 评分项目一级分类
	 * 
	 * @param enTypeCd
	 * @return
	 */
	public List<QaItmFstCategory> getAmrScoreCategory(
			String enTypeCd) {
		List<QaItmFstCategory> amrScoreCategorys = new ArrayList<QaItmFstCategory>();
		List<QaItmFst> qaItmFstList = cusQaFltItmDao.selectQaFltItm();
		for (QaItmFst qaItmFst : qaItmFstList) {
			QaItmFstCategory amrScoreCategory = new QaItmFstCategory();
			BeanCopyUtil.entityToModel(amrScoreCategory, qaItmFst,
					null, dictionaryService);
			amrScoreCategorys.add(amrScoreCategory);
		}
		return amrScoreCategorys;
	}

	/**
	 * 病案等级查询
	 * @param enTypeCd
	 * @return
	 */
	@Override
	public List<QaDivideLevelModel> searchQaDivideLevel(
			Map<String, String> value) throws Throwable {
		List<QaDivideLevelModel> qaDivideLevelModelList = new ArrayList<QaDivideLevelModel>();
		List<Map<String, Object>> qaDivideLevelList = cusQaDivideDao.selectQaDivideLevel();
		Map<String, Object> mapQaDivideLevel = null;
		if(null != qaDivideLevelList){
			if(qaDivideLevelList.size()>0){
				for(int i=0;i<qaDivideLevelList.size();i++){
						QaDivideLevelModel qaDivideLevelModel = new QaDivideLevelModel();
						mapQaDivideLevel = qaDivideLevelList.get(i);
						BeanCopyUtil.mapToModel(qaDivideLevelModel, mapQaDivideLevel,dictionaryService);
						qaDivideLevelModelList.add(qaDivideLevelModel);
					}
				}
			
			}
		return qaDivideLevelModelList;
	}

	@Override
	public QaDivideSetModel searchQaDivideLevelById(
			Map<String, String> value) throws Throwable {
		String qaDivideLevelCd = value.get("qaDivideLevelCd");
		QaDivideSetModel qaDivideLevelModel = new QaDivideSetModel();
		QaDivideLevel qaDivideLevel = null;
		if(!qaDivideLevelCd.equals("undefined")){
			qaDivideLevel = qaDivideLevelDao.selectById(qaDivideLevelCd);
			if(qaDivideLevel != null){
				BeanCopyUtil.entityToModel(qaDivideLevelModel, qaDivideLevel, null, dictionaryService);
			}
			return qaDivideLevelModel;
		}else{
			return null;
		}
		
	}

	@Override
	public SingleResult<QaDivideSetModel> delQaDivideLevelById(String qaDivideLevelCd) throws Throwable {
		QaDivideLevel qaDivideLevel= qaDivideLevelDao.selectById(qaDivideLevelCd);
		qaDivideLevel.setDelF((short)1);
		qaDivideLevelDao.markDelete(qaDivideLevel);
		return SingleResultBuilder.newSingleResult(QaDivideSetModel.class).build();
	}
	
	@Override
	public String VaidatorQaDivideLevelByLvl(String qaDivideLevelCd)
			throws Throwable {
		String str = "0";
		QaDivideLevel qaDivideLevel= qaDivideLevelDao.selectById(qaDivideLevelCd);
		if(qaDivideLevel != null){
			str = "1";
		}
		return str;
	}
	
	@Override
	public SingleResult<QaDivideSetModel> createLvl(
			QaDivideSetModel value) {
		QaDivideLevel qaDivideLevel= cusQaDivideDao.selectLevelById(value.getQaDivideLevelCd());
		if(qaDivideLevel == null){
			QaDivideLevel qaDivideLevelNew =new QaDivideLevel();
			if(value.getQaDivideLevelCd() != null){
				qaDivideLevelNew.setQaDivideLevelCd(value.getQaDivideLevelCd());
			}
			if(value.getLvl() != null){
				qaDivideLevelNew.setLvl(value.getLvl());
			}
			if(value.getMinScr() != null){
				qaDivideLevelNew.setMinScr(value.getMinScr());
			}
			if(value.getMaxScr() != null){
				qaDivideLevelNew.setMaxScr(value.getMaxScr());
			}
			qaDivideLevelDao.insertExludeNull(qaDivideLevelNew);
		}else{
			qaDivideLevel.setDelF((short)0);
			if(value.getMinScr() != null){
				qaDivideLevel.setMinScr(value.getMinScr());
			}
			if(value.getMaxScr() != null){
				qaDivideLevel.setMaxScr(value.getMaxScr());
			}
			qaDivideLevelDao.updateExcludeNull(qaDivideLevel);
		}
		return SingleResultBuilder.newSingleResult(QaDivideSetModel.class).build();
	}

	@Override
	public SingleResult<QaDivideSetModel> updateLvl(String qaDivideLevelCd,
			QaDivideSetModel value) {
		QaDivideLevel qaDivideLevel= qaDivideLevelDao.selectById(qaDivideLevelCd);
		if(value.getMinScr() != null){
			qaDivideLevel.setMinScr(value.getMinScr());
		}
		if(value.getMaxScr() != null){
			qaDivideLevel.setMaxScr(value.getMaxScr());
		}
		qaDivideLevelDao.updateExcludeNull(qaDivideLevel);
		return SingleResultBuilder.newSingleResult(QaDivideSetModel.class).build();
	}

	@Override
	public List<QaItmFstCategory> getQaItmFstCategory(
			@RequestParam Map<String, String> value) throws Throwable {
		List<QaItmFstCategory> amrScoreCategorys = new ArrayList<QaItmFstCategory>();
		List<QaItmFst> qaItmFstList = cusQaFltItmDao.selectQaFltItm();
		for (QaItmFst qaItmFst : qaItmFstList) {
			QaItmFstCategory amrScoreCategory = new QaItmFstCategory();
			BeanCopyUtil.entityToModel(amrScoreCategory, qaItmFst,
					null, dictionaryService);
			amrScoreCategorys.add(amrScoreCategory);
		}
		return amrScoreCategorys;
	}

	@Override
	public QaItmFstCategory searchQaItmFstById(Map<String, String> value)
			throws Throwable {
		String fstCd = value.get("fstCd");
		QaItmFstCategory qaItmFstCategory = new QaItmFstCategory();
		QaItmFst qaItmFst = null;
		if(!fstCd.equals("undefined")){
			qaItmFst = qaItmFstDao.selectById(fstCd);
			if(qaItmFst != null){
				BeanCopyUtil.entityToModel(qaItmFstCategory, qaItmFst, null, dictionaryService);
			}
			return qaItmFstCategory;
		}else{
			return null;
		}
		
	}

	@Override
	public SingleResult<QaItmFstCategory> delQaItmFstById(
			String fstCd) throws Throwable {
		QaItmFst qaItmFst= qaItmFstDao.selectById(fstCd);
		qaItmFst.setDelF((short)1);
		qaItmFstDao.markDelete(qaItmFst);
		List<QaItmSnd> qaItmSndList = cusQaFltItmDao.selectQaSndItm(fstCd);
		for (QaItmSnd qaItmSnd : qaItmSndList) {
			String sndCd = qaItmSnd.getSndCd();
			QaItmSnd qaItmSndNew= qaItmSndDao.selectById(sndCd);
			qaItmSndNew.setDelF((short)1);
			qaItmSndDao.markDelete(qaItmSndNew);
			// 查询质控项目
			List<QaItm> qaItmList = cusQaItemnDao.searchQaItem(fstCd, sndCd);
			for (QaItm qaitm : qaItmList) {
				String qaItmCd = qaitm.getQaItmCd();
				QaItm qaItm = qaItmDao.selectById(qaItmCd);
				qaItm.setDelF((short)1);
				qaItmDao.markDelete(qaItm);
			}
		}
		return SingleResultBuilder.newSingleResult(QaItmFstCategory.class).build();
	}
	@Override
	public SingleResult<QaItmFstCategory> createFst(
			QaItmFstCategory value) {
		QaItmFst qaItmFst= cusQaDivideDao.selectFstById(value.getFstCd());
		if(qaItmFst == null){
			QaItmFst qaItmFstNew= new QaItmFst();
			String fstCd = meCdRuService.selectById("QAM14.AT01").getId();
			qaItmFstNew.setFstCd(fstCd);
			if(value.getNm() != null){
				qaItmFstNew.setNm(value.getNm());
			}
			if(value.getScore() != null){
				qaItmFstNew.setScore(value.getScore());
			}
			if(value.getMemo() != null){
				qaItmFstNew.setMemo(value.getMemo());
			}
			qaItmFstDao.insertExludeNull(qaItmFstNew);
		}else{
			qaItmFst.setDelF((short)0);
			if(value.getNm() != null){
				qaItmFst.setNm(value.getNm());
			}
			if(value.getScore() != null){
				qaItmFst.setScore(value.getScore());
			}
			if(value.getMemo() != null){
				qaItmFst.setMemo(value.getMemo());
			}
			qaItmFstDao.updateExcludeNull(qaItmFst);
		}
		return SingleResultBuilder.newSingleResult(QaItmFstCategory.class).build();
	}

	@Override
	public SingleResult<QaItmFstCategory> updateFst(String fstCd,
			QaItmFstCategory value) {
		QaItmFst qaItmFst= qaItmFstDao.selectById(fstCd);
		if(value.getNm() != null){
			qaItmFst.setNm(value.getNm());
		}
		if(value.getScore() != null){
			qaItmFst.setScore(value.getScore());
		}
		if(value.getMemo() != null){
			qaItmFst.setMemo(value.getMemo());
		}
		qaItmFstDao.updateExcludeNull(qaItmFst);
		return SingleResultBuilder.newSingleResult(QaItmFstCategory.class).build();
	}

	@Override
	public String VaidatorQaItmFstByNm(String nm)
			throws Throwable {
		String str = "0";
		QaItmFst qaItmFst= cusQaFltItmDao.selectQaItmFstByNm(nm);
		if(qaItmFst != null){
			str = "1";
		}
		return str;
	}
	
//	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public SingleResult<Map> qaItmFstTree(Map<String, String> condition) {
		// 返回结果map
		Map mapResult = new HashMap();
		SingleResult<Map> result = new SingleResult<Map>();
		mapResult.put("text", "root");
		// 住院
		String encounterPk = condition.get("encounterPk");
		String enTpCd = EncounterType.INPATIENT;
		List<QaItmFst> qaItmFstList = cusQaFltItmDao.selectQaFltItm();
		List<Map> mapChilds = new ArrayList<Map>();
		if (null != qaItmFstList && qaItmFstList.size() > 0) {
			/*Map all = new HashMap();
//			all.put("id", "");
			all.put("text", qaItmFstList.get(qaItmFstList.size() - 1).getNm());
			all.put("leaf", true);
			mapChilds.add(all);*/
			for (int i = 0; i < qaItmFstList.size(); i++) {
				Map mapChild = new HashMap();
				mapChild.put("id", qaItmFstList.get(i).getFstCd());
				mapChild.put("text", qaItmFstList.get(i).getNm()+"("+qaItmFstList.get(i).getScore() + "分)");
				mapChild.put("leaf", true);
				mapChilds.add(mapChild);
			}
			mapResult.put("expanded", "true");
			mapResult.put("children", mapChilds);
		}
		result.setData(mapResult);
		return result;
	}
	
	@Override
	public QaItmSndCategory searchQaItmSndById(Map<String, String> value)
			throws Throwable {
		String sndCd = value.get("sndCd");
		QaItmSndCategory qaItmSndCategory = new QaItmSndCategory();
		QaItmSnd qaItmSnd = null;
		if(!sndCd.equals("undefined")){
			qaItmSnd = qaItmSndDao.selectById(sndCd);
			if(qaItmSnd != null){
				BeanCopyUtil.entityToModel(qaItmSndCategory, qaItmSnd, null, dictionaryService);
			}
			return qaItmSndCategory;
		}else{
			return null;
		}
		
	}
	
	@Override
	public SingleResult<QaItmSndCategory> delQaItmSndById(
			String sndCd) throws Throwable {
		QaItmSnd qaItmSnd= qaItmSndDao.selectById(sndCd);
		String fstCd = qaItmSnd.getFstCd();
		qaItmSnd.setDelF((short)1);
		qaItmSndDao.markDelete(qaItmSnd);
		List<QaItm> qaItmList = cusQaItemnDao.searchQaItem(fstCd, sndCd);
		for (QaItm qaitm : qaItmList) {
			String qaItmCd = qaitm.getQaItmCd();
			QaItm qaItm = qaItmDao.selectById(qaItmCd);
			qaItm.setDelF((short)1);
			qaItmDao.markDelete(qaItm);
		}
		return SingleResultBuilder.newSingleResult(QaItmSndCategory.class).build();
	}
	
	@Override
	public String VaidatorQaItmSndByNm(Map<String,String> value)
			throws Throwable {
		String str = "0";
		String nm = value.get("nm");
		String fstCd = value.get("fstCd");
		String score = value.get("score");
		BigDecimal sndScore = new BigDecimal(String.valueOf(score));
		QaItmSnd qaItmSnd= cusQaFltItmDao.selectQaItmSndByNm(nm);
		if(qaItmSnd != null){
			str = "1";
		}
		QaItmFst qaItmFst= qaItmFstDao.selectById(fstCd);
		BigDecimal fstScore = qaItmFst.getScore();
		if(sndScore.compareTo(fstScore) == 1){
			str = "2";
		}
		return str;
	}
	
	@Override
	public SingleResult<QaItmSndCategory> createSnd(
			QaItmSndCategory value) {
		
		QaItmSnd qaItmSnd= cusQaDivideDao.selectSndById(value.getSndCd());
		if(qaItmSnd == null){
			QaItmSnd qaItmSndNew= new QaItmSnd();
			String sndCd = meCdRuService.selectById("QAM15.AT01").getId();
			qaItmSndNew.setSndCd(sndCd);
			if(value.getFstCd() != null){
				qaItmSndNew.setFstCd(value.getFstCd());
			}
			if(value.getNm() != null){
				qaItmSndNew.setNm(value.getNm());
			}
			if(value.getScore() != null){
				qaItmSndNew.setScore(value.getScore());
			}
			qaItmSndDao.insertExludeNull(qaItmSndNew);
		}else{
			qaItmSnd.setDelF((short)0);
			if(value.getFstCd() != null){
				qaItmSnd.setFstCd(value.getFstCd());
			}
			if(value.getNm() != null){
				qaItmSnd.setNm(value.getNm());
			}
			if(value.getScore() != null){
				qaItmSnd.setScore(value.getScore());
			}
			qaItmSndDao.updateExcludeNull(qaItmSnd);
		}
		return SingleResultBuilder.newSingleResult(QaItmSndCategory.class).build();
	}

	@Override
	public SingleResult<QaItmSndCategory> updateSnd(String sndCd,
			QaItmSndCategory value) {
		QaItmSnd qaItmSnd= qaItmSndDao.selectById(sndCd);
		if(value.getFstCd() != null){
			qaItmSnd.setFstCd(value.getFstCd());
		}
		if(value.getNm() != null){
			qaItmSnd.setNm(value.getNm());
		}
		if(value.getScore() != null){
			qaItmSnd.setScore(value.getScore());
		}
		qaItmSndDao.updateExcludeNull(qaItmSnd);
		return SingleResultBuilder.newSingleResult(QaItmSndCategory.class).build();
	}

	@Override
	public SingleResult<Map> qaItmTree(@RequestParam Map<String, String> condition) {
		// 返回结果map
		Map mapResult = new HashMap();
		SingleResult<Map> result = new SingleResult<Map>();
		mapResult.put("text", "root");
		
		List<QaItmFst> qaItmFstList = cusQaFltItmDao.selectQaFltItm();
//		List<MdMrTpCcat> mdMrTpCcatList = cusMdMrTpCcatDao.selectSortTree(enTpCd, encounterPk);

		List<Map> mapChilds = new ArrayList<Map>();
		if (null != qaItmFstList && qaItmFstList.size() > 0) {
			for (int i = 0; i < qaItmFstList.size(); i++) {
				// 得到分类下的文书列表
				List<QaItmSnd> mrlist = cusQaFltItmDao.selectQaSndItm(qaItmFstList.get(i).getFstCd());
				
				Map mapChild = new HashMap();
				mapChild.put("sndCd", qaItmFstList.get(i).getFstCd());
				mapChild.put("text", qaItmFstList.get(i).getNm() +"("+qaItmFstList.get(i).getScore() + "分)");

				List<Map> mrMaps = new ArrayList<Map>();
				if (mrlist.size() > 0) {
					for (int j = 0; j < mrlist.size(); j++) {
					    //得到文书创建时间，转换格式
					    //Timestamp crtTime = mrlist.get(j).getSubmitDate();
						Map mrMap = new HashMap();
						mrMap.put("sndCd", mrlist.get(j).getSndCd());
						mrMap.put("text", mrlist.get(j).getNm()+"("+mrlist.get(j).getScore() + "分)");
						mrMap.put("leaf", true);
						mrMaps.add(mrMap);
					}
					mapChild.put("children", mrMaps);
				} else {
					mapChild.put("leaf", true);
				}
				mapChilds.add(mapChild);
			}
			mapResult.put("expanded", "true");
			mapResult.put("children", mapChilds);
		}
		result.setData(mapResult);
		return result;
	}

}
