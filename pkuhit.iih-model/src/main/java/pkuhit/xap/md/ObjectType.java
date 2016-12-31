package pkuhit.xap.md;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseMasterModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class ObjectType extends BaseMasterModel {
 public ObjectType(){
  super();
 }
 public ObjectType(String code){
  super(code);
 }
// 主数据
public static final String MASTER_DATA = "M";
// 知识数据
public static final String KNOWLEDGE_REPOSITORY = "K";
// 业务数据
public static final String BUSINESS_DATA = "B";


}