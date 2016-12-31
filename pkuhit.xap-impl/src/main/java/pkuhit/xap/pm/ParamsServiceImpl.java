package pkuhit.xap.pm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.md.DictionaryService;
import pkuhit.xap.dao.auto.entity.XapParam;
import pkuhit.xap.dao.custom.CustomXapParamDao;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.annotation.Reference;
import xap.sv.component.LifeCycleComponent;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;

public class ParamsServiceImpl implements ParamsService,LifeCycleComponent {
	
	@Autowired
	ParamsSetService paramsSetService;
	@Autowired
	CustomXapParamDao customXapParamDao;
	
	@Reference
    DictionaryService dictionaryService;
	
	public Map<String, List<Param>> paramMap = new HashMap<String, List<Param>>();
	
	@Override
	public ArrayResult<Param> getParam(String code) {
		// TODO Auto-generated method stub
		ArrayResultBuilder<Param> builder = ArrayResultBuilder.newArrayResult(Param.class);
		Param[] voArray = new Param[0];
		List<Param> list = paramMap.get(code);
		if (list != null) {
			voArray = new Param[list.size()];
			for(int i = 0 ; i < list.size() ; i++){
				Param po = list.get(i);
				voArray[i]=po ;
			}
		}
		builder.withData(voArray);
		return builder.build();
	}

	@Override
	public void putParam(Param param) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDestory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("pageNum", "1");
		map.put("pageSize", "1000");
		ArrayResult<Param> list = paramsSetService.search(map);
		if (list != null && list.getDataList() != null) {
			for (Param param : list.getDataList()) {
				if (param != null && param.getCode() != null && paramMap.get(param.getCode())!= null) {
					paramMap.get(param.getCode()).add(param);
				}else if (param != null && param.getCode() != null && paramMap.get(param.getCode())== null) {
					List<Param> paramList = new ArrayList<Param>();
					paramList.add(param);
					paramMap.put(param.getCode(), paramList);
				}
			}
		}
	}

	@Override
	public void updateParamsByCode(String code) {
		// TODO Auto-generated method stub
		
		List<XapParam> poList = null;
        if(code!=null && code.length()!=0){
        	poList = customXapParamDao.selectXapParamByCode(code);
        }
        
//        if (paramMap.get(code) != null) {
		List<Param> list = new ArrayList<Param>();
		
		for (XapParam xapParam : poList) {
			Param param = new Param();
			BeanCopyUtil.entityToModel(param, xapParam, null, dictionaryService);
			list.add(param);
		}
		paramMap.put(code, list);
//		}
	}

}
