package pkuhit.me;

public interface DataObjectMetadataRepository
{
    DataObjectMetadata getDataObjectMetadata(String objectCd);

    DataObjectMetadata getDataObjectMetadataByAttribute(String attributeCd);

    DataObjectMetadata[] getAllDataObjectMetadatas();
}
