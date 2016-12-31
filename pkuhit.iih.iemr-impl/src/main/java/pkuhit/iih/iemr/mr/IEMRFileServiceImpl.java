package pkuhit.iih.iemr.mr;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import pkuhit.xap.file.FileObject;
import pkuhit.xap.file.FileService;
import xap.sv.annotation.Reference;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;

public class IEMRFileServiceImpl implements IEMRFileService {
	@Reference
	FileService fileService ;
			
	@Override
	public SingleResult<Map> get(String filePk) throws IOException {
		Map map = new HashMap();
		if(null != filePk){
			FileObject file = fileService.getFile(filePk);
			if(null != file){
				String odtFile = new String(file.asByteArray(), "UTF-8");
				map.put("odtFile", odtFile);
			}
		}
		SingleResultBuilder<Map>  builder  = SingleResultBuilder.newSingleResult(Map.class);
		if(map.containsKey("odtFile")){
			builder.withData(map);
		}
		return builder.build();
	}

}
