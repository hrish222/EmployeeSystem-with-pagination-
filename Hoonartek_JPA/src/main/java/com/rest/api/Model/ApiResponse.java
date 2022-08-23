package com.rest.api.Model;

public class ApiResponse<T> {

    int recordCount;
    T response;
    
	public ApiResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ApiResponse(int recordCount, T response) {
		super();
		this.recordCount = recordCount;
		this.response = response;
	}

	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public T getResponse() {
		return response;
	}
	public void setResponse(T response) {
		this.response = response;
	}
	@Override
	public String toString() {
		return "ApiResponse [recordCount=" + recordCount + ", response=" + response + "]";
	}
    
    
    

}