package pkuhit.iih.qa.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:24:25.778+0800")
public final class _QaSysAmrRankScr extends org.seasar.doma.jdbc.entity.AbstractEntityType<pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _QaSysAmrRankScr __singleton = new _QaSysAmrRankScr();

    /** the qaSysAmrRankScrCd */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr, java.lang.String, java.lang.Object> $qaSysAmrRankScrCd = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "qaSysAmrRankScrCd", "QA_SYS_AMR_RANK_SCR_CD");

    /** the qaSysAmrCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr, java.lang.String, java.lang.Object> $qaSysAmrCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "qaSysAmrCd", "QA_SYS_AMR_CD", true, true);

    /** the amrRankCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr, java.lang.String, java.lang.Object> $amrRankCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr, java.lang.String, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "amrRankCd", "AMR_RANK_CD", true, true);

    /** the maxScr */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr, java.math.BigInteger, java.lang.Object> $maxScr = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr, java.math.BigInteger, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "maxScr", "MAX_SCR", true, true);

    /** the minScr */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr, java.math.BigInteger, java.lang.Object> $minScr = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr, java.math.BigInteger, java.lang.Object>(pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr.class, java.math.BigInteger.class, org.seasar.doma.wrapper.BigIntegerWrapper.class, null, null, "minScr", "MIN_SCR", true, true);

    private final pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScrListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr, ?>> __entityPropertyTypeMap;

    private _QaSysAmrRankScr() {
        __listener = new pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScrListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "QaSysAmrRankScr";
        __catalogName = "";
        __schemaName = "";
        __tableName = "QA_SYS_AMR_RANK_SCR";
        __qualifiedTableName = "QA_SYS_AMR_RANK_SCR";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr, ?>>(5);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr, ?>>(5);
        __idList.add($qaSysAmrRankScrCd);
        __list.add($qaSysAmrRankScrCd);
        __map.put("qaSysAmrRankScrCd", $qaSysAmrRankScrCd);
        __list.add($qaSysAmrCd);
        __map.put("qaSysAmrCd", $qaSysAmrCd);
        __list.add($amrRankCd);
        __map.put("amrRankCd", $amrRankCd);
        __list.add($maxScr);
        __map.put("maxScr", $maxScr);
        __list.add($minScr);
        __map.put("minScr", $minScr);
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
    public void preInsert(pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr entity, org.seasar.doma.jdbc.entity.PreInsertContext<pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr entity, org.seasar.doma.jdbc.entity.PreUpdateContext<pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr entity, org.seasar.doma.jdbc.entity.PreDeleteContext<pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr entity, org.seasar.doma.jdbc.entity.PostInsertContext<pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr entity, org.seasar.doma.jdbc.entity.PostUpdateContext<pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr entity, org.seasar.doma.jdbc.entity.PostDeleteContext<pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr newEntity() {
        return new pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr();
    }

    @Override
    public pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr newEntity(java.util.Map<String, Object> __args) {
        return new pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr();
    }

    @Override
    public Class<pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr> getEntityClass() {
        return pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr.class;
    }

    @Override
    public pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr getOriginalStates(pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr __entity) {
    }

    /**
     * @return the singleton
     */
    public static _QaSysAmrRankScr getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _QaSysAmrRankScr newInstance() {
        return new _QaSysAmrRankScr();
    }

}
