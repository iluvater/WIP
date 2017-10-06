package dev.testlogin;

public class LoginService {
	
	public boolean checkLogin(String userId, String pwd){
		if (userId == null || userId.equals("")){
			return false;
		}else{
			return true;
		}
	}
	
	public User getUser(String userId){
		return new User(userId);
	}

}
