package com.calceteam.WPIClient.User;

import java.io.Serializable;

import com.calceteam.WPIClient.model.BaseJsonObject;

public class WPIUser extends BaseJsonObject implements Serializable {

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
		this.set_id(userFacebookUUID);
	}
	
	
	
}
