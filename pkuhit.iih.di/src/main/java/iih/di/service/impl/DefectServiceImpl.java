package iih.di.service.impl;

import java.util.Map;

import iih.di.Defect;
import iih.di.DefectNotice;
import iih.di.service.intf.DefectService;

public class DefectServiceImpl implements DefectService
{
    @Override
    @SuppressWarnings("rawtypes")
    public DefectNotice[] getDefectNoticeList(Map params)
    {
        DefectNotice dn = new DefectNotice();
        dn.setDefectNoticeCd("notice22");
        Defect defect = new Defect();
        defect.setName("defect22");
        defect.setBugCd("22");
        dn.setDefects(new Defect[] { defect });
        return new DefectNotice[] { dn };
    }
}
