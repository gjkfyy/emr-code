package pkuhit.md;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseMasterModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class MessageType extends BaseMasterModel {
 public MessageType(){
  super();
 }
 public MessageType(String code){
  super(code);
 }


}