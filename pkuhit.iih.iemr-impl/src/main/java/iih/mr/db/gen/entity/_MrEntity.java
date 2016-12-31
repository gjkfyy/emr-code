package iih.mr.db.gen.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:11.453+0800")
public final class _MrEntity extends org.seasar.doma.jdbc.entity.AbstractEntityType<iih.mr.db.gen.entity.MrEntity> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _MrEntity __singleton = new _MrEntity();

    /** the mrPk */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.lang.String, java.lang.Object> $mrPk = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.lang.String, java.lang.Object>(iih.mr.db.gen.entity.MrEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mrPk", "MR_PK");

    /** the enPk */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.lang.String, java.lang.Object> $enPk = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.lang.String, java.lang.Object>(iih.mr.db.gen.entity.MrEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "enPk", "EN_PK", true, true);

    /** the mrTplCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.lang.String, java.lang.Object> $mrTplCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.lang.String, java.lang.Object>(iih.mr.db.gen.entity.MrEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mrTplCd", "MR_TPL_CD", true, true);

    /** the filePk */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.lang.String, java.lang.Object> $filePk = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.lang.String, java.lang.Object>(iih.mr.db.gen.entity.MrEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "filePk", "FILE_PK", true, true);

    /** the nm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.lang.String, java.lang.Object> $nm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.lang.String, java.lang.Object>(iih.mr.db.gen.entity.MrEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "nm", "NM", true, true);

    /** the mrTpCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.lang.String, java.lang.Object> $mrTpCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.lang.String, java.lang.Object>(iih.mr.db.gen.entity.MrEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mrTpCd", "MR_TP_CD", true, true);

    /** the mrStaCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.lang.String, java.lang.Object> $mrStaCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.lang.String, java.lang.Object>(iih.mr.db.gen.entity.MrEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mrStaCd", "MR_STA_CD", true, true);

    /** the mrQaStaCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.lang.String, java.lang.Object> $mrQaStaCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.lang.String, java.lang.Object>(iih.mr.db.gen.entity.MrEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mrQaStaCd", "MR_QA_STA_CD", true, true);

    /** the edigLockF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.lang.Short, java.lang.Object> $edigLockF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.lang.Short, java.lang.Object>(iih.mr.db.gen.entity.MrEntity.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "edigLockF", "EDIG_LOCK_F", true, true);

    /** the rejectF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.lang.Short, java.lang.Object> $rejectF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.lang.Short, java.lang.Object>(iih.mr.db.gen.entity.MrEntity.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "rejectF", "REJECT_F", true, true);

    /** the completeF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.lang.Short, java.lang.Object> $completeF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.lang.Short, java.lang.Object>(iih.mr.db.gen.entity.MrEntity.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "completeF", "COMPLETE_F", true, true);

    /** the signLvlCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.lang.String, java.lang.Object> $signLvlCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.lang.String, java.lang.Object>(iih.mr.db.gen.entity.MrEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "signLvlCd", "SIGN_LVL_CD", true, true);

    /** the bizTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.sql.Timestamp, java.lang.Object> $bizTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.sql.Timestamp, java.lang.Object>(iih.mr.db.gen.entity.MrEntity.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "bizTime", "BIZ_TIME", true, true);

    /** the supDctId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.lang.String, java.lang.Object> $supDctId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.lang.String, java.lang.Object>(iih.mr.db.gen.entity.MrEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "supDctId", "SUP_DCT_ID", true, true);

    /** the lgcSmtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.sql.Timestamp, java.lang.Object> $lgcSmtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.sql.Timestamp, java.lang.Object>(iih.mr.db.gen.entity.MrEntity.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lgcSmtTime", "LGC_SMT_TIME", true, true);

    /** the lgcSmtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.lang.String, java.lang.Object> $lgcSmtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.lang.String, java.lang.Object>(iih.mr.db.gen.entity.MrEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lgcSmtUserId", "LGC_SMT_USER_ID", true, true);

    /** the lgcSmtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.lang.String, java.lang.Object> $lgcSmtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.lang.String, java.lang.Object>(iih.mr.db.gen.entity.MrEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lgcSmtDeptCd", "LGC_SMT_DEPT_CD", true, true);

    /** the updCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.math.BigInteger, java.lang.Object> $updCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.math.BigInteger, java.lang.Object>(iih.mr.db.gen.entity.MrEntity.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "updCnt", "UPD_CNT", true, true);

    /** the crtTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.sql.Timestamp, java.lang.Object> $crtTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.sql.Timestamp, java.lang.Object>(iih.mr.db.gen.entity.MrEntity.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "crtTime", "CRT_TIME", true, true);

    /** the crtUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.lang.String, java.lang.Object> $crtUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.lang.String, java.lang.Object>(iih.mr.db.gen.entity.MrEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtUserId", "CRT_USER_ID", true, true);

    /** the crtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.lang.String, java.lang.Object> $crtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.lang.String, java.lang.Object>(iih.mr.db.gen.entity.MrEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDeptCd", "CRT_DEPT_CD", true, true);

    /** the lastUpdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.sql.Timestamp, java.lang.Object> $lastUpdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.sql.Timestamp, java.lang.Object>(iih.mr.db.gen.entity.MrEntity.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "lastUpdTime", "LAST_UPD_TIME", true, true);

    /** the lastUpdDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.lang.String, java.lang.Object> $lastUpdDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.lang.String, java.lang.Object>(iih.mr.db.gen.entity.MrEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdDeptCd", "LAST_UPD_DEPT_CD", true, true);

    /** the lastUpdUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.lang.String, java.lang.Object> $lastUpdUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.lang.String, java.lang.Object>(iih.mr.db.gen.entity.MrEntity.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "lastUpdUserId", "LAST_UPD_USER_ID", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, java.lang.Short, java.lang.Object>(iih.mr.db.gen.entity.MrEntity.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    private final iih.mr.db.gen.entity.MrEntityListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.mr.db.gen.entity.MrEntity, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.mr.db.gen.entity.MrEntity, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.mr.db.gen.entity.MrEntity, ?>> __entityPropertyTypeMap;

    private _MrEntity() {
        __listener = new iih.mr.db.gen.entity.MrEntityListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "MrEntity";
        __catalogName = "";
        __schemaName = "";
        __tableName = "MR";
        __qualifiedTableName = "MR";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.mr.db.gen.entity.MrEntity, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.mr.db.gen.entity.MrEntity, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.mr.db.gen.entity.MrEntity, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.mr.db.gen.entity.MrEntity, ?>>(25);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.mr.db.gen.entity.MrEntity, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<iih.mr.db.gen.entity.MrEntity, ?>>(25);
        __idList.add($mrPk);
        __list.add($mrPk);
        __map.put("mrPk", $mrPk);
        __list.add($enPk);
        __map.put("enPk", $enPk);
        __list.add($mrTplCd);
        __map.put("mrTplCd", $mrTplCd);
        __list.add($filePk);
        __map.put("filePk", $filePk);
        __list.add($nm);
        __map.put("nm", $nm);
        __list.add($mrTpCd);
        __map.put("mrTpCd", $mrTpCd);
        __list.add($mrStaCd);
        __map.put("mrStaCd", $mrStaCd);
        __list.add($mrQaStaCd);
        __map.put("mrQaStaCd", $mrQaStaCd);
        __list.add($edigLockF);
        __map.put("edigLockF", $edigLockF);
        __list.add($rejectF);
        __map.put("rejectF", $rejectF);
        __list.add($completeF);
        __map.put("completeF", $completeF);
        __list.add($signLvlCd);
        __map.put("signLvlCd", $signLvlCd);
        __list.add($bizTime);
        __map.put("bizTime", $bizTime);
        __list.add($supDctId);
        __map.put("supDctId", $supDctId);
        __list.add($lgcSmtTime);
        __map.put("lgcSmtTime", $lgcSmtTime);
        __list.add($lgcSmtUserId);
        __map.put("lgcSmtUserId", $lgcSmtUserId);
        __list.add($lgcSmtDeptCd);
        __map.put("lgcSmtDeptCd", $lgcSmtDeptCd);
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
    public void preInsert(iih.mr.db.gen.entity.MrEntity entity, org.seasar.doma.jdbc.entity.PreInsertContext<iih.mr.db.gen.entity.MrEntity> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(iih.mr.db.gen.entity.MrEntity entity, org.seasar.doma.jdbc.entity.PreUpdateContext<iih.mr.db.gen.entity.MrEntity> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(iih.mr.db.gen.entity.MrEntity entity, org.seasar.doma.jdbc.entity.PreDeleteContext<iih.mr.db.gen.entity.MrEntity> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(iih.mr.db.gen.entity.MrEntity entity, org.seasar.doma.jdbc.entity.PostInsertContext<iih.mr.db.gen.entity.MrEntity> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(iih.mr.db.gen.entity.MrEntity entity, org.seasar.doma.jdbc.entity.PostUpdateContext<iih.mr.db.gen.entity.MrEntity> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(iih.mr.db.gen.entity.MrEntity entity, org.seasar.doma.jdbc.entity.PostDeleteContext<iih.mr.db.gen.entity.MrEntity> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.mr.db.gen.entity.MrEntity, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<iih.mr.db.gen.entity.MrEntity, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<iih.mr.db.gen.entity.MrEntity, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, iih.mr.db.gen.entity.MrEntity, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public iih.mr.db.gen.entity.MrEntity newEntity() {
        return new iih.mr.db.gen.entity.MrEntity();
    }

    @Override
    public iih.mr.db.gen.entity.MrEntity newEntity(java.util.Map<String, Object> __args) {
        return new iih.mr.db.gen.entity.MrEntity();
    }

    @Override
    public Class<iih.mr.db.gen.entity.MrEntity> getEntityClass() {
        return iih.mr.db.gen.entity.MrEntity.class;
    }

    @Override
    public iih.mr.db.gen.entity.MrEntity getOriginalStates(iih.mr.db.gen.entity.MrEntity __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(iih.mr.db.gen.entity.MrEntity __entity) {
    }

    /**
     * @return the singleton
     */
    public static _MrEntity getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _MrEntity newInstance() {
        return new _MrEntity();
    }

}
