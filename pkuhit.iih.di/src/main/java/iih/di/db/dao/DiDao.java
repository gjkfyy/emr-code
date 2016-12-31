/**
 * <p>文件名:		DiDao.java</p>
 * <p>版权:		CopyrightTag</p>
 * <p>公司:		CompanyTag</p>
 * @author		李德强(li_deqiang@founder.com, readwall@163.com)
 */

package iih.di.db.dao;

import iih.di.db.gen.entity.MdDiEntity;
import iih.di.setttings.IihSettings;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import xap.sv.dao.annotation.RepositoryConfig;

/**
 * <p>
 * DiDao
 * </p>
 * <p>
 * 诊断的通用dao
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
 *          <td>2014年9月18日 上午11:31:01</td>
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
public interface DiDao {
	//从诊断表查询诊断
	@Select(maxRows = IihSettings.DIM_ASSIS_NUM)
	List<MdDiEntity> assistantQuerySpell(String keyWord, boolean prefixF);
	
	//从诊断表查询诊断
	@Select
	List<MdDiEntity> assistantQueryEqualSpell(String keyWord, boolean isEqual);	
	
	//从诊断别名表查询诊断
	@Select
	List<MdDiEntity> assistantQueryAliasEqualSpell(String keyWord,boolean isEqual);
	
	//从诊断别名表查询诊断
	@Select(maxRows = IihSettings.DIM_ASSIS_NUM)
	List<MdDiEntity> assistantQueryAliasSpell(String keyWord, boolean prefixF);
	
	@Select(maxRows = IihSettings.DIM_ASSIS_NUM)
	List<MdDiEntity> assistantQueryNm(String keyWord, boolean prefixF);
	
	@Select(maxRows = IihSettings.DIM_ASSIS_NUM)
	List<MdDiEntity> assistantQueryAll();

}
