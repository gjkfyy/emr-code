package pkuhit.xap.dao.auto;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "1.35.0" }, date = "2017-10-03T11:11:31.834+0800")
public class IemrPatientDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements pkuhit.xap.dao.auto.IemrPatientDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.35.0");
    }

    private static final java.lang.reflect.Method __method1 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.xap.dao.auto.IemrPatientDao.class, "insert", pkuhit.xap.dao.auto.entity.IemrPatient.class);

    private static final java.lang.reflect.Method __method2 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.xap.dao.auto.IemrPatientDao.class, "insertExludeNull", pkuhit.xap.dao.auto.entity.IemrPatient.class);

    private static final java.lang.reflect.Method __method3 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.xap.dao.auto.IemrPatientDao.class, "update", pkuhit.xap.dao.auto.entity.IemrPatient.class);

    private static final java.lang.reflect.Method __method4 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.xap.dao.auto.IemrPatientDao.class, "updateExcludeNull", pkuhit.xap.dao.auto.entity.IemrPatient.class);

    private static final java.lang.reflect.Method __method5 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.xap.dao.auto.IemrPatientDao.class, "markDelete", pkuhit.xap.dao.auto.entity.IemrPatient.class);

    private static final java.lang.reflect.Method __method6 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.xap.dao.auto.IemrPatientDao.class, "delete", pkuhit.xap.dao.auto.entity.IemrPatient.class);

    private static final java.lang.reflect.Method __method7 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.xap.dao.auto.IemrPatientDao.class, "batchInsert", java.util.List.class);

    private static final java.lang.reflect.Method __method8 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.xap.dao.auto.IemrPatientDao.class, "batchUpdate", java.util.List.class);

    private static final java.lang.reflect.Method __method9 = org.seasar.doma.internal.jdbc.dao.AbstractDao.__getDeclaredMethod(pkuhit.xap.dao.auto.IemrPatientDao.class, "batchDelete", java.util.List.class);

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public IemrPatientDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public pkuhit.xap.dao.auto.entity.IemrPatient selectIemrPatientById(java.lang.String patientId) {
        entering("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "selectIemrPatientById", patientId);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/auto/IemrPatientDao/selectIemrPatientById.sql");
            __query.addParameter("patientId", java.lang.String.class, patientId);
            __query.setCallerClassName("pkuhit.xap.dao.auto.IemrPatientDaoImpl");
            __query.setCallerMethodName("selectIemrPatientById");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.xap.dao.auto.entity.IemrPatient> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<pkuhit.xap.dao.auto.entity.IemrPatient>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<pkuhit.xap.dao.auto.entity.IemrPatient>(pkuhit.xap.dao.auto.entity._IemrPatient.getSingletonInternal()));
            pkuhit.xap.dao.auto.entity.IemrPatient __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "selectIemrPatientById", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "selectIemrPatientById", __e);
            throw __e;
        }
    }

    @Override
    public int insert(pkuhit.xap.dao.auto.entity.IemrPatient entity) {
        entering("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "insert", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoInsertQuery<pkuhit.xap.dao.auto.entity.IemrPatient> __query = new org.seasar.doma.internal.jdbc.query.AutoInsertQuery<pkuhit.xap.dao.auto.entity.IemrPatient>(pkuhit.xap.dao.auto.entity._IemrPatient.getSingletonInternal());
            __query.setMethod(__method1);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.xap.dao.auto.IemrPatientDaoImpl");
            __query.setCallerMethodName("insert");
            __query.setQueryTimeout(-1);
            __query.setNullExcluded(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.InsertCommand __command = new org.seasar.doma.internal.jdbc.command.InsertCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "insert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "insert", __e);
            throw __e;
        }
    }

    @Override
    public int insertExludeNull(pkuhit.xap.dao.auto.entity.IemrPatient entity) {
        entering("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "insertExludeNull", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoInsertQuery<pkuhit.xap.dao.auto.entity.IemrPatient> __query = new org.seasar.doma.internal.jdbc.query.AutoInsertQuery<pkuhit.xap.dao.auto.entity.IemrPatient>(pkuhit.xap.dao.auto.entity._IemrPatient.getSingletonInternal());
            __query.setMethod(__method2);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.xap.dao.auto.IemrPatientDaoImpl");
            __query.setCallerMethodName("insertExludeNull");
            __query.setQueryTimeout(-1);
            __query.setNullExcluded(true);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.InsertCommand __command = new org.seasar.doma.internal.jdbc.command.InsertCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "insertExludeNull", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "insertExludeNull", __e);
            throw __e;
        }
    }

    @Override
    public int update(pkuhit.xap.dao.auto.entity.IemrPatient entity) {
        entering("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "update", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.xap.dao.auto.entity.IemrPatient> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.xap.dao.auto.entity.IemrPatient>(pkuhit.xap.dao.auto.entity._IemrPatient.getSingletonInternal());
            __query.setMethod(__method3);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.xap.dao.auto.IemrPatientDaoImpl");
            __query.setCallerMethodName("update");
            __query.setQueryTimeout(-1);
            __query.setNullExcluded(false);
            __query.setVersionIncluded(false);
            __query.setVersionIgnored(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.setUnchangedPropertyIncluded(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.UpdateCommand __command = new org.seasar.doma.internal.jdbc.command.UpdateCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "update", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "update", __e);
            throw __e;
        }
    }

    @Override
    public int updateExcludeNull(pkuhit.xap.dao.auto.entity.IemrPatient entity) {
        entering("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "updateExcludeNull", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.xap.dao.auto.entity.IemrPatient> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.xap.dao.auto.entity.IemrPatient>(pkuhit.xap.dao.auto.entity._IemrPatient.getSingletonInternal());
            __query.setMethod(__method4);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.xap.dao.auto.IemrPatientDaoImpl");
            __query.setCallerMethodName("updateExcludeNull");
            __query.setQueryTimeout(-1);
            __query.setNullExcluded(true);
            __query.setVersionIncluded(false);
            __query.setVersionIgnored(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.setUnchangedPropertyIncluded(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.UpdateCommand __command = new org.seasar.doma.internal.jdbc.command.UpdateCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "updateExcludeNull", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "updateExcludeNull", __e);
            throw __e;
        }
    }

    @Override
    public int markDelete(pkuhit.xap.dao.auto.entity.IemrPatient entity) {
        entering("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "markDelete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.xap.dao.auto.entity.IemrPatient> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<pkuhit.xap.dao.auto.entity.IemrPatient>(pkuhit.xap.dao.auto.entity._IemrPatient.getSingletonInternal());
            __query.setMethod(__method5);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.xap.dao.auto.IemrPatientDaoImpl");
            __query.setCallerMethodName("markDelete");
            __query.setQueryTimeout(-1);
            __query.setNullExcluded(true);
            __query.setVersionIncluded(false);
            __query.setVersionIgnored(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.setUnchangedPropertyIncluded(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.UpdateCommand __command = new org.seasar.doma.internal.jdbc.command.UpdateCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "markDelete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "markDelete", __e);
            throw __e;
        }
    }

    @Override
    public int delete(pkuhit.xap.dao.auto.entity.IemrPatient entity) {
        entering("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "delete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.internal.jdbc.query.AutoDeleteQuery<pkuhit.xap.dao.auto.entity.IemrPatient> __query = new org.seasar.doma.internal.jdbc.query.AutoDeleteQuery<pkuhit.xap.dao.auto.entity.IemrPatient>(pkuhit.xap.dao.auto.entity._IemrPatient.getSingletonInternal());
            __query.setMethod(__method6);
            __query.setConfig(config);
            __query.setEntity(entity);
            __query.setCallerClassName("pkuhit.xap.dao.auto.IemrPatientDaoImpl");
            __query.setCallerMethodName("delete");
            __query.setQueryTimeout(-1);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.DeleteCommand __command = new org.seasar.doma.internal.jdbc.command.DeleteCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "delete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "delete", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchInsert(java.util.List<pkuhit.xap.dao.auto.entity.IemrPatient> entities) {
        entering("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "batchInsert", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchInsertQuery<pkuhit.xap.dao.auto.entity.IemrPatient> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchInsertQuery<pkuhit.xap.dao.auto.entity.IemrPatient>(pkuhit.xap.dao.auto.entity._IemrPatient.getSingletonInternal());
            __query.setMethod(__method7);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("pkuhit.xap.dao.auto.IemrPatientDaoImpl");
            __query.setCallerMethodName("batchInsert");
            __query.setQueryTimeout(-1);
            __query.setBatchSize(-1);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.BatchInsertCommand __command = new org.seasar.doma.internal.jdbc.command.BatchInsertCommand(__query);
            int[] __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "batchInsert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "batchInsert", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchUpdate(java.util.List<pkuhit.xap.dao.auto.entity.IemrPatient> entities) {
        entering("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "batchUpdate", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchUpdateQuery<pkuhit.xap.dao.auto.entity.IemrPatient> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchUpdateQuery<pkuhit.xap.dao.auto.entity.IemrPatient>(pkuhit.xap.dao.auto.entity._IemrPatient.getSingletonInternal());
            __query.setMethod(__method8);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("pkuhit.xap.dao.auto.IemrPatientDaoImpl");
            __query.setCallerMethodName("batchUpdate");
            __query.setQueryTimeout(-1);
            __query.setBatchSize(-1);
            __query.setVersionIncluded(false);
            __query.setVersionIgnored(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.BatchUpdateCommand __command = new org.seasar.doma.internal.jdbc.command.BatchUpdateCommand(__query);
            int[] __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "batchUpdate", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "batchUpdate", __e);
            throw __e;
        }
    }

    @Override
    public int[] batchDelete(java.util.List<pkuhit.xap.dao.auto.entity.IemrPatient> entities) {
        entering("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "batchDelete", entities);
        try {
            if (entities == null) {
                throw new org.seasar.doma.DomaNullPointerException("entities");
            }
            org.seasar.doma.internal.jdbc.query.AutoBatchDeleteQuery<pkuhit.xap.dao.auto.entity.IemrPatient> __query = new org.seasar.doma.internal.jdbc.query.AutoBatchDeleteQuery<pkuhit.xap.dao.auto.entity.IemrPatient>(pkuhit.xap.dao.auto.entity._IemrPatient.getSingletonInternal());
            __query.setMethod(__method9);
            __query.setConfig(config);
            __query.setEntities(entities);
            __query.setCallerClassName("pkuhit.xap.dao.auto.IemrPatientDaoImpl");
            __query.setCallerMethodName("batchDelete");
            __query.setQueryTimeout(-1);
            __query.setBatchSize(-1);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.BatchDeleteCommand __command = new org.seasar.doma.internal.jdbc.command.BatchDeleteCommand(__query);
            int[] __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "batchDelete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "batchDelete", __e);
            throw __e;
        }
    }

    @Override
    public java.sql.Clob createClob() {
        entering("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "createClob");
        try {
            org.seasar.doma.internal.jdbc.query.ClobCreateQuery __query = new org.seasar.doma.internal.jdbc.query.ClobCreateQuery();
            __query.setConfig(config);
            __query.setCallerClassName("pkuhit.xap.dao.auto.IemrPatientDaoImpl");
            __query.setCallerMethodName("createClob");
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.CreateCommand<java.sql.Clob> __command = new org.seasar.doma.internal.jdbc.command.CreateCommand<java.sql.Clob>(__query);
            java.sql.Clob __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "createClob", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "createClob", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.xap.dao.auto.entity.IemrPatient> selectIemrPatientList(java.lang.String condition, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "selectIemrPatientList", condition, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/auto/IemrPatientDao/selectIemrPatientList.sql");
            __query.setOptions(options);
            __query.addParameter("condition", java.lang.String.class, condition);
            __query.setCallerClassName("pkuhit.xap.dao.auto.IemrPatientDaoImpl");
            __query.setCallerMethodName("selectIemrPatientList");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.IemrPatient>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.IemrPatient>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.xap.dao.auto.entity.IemrPatient>(pkuhit.xap.dao.auto.entity._IemrPatient.getSingletonInternal()));
            java.util.List<pkuhit.xap.dao.auto.entity.IemrPatient> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "selectIemrPatientList", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "selectIemrPatientList", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.xap.dao.auto.entity.IemrPatient> selectFollowUpList(java.lang.String startDate, java.lang.String endDate, java.lang.String patientName, java.lang.String inpatientNo, java.lang.String tel, java.lang.String diagnosis, java.lang.String fuFlag, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "selectFollowUpList", startDate, endDate, patientName, inpatientNo, tel, diagnosis, fuFlag, options);
        try {
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/auto/IemrPatientDao/selectFollowUpList.sql");
            __query.setOptions(options);
            __query.addParameter("startDate", java.lang.String.class, startDate);
            __query.addParameter("endDate", java.lang.String.class, endDate);
            __query.addParameter("patientName", java.lang.String.class, patientName);
            __query.addParameter("inpatientNo", java.lang.String.class, inpatientNo);
            __query.addParameter("tel", java.lang.String.class, tel);
            __query.addParameter("diagnosis", java.lang.String.class, diagnosis);
            __query.addParameter("fuFlag", java.lang.String.class, fuFlag);
            __query.setCallerClassName("pkuhit.xap.dao.auto.IemrPatientDaoImpl");
            __query.setCallerMethodName("selectFollowUpList");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.IemrPatient>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.IemrPatient>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.xap.dao.auto.entity.IemrPatient>(pkuhit.xap.dao.auto.entity._IemrPatient.getSingletonInternal()));
            java.util.List<pkuhit.xap.dao.auto.entity.IemrPatient> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "selectFollowUpList", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "selectFollowUpList", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.xap.dao.auto.entity.IemrPatient> selectByAdvancedCondition(java.util.List<java.lang.String> itemValuesList, java.lang.String admissionDateStart, java.lang.String admissionDateEnd, java.lang.String inpatientNoStart, java.lang.String inpatientNoEnd, java.lang.String patientName, java.lang.String sex, java.lang.String birthdayStart, java.lang.String birthdayEnd, java.lang.String tel, java.lang.String address, java.lang.String diagnosis, java.lang.String ring, java.lang.String treatmentPlan, java.lang.String combined) {
        entering("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "selectByAdvancedCondition", itemValuesList, admissionDateStart, admissionDateEnd, inpatientNoStart, inpatientNoEnd, patientName, sex, birthdayStart, birthdayEnd, tel, address, diagnosis, ring, treatmentPlan, combined);
        try {
            if (itemValuesList == null) {
                throw new org.seasar.doma.DomaNullPointerException("itemValuesList");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/auto/IemrPatientDao/selectByAdvancedCondition.sql");
            __query.addParameter("itemValuesList", java.util.List.class, itemValuesList);
            __query.addParameter("admissionDateStart", java.lang.String.class, admissionDateStart);
            __query.addParameter("admissionDateEnd", java.lang.String.class, admissionDateEnd);
            __query.addParameter("inpatientNoStart", java.lang.String.class, inpatientNoStart);
            __query.addParameter("inpatientNoEnd", java.lang.String.class, inpatientNoEnd);
            __query.addParameter("patientName", java.lang.String.class, patientName);
            __query.addParameter("sex", java.lang.String.class, sex);
            __query.addParameter("birthdayStart", java.lang.String.class, birthdayStart);
            __query.addParameter("birthdayEnd", java.lang.String.class, birthdayEnd);
            __query.addParameter("tel", java.lang.String.class, tel);
            __query.addParameter("address", java.lang.String.class, address);
            __query.addParameter("diagnosis", java.lang.String.class, diagnosis);
            __query.addParameter("ring", java.lang.String.class, ring);
            __query.addParameter("treatmentPlan", java.lang.String.class, treatmentPlan);
            __query.addParameter("combined", java.lang.String.class, combined);
            __query.setCallerClassName("pkuhit.xap.dao.auto.IemrPatientDaoImpl");
            __query.setCallerMethodName("selectByAdvancedCondition");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.IemrPatient>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.IemrPatient>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.xap.dao.auto.entity.IemrPatient>(pkuhit.xap.dao.auto.entity._IemrPatient.getSingletonInternal()));
            java.util.List<pkuhit.xap.dao.auto.entity.IemrPatient> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "selectByAdvancedCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "selectByAdvancedCondition", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<pkuhit.xap.dao.auto.entity.IemrPatient> selectByAdvancedCondition(java.util.List<java.lang.String> itemValuesList, java.lang.String admissionDateStart, java.lang.String admissionDateEnd, java.lang.String inpatientNoStart, java.lang.String inpatientNoEnd, java.lang.String patientName, java.lang.String sex, java.lang.String birthdayStart, java.lang.String birthdayEnd, java.lang.String tel, java.lang.String address, java.lang.String diagnosis, java.lang.String ring, java.lang.String treatmentPlan, java.lang.String combined, org.seasar.doma.jdbc.SelectOptions options) {
        entering("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "selectByAdvancedCondition", itemValuesList, admissionDateStart, admissionDateEnd, inpatientNoStart, inpatientNoEnd, patientName, sex, birthdayStart, birthdayEnd, tel, address, diagnosis, ring, treatmentPlan, combined, options);
        try {
            if (itemValuesList == null) {
                throw new org.seasar.doma.DomaNullPointerException("itemValuesList");
            }
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/pkuhit/xap/dao/auto/IemrPatientDao/selectByAdvancedCondition.sql");
            __query.setOptions(options);
            __query.addParameter("itemValuesList", java.util.List.class, itemValuesList);
            __query.addParameter("admissionDateStart", java.lang.String.class, admissionDateStart);
            __query.addParameter("admissionDateEnd", java.lang.String.class, admissionDateEnd);
            __query.addParameter("inpatientNoStart", java.lang.String.class, inpatientNoStart);
            __query.addParameter("inpatientNoEnd", java.lang.String.class, inpatientNoEnd);
            __query.addParameter("patientName", java.lang.String.class, patientName);
            __query.addParameter("sex", java.lang.String.class, sex);
            __query.addParameter("birthdayStart", java.lang.String.class, birthdayStart);
            __query.addParameter("birthdayEnd", java.lang.String.class, birthdayEnd);
            __query.addParameter("tel", java.lang.String.class, tel);
            __query.addParameter("address", java.lang.String.class, address);
            __query.addParameter("diagnosis", java.lang.String.class, diagnosis);
            __query.addParameter("ring", java.lang.String.class, ring);
            __query.addParameter("treatmentPlan", java.lang.String.class, treatmentPlan);
            __query.addParameter("combined", java.lang.String.class, combined);
            __query.setCallerClassName("pkuhit.xap.dao.auto.IemrPatientDaoImpl");
            __query.setCallerMethodName("selectByAdvancedCondition");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.IemrPatient>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<pkuhit.xap.dao.auto.entity.IemrPatient>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<pkuhit.xap.dao.auto.entity.IemrPatient>(pkuhit.xap.dao.auto.entity._IemrPatient.getSingletonInternal()));
            java.util.List<pkuhit.xap.dao.auto.entity.IemrPatient> __result = __command.execute();
            __query.complete();
            exiting("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "selectByAdvancedCondition", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("pkuhit.xap.dao.auto.IemrPatientDaoImpl", "selectByAdvancedCondition", __e);
            throw __e;
        }
    }

}
