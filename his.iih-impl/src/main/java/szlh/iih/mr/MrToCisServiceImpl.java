package szlh.iih.mr;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import pkuhit.iih.mr.MrToCisService;
import pkuhit.iih.mr.wr.MedicalRecord;
import szlh.iih.db.DomaConfig;
import szlh.iih.mr.dao.CusIemrDocContentDao;
import szlh.iih.mr.dao.IemrDocContentDao;
import szlh.iih.mr.po.IemrDocContent;

public class MrToCisServiceImpl implements MrToCisService
{
    @Autowired
    IemrDocContentDao iemrDocContentDao;
    
    @Autowired
    CusIemrDocContentDao cusIemrDocContentDao;

    /*
     * (non-Javadoc)
     * @see fi.clinical.server.cis.service.MrToCisService#saveMrtoCis(pkuhit.iih.mr.wr.MedicalRecord)
     */
    @Override
    public void saveMrToCis(MedicalRecord medicalRecord)
    {
    	List<IemrDocContent> docList=cusIemrDocContentDao.selectByDocId(medicalRecord.getMrPk());
        if (docList != null && docList.size()>0)
        {
        	IemrDocContent content=docList.get(0);
        	content.setDocName(medicalRecord.getName());
        	content.setDocContent(medicalRecord.getTxtFileData());
        	iemrDocContentDao.updateExcludeNull(content);
        }else {
        	IemrDocContent content=new IemrDocContent();
        	content.setDocId(medicalRecord.getMrPk());
        	content.setCreateDate(new Timestamp(medicalRecord.getCreateTime().getTime()));
        	content.setCreator(medicalRecord.getCreateUserId());
        	content.setDocContent(medicalRecord.getTxtFileData());//病历纯文本
        	content.setDocName(medicalRecord.getName());
        	content.setDocType(medicalRecord.getTypeName());
        	content.setEncounterId(medicalRecord.getEncounterPk());
        	iemrDocContentDao.insert(content);
        }
    }

}
