package pkuhit.iih.mr.md.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.mr.md.MrType;
import pkuhit.iih.mr.md.MrTypeCustomCategory;
import pkuhit.iih.mr.md.MrTypeCustomCategoryItem;
import pkuhit.iih.mr.md.MrTypeCustomCategoryItemService;
import pkuhit.iih.mr.md.MrTypeService;
import pkuhit.iih.mr.md.dao.auto.MdMrTpCcatItmDao;
import pkuhit.iih.mr.md.dao.auto.MdMrTpDao;
import pkuhit.iih.mr.md.dao.auto.entity.MdMrTp;
import pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcatItm;
import pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatItmDao;
import pkuhit.iih.mr.md.dao.custom.CusMdMrTpDao;
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
 * 病历模板类型服务接口
 */
public class MrTypeServiceImpl implements MrTypeService {
	
	@Autowired
	MdMrTpDao autoDao ;
	@Autowired
	CusMdMrTpDao cusDao;
	@Reference
	DictionaryService dictionaryService;
	@Autowired
    CusMdMrTpCcatItmDao cusMdMrTpCcatItmDao;
	@Reference
    MeCdRuService meCdRuService;
    @Reference
    MrTypeCustomCategoryItemService mrTypeCustomCategoryItemService;
    @Autowired
    MdMrTpCcatItmDao autoItmDao;
	/**
	 * 根据根节点，查询自定义类型树
	 * @param rootCode 根节点
	 * @param childDepth 查询层级
	 * */
	@Override
	public TreeResult<MrType> tree(String rootCode,String childDepth) {
		Integer i = Integer.valueOf(childDepth);
		//子层级深度所处的level
		int maxDepthLevel = Integer.valueOf(i) ;
		//获取当前路径
		String rootPath = getWholePathByCode(rootCode) ;
		if(null != rootCode){
			//当rootcode为非空时
			MdMrTp rootMdMrTpCcat = autoDao.selectById(rootCode);
			//MdMrTp rootMdMrTpCcat = autoDao.selectById("MRM16.01");
//			maxDepthLevel = rootMdMrTpCcat.getLvl().intValue() + i ;

		}
		// 根据根节点，查询数据
        List<MdMrTp> poList = cusDao.selectTreeList(rootCode,maxDepthLevel);
        // 构建根节点，目前规定根节点为空，是一个虚值。
        TreeBuilder<MrType> builder = TreeBuilder.newTree("root", MrType.class);
        // 构建树列表
        if (poList != null)
        {
            for (MdMrTp po : poList)
            {
            	MrType vo = new MrType();
            	pkuhit.xap.util.BeanCopyUtil.entityToModel(vo, po, MrType.OBJ_CD, dictionaryService);
            	String path = getWholePathByCode(po.getMrTpCd()) ;
            	String name = po.getNm() ;
            	boolean isLeaf = false ;
//            	if(po.getLeafF().intValue() == 1){
//            		isLeaf = true ;
//            	}
                //构建树列表方式
                builder.addChildByData(path , name, vo,isLeaf);
            }
        }
        //构建树节点
        TreeNode<MrType> tree = builder.build();
        //构建树返回结果
        TreeResult<MrType> r = new TreeResult<MrType>();
        r.setRoot(tree);
        return r;

	}
	
	
	@Override
	public ArrayResult<MrType>  getChild(Map<String, String> params){
		if(null == params ){
			return null ;
		}
		String parentId = null ;
		if(params.containsKey("rootCode")){
			parentId = (String)params.get("rootCode") ;
		}	
		List<MdMrTp> poList = cusDao.getNextLevelChild(parentId);
		//总记录数
		int total = 0 ;
		MrType[] voArray = null ;
		ArrayResultBuilder<MrType> builder = ArrayResultBuilder.newArrayResult(MrType.class);
		if(null != poList){
			total = poList.size() ;
			voArray = new MrType[total];			 
			 int i = 0;
			 for(MdMrTp po : poList){
				 MrType vo = translateTypePo2vo(po);
				 voArray[i]= vo;
				 i++;
			 }
			 builder.withData(voArray);
		}
		ArrayResult<MrType> rs = builder.build();
		rs.setTotal(total);
		return rs;
	}
	private MrType translateTypePo2vo(MdMrTp po){
		MrType vo = new MrType();
		BeanCopyUtil.entityToModel(vo, po, MrType.OBJ_CD, dictionaryService);
		return vo;
	}
	
    private String getWholePathByCode(String code){
    	String rootPath ="/" ;
    	/*if(null != code){
	    	MdMrTp rootMdMrTpCcat = autoDao.selectById(code);
			do{
				rootPath = "/"+rootMdMrTpCcat.getMrTpCd()+rootPath;
				rootMdMrTpCcat = autoDao.selectById(rootMdMrTpCcat.getParMrTpCd());
			}
			while(null != rootMdMrTpCcat);
    	}*/
		return rootPath;
    }
    
    @Override
    public ArrayResult<MrType> search(MrType condition) {
        if(null == condition ){
            return null ;
        }
        String parentId = condition.getParentCode() ;
        List<MdMrTp> poList = cusDao.getNextLevelChild(parentId);
        //总记录数
        int total = 0 ;
        MrType[] voArray = null ;
        ArrayResultBuilder<MrType> builder = ArrayResultBuilder.newArrayResult(MrType.class);
        if(null != poList){
            total = poList.size() ;
            voArray = new MrType[total];             
             int i = 0;
             for(MdMrTp po : poList){
                 MrType vo = translateTypePo2vo(po);
                 voArray[i]= vo;
                 i++;
             }
             builder.withData(voArray);
        }
        ArrayResult<MrType> rs = builder.build();
        rs.setTotal(total);
        return rs;
    }


