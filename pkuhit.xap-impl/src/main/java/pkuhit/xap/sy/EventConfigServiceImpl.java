package pkuhit.xap.sy;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import xap.sv.component.LifeCycleComponent;
import xap.sv.event.build.EventSourceBuilder;
import xap.sv.event.source.EventSource;

public class EventConfigServiceImpl implements EventConfigService,LifeCycleComponent
{
    private Logger log = LoggerFactory.getLogger(EventConfigServiceImpl.class);
    
    private Map<String,EventSource> eventMap = new HashMap<String,EventSource>();
    
    @Autowired
    EventSourceBuilder eventSourceBuilder;
    
    @Override
    public void onStart() {
        URL location = null;
        location = this.getClass().getResource("/event.listener.xml");
//      location = ClassLoader.getSystemResource("qa.auto.item.xml");
        if(location != null){
            log.warn("location >>>>>>>>>>>>>>>>>>>>>>>>"+location.getPath());
        }else{
            log.warn("location >>>>>>>>>>>>>>>>>>>>>>>> is null ");
        }
        this.eventMap = eventSourceBuilder.resolve(location);
    }

    @Override
    public void onDestory() {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public Map<String,EventSource> getMap() {
        return this.eventMap;
    }
}
