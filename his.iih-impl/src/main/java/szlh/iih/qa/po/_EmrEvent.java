package szlh.iih.qa.po;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:34.647+0800")
public final class _EmrEvent extends org.seasar.doma.jdbc.entity.AbstractEntityType<szlh.iih.qa.po.EmrEvent> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _EmrEvent __singleton = new _EmrEvent();

    private final org.seasar.doma.jdbc.id.BuiltinIdentityIdGenerator __idGenerator = new org.seasar.doma.jdbc.id.BuiltinIdentityIdGenerator();

    /** the eventid */
    public final org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, szlh.iih.qa.po.EmrEvent, java.lang.Integer, java.lang.Object> $eventid = new org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, szlh.iih.qa.po.EmrEvent, java.lang.Integer, java.lang.Object>(szlh.iih.qa.po.EmrEvent.class, java.lang.Integer.class, org.seasar.doma.wrapper.IntegerWrapper.class, null, null, "eventid", "eventid", __idGenerator);

    /** the recid */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.qa.po.EmrEvent, java.lang.Integer, java.lang.Object> $recid = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.qa.po.EmrEvent, java.lang.Integer, java.lang.Object>(szlh.iih.qa.po.EmrEvent.class, java.lang.Integer.class, org.seasar.doma.wrapper.IntegerWrapper.class, null, null, "recid", "recid", true, true);

    /** the eventtype */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.qa.po.EmrEvent, java.lang.String, java.lang.Object> $eventtype = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.qa.po.EmrEvent, java.lang.String, java.lang.Object>(szlh.iih.qa.po.EmrEvent.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "eventtype", "eventtype", true, true);

    /** the happentime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.qa.po.EmrEvent, java.sql.Timestamp, java.lang.Object> $happentime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.qa.po.EmrEvent, java.sql.Timestamp, java.lang.Object>(szlh.iih.qa.po.EmrEvent.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "happentime", "happentime", true, true);

    /** the note */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.qa.po.EmrEvent, java.lang.String, java.lang.Object> $note = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.qa.po.EmrEvent, java.lang.String, java.lang.Object>(szlh.iih.qa.po.EmrEvent.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "note", "note", true, true);

    /** the treattime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.qa.po.EmrEvent, java.sql.Timestamp, java.lang.Object> $treattime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.qa.po.EmrEvent, java.sql.Timestamp, java.lang.Object>(szlh.iih.qa.po.EmrEvent.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "treattime", "treattime", true, true);

    /** the endtime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.qa.po.EmrEvent, java.sql.Timestamp, java.lang.Object> $endtime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.qa.po.EmrEvent, java.sql.Timestamp, java.lang.Object>(szlh.iih.qa.po.EmrEvent.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "endtime", "endtime", true, true);

    /** the evtSource */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.qa.po.EmrEvent, java.lang.String, java.lang.Object> $evtSource = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.qa.po.EmrEvent, java.lang.String, java.lang.Object>(szlh.iih.qa.po.EmrEvent.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "evtSource", "evt_source", true, true);

    /** the orderSn */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.qa.po.EmrEvent, java.lang.Integer, java.lang.Object> $orderSn = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.qa.po.EmrEvent, java.lang.Integer, java.lang.Object>(szlh.iih.qa.po.EmrEvent.class, java.lang.Integer.class, org.seasar.doma.wrapper.IntegerWrapper.class, null, null, "orderSn", "order_sn", true, true);

    /** the encId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.qa.po.EmrEvent, java.lang.Integer, java.lang.Object> $encId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.qa.po.EmrEvent, java.lang.Integer, java.lang.Object>(szlh.iih.qa.po.EmrEvent.class, java.lang.Integer.class, org.seasar.doma.wrapper.IntegerWrapper.class, null, null, "encId", "enc_id", true, true);

    /** the deletedFlag */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.qa.po.EmrEvent, java.lang.String, java.lang.Object> $deletedFlag = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.qa.po.EmrEvent, java.lang.String, java.lang.Object>(szlh.iih.qa.po.EmrEvent.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "deletedFlag", "deleted_flag", true, true);

    private final szlh.iih.qa.po.EmrEventListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.qa.po.EmrEvent, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.qa.po.EmrEvent, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.qa.po.EmrEvent, ?>> __entityPropertyTypeMap;

    private _EmrEvent() {
        __listener = new szlh.iih.qa.po.EmrEventListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "EmrEvent";
        __catalogName = "";
        __schemaName = "";
        __tableName = "emr_event";
        __qualifiedTableName = "emr_event";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.qa.po.EmrEvent, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.qa.po.EmrEvent, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.qa.po.EmrEvent, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.qa.po.EmrEvent, ?>>(11);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.qa.po.EmrEvent, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.qa.po.EmrEvent, ?>>(11);
        __idList.add($eventid);
        __list.add($eventid);
        __map.put("eventid", $eventid);
        __list.add($recid);
        __map.put("recid", $recid);
        __list.add($eventtype);
        __map.put("eventtype", $eventtype);
        __list.add($happentime);
        __map.put("happentime", $happentime);
        __list.add($note);
        __map.put("note", $note);
        __list.add($treattime);
        __map.put("treattime", $treattime);
        __list.add($endtime);
        __map.put("endtime", $endtime);
        __list.add($evtSource);
        __map.put("evtSource", $evtSource);
        __list.add($orderSn);
        __map.put("orderSn", $orderSn);
        __list.add($encId);
        __map.put("encId", $encId);
        __list.add($deletedFlag);
        __map.put("deletedFlag", $deletedFlag);
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
    public void preInsert(szlh.iih.qa.po.EmrEvent entity, org.seasar.doma.jdbc.entity.PreInsertContext<szlh.iih.qa.po.EmrEvent> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(szlh.iih.qa.po.EmrEvent entity, org.seasar.doma.jdbc.entity.PreUpdateContext<szlh.iih.qa.po.EmrEvent> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(szlh.iih.qa.po.EmrEvent entity, org.seasar.doma.jdbc.entity.PreDeleteContext<szlh.iih.qa.po.EmrEvent> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(szlh.iih.qa.po.EmrEvent entity, org.seasar.doma.jdbc.entity.PostInsertContext<szlh.iih.qa.po.EmrEvent> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(szlh.iih.qa.po.EmrEvent entity, org.seasar.doma.jdbc.entity.PostUpdateContext<szlh.iih.qa.po.EmrEvent> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(szlh.iih.qa.po.EmrEvent entity, org.seasar.doma.jdbc.entity.PostDeleteContext<szlh.iih.qa.po.EmrEvent> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.qa.po.EmrEvent, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.qa.po.EmrEvent, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.qa.po.EmrEvent, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, szlh.iih.qa.po.EmrEvent, ?, ?> getGeneratedIdPropertyType() {
        return $eventid;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, szlh.iih.qa.po.EmrEvent, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public szlh.iih.qa.po.EmrEvent newEntity() {
        return new szlh.iih.qa.po.EmrEvent();
    }

    @Override
    public szlh.iih.qa.po.EmrEvent newEntity(java.util.Map<String, Object> __args) {
        return new szlh.iih.qa.po.EmrEvent();
    }

    @Override
    public Class<szlh.iih.qa.po.EmrEvent> getEntityClass() {
        return szlh.iih.qa.po.EmrEvent.class;
    }

    @Override
    public szlh.iih.qa.po.EmrEvent getOriginalStates(szlh.iih.qa.po.EmrEvent __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(szlh.iih.qa.po.EmrEvent __entity) {
    }

    /**
     * @return the singleton
     */
    public static _EmrEvent getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _EmrEvent newInstance() {
        return new _EmrEvent();
    }

}
