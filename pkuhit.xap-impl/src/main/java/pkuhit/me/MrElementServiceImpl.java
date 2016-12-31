/**
 * 
 */
package pkuhit.me;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.me.dao.auto.MeObjDao;
import pkuhit.me.dao.auto.entity.MeObj;
import pkuhit.me.dao.auto.entity.MeObjAttr;
import pkuhit.me.dao.custom.CustomMeObjAttrDao;
import pkuhit.xap.pub.Constants;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;

/**
 * @author wu.junhui
 *
 */
public class MrElementServiceImpl implements MrElementService {
	@Autowired
	CustomMeObjAttrDao customMeObjAttrDao;
	
	@Autowired
	MeObjDao meObjDao;
	
	/* (non-Javadoc)
	 * @see pkuhit.me.MrElementService#getElements(java.util.Map)
	 */
	@Override
	public ArrayResult<MrElement> getElements(Map<String, String> condition) {
		//■　获取参数
		String keyword = condition.get("keyword");
		String type = condition.get("type");
		
		Integer pageNum = null; 
		Integer pageSize = null; 
		if(condition.containsKey("pageNum") && condition.containsKey("pageSize")){ 
			pageNum = Integer.valueOf(condition.get("pageNum")); 
			pageSize = Integer.valueOf(condition.get("pageSize")); 
		} 
		if(null == pageNum ||  null == pageSize) 
		{ 
			pageNum= 1; 
			pageSize = Constants.DEFAULT_PAGE_SIZE; 
		} 
		
		//■　数据查询
		SelectOptions options = SelectOptions.get().offset((pageNum-1)*pageSize)
				.limit(pageSize).count();
		
		List<MeObjAttr> objAttrList = customMeObjAttrDao.selectAllObjectAttribute(keyword, type, options);
		
		
		//■　返回结果
		ArrayResultBuilder<MrElement> builder = ArrayResultBuilder.newArrayResult(MrElement.class);
		if(objAttrList.size()>0){
			MrElement[]  voArray = new MrElement[objAttrList.size()];
			int i = 0 ;
			for(MeObjAttr po :objAttrList){
				MrElement vo = wrapElement(po);
				voArray[i] = vo ;
				i++;
			}
			builder.withData(voArray);
		}
		ArrayResult<MrElement> rs = builder.build();
		rs.setTotal((int)options.getCount());
		return rs;
	}

	private MrElement wrapElement(MeObjAttr meObjAttr) {
		MrElement mrElement = new MrElement();
		
		mrElement.setObjAttrCd(meObjAttr.getObjAttrCd());
		mrElement.setObjAttrNm(meObjAttr.getNm());
		
		//值域对象编码
		mrElement.setFkObjCd(meObjAttr.getFkObjCd());
		
		//描述
		mrElement.setDes(meObjAttr.getDes());
		
		//数据对象编码
		String objectCode = meObjAttr.getObjCd();
		mrElement.setObjCd(objectCode);
		
		//数据对象名称
		MeObj meObj = this.meObjDao.selectById(objectCode);
		if (meObj != null) {
			mrElement.setObjNm(meObj.getNm());
		}
		
		return mrElement;
	}
}
