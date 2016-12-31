package pkuhit.iih.di;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.di.bizmodel.DiInModel;
import pkuhit.iih.di.dao.auto.DiInDao;
import pkuhit.iih.di.dao.auto.entity.DiIn;
import pkuhit.iih.di.dao.custom.CusDiInDao;
import pkuhit.md.DictionaryService;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import xap.sv.util.UUIDGenerator;

public class DiInServiceImpl implements DiInService {
	final static Logger logger = LoggerFactory.getLogger(DiInServiceImpl.class);
	
	final Short Level_one = 1; // 第一层级
	final Short Level_two = 2; // 第二层级
	
	@Autowired
	DiInDao diInDao;
	
	@Reference
	DictionaryService dictionaryService;
	
	@Autowired
	CusDiInDao cusDiInDao;

	@Override
	public SingleResult<DiInModel> saveDiIn(DiInModel value) {
		DiIn diIn = new DiIn();
		if(value.getParDiSn().equals("")){
			value.setLvl1SortNo(Level_one);
		}else{
			value.setLvl2SortNo(Level_two);
		}
		String diSn = value.getDiSn();
		if("".equals(diSn)||diSn==null){
			diSn = UUIDGenerator.getUUID();
			List<DiIn> diInList = cusDiInDao.selectDiInsByEnSn(value.getEnSn());
			if(diInList.size()==0){
				value.setMainF((short) 1);
			}else{
				if(value.getMainF() == 1){
					for(DiIn diInNew : diInList){
						DiIn diInOld = cusDiInDao.selectDiInByMainF(value.getEnSn(),(short)1);
						if(diInOld!=null){
							diInOld.setMainF((short)0);
							diInDao.updateExcludeNull(diInOld);
						}
					}
				}
				
			}
			BeanCopyUtil.modelToEntity( diIn,value);
			diIn.setDiSn(diSn);
			diInDao.insertExludeNull(diIn);
		}else{
			short mainF = value.getMainF();
			diIn = diInDao.selectById(diSn);
			short mainFOld = diIn.getMainF();
			if(mainF != mainFOld){//!mainF.equals(mainFOld)
				if(mainF ==((short)1)){ //判断是否修改主诊断 
					DiIn diInOld = cusDiInDao.selectDiInByMainF(value.getEnSn(),(short)1);
					if(diInOld != null){
						diInOld.setMainF((short)0);
						diInDao.updateExcludeNull(diInOld);
					}
				}else{//将主诊断改为非主诊断，查询列表，将第一条作为主诊断
					List<DiIn> diInList = cusDiInDao.selectDiIns(value.getEnSn()); //修改排序
					for(DiIn diInNew : diInList){
						DiIn diInFirst = diInList.get(0);
						diInFirst.setMainF((short)1);
						diInDao.updateExcludeNull(diInFirst);
						break;
					}
				}
			}
			BeanCopyUtil.modelToEntity( diIn,value);
			diInDao.updateExcludeNull(diIn);
		}
		
		return SingleResultBuilder.newSingleResult(DiInModel.class).build();
	}

	@Override
	public List<DiInModel> searchDiInList(String enSn) {
		List<DiIn> diInsList = cusDiInDao.selectDiInsByEnSn(enSn);
		List<DiIn> lvs = new LinkedList<DiIn>();// 重新组装的诊断列表
		List<DiIn> lv1s = new LinkedList<DiIn>();// level是1的诊断列表
		// <parDiSn, 子诊断列表>
		List<DiIn> lv2ParSnDis = new LinkedList<DiIn>();
		for (DiIn di : diInsList) {
			if (null != di.getLvl1SortNo() && Level_one == di.getLvl1SortNo()) {// 找到级别为1的诊断
				lv1s.add(di);
			} else if (null != di.getLvl2SortNo() && Level_two == di.getLvl2SortNo()) {// 将级别为2的诊断加入map
				// lv2ParSnDis
				lv2ParSnDis.add(di);
			}
		}
		for(DiIn di : lv1s){
			String diSn = di.getDiSn();
			lvs.add(di);
			for(DiIn diSon : lv2ParSnDis){
				String parDiSn = diSon.getParDiSn();
				if(diSn.equals(parDiSn)){
					lvs.add(diSon);
				}
			}
		}
		
		List<DiInModel> diInModelList = new ArrayList<DiInModel>();
		for (DiIn diIn : lvs) {
			DiInModel diInModel = new DiInModel();
			BeanCopyUtil.entityToModel(diInModel, diIn,"", dictionaryService);
			diInModelList.add(diInModel);
		}
		return diInModelList;
	}

