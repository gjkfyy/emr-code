package pkuhit.md;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseMasterModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class PaperType extends BaseMasterModel {
 public PaperType(){
  super();
 }
 public PaperType(String code){
  super(code);
 }
// A4
public static final String A4 = "MDM07.01";
// B5
public static final String B5 = "MDM07.02";


}