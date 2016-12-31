package pkuhit.xap.pm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.jdbc.SelectOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.md.DictionaryService;
import pkuhit.md.dao.auto.entity.MdGs;
import pkuhit.xap.dao.auto.XapParamDao;
import pkuhit.xap.dao.auto.entity.XapParam;
import pkuhit.xap.dao.custom.CustomXapParamDao;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.annotation.Reference;
import xap.sv.i18n.MessageSource;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import xap.sv.util.UUIDGenerator;

public class ParamsSetServiceImpl implements ParamsSetService{
	
	final static Logger logger = LoggerFactory.getLogger(ParamsSetServiceImpl.class);
	
	final String FUNCTION_FLAG_CODE = "SYSM01.0";
	
    @Autowired
    XapParamDao xapParamDao;
    
    @Autowired
    CustomXapParamDao customXapParamDao;

    @Reference
    MessageSource messageSource;
    
    @Reference
    DictionaryService dictionaryService;
    
    @Reference
    ParamsService  paramsService;
    
    @Override
    public Param create(Param param){
        // TODO Auto-generated method stub
        XapParam xapParam = new XapParam();
        BeanCopyUtil.modelToEntity(xapParam, param);
        xapParam.setParamCd(UUIDGenerator.getUUID());
        xapParamDao.insert(xapParam);
        return param;
    }

    @Override
    public SingleResult<Param> update(String paramCd, Param param){
    	//更新用户主信息 
        XapParam xapParam = new XapParam();
        BeanCopyUtil.modelToEntity(xapParam, param);
        xapParamDao.updateExcludeNull(xapParam);
        //■　返回更新后的用户
        SingleResultBuilder<Param> builder = SingleResultBuilder.newSingleResult(Param.class);
        builder.withData(param);
		return builder.build();
    }
    
    @Override
    public SingleResult<Param> delete(String paramCd, Param param){
        // TODO Auto-generated method stub
        XapParam xapParam = xapParamDao.selectById(paramCd);
        xapParam.setDelF(Short.parseShort("1"));
        xapParamDao.markDelete(xapParam);
        BeanCopyUtil.entityToModel(param, xapParam, null, dictionaryService);
        SingleResultBuilder<Param> builder = SingleResultBuilder.newSingleResult(Param.class);
        builder.withData(param);
        return builder.build();
    }

    @Override
    public SingleResult<Param> selectById(String paramCd){
        XapParam xapParam = xapParamDao.selectById(paramCd);
        Param param = new Param();
        BeanCopyUtil.entityToModel(param, xapParam, null, dictionaryService);
        SingleResultBuilder<Param> builder = SingleResultBuilder.newSingleResult(Param.class);
        builder.withData(param);
		return builder.build();
    }

