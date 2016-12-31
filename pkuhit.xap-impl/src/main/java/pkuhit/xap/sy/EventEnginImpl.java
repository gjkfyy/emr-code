package pkuhit.xap.sy;

import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xap.sv.annotation.Reference;
import xap.sv.event.engin.EventEngin;
import xap.sv.event.listener.EventListener;
import xap.sv.event.object.EventObject;
import xap.sv.event.source.EventSource;

public class EventEnginImpl implements EventEngin
{
    private Logger log = LoggerFactory.getLogger(EventEnginImpl.class);
    
    @Reference
    EventConfigService eventConfigService;
    
    @Override
    public void fire(String eventCode, Object source) {
        Map<String,EventSource> eventMap = eventConfigService.getMap();
        EventSource eventSource = eventMap.get(eventCode);
        if(eventSource != null){
            EventObject eventObject = new EventObject(source);
            eventSource.setEventObject(eventObject);
            Iterator<EventListener> iterator = eventSource.getListenerList().iterator();  
            EventListener listener ;
            while(iterator.hasNext()){  
                listener = iterator.next();  
                listener.callBack(eventSource.getEventObject());  
            }
        }else{
            log.warn("not founde listener for this eventCode!!!");
        }
    }
}
