package com.finzly.loan.ExceptionHandleR;

public class MyError {
	private String message;
	private int statusCode;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	@Override
	public String toString() {
		return "MyError [message=" + message + ", statusCode=" + statusCode + "]";
	}
	public MyError(String message, int statusCode) {
		super();
		this.message = message;
		this.statusCode = statusCode;
	}
}
