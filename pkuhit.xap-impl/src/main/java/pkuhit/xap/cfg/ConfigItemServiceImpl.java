package pkuhit.xap.cfg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import pkuhit.md.DictionaryService;
import pkuhit.xap.dao.auto.XapCfgDao;
import pkuhit.xap.dao.auto.entity.XapCfg;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.annotation.Reference;

public class ConfigItemServiceImpl implements ConfigItemService {

	@Autowired
	XapCfgDao xapCfgDao;
	
	@Reference
	DictionaryService dictionaryService;
	
	@Override
	public int create(ConfigItem configItem) {
		// TODO Auto-generated method stub
		XapCfg xapcfg = new XapCfg();
		BeanCopyUtil.modelToEntity(xapcfg, configItem);
		return xapCfgDao.insert(xapcfg);
	}

	@Override
	public int update(ConfigItem configItem) {
		// TODO Auto-generated method stub
		XapCfg xapcfg = new XapCfg();
		BeanCopyUtil.modelToEntity(xapcfg, configItem);
		return  xapCfgDao.updateExcludeNull(xapcfg);
	}

	@Override
	public int delete(ConfigItem configItem) {
		// TODO Auto-generated method stub
		XapCfg xapcfg = new XapCfg();
		BeanCopyUtil.modelToEntity(xapcfg, configItem);
		return xapCfgDao.markDelete(xapcfg);
	}

	@Override
	public ConfigItem selectById(String id) {
		// TODO Auto-generated method stub
		 Assert.hasText(id, "PathVariable.value must not be empty");
		 ConfigItem configItem = new ConfigItem();
		 XapCfg xapcfg  = xapCfgDao.selectById(id);
		 BeanCopyUtil.entityToModel(configItem, xapcfg, configItem.OBJ_CD, dictionaryService);
		return configItem;
	}
}
