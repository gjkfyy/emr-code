package pkuhit.iih.mr.wr;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;

public interface ArchiveService {
	@RequestMapping(value = "/mr/archive/mrArchive", method = RequestMethod.PUT)
	ArrayResult<ArchiveFile> mrArchive(@ModelAttribute MedicalRecordList ms);
	
	@RequestMapping(value = "/mr/archive/amrArchive/{id}", method = RequestMethod.GET)
	ArrayResult<ArchiveFile> amrArchive(@PathVariable("id") String enPk);
	
	@RequestMapping(value = "/mr/archive/amrListArchive/{id}", method = RequestMethod.GET)
	SingleResult<ArchiveFile> amrListArchive(@PathVariable("id") String enPks);
}
