package pkuhit.xap.mes;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.md.DictionaryService;
import pkuhit.md.SysFunctionCode;
import pkuhit.xap.dao.auto.XapMessageDao;
import pkuhit.xap.dao.auto.XapTaskDao;
import pkuhit.xap.dao.auto.entity.XapMessage;
import pkuhit.xap.dao.auto.entity.XapTask;
import pkuhit.xap.dao.custom.CustomXapMessageDao;
import pkuhit.xap.pm.Param;
import pkuhit.xap.pm.ParamsService;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;

public class MessageServiceImpl implements MessageService {

	@Autowired
	XapMessageDao xapMessageDao;
	
	@Autowired
    XapTaskDao xapTaskDao;

	@Autowired
	CustomXapMessageDao customXapMessageDao;

	@Reference
	DictionaryService dictionaryService;
	
	@Reference
	ParamsService paramsService;

	@Override
	public boolean sendMessage(Message message) {
		// TODO Auto-generated method stub
		XapMessage xapMessage = new XapMessage();
		BeanCopyUtil.modelToEntity(xapMessage, message);
		try {
			xapMessageDao.insert(xapMessage);
			
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public ArrayResult<Message> getMessageByUser(Map<String, String> params) {
	    ArrayResultBuilder<Message> builder = ArrayResultBuilder.newArrayResult(Message.class);
	    ArrayResult<Message> msgArrayResult = new ArrayResult<Message>();
	    String userCd = params.get("userCd");
		String pageNum = params.get("pageNum");
        String pageSize = params.get("pageSize");
        if(StringUtils.isBlank(pageNum)){
            pageNum = "1" ;
        }
        if(StringUtils.isBlank(pageSize)){
            pageSize = "20" ;
        }
		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();          
//		List<XapMessage> messageMapList = customXapMessageDao.selectXapMessageByUserId(userCd, options);
		List<Map<String, Object>> messageMapList = customXapMessageDao.selectXapMessageByUserId(userCd, options);
		int total = 0;
		if (messageMapList != null) {
		    long count = options.getCount();
            total = Long.valueOf(count).intValue();
			Message[] messageList = new Message[messageMapList.size()];
//			int i = 0;
//			for (XapMessage xapMessage : messageMapList) {
			for (int i=0; i<messageMapList.size();i++) {
				Message message = new Message();
//				BeanCopyUtil.entityToModel(message, xapMessage, null, dictionaryService);
				BeanCopyUtil.mapToModel(message, messageMapList.get(i), dictionaryService);
				if(message.getTaskId() != null && !"".equals(message.getTaskId())){
				    XapTask task = xapTaskDao.selectById(message.getTaskId());
				    if(task != null){
				        message.setTaskTypeCd(task.getTaskTypeCd());
	                    message.setRevisionCd(task.getDocSn());
	                    message.setStatus(task.getStatus());
	                    message.setEncounterSn(task.getEncounterSn());
				    }
				}
				messageList[i] = message;
//				i++;
			}
			builder.withData(messageList);
		}
		msgArrayResult = builder.build();
		msgArrayResult.setTotal(total);
		
		return msgArrayResult;
	}

	@Override
    public SingleResult<Message> getMessageById(String messageId) {
	    SingleResult<Message> result;
        SingleResultBuilder<Message> builder = SingleResultBuilder.newSingleResult(Message.class);
	    XapMessage xapMessage = xapMessageDao.selectById(messageId);
        if(xapMessage != null){
            Message message = new Message();
            BeanCopyUtil.entityToModel(message, xapMessage, null,
                    dictionaryService);
            builder.withData(message);
        }
        result = builder.build();
        return result;
    }
	
	@Override
	public boolean deleteMessage(String messageId) {
		// TODO Auto-generated method stub
		XapMessage xapMessage = xapMessageDao.selectById(messageId);
		try {
			xapMessageDao.delete(xapMessage);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	@Override
    public boolean batchDeleteMessage(Map map) {
        List<Map> list = (List<Map>)map.get("ids");
        boolean result = true;
        for(int i=0;i<list.size();i++){
            String pk = (String)list.get(i).get("mesId");
            if(!deleteMessage(pk))return false;
        }
        return result;
    }

	@Override
	public boolean changeMessageReadFlag(String messageId) {
		// TODO Auto-generated method stub
		XapMessage xapMessage = xapMessageDao.selectById(messageId);
		xapMessage.setReadFlag("1");
		try {
			xapMessageDao.updateExcludeNull(xapMessage);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean batchChangeMessageReadFlag(Map map) {
	    List<Map> list = (List<Map>)map.get("ids");
	    boolean result = true;
	    for(int i=0;i<list.size();i++){
            String pk = (String)list.get(i).get("mesId");
            if(!changeMessageReadFlag(pk))return false;
        }
		return result;
	}

	@Override
	public ArrayResult<Message> getMessageByUserAndReadFlag(
			Map<String, String> params) {
		// TODO Auto-generated method stub
		String userCd = params.get("userCd");
		String readFlag = params.get("readFlag");
		if (readFlag == null) {
			readFlag = Message.READ_FLAG_BEFORE;
		}
//		List<XapMessage> messageMapList = customXapMessageDao.selectXapMessageByUserIdAndReadFlag(userCd,readFlag);
		List<Map<String, Object>> messageMapList = customXapMessageDao.selectXapMessageByUserIdAndReadFlag(userCd,readFlag);
		ArrayResult<Message> arrayResult = new ArrayResult<Message>();
		if (messageMapList != null) {
			Message[] messageList = new Message[messageMapList.size()];
//			int i = 0;
//			for (XapMessage xapMessage : messageMapList) {
			for (int i=0; i<messageMapList.size();i++){
				Message message = new Message();
//				BeanCopyUtil.entityToModel(message, xapMessage, null, dictionaryService);
				BeanCopyUtil.mapToModel(message, messageMapList.get(i), dictionaryService);
				messageList[i] = message;
//				i++;
			}
			arrayResult.setDataList(messageList);
		}
		return arrayResult;
	}

	/**
	 * 时限质控类型是否需要根据截止时间来获取消息列表
	 * 获取消息时时限类型截止时间前多长时间进行提醒
	 * 规则为：如果值=正整数则时限质控在截止时间前某小时内接收消息进行提醒，如果值!=0则接收到消息即展现
	 * @return
	 */
	private int getRemindLasttime() {
		int remindLasttime = 0;
		Param[] lasttimeParams=paramsService.getParam(SysFunctionCode.MESSAGE_REMIND_LASTTIME).getDataList();
		for(int i=0; i<lasttimeParams.length ; i++){
			Param param=lasttimeParams[i];
			if(param.getKey().equals("MESSAGE_REMIND_LASTTIME") && null!=param.getValue()){
				remindLasttime=Integer.parseInt(param.getValue());
				break;
			}
		}
		return remindLasttime;
	}
}
