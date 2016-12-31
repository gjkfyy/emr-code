package szlh.iih.lab.po;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:34.642+0800")
public final class _LabReportPo extends org.seasar.doma.jdbc.entity.AbstractEntityType<szlh.iih.lab.po.LabReportPo> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _LabReportPo __singleton = new _LabReportPo();

    /** the labRpPk */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, java.lang.String, java.lang.Object> $labRpPk = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, java.lang.String, java.lang.Object>(szlh.iih.lab.po.LabReportPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "labRpPk", "labRpPk", true, true);

    /** the enPk */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, java.lang.String, java.lang.Object> $enPk = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, java.lang.String, java.lang.Object>(szlh.iih.lab.po.LabReportPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "enPk", "enPk", true, true);

    /** the paId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, java.lang.String, java.lang.Object> $paId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, java.lang.String, java.lang.Object>(szlh.iih.lab.po.LabReportPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "paId", "paId", true, true);

    /** the enCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, java.lang.String, java.lang.Object> $enCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, java.lang.String, java.lang.Object>(szlh.iih.lab.po.LabReportPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "enCnt", "enCnt", true, true);

    /** the paNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, java.lang.String, java.lang.Object> $paNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, java.lang.String, java.lang.Object>(szlh.iih.lab.po.LabReportPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "paNm", "paNm", true, true);

    /** the labRpNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, java.lang.String, java.lang.Object> $labRpNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, java.lang.String, java.lang.Object>(szlh.iih.lab.po.LabReportPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "labRpNo", "labRpNo", true, true);

    /** the labRpNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, java.lang.String, java.lang.Object> $labRpNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, java.lang.String, java.lang.Object>(szlh.iih.lab.po.LabReportPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "labRpNm", "labRpNm", true, true);

    /** the execTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, java.lang.String, java.lang.Object> $execTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, java.lang.String, java.lang.Object>(szlh.iih.lab.po.LabReportPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "execTime", "execTime", true, true);

    /** the execDctId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, java.lang.String, java.lang.Object> $execDctId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, java.lang.String, java.lang.Object>(szlh.iih.lab.po.LabReportPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "execDctId", "execDctId", true, true);

    /** the execDctNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, java.lang.String, java.lang.Object> $execDctNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, java.lang.String, java.lang.Object>(szlh.iih.lab.po.LabReportPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "execDctNm", "execDctNm", true, true);

    /** the execDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, java.lang.String, java.lang.Object> $execDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, java.lang.String, java.lang.Object>(szlh.iih.lab.po.LabReportPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "execDeptCd", "execDeptCd", true, true);

    /** the execDeptNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, java.lang.String, java.lang.Object> $execDeptNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, java.lang.String, java.lang.Object>(szlh.iih.lab.po.LabReportPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "execDeptNm", "execDeptNm", true, true);

    /** the rlsUserId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, java.lang.String, java.lang.Object> $rlsUserId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, java.lang.String, java.lang.Object>(szlh.iih.lab.po.LabReportPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "rlsUserId", "rlsUserId", true, true);

    /** the rlsUserNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, java.lang.String, java.lang.Object> $rlsUserNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, java.lang.String, java.lang.Object>(szlh.iih.lab.po.LabReportPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "rlsUserNm", "rlsUserNm", true, true);

    /** the rlsTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, java.lang.String, java.lang.Object> $rlsTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, java.lang.String, java.lang.Object>(szlh.iih.lab.po.LabReportPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "rlsTime", "rlsTime", true, true);

    /** the rqsTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, java.lang.String, java.lang.Object> $rqsTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, java.lang.String, java.lang.Object>(szlh.iih.lab.po.LabReportPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "rqsTime", "rqsTime", true, true);

    /** the rqsDctId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, java.lang.String, java.lang.Object> $rqsDctId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, java.lang.String, java.lang.Object>(szlh.iih.lab.po.LabReportPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "rqsDctId", "rqsDctId", true, true);

    /** the rqsDctNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, java.lang.String, java.lang.Object> $rqsDctNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, java.lang.String, java.lang.Object>(szlh.iih.lab.po.LabReportPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "rqsDctNm", "rqsDctNm", true, true);

    /** the obDi */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, java.lang.String, java.lang.Object> $obDi = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, java.lang.String, java.lang.Object>(szlh.iih.lab.po.LabReportPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "obDi", "obDi", true, true);

    /** the adv */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, java.lang.String, java.lang.Object> $adv = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, java.lang.String, java.lang.Object>(szlh.iih.lab.po.LabReportPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "adv", "adv", true, true);

    /** the memo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, java.lang.String, java.lang.Object> $memo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, java.lang.String, java.lang.Object>(szlh.iih.lab.po.LabReportPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "memo", "memo", true, true);

    private final org.seasar.doma.jdbc.entity.NullEntityListener<szlh.iih.lab.po.LabReportPo> __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.lab.po.LabReportPo, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.lab.po.LabReportPo, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.lab.po.LabReportPo, ?>> __entityPropertyTypeMap;

    private _LabReportPo() {
        __listener = new org.seasar.doma.jdbc.entity.NullEntityListener<szlh.iih.lab.po.LabReportPo>();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "LabReportPo";
        __catalogName = "";
        __schemaName = "";
        __tableName = "LabReportPo";
        __qualifiedTableName = "LabReportPo";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.lab.po.LabReportPo, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.lab.po.LabReportPo, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.lab.po.LabReportPo, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.lab.po.LabReportPo, ?>>(21);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.lab.po.LabReportPo, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.lab.po.LabReportPo, ?>>(21);
        __list.add($labRpPk);
        __map.put("labRpPk", $labRpPk);
        __list.add($enPk);
        __map.put("enPk", $enPk);
        __list.add($paId);
        __map.put("paId", $paId);
        __list.add($enCnt);
        __map.put("enCnt", $enCnt);
        __list.add($paNm);
        __map.put("paNm", $paNm);
        __list.add($labRpNo);
        __map.put("labRpNo", $labRpNo);
        __list.add($labRpNm);
        __map.put("labRpNm", $labRpNm);
        __list.add($execTime);
        __map.put("execTime", $execTime);
        __list.add($execDctId);
        __map.put("execDctId", $execDctId);
        __list.add($execDctNm);
        __map.put("execDctNm", $execDctNm);
        __list.add($execDeptCd);
        __map.put("execDeptCd", $execDeptCd);
        __list.add($execDeptNm);
        __map.put("execDeptNm", $execDeptNm);
        __list.add($rlsUserId);
        __map.put("rlsUserId", $rlsUserId);
        __list.add($rlsUserNm);
        __map.put("rlsUserNm", $rlsUserNm);
        __list.add($rlsTime);
        __map.put("rlsTime", $rlsTime);
        __list.add($rqsTime);
        __map.put("rqsTime", $rqsTime);
        __list.add($rqsDctId);
        __map.put("rqsDctId", $rqsDctId);
        __list.add($rqsDctNm);
        __map.put("rqsDctNm", $rqsDctNm);
        __list.add($obDi);
        __map.put("obDi", $obDi);
        __list.add($adv);
        __map.put("adv", $adv);
        __list.add($memo);
        __map.put("memo", $memo);
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
    public void preInsert(szlh.iih.lab.po.LabReportPo entity, org.seasar.doma.jdbc.entity.PreInsertContext<szlh.iih.lab.po.LabReportPo> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(szlh.iih.lab.po.LabReportPo entity, org.seasar.doma.jdbc.entity.PreUpdateContext<szlh.iih.lab.po.LabReportPo> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(szlh.iih.lab.po.LabReportPo entity, org.seasar.doma.jdbc.entity.PreDeleteContext<szlh.iih.lab.po.LabReportPo> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(szlh.iih.lab.po.LabReportPo entity, org.seasar.doma.jdbc.entity.PostInsertContext<szlh.iih.lab.po.LabReportPo> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(szlh.iih.lab.po.LabReportPo entity, org.seasar.doma.jdbc.entity.PostUpdateContext<szlh.iih.lab.po.LabReportPo> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(szlh.iih.lab.po.LabReportPo entity, org.seasar.doma.jdbc.entity.PostDeleteContext<szlh.iih.lab.po.LabReportPo> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.lab.po.LabReportPo, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.lab.po.LabReportPo, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.lab.po.LabReportPo, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, szlh.iih.lab.po.LabReportPo, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public szlh.iih.lab.po.LabReportPo newEntity() {
        return new szlh.iih.lab.po.LabReportPo();
    }

    @Override
    public szlh.iih.lab.po.LabReportPo newEntity(java.util.Map<String, Object> __args) {
        return new szlh.iih.lab.po.LabReportPo();
    }

    @Override
    public Class<szlh.iih.lab.po.LabReportPo> getEntityClass() {
        return szlh.iih.lab.po.LabReportPo.class;
    }

    @Override
    public szlh.iih.lab.po.LabReportPo getOriginalStates(szlh.iih.lab.po.LabReportPo __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(szlh.iih.lab.po.LabReportPo __entity) {
    }

    /**
     * @return the singleton
     */
    public static _LabReportPo getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _LabReportPo newInstance() {
        return new _LabReportPo();
    }

}
