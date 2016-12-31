package szlh.iih.or.po;

/** */
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:34.592+0800")
public final class _OrderPo extends org.seasar.doma.jdbc.entity.AbstractEntityType<szlh.iih.or.po.OrderPo> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final _OrderPo __singleton = new _OrderPo();

    /** the orPk */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $orPk = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "orPk", "orPk", true, true);

    /** the paId */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $paId = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "paId", "paId", true, true);

    /** the enCnt */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $enCnt = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "enCnt", "enCnt", true, true);

    /** the paNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $paNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "paNm", "paNm", true, true);

    /** the enPk */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $enPk = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "enPk", "enPk", true, true);

    /** the orPresPk */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $orPresPk = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "orPresPk", "orPresPk", true, true);

    /** the svCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $svCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "svCd", "svCd", true, true);

    /** the svNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $svNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "svNm", "svNm", true, true);

    /** the orStaCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $orStaCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "orStaCd", "orStaCd", true, true);

    /** the orStaNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $orStaNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "orStaNm", "orStaNm", true, true);

    /** the longOrF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $longOrF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "longOrF", "longOrF", true, true);

    /** the longOrNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $longOrNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "longOrNm", "longOrNm", true, true);

    /** the orTpCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $orTpCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "orTpCd", "orTpCd", true, true);

    /** the orTpNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $orTpNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "orTpNm", "orTpNm", true, true);

    /** the freqCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $freqCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "freqCd", "freqCd", true, true);

    /** the freqNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $freqNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "freqNm", "freqNm", true, true);

    /** the routeCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $routeCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "routeCd", "routeCd", true, true);

    /** the routeNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $routeNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "routeNm", "routeNm", true, true);

    /** the spec */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $spec = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "spec", "spec", true, true);

    /** the dosage */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $dosage = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "dosage", "dosage", true, true);

    /** the dosageUnitNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $dosageUnitNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "dosageUnitNm", "dosageUnitNm", true, true);

    /** the amount */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $amount = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "amount", "amount", true, true);

    /** the takeAmount */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $takeAmount = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "takeAmount", "takeAmount", true, true);

    /** the takeAmountUnitNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $takeAmountUnitNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "takeAmountUnitNm", "takeAmountUnitNm", true, true);

    /** the crtDosage */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $crtDosage = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "crtDosage", "crtDosage", true, true);

    /** the boilDosage */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $boilDosage = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "boilDosage", "boilDosage", true, true);

    /** the boilTpNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $boilTpNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "boilTpNm", "boilTpNm", true, true);

    /** the insruGrdCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $insruGrdCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "insruGrdCd", "insruGrdCd", true, true);

    /** the insruGrdNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $insruGrdNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "insruGrdNm", "insruGrdNm", true, true);

    /** the selfF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $selfF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "selfF", "selfF", true, true);

    /** the selfNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $selfNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "selfNm", "selfNm", true, true);

    /** the indicationF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $indicationF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "indicationF", "indicationF", true, true);

    /** the indicationNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $indicationNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "indicationNm", "indicationNm", true, true);

    /** the preventF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $preventF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "preventF", "preventF", true, true);

    /** the preventNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $preventNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "preventNm", "preventNm", true, true);

    /** the skinTestF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $skinTestF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "skinTestF", "skinTestF", true, true);

    /** the skinTestNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $skinTestNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "skinTestNm", "skinTestNm", true, true);

    /** the inHospF */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $inHospF = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "inHospF", "inHospF", true, true);

    /** the inHospNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $inHospNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "inHospNm", "inHospNm", true, true);

    /** the orNoteNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $orNoteNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "orNoteNm", "orNoteNm", true, true);

    /** the parOrPk */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $parOrPk = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "parOrPk", "parOrPk", true, true);

    /** the sortNo */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $sortNo = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "sortNo", "sortNo", true, true);

    /** the orStdTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.sql.Timestamp, java.lang.Object> $orStdTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.sql.Timestamp, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "orStdTime", "orStdTime", true, true);

    /** the orStpTime */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.sql.Timestamp, java.lang.Object> $orStpTime = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.sql.Timestamp, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.sql.Timestamp.class, org.seasar.doma.wrapper.TimestampWrapper.class, null, null, "orStpTime", "orStpTime", true, true);

    /** the orCrtDctCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $orCrtDctCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "orCrtDctCd", "orCrtDctCd", true, true);

    /** the orCrtDctNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $orCrtDctNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "orCrtDctNm", "orCrtDctNm", true, true);

    /** the orCrtDeptCd */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $orCrtDeptCd = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "orCrtDeptCd", "orCrtDeptCd", true, true);

    /** the orCrtDeptNm */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $orCrtDeptNm = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "orCrtDeptNm", "orCrtDeptNm", true, true);

    /** the groupFlag */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object> $groupFlag = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, java.lang.String, java.lang.Object>(szlh.iih.or.po.OrderPo.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "groupFlag", "groupFlag", true, true);

    private final org.seasar.doma.jdbc.entity.NullEntityListener<szlh.iih.or.po.OrderPo> __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.or.po.OrderPo, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.or.po.OrderPo, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.or.po.OrderPo, ?>> __entityPropertyTypeMap;

    private _OrderPo() {
        __listener = new org.seasar.doma.jdbc.entity.NullEntityListener<szlh.iih.or.po.OrderPo>();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __immutable = false;
        __name = "OrderPo";
        __catalogName = "";
        __schemaName = "";
        __tableName = "OrderPo";
        __qualifiedTableName = "OrderPo";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.or.po.OrderPo, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.or.po.OrderPo, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.or.po.OrderPo, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.or.po.OrderPo, ?>>(49);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.or.po.OrderPo, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.or.po.OrderPo, ?>>(49);
        __list.add($orPk);
        __map.put("orPk", $orPk);
        __list.add($paId);
        __map.put("paId", $paId);
        __list.add($enCnt);
        __map.put("enCnt", $enCnt);
        __list.add($paNm);
        __map.put("paNm", $paNm);
        __list.add($enPk);
        __map.put("enPk", $enPk);
        __list.add($orPresPk);
        __map.put("orPresPk", $orPresPk);
        __list.add($svCd);
        __map.put("svCd", $svCd);
        __list.add($svNm);
        __map.put("svNm", $svNm);
        __list.add($orStaCd);
        __map.put("orStaCd", $orStaCd);
        __list.add($orStaNm);
        __map.put("orStaNm", $orStaNm);
        __list.add($longOrF);
        __map.put("longOrF", $longOrF);
        __list.add($longOrNm);
        __map.put("longOrNm", $longOrNm);
        __list.add($orTpCd);
        __map.put("orTpCd", $orTpCd);
        __list.add($orTpNm);
        __map.put("orTpNm", $orTpNm);
        __list.add($freqCd);
        __map.put("freqCd", $freqCd);
        __list.add($freqNm);
        __map.put("freqNm", $freqNm);
        __list.add($routeCd);
        __map.put("routeCd", $routeCd);
        __list.add($routeNm);
        __map.put("routeNm", $routeNm);
        __list.add($spec);
        __map.put("spec", $spec);
        __list.add($dosage);
        __map.put("dosage", $dosage);
        __list.add($dosageUnitNm);
        __map.put("dosageUnitNm", $dosageUnitNm);
        __list.add($amount);
        __map.put("amount", $amount);
        __list.add($takeAmount);
        __map.put("takeAmount", $takeAmount);
        __list.add($takeAmountUnitNm);
        __map.put("takeAmountUnitNm", $takeAmountUnitNm);
        __list.add($crtDosage);
        __map.put("crtDosage", $crtDosage);
        __list.add($boilDosage);
        __map.put("boilDosage", $boilDosage);
        __list.add($boilTpNm);
        __map.put("boilTpNm", $boilTpNm);
        __list.add($insruGrdCd);
        __map.put("insruGrdCd", $insruGrdCd);
        __list.add($insruGrdNm);
        __map.put("insruGrdNm", $insruGrdNm);
        __list.add($selfF);
        __map.put("selfF", $selfF);
        __list.add($selfNm);
        __map.put("selfNm", $selfNm);
        __list.add($indicationF);
        __map.put("indicationF", $indicationF);
        __list.add($indicationNm);
        __map.put("indicationNm", $indicationNm);
        __list.add($preventF);
        __map.put("preventF", $preventF);
        __list.add($preventNm);
        __map.put("preventNm", $preventNm);
        __list.add($skinTestF);
        __map.put("skinTestF", $skinTestF);
        __list.add($skinTestNm);
        __map.put("skinTestNm", $skinTestNm);
        __list.add($inHospF);
        __map.put("inHospF", $inHospF);
        __list.add($inHospNm);
        __map.put("inHospNm", $inHospNm);
        __list.add($orNoteNm);
        __map.put("orNoteNm", $orNoteNm);
        __list.add($parOrPk);
        __map.put("parOrPk", $parOrPk);
        __list.add($sortNo);
        __map.put("sortNo", $sortNo);
        __list.add($orStdTime);
        __map.put("orStdTime", $orStdTime);
        __list.add($orStpTime);
        __map.put("orStpTime", $orStpTime);
        __list.add($orCrtDctCd);
        __map.put("orCrtDctCd", $orCrtDctCd);
        __list.add($orCrtDctNm);
        __map.put("orCrtDctNm", $orCrtDctNm);
        __list.add($orCrtDeptCd);
        __map.put("orCrtDeptCd", $orCrtDeptCd);
        __list.add($orCrtDeptNm);
        __map.put("orCrtDeptNm", $orCrtDeptNm);
        __list.add($groupFlag);
        __map.put("groupFlag", $groupFlag);
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
    public void preInsert(szlh.iih.or.po.OrderPo entity, org.seasar.doma.jdbc.entity.PreInsertContext<szlh.iih.or.po.OrderPo> context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(szlh.iih.or.po.OrderPo entity, org.seasar.doma.jdbc.entity.PreUpdateContext<szlh.iih.or.po.OrderPo> context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(szlh.iih.or.po.OrderPo entity, org.seasar.doma.jdbc.entity.PreDeleteContext<szlh.iih.or.po.OrderPo> context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(szlh.iih.or.po.OrderPo entity, org.seasar.doma.jdbc.entity.PostInsertContext<szlh.iih.or.po.OrderPo> context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(szlh.iih.or.po.OrderPo entity, org.seasar.doma.jdbc.entity.PostUpdateContext<szlh.iih.or.po.OrderPo> context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(szlh.iih.or.po.OrderPo entity, org.seasar.doma.jdbc.entity.PostDeleteContext<szlh.iih.or.po.OrderPo> context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.or.po.OrderPo, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.or.po.OrderPo, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<szlh.iih.or.po.OrderPo, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, szlh.iih.or.po.OrderPo, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public szlh.iih.or.po.OrderPo newEntity() {
        return new szlh.iih.or.po.OrderPo();
    }

    @Override
    public szlh.iih.or.po.OrderPo newEntity(java.util.Map<String, Object> __args) {
        return new szlh.iih.or.po.OrderPo();
    }

    @Override
    public Class<szlh.iih.or.po.OrderPo> getEntityClass() {
        return szlh.iih.or.po.OrderPo.class;
    }

    @Override
    public szlh.iih.or.po.OrderPo getOriginalStates(szlh.iih.or.po.OrderPo __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(szlh.iih.or.po.OrderPo __entity) {
    }

    /**
     * @return the singleton
     */
    public static _OrderPo getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _OrderPo newInstance() {
        return new _OrderPo();
    }

}
