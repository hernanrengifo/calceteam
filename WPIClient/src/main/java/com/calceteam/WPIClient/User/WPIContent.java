package com.calceteam.WPIClient.User;

import java.io.Serializable;

public class WPIContent implements Serializable{
	private static final long serialVersionUID = -5034001432012942671L;
	private String userUUID;
	private String content;
	private String contentUUID;
	private String languaje = "es";
	private boolean isReply = false;
	private boolean isForward = false;
	private String parentContentUUID;
	
	public String getUserUUID() {
		return userUUID;
	}
	public void setUserUUID(String userUUID) {
		this.userUUID = userUUID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContentUUID() {
		return contentUUID;
	}
	public void setContentUUID(String contentUUID) {
		this.contentUUID = contentUUID;
	}
	public String getLanguaje() {
		return languaje;
	}
	public void setLanguaje(String languaje) {
		this.languaje = languaje;
	}
	public boolean isReply() {
		return isReply;
	}
	public void setReply(boolean isReply) {
		this.isReply = isReply;
	}
	public boolean isForward() {
		return isForward;
	}
	public void setForward(boolean isForward) {
		this.isForward = isForward;
	}
	public String getParentContentUUID() {
		return parentContentUUID;
	}
	public void setParentContentUUID(String parentContentUUID) {
		this.parentContentUUID = parentContentUUID;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
