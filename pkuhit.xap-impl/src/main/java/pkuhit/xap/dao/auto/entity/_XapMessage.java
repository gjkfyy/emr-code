package pkuhit.xap.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:41.284+0800")
public final class _XapMessage extends org.seasar.doma.jdbc.entity.AbstractEntityType<pkuhit.xap.dao.auto.entity.XapMessage> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _XapMessage __singleton = new _XapMessage();

    /** the mesId */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.lang.String, java.lang.Object> $mesId = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapMessage.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mesId", "MES_ID");

    /** the sendUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.lang.String, java.lang.Object> $sendUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapMessage.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sendUserId", "SEND_USER_ID", true, true);

    /** the sendDate */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.sql.Timestamp, java.lang.Object> $sendDate = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.sql.Timestamp, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapMessage.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "sendDate", "SEND_DATE", true, true);

    /** the receiveUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.lang.String, java.lang.Object> $receiveUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapMessage.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "receiveUserId", "RECEIVE_USER_ID", true, true);

    /** the receiveDate */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.sql.Timestamp, java.lang.Object> $receiveDate = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.sql.Timestamp, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapMessage.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "receiveDate", "RECEIVE_DATE", true, true);

    /** the portalCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.lang.String, java.lang.Object> $portalCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapMessage.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "portalCd", "PORTAL_CD", true, true);

    /** the menuCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.lang.String, java.lang.Object> $menuCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapMessage.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "menuCd", "MENU_CD", true, true);

    /** the content */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.lang.String, java.lang.Object> $content = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapMessage.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "content", "CONTENT", true, true);

    /** the readFlag */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.lang.String, java.lang.Object> $readFlag = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapMessage.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "readFlag", "READ_FLAG", true, true);

    /** the mesLevel */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.lang.Short, java.lang.Object> $mesLevel = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.lang.Short, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapMessage.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "mesLevel", "MES_LEVEL", true, true);

    /** the mesType */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.lang.String, java.lang.Object> $mesType = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapMessage.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mesType", "MES_TYPE", true, true);

    /** the memo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.lang.String, java.lang.Object> $memo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapMessage.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "memo", "MEMO", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.lang.String, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapMessage.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sortNo", "SORT_NO", true, true);

    /** the spellNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.lang.String, java.lang.Object> $spellNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapMessage.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spellNo", "SPELL_NO", true, true);

    /** the wubiNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.lang.String, java.lang.Object> $wubiNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapMessage.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "wubiNo", "WUBI_NO", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.math.BigInteger, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.math.BigInteger, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapMessage.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.sql.Timestamp, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapMessage.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapMessage.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapMessage.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.sql.Timestamp, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapMessage.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapMessage.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapMessage.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.lang.Short, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapMessage.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    /** the taskId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.lang.String, java.lang.Object> $taskId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, java.lang.String, java.lang.Object>(pkuhit.xap.dao.auto.entity.XapMessage.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "taskId", "TASK_ID", true, true);

    private final pkuhit.xap.dao.auto.entity.XapMessageListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapMessage, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapMessage, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapMessage, ?>> __entityPropertyTypeMap;

    private _XapMessage() {
        __listener = new pkuhit.xap.dao.auto.entity.XapMessageListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "XapMessage";
        __catalogName = "";
        __schemaName = "";
        __tableName = "XAP_MESSAGE";
        __qualifiedTableName = "XAP_MESSAGE";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapMessage, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapMessage, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapMessage, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapMessage, ?>>(24);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapMessage, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapMessage, ?>>(24);
        __idList.add($mesId);
        __list.add($mesId);
        __map.put("mesId", $mesId);
        __list.add($sendUserId);
        __map.put("sendUserId", $sendUserId);
        __list.add($sendDate);
        __map.put("sendDate", $sendDate);
        __list.add($receiveUserId);
        __map.put("receiveUserId", $receiveUserId);
        __list.add($receiveDate);
        __map.put("receiveDate", $receiveDate);
        __list.add($portalCd);
        __map.put("portalCd", $portalCd);
        __list.add($menuCd);
        __map.put("menuCd", $menuCd);
        __list.add($content);
        __map.put("content", $content);
        __list.add($readFlag);
        __map.put("readFlag", $readFlag);
        __list.add($mesLevel);
        __map.put("mesLevel", $mesLevel);
        __list.add($mesType);
        __map.put("mesType", $mesType);
        __list.add($memo);
        __map.put("memo", $memo);
        __list.add($sortNo);
        __map.put("sortNo", $sortNo);
        __list.add($spellNo);
        __map.put("spellNo", $spellNo);
        __list.add($wubiNo);
        __map.put("wubiNo", $wubiNo);
        __list.add($updCnt);
        __map.put("updCnt", $updCnt);
        __list.add($crtTime);
        __map.put("crtTime", $crtTime);
        __list.add($crtUserId);
        __map.put("crtUserId", $crtUserId);
        __list.add($crtDeptCd);
        __map.put("crtDeptCd", $crtDeptCd);
        __list.add($lastUpdTime);
        __map.put("lastUpdTime", $lastUpdTime);
        __list.add($lastUpdDeptCd);
        __map.put("lastUpdDeptCd", $lastUpdDeptCd);
        __list.add($lastUpdUserId);
        __map.put("lastUpdUserId", $lastUpdUserId);
        __list.add($delF);
        __map.put("delF", $delF);
        __list.add($taskId);
        __map.put("taskId", $taskId);
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
    public void preInsert(pkuhit.xap.dao.auto.entity.XapMessage entity, org.seasar.doma.jdbc.entity.PreInsertContext<pkuhit.xap.dao.auto.entity.XapMessage> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(pkuhit.xap.dao.auto.entity.XapMessage entity, org.seasar.doma.jdbc.entity.PreUpdateContext<pkuhit.xap.dao.auto.entity.XapMessage> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(pkuhit.xap.dao.auto.entity.XapMessage entity, org.seasar.doma.jdbc.entity.PreDeleteContext<pkuhit.xap.dao.auto.entity.XapMessage> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(pkuhit.xap.dao.auto.entity.XapMessage entity, org.seasar.doma.jdbc.entity.PostInsertContext<pkuhit.xap.dao.auto.entity.XapMessage> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(pkuhit.xap.dao.auto.entity.XapMessage entity, org.seasar.doma.jdbc.entity.PostUpdateContext<pkuhit.xap.dao.auto.entity.XapMessage> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(pkuhit.xap.dao.auto.entity.XapMessage entity, org.seasar.doma.jdbc.entity.PostDeleteContext<pkuhit.xap.dao.auto.entity.XapMessage> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapMessage, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapMessage, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.xap.dao.auto.entity.XapMessage, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, pkuhit.xap.dao.auto.entity.XapMessage, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public pkuhit.xap.dao.auto.entity.XapMessage newEntity() {
        return new pkuhit.xap.dao.auto.entity.XapMessage();
    }

    @Override
    public pkuhit.xap.dao.auto.entity.XapMessage newEntity(java.util.Map<String, Object> __args) {
        return new pkuhit.xap.dao.auto.entity.XapMessage();
    }

    @Override
    public Class<pkuhit.xap.dao.auto.entity.XapMessage> getEntityClass() {
        return pkuhit.xap.dao.auto.entity.XapMessage.class;
    }

    @Override
    public pkuhit.xap.dao.auto.entity.XapMessage getOriginalStates(pkuhit.xap.dao.auto.entity.XapMessage __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(pkuhit.xap.dao.auto.entity.XapMessage __entity) {
    }

    /**
     * @return the singleton
     */
    public static _XapMessage getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _XapMessage newInstance() {
        return new _XapMessage();
    }

}
