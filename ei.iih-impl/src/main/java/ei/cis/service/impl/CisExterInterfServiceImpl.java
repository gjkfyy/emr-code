package ei.cis.service.impl;

import pkuhit.xap.ei.ExterInterf;
import pkuhit.xap.ei.ExterInterfCode;
import pkuhit.xap.ei.ExternalInterfService;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import ei.cis.service.CisExterInterfService;

public class CisExterInterfServiceImpl implements CisExterInterfService{
    
    @Reference
    ExternalInterfService externalInterfService;

	@Override
	public SingleResult<ExterInterf> searchExterInterf(String exterInterfCd) {
		// TODO Auto-generated method stub
		SingleResultBuilder<ExterInterf> builder = SingleResultBuilder.newSingleResult(ExterInterf.class);
		//cis门诊处方调用
		String cisRecipe =  ExterInterfCode.CIS_RECIPE;
		if(cisRecipe.equals(exterInterfCd)){
			ArrayResult<ExterInterf> exterInterfs = externalInterfService.getExternalInterf(exterInterfCd);
			ExterInterf[] exterInterfArray = exterInterfs.getDataList();
			if(exterInterfArray != null && exterInterfArray.length>0){
				ExterInterf exterInterf = exterInterfArray[0];
				builder.withData(exterInterf);
			}
		}
		SingleResult rs = builder.build();
		return rs;
	}
    

}
