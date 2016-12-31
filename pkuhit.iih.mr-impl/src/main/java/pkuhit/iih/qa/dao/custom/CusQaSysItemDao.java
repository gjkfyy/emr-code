/**
 * <p>文件名:		CusQaSysItemDao.java</p>
 * <p>版权:		CopyrightTag</p>
 * <p>公司:		CompanyTag</p>
 * @author		李德强(li_deqiang@founder.com, readwall@163.com)
 */

package pkuhit.iih.qa.dao.custom;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import pkuhit.iih.mr.md.dao.auto.entity.MdMrTp;
import pkuhit.iih.qa.dao.auto.entity.QaSysItm;
import pkuhit.iih.qa.dao.custom.entity.CusQaSysItm;
import xap.sv.dao.annotation.RepositoryConfig;

/**
 * <p>
 * CusQaSysItemDao
 * </p>
 * <p>
 * 自定义的质控体系_质控项目dao
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
 *          <td>2014年12月9日 下午1:22:21</td>
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
public interface CusQaSysItemDao {

	/**
	 * @param enTpCd
	 *            就诊类型编码
	 * @param mrTemplateCode
	 *            医疗记录类型编码
	 * @param mrSegmentTemplateCode
	 *            医疗记录段落类型编码
	 * @return List pkuhit.iih.qa.dao.custom.entity.CusQaSysItem
	 */
	@Select
	List<CusQaSysItm> searchQaSysItem(String enTpCd, List<String> mrTpCds,
			String mrSegmentTemplateCode);

	/**
	 * 查询某个病例文书类型的所有子病例文书类型
	 * 
	 * @param parentCd
	 * @return
	 */
	@Select
	MdMrTp selectParentMrTpByMrTpCd(String mrTpCd);

}
