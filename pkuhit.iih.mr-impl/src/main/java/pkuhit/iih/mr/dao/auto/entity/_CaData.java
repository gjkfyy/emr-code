package pkuhit.iih.mr.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:25.728+0800")
public final class _CaData extends org.seasar.doma.jdbc.entity.AbstractEntityType<pkuhit.iih.mr.dao.auto.entity.CaData> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _CaData __singleton = new _CaData();

    /** the caSn */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.CaData, java.lang.String, java.lang.Object> $caSn = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.CaData, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.CaData.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "caSn", "CA_SN");

    /** the empId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.CaData, java.lang.String, java.lang.Object> $empId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.CaData, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.CaData.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "empId", "EMP_ID", true, true);

    /** the enPk */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.CaData, java.lang.String, java.lang.Object> $enPk = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.CaData, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.CaData.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "enPk", "EN_PK", true, true);

    /** the dataId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.CaData, java.lang.String, java.lang.Object> $dataId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.CaData, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.CaData.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "dataId", "DATA_ID", true, true);

    /** the dataSn */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.CaData, java.lang.String, java.lang.Object> $dataSn = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.CaData, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.CaData.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "dataSn", "DATA_SN", true, true);

    /** the dataXml */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.CaData, java.sql.Clob, java.lang.Object> $dataXml = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.CaData, java.sql.Clob, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.CaData.class, java.sql.Clob.class, org.seasar.doma.wrapper.ClobWrapper.class, null, null, "dataXml", "DATA_XML", true, true);

    /** the certId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.CaData, java.lang.String, java.lang.Object> $certId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.CaData, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.CaData.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "certId", "CERT_ID", true, true);

    /** the certValue */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.CaData, java.lang.String, java.lang.Object> $certValue = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.CaData, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.CaData.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "certValue", "CERT_VALUE", true, true);

    /** the caData */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.CaData, java.sql.Clob, java.lang.Object> $caData = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.CaData, java.sql.Clob, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.CaData.class, java.sql.Clob.class, org.seasar.doma.wrapper.ClobWrapper.class, null, null, "caData", "CA_DATA", true, true);

    /** the tsData */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.CaData, java.sql.Clob, java.lang.Object> $tsData = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.CaData, java.sql.Clob, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.CaData.class, java.sql.Clob.class, org.seasar.doma.wrapper.ClobWrapper.class, null, null, "tsData", "TS_DATA", true, true);

    /** the createTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.CaData, java.sql.Timestamp, java.lang.Object> $createTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.CaData, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.CaData.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "createTime", "CREATE_TIME", true, true);

    /** the sysCode */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.CaData, java.lang.String, java.lang.Object> $sysCode = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.CaData, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.CaData.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sysCode", "SYS_CODE", true, true);

    /** the module */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.CaData, java.lang.String, java.lang.Object> $module = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.CaData, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.CaData.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "module", "MODULE", true, true);

    /** the caState */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.CaData, java.lang.String, java.lang.Object> $caState = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.CaData, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.CaData.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "caState", "CA_STATE", true, true);

    private final pkuhit.iih.mr.dao.auto.entity.CaDataListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.CaData, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.CaData, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.CaData, ?>> __entityPropertyTypeMap;

    private _CaData() {
        __listener = new pkuhit.iih.mr.dao.auto.entity.CaDataListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "CaData";
        __catalogName = "";
        __schemaName = "";
        __tableName = "CA_DATA";
        __qualifiedTableName = "CA_DATA";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.CaData, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.CaData, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.CaData, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.CaData, ?>>(14);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.CaData, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.CaData, ?>>(14);
        __idList.add($caSn);
        __list.add($caSn);
        __map.put("caSn", $caSn);
        __list.add($empId);
        __map.put("empId", $empId);
        __list.add($enPk);
        __map.put("enPk", $enPk);
        __list.add($dataId);
        __map.put("dataId", $dataId);
        __list.add($dataSn);
        __map.put("dataSn", $dataSn);
        __list.add($dataXml);
        __map.put("dataXml", $dataXml);
        __list.add($certId);
        __map.put("certId", $certId);
        __list.add($certValue);
        __map.put("certValue", $certValue);
        __list.add($caData);
        __map.put("caData", $caData);
        __list.add($tsData);
        __map.put("tsData", $tsData);
        __list.add($createTime);
        __map.put("createTime", $createTime);
        __list.add($sysCode);
        __map.put("sysCode", $sysCode);
        __list.add($module);
        __map.put("module", $module);
        __list.add($caState);
        __map.put("caState", $caState);
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
    public void preInsert(pkuhit.iih.mr.dao.auto.entity.CaData entity, org.seasar.doma.jdbc.entity.PreInsertContext<pkuhit.iih.mr.dao.auto.entity.CaData> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(pkuhit.iih.mr.dao.auto.entity.CaData entity, org.seasar.doma.jdbc.entity.PreUpdateContext<pkuhit.iih.mr.dao.auto.entity.CaData> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(pkuhit.iih.mr.dao.auto.entity.CaData entity, org.seasar.doma.jdbc.entity.PreDeleteContext<pkuhit.iih.mr.dao.auto.entity.CaData> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(pkuhit.iih.mr.dao.auto.entity.CaData entity, org.seasar.doma.jdbc.entity.PostInsertContext<pkuhit.iih.mr.dao.auto.entity.CaData> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(pkuhit.iih.mr.dao.auto.entity.CaData entity, org.seasar.doma.jdbc.entity.PostUpdateContext<pkuhit.iih.mr.dao.auto.entity.CaData> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(pkuhit.iih.mr.dao.auto.entity.CaData entity, org.seasar.doma.jdbc.entity.PostDeleteContext<pkuhit.iih.mr.dao.auto.entity.CaData> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.CaData, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.CaData, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.CaData, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.CaData, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.CaData, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public pkuhit.iih.mr.dao.auto.entity.CaData newEntity() {
        return new pkuhit.iih.mr.dao.auto.entity.CaData();
    }

    @Override
    public pkuhit.iih.mr.dao.auto.entity.CaData newEntity(java.util.Map<String, Object> __args) {
        return new pkuhit.iih.mr.dao.auto.entity.CaData();
    }

    @Override
    public Class<pkuhit.iih.mr.dao.auto.entity.CaData> getEntityClass() {
        return pkuhit.iih.mr.dao.auto.entity.CaData.class;
    }

    @Override
    public pkuhit.iih.mr.dao.auto.entity.CaData getOriginalStates(pkuhit.iih.mr.dao.auto.entity.CaData __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(pkuhit.iih.mr.dao.auto.entity.CaData __entity) {
    }

    /**
     * @return the singleton
     */
    public static _CaData getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _CaData newInstance() {
        return new _CaData();
    }

}
