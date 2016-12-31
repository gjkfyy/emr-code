package pkuhit.xap.file;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Clob;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.util.Assert;

import pkuhit.iih.mr.pub.MessageCode;
import pkuhit.xap.dao.auto.XapBasefileDao;
import pkuhit.xap.dao.auto.XapBizfileDao;
import pkuhit.xap.dao.auto.entity.XapBasefile;
import pkuhit.xap.dao.auto.entity.XapBizfile;
import pkuhit.xap.dao.custom.CusXapBasefileDao;
import xap.sv.annotation.Reference;
import xap.sv.dao.DaoFactory;
import xap.sv.notification.Notification;
import xap.sv.notification.exception.NotificationException;
import xap.sv.util.UUIDGenerator;

public class FileServiceImpl implements FileService
{
    @Reference
    DaoFactory daoFactory;

    @Autowired
    CusXapBasefileDao  cusXapBasefileDao;
    
	@Autowired
	JdbcTemplate jdbcTemplate;
    
    @Override
    public FileObject getFile(String id)
    {
        FileObject fo = getBaseFile(id);
        if (fo == null)
        {
            fo = getBizFile(id);
        }
        Assert.notNull(fo, "can not find file object with id [" + id + "]");
        return fo;
    }

    @Override
    public FileObject getBaseFile(String id)
    {
        XapBasefileDao dao = daoFactory.getDao(XapBasefileDao.class);
        XapBasefile basefile = dao.selectById(id);
        if (basefile != null)
        {
            Clob clob = basefile.getFileData();
            return getFileByClob(id, clob);
        }
        return null;
    }

    @Override
    public FileObject getBizFile(String id)
    {
        XapBizfileDao xbfd = daoFactory.getDao(XapBizfileDao.class);
        XapBizfile bizfile = xbfd.selectById(id);
        if (bizfile != null)
        {
            Clob clob = bizfile.getFileData();
            return getFileByClob(id, clob);
        }
        return null;
    }

