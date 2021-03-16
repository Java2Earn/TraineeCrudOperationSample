package com.exception;



//import java.time.LocalDateTime;

public class ExceptionBean {

	private String url;
	private String message;
//	private String timestamp;
	
	
	/*public ExceptionBean(String url, String message, String timestamp) {
		
		this.url = url;
		this.message = message;
		this.timestamp = timestamp;
	}
*/
	

	public ExceptionBean(String url, String message) {
		this.url = url;
		this.message = message;
	}
	
	public String getUrl() {
	return url;
	}
	public void setUrl(String url) {
	this.url = url;
	}
	public String getMessage() {
	return message;
	}
	public void setMessage(String message) {
	this.message= message;
	}

	/*public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}*/
	
}
