package pkuhit.xap.md;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseMasterModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class DataType extends BaseMasterModel {
 public DataType(){
  super();
 }
 public DataType(String code){
  super(code);
 }
// 字符
public static final String VARCHAR2 = "VARCHAR2";
// 日期
public static final String DATE = "DATE";
// 数值
public static final String NUMBER = "NUMBER";
// 字符大字段
public static final String CLOB = "CLOB";
// 日期时间
public static final String DATETIME = "DATETIME";
// 整形
public static final String INGTEGER = "INTEGER";


}