package model;

import java.io.Serializable;

public class Admin implements Serializable{
	

	private String account, password;
	
	public Admin() {
		super();
	}
	

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
