package ei.ass.di.mz.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.jdbc.SelectOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.di.DiagnosisModel;
import pkuhit.iih.di.his.HisDiagnosis;
import pkuhit.iih.di.his.HisDiagnosisListModel;
import pkuhit.xap.util.PerformancePrinter;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import ei.ass.di.auto.po.DiagnosisPo;
import ei.ass.di.auto.po.MzPatientDiagnosisEntity;
import ei.ass.di.mz.dao.MzPatientDiagnosisEntityDao;
import ei.ass.di.mz.dao.MzSplitDiDao;
import ei.ass.di.mz.service.MzSplitDiagnosisService;

public class MzSplitDiagnosisServiceImpl implements MzSplitDiagnosisService {

	final static Logger logger = LoggerFactory.getLogger(MzSplitDiagnosisServiceImpl.class);
	@Autowired
	MzSplitDiDao diDao ;
	@Autowired
	MzPatientDiagnosisEntityDao entityDao ;
	
	/* (non-Javadoc)
	 * @see pkuhit.iih.di.DiagnosisService#search(java.lang.String)
	 */
	@Override
	public SingleResult<DiagnosisModel> search(String diPk) {
		DiagnosisPo po = diDao.getDibDiDetail(diPk);
		DiagnosisModel vo = new DiagnosisModel() ;
		SingleResultBuilder<DiagnosisModel> builder = SingleResultBuilder.newSingleResult(DiagnosisModel.class);
		if(null != po){
			BeanUtils.copyProperties( po,vo);
			builder.withData(vo);
		}
		return builder.build();
	
	}

	/* (non-Javadoc)
	 * @see pkuhit.iih.di.DiagnosisService#search(java.util.Map)
	 */
	@Override
	public ArrayResult<DiagnosisModel> search(String patient_id,String times, String isMainF,String onlyNotStop, String currentPageIndex , String pageSize ) {
		logger.debug("patient_id:"+patient_id+",times:"+times+",isMainF:"+isMainF+",onlyNotStop:"+onlyNotStop+",currentPageIndex:"+currentPageIndex+",pageSize:"+pageSize);
		if(null == currentPageIndex || !StringUtils.isNumeric(currentPageIndex)   || null == pageSize || !StringUtils.isNumeric(pageSize)  )
		{
			currentPageIndex= "1";
			pageSize = "1000";
		}
		String onlyMainF = null ;
		if(null != isMainF && (isMainF.equalsIgnoreCase("true")|| isMainF.equalsIgnoreCase("1"))){
			onlyMainF = "1";
		}
		ArrayResultBuilder<DiagnosisModel> builder = ArrayResultBuilder.newArrayResult(DiagnosisModel.class);
		int total = 0;

		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(currentPageIndex)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();			

			
			List<DiagnosisPo> poList = this.diDao.getDisListByEnSn(patient_id,times,onlyMainF,onlyNotStop,options);
			long count = options.getCount();
			 total = Long.valueOf(count).intValue();
			DiagnosisModel[] voArray = null ;
	
			if(null != poList){
				 voArray = new DiagnosisModel[poList.size()];
				 int i = 0;
				 int j = 1 ;
				 for(DiagnosisPo po : poList){
					 DiagnosisModel vo = new DiagnosisModel();
					 BeanUtils.copyProperties( po,vo);
					 if(null != vo.getDiNm()){
						 vo.setLongDiNm(String.valueOf(j)+"."+vo.getDiNm());
						 if("1".equalsIgnoreCase(vo.getUncF())){
							 vo.setLongDiNm(vo.getLongDiNm()+"（？）");
						 }
						 if("1".equalsIgnoreCase(vo.getUnkF())){
							 vo.setLongDiNm(vo.getLongDiNm()+"（待查）"); 
						 }
					 }
					 voArray[i]= vo;
					 i++;
					 j++;
				 }
				builder.withData(voArray);
			}

		ArrayResult<DiagnosisModel> rs = builder.build();
		rs.setTotal(total);
		return rs;
	}

	
	
