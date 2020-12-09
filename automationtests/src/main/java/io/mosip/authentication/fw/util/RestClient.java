package io.mosip.authentication.fw.util;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * The Rest assured class to put, post, get request and response
 * 
 * @author Vignesh
 *
 */
public class RestClient {

	private static final Logger RESTCLIENT_LOGGER = Logger.getLogger(RestClient.class);

	private static RestAssuredConfig config = RestAssured.config()
			.httpClient(HttpClientConfig.httpClientConfig().setParam("http.connection.timeout", 50000)
					.setParam("http.socket.timeout", 50000).setParam("http.connection-manager.timeout", 50000));

	/**
	 * REST ASSURED POST request method
	 * 
	 * @param url
	 * @param body
	 * @param contentHeader
	 * @param acceptHeader
	 * @return response
	 */
	public static Response postRequestWithAuthHeader(String url, Object body, String contentHeader, String acceptHeader, String authHeaderName, String authHeaderValue) {
		RESTCLIENT_LOGGER.info("REST-ASSURED: Sending a POST request to " + url);
		Response postResponse = given().config(config).relaxedHTTPSValidation().header(authHeaderName, authHeaderValue).body(body).contentType(contentHeader)
				.accept(acceptHeader).log().all().when().post(url).then().log().all().extract().response();
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response from the request is: " + postResponse.asString());
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response Time is: " + postResponse.time());
		return postResponse;
	}
	
	/**
	 * REST ASSURED POST request method
	 * 
	 * @param url
	 * @param body
	 * @param contentHeader
	 * @param acceptHeader
	 * @return response
	 */
	public static Response postRequest(String url, Object body, String contentHeader, String acceptHeader) {
		RESTCLIENT_LOGGER.info("REST-ASSURED: Sending a POST request to " + url);
		Response postResponse = given().config(config).relaxedHTTPSValidation().body(body).contentType(contentHeader)
				.accept(acceptHeader).log().all().when().post(url).then().log().all().extract().response();
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response from the request is: " + postResponse.asString());
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response Time is: " + postResponse.time());
		return postResponse;
	}
	public static Response postWithFormPathParamAndFile(String url, HashMap<String, String> formParams, HashMap<String, String> pathParams, File file,
			String fileKeyName, String contentHeader, String cookie){
		RESTCLIENT_LOGGER.info("REST:ASSURED:Sending post request with file to" + url);
		RESTCLIENT_LOGGER.info("Name of the file is" + file.getName());
		Cookie.Builder builder = new Cookie.Builder("Authorization", cookie);
		Response postResponse = given().cookie(builder.build()).relaxedHTTPSValidation().multiPart(fileKeyName, file).pathParams(pathParams)
				.formParams(formParams).contentType(contentHeader).expect().when().post(url).then().log().all()
				.extract().response();
		// log then response
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response from request is: " + postResponse.asString());
		RESTCLIENT_LOGGER.info("REST-ASSURED: the response time is: " + postResponse.time());
		return postResponse;
	}
	
