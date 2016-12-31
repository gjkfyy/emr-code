package ei.cis.db.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:23:15.781+0800")
public final class _IemrEnAdtEntity extends org.seasar.doma.jdbc.entity.AbstractEntityType<ei.cis.db.dao.auto.entity.IemrEnAdtEntity> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _IemrEnAdtEntity __singleton = new _IemrEnAdtEntity();

    /** the enAdtCd */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.lang.String, java.lang.Object> $enAdtCd = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.lang.String, java.lang.Object>(ei.cis.db.dao.auto.entity.IemrEnAdtEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "enAdtCd", "en_adt_cd");

    /** the enPk */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.lang.String, java.lang.Object> $enPk = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.lang.String, java.lang.Object>(ei.cis.db.dao.auto.entity.IemrEnAdtEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "enPk", "en_pk", true, true);

    /** the patientId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.lang.String, java.lang.Object> $patientId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.lang.String, java.lang.Object>(ei.cis.db.dao.auto.entity.IemrEnAdtEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "patientId", "patient_id", true, true);

    /** the enCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.lang.String, java.lang.Object> $enCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.lang.String, java.lang.Object>(ei.cis.db.dao.auto.entity.IemrEnAdtEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "enCnt", "en_cnt", true, true);

    /** the ledgerSn */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.lang.Integer, java.lang.Object> $ledgerSn = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.lang.Integer, java.lang.Object>(ei.cis.db.dao.auto.entity.IemrEnAdtEntity.class, java.lang.Integer.class, org.seasar.doma.wrapper.IntegerWrapper.class, null, null, "ledgerSn", "ledger_sn", true, true);

    /** the transTimes */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.lang.Integer, java.lang.Object> $transTimes = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.lang.Integer, java.lang.Object>(ei.cis.db.dao.auto.entity.IemrEnAdtEntity.class, java.lang.Integer.class, org.seasar.doma.wrapper.IntegerWrapper.class, null, null, "transTimes", "trans_times", true, true);

    /** the admissDate */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.util.Date, java.lang.Object> $admissDate = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.util.Date, java.lang.Object>(ei.cis.db.dao.auto.entity.IemrEnAdtEntity.class, java.util.Date.class, org.seasar.doma.wrapper.UtilDateWrapper.class, null, null, "admissDate", "admiss_date", true, true);

    /** the disDate */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.util.Date, java.lang.Object> $disDate = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.util.Date, java.lang.Object>(ei.cis.db.dao.auto.entity.IemrEnAdtEntity.class, java.util.Date.class, org.seasar.doma.wrapper.UtilDateWrapper.class, null, null, "disDate", "dis_date", true, true);

    /** the transRegDate */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.util.Date, java.lang.Object> $transRegDate = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.util.Date, java.lang.Object>(ei.cis.db.dao.auto.entity.IemrEnAdtEntity.class, java.util.Date.class, org.seasar.doma.wrapper.UtilDateWrapper.class, null, null, "transRegDate", "trans_reg_date", true, true);

    /** the transDate */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.util.Date, java.lang.Object> $transDate = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.util.Date, java.lang.Object>(ei.cis.db.dao.auto.entity.IemrEnAdtEntity.class, java.util.Date.class, org.seasar.doma.wrapper.UtilDateWrapper.class, null, null, "transDate", "trans_date", true, true);

    /** the transType */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.lang.String, java.lang.Object> $transType = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.lang.String, java.lang.Object>(ei.cis.db.dao.auto.entity.IemrEnAdtEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "transType", "trans_type", true, true);

    /** the origDept */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.lang.String, java.lang.Object> $origDept = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.lang.String, java.lang.Object>(ei.cis.db.dao.auto.entity.IemrEnAdtEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "origDept", "orig_dept", true, true);

    /** the origWard */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.lang.String, java.lang.Object> $origWard = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.lang.String, java.lang.Object>(ei.cis.db.dao.auto.entity.IemrEnAdtEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "origWard", "orig_ward", true, true);

    /** the origRoom */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.lang.String, java.lang.Object> $origRoom = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.lang.String, java.lang.Object>(ei.cis.db.dao.auto.entity.IemrEnAdtEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "origRoom", "orig_room", true, true);

    /** the origBed */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.lang.String, java.lang.Object> $origBed = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.lang.String, java.lang.Object>(ei.cis.db.dao.auto.entity.IemrEnAdtEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "origBed", "orig_bed", true, true);

    /** the origOpera */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.lang.String, java.lang.Object> $origOpera = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.lang.String, java.lang.Object>(ei.cis.db.dao.auto.entity.IemrEnAdtEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "origOpera", "orig_opera", true, true);

    /** the currDept */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.lang.String, java.lang.Object> $currDept = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.lang.String, java.lang.Object>(ei.cis.db.dao.auto.entity.IemrEnAdtEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "currDept", "curr_dept", true, true);

    /** the currWard */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.lang.String, java.lang.Object> $currWard = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.lang.String, java.lang.Object>(ei.cis.db.dao.auto.entity.IemrEnAdtEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "currWard", "curr_ward", true, true);

    /** the currRoom */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.lang.String, java.lang.Object> $currRoom = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.lang.String, java.lang.Object>(ei.cis.db.dao.auto.entity.IemrEnAdtEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "currRoom", "curr_room", true, true);

    /** the currBed */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.lang.String, java.lang.Object> $currBed = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.lang.String, java.lang.Object>(ei.cis.db.dao.auto.entity.IemrEnAdtEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "currBed", "curr_bed", true, true);

    /** the currOpera */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.lang.String, java.lang.Object> $currOpera = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.lang.String, java.lang.Object>(ei.cis.db.dao.auto.entity.IemrEnAdtEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "currOpera", "curr_opera", true, true);

    /** the mark */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.lang.String, java.lang.Object> $mark = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.lang.String, java.lang.Object>(ei.cis.db.dao.auto.entity.IemrEnAdtEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mark", "mark", true, true);

    /** the flag */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.lang.String, java.lang.Object> $flag = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, java.lang.String, java.lang.Object>(ei.cis.db.dao.auto.entity.IemrEnAdtEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "flag", "flag", true, true);

    private final ei.cis.db.dao.auto.entity.IemrEnAdtEntityListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.cis.db.dao.auto.entity.IemrEnAdtEntity, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.cis.db.dao.auto.entity.IemrEnAdtEntity, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<ei.cis.db.dao.auto.entity.IemrEnAdtEntity, ?>> __entityPropertyTypeMap;

    private _IemrEnAdtEntity() {
        __listener = new ei.cis.db.dao.auto.entity.IemrEnAdtEntityListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "IemrEnAdtEntity";
        __catalogName = "";
        __schemaName = "";
        __tableName = "IEMR_EN_ADT";
        __qualifiedTableName = "IEMR_EN_ADT";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.cis.db.dao.auto.entity.IemrEnAdtEntity, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.cis.db.dao.auto.entity.IemrEnAdtEntity, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.cis.db.dao.auto.entity.IemrEnAdtEntity, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.cis.db.dao.auto.entity.IemrEnAdtEntity, ?>>(23);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<ei.cis.db.dao.auto.entity.IemrEnAdtEntity, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<ei.cis.db.dao.auto.entity.IemrEnAdtEntity, ?>>(23);
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
        __list.add($flag);
        __map.put("flag", $flag);
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
    public void preInsert(ei.cis.db.dao.auto.entity.IemrEnAdtEntity entity, org.seasar.doma.jdbc.entity.PreInsertContext<ei.cis.db.dao.auto.entity.IemrEnAdtEntity> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(ei.cis.db.dao.auto.entity.IemrEnAdtEntity entity, org.seasar.doma.jdbc.entity.PreUpdateContext<ei.cis.db.dao.auto.entity.IemrEnAdtEntity> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(ei.cis.db.dao.auto.entity.IemrEnAdtEntity entity, org.seasar.doma.jdbc.entity.PreDeleteContext<ei.cis.db.dao.auto.entity.IemrEnAdtEntity> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(ei.cis.db.dao.auto.entity.IemrEnAdtEntity entity, org.seasar.doma.jdbc.entity.PostInsertContext<ei.cis.db.dao.auto.entity.IemrEnAdtEntity> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(ei.cis.db.dao.auto.entity.IemrEnAdtEntity entity, org.seasar.doma.jdbc.entity.PostUpdateContext<ei.cis.db.dao.auto.entity.IemrEnAdtEntity> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(ei.cis.db.dao.auto.entity.IemrEnAdtEntity entity, org.seasar.doma.jdbc.entity.PostDeleteContext<ei.cis.db.dao.auto.entity.IemrEnAdtEntity> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.cis.db.dao.auto.entity.IemrEnAdtEntity, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<ei.cis.db.dao.auto.entity.IemrEnAdtEntity, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.cis.db.dao.auto.entity.IemrEnAdtEntity, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, ei.cis.db.dao.auto.entity.IemrEnAdtEntity, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public ei.cis.db.dao.auto.entity.IemrEnAdtEntity newEntity() {
        return new ei.cis.db.dao.auto.entity.IemrEnAdtEntity();
    }

    @Override
    public ei.cis.db.dao.auto.entity.IemrEnAdtEntity newEntity(java.util.Map<String, Object> __args) {
        return new ei.cis.db.dao.auto.entity.IemrEnAdtEntity();
    }

    @Override
    public Class<ei.cis.db.dao.auto.entity.IemrEnAdtEntity> getEntityClass() {
        return ei.cis.db.dao.auto.entity.IemrEnAdtEntity.class;
    }

    @Override
    public ei.cis.db.dao.auto.entity.IemrEnAdtEntity getOriginalStates(ei.cis.db.dao.auto.entity.IemrEnAdtEntity __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(ei.cis.db.dao.auto.entity.IemrEnAdtEntity __entity) {
    }

    /**
     * @return the singleton
     */
    public static _IemrEnAdtEntity getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _IemrEnAdtEntity newInstance() {
        return new _IemrEnAdtEntity();
    }

}
