package pkuhit.xap.ac;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import pkuhit.xap.dao.auto.IemrPatientDao;
import pkuhit.xap.dao.auto.entity.IemrPatient;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestParam;
public class FollowUpServiceImpl implements FollowUpService
{
    /**
	 * 
	 */
	@Autowired
    IemrPatientDao imerPatientDao;
     
	//private static final ThreadLocal<HttpServletRequest> requestContainer = new ThreadLocal<HttpServletRequest>();
	
	 private static final ThreadLocal<HttpServletResponse> responseContainer = new ThreadLocal<HttpServletResponse>();
	 
	// private static final ThreadLocal<ModelMap> modelContainer = new ThreadLocal<ModelMap>();
	 
	 @ModelAttribute
	 private final void initResponse(HttpServletResponse response) {
	          responseContainer.set(response);
	 }
	 
	 @ModelAttribute
	 protected final HttpServletResponse getResponse() {
		        return responseContainer.get();
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
    			
    			cal.add(Calendar.MONTH, +24);
    			Date after5y = cal.getTime();
    			
    			String fuStatus = "";
    			if(day7Before2.compareTo(after3m)<0 && day7After2.compareTo(after3m)>0){
    				if("1".equalsIgnoreCase(patientList[i].getFuFlag())){
    					fuStatus = "待随访（3M）";
    				}else if("2".equalsIgnoreCase(patientList[i].getFuFlag())){
    					fuStatus = "已随访（3M）";
    				}else if("3".equalsIgnoreCase(patientList[i].getFuFlag())){
    					fuStatus = "已忽略（3M）";
    				}
    			}else if(day7Before2.compareTo(after6m)<0 && day7After2.compareTo(after6m)>0){
    				if("1".equalsIgnoreCase(patientList[i].getFuFlag())){
    					fuStatus = "待随访（6M）";
    				}else if("2".equalsIgnoreCase(patientList[i].getFuFlag())){
    					fuStatus = "已随访（6M）";
    				}else if("3".equalsIgnoreCase(patientList[i].getFuFlag())){
    					fuStatus = "已忽略（6M）";
    				}
    			}else if(day7Before2.compareTo(after1y)<0 && day7After2.compareTo(after1y)>0){
    				if("1".equalsIgnoreCase(patientList[i].getFuFlag())){
    					fuStatus = "待随访（1Y）";
    				}else if("2".equalsIgnoreCase(patientList[i].getFuFlag())){
    					fuStatus = "已随访（1Y）";
    				}else if("3".equalsIgnoreCase(patientList[i].getFuFlag())){
    					fuStatus = "已忽略（1Y）";
    				}
    			}else if(day7Before2.compareTo(after3y)<0 && day7After2.compareTo(after3y)>0){
    				if("1".equalsIgnoreCase(patientList[i].getFuFlag())){
    					fuStatus = "待随访（3Y）";
    				}else if("2".equalsIgnoreCase(patientList[i].getFuFlag())){
    					fuStatus = "已随访（3Y）";
    				}else if("3".equalsIgnoreCase(patientList[i].getFuFlag())){
    					fuStatus = "已忽略（3Y）";
    				}
    			}else if(day7Before2.compareTo(after5y)<0 && day7After2.compareTo(after5y)>0){
    				if("1".equalsIgnoreCase(patientList[i].getFuFlag())){
    					fuStatus = "待随访（5Y）";
    				}else if("2".equalsIgnoreCase(patientList[i].getFuFlag())){
    					fuStatus = "已随访（5Y）";
    				}else if("3".equalsIgnoreCase(patientList[i].getFuFlag())){
    					fuStatus = "已忽略（5Y）";
    				}
    			}
            	patientList[i].setFuStatus(fuStatus);
    			
            	i++;
            }
            
