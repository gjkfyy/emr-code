/**
 * <p>文件名:		ScoreTree.java</p>
 * <p>版权:		CopyrightTag</p>
 * <p>公司:		CompanyTag</p>
 * @author		李德强(li_deqiang@founder.com, readwall@163.com)
 */

package pkuhit.iih.qa.qascore;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * ScoreTreeNode
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
 *          <td>2014年12月20日 上午10:52:45</td>
 *          </tr>
 *          <tr>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          </tr>
 *          </table>
 */
public class ScoreTreeNode<T> {

	/**
	 * 当前结点的数据
	 */
	private T data;

	private ScoreTreeNode<T> parent;

	private List<ScoreTreeNode<T>> children;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public ScoreTreeNode<T> getParent() {
		return parent;
	}

	public void setParent(ScoreTreeNode<T> parent) {
		this.parent = parent;
	}

	public ScoreTreeNode<T> addChild(ScoreTreeNode<T> child) {
		if (this.children == null) {
			this.children = new ArrayList<ScoreTreeNode<T>>();
		}
		this.children.add(child);
		return this;
	}

	public List<ScoreTreeNode<T>> getChildren() {
		return children;
	}

	public void setChildren(List<ScoreTreeNode<T>> children) {
		this.children = children;
	}

	/**
	 * 构造器
	 */
	public ScoreTreeNode() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * FIXME
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ScoreTreeNode<ScoreCaculate> n = new ScoreTreeNode<ScoreCaculate>();
		n.setData(new ScoreAmr());
//		n.addChild(new ScoreTreeNode<ScoreMrType>());
	}

}
