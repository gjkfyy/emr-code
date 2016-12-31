package pkuhit.iih.mr;

import pkuhit.iih.mr.wr.MedicalRecord;

public interface MrToCisService {
	/**
	 * 将病历文书以纯文本形式传给Cis系统
	 * @param medicalRecord
	 */
	public void saveMrToCis(MedicalRecord medicalRecord);
}
