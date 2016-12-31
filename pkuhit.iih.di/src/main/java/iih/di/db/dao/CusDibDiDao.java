/**
 * <p>文件名:		CusDibDiDao.java</p>
 * <p>版权:		CopyrightTag</p>
 * <p>公司:		CompanyTag</p>
 * @author		李德强(li_deqiang@founder.com, readwall@163.com)
 */

package iih.di.db.dao;

import iih.di.db.gen.entity.DiEntity;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.jdbc.SelectOptions;

import xap.sv.dao.annotation.RepositoryConfig;


/**
 * <p>
 * CusDibDiDao
 * </p>
 * <p>
 * TODO
 * </p>
 * 
 * @author 李德强(li_deqiang@founder.com, readwall@163.com)
 * @version 0.0.0
 *          <table style="border:1px solid gray;">
 *          <tr>
 *          <th width="100px">版本号</th>
 *          <th width="100px">动作</th>
 *          <th width="100px">修改人</th>
 *          <th width="100px">修改时间</th>
 *          </tr>
 *          <!-- 以 Table 方式书写修改历史 -->
 *          <tr>
 *          <td>0.0.0</td>
 *          <td>创建类</td>
 *          <td>李德强</td>
 *          <td>2014年9月1日 下午2:25:18</td>
 *          </tr>
 *          <tr>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          </tr>
 *          </table>
 */
@Dao
@RepositoryConfig
public interface CusDibDiDao {

	/**
	 * 通过就诊序号查询就诊信息列表
	 * @param orgCode 组织编码
	 * @param diSn 就诊序号
	 * @param mainF 主诊断
	 * @return 诊断列表。如果mainF不为空时，只得一条主诊断
	 */
	@Select
	List<DiEntity> selectByEnSn(String enSn, String orgCode,Integer mainF);
	
	/**
	 * 通过就诊序号查询第一条数据，lvl1最小的一条，用来作为主诊断
	 * @param orgCode 组织编码
	 * @param diSn 就诊序号
	 * @return 诊断实体
	 */
	@Select
	DiEntity selectDiNextRecord(String enSn, String orgCode,SelectOptions options);
	/**
	 * 通过就诊序号查询就诊信息列表
	 * @param orgCode 组织编码 参数为00
	 * @param diSn 就诊序号
	 */
	@Select
	List<DiEntity> selectDisByEnSn(String enSn,String orgCode);
	/**
	 * 通过旧就诊序号查询非停用就诊信息列表
	 * @param orgCode 组织编码 参数为00
	 * @param diSn 就诊序号
	 */
	@Select
	List<DiEntity> selectDisByOldEnSn(String enSn,String orgCode);

	/**
	 * 通过旧就诊序号查询非停用就诊信息列表
	 * @param orgCode 组织编码 参数为00
	 * @param diSn 就诊序号
	 */
	@Select
	List<DiEntity> selectDisByEnSnAndDicd(String enSn,String orgCode,String diCd);
	
	
}