    FileObject getFileByClob(String id, Clob clob)
    {
        try
        {
            byte[] clobData = null;
            String content =  null ;
            if(clob!=null && clob.length()!=0){
            	content = clob.getSubString((long)1,(int)clob.length());
            }
            InputStream in = null ;
            if (!StringUtils.isBlank(content)) {
            	clobData = content.getBytes("UTF-8");
            	in = new ByteArrayInputStream(clobData); 
            }else{
            	//当content为""时
            	in = new ByteArrayInputStream(new byte[0]);
            }
            
            FileObject fo = new FileObject(id, clob.length(), in);
            return fo;
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public FileObject deleteFile(String id)
    {
        FileObject fo = getBizFile(id);
        if (fo != null)
        {
            XapBizfileDao bizfiledao = daoFactory.getDao(XapBizfileDao.class);
            XapBizfile bizfile = new XapBizfile();
            bizfile.setFilePk(id);
            bizfiledao.markDelete(bizfile);
            return fo;
        }
        fo = getBaseFile(id);
        if (fo != null)
        {
            XapBasefile entity = new XapBasefile();
            entity.setFilePk(id);
            XapBasefileDao basefiledao = daoFactory.getDao(XapBasefileDao.class);
            basefiledao.markDelete(entity);
            return fo;
        }
        Assert.notNull(fo, "can not find file object with id [" + id + "]");
        return fo;
    }

    @Override
    public FileObject createFile(String folder, byte[] bytes)
    {
        try
        {
            if ("biz".equalsIgnoreCase(folder))
            {
                return createBizFile(bytes);
            }
            else if ("base".equalsIgnoreCase(folder))
            {
                return createBaseFile(bytes);
            }
            else
                return null;
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public FileObject createBizFile(byte[] bytes) throws Exception
    {
        String data = new String(bytes);
        XapBizfileDao dao = daoFactory.getDao(XapBizfileDao.class);
        Clob clob = dao.createClob();
        clob.setString(1, data);
        // ObjectData o = new ObjectData(bytes);
        // o.writeTo(clob.setAsciiStream(1));
        XapBizfile entity = new XapBizfile();
        entity.setFileData(clob);
        entity.setFilePk(UUIDGenerator.getUUID());
        dao.insertExludeNull(entity);
        return getFile(entity.getFilePk());
    }

    @Override
    public FileObject createBaseFile(byte[] bytes) throws Exception
    {
        XapBasefileDao dao = daoFactory.getDao(XapBasefileDao.class);
        Clob clob = dao.createClob();
        String data = new String(bytes);
        clob.setString(1, data);
        // ObjectData o = new ObjectData(bytes);
        // o.writeTo(clob.setAsciiStream(1));
        XapBasefile entity = new XapBasefile();
        entity.setFileData(clob);
        entity.setFilePk(UUIDGenerator.getUUID());
        dao.insertExludeNull(entity);
        return getFile(entity.getFilePk());
    }

    @Override
    public FileObject updateFile(String id, byte[] bytes)
    {
        FileObject fo = null;
        try
        {
            if (this.isBaseFile(id))
            {
            	fo = updateBaseFile(id, bytes);
            }
            else
            {
                fo = updateBizFile(id, bytes);
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Notification notification = new Notification(MessageCode.FILE_UPDATE_FAILURE, "文件保存失败,请重试保存。");
			throw new NotificationException(notification);
			//throw new RuntimeException(e);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Notification notification = new Notification(MessageCode.FILE_UPDATE_FAILURE, "文件保存失败,请重试保存。");
			throw new NotificationException(notification);
			//throw new RuntimeException(e);
		}
        return fo;
    }

    @Override
    public FileObject updateBizFile(String id, byte[] bytes) throws SQLException,Exception
    {
    	FileObject bizFile = getBizFile(id);
    	if(bizFile == null){
            String data = new String(bytes);
            XapBizfileDao dao = daoFactory.getDao(XapBizfileDao.class);
            Clob clob = dao.createClob();
            clob.setString(1, data);
            // ObjectData o = new ObjectData(bytes);
            // o.writeTo(clob.setAsciiStream(1));
            XapBizfile entity = new XapBizfile();
            entity.setFileData(clob);
            entity.setFilePk(id);
            dao.insertExludeNull(entity);
            return getFile(entity.getFilePk());
    	}else{
	        XapBizfileDao dao = daoFactory.getDao(XapBizfileDao.class);
	        Clob clob = dao.createClob();
	        String data = new String(bytes);
	        clob.setString(1, data);
	        XapBizfile entity = new XapBizfile();
	        entity.setFileData(clob);
	        entity.setFilePk(id);
	        dao.updateExcludeNull(entity);
	        return getFile(id);
    	}
    }

    @Override
    public FileObject updateBaseFile(String id, byte[] bytes) throws SQLException,Exception
    {
    	FileObject baseFile = getBaseFile(id);
    	if(baseFile == null){
    		XapBasefileDao dao = daoFactory.getDao(XapBasefileDao.class);
            Clob clob = dao.createClob();
            String data = new String(bytes);
            clob.setString(1, data);
            // ObjectData o = new ObjectData(bytes);
            // o.writeTo(clob.setAsciiStream(1));
            XapBasefile entity = new XapBasefile();
            entity.setFileData(clob);
            entity.setFilePk(id);
            dao.insertExludeNull(entity);
            return getFile(entity.getFilePk());
    	}else{
	    	XapBasefileDao dao = daoFactory.getDao(XapBasefileDao.class);
	        Clob clob = dao.createClob();
	        final String data = new String(bytes);
	        clob.setString(1, data);
	        String strGetXapBaseFileById = "update xap_basefile set  file_data = ? where file_pk ='"+id+"'";
	        final LobHandler lobHandler=new DefaultLobHandler();  
	        this.jdbcTemplate.execute(strGetXapBaseFileById, new AbstractLobCreatingPreparedStatementCallback(lobHandler){   
	            protected void setValues(PreparedStatement pstmt,LobCreator lobCreator) throws SQLException{  
	                lobCreator.setClobAsString(pstmt, 1, data);
	             //   lobCreator.setBlobAsBinaryStream(pstmt,2,is,(int)binaryFile.length());  
	          }  
	        });   
    	}
        
        return getFile(id);
    }

    boolean isBaseFile(String id)
    {
        FileObject fo = getBaseFile(id);
        if (fo != null)
        {
            return true;
        }
        return false;
    }
}
