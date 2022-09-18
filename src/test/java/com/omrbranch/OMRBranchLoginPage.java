package com.omrbranch;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;
import com.pojo.AddUserAddress_Input_Pojo;
import com.pojo.AddUserAddress_Output_Pojo;
import com.pojo.ChangeProfilePic_Output_pojo;
import com.pojo.DeleteUserAddress_Input_Pojo;
import com.pojo.DeleteUserAddress_Output_Pojo;
import com.pojo.GetUserAddress_Output_Pojo;
import com.pojo.Login_Output_Pojo;
import com.pojo.UpdateUserAddress_Input_Pojo;
import com.pojo.UpdateUserAddress_Output_Pojo;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class OMRBranchLoginPage extends BaseClass {

	String logtoken;
	String address_id;

	@Test(priority = 6)
	public void changeProfilePic() {
		// 1. Header
		List<Header> header = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "multipart/form-data");

		header.add(h1);
		header.add(h2);

		Headers headers = new Headers(header);
		addHeaders(headers);
		// 2. formdata
formData("profile_picture", new File(System.getProperty("user.dir")+"\\Images\\SankarPic.jpg"));

//3. Method type
Response response = requestType("POST", "https://omrbranch.com/api/changeProfilePic");
int statusCode = getStatusCode(response);
System.out.println(statusCode);
Assert.assertEquals(statusCode, 200, "Verify Status Code");
ChangeProfilePic_Output_pojo changeProfilePic_Output_pojo = response.as(ChangeProfilePic_Output_pojo.class);
String message = changeProfilePic_Output_pojo.getMessage();
Assert.assertEquals(message, "Profile updated Successfully", "Verify profile updated successfully");

	}

	@Test(priority = 5)
	public void getUserAddresses() {
		// 1. Header
		List<Header> header = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);

		header.add(h1);
		header.add(h2);

		Headers headers = new Headers(header);
		addHeaders(headers);

		// Method type
		Response requestType = requestType("GET", "https://omrbranch.com/api/getUserAddress");
		int statusCode = getStatusCode(requestType);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "Verify Status Code");
		GetUserAddress_Output_Pojo getUserAddress_Output_Pojo = requestType.as(GetUserAddress_Output_Pojo.class);
		String message = getUserAddress_Output_Pojo.getMessage();
		Assert.assertEquals(message, "OK", "Verify OK");
	}

	@Test(priority = 4)
	public void deleteUserAddress() {
		// 1. Add Headers
		List<Header> header = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");

		header.add(h1);
		header.add(h2);
		header.add(h3);

		Headers headers = new Headers(header);
		addHeaders(headers);

		// 2. Pass the payload
		DeleteUserAddress_Input_Pojo deleteUserAddress_Input_Pojo = new DeleteUserAddress_Input_Pojo(address_id);
		addBody(deleteUserAddress_Input_Pojo);

		// 3. Method Type
		Response requestType = requestType("DELETE", "https://omrbranch.com/api/deleteAddress");
		int statusCode = getStatusCode(requestType);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "Verify Status Code");

		DeleteUserAddress_Output_Pojo deleteUserAddress_Output_Pojo = requestType
				.as(DeleteUserAddress_Output_Pojo.class);
		String message = deleteUserAddress_Output_Pojo.getMessage();
		Assert.assertEquals(message, "Address deleted successfully", "Verify delete msg");
	}

	@Test(priority = 3)
	public void updateUserAddress() {

		// 1. Add Headers
		List<Header> header = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");
		header.add(h1);
		header.add(h2);
		header.add(h3);

		Headers headers = new Headers(header);
		addHeaders(headers);

		// 2. Pass the payload
		UpdateUserAddress_Input_Pojo updateUserAddress_Input_Pojo = new UpdateUserAddress_Input_Pojo(address_id,
				"Eganthan", "V", "7299476012", "CholanNagar", 6, 5, 3, "600109", "Thirumullaivoyal", "Home");
		addBody(updateUserAddress_Input_Pojo);

		// 3. Method type
		Response requestType = requestType("PUT", "https://omrbranch.com/api/updateUserAddress");
		int statusCode = getStatusCode(requestType);
		System.out.println(statusCode);

		Assert.assertEquals(statusCode, 200, "Verify Status Code");

		UpdateUserAddress_Output_Pojo as = requestType.as(UpdateUserAddress_Output_Pojo.class);
		String message = as.getMessage();
		Assert.assertEquals(message, "Address updated successfully", "Verify Address updated successfully");

	}

	@Test(priority = 2)
	public void addUserAddress() {
		// 1. Add Headers
		List<Header> header = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");
		header.add(h1);
		header.add(h2);
		header.add(h3);

		Headers headers = new Headers(header);
		addHeaders(headers);

		// 2. Pass the payload
		AddUserAddress_Input_Pojo address_Input_Pojo = new AddUserAddress_Input_Pojo("Sankar", "Eganthan", "7299476012",
				"CholanNagar", 6, 5, 3, "600109", "Thirumullaivoyal", "Home");

		addBody(address_Input_Pojo);

		// 3. Method Type
		Response response2 = requestType("POST", "https://omrbranch.com/api/addUserAddress");
		int statusCode = getStatusCode(response2);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "Verify Status Code");

		AddUserAddress_Output_Pojo addUserAddress_Output_Pojo = response2.as(AddUserAddress_Output_Pojo.class);
		String message = addUserAddress_Output_Pojo.getMessage();
		Assert.assertEquals(message, "Address added successfully", "Verify Address added successfully");
		int id = addUserAddress_Output_Pojo.getAddress_id();
		address_id = String.valueOf(id);

	}

	@Test(priority = 1)
	public void login() {
		// 1. Header
		addHeader("accept", "application/json");

		// 2. Auth
		basicAuth("sankareganthan@yahoo.co.in", "APITesting1$");

		// 3. Method Type
		Response response = requestType("POST", "https://omrbranch.com/api/postmanBasicAuthLogin");

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(200, statusCode, "Verify");
		Login_Output_Pojo login_Output_Pojo = response.as(Login_Output_Pojo.class);
		String first_name = login_Output_Pojo.getData().getFirst_name();
		System.out.println(first_name);
		Assert.assertEquals(first_name, "Sankar");

		logtoken = login_Output_Pojo.getData().getLogtoken();

	}
}