	public static Response postWithFormDataAndFile(String url, HashMap<String, String> formParams, String filePath,
			 String contentHeader, String cookie){
		RESTCLIENT_LOGGER.info("REST:ASSURED:Sending post request with file to" + url);
		//RESTCLIENT_LOGGER.info("Name of the file is" + file.getName());
		Cookie.Builder builder = new Cookie.Builder("Authorization", cookie);
		Response postResponse = given().cookie(builder.build()).relaxedHTTPSValidation()
				.contentType(contentHeader)
				.multiPart("files", new File(filePath))
				.multiPart("tableName", formParams.get("tableName"))
				.multiPart("operation", formParams.get("operation"))
				.multiPart("category", formParams.get("category"))
				.expect().when().post(url).then().log().all().extract().response();
		// log then response
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response from request is: " + postResponse.asString());
		RESTCLIENT_LOGGER.info("REST-ASSURED: the response time is: " + postResponse.time());
		return postResponse;
	}
	public static Response postWithFormDataAndMultipleFile(String url, HashMap<String, String> formParams, File[] filePath,
			 String contentHeader, String cookie){
		RESTCLIENT_LOGGER.info("REST:ASSURED:Sending post request with file to" + url);
		//RESTCLIENT_LOGGER.info("Name of the file is" + file.getName());
		Cookie.Builder builder = new Cookie.Builder("Authorization", cookie);
		/*
		 * Response postResponse =
		 * given().cookie(builder.build()).relaxedHTTPSValidation()
		 * .contentType(contentHeader) .multiPart("files", filePath[0])
		 * .multiPart("files", filePath[1]) .multiPart("tableName",
		 * formParams.get("tableName")) .multiPart("operation",
		 * formParams.get("operation")) .multiPart("category",
		 * formParams.get("category"))
		 * .expect().when().post(url).then().log().all().extract().response();
		 */
		
		
		RequestSpecification requestSpecification = given().cookie(builder.build()).relaxedHTTPSValidation()
		.contentType(contentHeader);
		for (int i=0;i<filePath.length;i++) {
			requestSpecification.multiPart("files", filePath[i]);
		}
		Response postResponse =requestSpecification.multiPart("tableName", formParams.get("tableName"))
		.multiPart("operation", formParams.get("operation"))
		.multiPart("category", formParams.get("category"))
		.expect().when().post(url).then().log().all().extract().response();
		
		// log then response
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response from request is: " + postResponse.asString());
		RESTCLIENT_LOGGER.info("REST-ASSURED: the response time is: " + postResponse.time());
		return postResponse;
	}
	/**
	 * REST ASSURED GET request method
	 * 
	 * @param url
	 * @param contentHeader
	 * @param acceptHeader
	 * @param urls
	 * @return response
	 */
	public static Response getRequest(String url, String contentHeader, String acceptHeader, String urls) {
		RESTCLIENT_LOGGER.info("REST-ASSURED: Sending a GET request to " + url);
		Response getResponse = given().config(config).relaxedHTTPSValidation().log().all().when().get(url + "?" + urls)
				.then().log().all().extract().response();
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response from the request is: " + getResponse.asString());
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response Time is: " + getResponse.time());
		return getResponse;
	}

	/**
	 * REST ASSURED GET request method without type or after ?
	 * 
	 * @param url
	 * @param contentHeader
	 * @param acceptHeader
	 * @param urls
	 * @return response
	 */
	public static Response getRequest(String url, String contentHeader, String acceptHeader) {
		RESTCLIENT_LOGGER.info("RESSURED: Sending a GET request to " + url);
		Response getResponse = given().config(config).relaxedHTTPSValidation().log().all().when().get(url).then().log()
				.all().extract().response();
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response from the request is: " + getResponse.asString());
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response Time is: " + getResponse.time());
		return getResponse;
	}

	/**
	 * REST ASSURED POST request method
	 * 
	 * @param url
	 * @param File
	 * @param contentHeader
	 * @param acceptHeader
	 * @return response
	 */
	public static Response postRequest(String url, File file, String contentHeader, String acceptHeader) {
		RESTCLIENT_LOGGER.info("REST-ASSURED: Sending a POST request to " + url);
		Response postResponse = given().config(config).relaxedHTTPSValidation().multiPart(file)
				.contentType(contentHeader).accept(acceptHeader).log().all().when().post(url).then().log().all()
				.extract().response();
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response from the request is: " + postResponse.asString());
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response Time is: " + postResponse.time());
		return postResponse;
	}

	/**
	 * REST ASSURED POST request method
	 * 
	 * @param url
	 * @param string
	 * @param contentHeader
	 * @param acceptHeader
	 * @return response
	 */
	public static Response postRequest(String url, String content, String contentHeader, MediaType acceptHeader) {
		RESTCLIENT_LOGGER.info("REST-ASSURED: Sending a POST request to " + url);
		Response postResponse = given().config(config).relaxedHTTPSValidation().body(content).contentType(contentHeader)
				.accept(acceptHeader.toString()).log().all().when().post(url).then().log().all().extract().response();
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response from the request is: " + postResponse.asString());
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response Time is: " + postResponse.time());
		return postResponse;
	}

