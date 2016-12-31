package pkuhit.me;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.util.Assert;

import pkuhit.me.dao.custom.entity.ObjectAttributeMetadata;
import pkuhit.me.query.Query;
import pkuhit.me.query.QueryBuilder;
import pkuhit.me.query.Query.Filter;
import pkuhit.me.table.PrimaryKeyObjectMetadata;
import xap.sv.bundle.XapBundleContext;
import xap.sv.bundle.XapBundleContextAware;
import xap.sv.log.DebugLogger;

import com.rollen.sqlbuilder.SelectCreator;

public class DataObjectServiceImpl implements DataObjectService,
        XapBundleContextAware
{
    static Logger logger = LoggerFactory.getLogger(DataObjectServiceImpl.class);

    XapBundleContext xbc;

    DataObjectMetadataRepository dataObjectMetadataRepository;

    JdbcTemplate jdbcTemplate;

    public void setDataObjectMetadataRepository(
            DataObjectMetadataRepository dataObjectMetadataRepository)
    {
        this.dataObjectMetadataRepository = dataObjectMetadataRepository;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public DataObject getObjectById(DataObjectId id)
    {
        DataObjectMetadata metadata = dataObjectMetadataRepository.getDataObjectMetadata(id.getObjectCode());
        Query query = QueryBuilder.newQuery(id.getObjectCode()).and(
                metadata.getKey().getAttributeName(), id.getValue()).build();
        DataObject[] objects = this.executeQuery(query);
        Assert.isTrue(objects.length <= 1, "found more than one result using ["
            + id.getObjectCode() + "].[" + id.getValue() + "]");
        if (objects.length > 0)
        {
            return objects[0];
        }
        return null;
    }

    @Override
    public DataObject[] executeQuery(Query query)
    {
        String objectCd = query.getObjectCd();
//        logger.debug("query object from table :"+objectCd);
        DataObjectMetadata dom = dataObjectMetadataRepository.getDataObjectMetadata(objectCd);
        PrimaryKeyObjectMetadata pkom = (PrimaryKeyObjectMetadata) dom;

        SelectCreator sc = new SelectCreator();
        for (ObjectAttributeMetadata oam : pkom.getAttributes().values())
        {
            String columnName = oam.getColumnName();
            if (!StringUtils.hasText(columnName))
            {
//                logger.debug("columnName of object [" + objectCd + "]."
//                    + oam.getAttributeName() + " is empty");
                continue;
            }
            sc.column(columnName);
        }
        sc.from(pkom.getTableName());

        for (Filter filter : query.getFilters())
        {
            ObjectAttributeMetadata oam = dom.getAttributeByName(filter.getProperty());
            String columnName = oam.getColumnName();
            Assert.hasText(columnName,
                    "columnName of " + objectCd + "." + oam.getAttributeName()
                        + " must not be empty");
            sc.whereEquals(oam.getColumnName(), filter.getValue());
        }
        // TODO 常量
        sc.whereEquals("DEL_F", 0);

        RowMapperResultSetExtractor<Map<String, Object>> rse = new RowMapperResultSetExtractor<Map<String, Object>>(
                new ColumnMapRowMapper());
        List<Map<String, Object>> ret = jdbcTemplate.query(sc, rse);
        DataObject[] objects = new DataObject[ret.size()];
        for (int i = 0; i < ret.size(); i++)
        {
            Map<String, Object> origin = ret.get(i);
            Map<String, Object> target = new HashMap<String, Object>();
            for (String column : origin.keySet())
            {
                ObjectAttributeMetadata oam = dom.getAttributeByColumn(column);
                target.put(oam.getAttributeName(), origin.get(column));
            }
            DataObject o = new DataObject();
            o.setObjectData(target);
            objects[i] = o;
        }
        return objects;
    }

    @Override
    public void setBundleContext(XapBundleContext context)
    {
        this.xbc = context;
    }

    @Override
    public DataObject getObject(String objectCd, String id)
    {
        DataObjectId doi = new DataObjectId();
        doi.setObjectCode(objectCd);
        doi.setValue(id);
        return this.getObjectById(doi);
    }

    @Override
    public DataObject[] getObjects(String objectCd, String... idList)
    {
        List<DataObject> objectList = new ArrayList<DataObject>();
        if (idList != null) {
        	
        	for (String id : idList)
        	{
        		DataObject o = this.getObject(objectCd, id);
        		if (o != null)
        			objectList.add(o);
        	}
		}
        return objectList.toArray(new DataObject[objectList.size()]);
    }
}
