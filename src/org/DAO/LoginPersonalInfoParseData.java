package org.DAO;

public class LoginPersonalInfoParseData {
	private String username, pw;

	public LoginPersonalInfoParseData(String username, String pw) {
		super();
		this.username = username;
		this.pw = pw;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

}
