package ei.common;

public class RestRequestEntity {
	
	private String entityName;

	private String url;
	
	private String method;
	
	private String defaultParam;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getDefaultParam() {
		return defaultParam;
	}

	public void setDefaultParam(String defaultParam) {
		this.defaultParam = defaultParam;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	
	
}
