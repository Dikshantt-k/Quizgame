package com.example.quizapp.question;

import lombok.Data;

@Data
public class Response {
	
	public int id;
	public String response;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public Response(int id, String response) {
		super();
		this.id = id;
		this.response = response;
	}
	public Response() {
		super();
	}
	
	
}
