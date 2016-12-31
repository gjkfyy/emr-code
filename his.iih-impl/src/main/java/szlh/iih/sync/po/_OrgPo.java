package szlh.iih.sync.po;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:34.640+0800")
public final class _OrgPo extends org.seasar.doma.jdbc.entity.AbstractEntityType<szlh.iih.sync.po.OrgPo> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _OrgPo __singleton = new _OrgPo();

    /** the orgId */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, szlh.iih.sync.po.OrgPo, java.lang.Integer, java.lang.Object> $orgId = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, szlh.iih.sync.po.OrgPo, java.lang.Integer, java.lang.Object>(szlh.iih.sync.po.OrgPo.class, java.lang.Integer.class, org.seasar.doma.wrapper.IntegerWrapper.class, null, null, "orgId", "ORG_ID");

    /** the orgCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.OrgPo, java.lang.String, java.lang.Object> $orgCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.OrgPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.OrgPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "orgCd", "orgCd", true, true);

    /** the orgTpCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.OrgPo, java.lang.String, java.lang.Object> $orgTpCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.OrgPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.OrgPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "orgTpCd", "orgTpCd", true, true);

    /** the nm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.OrgPo, java.lang.String, java.lang.Object> $nm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.OrgPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.OrgPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "nm", "nm", true, true);

    /** the des */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.OrgPo, java.lang.String, java.lang.Object> $des = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.OrgPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.OrgPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "des", "des", true, true);

    /** the shtNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.OrgPo, java.lang.String, java.lang.Object> $shtNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.OrgPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.OrgPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "shtNm", "shtNm", true, true);

    /** the aliasNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.OrgPo, java.lang.String, java.lang.Object> $aliasNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.OrgPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.OrgPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "aliasNm", "aliasNm", true, true);

    /** the distCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.OrgPo, java.lang.String, java.lang.Object> $distCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.OrgPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.OrgPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "distCd", "distCd", true, true);

    /** the subdistNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.OrgPo, java.lang.String, java.lang.Object> $subdistNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.OrgPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.OrgPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "subdistNm", "subdistNm", true, true);

    /** the zipNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.OrgPo, java.lang.String, java.lang.Object> $zipNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.OrgPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.OrgPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "zipNo", "zipNo", true, true);

    /** the telNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.OrgPo, java.lang.String, java.lang.Object> $telNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.OrgPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.OrgPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "telNo", "telNo", true, true);

    /** the delF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.OrgPo, java.lang.String, java.lang.Object> $delF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.OrgPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.OrgPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "delF", "delF", true, true);

    /** the spellNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.OrgPo, java.lang.String, java.lang.Object> $spellNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.OrgPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.OrgPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spellNo", "spellNo", true, true);

    /** the flag */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.OrgPo, java.lang.String, java.lang.Object> $flag = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.sync.po.OrgPo, java.lang.String, java.lang.Object>(szlh.iih.sync.po.OrgPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "flag", "flag", true, true);

    private final szlh.iih.sync.po.OrgPoListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.OrgPo, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.OrgPo, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.OrgPo, ?>> __entityPropertyTypeMap;

    private _OrgPo() {
        __listener = new szlh.iih.sync.po.OrgPoListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "OrgPo";
        __catalogName = "";
        __schemaName = "";
        __tableName = "iemr_org";
        __qualifiedTableName = "iemr_org";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.OrgPo, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.OrgPo, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.OrgPo, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.OrgPo, ?>>(14);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.OrgPo, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.OrgPo, ?>>(14);
        __idList.add($orgId);
        __list.add($orgId);
        __map.put("orgId", $orgId);
        __list.add($orgCd);
        __map.put("orgCd", $orgCd);
        __list.add($orgTpCd);
        __map.put("orgTpCd", $orgTpCd);
        __list.add($nm);
        __map.put("nm", $nm);
        __list.add($des);
        __map.put("des", $des);
        __list.add($shtNm);
        __map.put("shtNm", $shtNm);
        __list.add($aliasNm);
        __map.put("aliasNm", $aliasNm);
        __list.add($distCd);
        __map.put("distCd", $distCd);
        __list.add($subdistNm);
        __map.put("subdistNm", $subdistNm);
        __list.add($zipNo);
        __map.put("zipNo", $zipNo);
        __list.add($telNo);
        __map.put("telNo", $telNo);
        __list.add($delF);
        __map.put("delF", $delF);
        __list.add($spellNo);
        __map.put("spellNo", $spellNo);
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
    public void preInsert(szlh.iih.sync.po.OrgPo entity, org.seasar.doma.jdbc.entity.PreInsertContext<szlh.iih.sync.po.OrgPo> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(szlh.iih.sync.po.OrgPo entity, org.seasar.doma.jdbc.entity.PreUpdateContext<szlh.iih.sync.po.OrgPo> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(szlh.iih.sync.po.OrgPo entity, org.seasar.doma.jdbc.entity.PreDeleteContext<szlh.iih.sync.po.OrgPo> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(szlh.iih.sync.po.OrgPo entity, org.seasar.doma.jdbc.entity.PostInsertContext<szlh.iih.sync.po.OrgPo> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(szlh.iih.sync.po.OrgPo entity, org.seasar.doma.jdbc.entity.PostUpdateContext<szlh.iih.sync.po.OrgPo> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(szlh.iih.sync.po.OrgPo entity, org.seasar.doma.jdbc.entity.PostDeleteContext<szlh.iih.sync.po.OrgPo> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.OrgPo, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.OrgPo, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.sync.po.OrgPo, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, szlh.iih.sync.po.OrgPo, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, szlh.iih.sync.po.OrgPo, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public szlh.iih.sync.po.OrgPo newEntity() {
        return new szlh.iih.sync.po.OrgPo();
    }

    @Override
    public szlh.iih.sync.po.OrgPo newEntity(java.util.Map<String, Object> __args) {
        return new szlh.iih.sync.po.OrgPo();
    }

    @Override
    public Class<szlh.iih.sync.po.OrgPo> getEntityClass() {
        return szlh.iih.sync.po.OrgPo.class;
    }

    @Override
    public szlh.iih.sync.po.OrgPo getOriginalStates(szlh.iih.sync.po.OrgPo __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(szlh.iih.sync.po.OrgPo __entity) {
    }

    /**
     * @return the singleton
     */
    public static _OrgPo getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _OrgPo newInstance() {
        return new _OrgPo();
    }

}
