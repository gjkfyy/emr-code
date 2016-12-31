package ei.ass.nu.auto.po;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:35.658+0800")
public final class _VitalsignPo extends org.seasar.doma.jdbc.entity.AbstractEntityType<ei.ass.nu.auto.po.VitalsignPo> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _VitalsignPo __singleton = new _VitalsignPo();

    /** the vitalSignPk */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object> $vitalSignPk = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object>(ei.ass.nu.auto.po.VitalsignPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "vitalSignPk", "vitalSignPk", true, true);

    /** the enPk */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object> $enPk = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object>(ei.ass.nu.auto.po.VitalsignPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "enPk", "enPk", true, true);

    /** the paId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object> $paId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object>(ei.ass.nu.auto.po.VitalsignPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "paId", "paId", true, true);

    /** the enCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object> $enCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object>(ei.ass.nu.auto.po.VitalsignPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "enCnt", "enCnt", true, true);

    /** the paNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object> $paNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object>(ei.ass.nu.auto.po.VitalsignPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "paNm", "paNm", true, true);

    /** the temper */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object> $temper = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object>(ei.ass.nu.auto.po.VitalsignPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "temper", "temper", true, true);

    /** the weight */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object> $weight = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object>(ei.ass.nu.auto.po.VitalsignPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "weight", "weight", true, true);

    /** the heartRate */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object> $heartRate = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object>(ei.ass.nu.auto.po.VitalsignPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "heartRate", "heartRate", true, true);

    /** the pulse */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object> $pulse = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object>(ei.ass.nu.auto.po.VitalsignPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "pulse", "pulse", true, true);

    /** the breathe */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object> $breathe = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object>(ei.ass.nu.auto.po.VitalsignPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "breathe", "breathe", true, true);

    /** the bldOxygen */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object> $bldOxygen = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object>(ei.ass.nu.auto.po.VitalsignPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "bldOxygen", "bldOxygen", true, true);

    /** the systolicPress */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object> $systolicPress = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object>(ei.ass.nu.auto.po.VitalsignPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "systolicPress", "systolicPress", true, true);

    /** the diastolicPress */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object> $diastolicPress = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object>(ei.ass.nu.auto.po.VitalsignPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "diastolicPress", "diastolicPress", true, true);

    /** the acquisitionDate */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object> $acquisitionDate = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object>(ei.ass.nu.auto.po.VitalsignPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "acquisitionDate", "acquisitionDate", true, true);

    /** the circumference */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object> $circumference = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object>(ei.ass.nu.auto.po.VitalsignPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "circumference", "circumference", true, true);

    /** the bldSugar */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object> $bldSugar = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object>(ei.ass.nu.auto.po.VitalsignPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "bldSugar", "bldSugar", true, true);

    /** the normalStool */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object> $normalStool = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object>(ei.ass.nu.auto.po.VitalsignPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "normalStool", "normalStool", true, true);

    /** the normalPiss */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object> $normalPiss = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object>(ei.ass.nu.auto.po.VitalsignPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "normalPiss", "normalPiss", true, true);

    /** the intakeSum */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object> $intakeSum = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object>(ei.ass.nu.auto.po.VitalsignPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "intakeSum", "intakeSum", true, true);

    /** the outtakeSum */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object> $outtakeSum = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object>(ei.ass.nu.auto.po.VitalsignPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "outtakeSum", "outtakeSum", true, true);

    /** the height */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object> $height = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object>(ei.ass.nu.auto.po.VitalsignPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "height", "height", true, true);

    /** the drugAllergic */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object> $drugAllergic = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, java.lang.String, java.lang.Object>(ei.ass.nu.auto.po.VitalsignPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "drugAllergic", "drugAllergic", true, true);

    private final org.seasar.doma.jdbc.entity.NullEntityListener<ei.ass.nu.auto.po.VitalsignPo> __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.ass.nu.auto.po.VitalsignPo, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.ass.nu.auto.po.VitalsignPo, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<ei.ass.nu.auto.po.VitalsignPo, ?>> __entityPropertyTypeMap;

    private _VitalsignPo() {
        __listener = new org.seasar.doma.jdbc.entity.NullEntityListener<ei.ass.nu.auto.po.VitalsignPo>();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "VitalsignPo";
        __catalogName = "";
        __schemaName = "";
        __tableName = "VitalsignPo";
        __qualifiedTableName = "VitalsignPo";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.ass.nu.auto.po.VitalsignPo, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.ass.nu.auto.po.VitalsignPo, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.ass.nu.auto.po.VitalsignPo, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.ass.nu.auto.po.VitalsignPo, ?>>(22);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<ei.ass.nu.auto.po.VitalsignPo, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<ei.ass.nu.auto.po.VitalsignPo, ?>>(22);
        __list.add($vitalSignPk);
        __map.put("vitalSignPk", $vitalSignPk);
        __list.add($enPk);
        __map.put("enPk", $enPk);
        __list.add($paId);
        __map.put("paId", $paId);
        __list.add($enCnt);
        __map.put("enCnt", $enCnt);
        __list.add($paNm);
        __map.put("paNm", $paNm);
        __list.add($temper);
        __map.put("temper", $temper);
        __list.add($weight);
        __map.put("weight", $weight);
        __list.add($heartRate);
        __map.put("heartRate", $heartRate);
        __list.add($pulse);
        __map.put("pulse", $pulse);
        __list.add($breathe);
        __map.put("breathe", $breathe);
        __list.add($bldOxygen);
        __map.put("bldOxygen", $bldOxygen);
        __list.add($systolicPress);
        __map.put("systolicPress", $systolicPress);
        __list.add($diastolicPress);
        __map.put("diastolicPress", $diastolicPress);
        __list.add($acquisitionDate);
        __map.put("acquisitionDate", $acquisitionDate);
        __list.add($circumference);
        __map.put("circumference", $circumference);
        __list.add($bldSugar);
        __map.put("bldSugar", $bldSugar);
        __list.add($normalStool);
        __map.put("normalStool", $normalStool);
        __list.add($normalPiss);
        __map.put("normalPiss", $normalPiss);
        __list.add($intakeSum);
        __map.put("intakeSum", $intakeSum);
        __list.add($outtakeSum);
        __map.put("outtakeSum", $outtakeSum);
        __list.add($height);
        __map.put("height", $height);
        __list.add($drugAllergic);
        __map.put("drugAllergic", $drugAllergic);
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
    public void preInsert(ei.ass.nu.auto.po.VitalsignPo entity, org.seasar.doma.jdbc.entity.PreInsertContext<ei.ass.nu.auto.po.VitalsignPo> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(ei.ass.nu.auto.po.VitalsignPo entity, org.seasar.doma.jdbc.entity.PreUpdateContext<ei.ass.nu.auto.po.VitalsignPo> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(ei.ass.nu.auto.po.VitalsignPo entity, org.seasar.doma.jdbc.entity.PreDeleteContext<ei.ass.nu.auto.po.VitalsignPo> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(ei.ass.nu.auto.po.VitalsignPo entity, org.seasar.doma.jdbc.entity.PostInsertContext<ei.ass.nu.auto.po.VitalsignPo> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(ei.ass.nu.auto.po.VitalsignPo entity, org.seasar.doma.jdbc.entity.PostUpdateContext<ei.ass.nu.auto.po.VitalsignPo> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(ei.ass.nu.auto.po.VitalsignPo entity, org.seasar.doma.jdbc.entity.PostDeleteContext<ei.ass.nu.auto.po.VitalsignPo> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.ass.nu.auto.po.VitalsignPo, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<ei.ass.nu.auto.po.VitalsignPo, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<ei.ass.nu.auto.po.VitalsignPo, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, ei.ass.nu.auto.po.VitalsignPo, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public ei.ass.nu.auto.po.VitalsignPo newEntity() {
        return new ei.ass.nu.auto.po.VitalsignPo();
    }

    @Override
    public ei.ass.nu.auto.po.VitalsignPo newEntity(java.util.Map<String, Object> __args) {
        return new ei.ass.nu.auto.po.VitalsignPo();
    }

    @Override
    public Class<ei.ass.nu.auto.po.VitalsignPo> getEntityClass() {
        return ei.ass.nu.auto.po.VitalsignPo.class;
    }

    @Override
    public ei.ass.nu.auto.po.VitalsignPo getOriginalStates(ei.ass.nu.auto.po.VitalsignPo __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(ei.ass.nu.auto.po.VitalsignPo __entity) {
    }

    /**
     * @return the singleton
     */
    public static _VitalsignPo getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _VitalsignPo newInstance() {
        return new _VitalsignPo();
    }

}
