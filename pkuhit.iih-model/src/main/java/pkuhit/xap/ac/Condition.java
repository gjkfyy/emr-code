package pkuhit.xap.ac;

import java.sql.Timestamp;

import org.seasar.doma.Column;

public class Condition {
	
	 public Condition(){
			
		  super();
		
		 }
	
		//ID
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
