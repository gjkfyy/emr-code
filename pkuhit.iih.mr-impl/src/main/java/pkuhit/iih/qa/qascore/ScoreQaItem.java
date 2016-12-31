/**
 * <p>文件名:		ScoreQaItem.java</p>
 * <p>版权:		CopyrightTag</p>
 * <p>公司:		CompanyTag</p>
 * @author		李德强(li_deqiang@founder.com, readwall@163.com)
 */

package pkuhit.iih.qa.qascore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pkuhit.iih.qa.md.QaDropScoreType;

/**
 * <p>
 * ScoreQaItem
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
 *          <td>2014年12月20日 上午10:48:02</td>
 *          </tr>
 *          <tr>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          </tr>
 *          </table>
 */
public class ScoreQaItem extends ScoreCaculate implements ScoreDrop {

	private boolean dropOnceF = false;

	private double onceDropScore;

	private double maxDropScore;

	public boolean isDropOnceF() {
		return dropOnceF;
	}

	public void setDropOnceF(boolean dropOnceF) {
		this.dropOnceF = dropOnceF;
	}

	/**
	 * 质控体系_质控项目
	 */
	private String qaDropScoreTypeCode;

	public String getQaDropScoreTypeCode() {
		return qaDropScoreTypeCode;
	}

	public void setQaDropScoreTypeCode(String qaDropScoreTypeCode) {
		this.qaDropScoreTypeCode = qaDropScoreTypeCode;
	}

	public double getOnceDropScore() {
		return onceDropScore;
	}

	public void setOnceDropScore(double onceDropScore) {
		this.onceDropScore = onceDropScore;
	}

	public double getMaxDropScore() {
		return maxDropScore;
	}

	public void setMaxDropScore(double maxDropScore) {
		this.maxDropScore = maxDropScore;
	}

	private static final Logger log = LoggerFactory
			.getLogger(ScoreQaItem.class);

	/**
	 * 总扣分值
	 */
	private double dropTotalScore = 0;

	public double getDropTotalScore() {
		return dropTotalScore;
	}

	public void setDropTotalScore(double dropTotalScore) {
		this.dropTotalScore = dropTotalScore;
	}

	/**
	 * 注意：质控项目该方法返回值为多次扣分时的每次实际所扣分数
	 */
	@Override
	public double dropScore(double dropScoreValue) {
		if (this.getQaItemType() != QaDropScoreTypeEnum.MORE_THAN_ONCE) {
			return 0;
		}

		if (this.getMaxDropScore() == this.dropTotalScore) {
			return 0;
		}

		this.dropTotalScore += dropScoreValue;

		if (this.getMaxDropScore() >= this.dropTotalScore) {
			return dropScoreValue;
		} else {
			double drop = this.getMaxDropScore() - (this.dropTotalScore - dropScoreValue);
			this.dropTotalScore = this.getMaxDropScore();
			return drop;
		}

	}

	/**
	 * 构造器
	 */
	public ScoreQaItem() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 获得质控扣分类型
	 * 
	 * @return
	 */
	public QaDropScoreTypeEnum getQaItemType() {
		if (QaDropScoreType.ONCE.equals(this.qaDropScoreTypeCode)) {
			return QaDropScoreTypeEnum.ONCE;
		} else if (QaDropScoreType.MORE_THAN_ONCE
				.equals(this.qaDropScoreTypeCode)) {
			return QaDropScoreTypeEnum.MORE_THAN_ONCE;
		} else if (QaDropScoreType.GRADE_B.equals(this.qaDropScoreTypeCode)) {
			return QaDropScoreTypeEnum.GRADE_B;
		} else if (QaDropScoreType.GRADE_C.equals(this.qaDropScoreTypeCode)) {
			return QaDropScoreTypeEnum.GRADE_C;
		} else {
			throw new RuntimeException("质控项目" + this.getCode() + "没有扣分类型");
		}
	}

	/**
	 * FIXME
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
