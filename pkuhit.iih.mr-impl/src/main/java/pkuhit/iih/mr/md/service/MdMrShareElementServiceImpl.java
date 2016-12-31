package pkuhit.iih.mr.md.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.jdbc.SelectOptions;

import pkuhit.iih.mr.md.HyperlinkTemplate;
import pkuhit.iih.mr.md.MdMrShareElementService;
import pkuhit.iih.mr.md.MetaElement;
import pkuhit.iih.mr.md.MetaElementValue;
import pkuhit.iih.mr.md.MrShareElement;
import pkuhit.iih.mr.md.dao.auto.MdMrShareElementDao;
import pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement;
import pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue;
import pkuhit.iih.mr.md.dao.auto.entity.MdMrShareElement;
import pkuhit.iih.mr.md.dao.custom.CusMdMetaElementDao;
import pkuhit.iih.mr.md.dao.custom.CusMdMetaElementValueDao;
import pkuhit.iih.mr.md.dao.custom.CusMdMrShareElementDao;
import pkuhit.md.DictionaryService;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.annotation.Reference;
import xap.sv.dao.config.DaoConfigProxy;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import xap.sv.util.UUIDGenerator;

/**
 * @author guo_zhongbao
 * 病历模板类型服务接口
 */
public class MdMrShareElementServiceImpl implements MdMrShareElementService {
	
	@Autowired
	CusMdMrShareElementDao cusMdMrShareElementDao;
	
	@Autowired
    MdMrShareElementDao autoDao;
	
	@Autowired
	CusMdMetaElementDao cusMdMetaElementDao;
	
	@Autowired
	CusMdMetaElementValueDao cusMdMetaElementValueDao;
	
	@Reference
	DictionaryService dictionaryService;
	
	
	@Override
	public ArrayResult<MrShareElement> getMrShareElements(String macroFlag,String spellNo) {
		ArrayResult<MrShareElement> result = null;
		ArrayResultBuilder<MrShareElement> builder = ArrayResultBuilder.newArrayResult(MrShareElement.class);
		List<MdMrShareElement> list = cusMdMrShareElementDao.selectByMacroFlag(macroFlag,spellNo.toUpperCase());
		List<MrShareElement> list2=new ArrayList<MrShareElement>();
		for(MdMrShareElement mdMrShareElement:list){
			MrShareElement mrShareElement=new MrShareElement();
			BeanCopyUtil.entityToModel(mrShareElement, mdMrShareElement, "", dictionaryService);
			list2.add(mrShareElement);
		}
		if (list.size() > 0) {
			builder.withData(list2.toArray(new MrShareElement[0]));
		}
		result = builder.build();
		result.setTotal(list.size());
		return result;
	}
	
	@Override
	public ArrayResult<MetaElement> getMetaElements(String metaElementNm,String spellNo) {
		ArrayResult<MetaElement> result = null;
		ArrayResultBuilder<MetaElement> builder = ArrayResultBuilder.newArrayResult(MetaElement.class);
		List<MdMetaElement> list = cusMdMetaElementDao.selectByMetaElementNm(metaElementNm,spellNo.toLowerCase());
		List<MetaElement> list2=new ArrayList<MetaElement>();
		MetaElement metaElement = null;
		for(MdMetaElement mdMetaElement:list){
			metaElement=new MetaElement();
//			BeanCopyUtil.entityToModel(metaElement, mdMetaElement, "", dictionaryService);
			metaElement.setDataElementCd(mdMetaElement.getDataElementCd());
			metaElement.setDataElementNm(mdMetaElement.getDataElementNm());
			list2.add(metaElement);
		}
		if (list2.size() > 0) {
			builder.withData(list2.toArray(new MetaElement[0]));
		}
		result = builder.build();
		result.setTotal(list2.size());
		return result;
	}
	
	@Override
	public ArrayResult<MetaElementValue> getMetaElementsValue(String dataElementCd) {
		ArrayResult<MetaElementValue> result = null;
		ArrayResultBuilder<MetaElementValue> builder = ArrayResultBuilder.newArrayResult(MetaElementValue.class);
		List<MdMetaElementValue> list = cusMdMetaElementValueDao.selectByDataElementCd(dataElementCd);
		List<MetaElementValue> list2=new ArrayList<MetaElementValue>();
		for(MdMetaElementValue mdMetaElement:list){
			MetaElementValue metaElementValue=new MetaElementValue();
			BeanCopyUtil.entityToModel(metaElementValue, mdMetaElement, "", dictionaryService);
			list2.add(metaElementValue);
		}
		if (list2.size() > 0) {
			builder.withData(list2.toArray(new MetaElementValue[0]));
		}
		result = builder.build();
		result.setTotal(list2.size());
		return result;
	}
	
