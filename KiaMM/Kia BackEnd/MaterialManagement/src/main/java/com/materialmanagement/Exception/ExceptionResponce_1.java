package com.materialmanagement.Exception;

import java.time.LocalDateTime;

public class ExceptionResponce {

	private LocalDateTime timestamp;
	private boolean status;
	private String message;
	private Object datasource;

	public ExceptionResponce(LocalDateTime timestamp, boolean status, String message, Object datasource) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.message = message;
		this.datasource = datasource;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getdatasource() {
		return datasource;
	}

	public void setdatasource(Object datasource) {
		this.datasource = datasource;
	}

}
