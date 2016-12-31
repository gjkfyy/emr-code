package pkuhit.xap.cfg;

import org.springframework.beans.factory.annotation.Autowired;




import org.springframework.util.Assert;

import pkuhit.md.DictionaryService;
import pkuhit.xap.dao.auto.XapCfgOptnDao;
import pkuhit.xap.dao.auto.entity.XapCfgOptn;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.annotation.Reference;


public class ConfigItemOptionServiceImpl implements ConfigItemOptionService {
   
	@Autowired
	XapCfgOptnDao xapCfgOptnDao;
	@Reference
	DictionaryService dictionaryService;
	@Override
	public int create(ConfigItemOption configItemOption) {
		// TODO Auto-generated method stub
		XapCfgOptn xapCfgOptn = new XapCfgOptn();
		BeanCopyUtil.modelToEntity(xapCfgOptn, configItemOption);
		return xapCfgOptnDao.insert(xapCfgOptn);
	}

	@Override
	public int update(ConfigItemOption configItemOption) {
		// TODO Auto-generated method stub
		XapCfgOptn xapCfgOptn = new XapCfgOptn();
		BeanCopyUtil.modelToEntity(xapCfgOptn, configItemOption);
		return xapCfgOptnDao.updateExcludeNull(xapCfgOptn);
	}

	@Override
	public int delete(ConfigItemOption configItemOption) {
		// TODO Auto-generated method stub
		XapCfgOptn xapCfgOptn = new XapCfgOptn();
		BeanCopyUtil.modelToEntity(xapCfgOptn, configItemOption);
		return xapCfgOptnDao.markDelete(xapCfgOptn);
	}

	@Override
	public ConfigItemOption selectById(String id) {
		// TODO Auto-generated method stub
		Assert.hasText(id, "PathVariable.value must not be empty");
		XapCfgOptn xapCfgOptn = xapCfgOptnDao.selectById(id);
		ConfigItemOption configItemOption = new ConfigItemOption();
		BeanCopyUtil.entityToModel(configItemOption, xapCfgOptn, configItemOption.OBJ_CD, dictionaryService);
		return  configItemOption;
	}

}
