package pkuhit.xap.ei;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.jdbc.SelectOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.md.DictionaryService;
import pkuhit.xap.dao.auto.entity.XapExterInterf;
import pkuhit.xap.dao.custom.CustomXapExternalInterfDao;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;

public class ExternalInterfSetServiceImpl implements ExternalInterfSetService{
	
	final static Logger logger = LoggerFactory.getLogger(ExternalInterfSetServiceImpl.class);
	
    @Autowired
    CustomXapExternalInterfDao customXapExternalInterfDao;
    
    
    @Reference
    DictionaryService dictionaryService;
    
    @Reference
    ExternalInterfService  externalInterfService;
    

   

    @Override
    public ArrayResult<ExterInterf> search(Map<String, String> params){
        //■　装配并返回
        ArrayResultBuilder<ExterInterf> builder = ArrayResultBuilder.newArrayResult(ExterInterf.class);
        /*分页实现部分*/
        long total = 0;
        String pageNum = null; 
        String pageSize = null; 
        if(params.containsKey("pageNum") && params.containsKey("pageSize")){ 
            pageNum = (String)params.get("pageNum"); 
            pageSize = (String)params.get("pageSize"); 
        } 
        if(null == pageNum || !StringUtils.isNumeric(pageNum) || null == pageSize || !StringUtils.isNumeric(pageSize) ) { 
            pageNum= "1"; 
            pageSize = "100"; 
        }
        SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();
        List<XapExterInterf> poList  = customXapExternalInterfDao.selectXapExternalInterList(options);
        if(poList.size() > 0){
            ExterInterf[] voArray = new ExterInterf[poList.size()];
            ExterInterf vo = null;
            for(int i = 0 ; i < poList.size() ; i++){
            	XapExterInterf po = poList.get(i);
                vo = new ExterInterf();
                BeanCopyUtil.entityToModel(vo, po, null, dictionaryService);
                voArray[i]=vo ;
            }
            builder.withData(voArray);
            total = options.getCount();
        }else{
            ArrayResult<ExterInterf> rs = builder.build();
            rs.setPageNum(Integer.valueOf(pageNum));
            rs.setPageSize(Integer.valueOf(pageSize));
            rs.setTotal(0);
        }
        ArrayResult<ExterInterf> rs = builder.build();
        rs.setPageNum(Integer.valueOf(pageNum));
        rs.setPageSize(Integer.valueOf(pageSize));
        rs.setTotal(Long.valueOf(total).intValue());
        return rs;
    }
   
  
    
    @Override
    public ArrayResult<ExterInterf> refresh(Map<String, String> params){
        //查询
    	Map<String, String> map = new HashMap<String, String>();
		map.put("pageNum", "1");
		map.put("pageSize", "1000");
		ArrayResult<ExterInterf> list = search(map);
     
        //将所有的数据元都刷入内存中
        externalInterfService.cacheExternalInterf(list);
        return list;
    }
}
