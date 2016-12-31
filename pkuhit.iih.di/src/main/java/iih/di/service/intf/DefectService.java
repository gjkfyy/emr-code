package iih.di.service.intf;

import java.util.Map;

import iih.di.DefectNotice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface DefectService
{
    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/defect_notice", method = RequestMethod.GET)
    DefectNotice[] getDefectNoticeList(@RequestParam Map params);
}
