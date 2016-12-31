package pkuhit.xap.ei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.md.DictionaryService;
import pkuhit.xap.dao.custom.CustomXapExternalInterfDao;
import xap.sv.annotation.Reference;
import xap.sv.component.LifeCycleComponent;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;

public class ExternalInterfServiceImpl implements ExternalInterfService,LifeCycleComponent {
	
	@Autowired
	ExternalInterfSetService externalInterfSetService;
	@Autowired
	CustomXapExternalInterfDao customXapExternalInterfDao;
	
	@Reference
    DictionaryService dictionaryService;
	
	public Map<String, List<ExterInterf>> exterInterfMap = new HashMap<String, List<ExterInterf>>();
	


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
		ArrayResult<ExterInterf> list = externalInterfSetService.search(map);
		cacheExternalInterf(list);
		System.out.println("缓存对外接口url============"+exterInterfMap);
	}


	@Override
	public ArrayResult<ExterInterf> getExternalInterf(String code) {

		// TODO Auto-generated method stub
		ArrayResultBuilder<ExterInterf> builder = ArrayResultBuilder.newArrayResult(ExterInterf.class);
		ExterInterf[] voArray = new ExterInterf[0];
		List<ExterInterf> list = exterInterfMap.get(code);
		if (list != null) {
			voArray = new ExterInterf[list.size()];
			for(int i = 0 ; i < list.size() ; i++){
				voArray[i]=list.get(i) ;
			}
		}
		builder.withData(voArray);
		return builder.build();
	
	}
	

	@Override
	public void cacheExternalInterf(ArrayResult<ExterInterf> list) {
		// TODO Auto-generated method stub
		exterInterfMap.clear();
		if (list != null && list.getDataList() != null) {
			for (ExterInterf exterInterf : list.getDataList()) {
				if (exterInterf != null && exterInterfMap.get(exterInterf.getExterInterfCd())!= null) {
					exterInterfMap.get(exterInterf.getExterInterfCd()).add(exterInterf);
				}else if (exterInterf != null && exterInterfMap.get(exterInterf.getExterInterfCd())== null) {
					List<ExterInterf> exterInterfList = new ArrayList<ExterInterf>();
					exterInterfList.add(exterInterf);
					exterInterfMap.put(exterInterf.getExterInterfCd(), exterInterfList);
				}
			}
		}
	}

}
