package pkuhit.iih.mr.dao.auto.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:38.263+0800")
public final class _MdMrTpPara extends org.seasar.doma.jdbc.entity.AbstractEntityType<pkuhit.iih.mr.dao.auto.entity.MdMrTpPara> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _MdMrTpPara __singleton = new _MdMrTpPara();

    /** the mdMrTpParaPk */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MdMrTpPara, java.lang.String, java.lang.Object> $mdMrTpParaPk = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MdMrTpPara, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.MdMrTpPara.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mdMrTpParaPk", "MD_MR_TP_PARA_PK");

    /** the mdMrTpCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MdMrTpPara, java.lang.String, java.lang.Object> $mdMrTpCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MdMrTpPara, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.MdMrTpPara.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mdMrTpCd", "MD_MR_TP_CD", true, true);

    /** the mdMrParaCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MdMrTpPara, java.lang.String, java.lang.Object> $mdMrParaCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MdMrTpPara, java.lang.String, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.MdMrTpPara.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mdMrParaCd", "MD_MR_PARA_CD", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MdMrTpPara, java.lang.Short, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MdMrTpPara, java.lang.Short, java.lang.Object>(pkuhit.iih.mr.dao.auto.entity.MdMrTpPara.class, java.lang.Short.class, org.seasar.doma.wrapper.ShortWrapper.class, null, null, "delF", "DEL_F", true, true);

    private final pkuhit.iih.mr.dao.auto.entity.MdMrTpParaListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.MdMrTpPara, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.MdMrTpPara, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.MdMrTpPara, ?>> __entityPropertyTypeMap;

    private _MdMrTpPara() {
        __listener = new pkuhit.iih.mr.dao.auto.entity.MdMrTpParaListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "MdMrTpPara";
        __catalogName = "";
        __schemaName = "";
        __tableName = "MD_MR_TP_PARA";
        __qualifiedTableName = "MD_MR_TP_PARA";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.MdMrTpPara, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.MdMrTpPara, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.MdMrTpPara, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.MdMrTpPara, ?>>(4);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.MdMrTpPara, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.MdMrTpPara, ?>>(4);
        __idList.add($mdMrTpParaPk);
        __list.add($mdMrTpParaPk);
        __map.put("mdMrTpParaPk", $mdMrTpParaPk);
        __list.add($mdMrTpCd);
        __map.put("mdMrTpCd", $mdMrTpCd);
        __list.add($mdMrParaCd);
        __map.put("mdMrParaCd", $mdMrParaCd);
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
    public void preInsert(pkuhit.iih.mr.dao.auto.entity.MdMrTpPara entity, org.seasar.doma.jdbc.entity.PreInsertContext<pkuhit.iih.mr.dao.auto.entity.MdMrTpPara> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(pkuhit.iih.mr.dao.auto.entity.MdMrTpPara entity, org.seasar.doma.jdbc.entity.PreUpdateContext<pkuhit.iih.mr.dao.auto.entity.MdMrTpPara> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(pkuhit.iih.mr.dao.auto.entity.MdMrTpPara entity, org.seasar.doma.jdbc.entity.PreDeleteContext<pkuhit.iih.mr.dao.auto.entity.MdMrTpPara> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(pkuhit.iih.mr.dao.auto.entity.MdMrTpPara entity, org.seasar.doma.jdbc.entity.PostInsertContext<pkuhit.iih.mr.dao.auto.entity.MdMrTpPara> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(pkuhit.iih.mr.dao.auto.entity.MdMrTpPara entity, org.seasar.doma.jdbc.entity.PostUpdateContext<pkuhit.iih.mr.dao.auto.entity.MdMrTpPara> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(pkuhit.iih.mr.dao.auto.entity.MdMrTpPara entity, org.seasar.doma.jdbc.entity.PostDeleteContext<pkuhit.iih.mr.dao.auto.entity.MdMrTpPara> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.MdMrTpPara, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.MdMrTpPara, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<pkuhit.iih.mr.dao.auto.entity.MdMrTpPara, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MdMrTpPara, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, pkuhit.iih.mr.dao.auto.entity.MdMrTpPara, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public pkuhit.iih.mr.dao.auto.entity.MdMrTpPara newEntity() {
        return new pkuhit.iih.mr.dao.auto.entity.MdMrTpPara();
    }

    @Override
    public pkuhit.iih.mr.dao.auto.entity.MdMrTpPara newEntity(java.util.Map<String, Object> __args) {
        return new pkuhit.iih.mr.dao.auto.entity.MdMrTpPara();
    }

    @Override
    public Class<pkuhit.iih.mr.dao.auto.entity.MdMrTpPara> getEntityClass() {
        return pkuhit.iih.mr.dao.auto.entity.MdMrTpPara.class;
    }

    @Override
    public pkuhit.iih.mr.dao.auto.entity.MdMrTpPara getOriginalStates(pkuhit.iih.mr.dao.auto.entity.MdMrTpPara __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(pkuhit.iih.mr.dao.auto.entity.MdMrTpPara __entity) {
    }

    /**
     * @return the singleton
     */
    public static _MdMrTpPara getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _MdMrTpPara newInstance() {
        return new _MdMrTpPara();
    }

}