	/**
	 * REST ASSURED PATCH request method
	 * 
	 * @param url
	 * @param body
	 * @param contentHeader
	 * @param acceptHeader
	 * @return response
	 */
	public static Response patchRequest(String url, String body, String contentHeader, String acceptHeader) {
		RESTCLIENT_LOGGER.info("REST-ASSURED: Sending a PATCH request to " + url);
		Response postResponse = given().config(config).relaxedHTTPSValidation().body(body).contentType(contentHeader)
				.accept(acceptHeader).log().all().when().patch(url).then().log().all().extract().response();
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response from the request is: " + postResponse.asString());
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response Time is: " + postResponse.time());
		return postResponse;
	}

	public static String getCookie(String url, Object body, String contentHeader, String acceptHeader,
			String cookieName) {
		RESTCLIENT_LOGGER.info("REST-ASSURED: Sending a GET request to " + url);
		Response postResponse = given().config(config).relaxedHTTPSValidation().body(body).contentType(contentHeader)
				.accept(acceptHeader).log().all().when().post(url).then().log().all().extract().response();
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response from the request is: " + postResponse.asString());
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response Time is: " + postResponse.time());
		return postResponse.getCookie(cookieName);
	}

	public static Response postRequestWithCookie(String url, Object body, String contentHeader, String acceptHeader,
			String cookieName, String cookieValue) {
		RESTCLIENT_LOGGER.info("REST-ASSURED: Sending a POST request to " + url);
		Response postResponse = given().config(config).relaxedHTTPSValidation().body(body).contentType(contentHeader)
				.cookie(cookieName, cookieValue).accept(acceptHeader).log().all().when().post(url).then().log().all()
				.extract().response();
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response from the request is: " + postResponse.asString());
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response Time is: " + postResponse.time());
		return postResponse;
	}
	
	public static Response postRequestWithCookieAndHeader(String url, Object body, String contentHeader, String acceptHeader,
			String cookieName, String cookieValue, String authHeaderName, String authHeaderValue) {
		RESTCLIENT_LOGGER.info("REST-ASSURED: Sending a POST request to " + url);
		Response postResponse = given().config(config).relaxedHTTPSValidation().header(authHeaderName, authHeaderValue).body(body).contentType(contentHeader)
				.cookie(cookieName, cookieValue).accept(acceptHeader).log().all().when().post(url).then().log().all()
				.extract().response();
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response from the request is: " + postResponse.asString());
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response Time is: " + postResponse.time());
		return postResponse;
	}	

	public static Response getRequestWithCookie(String url, String contentHeader, String acceptHeader, String urls,
			String cookieName, String cookieValue) {
		RESTCLIENT_LOGGER.info("REST-ASSURED: Sending a GET request to " + url);
		Response getResponse = given().config(config).relaxedHTTPSValidation().cookie(cookieName, cookieValue).log()
				.all().when().get(url + "?" + urls).then().log().all().extract().response();
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response from the request is: " + getResponse.asString());
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response Time is: " + getResponse.time());
		return getResponse;
	}

	public static Response patchRequestWithCookie(String url, String body, String contentHeader, String acceptHeader,
			String cookieName, String cookieValue) {
		RESTCLIENT_LOGGER.info("REST-ASSURED: Sending a PATCH request to " + url);
		Response postResponse = given().config(config).relaxedHTTPSValidation().body(body).contentType(contentHeader)
				.cookie(cookieName, cookieValue).accept(acceptHeader).log().all().when().patch(url).then().log().all()
				.extract().response();
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response from the request is: " + postResponse.asString());
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response Time is: " + postResponse.time());
		return postResponse;
	}