    @Override
    public ArrayResult<Param> search(Map<String, String> params){
        //■　装配并返回
        ArrayResultBuilder<Param> builder = ArrayResultBuilder.newArrayResult(Param.class);
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
            pageSize = "25"; 
        }
        List<String> conditionNmList = new ArrayList<String>();
        String conditionNm = null;
        if(params.containsKey("conditionNm")){
        	Object o = params.get("conditionNm");
        	if(o!=null){
        		conditionNm = (String)o;
        		conditionNm = conditionNm.toLowerCase();
        		if((conditionNm.contains("="))||(conditionNm.contains(" or "))||(conditionNm.contains(" OR "))||(conditionNm.contains(" and "))||(conditionNm.contains(" AND "))||(conditionNm.contains("<"))||(conditionNm.contains(">"))){
        			//防止sql注入，不能传入此类字符
        		}else{
	        		if(conditionNm.indexOf("|")!=-1){
	        			conditionNmList=Arrays.asList(conditionNm.split("|"));
	        		}else if(conditionNm.indexOf(",")!=-1){
	        			conditionNmList=Arrays.asList(conditionNm.split(","));
	        		}else if(conditionNm.indexOf(" ")!=-1){
	        			conditionNmList=Arrays.asList(conditionNm.split(" "));
	        		}else{
	        			conditionNmList.add(conditionNm);
	        		}
        		}
        	}
        }
        String code = null;
        if(params.containsKey("code")){
        	Object o = params.get("code");
        	if(o!=null){
        		code = (String)o;
        	}
        }
        SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();
        List<XapParam> poList  = customXapParamDao.selectXapParamListByCondition(conditionNmList,code,options);
        if(poList.size() > 0){
            Param[] voArray = new Param[poList.size()];
            Param vo = null;
            for(int i = 0 ; i < poList.size() ; i++){
                XapParam po = poList.get(i);
                vo = new Param();
                BeanCopyUtil.entityToModel(vo, po, null, dictionaryService);
                voArray[i]=vo ;
            }
            builder.withData(voArray);
            total = options.getCount();
        }else{
            ArrayResult<Param> rs = builder.build();
            rs.setPageNum(Integer.valueOf(pageNum));
            rs.setPageSize(Integer.valueOf(pageSize));
            rs.setTotal(0);
        }
        ArrayResult<Param> rs = builder.build();
        rs.setPageNum(Integer.valueOf(pageNum));
        rs.setPageSize(Integer.valueOf(pageSize));
        rs.setTotal(Long.valueOf(total).intValue());
        return rs;
    }
    
    @Override
    public SingleResult<Map> findByNm(Map<String, String> params) throws IOException{
        // TODO Auto-generated method stub
        String nm = null;
        String paramCd = null;
        String code = null;
        String key = null;
        if(params.containsKey("nm")){
            nm = (String)params.get("nm"); 
        }
        
        if(params.containsKey("paramCd")){
        	paramCd = (String)params.get("paramCd"); 
        }
        if(params.containsKey("code")){
        	code = (String)params.get("code"); 
        }
        
        if(params.containsKey("key")){
        	key = (String)params.get("key"); 
        }
        logger.info("参数paramcd："+paramCd+"参数nm："+nm+"参数code："+code+"参数key："+key);
        Map mapRs = new HashMap();
        String count = customXapParamDao.selectXapParamNm(nm,paramCd);
        String ckCount = customXapParamDao.selectXapParamCodeAndKey(paramCd,code,key);
        mapRs.put("success", Boolean.TRUE);
        mapRs.put("nmExist", count);
        mapRs.put("ckExist", ckCount);
        SingleResultBuilder<Map> builder = SingleResultBuilder.newSingleResult(Map.class);
        builder.withData(mapRs);
        logger.info("判断名称是否重复："+count+"编码和key："+ckCount);
        return builder.build();
    }
    
    @Override
    public SingleResult<Map> searchByCode(String code){
        //■　装配并返回
    	SingleResultBuilder<Map> builder = SingleResultBuilder.newSingleResult(Map.class);
        List<XapParam> poList = null;
        if(code!=null && code.length()!=0){
        	poList = customXapParamDao.selectXapParamByCode(code);
        }
        if(poList.size() > 0){
        	Map map = new HashMap();
            for(int i = 0 ; i < poList.size() ; i++){
                XapParam po = poList.get(i);
                map.put(po.getKey(),po.getValue()) ;
            }
            builder.withData(map);
        }
        SingleResult<Map> rs = builder.build();
        return rs;
    }
    
    @Override
    public  SingleResult<String> searchFunFlagByKey( String key){
    	SingleResultBuilder<String> builder = SingleResultBuilder.newSingleResult(String.class);
    	//获取code 为 SYSM01.0 的开关项目
        String flag = customXapParamDao.selectXapParamCodeAndKey(null,FUNCTION_FLAG_CODE,key);
        if(flag==null){
        	flag="";
        }
        builder.withData(flag);
        SingleResult<String> rs = builder.build();
        return rs;
    }
    
    /**
     * 
     * @description 根据parOrgCd和orgTpCd查询组织列表
     * @author jiao_xiantong
     * @date 2014年12月5日 下午1:11:16
     * @param params
     * @return
     * @see pkuhit.org.OrganizationService#search(java.util.Map)
     */
    @Override
    public ArrayResult<Param> searchByKeyword(Map<String, String> params)
    {
    	// TODO Auto-generated method stub
    	String keyword = params.get("keyword");
    	String id = params.get("id");
    	int pageSize = 100;
    	if(params.containsKey("pageSize")){
    		pageSize = Integer.parseInt(params.get("pageSize"));
    	}
    	if (keyword != null) {
			keyword = keyword.toLowerCase();
		}
		SelectOptions options = SelectOptions.get().offset(0).limit(pageSize).count();
		System.err.println("keyword="+keyword+"---id="+id+"---options="+options);
    	List<MdGs> list = customXapParamDao.selectMdGsList(keyword,id,options);
    	ArrayResult<Param> arrayResult = new ArrayResult<Param>();
    	if (list != null)
    	{
    		System.err.println("size="+list.size());
    		Param[] paramList = new Param[list.size()];
    		int i = 0;
    		for (MdGs mdGs : list)
    		{
    			Param param = new Param();
    			param.setCode(mdGs.getGsCd());
    			param.setCodeName(mdGs.getNm());
//    			pkuhit.xap.util.BeanCopyUtil.entityToModel(param, mdGs, null, null);
    			paramList[i] = param;
    			i++;
    		}
    		arrayResult.setDataList(paramList);
    	}
    	return arrayResult;
    }
    
    @Override
    public ArrayResult<Param> refresh(Map<String, String> params){
        //■　装配并返回
        ArrayResultBuilder<Param> builder = ArrayResultBuilder.newArrayResult(Param.class);
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
            pageSize = "25"; 
        }
        SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum)-1)*Integer.valueOf(pageSize)).limit(10000).count();
        List<XapParam> arrList = customXapParamDao.selectXapParamList(options);
        //将所有的数据元都刷入内存中
        for(int i = 0 ; i < arrList.size() ; i++){
        	XapParam po = arrList.get(i);
        	if(po.getCode()!=null && po.getCode().length()!=0){
        		paramsService.updateParamsByCode(po.getCode());
        	}
        }
        options = SelectOptions.get().offset((Integer.valueOf(pageNum)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();
        List<XapParam> poList  = customXapParamDao.selectXapParamList(options);
        if(poList.size() > 0){
            Param[] voArray = new Param[poList.size()];
            Param vo = null;
            for(int i = 0 ; i < poList.size() ; i++){
                XapParam po = poList.get(i);
                vo = new Param();
                BeanCopyUtil.entityToModel(vo, po, null, dictionaryService);
                voArray[i]=vo ;
            }
            builder.withData(voArray);
            total = options.getCount();
        }else{
            ArrayResult<Param> rs = builder.build();
            rs.setPageNum(Integer.valueOf(pageNum));
            rs.setPageSize(Integer.valueOf(pageSize));
            rs.setTotal(0);
        }
        ArrayResult<Param> rs = builder.build();
        rs.setPageNum(Integer.valueOf(pageNum));
        rs.setPageSize(Integer.valueOf(pageSize));
        rs.setTotal(Long.valueOf(total).intValue());
        return rs;
    }
}
