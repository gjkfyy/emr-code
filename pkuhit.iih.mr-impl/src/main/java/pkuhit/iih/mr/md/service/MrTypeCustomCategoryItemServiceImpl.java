/**
 * 
 */
package pkuhit.iih.mr.md.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.mr.md.MrTypeCustomCategory;
import pkuhit.iih.mr.md.MrTypeCustomCategoryItem;
import pkuhit.iih.mr.md.MrTypeCustomCategoryItemService;
import pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat;
import pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcatItm;
import pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatItmDao;
import pkuhit.md.DictionaryService;
import pkuhit.xap.me.MeCdRuId;
import pkuhit.xap.me.MeCdRuService;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import pkuhit.xap.util.BeanCopyUtil;

/**
 * @author guo_zhongbao
 * 病历模板分类 与 病历模板类型 的关系
 */
public class MrTypeCustomCategoryItemServiceImpl implements MrTypeCustomCategoryItemService {

    //病历模板分类 与 病历模板类型 的关系 数据访问接口
    @Autowired
    CusMdMrTpCcatItmDao cusMdMrTpCcatItmDao;
    
    @Reference
    MeCdRuService meCdRuService;
    @Reference
    DictionaryService dictionaryService;
    /* (non-Javadoc)
     * @see pkuhit.iih.mr.md.MdMrTpCcatItmService#getMdMrTpCcatItmByTemplateType(java.lang.String)
     */
    /**
     * 根据病历模板类型编码查询，所关联的分类
     * */
    @Override
    public ArrayResult<MrTypeCustomCategoryItem> getMdMrTpCcatItmByTemplateType(
            String typeCode) {
        List<MdMrTpCcatItm> mdMrTpCcatItmByTemplateTypeList = cusMdMrTpCcatItmDao.getMdMrTpCcatItmByTemplateType(typeCode);
        MrTypeCustomCategoryItem[] mrTypeCustomCategoryItemArray = new MrTypeCustomCategoryItem[mdMrTpCcatItmByTemplateTypeList.size()];
        int i = 0;
        for(MdMrTpCcatItm po:mdMrTpCcatItmByTemplateTypeList){
            MrTypeCustomCategoryItem vo = new MrTypeCustomCategoryItem();
            BeanCopyUtil.entityToModel(vo, po, MrTypeCustomCategoryItem.OBJ_CD, dictionaryService);
            mrTypeCustomCategoryItemArray[i] = vo;
            i++;
        }
        ArrayResult<MrTypeCustomCategoryItem> arrayResult = new ArrayResult<MrTypeCustomCategoryItem>();
        arrayResult.setDataList( mrTypeCustomCategoryItemArray ); 
        return arrayResult;
    }
    /**
     * 根据病历模板分类编码查询，所关联的类型
     * */
     public  ArrayResult<MrTypeCustomCategoryItem> getMdMrTpCcatItmByTemplateCategory(String categoryCode){
        List<MdMrTpCcatItm> mdMrTpCcatItmByTemplateTypeList = cusMdMrTpCcatItmDao.getMdMrTpCcatItmByTemplateCategory(categoryCode);
        MrTypeCustomCategoryItem[] mrTypeCustomCategoryItemArray = new MrTypeCustomCategoryItem[mdMrTpCcatItmByTemplateTypeList.size()];
        int i = 0;
        for(MdMrTpCcatItm po:mdMrTpCcatItmByTemplateTypeList){
            MrTypeCustomCategoryItem vo = new MrTypeCustomCategoryItem();
            BeanCopyUtil.entityToModel(vo, po, MrTypeCustomCategoryItem.OBJ_CD, dictionaryService);
            mrTypeCustomCategoryItemArray[i] = vo;
            i++;
        }
        ArrayResult<MrTypeCustomCategoryItem> arrayResult = new ArrayResult<MrTypeCustomCategoryItem>();
        arrayResult.setDataList( mrTypeCustomCategoryItemArray ); 
        return arrayResult;
     }
     
     /**
     * 根据病历模板类型编码查询其所属就诊类型(去掉重复)
     * */
     public  ArrayResult<MrTypeCustomCategoryItem> searchEnTypeByTemplateType(String typeCode){
         List<MdMrTpCcatItm> mdMrTpCcatItmByTemplateTypeList = cusMdMrTpCcatItmDao.selectEnTypeByTemplateType(typeCode);
         MrTypeCustomCategoryItem[] mrTypeCustomCategoryItemArray = new MrTypeCustomCategoryItem[mdMrTpCcatItmByTemplateTypeList.size()];
         int i = 0;
         for(MdMrTpCcatItm po:mdMrTpCcatItmByTemplateTypeList){
             MrTypeCustomCategoryItem vo = new MrTypeCustomCategoryItem();
             BeanCopyUtil.entityToModel(vo, po, MrTypeCustomCategoryItem.OBJ_CD, dictionaryService);
             mrTypeCustomCategoryItemArray[i] = vo;
             i++;
         }
         ArrayResult<MrTypeCustomCategoryItem> arrayResult = new ArrayResult<MrTypeCustomCategoryItem>();
         arrayResult.setDataList( mrTypeCustomCategoryItemArray ); 
         return arrayResult;
     }
     
     /**
      * 根据病历模板类型编码查询其所属分组(去掉重复)
      * */
     @Override
     public ArrayResult<MrTypeCustomCategoryItem> searchMrTpCcatByTemplateType(
             String typeCode) {
         List<MdMrTpCcatItm> mdMrTpCcatItmByTemplateTypeList = cusMdMrTpCcatItmDao.selectMrTpCcatByTemplateType(typeCode);
         MrTypeCustomCategoryItem[] mrTypeCustomCategoryItemArray = new MrTypeCustomCategoryItem[mdMrTpCcatItmByTemplateTypeList.size()];
         int i = 0;
         for(MdMrTpCcatItm po:mdMrTpCcatItmByTemplateTypeList){
             MrTypeCustomCategoryItem vo = new MrTypeCustomCategoryItem();
             BeanCopyUtil.entityToModel(vo, po, MrTypeCustomCategoryItem.OBJ_CD, dictionaryService);
             mrTypeCustomCategoryItemArray[i] = vo;
             i++;
         }
         ArrayResult<MrTypeCustomCategoryItem> arrayResult = new ArrayResult<MrTypeCustomCategoryItem>();
         arrayResult.setDataList( mrTypeCustomCategoryItemArray ); 
         return arrayResult;
     }
}