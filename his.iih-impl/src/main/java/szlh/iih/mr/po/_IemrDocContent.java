package szlh.iih.mr.po;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:23:26.245+0800")
public final class _IemrDocContent extends org.seasar.doma.jdbc.entity.AbstractEntityType<szlh.iih.mr.po.IemrDocContent> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _IemrDocContent __singleton = new _IemrDocContent();

    private final org.seasar.doma.jdbc.id.BuiltinIdentityIdGenerator __idGenerator = new org.seasar.doma.jdbc.id.BuiltinIdentityIdGenerator();

    /** the id */
    public final org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, szlh.iih.mr.po.IemrDocContent, java.lang.Integer, java.lang.Object> $id = new org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, szlh.iih.mr.po.IemrDocContent, java.lang.Integer, java.lang.Object>(szlh.iih.mr.po.IemrDocContent.class, java.lang.Integer.class, org.seasar.doma.wrapper.IntegerWrapper.class, null, null, "id", "id", __idGenerator);

    /** the encounterId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.mr.po.IemrDocContent, java.lang.String, java.lang.Object> $encounterId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.mr.po.IemrDocContent, java.lang.String, java.lang.Object>(szlh.iih.mr.po.IemrDocContent.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "encounterId", "encounter_id", true, true);

    /** the docType */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.mr.po.IemrDocContent, java.lang.String, java.lang.Object> $docType = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.mr.po.IemrDocContent, java.lang.String, java.lang.Object>(szlh.iih.mr.po.IemrDocContent.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "docType", "doc_type", true, true);

    /** the createDate */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.mr.po.IemrDocContent, java.sql.Timestamp, java.lang.Object> $createDate = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.mr.po.IemrDocContent, java.sql.Timestamp, java.lang.Object>(szlh.iih.mr.po.IemrDocContent.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "createDate", "create_date", true, true);

    /** the creator */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.mr.po.IemrDocContent, java.lang.String, java.lang.Object> $creator = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.mr.po.IemrDocContent, java.lang.String, java.lang.Object>(szlh.iih.mr.po.IemrDocContent.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "creator", "creator", true, true);

    /** the docId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.mr.po.IemrDocContent, java.lang.String, java.lang.Object> $docId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.mr.po.IemrDocContent, java.lang.String, java.lang.Object>(szlh.iih.mr.po.IemrDocContent.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "docId", "doc_id", true, true);

    /** the docName */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.mr.po.IemrDocContent, java.lang.String, java.lang.Object> $docName = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.mr.po.IemrDocContent, java.lang.String, java.lang.Object>(szlh.iih.mr.po.IemrDocContent.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "docName", "doc_name", true, true);

    /** the docContent */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.mr.po.IemrDocContent, java.lang.String, java.lang.Object> $docContent = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.mr.po.IemrDocContent, java.lang.String, java.lang.Object>(szlh.iih.mr.po.IemrDocContent.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "docContent", "doc_content", true, true);

    /** the messageId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.mr.po.IemrDocContent, java.lang.String, java.lang.Object> $messageId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.mr.po.IemrDocContent, java.lang.String, java.lang.Object>(szlh.iih.mr.po.IemrDocContent.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "messageId", "message_id", true, true);

    private final szlh.iih.mr.po.IemrDocContentListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.mr.po.IemrDocContent, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.mr.po.IemrDocContent, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.mr.po.IemrDocContent, ?>> __entityPropertyTypeMap;

    private _IemrDocContent() {
        __listener = new szlh.iih.mr.po.IemrDocContentListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "IemrDocContent";
        __catalogName = "";
        __schemaName = "";
        __tableName = "iemr_doc_content";
        __qualifiedTableName = "iemr_doc_content";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.mr.po.IemrDocContent, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.mr.po.IemrDocContent, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.mr.po.IemrDocContent, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.mr.po.IemrDocContent, ?>>(9);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.mr.po.IemrDocContent, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.mr.po.IemrDocContent, ?>>(9);
        __idList.add($id);
        __list.add($id);
        __map.put("id", $id);
        __list.add($encounterId);
        __map.put("encounterId", $encounterId);
        __list.add($docType);
        __map.put("docType", $docType);
        __list.add($createDate);
        __map.put("createDate", $createDate);
        __list.add($creator);
        __map.put("creator", $creator);
        __list.add($docId);
        __map.put("docId", $docId);
        __list.add($docName);
        __map.put("docName", $docName);
        __list.add($docContent);
        __map.put("docContent", $docContent);
        __list.add($messageId);
        __map.put("messageId", $messageId);
        __idPropertyTypes = java.util.Collections.unmodifiableList(__idList);
        __entityPropertyTypes = java.util.Collections.unmodifiableList(__list);
        __entityPropertyTypeMap = java.util.Collections.unmodifiableMap(__map);
    }

    @Override
    public org.seasar.doma.jdbc.entity.NamingType getNamingType() {
        return __namingType;
    }

    @Override
    public boolean isImmutable() {
        return __immutable;
    }

    @Override
    public String getName() {
        return __name;
    }

    @Override
    public String getCatalogName() {
        return __catalogName;
    }

    @Override
    public String getSchemaName() {
        return __schemaName;
    }

    @Override
    public String getTableName() {
        return __tableName;
    }

    @Override
    public String getQualifiedTableName() {
        return __qualifiedTableName;
    }

    @Override
    public void preInsert(szlh.iih.mr.po.IemrDocContent entity, org.seasar.doma.jdbc.entity.PreInsertContext<szlh.iih.mr.po.IemrDocContent> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(szlh.iih.mr.po.IemrDocContent entity, org.seasar.doma.jdbc.entity.PreUpdateContext<szlh.iih.mr.po.IemrDocContent> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(szlh.iih.mr.po.IemrDocContent entity, org.seasar.doma.jdbc.entity.PreDeleteContext<szlh.iih.mr.po.IemrDocContent> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(szlh.iih.mr.po.IemrDocContent entity, org.seasar.doma.jdbc.entity.PostInsertContext<szlh.iih.mr.po.IemrDocContent> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(szlh.iih.mr.po.IemrDocContent entity, org.seasar.doma.jdbc.entity.PostUpdateContext<szlh.iih.mr.po.IemrDocContent> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(szlh.iih.mr.po.IemrDocContent entity, org.seasar.doma.jdbc.entity.PostDeleteContext<szlh.iih.mr.po.IemrDocContent> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.mr.po.IemrDocContent, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.mr.po.IemrDocContent, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.mr.po.IemrDocContent, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, szlh.iih.mr.po.IemrDocContent, ?, ?> getGeneratedIdPropertyType() {
        return $id;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, szlh.iih.mr.po.IemrDocContent, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public szlh.iih.mr.po.IemrDocContent newEntity() {
        return new szlh.iih.mr.po.IemrDocContent();
    }

    @Override
    public szlh.iih.mr.po.IemrDocContent newEntity(java.util.Map<String, Object> __args) {
        return new szlh.iih.mr.po.IemrDocContent();
    }

    @Override
    public Class<szlh.iih.mr.po.IemrDocContent> getEntityClass() {
        return szlh.iih.mr.po.IemrDocContent.class;
    }

    @Override
    public szlh.iih.mr.po.IemrDocContent getOriginalStates(szlh.iih.mr.po.IemrDocContent __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(szlh.iih.mr.po.IemrDocContent __entity) {
    }

    /**
     * @return the singleton
     */
    public static _IemrDocContent getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _IemrDocContent newInstance() {
        return new _IemrDocContent();
    }

}