	@Override
	public void saveOrUpdateDiagnosis(HisDiagnosisListModel src,
			String patient_id, String times) {
		// TODO Auto-generated method stub
		logger.debug("南京鼓楼版本使用该方法，同步诊断到HIS中...");
		String enPk = patient_id+"_"+times ;
		ArrayResult<DiagnosisModel> hisDiArrayResult = search(patient_id,times,null,null,null,null);
		//HIS数据库数据
		DiagnosisModel[] dstList = new  DiagnosisModel[0];
		if(null == hisDiArrayResult || null == hisDiArrayResult.getDataList() || 0 == hisDiArrayResult.getDataList().length){
			//return ;
		}else{
			dstList = hisDiArrayResult.getDataList();
		}
		//源数据
		List<HisDiagnosis> srcList = src.getList();
		this.compareLists(srcList, dstList, patient_id, times);
	}
	
	/**
	 * @author guo_zhongbao
	 * @param srcList 更新源
	 * @param dstArr 更新目标
	 * @return 比对结果需要执行的sqlMap
	 * srcList  新增更新，dstList从His中查询出现有的诊断。
	 * 以诊断编码作为比对标准，src dst都存在则更新。src存在dst不存在，则新增。src不存在dst存在，则删除。
	 * 最后更新下 His的主诊断记录
	 * */
	private void compareLists(List<HisDiagnosis> srcList,DiagnosisModel[]  dstArr,String patient_id,String times){

		Map rsMap =new HashMap();
		HisDiagnosis[] a ;		
		//待删除的对象列表
		List<DiagnosisModel> dstListToDelete = new ArrayList<DiagnosisModel>(dstArr.length) ;
		for(int i = 0 ; i < dstArr.length ; i++){
			dstListToDelete.add(dstArr[i]) ;
		}
		
		List<DiagnosisModel> dstListToUpdate = new ArrayList<DiagnosisModel>();
		//Collections.copy(dstListToDelete, dstList); ;//Arrays.asList(dstList.toArray(a));;
		//待增加的对象列表
		List<HisDiagnosis> srcListToAdd = new ArrayList<HisDiagnosis>(srcList.size()) ;
		srcListToAdd.addAll(srcList) ;
		List<HisDiagnosis> srcListToUpdate = new ArrayList<HisDiagnosis>();
		//Collections.copy(srcListToAdd, srcList); //Arrays.asList(dstList.toArray(a));;		
		List<String> sqlList = new ArrayList<String>();
		//更新对象列表
		List<MzPatientDiagnosisEntity> updateEntityList = new ArrayList<MzPatientDiagnosisEntity>();
		//新增对象列表
		List<MzPatientDiagnosisEntity> addEntityList = new ArrayList<MzPatientDiagnosisEntity>();
		//删除对象列表
		List<MzPatientDiagnosisEntity> deleteEntityList = new ArrayList<MzPatientDiagnosisEntity>();
		//对目标进行循环，如果是源中存在，则从待删除中删除，也从待增加中删除
		for(DiagnosisModel dstHisDiagnosis: dstListToDelete){
			String dstDiagCode = dstHisDiagnosis.getDiCd() ;
			for(HisDiagnosis srcHisDiagnosis: srcListToAdd){
				String srcDiagCode = srcHisDiagnosis.getDiagCode() ;
					if(dstDiagCode.equalsIgnoreCase(srcDiagCode)){
						logger.debug("His sn:"+ dstHisDiagnosis.getDiPk()+ " 中的diCode:"+dstDiagCode +" == 要保存 中的diCode:"+dstDiagCode);
						//如果在源，目标中都存在，则删除
						//dstListToDelete.remove(dstHisDiagnosis) ;
						dstListToUpdate.add(dstHisDiagnosis);
						srcListToUpdate.add(srcHisDiagnosis);
						//srcListToAdd.remove(srcHisDiagnosis) ;
						//生成update 对象 加入到update 列表
						MzPatientDiagnosisEntity updateEntity = updateModify(dstHisDiagnosis,srcHisDiagnosis) ;
						if(null != updateEntity){
							updateEntityList.add(updateEntity);
						}
					}else{
						logger.debug("His sn:"+ dstHisDiagnosis.getDiPk()+ " 中的diCode:"+dstDiagCode +" <>  要保存 中的diCode:"+dstDiagCode);
					}
				}
		}
		dstListToDelete.removeAll(dstListToUpdate) ;
		srcListToAdd.removeAll(srcListToUpdate) ;
		//新增实体
		for(HisDiagnosis srcHisDiagnosis: srcListToAdd){
			addEntityList.add(addEntity(srcHisDiagnosis, patient_id, times));
		}
		//开始新增，更新，删除
		if(!addEntityList.isEmpty()){
		//新增
		entityDao.batchInsert(addEntityList);
		}
		//更新
		for( MzPatientDiagnosisEntity entity:  updateEntityList){
			logger.debug("更新 sn:"+entity.getSn());
			entityDao.updateExcludeNull(entity) ;
		}
		//删除实体		
		for( DiagnosisModel model:  dstListToDelete){
			MzPatientDiagnosisEntity deleteEntity  = entityDao.selectById(Integer.valueOf(model.getDiPk())) ;
			logger.debug("更新 sn:"+deleteEntity.getSn());
			entityDao.delete(deleteEntity) ;
		}


	
	}
	
