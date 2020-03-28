package org.DAO;

public class RegistrationManagerTableModels {
	String id, username, pw, status;

	public RegistrationManagerTableModels(String id, String username, String pw, String status) {
		super();
		this.id = id;
		this.username = username;
		this.pw = pw;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
