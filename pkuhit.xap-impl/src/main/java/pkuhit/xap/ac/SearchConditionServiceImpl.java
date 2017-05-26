package pkuhit.xap.ac;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import pkuhit.xap.dao.auto.IemrSearchConditionDao;
import pkuhit.xap.dao.auto.entity.IemrSearchCondition;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.util.UUIDGenerator;
public class SearchConditionServiceImpl implements SearchConditionService
{
    @Autowired
    IemrSearchConditionDao iemrSearchConditionDao;


	@Override
	public ArrayResult<Condition> search(Map<String, String> params) {
		//■ 查询数据
        String pageNum = null;
		String pageSize = null;
		if (params.containsKey("pageNum") && params.containsKey("pageSize")) {
			pageNum = (String) params.get("pageNum");
			pageSize = (String) params.get("pageSize");
		}
		if (org.apache.commons.lang3.StringUtils.isBlank(pageNum)) {
			pageNum = "1";
		}
		if (org.apache.commons.lang3.StringUtils.isBlank(pageSize)) {
			pageSize = "20";
		}
		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum) - 1) * Integer.valueOf(pageSize))
				.limit(Integer.valueOf(pageSize)).count();

		String userId = getParamValue(params, "userId");
        List<IemrSearchCondition> list = iemrSearchConditionDao.selectIemrSearchConditionById(userId, options);
        
        //■　装配并返回
        ArrayResultBuilder<Condition> builder = ArrayResultBuilder.newArrayResult(Condition.class);
        int size = 0;
        if (list != null && list.size() > 0)
        {
        	Condition[] conditionList = new Condition[list.size()];
            int i = 0;
            for (IemrSearchCondition iemrSearchCondition : list)
            {
            	conditionList[i] = this.wrapData(iemrSearchCondition);
                i++;
            }
            
            builder.withData(conditionList);
            size = conditionList.length;
        }
        
        ArrayResult<Condition> arrayResult = builder.build();
        arrayResult.setTotal(size);
        return arrayResult;
	}

	@Override
	public Condition insert(Condition condition) {
		
		IemrSearchCondition iemrSearchCondition = new IemrSearchCondition();
		//BeanCopyUtil.modelToEntity(iemrSearchCondition, condition);   //不知道为什么不能复制属性
		BeanUtils.copyProperties(condition, iemrSearchCondition);
		
		
		iemrSearchCondition.setId(UUIDGenerator.getUUID());
		iemrSearchCondition.setDelF((short)0);
		iemrSearchCondition.setCrtTime(new Timestamp(new Date().getTime()));
		iemrSearchConditionDao.insert(iemrSearchCondition);
		
		return condition;
	}


	@Override
	public ArrayResult<Condition> delete(String id) {
		IemrSearchCondition iemrSearchCondition = new IemrSearchCondition();
		iemrSearchCondition.setId(id);
		iemrSearchCondition.setDelF((short)1);
		iemrSearchConditionDao.update(iemrSearchCondition);
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("pageNum", "1");
		params.put("pageSize", "20");
		return search(params);
	}
	
	 private Condition wrapData(IemrSearchCondition iemrSearchCondition) {
		 	Condition condition = new Condition();
	    	//BeanCopyUtil.entityToModel(condition, iemrSearchCondition, null, null);
		 	BeanUtils.copyProperties(iemrSearchCondition, condition);
	    	return condition;
	 }
	
	
	 String getParamValue(Map<String, String> params, String paramName){
	        String value = params.get(paramName);
	        if (!StringUtils.hasText(value))
	        {
	            return null;
	        }
	        return value;
	 }



}
