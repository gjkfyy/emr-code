package pkuhit.xap.ac;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import pkuhit.xap.dao.auto.IemrPatientDao;
import pkuhit.xap.dao.auto.entity.IemrPatient;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
public class FollowUpServiceImpl implements FollowUpService
{
    @Autowired
    IemrPatientDao imerPatientDao;

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
		
		//默认最近14天
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DAY_OF_MONTH, -7);
		Date day7Before = cal.getTime();
		String before7 = df.format(day7Before);
		
		cal.add(Calendar.DAY_OF_MONTH, +14);
		Date day7After = cal.getTime();
		String after7 = df.format(day7After);
		
		String fuDate = getParamValue(params, "fuDate");
		String startDate = "2017-4-05";
	    String endDate = "2017-4-09";
		if("14".equalsIgnoreCase(fuDate)){
			startDate = before7;
			endDate = after7;
		}else if("7".equalsIgnoreCase(fuDate)){
			
		}else if("-7".equalsIgnoreCase(fuDate)){
			
		}else if("all".equalsIgnoreCase(fuDate)){
			startDate = null;
			endDate = null;
		}
		
		//患者姓名查询
		String fuType = getParamValue(params, "fuType");
		String fuValue = getParamValue(params, "fuValue");
		String patientName = "";
		String inpatientNo = "";
		String tel = "";
        if("patientName".equalsIgnoreCase(fuType)){
        	patientName = fuValue;
        }else if("inpatientNo".equalsIgnoreCase(fuType)){
        	inpatientNo = fuValue;
        }else if("tel".equalsIgnoreCase(fuType)){
        	tel = fuValue;
        }
        
        String diagnosis = getParamValue(params, "diagnosis");
        String fuFlag = getParamValue(params, "fuFlag");
       
        List<IemrPatient> list = imerPatientDao.selectFollowUpList(startDate,endDate,patientName,inpatientNo,tel,diagnosis,fuFlag,options);
        
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
	 

}