	public static Response getRequestWithCookie(String url, String contentHeader, String acceptHeader,
			String cookieName, String cookieValue) {
		RESTCLIENT_LOGGER.info("REST-ASSURED: Sending a GET request to " + url);
		Response getResponse = given().config(config).relaxedHTTPSValidation().cookie(cookieName, cookieValue).log()
				.all().when().get(url).then().log().all().extract().response();
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response from the request is: " + getResponse.asString());
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response Time is: " + getResponse.time());
		return getResponse;
	}

	public static Response postRequestWithCookie(String url, String contentHeader, String acceptHeader,
			String cookieName, String cookieValue) {
		RESTCLIENT_LOGGER.info("REST-ASSURED: Sending a POST request to " + url);
		Response postResponse = given().config(config).relaxedHTTPSValidation().contentType(contentHeader)
				.cookie(cookieName, cookieValue).accept(acceptHeader).log().all().when().post(url).then().log().all()
				.extract().response();
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response from the request is: " + postResponse.asString());
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response Time is: " + postResponse.time());
		return postResponse;
	}

	public static Response putRequestWithParm(String url, HashMap<String, String> body, String contentHeader,
			String acceptHeader, String cookieName, String cookieValue) {
		RESTCLIENT_LOGGER.info("REST-ASSURED: Sending a PUT request to " + url);
		Response postResponse = given().config(config).relaxedHTTPSValidation().pathParams(body)
				.contentType(contentHeader).cookie(cookieName, cookieValue).accept(acceptHeader).log().all().when()
				.put(url).then().log().all().extract().response();
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response from the request is: " + postResponse.asString());
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response Time is: " + postResponse.time());
		return postResponse;
	}
	
	public static Response patchRequestWithParm(String url, HashMap<String, String> body, String contentHeader,
			String acceptHeader, String cookieName, String cookieValue) {
		RESTCLIENT_LOGGER.info("REST-ASSURED: Sending a PATCH request to " + url);
		Response postResponse = given().config(config).relaxedHTTPSValidation().pathParams(body)
				.contentType(contentHeader).cookie(cookieName, cookieValue).accept(acceptHeader).log().all().when()
				.patch(url).then().log().all().extract().response();
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response from the request is: " + postResponse.asString());
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response Time is: " + postResponse.time());
		return postResponse;
	}
	public static Response putWithPathParamsBodyAndCookie(String url, HashMap<String, String> pathParams, String body, String contentHeader,
			String acceptHeader, String cookieName, String cookieValue) {
		RESTCLIENT_LOGGER.info("REST-ASSURED: Sending a PUT request to " + url);
		Response postResponse = given().config(config).relaxedHTTPSValidation().pathParams(pathParams).body(body)
				.contentType(contentHeader).cookie(cookieName, cookieValue).accept(acceptHeader).log().all().when()
				.put(url).then().log().all().extract().response();
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response from the request is: " + postResponse.asString());
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response Time is: " + postResponse.time());
		return postResponse;
	}
	public static Response postWithPathParamsBodyAndCookie(String url, HashMap<String, String> pathParams, String body, String contentHeader,
			String acceptHeader, String cookieName, String cookieValue) {
		RESTCLIENT_LOGGER.info("REST-ASSURED: Sending a PUT request to " + url);
		Response postResponse = given().config(config).relaxedHTTPSValidation().pathParams(pathParams).body(body)
				.contentType(contentHeader).cookie(cookieName, cookieValue).accept(acceptHeader).log().all().when()
				.post(url).then().log().all().extract().response();
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response from the request is: " + postResponse.asString());
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response Time is: " + postResponse.time());
		return postResponse;
	}
	
