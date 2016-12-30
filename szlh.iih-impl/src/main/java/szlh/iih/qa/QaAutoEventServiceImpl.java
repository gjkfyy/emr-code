package szlh.iih.qa;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.qa.EmrEventModel;
import pkuhit.iih.qa.QaAutoEventService;
import szlh.iih.qa.dao.CusQaAutoEventDao;
import szlh.iih.qa.po.EmrEvent;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;

public class QaAutoEventServiceImpl implements QaAutoEventService{

	@Autowired
	CusQaAutoEventDao cusQaAutoEventDao;

	@Override
	public ArrayResult<EmrEventModel> getEventTypeList(String enPk)
			throws Throwable {
		List<EmrEvent> emrEventList = cusQaAutoEventDao.selectEmrEvents(enPk);
		
		ArrayResultBuilder<EmrEventModel> builder = ArrayResultBuilder.newArrayResult(EmrEventModel.class);
		if(emrEventList.size() > 0 ){
			EmrEventModel[] emrEventModelArray = new EmrEventModel[emrEventList.size()];
			
			for(int i=0;i<emrEventList.size();i++){
				EmrEventModel emrEventModel = new  EmrEventModel();
				EmrEvent emrEventEntity = emrEventList.get(i);
				BeanUtils.copyProperties( emrEventEntity,emrEventModel);
				emrEventModelArray[i] = emrEventModel;
				
			}
			builder.withData(emrEventModelArray);
		}
		return builder.build();

	}
	
	
}
