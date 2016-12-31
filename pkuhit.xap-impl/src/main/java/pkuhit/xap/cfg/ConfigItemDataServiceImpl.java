package pkuhit.xap.cfg;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import pkuhit.md.DictionaryService;
import pkuhit.xap.dao.auto.XapCfgDataDao;
import pkuhit.xap.dao.auto.entity.XapCfgData;
import pkuhit.xap.dao.custom.CustomXapCfgDataDao;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
 

public class ConfigItemDataServiceImpl implements ConfigItemDataService {
   
	@Autowired
	XapCfgDataDao configItemDataDao;
	@Reference
	DictionaryService dictionaryService;
	@Autowired
	CustomXapCfgDataDao customCapCfgDataDao;
	@Override
	public int create(ConfigItemData configItemData) {
		// TODO Auto-generated method stub
		XapCfgData xapCfgData = new XapCfgData();
		BeanCopyUtil.modelToEntity(xapCfgData, configItemData);
		return configItemDataDao.insert(xapCfgData);
	}

	@Override
	public int update(ConfigItemData configItemData) {
		// TODO Auto-generated method stub
		XapCfgData xapCfgData = new XapCfgData();
		BeanCopyUtil.modelToEntity(xapCfgData, configItemData);
		return configItemDataDao.updateExcludeNull(xapCfgData);
	}

	@Override
	public int delete(ConfigItemData configItemData) {
		// TODO Auto-generated method stub
		XapCfgData xapCfgData = new XapCfgData();
		BeanCopyUtil.modelToEntity(xapCfgData, configItemData);
		return configItemDataDao.markDelete(xapCfgData);
	}

	@Override
	public ConfigItemData selectById(String id) {
		// TODO Auto-generated method stub
		Assert.hasText(id, "PathVariable.value must not be empty");
		XapCfgData xapCfgData = new XapCfgData();
		ConfigItemData configItemData = new ConfigItemData();
		xapCfgData = configItemDataDao.selectById(id);
		BeanCopyUtil.entityToModel(configItemData,xapCfgData,configItemData.OBJ_CD,dictionaryService);
		return configItemData;
	}
	
	
     @Override
	public SingleResult<ConfigItemData> search(Map<String,String> params){
    	 SingleResult<ConfigItemData>  arrayResult= new SingleResult<ConfigItemData>();
    	List<XapCfgData> list = customCapCfgDataDao.selectCfgDataList(params.get("orgCode"), params.get("configCode"));
    	 if(list != null){
    		 ConfigItemData[] xapCfgDatas= new ConfigItemData[list.size()] ;
    		  int i =0;
    		for(XapCfgData xapCfgDate:list){
    			ConfigItemData configItemdata = new ConfigItemData();
    			BeanCopyUtil.entityToModel(configItemdata, xapCfgDate, configItemdata.OBJ_CD, dictionaryService);
    			xapCfgDatas[i] = configItemdata;
    			i++;
    			arrayResult.setData(configItemdata);
    	 }
    		
		return arrayResult;
     }
        return null;
  }
}