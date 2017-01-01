package pkuhit.iih.mr.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:38.219+0800")
public final class _EnAdtEntity extends org.seasar.doma.jdbc.entity.AbstractEntityType<pkuhit.iih.mr.dao.auto.entity.EnAdtEntity> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _EnAdtEntity __singleton = new _EnAdtEntity();

    /** the enAdtCd */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.lang.String, java.lang.Object> $enAdtCd = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.EnAdtEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "enAdtCd", "EN_ADT_CD");

    /** the enPk */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.lang.String, java.lang.Object> $enPk = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.EnAdtEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "enPk", "EN_PK", true, true);

    /** the patientId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.lang.String, java.lang.Object> $patientId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.EnAdtEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "patientId", "PATIENT_ID", true, true);

    /** the enCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.lang.String, java.lang.Object> $enCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.EnAdtEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "enCnt", "EN_CNT", true, true);

    /** the ledgerSn */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.math.BigInteger, java.lang.Object> $ledgerSn = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.math.BigInteger, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.EnAdtEntity.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "ledgerSn", "LEDGER_SN", true, true);

    /** the transTimes */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.math.BigInteger, java.lang.Object> $transTimes = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.math.BigInteger, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.EnAdtEntity.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "transTimes", "TRANS_TIMES", true, true);

    /** the admissDate */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.sql.Timestamp, java.lang.Object> $admissDate = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.EnAdtEntity.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "admissDate", "ADMISS_DATE", true, true);

    /** the disDate */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.sql.Timestamp, java.lang.Object> $disDate = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.EnAdtEntity.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "disDate", "DIS_DATE", true, true);

    /** the transRegDate */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.sql.Timestamp, java.lang.Object> $transRegDate = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.EnAdtEntity.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "transRegDate", "TRANS_REG_DATE", true, true);

    /** the transDate */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.sql.Timestamp, java.lang.Object> $transDate = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.sql.Timestamp, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.EnAdtEntity.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "transDate", "TRANS_DATE", true, true);

    /** the transType */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.lang.String, java.lang.Object> $transType = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.EnAdtEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "transType", "TRANS_TYPE", true, true);

    /** the origDept */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.lang.String, java.lang.Object> $origDept = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.EnAdtEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "origDept", "ORIG_DEPT", true, true);

    /** the origWard */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.lang.String, java.lang.Object> $origWard = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.EnAdtEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "origWard", "ORIG_WARD", true, true);

    /** the origRoom */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.lang.String, java.lang.Object> $origRoom = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.EnAdtEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "origRoom", "ORIG_ROOM", true, true);

    /** the origBed */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.lang.String, java.lang.Object> $origBed = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.EnAdtEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "origBed", "ORIG_BED", true, true);

    /** the origOpera */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.lang.String, java.lang.Object> $origOpera = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.EnAdtEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "origOpera", "ORIG_OPERA", true, true);

    /** the currDept */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.lang.String, java.lang.Object> $currDept = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.EnAdtEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "currDept", "CURR_DEPT", true, true);

    /** the currWard */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.lang.String, java.lang.Object> $currWard = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.EnAdtEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "currWard", "CURR_WARD", true, true);

    /** the currRoom */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.lang.String, java.lang.Object> $currRoom = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.EnAdtEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "currRoom", "CURR_ROOM", true, true);

    /** the currBed */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.lang.String, java.lang.Object> $currBed = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.EnAdtEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "currBed", "CURR_BED", true, true);

    /** the currOpera */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.lang.String, java.lang.Object> $currOpera = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.EnAdtEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "currOpera", "CURR_OPERA", true, true);

    /** the mark */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.lang.String, java.lang.Object> $mark = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.EnAdtEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mark", "MARK", true, true);

    private final pkuhit.iih.mr.dao.auto.entity.EnAdtEntityListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, ?>> __entityPropertyTypeMap;

    private _EnAdtEntity() {
        __listener = new pkuhit.iih.mr.dao.auto.entity.EnAdtEntityListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "EnAdtEntity";
        __catalogName = "";
        __schemaName = "";
        __tableName = "EN_ADT";
        __qualifiedTableName = "EN_ADT";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, ?>>(22);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, ?>>(22);
        __idList.add($enAdtCd);
        __list.add($enAdtCd);
        __map.put("enAdtCd", $enAdtCd);
        __list.add($enPk);
        __map.put("enPk", $enPk);
        __list.add($patientId);
        __map.put("patientId", $patientId);
        __list.add($enCnt);
        __map.put("enCnt", $enCnt);
        __list.add($ledgerSn);
        __map.put("ledgerSn", $ledgerSn);
        __list.add($transTimes);
        __map.put("transTimes", $transTimes);
        __list.add($admissDate);
        __map.put("admissDate", $admissDate);
        __list.add($disDate);
        __map.put("disDate", $disDate);
        __list.add($transRegDate);
        __map.put("transRegDate", $transRegDate);
        __list.add($transDate);
        __map.put("transDate", $transDate);
        __list.add($transType);
        __map.put("transType", $transType);
        __list.add($origDept);
        __map.put("origDept", $origDept);
        __list.add($origWard);
        __map.put("origWard", $origWard);
        __list.add($origRoom);
        __map.put("origRoom", $origRoom);
        __list.add($origBed);
        __map.put("origBed", $origBed);
        __list.add($origOpera);
        __map.put("origOpera", $origOpera);
        __list.add($currDept);
        __map.put("currDept", $currDept);
        __list.add($currWard);
        __map.put("currWard", $currWard);
        __list.add($currRoom);
        __map.put("currRoom", $currRoom);
        __list.add($currBed);
        __map.put("currBed", $currBed);
        __list.add($currOpera);
        __map.put("currOpera", $currOpera);
        __list.add($mark);
        __map.put("mark", $mark);
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
    public void preInsert(pkuhit.iih.mr.dao.auto.entity.EnAdtEntity entity, org.seasar.doma.jdbc.entity.PreInsertContext<pkuhit.iih.mr.dao.auto.entity.EnAdtEntity> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(pkuhit.iih.mr.dao.auto.entity.EnAdtEntity entity, org.seasar.doma.jdbc.entity.PreUpdateContext<pkuhit.iih.mr.dao.auto.entity.EnAdtEntity> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(pkuhit.iih.mr.dao.auto.entity.EnAdtEntity entity, org.seasar.doma.jdbc.entity.PreDeleteContext<pkuhit.iih.mr.dao.auto.entity.EnAdtEntity> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(pkuhit.iih.mr.dao.auto.entity.EnAdtEntity entity, org.seasar.doma.jdbc.entity.PostInsertContext<pkuhit.iih.mr.dao.auto.entity.EnAdtEntity> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(pkuhit.iih.mr.dao.auto.entity.EnAdtEntity entity, org.seasar.doma.jdbc.entity.PostUpdateContext<pkuhit.iih.mr.dao.auto.entity.EnAdtEntity> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(pkuhit.iih.mr.dao.auto.entity.EnAdtEntity entity, org.seasar.doma.jdbc.entity.PostDeleteContext<pkuhit.iih.mr.dao.auto.entity.EnAdtEntity> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.EnAdtEntity, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public pkuhit.iih.mr.dao.auto.entity.EnAdtEntity newEntity() {
        return new pkuhit.iih.mr.dao.auto.entity.EnAdtEntity();
    }

    @Override
    public pkuhit.iih.mr.dao.auto.entity.EnAdtEntity newEntity(java.util.Map<String, Object> __args) {
        return new pkuhit.iih.mr.dao.auto.entity.EnAdtEntity();
    }

    @Override
    public Class<pkuhit.iih.mr.dao.auto.entity.EnAdtEntity> getEntityClass() {
        return pkuhit.iih.mr.dao.auto.entity.EnAdtEntity.class;
    }

    @Override
    public pkuhit.iih.mr.dao.auto.entity.EnAdtEntity getOriginalStates(pkuhit.iih.mr.dao.auto.entity.EnAdtEntity __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(pkuhit.iih.mr.dao.auto.entity.EnAdtEntity __entity) {
    }

    /**
     * @return the singleton
     */
    public static _EnAdtEntity getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _EnAdtEntity newInstance() {
        return new _EnAdtEntity();
    }

}
