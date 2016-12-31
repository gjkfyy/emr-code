package pkuhit.iih.qa.qacustom;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import pkuhit.iih.mr.md.dao.auto.MdMrTpDao;
import pkuhit.iih.mr.md.dao.auto.entity.MdMrTp;
import pkuhit.iih.qa.CusQaAutoItmConfig;
import pkuhit.iih.qa.QaItem;
import pkuhit.iih.qa.dao.auto.QaAutoItmConfigDao;
import pkuhit.iih.qa.dao.auto.QaItmDao;
import pkuhit.iih.qa.dao.auto.QaItmSndDao;
import pkuhit.iih.qa.dao.auto.entity.QaAutoItmConfig;
import pkuhit.iih.qa.dao.auto.entity.QaItm;
import pkuhit.iih.qa.dao.auto.entity.QaItmSnd;
import pkuhit.iih.qa.dao.qacustom.CusQaAutoItmConfigDao;
import pkuhit.iih.qa.dao.qacustom.CusQaItemnDao;
import pkuhit.md.DictionaryService;
import pkuhit.xap.me.MeCdRuService;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import xap.sv.servlet.mvc.annotation.ModelAttribute;

public class QaItemServiceImpl implements QaItemService {

	@Reference
	pkuhit.iih.mr.qasys.QaItemService  qaItemService;//qaSysService;

	
	@Reference
	private DictionaryService dictionnaryService;
	
	@Reference
	MeCdRuService meCdRuService;
	
	@Autowired
	private CusQaItemnDao cusQaItemnDao;
	
	@Autowired
	private QaItmDao qaItmDao;
	
	@Autowired
	QaItmSndDao qaItmSndDao;
	
	@Autowired
	QaAutoItmConfigDao qaAutoItmDao;
	
	@Autowired
	MdMrTpDao mdMrTpDao;	
	
	@Autowired
	private CusQaAutoItmConfigDao cusQaAutoItmDao;
	
