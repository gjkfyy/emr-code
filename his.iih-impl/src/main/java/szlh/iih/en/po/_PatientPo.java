package szlh.iih.en.po;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:23:26.302+0800")
public final class _PatientPo extends org.seasar.doma.jdbc.entity.AbstractEntityType<szlh.iih.en.po.PatientPo> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _PatientPo __singleton = new _PatientPo();

    /** the paId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object> $paId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object>(szlh.iih.en.po.PatientPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "paId", "paId", true, true);

    /** the nm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object> $nm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object>(szlh.iih.en.po.PatientPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "nm", "nm", true, true);

    /** the birthday */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object> $birthday = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object>(szlh.iih.en.po.PatientPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "birthday", "birthday", true, true);

    /** the idCardNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object> $idCardNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object>(szlh.iih.en.po.PatientPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "idCardNo", "idCardNo", true, true);

    /** the sexCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object> $sexCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object>(szlh.iih.en.po.PatientPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sexCd", "sexCd", true, true);

    /** the sexNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object> $sexNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object>(szlh.iih.en.po.PatientPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sexNm", "sexNm", true, true);

    /** the mariCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object> $mariCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object>(szlh.iih.en.po.PatientPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mariCd", "mariCd", true, true);

    /** the mariNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object> $mariNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object>(szlh.iih.en.po.PatientPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mariNm", "mariNm", true, true);

    /** the deathF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.Integer, java.lang.Object> $deathF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.Integer, java.lang.Object>(szlh.iih.en.po.PatientPo.class, java.lang.Integer.class, org.seasar.doma.wrapper.IntegerWrapper.class, null, null, "deathF", "deathF", true, true);

    /** the deathDate */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object> $deathDate = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object>(szlh.iih.en.po.PatientPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "deathDate", "deathDate", true, true);

    /** the autopsyF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.Integer, java.lang.Object> $autopsyF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.Integer, java.lang.Object>(szlh.iih.en.po.PatientPo.class, java.lang.Integer.class, org.seasar.doma.wrapper.IntegerWrapper.class, null, null, "autopsyF", "autopsyF", true, true);

    /** the telNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object> $telNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object>(szlh.iih.en.po.PatientPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "telNo", "telNo", true, true);

    /** the mobileNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object> $mobileNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object>(szlh.iih.en.po.PatientPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "mobileNo", "mobileNo", true, true);

    /** the email */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object> $email = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object>(szlh.iih.en.po.PatientPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "email", "email", true, true);

    /** the workOrgCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object> $workOrgCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object>(szlh.iih.en.po.PatientPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "workOrgCd", "workOrgCd", true, true);

    /** the workOrgNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object> $workOrgNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object>(szlh.iih.en.po.PatientPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "workOrgNm", "workOrgNm", true, true);

    /** the nationCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object> $nationCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object>(szlh.iih.en.po.PatientPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "nationCd", "nationCd", true, true);

    /** the nationNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object> $nationNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object>(szlh.iih.en.po.PatientPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "nationNm", "nationNm", true, true);

    /** the occuCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object> $occuCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object>(szlh.iih.en.po.PatientPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "occuCd", "occuCd", true, true);

    /** the occuNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object> $occuNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object>(szlh.iih.en.po.PatientPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "occuNm", "occuNm", true, true);

    /** the distCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object> $distCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object>(szlh.iih.en.po.PatientPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "distCd", "distCd", true, true);

    /** the distNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object> $distNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object>(szlh.iih.en.po.PatientPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "distNm", "distNm", true, true);

    /** the encounterCardNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object> $encounterCardNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object>(szlh.iih.en.po.PatientPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "encounterCardNo", "encounterCardNo", true, true);

    /** the homeAddress */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object> $homeAddress = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object>(szlh.iih.en.po.PatientPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "homeAddress", "homeAddress", true, true);

    /** the idCardAdress */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object> $idCardAdress = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object>(szlh.iih.en.po.PatientPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "idCardAdress", "idCardAdress", true, true);

    /** the reservedColumn1 */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object> $reservedColumn1 = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object>(szlh.iih.en.po.PatientPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "reservedColumn1", "reservedColumn1", true, true);

    /** the reservedColumn2 */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object> $reservedColumn2 = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object>(szlh.iih.en.po.PatientPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "reservedColumn2", "reservedColumn2", true, true);

    /** the reservedColumn3 */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object> $reservedColumn3 = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object>(szlh.iih.en.po.PatientPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "reservedColumn3", "reservedColumn3", true, true);

    /** the reservedColumn4 */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object> $reservedColumn4 = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object>(szlh.iih.en.po.PatientPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "reservedColumn4", "reservedColumn4", true, true);

    /** the reservedColumn5 */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object> $reservedColumn5 = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object>(szlh.iih.en.po.PatientPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "reservedColumn5", "reservedColumn5", true, true);

    /** the reservedColumn6 */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object> $reservedColumn6 = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object>(szlh.iih.en.po.PatientPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "reservedColumn6", "reservedColumn6", true, true);

    /** the reservedColumn7 */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object> $reservedColumn7 = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object>(szlh.iih.en.po.PatientPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "reservedColumn7", "reservedColumn7", true, true);

    /** the reservedColumn8 */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object> $reservedColumn8 = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, java.lang.String, java.lang.Object>(szlh.iih.en.po.PatientPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "reservedColumn8", "reservedColumn8", true, true);

    private final org.seasar.doma.jdbc.entity.NullEntityListener<szlh.iih.en.po.PatientPo> __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.en.po.PatientPo, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.en.po.PatientPo, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.en.po.PatientPo, ?>> __entityPropertyTypeMap;

    private _PatientPo() {
        __listener = new org.seasar.doma.jdbc.entity.NullEntityListener<szlh.iih.en.po.PatientPo>();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "PatientPo";
        __catalogName = "";
        __schemaName = "";
        __tableName = "PatientPo";
        __qualifiedTableName = "PatientPo";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.en.po.PatientPo, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.en.po.PatientPo, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.en.po.PatientPo, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.en.po.PatientPo, ?>>(33);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.en.po.PatientPo, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.en.po.PatientPo, ?>>(33);
        __list.add($paId);
        __map.put("paId", $paId);
        __list.add($nm);
        __map.put("nm", $nm);
        __list.add($birthday);
        __map.put("birthday", $birthday);
        __list.add($idCardNo);
        __map.put("idCardNo", $idCardNo);
        __list.add($sexCd);
        __map.put("sexCd", $sexCd);
        __list.add($sexNm);
        __map.put("sexNm", $sexNm);
        __list.add($mariCd);
        __map.put("mariCd", $mariCd);
        __list.add($mariNm);
        __map.put("mariNm", $mariNm);
        __list.add($deathF);
        __map.put("deathF", $deathF);
        __list.add($deathDate);
        __map.put("deathDate", $deathDate);
        __list.add($autopsyF);
        __map.put("autopsyF", $autopsyF);
        __list.add($telNo);
        __map.put("telNo", $telNo);
        __list.add($mobileNo);
        __map.put("mobileNo", $mobileNo);
        __list.add($email);
        __map.put("email", $email);
        __list.add($workOrgCd);
        __map.put("workOrgCd", $workOrgCd);
        __list.add($workOrgNm);
        __map.put("workOrgNm", $workOrgNm);
        __list.add($nationCd);
        __map.put("nationCd", $nationCd);
        __list.add($nationNm);
        __map.put("nationNm", $nationNm);
        __list.add($occuCd);
        __map.put("occuCd", $occuCd);
        __list.add($occuNm);
        __map.put("occuNm", $occuNm);
        __list.add($distCd);
        __map.put("distCd", $distCd);
        __list.add($distNm);
        __map.put("distNm", $distNm);
        __list.add($encounterCardNo);
        __map.put("encounterCardNo", $encounterCardNo);
        __list.add($homeAddress);
        __map.put("homeAddress", $homeAddress);
        __list.add($idCardAdress);
        __map.put("idCardAdress", $idCardAdress);
        __list.add($reservedColumn1);
        __map.put("reservedColumn1", $reservedColumn1);
        __list.add($reservedColumn2);
        __map.put("reservedColumn2", $reservedColumn2);
        __list.add($reservedColumn3);
        __map.put("reservedColumn3", $reservedColumn3);
        __list.add($reservedColumn4);
        __map.put("reservedColumn4", $reservedColumn4);
        __list.add($reservedColumn5);
        __map.put("reservedColumn5", $reservedColumn5);
        __list.add($reservedColumn6);
        __map.put("reservedColumn6", $reservedColumn6);
        __list.add($reservedColumn7);
        __map.put("reservedColumn7", $reservedColumn7);
        __list.add($reservedColumn8);
        __map.put("reservedColumn8", $reservedColumn8);
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
    public void preInsert(szlh.iih.en.po.PatientPo entity, org.seasar.doma.jdbc.entity.PreInsertContext<szlh.iih.en.po.PatientPo> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(szlh.iih.en.po.PatientPo entity, org.seasar.doma.jdbc.entity.PreUpdateContext<szlh.iih.en.po.PatientPo> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(szlh.iih.en.po.PatientPo entity, org.seasar.doma.jdbc.entity.PreDeleteContext<szlh.iih.en.po.PatientPo> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(szlh.iih.en.po.PatientPo entity, org.seasar.doma.jdbc.entity.PostInsertContext<szlh.iih.en.po.PatientPo> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(szlh.iih.en.po.PatientPo entity, org.seasar.doma.jdbc.entity.PostUpdateContext<szlh.iih.en.po.PatientPo> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(szlh.iih.en.po.PatientPo entity, org.seasar.doma.jdbc.entity.PostDeleteContext<szlh.iih.en.po.PatientPo> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.en.po.PatientPo, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.en.po.PatientPo, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.en.po.PatientPo, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, szlh.iih.en.po.PatientPo, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public szlh.iih.en.po.PatientPo newEntity() {
        return new szlh.iih.en.po.PatientPo();
    }

    @Override
    public szlh.iih.en.po.PatientPo newEntity(java.util.Map<String, Object> __args) {
        return new szlh.iih.en.po.PatientPo();
    }

    @Override
    public Class<szlh.iih.en.po.PatientPo> getEntityClass() {
        return szlh.iih.en.po.PatientPo.class;
    }

    @Override
    public szlh.iih.en.po.PatientPo getOriginalStates(szlh.iih.en.po.PatientPo __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(szlh.iih.en.po.PatientPo __entity) {
    }

    /**
     * @return the singleton
     */
    public static _PatientPo getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _PatientPo newInstance() {
        return new _PatientPo();
    }

}