            builder.withData(patientList);
            size = patientList.length;
        }
        
        ArrayResult<Patient> ar = builder.build();
        ar.setPageNum(Integer.valueOf(pageNum));
        ar.setPageSize(Integer.valueOf(pageSize));
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

	
	/**
	 * 更新随访状态和备注信息
	 */
	@Override
	public SingleResult<Patient> saveFlag(String patientId, Patient patient) {
		patient.setPatientId(patientId);
		IemrPatient iemrPatient = imerPatientDao.selectIemrPatientById(patientId);
		BigInteger newUpdCnt = iemrPatient.getUpdCnt().add(BigInteger.valueOf(1));
		BeanCopyUtil.modelToEntity(iemrPatient, patient);
		iemrPatient.setFuFlag(patient.getFuFlag());
		iemrPatient.setRemark(patient.getRemark());
		iemrPatient.setLastUpdTime(new Timestamp(new Date().getTime()));
		iemrPatient.setUpdCnt(newUpdCnt);
		imerPatientDao.updateExcludeNull(iemrPatient);
		SingleResultBuilder<Patient> builder = SingleResultBuilder.newSingleResult(Patient.class);
        builder.withData(iemrPatient);
		return builder.build();
	}

	@Override
	public void followUpListaa(@RequestParam Map<String, String> params) {
		
		//默认最近14天
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		
		HttpServletResponse response11 = ((ServletWebRequest)RequestContextHolder.getRequestAttributes()).getResponse();
		
//		HttpServletResponse response = (RequestContextHolder.getRequestAttributes()).get.getResponse();
		//HttpServletResponse resp = (()RequestContextHolder.getRequestAttributes()).getResponse();  
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
        SelectOptions options = SelectOptions.get();
        List<IemrPatient> list = imerPatientDao.selectFollowUpList(startDate,endDate,patientName,inpatientNo,tel,diagnosis,fuFlag,options);
        
        //■　装配并返回
        ArrayResultBuilder<Patient> builder = ArrayResultBuilder.newArrayResult(Patient.class);
        int size = 0;
        JSONArray result = new JSONArray();
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
    			
    			cal.add(Calendar.MONTH, +24);
    			Date after5y = cal.getTime();
    			
    			String fuStatus = "";
    			if(day7Before2.compareTo(after3m)<0 && day7After2.compareTo(after3m)>0){
    				if("1".equalsIgnoreCase(patientList[i].getFuFlag())){
    					fuStatus = "待随访（3M）";
    				}else if("2".equalsIgnoreCase(patientList[i].getFuFlag())){
    					fuStatus = "已随访（3M）";
    				}else if("3".equalsIgnoreCase(patientList[i].getFuFlag())){
    					fuStatus = "已忽略（3M）";
    				}
    			}else if(day7Before2.compareTo(after6m)<0 && day7After2.compareTo(after6m)>0){
    				if("1".equalsIgnoreCase(patientList[i].getFuFlag())){
    					fuStatus = "待随访（6M）";
    				}else if("2".equalsIgnoreCase(patientList[i].getFuFlag())){
    					fuStatus = "已随访（6M）";
    				}else if("3".equalsIgnoreCase(patientList[i].getFuFlag())){
    					fuStatus = "已忽略（6M）";
    				}
    			}else if(day7Before2.compareTo(after1y)<0 && day7After2.compareTo(after1y)>0){
    				if("1".equalsIgnoreCase(patientList[i].getFuFlag())){
    					fuStatus = "待随访（1Y）";
    				}else if("2".equalsIgnoreCase(patientList[i].getFuFlag())){
    					fuStatus = "已随访（1Y）";
    				}else if("3".equalsIgnoreCase(patientList[i].getFuFlag())){
    					fuStatus = "已忽略（1Y）";
    				}
    			}else if(day7Before2.compareTo(after3y)<0 && day7After2.compareTo(after3y)>0){
    				if("1".equalsIgnoreCase(patientList[i].getFuFlag())){
    					fuStatus = "待随访（3Y）";
    				}else if("2".equalsIgnoreCase(patientList[i].getFuFlag())){
    					fuStatus = "已随访（3Y）";
    				}else if("3".equalsIgnoreCase(patientList[i].getFuFlag())){
    					fuStatus = "已忽略（3Y）";
    				}
    			}else if(day7Before2.compareTo(after5y)<0 && day7After2.compareTo(after5y)>0){
    				if("1".equalsIgnoreCase(patientList[i].getFuFlag())){
    					fuStatus = "待随访（5Y）";
    				}else if("2".equalsIgnoreCase(patientList[i].getFuFlag())){
    					fuStatus = "已随访（5Y）";
    				}else if("3".equalsIgnoreCase(patientList[i].getFuFlag())){
    					fuStatus = "已忽略（5Y）";
    				}
    			}
            	patientList[i].setFuStatus(fuStatus);
    			
            	i++;
            	JSONObject jo = new JSONObject();
                jo.put("patientName", iemrPatient.getParentName());
                jo.put("sex", iemrPatient.getSex());
                jo.put("age", iemrPatient.getAge());
                result.add(jo);
            }
            builder.withData(patientList);
            size = patientList.length;
        }
        
        ArrayResult<Patient> ar = builder.build();
		
        
        Map<String,String> headMap = new LinkedHashMap<String,String>();
        headMap.put("patientName","姓名");
        headMap.put("age","年龄");
        headMap.put("sex","性别");
      
	}
}