	public QaItemServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pkuhit.iih.mr.qasys.QaItemService#search(java.util.Map)
	 */
	@Override
	public ArrayResult<QaItem> search(Map condition) throws Throwable {
		
		ArrayResultBuilder<QaItem> builder = ArrayResultBuilder
				.newArrayResult(QaItem.class);
		//记录总条数
		int total = 0;
		
		if(null != condition){
			String itemFirstCode = "1";
			String itemSecondCode = "";
			
			if(condition.containsKey("qaItmFst")){
				itemFirstCode = condition.get("qaItmFst").toString();
			}
			if(condition.containsKey("qaItmSnd")){
				itemSecondCode = condition.get("qaItmSnd").toString();
			}
			// 查询质控项目
			List<Map<String, Object>> searchQaItems = cusQaItemnDao.searchQaItemList(
					itemFirstCode, itemSecondCode);
			
			total = searchQaItems.size();
			if (total > 0) {
				QaItem[] qaItems = new QaItem[total];
				for (int i = 0; i < total; i++) {
					QaItem qaItem = new QaItem();
					Map<String, Object> qaItmMap = searchQaItems.get(i);
					// 拷贝属性
					BeanCopyUtil.mapToModel(qaItem, qaItmMap,dictionnaryService);
					qaItems[i] = qaItem;
				}
				builder.withData(qaItems);
			}
		}
		ArrayResult<QaItem> rs = builder.build();
		rs.setTotal(total);
		return rs;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public QaItem searchByQaItmCd(Map condition) throws Throwable {
		String qaItmCd = condition.get("qaItmCd").toString();
		QaItem qaItem = new QaItem();
		QaItm qaItm = null;
		if(!qaItmCd.equals("undefined")){
			qaItm = qaItmDao.selectById(qaItmCd);
			if(qaItm != null){
				BeanCopyUtil.entityToModel(qaItem, qaItm, null, dictionnaryService);
			}
			return qaItem;
		}else{
			return null;
		}
		
	}

	@Override
	public SingleResult<QaItem> createQaItm(QaItem value) {
		QaItm qaItm = cusQaItemnDao.selectQaItmById(value.getQaItmCd());
		BigDecimal onceDrpScr = value.getOnceDrpScr();
		String qaDrpScrTpCd = value.getQaDrpScrTpCd();
		/*String deductDes = "";
		if(qaDrpScrTpCd.equals("QAM02.01")){
			deductDes = onceDrpScr.toString();
		}else if(qaDrpScrTpCd.equals("QAM02.02")){
			deductDes = onceDrpScr.toString() + "/项";
		}else if(qaDrpScrTpCd.equals("QAM02.03")){
			deductDes ="乙级";
		}else if(qaDrpScrTpCd.equals("QAM02.04")){
			deductDes ="丙级";
		}*/
		if(qaItm == null){
			QaItm qaItmNew= new QaItm();
			BeanCopyUtil.modelToEntity(qaItmNew, value);
			String qaItmCd = meCdRuService.selectById("QAM16.AT01").getId();
			qaItmNew.setQaItmCd(qaItmCd);
//			qaItmNew.setDeductDes(deductDes);
			qaItmDao.insertExludeNull(qaItmNew);
		}else{
			qaItm.setDelF((short)0);
//			qaItm.setDeductDes(deductDes);
			BeanCopyUtil.modelToEntity(qaItm, value);
			qaItmDao.updateExcludeNull(qaItm);
		}
		return SingleResultBuilder.newSingleResult(QaItem.class).build();
	}

	@Override
	public SingleResult<QaItem> updateQaItm(String qaItmCd,
			@ModelAttribute QaItem value) {
		QaItm qaItm = qaItmDao.selectById(qaItmCd);
		BigDecimal onceDrpScr = value.getOnceDrpScr();
		String qaDrpScrTpCd = value.getQaDrpScrTpCd();
		BigDecimal maxDrpScr = value.getMaxDrpScr();
		
		/*String deductDes = "";
		if(qaDrpScrTpCd.equals("QAM02.01")){
			deductDes = onceDrpScr.toString();
		}else if(qaDrpScrTpCd.equals("QAM02.02")){
			deductDes = onceDrpScr.toString() + "/项";
		}else if(qaDrpScrTpCd.equals("QAM02.03")){
			deductDes ="乙级";
		}else if(qaDrpScrTpCd.equals("QAM02.04")){
			deductDes ="丙级";
		}*/
		if(qaItm != null){
			BeanCopyUtil.modelToEntity(qaItm, value);
		}
		
//		qaItm.setDeductDes(deductDes);
		qaItmDao.updateExcludeNull(qaItm);
		if(maxDrpScr == null){
			QaItm qaItm1 = qaItmDao.selectById(qaItmCd);
			qaItm1.setMaxDrpScr(maxDrpScr);
			qaItmDao.update(qaItm1);
		}
		return SingleResultBuilder.newSingleResult(QaItem.class).build();
	}

	@Override
	public SingleResult<QaItem> delQaItmById(@PathVariable("id") String qaItmCd)
			throws Throwable {
		QaItm qaItm = qaItmDao.selectById(qaItmCd);
		if(qaItm != null){
			qaItm.setDelF((short)1);
			qaItmDao.markDelete(qaItm);
		}
		return SingleResultBuilder.newSingleResult(QaItem.class).build();
	}

	@Override
	public String VaidatorQaItm(Map<String, String> value)
			throws Throwable {
		String str = "0";
		String sndCd = value.get("sndCd");
		String onceDrpScr = value.get("onceDrpScr");
		QaItmSnd qaItmSnd= qaItmSndDao.selectById(sndCd);
		BigDecimal sndScore = qaItmSnd.getScore();
		BigDecimal onceDrpScore = new BigDecimal(String.valueOf(onceDrpScr));
		if(onceDrpScore.compareTo(sndScore) == 1){
			str = "2";
		}
		return str;
	}
	
	@Override
	public SingleResult<CusQaAutoItmConfig> createQaAutoItm(CusQaAutoItmConfig value) {
		String qaItmTpCd = value.getQaItmTpCd();
		if(qaItmTpCd.equals(CusQaAutoItmConfig.DEPENDENT)){
			MdMrTp mdMrTp = mdMrTpDao.selectById(value.getQaItmCd());
			mdMrTp.setMemo("1");
			mdMrTpDao.updateExcludeNull(mdMrTp);
		}
		QaAutoItmConfig qaAutoItm = qaAutoItmDao.selectById(value.getQaItmConfigCd());
		BigDecimal qaRlCd = value.getQaRlCd();
		if(qaAutoItm == null){
			QaAutoItmConfig qaAutoItmNew= new QaAutoItmConfig();
			BeanCopyUtil.modelToEntity(qaAutoItmNew, value);
			String qaItmConfigCd = meCdRuService.selectById("QAM18.AT01").getId();
			qaAutoItmNew.setQaItmConfigCd(qaItmConfigCd);
			if(qaRlCd != null){
				qaAutoItmNew.setQaRlCd(qaRlCd.toString());
			}
			qaAutoItmDao.insertExludeNull(qaAutoItmNew);
		}else{
			qaAutoItm.setDelF((short)0);
			BeanCopyUtil.modelToEntity(qaAutoItm, value);
			if(qaRlCd != null){
				qaAutoItm.setQaRlCd(qaRlCd.toString());
			}
			qaAutoItmDao.updateExcludeNull(qaAutoItm);
		}
		return SingleResultBuilder.newSingleResult(CusQaAutoItmConfig.class).build();
	}
	
	
	@Override
	public CusQaAutoItmConfig searchAutoByQaItmCd(Map condition) throws Throwable {
		String qaItmCd = condition.get("qaItmCd").toString();
		CusQaAutoItmConfig cusQaAutoItmConfig = new CusQaAutoItmConfig();
		QaAutoItmConfig qaAutoItmConfig = null;
		if(!qaItmCd.equals("undefined")){
			qaAutoItmConfig = cusQaAutoItmDao.selectByQaItmCd(qaItmCd);
			if(qaAutoItmConfig != null){
				BeanCopyUtil.entityToModel(cusQaAutoItmConfig, qaAutoItmConfig, null, dictionnaryService);
				if(qaAutoItmConfig.getQaRlCd() != null){
					cusQaAutoItmConfig.setQaRlCd(new BigDecimal(qaAutoItmConfig.getQaRlCd()));
				}
			}
			return cusQaAutoItmConfig;
		}else{
			return null;
		}
		
	}
}
