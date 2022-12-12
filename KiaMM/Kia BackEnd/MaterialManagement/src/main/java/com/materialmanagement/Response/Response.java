package com.materialmanagement.Response;

public class Response {

	private boolean status;
	private String message;
	private Object datasource;

	public Response(boolean status, String message, Object datasource) {
		super();
		this.status = status;
		this.message = message;
		this.datasource = datasource;
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

	public Object getDatasource() {
		return datasource;
	}

	public void setDatasource(Object datasource) {
		this.datasource = datasource;
	}

}
