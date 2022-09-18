package com.baseclass;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	RequestSpecification reqSpec;
	Response response;

	public void basicAuth(String userName, String password) {
		reqSpec = reqSpec.auth().preemptive().basic(userName, password);
	}

	public void addHeader(String key, String value) {
		reqSpec = RestAssured.given().header(key, value);
	}

	public void addHeaders(Headers headers) {
		reqSpec = RestAssured.given().headers(headers);
	}

	public void addQueryParam(String key, String value) {
		reqSpec = reqSpec.queryParam(key, value);
	}

	public void addPathParem(String key, String value) {
		reqSpec = reqSpec.pathParam(key, value);
	}

	public void addBody(String body) {
		reqSpec = reqSpec.body(body);
	}

	public void addBody(Object body) {
		reqSpec = reqSpec.body(body);
	}

	public Response requestType(String reqType, String endpoint) {
		switch (reqType) {
		case "GET":
			response = reqSpec.get(endpoint);
			break;

		case "POST":
			response = reqSpec.post(endpoint);
			break;

		case "PUT":
			response = reqSpec.put(endpoint);
			break;
		case "DELETE":
			response = reqSpec.delete(endpoint);
			break;
		default:
			break;
		}
		return response;
	}

	public int getStatusCode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;
	}

	public String getResponseBodyAsString(Response response) {
		String asString = response.asString();
		return asString;
	}

	public String getResponseBodyAsPrettyString(Response response) {
		String asPrettyString = response.asPrettyString();
		return asPrettyString;
	}

	public void formData(String key, File path) {
		reqSpec = reqSpec.multiPart(key, path);
	}
}