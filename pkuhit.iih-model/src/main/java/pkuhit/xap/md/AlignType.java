package pkuhit.xap.md;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseMasterModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class AlignType extends BaseMasterModel {
 public AlignType(){
  super();
 }
 public AlignType(String code){
  super(code);
 }
// 左
public static final String LEFT = "MEM09.PUT";
// 中
public static final String CENTER = "MEM09.POST";
// 右
public static final String RIGHT = "MEM09.DELETE";


}