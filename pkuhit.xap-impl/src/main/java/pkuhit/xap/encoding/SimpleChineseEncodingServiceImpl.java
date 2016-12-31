package pkuhit.xap.encoding;

import java.util.List;

import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.org.dao.auto.WardDeptDao;
import pkuhit.org.dao.auto.entity.WardDept;
import pkuhit.org.dao.custom.CustomOrgDao;
import xap.sv.model.SingleResult;

public class SimpleChineseEncodingServiceImpl implements
		SimpleChineseEncodingService {
	
	@Autowired
	WardDeptDao wardDeptDao;
	@Autowired
	CustomOrgDao customOrgDao;
	@Autowired
	ChineseEncoding chineseEncoding;
	
	@Override
	public SingleResult<Object> encodingDept() {
		// TODO Auto-generated method stub
		// 1、查询出所有科室
		int pageSize = 200;
		SelectOptions options = SelectOptions.get().offset(0).limit(pageSize).count();
		List<WardDept> list= customOrgDao.selectDeptList(null,null,null,options);
		// 2、根据科室名称生成对应的拼音码
		if (list != null) {
			for (WardDept wardDept : list) {
				String pinyinCode = chineseEncoding.encode(wardDept.getNm());
				pinyinCode = pinyinCode.toLowerCase();
				wardDept.setSpellNo(pinyinCode);
				wardDeptDao.update(wardDept);
			}
		}
		// 3、更新科室
		SingleResult<Object> sigResult= new SingleResult<Object>();
		return sigResult;
	}

}