	/**
	 * 根据源 目标对象，生成update sql字符串
	 * @param dstHisDiagnosis 目标对象
	 * @param srcHisDiagnosis 源对象
	 * @return 更新字符串
	 * */
    private MzPatientDiagnosisEntity updateModify(DiagnosisModel dstHisDiagnosis,HisDiagnosis srcHisDiagnosis)
    {
    	MzPatientDiagnosisEntity updateEntity = null ;
    	String src_MainFlag  = srcHisDiagnosis.getMainFlag();
    	String dst_MainFlag  = dstHisDiagnosis.getMainF();
    	String src_lv1sortNo = srcHisDiagnosis.getLv1sortNo() ;
    	String dst_lv1sortNo =  dstHisDiagnosis.getLvl1SortNo() ;
    	String src_lv2sortNo = srcHisDiagnosis.getLv2sortNo() ;
    	String dst_lv2sortNo =  dstHisDiagnosis.getLvl2SortNo() ;
    	if(src_MainFlag.equalsIgnoreCase(dst_MainFlag) && src_lv1sortNo.equalsIgnoreCase(dst_lv1sortNo) && src_lv2sortNo.equalsIgnoreCase(dst_lv2sortNo) ){
    		logger.debug("His sn:"+ dstHisDiagnosis.getDiPk()+ " 中的MainFlag:"+dst_MainFlag +" == 要保存 中的MainFlag:"+src_MainFlag);
    		logger.debug("His sn:"+ dstHisDiagnosis.getDiPk()+ " 中的lv1sortNo:"+dst_lv1sortNo +" == 要保存 中的lv1sortNo:"+src_lv1sortNo);
    		logger.debug("His sn:"+ dstHisDiagnosis.getDiPk()+ " 中的MainFlag:"+dst_lv2sortNo +" == 要保存 中的lv2sortNo:"+src_lv2sortNo);
    	}else{
    		logger.debug("His sn:"+ dstHisDiagnosis.getDiPk()+ " 中的MainFlag:"+dst_MainFlag +" <> 要保存 中的MainFlag:"+src_MainFlag);
    		logger.debug("His sn:"+ dstHisDiagnosis.getDiPk()+ " 中的lv1sortNo:"+dst_lv1sortNo +" <> 要保存 中的lv1sortNo:"+src_lv1sortNo);
    		logger.debug("His sn:"+ dstHisDiagnosis.getDiPk()+ " 中的MainFlag:"+dst_lv2sortNo +" <> 要保存 中的lv2sortNo:"+src_lv2sortNo);
    		updateEntity = entityDao.selectById(Integer.valueOf(dstHisDiagnosis.getDiPk())) ;
    		updateEntity.setMainFlag(src_MainFlag);
    		updateEntity.setLv1sortNo(src_lv1sortNo);
    		updateEntity.setLv2sortNo(src_lv2sortNo);
    	}
    	return updateEntity;
    }
    
