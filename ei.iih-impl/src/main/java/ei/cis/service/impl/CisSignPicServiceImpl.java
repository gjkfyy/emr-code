package ei.cis.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;

import ei.cis.db.dao.CisSignPicDao;
import ei.cis.service.CisSignPicService;

import pkuhit.xap.ac.User;
import xap.sv.model.SingleResult;

public class CisSignPicServiceImpl implements CisSignPicService
{
    private Logger log = LoggerFactory.getLogger(CisSignPicServiceImpl.class);
    
    @Autowired
    CisSignPicDao cisSignPicDao;
    
    public SingleResult<User> selectSignPicByUser(String userCd){
        SingleResult<User> result=new SingleResult<User>();
        User user=new User();
        Blob blob = cisSignPicDao.selectUserImg(userCd);
        user.setSignPicture(this.blobToString(blob));
        result.setData(user);
        return result;
    }
    
    public String blobToString(Blob blob) {
        String reString = "";
        if(blob == null)
            return reString;
        try{
            InputStream ins = blob.getBinaryStream();
            if(ins != null){
                ByteArrayOutputStream ot = new ByteArrayOutputStream();
                int i = 0;
                while ((i=ins.read())!=-1) {
                    ot.write(i);
                }
                byte[] data = ot.toByteArray();
                reString = new String(Base64.encodeBase64(data));
                ot.close();
                ins.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return reString;
    }
}
