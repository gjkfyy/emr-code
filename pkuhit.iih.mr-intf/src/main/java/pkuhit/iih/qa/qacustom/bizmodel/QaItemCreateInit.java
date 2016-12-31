
package pkuhit.iih.qa.qacustom.bizmodel;

import java.util.List;

/**
 * 评分项目画面初始化数据model <p>QaItemCreateInit</p> <p>TODO</p>
 * 
 * @author yaolijie
 */
public class QaItemCreateInit {

	public QaItemCreateInit() {

		super();

	}
	private List<QaItmFstCategory> qaItmFstCategory;

	private QaItmSndCategory[] qaItmSndCategory;

	public List<QaItmFstCategory> getQaItmFstCategory() {
		return qaItmFstCategory;
	}

	public void setQaItmFstCategory(List<QaItmFstCategory> qaItmFstCategory) {
		this.qaItmFstCategory = qaItmFstCategory;
	}

	public QaItmSndCategory[] getQaItmSndCategory() {
		return qaItmSndCategory;
	}

	public void setQaItmSndCategory(QaItmSndCategory[] qaItmSndCategory) {
		this.qaItmSndCategory = qaItmSndCategory;
	}

}
