package pkuhit.iih.mr.md.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.mr.md.MrTypeCustomCategory;
import pkuhit.iih.mr.md.MrTypeCustomCategoryService;
import pkuhit.iih.mr.md.dao.auto.MdMrTpCcatDao;
import pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat;
import pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatDao;
import pkuhit.md.DictionaryService;
import pkuhit.xap.me.MeCdRuId;
import pkuhit.xap.me.MeCdRuService;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import xap.sv.model.TreeBuilder;
import xap.sv.model.TreeNode;
import xap.sv.model.TreeResult;

/**
 * @author guo_zhongbao
 * 病历模板自定义分类服务接口
 */
public class MrTypeCustomCategoryServiceImpl implements
		MrTypeCustomCategoryService {
	@Autowired
	CusMdMrTpCcatDao cusDao;
	@Autowired
	MdMrTpCcatDao autoDao;
	@Reference
	DictionaryService dictionaryService;
	@Reference
    MeCdRuService meCdRuService;

	/* (non-Javadoc)
	 * @see pkuhit.iih.mr.md.MrTypeCustomCategoryService#tree(java.lang.String)
	 */
	@Override
	public TreeResult<MrTypeCustomCategory> tree(String orgCode ,String rootCode,int childDepth) {
		//子层级深度所处的level
		int maxDepthLevel = childDepth ;
		if(null != rootCode){
			//当rootcode为非空时
			MdMrTpCcat mdMrTpCcat = autoDao.selectById(rootCode);
//			maxDepthLevel = mdMrTpCcat.getLvl().intValue() + childDepth ;
		}
		// 根据根节点，查询数据
        List<MdMrTpCcat> poList = cusDao.selectTreeList(orgCode,rootCode,maxDepthLevel);
        // 构建根节点，目前规定根节点为空，是一个虚值。
        TreeBuilder<MrTypeCustomCategory> builder = TreeBuilder.newTree("root", null);
        // 构建树列表
        if (poList != null)
        {
            for (MdMrTpCcat po : poList)
            {
            	MrTypeCustomCategory vo = new MrTypeCustomCategory();
                BeanCopyUtil.entityToModel(vo, po, MrTypeCustomCategory.OBJ_CD, dictionaryService);
                //构建树列表方式
                builder.addChildByData(vo.getCode(), vo.getName(), vo);
            }
        }
        //构建树节点
        TreeNode<MrTypeCustomCategory> tree = builder.build();
        //构建树返回结果
        TreeResult<MrTypeCustomCategory> r = new TreeResult<MrTypeCustomCategory>();
        r.setRoot(tree);
        return r;

	}

	@Override
    public ArrayResult<MrTypeCustomCategory> search() {
        List<MdMrTpCcat> lst = cusDao.selectAll();
        int total = 0 ;
        MrTypeCustomCategory[] voArray = null ;
        ArrayResultBuilder<MrTypeCustomCategory> builder = ArrayResultBuilder.newArrayResult(MrTypeCustomCategory.class);
        if(null != lst){
            total = lst.size() ;
            voArray = new MrTypeCustomCategory[total];           
             int i = 0;
             for(MdMrTpCcat po : lst){
                 MrTypeCustomCategory vo = new MrTypeCustomCategory();
                 BeanCopyUtil.entityToModel(vo, po, MrTypeCustomCategory.OBJ_CD, dictionaryService);
                 voArray[i]= vo;
                 vo.setContinuePrintF(po.getContinuePrintF());
                 i++;
             }
             builder.withData(voArray);
        }
        ArrayResult<MrTypeCustomCategory> rs = builder.build();
        rs.setTotal(total);
        return rs;
    }
	
	@Override
    public SingleResult<Map> searchTree() {
        SingleResult<Map> result = new SingleResult<Map>();
        Map mapResult = new HashMap();
        mapResult.put("text", "root");
        List<MdMrTpCcat> lst = cusDao.selectAll();
        if(null != lst){
             List<Map> mapChilds = new ArrayList<Map>();
             Map all = new HashMap();
             all.put("id", "all");
             all.put("text", "全部");
             all.put("leaf", true);
             mapChilds.add(all);
             for(MdMrTpCcat po : lst){
                 Map node = new HashMap();
                 node.put("id", po.getMrTpCcatCd());
                 node.put("text", po.getNm());
                 node.put("leaf", true);
                 mapChilds.add(node);
             }
             mapResult.put("expanded", "true");
             mapResult.put("children", mapChilds);
        }
        result.setData(mapResult);
        return result;
    }
	
	@Override
	public ArrayResult<MrTypeCustomCategory>  getChild( Map<String, String>  params ){
		
		if(null == params || !params.containsKey("orgCode")){
			return null ;
		}
		String parentId = null ;
		if(params.containsKey("rootCode")){
			parentId = (String)params.get("rootCode") ;
		}	
		String orgCode = null ;
		if(params.containsKey("orgCode")){
			orgCode = (String)params.get("orgCode") ;
		}	
		List<MdMrTpCcat> poList = cusDao.getNextLevelChild(orgCode,parentId);
		//总记录数
		int total = 0 ;
		MrTypeCustomCategory[] voArray = null ;
		ArrayResultBuilder<MrTypeCustomCategory> builder = ArrayResultBuilder.newArrayResult(MrTypeCustomCategory.class);
		if(null != poList){
			total = poList.size() ;
			voArray = new MrTypeCustomCategory[total];			 
			 int i = 0;
			 for(MdMrTpCcat po : poList){
				 MrTypeCustomCategory vo = new MrTypeCustomCategory();
				 BeanCopyUtil.entityToModel(vo, po, MrTypeCustomCategory.OBJ_CD, dictionaryService);
				 voArray[i]= vo;
				 i++;
			 }
			 builder.withData(voArray);
		}
		ArrayResult<MrTypeCustomCategory> rs = builder.build();
		rs.setTotal(total);
		return rs;
	
	}
	
	@Override
    public SingleResult<MrTypeCustomCategory> create(
            MrTypeCustomCategory mrTypeCustomCategory) {
        // TODO Auto-generated method stub
        MdMrTpCcat mdMrTpCcat = new MdMrTpCcat();
        BeanCopyUtil.modelToEntity(mdMrTpCcat, mrTypeCustomCategory);
        String id = mrTypeCustomCategory.getCode();
        if("".equals(id)||id==null){
            MeCdRuId meCdRuId = meCdRuService.selectById("MRM14.AT01");
            mdMrTpCcat.setMrTpCcatCd(meCdRuId.getId());
        }
        autoDao.insert(mdMrTpCcat);
        return this.selectByCode(id);
    }

    @Override
    public SingleResult<MrTypeCustomCategory> update(
            MrTypeCustomCategory mrTypeCustomCategory) {
        // TODO Auto-generated method stub
        MdMrTpCcat mdMrTpCcat= new MdMrTpCcat();
        BeanCopyUtil.modelToEntity(mdMrTpCcat, mrTypeCustomCategory);
        autoDao.updateExcludeNull(mdMrTpCcat);
        return this.selectByCode(mdMrTpCcat.getMrTpCcatCd());
    }

    @Override
    public SingleResult<MrTypeCustomCategory> delete(String mrTypeCustomCategoryId) {
        // TODO Auto-generated method stub
        MdMrTpCcat mdMrTpCcat = autoDao.selectById(mrTypeCustomCategoryId);
        mdMrTpCcat.setDelF((short)1);
        autoDao.markDelete(mdMrTpCcat);
        return this.selectByCode(mrTypeCustomCategoryId);
    }

    @Override
    public SingleResult<MrTypeCustomCategory> selectByCode(
            String mrTypeCustomCategoryId) {
        // TODO Auto-generated method stub
        SingleResultBuilder<MrTypeCustomCategory> builder = SingleResultBuilder.newSingleResult(MrTypeCustomCategory.class);
        MdMrTpCcat mdMrTpCcat = autoDao.selectById(mrTypeCustomCategoryId);
        MrTypeCustomCategory mrTypeCustomCategory = new MrTypeCustomCategory();
        if (null != mdMrTpCcat) {
            BeanCopyUtil.entityToModel(mrTypeCustomCategory, mdMrTpCcat, MrTypeCustomCategory.OBJ_CD, dictionaryService);
            builder.withData(mrTypeCustomCategory);
        }
        return builder.build();
    }

}
