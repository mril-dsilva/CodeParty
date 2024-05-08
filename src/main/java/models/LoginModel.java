package models;

public class LoginModel {
	String username = "bradshaw";
	String password = "password";
	
	public boolean attemptLogin(String username, String password) {
		if(this.username.equals(username) && this.password.equals(password)) {
			return true;
		}else {
			return false;
		}
	}
}
