package pkuhit.iih.mr.md;
import xap.model.BaseMasterModel;

public class MrGroupElementType extends BaseMasterModel {
 public MrGroupElementType(){
  super();
 }
 public MrGroupElementType(String code){
  super(code);
 }

//普通元素
public static final String COMMON_ELEMENT = "MRM11.01";

//片段元素
public static final String FRAGMENT_ELEMENT = "MRM11.02";
}