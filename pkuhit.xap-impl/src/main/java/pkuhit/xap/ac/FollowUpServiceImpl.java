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
			cal.add(Calendar.DAY_OF_MONTH, -6);
			Date day1After = cal.getTime();
			String after1 = df.format(day1After);
			startDate = after1;
			endDate = after7;
		}else if("-7".equalsIgnoreCase(fuDate)){
			cal.add(Calendar.DAY_OF_MONTH, -8);
			Date day1Before = cal.getTime();
			String before1 = df.format(day1Before);
			startDate = before7;
			endDate = before1;
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
               
                //根据入院日期计算出随访状态
                df = new SimpleDateFormat("yyyy-MM-dd");
    			cal = Calendar.getInstance();
    			cal.setTime(new Date());
    			cal.add(Calendar.DAY_OF_MONTH, -7);
    			Date day7Before2 = cal.getTime();
    			
    			cal.add(Calendar.DAY_OF_MONTH, +14);
    			Date day7After2 = cal.getTime();
    			
    			Date date = new Date();
    			try {
    				date = patientList[i].getAdmissionDate();
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    			
    			cal.setTime(date);
    			cal.add(Calendar.MONTH, +3);
    			Date after3m = cal.getTime();
    			
    			cal.add(Calendar.MONTH, +3);
    			Date after6m = cal.getTime();
    			
    			cal.add(Calendar.MONTH, +6);
    			Date after1y = cal.getTime();
    			
    			cal.add(Calendar.MONTH, +24);
    			Date after3y = cal.getTime();
    			
    			String fuStatus = "";
    			if(day7Before2.compareTo(after3m)<0 && day7After2.compareTo(after3m)>0){
    				fuStatus = "待随访（3M）";
    			}else if(day7Before2.compareTo(after6m)<0 && day7After2.compareTo(after6m)>0){
    				fuStatus = "待随访（6M）";
    			}else if(day7Before2.compareTo(after1y)<0 && day7After2.compareTo(after1y)>0){
    				fuStatus = "待随访（1Y）";
    			}else if(day7Before2.compareTo(after3y)<0 && day7After2.compareTo(after3y)>0){
    				fuStatus = "待随访（3Y）";
    			}
            	patientList[i].setFuStutas(fuStatus);
    			
            	i++;
            }
            
            builder.withData(patientList);
            size = patientList.length;
        }
        
        ArrayResult<Patient> ar = builder.build();
      /*  ar.setPageNum(Integer.valueOf(pageNum));
        ar.setPageSize(Integer.valueOf(pageSize));*/
        ar.setTotal(Integer.valueOf(options.getCount()+""));
		ar.setGenericTypeName(String.valueOf((new Date()).getTime()));
        return ar;
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
	public Date getDate() {
		Date date = new Date();
		date.getTime();
		return new Date();
	}
}