	public static Response patchWithPathParamsBodyAndCookie(String url, HashMap<String, String> pathParams, String body, String contentHeader,
			String acceptHeader, String cookieName, String cookieValue) {
		RESTCLIENT_LOGGER.info("REST-ASSURED: Sending a PUT request to " + url);
		Response postResponse = given().config(config).relaxedHTTPSValidation().pathParams(pathParams).body(body)
				.contentType(contentHeader).cookie(cookieName, cookieValue).accept(acceptHeader).log().all().when()
				.patch(url).then().log().all().extract().response();
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response from the request is: " + postResponse.asString());
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response Time is: " + postResponse.time());
		return postResponse;
	}
	public static Response putRequestWithQueryParm(String url, HashMap<String, String> body, String contentHeader, String acceptHeader,String cookieName,String cookieValue) {
		RESTCLIENT_LOGGER.info("REST-ASSURED: Sending a PUT request to " + url);
		Response postResponse = given().config(config).relaxedHTTPSValidation().queryParams(body).contentType(contentHeader).cookie(cookieName, cookieValue)
				.accept(acceptHeader).log().all().when().put(url).then().log().all().extract().response();
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response from the request is: " + postResponse.asString());
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response Time is: " + postResponse.time());
		return postResponse;
	}


	public static Response putRequestWithCookie(String url, Object body, String contentHeader, String acceptHeader,
			String cookieName, String cookieValue) {
		RESTCLIENT_LOGGER.info("REST-ASSURED: Sending a PUT request to " + url);
		Response putResponse = given().config(config).relaxedHTTPSValidation().body(body).contentType(contentHeader)
				.cookie(cookieName, cookieValue).accept(acceptHeader).log().all().when().put(url).then().log().all()
				.extract().response();
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response from the request is: " + putResponse.asString());
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response Time is: " + putResponse.time());
		return putResponse;
	}

	// Added by Admin Test Team
	public static Response getRequestWithCookieAndPathParm(String url, HashMap<String, String> body,
			String contentHeader, String acceptHeader, String cookieName, String cookieValue) {
		RESTCLIENT_LOGGER.info("REST-ASSURED: Sending a GET request to " + url);
		Response getResponse = given().config(config).relaxedHTTPSValidation().pathParams(body)
				.cookie(cookieName, cookieValue).log().all().when().get(url).then().log().all().extract().response();
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response from the request is: " + getResponse.asString());
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response Time is: " + getResponse.time());
		return getResponse;
	}

	public static Response getRequestWithCookieAndQueryParm(String url, HashMap<String, String> body,
			String contentHeader, String acceptHeader, String cookieName, String cookieValue) {
		RESTCLIENT_LOGGER.info("REST-ASSURED: Sending a GET request to " + url);
		Response getResponse = given().config(config).relaxedHTTPSValidation().queryParams(body)
				.cookie(cookieName, cookieValue).log().all().when().get(url).then().log().all().extract().response();
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response from the request is: " + getResponse.asString());
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response Time is: " + getResponse.time());
		return getResponse;
	}
	
	public static Response deleteRequestWithCookieAndPathParm(String url,HashMap<String, String> body, String contentHeader, String acceptHeader,String cookieName,String cookieValue) {
        RESTCLIENT_LOGGER.info("REST-ASSURED: Sending a DELETE request to " + url);
        Response deleteResponse= given().config(config).relaxedHTTPSValidation().pathParams(body).cookie(cookieName, cookieValue)
                    .log().all().when().delete(url).then().log().all().extract().response();
        RESTCLIENT_LOGGER.info("REST-ASSURED: The response from the request is: " + deleteResponse.asString());
        RESTCLIENT_LOGGER.info("REST-ASSURED: The response Time is: " + deleteResponse.time());
        return deleteResponse;
    }
	public static Response postRequestWithCookieAndOnlyPathParm(String url, HashMap<String, String> body,
			String contentHeader, String acceptHeader, String cookieName, String cookieValue) {
		RESTCLIENT_LOGGER.info("REST-ASSURED: Sending a POST request to " + url);
		Response getResponse = given().config(config).relaxedHTTPSValidation().pathParams(body)
				.cookie(cookieName, cookieValue).log().all().when().post(url).then().log().all().extract().response();
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response from the request is: " + getResponse.asString());
		RESTCLIENT_LOGGER.info("REST-ASSURED: The response Time is: " + getResponse.time());
		return getResponse;
	}
}
