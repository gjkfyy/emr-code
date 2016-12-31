/**
 * <p>文件名:		ScoreTree.java</p>
 * <p>版权:		CopyrightTag</p>
 * <p>公司:		CompanyTag</p>
 * @author		李德强(li_deqiang@founder.com, readwall@163.com)
 */

package pkuhit.iih.qa.qascore;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * <p>
 * ScoreTree
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
 *          <td>2014年12月20日 上午11:27:19</td>
 *          </tr>
 *          <tr>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          </tr>
 *          </table>
 */
public class ScoreTree {

	private static final Logger log = LoggerFactory.getLogger(ScoreTree.class);

	/**
	 * 当前结点的数据
	 */
	private ScoreCaculate data;

	private ScoreTree parent;

	private List<ScoreTree> children;

	public ScoreCaculate getData() {
		return data;
	}

	public void setData(ScoreCaculate data) {
		this.data = data;
	}

	public ScoreTree getParent() {
		return parent;
	}

	public void setParent(ScoreTree parent) {
		this.parent = parent;
	}

	public List<? extends ScoreTree> getChildren() {
		return children;
	}

	public void setChildren(List<ScoreTree> children) {
		this.children = children;
	}

	public ScoreTree addChild(ScoreTree child) {
		if (null == children) {
			children = new ArrayList<ScoreTree>();
		}
		children.add(child);

		// 算分
		caculateScore(child);

		return this;
	}

	/**
	 * 算分
	 * 
	 * @param child
	 */
	private void caculateScore(ScoreTree child) {
		ScoreCaculate childData = child.getData();
		if (this.data instanceof ScoreQaItem
				&& childData instanceof ScoreQaFault) {
			ScoreQaItem qaItm = (ScoreQaItem) this.data;
			// ScoreQaFault qaFlt = (ScoreQaFault) childData;

			// 单次扣分
			if (qaItm.getQaItemType() == QaDropScoreTypeEnum.ONCE
					&& !qaItm.isDropOnceF()) {
				qaItm.setDropOnceF(true);
				// 进行单次扣分
				log.debug("进行单次扣分");
				ScoreTree t = this;
				while (t.getParent() != null) {// 质控项目的父节点有可能是段落，文书，病案
					ScoreDrop drop = (ScoreDrop) t.getParent().getData();
					drop.dropScore(qaItm.getOnceDropScore());
					t = t.getParent();
				}
			} else if (qaItm.getQaItemType() == QaDropScoreTypeEnum.MORE_THAN_ONCE) {
				ScoreTree t = this;
				ScoreDrop sd = (ScoreDrop) t.getData();
				double dropScore = sd.dropScore(qaItm.getOnceDropScore());
				log.debug("进行多次扣分，本次扣分" + dropScore);
				while (t.getParent() != null) {// 质控项目的父节点有可能是段落，文书，病案
					ScoreDrop drop = (ScoreDrop) t.getParent().getData();
					drop.dropScore(dropScore);
					t = t.getParent();
				}
			} else if (qaItm.getQaItemType() == QaDropScoreTypeEnum.GRADE_B) {
				// 单否乙质控类型缺陷不扣分
				// 病案的评级变为乙级
				ScoreTree t = this;
				while (t.getParent() != null) {// 获取病案
					t = t.getParent();
				}
				ScoreAmr amr = (ScoreAmr) t.getData();
				amr.setGRADE(QaDropScoreTypeEnum.GRADE_B);

			} else if (qaItm.getQaItemType() == QaDropScoreTypeEnum.GRADE_C) {
				// 单否丙质控类型缺陷不扣分
				// 病案的评级变为丙级
				ScoreTree t = this;
				while (t.getParent() != null) {// 获取病案
					t = t.getParent();
				}
				ScoreAmr amr = (ScoreAmr) t.getData();
				amr.setGRADE(QaDropScoreTypeEnum.GRADE_C);
			}
		}
	}

	/**
	 * 构造器
	 */
	public ScoreTree() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 构造器
	 */
	public ScoreTree(ScoreCaculate data) {
		this.data = data;
	}

	/**
	 * FIXME
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
	}

}
