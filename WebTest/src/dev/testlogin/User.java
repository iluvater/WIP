package dev.testlogin;

public class User {
	
	private String userId;
	private String pwd;
	private String uname;
	
	
	public User (String userId, String pwd, String uname){
		this.userId = userId;
		this.uname = uname;
		this.pwd = pwd;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}

}
