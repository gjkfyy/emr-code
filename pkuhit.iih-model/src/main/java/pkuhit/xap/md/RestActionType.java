package pkuhit.xap.md;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseMasterModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class RestActionType extends BaseMasterModel {
 public RestActionType(){
  super();
 }
 public RestActionType(String code){
  super(code);
 }
// GET
public static final String GET = "GET";
// PUT
public static final String PUT = "PUT";
// POST
public static final String POST = "POST";
// DELETE
public static final String DELETE = "DELETE";


}