    @Override
    public SingleResult<MrType> create(MrType mrType) {
        // TODO Auto-generated method stub
        MdMrTp mdMrTp = new MdMrTp();
        BeanCopyUtil.modelToEntity(mdMrTp, mrType);
        String id = mrType.getCode();
        if("".equals(id)||id==null){
            MeCdRuId meCdRuId = meCdRuService.selectById("MRM16.AT01");
            mdMrTp.setMrTpCd(meCdRuId.getId());
        }
        autoDao.insert(mdMrTp);
        this.insertMrTypeCustomCategoryItem(mrType.getMrTpCcatCd(),mdMrTp.getMrTpCd(),mrType.getEncounterTypeCode());
        return this.selectByMrTypeId(id);
    }
    
    private void insertMrTypeCustomCategoryItem(String mrTpCcatCd,String mrTpCd,String encounterTypeCode){
        List<MdMrTpCcatItm> mdMrTpCcatItmByTemplateTypeList = cusMdMrTpCcatItmDao.getMdMrTpCcatItmByTemplateType(mrTpCd);
        autoItmDao.batchDelete(mdMrTpCcatItmByTemplateTypeList);
        /*if(mdMrTpCcatItmByTemplateTypeList != null && mdMrTpCcatItmByTemplateTypeList.size() > 0){
            for(MdMrTpCcatItm entity:mdMrTpCcatItmByTemplateTypeList){
                autoItmDao.markDelete(entity);
            }
        }*/
        String[] array = mrTpCcatCd.split(",");
        for(int i=0;i<array.length;i++){
            String[] enArray = encounterTypeCode.split(",");
            for(int j=0;j<enArray.length;j++){
                MdMrTpCcatItm mdMrTpCcatItm = new MdMrTpCcatItm();
                mdMrTpCcatItm.setMrTpCcatCd(array[i]);
                mdMrTpCcatItm.setMrTpCd(mrTpCd);
                mdMrTpCcatItm.setEnTpCd(enArray[j]);
                MeCdRuId meCdRuId = meCdRuService.selectById("MRM15.AT01");
                mdMrTpCcatItm.setMrTpCcatItmCd(meCdRuId.getId());
                autoItmDao.insert(mdMrTpCcatItm);
            }
        }
    }


    @Override
    public SingleResult<MrType> update(MrType mrType) {
        // TODO Auto-generated method stub
        MdMrTp mdMrTp = new MdMrTp();
        BeanCopyUtil.modelToEntity(mdMrTp, mrType);
        autoDao.updateExcludeNull(mdMrTp);
        this.insertMrTypeCustomCategoryItem(mrType.getMrTpCcatCd(),mdMrTp.getMrTpCd(),mrType.getEncounterTypeCode());
        return this.selectByMrTypeId(mdMrTp.getMrTpCd());
    }


    @Override
    public SingleResult<MrType> delete(String mrTypeId) {
        // TODO Auto-generated method stub
        MdMrTp mdMrTp = autoDao.selectById(mrTypeId);
        mdMrTp.setDelF((short)1);
        autoDao.markDelete(mdMrTp);
        return this.selectByMrTypeId(mrTypeId);
    }


    @Override
    public SingleResult<MrType> selectByMrTypeId(String mrTypeId) {
        // TODO Auto-generated method stub
        SingleResultBuilder<MrType> builder = SingleResultBuilder.newSingleResult(MrType.class);
        MdMrTp mdMrTp = autoDao.selectById(mrTypeId);
        MrType mrType = new MrType();
        if (null != mdMrTp) {
            BeanCopyUtil.entityToModel(mrType, mdMrTp, MrTypeCustomCategory.OBJ_CD, dictionaryService);
            builder.withData(mrType);
        }
        return builder.build();
    }


    @Override
    public ArrayResult<MrType> selectByMrTypeCcatId(String mrTypeCcatId) {
        List<MdMrTp> poList = cusDao.selectByMrTypeCcatId(mrTypeCcatId);
        //总记录数
        int total = 0 ;
        MrType[] voArray = null ;
        ArrayResultBuilder<MrType> builder = ArrayResultBuilder.newArrayResult(MrType.class);
        if(null != poList){
            total = poList.size() ;
            voArray = new MrType[total];             
             int i = 0;
             for(MdMrTp po : poList){
                 MrType vo = translateTypePo2vo(po);
                 ArrayResult<MrTypeCustomCategoryItem> enResult = mrTypeCustomCategoryItemService.searchEnTypeByTemplateType(vo.getCode());
                 if(enResult != null && enResult.getDataList() != null){
                     StringBuilder enType = new StringBuilder();
                     MrTypeCustomCategoryItem[] array = enResult.getDataList();
                     for(int j=0;j<array.length;j++){
                         MrTypeCustomCategoryItem item = array[j];
                         enType.append(item.getEncounterTypeName());
                         enType.append(",");
                     }
                     vo.setEncounterTypeName(enType.toString().substring(0, enType.toString().length()-1));
                 }
                 voArray[i]= vo;
                 i++;
             }
             builder.withData(voArray);
        }
        ArrayResult<MrType> rs = builder.build();
        rs.setTotal(total);
        return rs;
    }

}
