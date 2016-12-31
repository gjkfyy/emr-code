package iih.mr.db.gen.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-01-01T01:49:36.860+0800")
public class MrEntityDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements iih.mr.db.gen.dao.MrEntityDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public MrEntityDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

}