	@Override
	public SingleResult<DiInModel> delDiIn(String diSn)
			throws Throwable {
		DiIn diIn = diInDao.selectById(diSn);
		short mainF = diIn.getMainF();
		String enSn = diIn.getEnSn();
		if(diIn != null){
			//查询子诊断并删除
			List<DiIn> diInSonList = cusDiInDao.selectDiInSon(diSn);
			if(diInSonList.size()>0){
				for(DiIn diInSon : diInSonList){
					diInSon.setDelF((short)1);
					diInDao.markDelete(diInSon);
				}
			}
			diIn.setDelF((short)1);
			diInDao.markDelete(diIn);
			if(mainF == (short)1){ //如果删除的是主诊断，则将第一条设置为主诊断
				List<DiIn> diInList = cusDiInDao.selectDiIns(enSn); //修改排序
				for(DiIn diInNew : diInList){
					DiIn diInFirst = diInList.get(0);
					diInFirst.setMainF((short)1);
					diInDao.updateExcludeNull(diInFirst);
				}
			}
		}
		return SingleResultBuilder.newSingleResult(DiInModel.class).build();
	}

	@Override
	public ArrayResult<DiagnosisModel> getDiInsListByEnSn(String enSn, Map map) {
		ArrayResultBuilder<DiagnosisModel> builder = ArrayResultBuilder.newArrayResult(DiagnosisModel.class);
		logger.debug("获取诊断列表，就诊序号是" + enSn);
		List<DiIn> diInsList = cusDiInDao.selectDiInsByEnSn(enSn);
		List<DiIn> lvs = new LinkedList<DiIn>();// 重新组装的诊断列表
		List<DiIn> lv1s = new LinkedList<DiIn>();// level是1的诊断列表
		// <parDiSn, 子诊断列表>
		List<DiIn> lv2ParSnDis = new LinkedList<DiIn>();
		for (DiIn di : diInsList) {
			if (null != di.getLvl1SortNo() && Level_one == di.getLvl1SortNo()) {// 找到级别为1的诊断
				lv1s.add(di);
			} else if (null != di.getLvl2SortNo() && Level_two == di.getLvl2SortNo()) {// 将级别为2的诊断加入map
				// lv2ParSnDis
				lv2ParSnDis.add(di);
			}
		}
		for(DiIn di : lv1s){
			String diSn = di.getDiSn();
			lvs.add(di);
			for(DiIn diSon : lv2ParSnDis){
				String parDiSn = diSon.getParDiSn();
				if(diSn.equals(parDiSn)){
					lvs.add(diSon);
				}
			}
		}

		int total = 0 ;
		if(null != lvs && !lvs.isEmpty()){
			DiagnosisModel[] voArray = new DiagnosisModel[lvs.size()];
			total = lvs.size() ;
			for (int index = 0; index < lvs.size() ; index++) {
				DiIn di = lvs.get(index);
				DiagnosisModel m = trans2DiagnosisModel(di,index);
				voArray[index] = m ;
			}
			builder.withData(voArray);
		}
		ArrayResult<DiagnosisModel> rs = builder.build();
		rs.setTotal(total);
		return rs;
	}

	private DiagnosisModel trans2DiagnosisModel(DiIn di, int index) {
		index = index + 1 ;
		DiagnosisModel m = new DiagnosisModel();
		m.setAddInfo(di.getAddDescr());
		m.setDiCd(di.getDiCd());
		m.setDiDeptCd(di.getDiDeptCd());
		m.setDiNm(di.getDiNm());
		m.setDiPk(di.getDiSn());
		m.setDiTime(di.getDiTime());
		m.setDiUserId(di.getDiEmpId());
		m.setEnPk(di.getEnSn());
		m.setIcdCd(di.getIcdCd());
		m.setLongDiNm(String.valueOf(index)+"."+m.getDiNm());
		m.setLvl1SortNo(String.valueOf(di.getLvl1SortNo()));
		m.setLvl2SortNo(String.valueOf(di.getLvl2SortNo()));
		m.setMainF(String.valueOf(di.getMainF()));
		m.setDiTpNm(di.getDiTypeNm());//诊断类型
		m.setNumber(index);
		return m;
	}

}
