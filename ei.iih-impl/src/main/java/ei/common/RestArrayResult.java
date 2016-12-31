package ei.common;

import xap.sv.model.ArrayResult;

public class RestArrayResult<T> {

	

	//返回结果状态1=成功；0=失败
	private String code;

	private String msg;
	
	
	private T[] result = null;
	


	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T[] getResult() {
		return result;
	}

	public void setResult(T[] result) {
		this.result = result;
	}
	

}