    private MzPatientDiagnosisEntity  addEntity(HisDiagnosis srcHisDiagnosis,String patient_id,String times){
    	MzPatientDiagnosisEntity addEntity = new  MzPatientDiagnosisEntity();
    	addEntity.setPatientId(patient_id); //患者id
    	addEntity.setTimes(Short.valueOf(times));//就诊次数
    	addEntity.setDoctorSn(srcHisDiagnosis.getDoctorSn());//医生id
    	addEntity.setDeptSn(srcHisDiagnosis.getDeptSn());//科室id
    	addEntity.setDiagStr(srcHisDiagnosis.getDiagStr());//诊断名称
    	addEntity.setDiagCode(srcHisDiagnosis.getDiagCode());//诊断编码
    	addEntity.setIcdCode(srcHisDiagnosis.getIcdCode());//诊断icd编码
    	addEntity.setCommentStr(srcHisDiagnosis.getCommentStr());//注释
    	addEntity.setMainFlag(srcHisDiagnosis.getMainFlag());//主诊断标志
    	addEntity.setUncertainFlag(srcHisDiagnosis.getUncertainFlag());//疑似标志
    	addEntity.setSuspectedFlag(srcHisDiagnosis.getSuspectedFlag());//待查标志
    	addEntity.setLv1sortNo(srcHisDiagnosis.getLv1sortNo());
    	addEntity.setLv2sortNo(srcHisDiagnosis.getLv2sortNo());
    	Date date = srcHisDiagnosis.getInputDate();//
    	SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//
    	long currTime = date.getTime()  ;
    	currTime = currTime - currTime % 1000  ;
    	addEntity.setInputDate(new Timestamp(currTime));//时间
    	StringBuffer sb = new StringBuffer();
    	sb.append("insert into mz_patient_diagnosis(patient_id,times,doctor_sn,dept_sn , diag_str ,diag_code ,icd_code,comment_str,main_flag,uncertain_flag, suspected_flag,lvl1_sort_no,lvl2_sort_no,input_date) values (") ;
    	sb.append("'").append(patient_id).append("'");
    	sb.append(",").append(times);
    	sb.append(",'").append(srcHisDiagnosis.getDoctorSn()).append("'");
    	sb.append(",'").append(srcHisDiagnosis.getDeptSn()).append("'");
    	sb.append(",'").append(srcHisDiagnosis.getDiagStr()).append("'");
    	sb.append(",'").append(srcHisDiagnosis.getDiagCode()).append("'");
    	sb.append(",'").append(srcHisDiagnosis.getIcdCode()).append("'");
    	sb.append(",'").append(srcHisDiagnosis.getCommentStr()).append("'");
    	sb.append(",'").append(srcHisDiagnosis.getMainFlag()).append("'");
    	sb.append(",'").append(srcHisDiagnosis.getUncertainFlag()).append("'");
    	sb.append(",'").append(srcHisDiagnosis.getSuspectedFlag()).append("'");
    	sb.append(",'").append(srcHisDiagnosis.getLv1sortNo()).append("'");
    	sb.append(",'").append(srcHisDiagnosis.getLv2sortNo()).append("'");
    	String date_str=df.format(date);
    	sb.append(",'").append(date_str).append("'");
    	sb.append(")");
    	logger.debug(sb.toString());
    	return addEntity;
    }

	@Override
	public void delDiagnosis(String delDiCode, String mainDiCode,
			String patientId, String times) {
		List<String> diCodeList = new ArrayList<String>();
		diCodeList.add(delDiCode);
		if(!StringUtils.isBlank(mainDiCode)){
			diCodeList.add(mainDiCode);
		}
		PerformancePrinter.start("his getDisListByDicodes");
		List<MzPatientDiagnosisEntity> poList = this.diDao.getDisListByDicodes(patientId,times,diCodeList);
		PerformancePrinter.end("his getDisListByDicodes");
		if(null != poList){
			if(poList.size() > 0){
				//当前删除的诊断
				for(MzPatientDiagnosisEntity po :poList){
					if(!StringUtils.isBlank(mainDiCode) && mainDiCode.equalsIgnoreCase(po.getDiagCode())){
						//如果等于主诊断mainDiCode 等于 实体的诊断，则更新为主诊断
						po.setMainFlag("1");
						PerformancePrinter.start("his updateExcludeNull");
						this.entityDao.updateExcludeNull(po);
						PerformancePrinter.end("his updateExcludeNull");
					}else{
						PerformancePrinter.start("his delete");
						this.entityDao.delete(po);
						PerformancePrinter.end("his delete");
					}
				}
			}
		}
	}

}
