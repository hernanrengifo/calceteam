package com.calceteam.WPIClient.User;

import java.io.Serializable;

public class WPIUser implements Serializable {

	private static final long serialVersionUID = -7109427582891420871L;
	private String user;
	private String userFacebookUUID;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getUserFacebookUUID() {
		return userFacebookUUID;
	}
	public void setUserFacebookUUID(String userFacebookUUID) {
		this.userFacebookUUID = userFacebookUUID;
	}
	
	
	
}
