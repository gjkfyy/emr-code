package pkuhit.xap.ac;

import java.sql.Timestamp;
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
import xap.sv.model.SingleResult;
import xap.util.UUIDGenerator;
public class PatientServiceImpl implements PatientService
{
    @Autowired
    IemrPatientDao imerPatientDao;

    //新建患者
	@Override
	public Patient create(Patient patient) {
		patient.setPatientId(UUIDGenerator.getUUID());
		patient.setDelF((short)0);
		patient.setCrtTime(new Timestamp(new Date().getTime()));
		patient.setLastUpdateTime(new Timestamp(new Date().getTime()));
		IemrPatient iemrPatient = new IemrPatient();
		BeanCopyUtil.modelToEntity(iemrPatient, patient);
		imerPatientDao.insert(iemrPatient);
		return patient;
	}

	@Override
	public SingleResult<Patient> update(String patientId, Patient patient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SingleResult<Patient> selectPatientById(String patientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(String patientId) {
		// TODO Auto-generated method stub
		return null;
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
		 //wangyanli add 添加参数 dctNsF 2016-11-8
        String condition = getParamValue(params, "condition");
        if("输入姓名、住院号、入院时间检索".equalsIgnoreCase(condition)){
        	condition = null;
        }
        List<IemrPatient> list = imerPatientDao.selectIemrPatientList(condition,options);
        
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
