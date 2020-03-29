package org.DAO;

public class LoginPersonalInfoParseData {
	private String EmID, userName, pw;

	public LoginPersonalInfoParseData(String emID, String userName, String pw) {
		super();
		EmID = emID;
		this.userName = userName;
		this.pw = pw;
	}

	public String getEmID() {
		return EmID;
	}

	public void setEmID(String emID) {
		EmID = emID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

}
