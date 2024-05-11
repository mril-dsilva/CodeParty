package models;

public class LoginModel {
	
	public LoginModel() {
		super();
		this.username = "bradshaw";
		this.password = "password";
		this.currUser = "123";
	}

	String username;
	String password;
	String currUser;
	
	public String currUser() {
		return currUser;
	}
	
	public boolean attemptLogin(String username, String password) {
		if(this.username.equals(username) && this.password.equals(password)) {
			return true;
		}else {
			return false;
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCurrUser() {
		return currUser;
	}

	public void setCurrUser(String currUser) {
		this.currUser = currUser;
	}
}
