package driverManagerFactory;
public enum DriverType {
	CHROME, FIREFOX, EDGE, IE;

	public static final String COMMON_URL;

	static {
		try {
			COMMON_URL ="https://dev-arlavansales.winitsoftware.com/pages/Login.aspx";
		} catch (Exception e) {
			throw new RuntimeException("Failed to initialize URL", e);
		}
	}

	public String getUrl() {
		return COMMON_URL;
	}
}
