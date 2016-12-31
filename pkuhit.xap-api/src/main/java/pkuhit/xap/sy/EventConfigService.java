package pkuhit.xap.sy;

import java.util.Map;

import xap.sv.event.source.EventSource;

public interface EventConfigService
{
    Map<String,EventSource> getMap();
}
