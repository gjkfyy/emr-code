package ei.iih.db.cfg;


public class CustomerContextHolder {
	
	public static final String DATASOURCE_HIS = "his";
	
	public static final String DATASOURCE_CIS = "cis";
	
	public static final String DATASOURCE_IEMR = "iemr";

	public static final String DATASOURCE_RIS = "ris";
	
	public static final String DATASOURCE_DI = "di";
	
	public static final String DATASOURCE_LIS = "lis";
	
	public static final String DATASOURCE_ASS_DI_MZ = "ass.di.mz";  //助手区，诊断，门诊
	
	public static final String DATASOURCE_ASS_DI_ZY = "ass.di.zy";  //助手区，诊断，住院
	
	public static final String DATASOURCE_ASS_OR_MZ = "ass.or.mz";  //助手区，医嘱，门诊
	
	public static final String DATASOURCE_ASS_OR_ZY = "ass.or.zy";  //助手区，医嘱，住院
	
	public static final String DATASOURCE_ASS_NU_MZ = "ass.nu.mz";  //助手区，生命体征，门诊
	
	public static final String DATASOURCE_ASS_NU_ZY = "ass.nu.zy";  //助手区，生命体征，住院
	
	public static final String DATASOURCE_XML_PA_ZY = "xml.pa.zy";  //xml使用，患者信息，住院
	
	/**
	 * 构造器
	 */
	public CustomerContextHolder() {
		// TODO Auto-generated constructor stub
	}

	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	public static void setCustomerType(String customerType) {
		contextHolder.set(customerType);
	}

	public static String getCustomerType() {
		return contextHolder.get();
	}

	public static void clearCustomerType() {
		contextHolder.remove();
	}

	/**
	 * FIXME
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
