package pkuhit.xap.file;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseBizModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class BaseFile extends BaseBizModel {
 public BaseFile(){
  super();
 }
 public BaseFile(String code){
  super(code);
 }
// 文件主键
public static final   String  PK = "XAPB01.AT01";
// 文件格式编码
public static final   String  FORMAT_CODE = "XAPB01.AT02";
// 文件数据
public static final   String  DATA = "XAPB01.AT03";

// 文件主键
@Column(name="FILE_PK") 
private  String pk;
// 文件格式编码
@Column(name="FILE_FMT_CD") 
private  String formatCode;
// 文件数据
@Column(name="FILE_DATA") 
private  String data;
// 文件格式名称
@DictionaryTag(code = "formatCode")
private  String formatName;
public String getPk()
 {
     return this.pk;
 }
public  void  setPk(String pk)
 {
  this.pk = pk;
 }
public String getFormatCode()
 {
     return this.formatCode;
 }
public  void  setFormatCode(String formatCode)
 {
  this.formatCode = formatCode;
 }
public String getData()
 {
     return this.data;
 }
public  void  setData(String data)
 {
  this.data = data;
 }
public String getFormatName()
 {
     return this.formatName;
 }
public  void  setFormatName(String formatName)
 {
  this.formatName = formatName;
 }

}