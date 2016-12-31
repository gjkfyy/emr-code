package pkuhit.md;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.md.dao.auto.entity.MdDi;
import pkuhit.md.dao.custom.CustomMdDiDao;
import pkuhit.org.dao.auto.entity.Org;
import pkuhit.org.dao.auto.entity.WardDept;
import pkuhit.org.dao.custom.CustomOrgDao;

/**
 * 通用主数据之外的字典查询服务。
 * 
 * 目前支持：
 * 部门列表查询
 * 诊断字典查询
 * @author wu.junhui
 *
 */
public class ComplexDictionaryQueryService implements DictionaryQueryService {

	@Autowired
	CustomOrgDao customOrgDao = null;
	
	@Autowired
	CustomMdDiDao customMdDiDao = null;
	
	@Override
	public Dictionary[] execute(DictionaryQueryCondition condition) {
		//■ 获得查询条件
		String id = (String) condition.get("id");
		String keyword = null;
		if (condition != null && condition.get("keyword") != null) {
			keyword = ((String) condition.get("keyword")).trim().toUpperCase();
		} 
		
		//■ 查询符合条件的数据
		//如果id=='ownerCdLoad', 查询科室列表
		//如果id=='diagnosisCdLoad', 查询诊断字典列表
		Dictionary dict = new Dictionary();
		dict.setId(id);
		Dictionary.SimpleItem item = null;
		if ("ownerCdLoad".equals(id)) {
			List<WardDept> deptList = this.customOrgDao.selectDeptList(keyword,null,null,null);
			for (int i = 0; i < deptList.size(); i++) {
				item = new Dictionary.SimpleItem();
				//item.put("code", deptList.get(i).getOrgCd()); // 兼容 
				item.put(Dictionary.SimpleItem.VALUE_KEY, deptList.get(i).getDeptCd());
				
				//item.put("dept", deptList.get(i).getNm()); // 兼容 
				item.put(Dictionary.SimpleItem.TEXT_KEY, deptList.get(i).getNm());
				dict.addItem(item);
			}
			
		} else if ("diagnosisCdLoad".equals(id)) {
			List<MdDi> mdDiList = this.customMdDiDao.selectMdDiList(keyword);
			for (int i = 0; i < mdDiList.size(); i++) {
				item = new Dictionary.SimpleItem();
				//item.put("abbr", mdDiList.get(i).getDiCd()); // 兼容 
				item.put(Dictionary.SimpleItem.VALUE_KEY, mdDiList.get(i).getDiCd());
				
				//item.put("name", mdDiList.get(i).getNm()); // 兼容 
				item.put(Dictionary.SimpleItem.TEXT_KEY, mdDiList.get(i).getNm());
				dict.addItem(item);
			}
		} else {
			return null;
		}
		
		//■ 返回结果 
		Dictionary[] ret = new Dictionary[1];
		ret[0] = dict;
		return ret;
	}

}
