package pkuhit.xap.ac;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import pkuhit.xap.dao.auto.IemrPatientDao;
import pkuhit.xap.dao.auto.entity.IemrPatient;
import pkuhit.xap.util.BeanCopyUtil;
import pkuhit.xap.util.ExcelExport;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestParam;
public class AdvancedSearchServiceImpl implements AdvancedSearchService
{
    @Autowired
    IemrPatientDao imerPatientDao;
    
    protected HttpServletResponse response;
    
    
    @ModelAttribute
    public void setResponse(HttpServletResponse response){
    	this.response = response;
    }

    @Override
	public ArrayResult<Patient> search(Map<String, String> params) {

    	//■ 查询数据
        String pageNum = null;
		String pageSize = null;
		if (params.containsKey("pageNum") && params.containsKey("pageSize")) {
			pageNum = (String) params.get("pageNum");
			pageSize = (String) params.get("pageSize");
		}
		if (org.apache.commons.lang3.StringUtils.isBlank(pageNum)) {
			pageNum = "1";
		}
		if (org.apache.commons.lang3.StringUtils.isBlank(pageSize)) {
			pageSize = "20";
		}
		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum) - 1) * Integer.valueOf(pageSize))
				.limit(Integer.valueOf(pageSize)).count();
		
        String admissionDateStart = getParamValue(params, "admissionDateStart");
        String admissionDateEnd = getParamValue(params, "admissionDateEnd");
        String inpatientNoStart = getParamValue(params, "inpatientNoStart");
        String inpatientNoEnd = getParamValue(params, "inpatientNoEnd");
        String patientName = getParamValue(params, "patientName");
        String sex = getParamValue(params, "sex");
        if("-1".equals(sex)){
        	sex = null;
        }
        String birthdayStart = getParamValue(params, "birthdayStart");
        String birthdayEnd = getParamValue(params, "birthdayEnd");
        String tel = getParamValue(params, "tel");
        String address = getParamValue(params, "address");
        String diagnosis = getParamValue(params, "diagnosis");
        
        List<String> itemValuesList = new ArrayList<String>();
        String itemValues = getParamValue(params, "itemValues");
        if(itemValues != null){
        	String[] split = itemValues.split("\\|\\|");
        	itemValuesList = Arrays.asList(split);
        }
        
        List<IemrPatient> list = imerPatientDao.selectByAdvancedCondition(itemValuesList,admissionDateStart, admissionDateEnd, inpatientNoStart, 
        		inpatientNoEnd, patientName, sex, birthdayStart, birthdayEnd, tel, address, diagnosis,options);
        
        //■　装配并返回
        ArrayResultBuilder<Patient> builder = ArrayResultBuilder.newArrayResult(Patient.class);
        int size = 0;
        if (list != null && list.size() > 0)
        {
            Patient[] patientList = new Patient[list.size()];
            int i = 0;
            for (IemrPatient iemrPatient : list)
            {
            	patientList[i] = this.wrapData(iemrPatient);
                i++;
            }
            
            builder.withData(patientList);
            size = patientList.length;
        }
        
        ArrayResult<Patient> arrayResult = builder.build();
        arrayResult.setTotal(Integer.valueOf(options.getCount()+""));
        return arrayResult;
    
	}

	 private Patient wrapData(IemrPatient imerPatient) {
	    	Patient patient = new Patient();
	    	BeanCopyUtil.entityToModel(patient, imerPatient, null, null);
	    	return patient;
	 }
	 
	 String getParamValue(Map<String, String> params, String paramName){
	        String value = params.get(paramName);
	        if (!StringUtils.hasText(value))
	        {
	            return null;
	        }
	        return value;
	 }

	@Override
	public ArrayResult<Patient> exportExcel(@RequestParam Map<String, String> params) {
		
		String admissionDateStart = getParamValue(params, "admissionDateStart");
        String admissionDateEnd = getParamValue(params, "admissionDateEnd");
        String inpatientNoStart = getParamValue(params, "inpatientNoStart");
        String inpatientNoEnd = getParamValue(params, "inpatientNoEnd");
        String patientName = getParamValue(params, "patientName");
        String sex = getParamValue(params, "sex");
        if("-1".equals(sex)){
        	sex = null;
        }
        String birthdayStart = getParamValue(params, "birthdayStart");
        String birthdayEnd = getParamValue(params, "birthdayEnd");
        String tel = getParamValue(params, "tel");
        String address = getParamValue(params, "address");
        String diagnosis = getParamValue(params, "diagnosis");
        
        List<String> itemValuesList = new ArrayList<String>();
        String itemValues = getParamValue(params, "itemValues");
        if(itemValues != null){
        	String[] split = itemValues.split("\\|\\|");
        	itemValuesList = Arrays.asList(split);
        }

        List<IemrPatient> list = imerPatientDao.selectByAdvancedCondition(itemValuesList,admissionDateStart, admissionDateEnd, inpatientNoStart, 
        		inpatientNoEnd, patientName, sex, birthdayStart, birthdayEnd, tel, address, diagnosis);
        
        //■　装配并返回
        ArrayResultBuilder<Patient> builder = ArrayResultBuilder.newArrayResult(Patient.class);
        int size = 0;
        if (list != null && list.size() > 0)
        {
            Patient[] patientList = new Patient[list.size()];
            int i = 0;
            for (IemrPatient iemrPatient : list)
            {
            	patientList[i] = this.wrapData(iemrPatient);
                i++;
            }
            
            builder.withData(patientList);
            size = patientList.length;
        }
        
        ArrayResult<Patient> arrayResult = builder.build();
        
        String title = "高级检索列表";  
        String[] rowsName = new String[]{"姓名","卡号","就诊日期","来源","性别","年龄","诊断","治疗目标","手术方案"};  
        List<Object[]>  dataList = new ArrayList<Object[]>();  
        Object[] objs = null;  
        for (IemrPatient p : list) {  
            objs = new Object[rowsName.length];  
            objs[0] = p.getPatientName(); 
            objs[1] = p.getInpatientNo();
            objs[2] = TimestampToDateString(p.getAdmissionDate()); 
            objs[3] = "";
            objs[4] = getSex(p.getSex());
            objs[5] = p.getAge();
            objs[6] = p.getDiagnosis();
            objs[7] = "";
            objs[8] = "";
            dataList.add(objs);  
    }  
      
    ExcelExport ex = new ExcelExport(response, title, rowsName, dataList);  
    try {
        ex.export();
    } catch (Exception e) {
        e.printStackTrace();
    }  
    
    return arrayResult;
	}
	
	private String TimestampToDateString(Timestamp ts){
		
		String tsStr = "";
		if(ts != null){
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				tsStr = sdf.format(ts);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return tsStr;
		
	}
	
	private String getSex(String code){
		if(code == null)
			return "";
		else if(code.equals("0"))
			return "女";
		else
			return "男";
	}

}
