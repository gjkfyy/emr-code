/**
 * <p>文件名:		ScoreQaMrSeg.java</p>
 * <p>版权:		CopyrightTag</p>
 * <p>公司:		CompanyTag</p>
 * @author		李德强(li_deqiang@founder.com, readwall@163.com)
 */

package pkuhit.iih.qa.qascore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * ScoreQaMrSeg
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
 *          <td>2014年12月20日 上午10:49:41</td>
 *          </tr>
 *          <tr>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          </tr>
 *          </table>
 */
public class ScoreQaMrSeg extends ScoreCaculate implements ScoreDrop {

	/**
	 * 构造器
	 */
	public ScoreQaMrSeg() {
		// TODO Auto-generated constructor stub
	}

	private static final Logger log = LoggerFactory
			.getLogger(ScoreQaMrSeg.class);

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

	@Override
	public double dropScore(double dropScoreValue) {
		this.dropTotalScore += dropScoreValue;

		if (this.getMaxDropScore() <= this.dropTotalScore) {
			log.warn("病例文书段落:" + this.getCode() + " 所扣总分值已经超过病例文书段落最大可扣分值");
			log.warn("设置扣分值为病例文书段落最大可扣分值:" + this.getMaxDropScore());
			this.dropTotalScore = this.getMaxDropScore();
		}
		return this.dropTotalScore;
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
