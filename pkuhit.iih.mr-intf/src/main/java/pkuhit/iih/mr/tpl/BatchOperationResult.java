/**
 * 
 */
package pkuhit.iih.mr.tpl;


/**
 * @author guo_zhongbao
 *
 */
public class BatchOperationResult{
	
		public BatchOperationResult()
	   	{
	        setSuccess("success");
	    }
		//成功标志
		private String success;		
		//消息
		private String message;		
		//成功操作个数
		private int successCount;
		//失败操作个数
		private int failCount;
		//失败条目
		private FailItem[] failItems ;
		public String getSuccess() {
			return success;
		}
		public void setSuccess(String success) {
			this.success = success;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public int getSuccessCount() {
			return successCount;
		}
		public void setSuccessCount(int successCount) {
			this.successCount = successCount;
		}
		public int getFailCount() {
			return failCount;
		}
		public void setFailCount(int failCount) {
			this.failCount = failCount;
		}
		public FailItem[] getFailItems() {
			return failItems;
		}
		public void setFailItems(FailItem[] failitems) {
			this.failItems = failitems;
		}
		
}
