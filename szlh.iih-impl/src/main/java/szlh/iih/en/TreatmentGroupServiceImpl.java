/**
 * 
 */
package szlh.iih.en;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.en.TreatmentGroupMemberModel;
import pkuhit.iih.en.TreatmentGroupService;
import szlh.iih.en.dao.TreatmentGroupMemberDao;
import szlh.iih.en.po.TreatmentGroupMemberPo;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;

/**
 * @author guo_zhongbao
 * 诊疗组成员服务接口
 */
public class TreatmentGroupServiceImpl implements TreatmentGroupService {
	@Autowired
	TreatmentGroupMemberDao treatmentGroupMemberDao;
	
	/**
	 * 根据就诊PK和用户ID获得用户在诊疗组中的信息 
	 * @param enPk 就诊序号
	 * @param empId 人员ID
	 * @return TreatmentGroupMember
	 */
	/* (non-Javadoc)
	 * @see pkuhit.iih.en.TreatmentGroupService#getTreatmentGroupMember(java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayResult<TreatmentGroupMemberModel> getTreatmentGroupMember(String enPk,
			String empId) {
		if(StringUtils.isBlank(enPk)){
			enPk = null ;
		}
		if(StringUtils.isBlank(empId)){
			empId = null ;
		}
		 List<TreatmentGroupMemberPo> poList = null;// treatmentGroupMemberDao.getTreatmentGroupMember(enPk, empId);
		 TreatmentGroupMemberModel[] voArray = null ;
		 ArrayResultBuilder<TreatmentGroupMemberModel> builder = ArrayResultBuilder.newArrayResult(TreatmentGroupMemberModel.class);
		 int total = 0;
		 if(null != poList){
			 voArray = new TreatmentGroupMemberModel[poList.size()];
			 int i = 0;
			 for(TreatmentGroupMemberPo po : poList){
				 TreatmentGroupMemberModel vo = new TreatmentGroupMemberModel();
				 BeanUtils.copyProperties( po,vo);
				 voArray[i]= vo;
				 i++;
			 }
			 total = poList.size();
			 builder.withData(voArray);
		 }
		 ArrayResult<TreatmentGroupMemberModel> rs = builder.build();
		 rs.setTotal(total);
		return rs;
	}

}
