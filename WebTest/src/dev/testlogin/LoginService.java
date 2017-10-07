package dev.testlogin;

public class LoginService {

	public boolean checkLogin(String userId, String pwd){
		if (userId == null || userId.equals("")){
			return false;
		}else{
			MyDBConnection db = new MyDBConnection();
			User user = db.getUser(userId);
			
			if(user!= null && user.getPwd().equals(pwd)){
				return true;
			}else{
				return false;
			}
		}
	}

	public User getUser(String userId) {
		MyDBConnection db = new MyDBConnection();
		User user = db.getUser(userId);
		return user;
	}

}
