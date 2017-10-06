package dev.testlogin;

public class User {
	
	private String userId;
	private String pwd;
	private String uname;
	
	
	public User (String userId){
		this.userId = userId;
		this.uname = userId;
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
