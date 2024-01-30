package TestData;

public enum info {
	USERNAME("ksaadmin"), PSWD("1234");

	private String credentials;

	private info(String credentials) {
		this.credentials = credentials;

	}

	public String getcredentials() {
		return credentials;
	}

}
// info.USERNAME.getcredentials()