package pkuhit.me;

import xap.sv.annotation.Service;

@Service
public interface DataObjectSource
{
    DataObject getDataObject(DataObjectId id,
            DataObjectMetadata metadata);

    boolean support(DataObjectMetadata metadata);
}
