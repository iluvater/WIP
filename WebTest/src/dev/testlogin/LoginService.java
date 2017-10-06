package dev.testlogin;

public class LoginService {
	
	public boolean checkLogin(String userId, String pwd){
		if (userId != null && pwd != null){
			return true;
		}else{
			return false;
		}
	}
	
	public User getUser(String userId){
		return new User(userId);
	}

}
