package szlh.iih.en.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2016-12-28T22:23:26.326+0800")
public class EncounterDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements szlh.iih.en.dao.EncounterDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public EncounterDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

}
