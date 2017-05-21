package pkuhit.xap.dao.auto.entity;

import java.sql.Timestamp;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 高级检索条件
 */
@Table(name = "IEMR_SEARCH_CONDITION")
@Entity
public class IemrSearchCondition {

		//ID
		@Id
		@Column(name="ID")
		String id;
		
		@Column(name="USER_ID")
		String userId;
		
	    @Column(name = "CRT_TIME")
	    Timestamp crtTime;
		
		@Column(name="CONDITION")
		String condition;
		
		@Column(name="CONDITION_NAME")
		String conditionName;
		
	    //删除标识
	    @Column(name = "DEL_F")
	    Short delF;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public Timestamp getCrtTime() {
			return crtTime;
		}

		public void setCrtTime(Timestamp crtTime) {
			this.crtTime = crtTime;
		}

		public String getCondition() {
			return condition;
		}

		public void setCondition(String condition) {
			this.condition = condition;
		}

		public String getConditionName() {
			return conditionName;
		}

		public void setConditionName(String conditionName) {
			this.conditionName = conditionName;
		}

		public Short getDelF() {
			return delF;
		}

		public void setDelF(Short delF) {
			this.delF = delF;
		}
	    
	    
		
}