package pkuhit.iih.mr.tth;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.mr.tth.dao.auto.MrTeethExamDao;
import pkuhit.iih.mr.tth.dao.auto.MrTeethExamItemDao;
import pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam;
import pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem;
import pkuhit.iih.mr.tth.dao.custom.CusTeethExamDao;
import pkuhit.md.DictionaryService;
import pkuhit.xap.util.BeanCopyUtil;

import xap.sv.annotation.Reference;
import xap.sv.util.UUIDGenerator;

public class TeethExamServiceImpl implements TeethExamService
{
    @Autowired
    CusTeethExamDao teethExamDao;
    
    @Autowired
    MrTeethExamDao mrTeethExamDao;
    
    @Autowired
    MrTeethExamItemDao mrTeethExamItemDao;
    
    @Reference
    DictionaryService dictionaryService;
    
    java.text.DecimalFormat df =new java.text.DecimalFormat("#.00");
    
    /**
     * 查询
     * @param enPk
     * @return
     */
    @Override
    public TeethExamModel search(String enpk){
        MrTeethExam entity = teethExamDao.selectTeethExamByEnPk(enpk);
        TeethExamModel model = this.getTeethExamModel();
        if(entity != null){
            BeanCopyUtil.entityToModel(model, entity, "", dictionaryService);
            String id = entity.getTeethPk();
            List<MrTeethExamItem> list = teethExamDao.selectTeethExamItemByPk(id);
            if(list != null && list.size() > 0){
                TeethExamItemModel[] teethExamItemArray = model.getTeethExamItemArray();
                for(int i=0; i<list.size(); i++){
                    MrTeethExamItem itemEntity = list.get(i);
                    TeethExamItemModel itemModel = new TeethExamItemModel();
                    BeanCopyUtil.entityToModel(itemModel, itemEntity, "", dictionaryService);
                    teethExamItemArray[i] = itemModel;
                }
            }
        }
        return model;
    }
    
    /**
     * 保存
     * @param model
     * @return
     */
    @Override
    public void save(TeethExamModel model){
        String id = model.getTeethPk();
        String enPk = model.getEnPk();
        String bop = "0.00";
        int bleeding = model.getBleeding();
        int valueCount = model.getBlValueCount();
        if(valueCount > 0)
            bop = df.format(bleeding*1.00/valueCount*100.00);
        model.setBop(bop);
        if(id != null && !"".equals(id)){
            MrTeethExam mrTeethExam = new MrTeethExam();
            BeanCopyUtil.modelToEntity(mrTeethExam, model);
            mrTeethExamDao.updateExcludeNull(mrTeethExam);
            TeethExamItemModel[] array = model.getTeethExamItemArray();
            if(array != null && array.length > 0){
                for(int i=0; i<array.length; i++){
                    TeethExamItemModel item = array[i];
                    MrTeethExamItem mrTeethExamItem = new MrTeethExamItem();
                    BeanCopyUtil.modelToEntity(mrTeethExamItem, item);
                    mrTeethExamItemDao.updateExcludeNull(mrTeethExamItem);
                }
            }
        }else{
            MrTeethExam mrTeethExam = new MrTeethExam();
            BeanCopyUtil.modelToEntity(mrTeethExam, model);
            mrTeethExam.setTeethPk(UUIDGenerator.getUUID());
            mrTeethExam.setExamDate(new Date());
            mrTeethExamDao.insert(mrTeethExam);
            String teethPk = mrTeethExam.getTeethPk();
            TeethExamItemModel[] array = model.getTeethExamItemArray();
            if(array != null && array.length > 0){
                for(int i=0; i<array.length; i++){
                    TeethExamItemModel item = array[i];
                    MrTeethExamItem mrTeethExamItem = new MrTeethExamItem();
                    BeanCopyUtil.modelToEntity(mrTeethExamItem, item);
                    mrTeethExamItem.setTeethItemPk(UUIDGenerator.getUUID());
                    mrTeethExamItem.setTeethPk(teethPk);
                    mrTeethExamItemDao.insert(mrTeethExamItem);
                }
            }
        }
    }
    
    /**
     * 删除
     * @param pk
     * @return
     */
    @Override
    public TeethExamModel delete(String pk){
        MrTeethExam entity = mrTeethExamDao.selectById(pk);
        if(entity != null){
            List<MrTeethExamItem> list = teethExamDao.selectTeethExamItemByPk(pk);
            if(list != null && list.size() > 0){
                for(int i=0; i<list.size(); i++){
                    MrTeethExamItem itemEntity = list.get(i);
                    mrTeethExamItemDao.delete(itemEntity);
                }
            }
            mrTeethExamDao.delete(entity);
        }
        return this.getTeethExamModel();
    }
    
    private TeethExamModel getTeethExamModel(){
        TeethExamModel model = new TeethExamModel();
        TeethExamItemModel[] teethExamItemArray = new TeethExamItemModel[4];
        for(int i=0; i<4; i++){
            TeethExamItemModel mrTeethExamItem = new TeethExamItemModel();
            mrTeethExamItem.setTeethLocation(String.valueOf(i));
            mrTeethExamItem.setColDisabled("00000000");
            teethExamItemArray[i] = mrTeethExamItem;
        }
        model.setTeethExamItemArray(teethExamItemArray);
        return model;
    }
}
