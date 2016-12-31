package pkuhit.xap.file;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.servlet.mvc.annotation.RequestBody;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface FileService
{
    /**
     * 创建文件对象
     * 
     * @param folder 文件容器，biz指得是业务文件，base指得是基础文件
     * @param bytes 文件内容（字节数组）
     * @return 文件对象
     */
    @RequestMapping(value = "/file", method = RequestMethod.POST)
    FileObject createFile(@RequestParam("folder") String folder,
            @RequestBody byte[] bytes);

    /**
     * 更新文件对象
     * @param id 文件对象ID
     * @param bytes 文件内容（字节数组）
     * @return 更新后的文件对象
     */
    @RequestMapping(value = "/file/{id}", method = RequestMethod.PUT)
    FileObject updateFile(@PathVariable("id") String id,
            @RequestBody byte[] bytes);

    /**
     * 取得文件对象
     * 
     * @param id 文件对象ID
     * @return 文件对象
     */
    @RequestMapping(value = "/file/{id}", method = RequestMethod.GET)
    FileObject getFile(@PathVariable("id") String id);

    /**
     * 删除文件对象
     * @param id 文件ID
     * @return 被删除的文件对象
     */
    @RequestMapping(value = "/file/{id}", method = RequestMethod.DELETE)
    FileObject deleteFile(@PathVariable("id") String id);

    /**
     * 取得模板文件对象
     * 
     * @param id 文件对象ID
     * @return 文件对象
     */
	FileObject getBaseFile(String id);
    /**
     * 取得病历文件对象
     * 
     * @param id 文件对象ID
     * @return 文件对象
     */
	FileObject getBizFile(String id);
    /**
     * 创建病历文件对象
     * 
     * @param folder 文件容器，biz指得是业务文件，base指得是基础文件
     * @param bytes 文件内容（字节数组）
     * @return 文件对象
     */
	FileObject createBizFile(byte[] bytes) throws Exception;
    /**
     * 创建模板文件对象
     * 
     * @param folder 文件容器，biz指得是业务文件，base指得是基础文件
     * @param bytes 文件内容（字节数组）
     * @return 文件对象
     */
	FileObject createBaseFile(byte[] bytes) throws Exception;
    /**
     * 更新病历文件对象
     * @param id 文件对象ID
     * @param bytes 文件内容（字节数组）
     * @return 更新后的文件对象
     * @throws Exception 
     */
	FileObject updateBizFile(String id, byte[] bytes) throws SQLException, Exception;
	/**
     * 更新模板文件对象
     * @param id 文件对象ID
     * @param bytes 文件内容（字节数组）
     * @return 更新后的文件对象
	 * @throws Exception 
     */
	FileObject updateBaseFile(String id, byte[] bytes) throws SQLException, Exception;
}