	@Override
    public ArrayResult<MrShareElement> search(Map<String, String> map) {
        String pageNum = null; 
        if(map.get("pageNum") != null){
            pageNum = (String)map.get("pageNum");
        }
        String pageSize = null; 
        if(map.get("pageSize") != null){
            pageSize = (String)map.get("pageSize");
        }
        if(StringUtils.isBlank(pageNum)){
            pageNum = "1" ;
        }
        if(StringUtils.isBlank(pageSize)){
            pageSize = "25" ;
        }
        SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();
        List<MdMrShareElement> lst = cusMdMrShareElementDao.selectAll(options);
        int total = 0 ;
        MrShareElement[] voArray = null;
        ArrayResultBuilder<MrShareElement> builder = ArrayResultBuilder.newArrayResult(MrShareElement.class);
        if(null != lst){
            long count = options.getCount();
            total = Long.valueOf(count).intValue();
            voArray = new MrShareElement[lst.size()];           
             int i = 0;
             for(MdMrShareElement po : lst){
                 MrShareElement vo = new MrShareElement();
                 BeanCopyUtil.entityToModel(vo, po, "", dictionaryService);
                 voArray[i]= vo;
                 vo.setMacroFlag(po.getMacroFlag());
                 i++;
             }
             builder.withData(voArray);
        }
        ArrayResult<MrShareElement> rs = builder.build();
        rs.setTotal(total);
        return rs;
    }
    
    @Override
    public SingleResult<MrShareElement> delete(String id) {
        // TODO Auto-generated method stub
        MdMrShareElement mdMrShareElement = autoDao.selectById(id);
        mdMrShareElement.setDelF((short)1);
        autoDao.markDelete(mdMrShareElement);
        return this.selectByCode(id);
    }
    
    @Override
    public SingleResult<MrShareElement> selectByCode(String id) {
        // TODO Auto-generated method stub
        SingleResultBuilder<MrShareElement> builder = SingleResultBuilder.newSingleResult(MrShareElement.class);
        MdMrShareElement mdMrShareElement = autoDao.selectById(id);
        MrShareElement mrShareElement = new MrShareElement();
        if (null != mdMrShareElement) {
            BeanCopyUtil.entityToModel(mrShareElement, mdMrShareElement, "", dictionaryService);
            builder.withData(mrShareElement);
        }
        return builder.build();
    }
    
    @Override
    public SingleResult<MrShareElement> create(MrShareElement mrShareElement) {
        // TODO Auto-generated method stub
        MdMrShareElement mdMrShareElement = new MdMrShareElement();
        BeanCopyUtil.modelToEntity(mdMrShareElement, mrShareElement);
        mdMrShareElement.setMrShareElementCd(UUIDGenerator.getUUID());
        autoDao.insert(mdMrShareElement);
        return this.selectByCode(mdMrShareElement.getMrShareElementCd());
    }

    @Override
    public SingleResult<MrShareElement> update(MrShareElement mrShareElement) {
        // TODO Auto-generated method stub
        MdMrShareElement mdMrShareElement= new MdMrShareElement();
        BeanCopyUtil.modelToEntity(mdMrShareElement, mrShareElement);
        autoDao.updateExcludeNull(mdMrShareElement);
        return this.selectByCode(mdMrShareElement.getMrShareElementCd());
    }
    
    private String getStringValueFromMap(Map map,String key){
        String value = "";
        if(map.containsKey(key) && null != map.get(key)){
            value = (String)map.get(key);
            if(StringUtils.isBlank(value)){
                value = "";
            }
        }
        return value;
    }

	@Override
	public ArrayResult<HyperlinkTemplate> shareElementDict(String id,Map<String, String> map) {
		String keyword=null;
		if(map!=null){
			keyword= map.get("keyword");
		}
 		DaoConfigProxy daoConfigProxy=new DaoConfigProxy("mainConfig");
		ArrayResultBuilder<HyperlinkTemplate> builder = ArrayResultBuilder.newArrayResult(HyperlinkTemplate.class);
		List<HyperlinkTemplate> mdDiTemplates=new ArrayList<HyperlinkTemplate>();
		MdMrShareElement mdMrShareElement = autoDao.selectById(id);
		if(mdMrShareElement!=null){
			try {
				Connection conn=daoConfigProxy.getDataSource().getConnection();
				String sql=mdMrShareElement.getDsSql();
				if(!StringUtils.isBlank(keyword)){
					sql+=" AND (NM like '%"+keyword+"%' or SPELL_NO like lower('%"+keyword+"%'))";
				}
				PreparedStatement ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				if(rs!=null){
					while (rs.next()) {
						HyperlinkTemplate diTemplate=new HyperlinkTemplate();
						diTemplate.setCode(rs.getString("code"));
						diTemplate.setName(rs.getString("nm"));
						mdDiTemplates.add(diTemplate);
					}
				}
				if(rs!=null)
				rs.close();
				if(ps!=null)
				ps.close();
				if(conn!=null)
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//list2.toArray(new MrShareElement[0])
		builder.withData(mdDiTemplates.toArray(new HyperlinkTemplate[0]));
		return builder.build();
	}
}
